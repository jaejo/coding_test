package samsung.s27006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            char[][] arr = new char[N][N];
            int answer = 0;

            for (int i = 0; i < N; i++) {
                String str = br.readLine().trim();
                for (int j =0; j < N; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            for (int B = 0; B < N; B++) {
                boolean isSynchronized = true;

                for (int i=0; i < N; i++) {
                    for (int j=i+1; j < N; j++) {
                        // i + B or j + B가 초과했을 경우
                        // x - N는 x % N과 같다.
                        char cell1 = arr[i][(j + B) % N];
                        char cell2 = arr[j][(i + B) % N];

                        if (cell1 != cell2) {
                            isSynchronized = false;
                            break;
                        }
                    }
                    if (!isSynchronized) {
                        break;
                    }
                }
                if (isSynchronized) {
                    answer += N;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
