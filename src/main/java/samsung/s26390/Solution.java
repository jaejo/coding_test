package samsung.s26390;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] degree = new int[N + 1];
            long answer = 0;
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                degree[a]++;
                degree[b]++;
            }
            for (int i = 1; i <= N; i++) {
                if (degree[i] > 2) {
                    answer += degree[i] - 2;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
