package samsung.s1209;

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

            int[][] arr = new int[100][100];
            int answer = 0;

            // 가로
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int temp = 0;
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    temp += arr[i][j];
                }
                answer = Math.max(answer, temp);
            }

            // 세로
            for (int i = 0; i < 100; i++) {
                int temp = 0;
                for (int j = 0; j < 100; j++) {
                    temp += arr[j][i];
                }
                answer = Math.max(answer, temp);
            }

            // 오른쪽 방향 내림 대각선
            int rightTemp = 0;
            // 왼쪾 방향 내림 대각선
            int leftTemp = 0;
            // 대각선
            for (int i = 0; i < 100; i++) {
                rightTemp += arr[i][i];
                leftTemp += arr[i][99 - i];
            }
            answer = Math.max(answer, Math.max(rightTemp, leftTemp));

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
