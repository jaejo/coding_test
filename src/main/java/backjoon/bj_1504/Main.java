package backjoon.bj_1504;

import java.io.*;
import java.util.*;

// 우선순위 큐에서 간선 비용(weight)을 기준으로 오름차순 정렬하기 위해 Comparable 구현
class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static final int INF = 200_000_000;
    static int n, m;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 간선 정보
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 그래프 설정
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 입력 - 꼭 거쳐야 하는 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1번 정점, v1, v2에서 시작하는 최단 거리 배열을 각각 구함
        int[] originalDistance = dijkstra(1);
        int[] v1Distance = dijkstra(v1);
        int[] v2Distance = dijkstra(v2);

        // 경로 1: 1 -> v1 -> v2 -> N
        long v1Path = (long) originalDistance[v1] + v1Distance[v2] + v2Distance[n];
        // 경로 2: 1 -> v2 -> v1 -> N
        long v2Path = (long) originalDistance[v2] + v2Distance[v1] + v1Distance[n];

        // 두 경로 중 최솟값 선택
        long result = Math.min(v1Path, v2Path);

        // 경로가 없는 경우(INF 이상) -1 출력, 아니면 결과 출력
        if (result >= INF) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }

    static int[] dijkstra(int start) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.end;
            int dist = current.weight;

            if (distance[now] < dist) continue;

            for (Node next : graph.get(now)) {
                int cost = dist + next.weight;

                if (cost < distance[next.end]) {
                    distance[next.end] = cost;
                    pq.offer(new Node(next.end, cost));
                }
            }
        }
        return distance;
    }
}