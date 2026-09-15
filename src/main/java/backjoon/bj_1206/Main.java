package backjoon.bj_1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean checkAvgs(int num, int[] avgs) {
        // 평균을 담은 배열의 길이
        int len = avgs.length;
        // 배열의 모든 평균이 인원 수(num)를 만족하는가?
        boolean isValid = true;

        /*
        평균 = 총점 / 인원 수
        평균 * 인원 수 <= 1000 * 총점 < (평균 + 1) * 인원 수
        1. 평균 + 1인 이유 : 소수점 셋째 자리에서 자른 값(버림)
        - Ex) 6.666 <= 실제 평균 < 6.667 => 6.6660 ~ 6.6669
        2. 1000 * 총점인 이유 : 배열에 넣을 때 String -> int
        - Ex) 0.500 -> avgs[0] = 500
       */
        for (int i = 0; i < len; i++) {
            // 하한선
            int L = avgs[i] * num;
            // 상한선
            int R = (avgs[i] + 1) * num;

            // 1000 * 총점이므로 1000의 배수 단위로 커진다.
            int target = ((L + 999) / 1000) * 1000;

            // 상한선을 넘으면 거짓
            if (target >= R) {
                isValid = false;
                break;
            }

            // 상한선은 문항의 총점(10 * 1000) * 문항의 수를 넘으면 거짓
            if (target > 10000 * num) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 평균을 넣을 배열
        int[] avgs = new int[n];

        // 부동소수점 오차를 방지하기 위해 정수 연산으로 변환
        // 입력 값이 모두 소수점 셋째 자리까지 주어지므로, .을 제거시 1000을 곱한 정수가 됨
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String temp = input.replace(".", "");
            avgs[i] = Integer.parseInt(temp);
        }

        // 사람의 수는 1부터 1000까지 가능
        // 1000으로 소수점 3자리를 모두 표현 가능하기 때문
        // 가장 먼저 값이 나오면 그 값을 출력(가장 적은 인원)
        for (int num = 1; num <= 1000; num++) {
            if (checkAvgs(num, avgs)) {
                System.out.println(num);
                return;
            }
        }
    }
}
