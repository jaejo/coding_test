package backjoon.bj_15311;

/*
 * 시간 복잡도: O(1) = O(요구량)
 * 아래에 내용을 고정으로 모든 조건이 해결 가능하다.
 * - 1. 약 매대에 약봉지를 최대 2000개를 올려둘 수 있다.
 * - 2. 최대 1,000,000(N)의 부분합을 해결할 수 있다.
 * 1000개를 가진 약봉지 1000개
 * 1개를 가진 약봉지 999개
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        StringBuilder sb = new StringBuilder();

        // 총 봉지 수: 1999개 (1: 999개 + 1000: 1000개)
        sb.append(1999).append("\n");

        // 1개를 가진 봉지 999개 (1~999까지의 모든 수 커버)
        for (int i = 0; i < 999; i++) {
            sb.append(1).append(" ");
        }

        // 1000개를 가진 봉지 1000개 (1000단위로 100만까지 커버)
        for (int i = 0; i < 1000; i++) {
            sb.append(1000).append(" ");
        }

        System.out.println(sb.toString());
    }
}
