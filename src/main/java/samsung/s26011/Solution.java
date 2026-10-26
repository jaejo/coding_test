package samsung.s26011;

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            long answer = 0;

            // 1 <= a, b, c , d <= N
            // a + b = X, c + d = Y, X - Y = K
            // -> 2 <= Y <= 2N
            // -> 2 - K <= Y <= 2N - K
            // -> Math.max(2, 2 - K) <= Y <= Math.min(2N, 2N - K)
            long minY = Math.max(2, 2 - K);
            long maxY = Math.min(2 * N, 2 * N - K);

            for (long Y = minY; Y <= maxY; Y++) {
                // a + b = X, c + d = Y
                // X = Y + K
                long X = Y + K;

                // a + b = S(X or Y)
                // b = S - a
                // => 1 <= S - a <= N
                // a <= S - 1
                // S - N <= a
                // => S - N <= a <= S - 1
                // Math.max(1, S - N) <= a <= Math.min(N, S - 1)
                // case 1: 올라가는 지점
                // S <= N + 1(중앙값)
                // S - N <= 1
                // a의 최솟값: 1
                // S - 1 <= N
                // a의 최대값: S - 1
                // a의 총 개수: (S - 1) - 1 + 1 = S - 1
                // case 2: 내려가는 지점
                // S > N + 1
                // S - N > 1
                // a의 최솟값: S - N
                // S - 1 > N
                // a의 최댓값: N
                // a의 총 개수: N - (S - N) + 1 = 2N + 1 - S
                long caseY = (Y <= N + 1) ? (Y - 1) : (2 * N + 1 - Y);
                long caseX = (X <= N + 1) ? (X - 1) : (2 * N + 1 - X);

                // X, Y 모두 같은 상황에서 나올 수 있는 것으로 곱해서 누적합
                answer += caseX * caseY;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}