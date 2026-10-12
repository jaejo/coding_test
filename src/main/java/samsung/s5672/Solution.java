package samsung.s5672;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] arr = new char[N];
            StringBuilder answer = new StringBuilder();

            for (int j = 0; j < N; j++) {
                arr[j] = br.readLine().charAt(0);
            }

            int left = 0;
            int right = N - 1;

            while (left <= right) {
                boolean left_pick = false;
                int l = left;
                int r = right;
                while (l <= r) {
                    if (arr[l] < arr[r]) {
                        left_pick = true;
                        break;
                    } else if (arr[l] > arr[r]) {
                        break;
                    }
                    l++;
                    r--;
                }
                if (left_pick) {
                    answer.append(arr[left]);
                    left++;
                } else {
                    answer.append(arr[right]);
                    right--;
                }
            }
            sb.append("#").append(i).append(' ').append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
