package samsung.s5678;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            int answer = (str.isEmpty()) ? 0 : 1;

            for (int i = 0; i < str.length(); i++) {
                for (int j = i+1; j < str.length(); j++) {
                    if (checkPalindrome(str, i, j)) {
                        answer = Math.max(answer, j - i + 1);
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }
        System.out.println(sb);
    }

    static boolean checkPalindrome(String str, int left, int right) {
        while(left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
