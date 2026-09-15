package backjoon.bj_11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    // 간선 정보를 넣을 리스트 배열
    static List<Integer>[] list;
    // 노드의 해당하는 부모를 저장하기 위한 배열
    static int[][] parent;
    // 트리의 깊이를 저장하는 배열
    static int[] depth;

    // node: 현재 노드
    // p: 부모 노드
    // d: 깊이
    static void dfs(int node, int p, int d) {
        depth[node] = d;
        parent[node][0] = p;

        for(int child : list[node]) {
            // 자식 노드가 부모가 될 경우(역행) 방지
            if (child != p) {
                // 깊이가 증가하여 탐색한다.
                dfs(child, node, d + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드의 수
        n = Integer.parseInt(br.readLine());
        // 트리를 담을 리스트 배열 선언
        list = new ArrayList[n + 1];
        depth = new int[n + 1];
        parent = new int[n + 1][17];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        // 정점에 대한 간선 정보는 n - 1
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // root 노드인 1부터 탐색
        // 1은 부모가 0이라 가정
        // 깊이는 0부터 시작한다.
        dfs(1, 0, 0);

        for (int j = 1; j <= 16; j++) {
            for (int i = 1; i < n + 1; i++) {
                parent[i][j] = parent[parent[i][j-1]][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();

        // 최소 조상 노드를 구하는 쌍의 개수
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            // 공통 조상을 찾기 위한 노드 쌍
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            /*
             * 1. 깊이가 다른 경우 깊이가 낮은 노드에 맞춘다.
             * 2. 부모가 다를 경우 둘다 올라간다.
             */
            // 계산 편의상 a가 항상 더 깊은 노드가 되도록 스왑하는 로직
            if (depth[a] < depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            // a와 b의 깊이를 동일하게 맞추는 로직
            for (int j = 16; j >= 0; j--) {
                if (depth[a] - depth[b] >= (1 << j)) {
                    a = parent[a][j];
                }
            }

            // 깊이를 맞췄는데, 두 노드가 같으면 노드의 공통 조상을 출력
            if (a == b) {
                sb.append(a).append("\n");
                continue;
            }

            // 부모가 다를 경우, 최상단부터 내려오면서 공통 조상 바로 아래까지 점프하는 로직
            for (int j = 16; j >= 0; j--) {
                if (parent[a][j] != parent[b][j]) {
                    a = parent[a][j];
                    b = parent[b][j];
                }
            }
            sb.append(parent[a][0]).append("\n");
        }
        // 정답 출력
        System.out.println(sb.toString().trim());
    }
}
