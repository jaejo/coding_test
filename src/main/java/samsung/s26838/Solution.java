package samsung.s26838;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N; // 정점의 개수
    static int M; // 간선의 수
    static int K; // 색상의 종류 수
    static int[] color;
    static ArrayList<Integer>[] graph;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            color = new int[N + 1];
            StringTokenizer stN = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                // 비트마스킹(0 ~ K - 1)을 위해 색상 번호를 0부터 시작하도록 -1 처리
                color[i] = Integer.parseInt(stN.nextToken()) - 1;
            }

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 무방향 그래프
            for (int i = 0; i < M; i++) {
                StringTokenizer stM = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stM.nextToken());
                int b = Integer.parseInt(stM.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            // dp[now][mask] : 현재 now 정점에 있고 사용한 색상 비트가 mask일 때
            //                 앞으로 더 확장할 수 있는 유효 경로의 개수
            dp = new long[N + 1][1 << K];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dp[i], -1);
            }

            long answer = 0;
            for (int i = 1; i <= N; i++) {
                // 정점의 색상 비트 1로 수정
                int startMask = 1 << color[i];
                answer += dfs(i, startMask);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static long dfs(int now, int mask) {
        // 이미 계산되었다면 저장된 값을 즉시 반환
        if (dp[now][mask] != -1) return dp[now][mask];

        long count = 0;
        for (int next : graph[now]) {
            // 다음 정점의 색상을 나타내는 비트
            int nextMask = 1 << color[next];
            // 이미 경로상에서 사용한 색상이라면 스킵
            if ((mask & nextMask) != 0) continue;
            count += 1 + dfs(next, mask | nextMask);
        }

        return dp[now][mask] = count;
    }
}
