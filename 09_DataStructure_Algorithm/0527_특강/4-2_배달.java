// https://school.programmers.co.kr/learn/courses/30/lessons/12978?language=java

// 강의 코드
import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 최단 거리 배열
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 500001);

        // 그래프 생성
        List<Node>[] graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 그래프 저장
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        // 다익스트라 시작
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            int node = current.to;
            int dis = current.cost;

            // 이미 더 짧은 경로가 있다면 패스
            if (dist[node] < dis) {
                continue;
            }

            // 연결된 노드 탐색
            for (Node next : graph[node]) {

                int nextNode = next.to;
                int nextDis = next.cost;

                int d = dis + nextDis;
                
                // 더 짧은 거리 발견 시 갱신
                if (dist[nextNode] > d) {
                    dist[nextNode] = d;
                    pq.offer(new Node(nextNode, d));
                }
            }
        }

        // K 이하 거리 마을 개수 세기
        for (int d : dist) {
            if (d <= K) {
                answer++;
            }
        }

        return answer;
    }
}