package backjoon.bj_1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x;
            int max = (int) Math.sqrt(distance);

            if (max * max == distance) {
                sb.append(2 * max - 1).append("\n");
            } else if (distance <= max * max + max) {
                sb.append(2 * max).append("\n");
            } else {
                sb.append(2 * max + 1).append("\n");
            }
        }

        System.out.print(sb);
    }
}