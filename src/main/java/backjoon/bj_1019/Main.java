package backjoon.bj_1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //0 ~ 9 넣을 배열
    static long[] count = new long[10];

    public static void calc(long x, long digit) {
        while (x > 0) {
            count[(int) (x % 10)] += digit;
            x /= 10;
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // 초기 세팅
        long start = 1;   // 시작 페이지
        long end = n;    // 끝 페이지
        long digit = 1;  // 자릿수 - 1 -> 10 -> 100 -> 1000 -> ...

        int num = 1;
        while (start <= end) {

            // end를 9로 끝나도록 조정
            while (end % 10 != 9 && start <= end) {
                calc(end, digit);
                end--;
            }
            System.out.println("end:" + end);
            System.out.println(num + "회차(뒤): " + Arrays.toString(count));

            // start를 0으로 끝나도록 조정
            while (start % 10 != 0 && start <= end) {
                calc(start, digit);
                start++;
            }

            System.out.println("start:" + start);
            System.out.println(num + "회차(앞): " + Arrays.toString(count));

            if (start > end) break;

            long common_cnt = (end / 10 - start / 10 + 1);

            for (int i = 0; i < 10; i++) {
                count[i] += common_cnt * digit;
            }

            System.out.println("공통 부분:" + common_cnt);
            System.out.println(num + "회차(공통): " + Arrays.toString(count));

            start /= 10;
            end /= 10;
            // 자릿수 증가
            digit *= 10;
            num++;
            System.out.println("=====================");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(count[i]).append(" ");
        }

        // 출력
        System.out.println(sb);
    }
}
