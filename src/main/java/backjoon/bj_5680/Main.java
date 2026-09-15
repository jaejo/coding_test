package backjoon.bj_5680;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static class Node {

        // 자식 노드를 담을 map
        HashMap<Character, Node> child;

        //해당 노드가 마지막인지 저장
        boolean endOfWord;

        public Node() {
            this.child = new HashMap<>();
            this.endOfWord = false;
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        // 삽입
        public void insert(String str) {
            Node node = this.root;

            for (int i = 0; i < str.length(); i++) {
                // String to char
                char c = str.charAt(i);
                // 노드의 자식 노드가 존재하지 않을 경우 자식 노드를 생성해서 넣음
                node.child.putIfAbsent(c, new Node());
                // 자식 노드로 이동
                node = node.child.get(c);
            }
            // 마지막 노드는 마지막임을 명시
            node.endOfWord = true;
        }

        // 탐색
        int search(String str) {
            Node node = this.root;
            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (node.child.containsKey(c)) {
                    if (i == 0) cnt++;
                    else {
                        // 여러 선택지가 있을 경우 or 현재까지 친 글자가 완성된 단어일 경우 추가 조회가 필요한 경우 입력해야 한다.
                        if (node.child.size() > 1 || node.endOfWord) {
                            cnt++;
                        }
                    }
                    node = node.child.get(c);
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null && !input.trim().isEmpty()) {
            try {
                int n = Integer.parseInt(input);
                int total_sum = 0;
                String[] arr = new String[n];

                Trie trie = new Trie();

                for (int i = 0; i < n; i++) {
                    String str = br.readLine();
                    arr[i] = str;
                    trie.insert(str);
                }

                for (String word : arr) {
                    total_sum += trie.search(word);
                }
                String result = String.format("%.2f", (double) total_sum / n);
                sb.append(result).append("\n");
            } catch (NumberFormatException e) {
                break;
            }
        }
        System.out.println(sb);
    }
}
