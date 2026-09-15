package backjoon.bj_1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배열의 크기
        int n = Integer.parseInt(br.readLine());
        // 찾을 인덱스
        int k = Integer.parseInt(br.readLine());

        /*
           end = n * n이 아닌 이유
           일차원 배열을 오름차순으로 정렬했을 때 k번째 숫자가 k보다 큰 숫자가 올 수 없음
           Ex) 4 * 4 2차원 배열 A를 만들고 일차원 배열 B를 만들어 오름차순으로 정렬했다면?
           [1, 2, 2, 3, 3, 3, 4, 4 ......], k = 4
           B[4] = 3 => k번째 숫자는 절대로 K를 넘을 수 없음
         */
        int start = 1, end = k;
        int ans = 0;

        // 이분 탐색
        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                /*
                  a[i][j] = i * j
                  i * j <= mid
                  j <= mid / i
                  Math.min(mid / i, n) -> 열의 개수는 최대 n으로 고정되어 있음
                */
                cnt += Math.min(mid / i, n);
            }
            if (cnt >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
