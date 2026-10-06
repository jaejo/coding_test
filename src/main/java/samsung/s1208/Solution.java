package samsung.s1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            // 덤프 횟수(1<= N <= 1000)
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[100];
            int answer = 1;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int left = 0;
            int right = arr.length - 1;
            for (int i = 0; i < N; i++) {
                // 평탄화된 경우
                if (arr[right] - arr[left] <= 1) break;

                arr[right] -= 1;
                arr[left] += 1;
                Arrays.sort(arr);
            }
            answer = arr[right] - arr[left];

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
