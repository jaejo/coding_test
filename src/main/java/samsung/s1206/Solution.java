package samsung.s1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < arr.length - 2; i++) {
                int maxValue = Math.max(Math.max(arr[i-2], arr[i-1]), Math.max(arr[i+1], arr[i+2]));
                if (arr[i] <= maxValue) {
                    continue;
                }
                answer += arr[i] - maxValue;
            }
            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
