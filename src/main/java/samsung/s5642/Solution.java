package samsung.s5642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int currentSum = first;
            int maxSum = first;

            for (int i = 1; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                currentSum = Math.max(num, currentSum + num);
                maxSum = Math.max(maxSum, currentSum);
            }

            sb.append('#').append(t).append(' ').append(maxSum).append('\n');
        }

        System.out.print(sb);
    }
}
