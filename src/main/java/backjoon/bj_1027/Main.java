package backjoon.bj_1027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //전체 빌딩의 수
    static int n;
    //빌딩들의 높이를 담는 배열
    static int[] building;

    // 두 점의 기울기 = (y2 - y1) / (x2 - x1)
    public static double calc_slope(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        //편의상 1부터 시작하기 위해
        building = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        //가장 많이 빌딩이 보이는 수
        int maxCount = 0;

        for(int i = 1; i<=n; i++) {
            int count = 0;

            // Double.Max_Value는 0에 가까운 양수
            double currentMaxSlope = -Double.MAX_VALUE;
            double currentMinSlope = Double.MAX_VALUE;

            // 오른쪽을 봤을 때
            for (int j= i+1; j<= n; j++) {
                double current_slope = calc_slope(i, building[i], j, building[j]);

                // 현재 i 빌딩과 j 빌딩의 기울기를 기존의 최고 기울기와 비교함.
                // 최고 기울기를 넘지 못하면 볼 수 없음
                if(current_slope > currentMaxSlope) {
                    count++;
                    currentMaxSlope = current_slope;
                }
            }
            // 왼쪽을 봤을 때
            for (int j = i-1; j > 0; j--) {
                double current_slope = calc_slope(i, building[i], j, building[j]);

                /*
                현재 i빌딩과 j 빌딩의 기울기를 기존의 최저 기울기와 비교함
                기울기가 음수이므로 더 작아야 확인 가능
                 */
                if(current_slope < currentMinSlope) {
                    count++;
                    currentMinSlope = current_slope;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
