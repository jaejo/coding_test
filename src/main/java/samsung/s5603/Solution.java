package samsung.s5603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int total = 0;
            int answer = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                total += arr[i];
            }

            int avg = total / N;
            for (int num : arr) {
                answer += num > avg ? num - avg : 0;
            }
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
