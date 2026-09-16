package samsung.s5607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int MOD = 1234567891;
    // 팩토리얼 전처리를 위한 배열
    static long[] fact = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        fact[0] = 1;
        // 1~1000000 팩토리얼 전처리
        for (int i = 1; i <= 1000000; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // nCr = n! / (r! * (n - r)!)
            long child = fact[N];
            long parent = (fact[R] * fact[N-R]) % MOD;

            // A * B^{P-2} MOD P
            long ans = (child * power(parent, MOD - 2)) % MOD;

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.print(sb);
    }

    // 분할 정복 거듭제곱
    private static long power(long base, long exp) {
        long res = 1;
        base %= MOD;

        while (exp > 0) {
            // 지수 가장 마지막이 1인 경우
            // 누적 나머지 곱 = 나머지 * 밑
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            // 비트 오른쪽으로 이동
            exp >>= 1;
        }
        return res;
    }
}