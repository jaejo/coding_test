package samsung.s1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            String word = br.readLine();
            String str = br.readLine();

            int answer = 0;
            answer = str.length() - str.replace(word, "").length();

            sb.append('#').append(t).append(' ').append(answer / word.length()).append('\n');
        }
        System.out.println(sb);
    }
}
