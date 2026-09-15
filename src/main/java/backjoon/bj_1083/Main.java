package backjoon.bj_1083;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list = new ArrayList<>();

    // start와 end의 범위 내에서 가장 큰 값의 인덱스를 구함
    static int findMaxIndex(int start, int end) {
        // 나올수 있는 값보다 더 작은 값으로 max를 세팅
        int max = -1;
        int index = start;

        // 최대값을 가진 인덱스를 찾음
        for(int i = start; i <= end; i++) {
            if(max < list.get(i)) {
                max = list.get(i);
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 배열의 크기
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 교환 횟수
        int s = Integer.parseInt(br.readLine());

        /*
         * 핵심 로직: 정렬한 결과가 사전순으로 가장 뒷서는 것을 출력해야 한다.
         * 1. 내림차순으로 정렬하되, 앞의 인덱스부터 가장 높은 값을 넣어준다.
         * 2. 반복문을 통해 0번 인덱스부터 남은 교환 횟수로 범위를 설정 후 정렬을 진행한다.
         * EX) 19 20 17 18 15 16 13 14 11 12
         * start: 정렬할 인덱스, end: 동작 횟수로 최댓값을 확인할 수 있는 인덱스
         * start = 0 end = start + s(동작 횟수=5) => 범위 탐색
         * 최댓값 = 20, 최댓값의 인덱스 = 1
         * [20] [19 17 18 15 16] 13 14 11 12
         * list이므로 최댓값 인덱스(1)를 제거 후 정렬할 인덱스에 제거한 값을 넣어준다 => 연속된 두 개의 원소를 교환할 수 있기 때문이다.
         * 이동 횟수(s) -= 최댓값을 가진 인덱스(maxValueIndex) - 정렬할 인덱스(start)
         * */
        for(int start=0; start<n; start++) {
            // 최대 인덱스를 벗어나질 않게 설정
            int end = Math.min(n -1, start + s);
            // 범위에 해당하는 최댓값을 가진 인덱스를 찾음
            int maxValueIndex = findMaxIndex(start, end);

            // 시작점과 최댓값의 인덱스가 같은 경우 수행하지 않음
            if (maxValueIndex != start) {
                int maxValue = list.remove(maxValueIndex);
                // 시작 인덱스에 최대값을 넣어줌
                list.add(start, maxValue);
                // 교환 횟수에서 이동 횟수를 뺀다
                s -= maxValueIndex - start;
                if (s == 0) break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num: list) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());
    }
}
