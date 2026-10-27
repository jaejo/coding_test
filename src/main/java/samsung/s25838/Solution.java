package samsung.s25838;

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
            String str = br.readLine();
            char[] arr = new char[N];

            int peek = 0;
            for (int i = 0; i < N; i++) {
                char c = str.charAt(i);
                arr[peek++] = c;

                if (peek >= 3 && arr[peek - 3] == 'f' && arr[peek - 2] == 'o' && arr[peek - 1] == 'x') {
                    peek -= 3;
                }
            }
            sb.append(peek).append("\n");
        }
        System.out.println(sb);
    }
}