import java.util.*;

class Solution {
    // 방향 벡터 선언
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    // 마크 배열 : 해당 열에 '얼마나 석유를 캘수 있는지' 체크하기 위한 배열
    public static int[] mark;
    

    public int solution(int[][] land) {
        int answer = 0;
        // mark를 land의 열과 같은 크기의 배열을 선언
        mark = new int[land[0].length];
        // 전체적으로 bfs를 먼저 돌리기 위한 방문 배열 선언
        boolean[][] visited = new boolean[land.length][land[0].length];
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                // bfs 메서드
                bfs(visited, land, i, j);
            }
        }
        // bfs가 끝나면 mark엔 열별 최고 매장량이 들어가 있따.
        for(int i = 0; i < mark.length; i++){
            // answer은 그중 최고값
            answer = Math.max(mark[i], answer);
        }
        
        return answer;
    }
    
    
    public static void bfs(boolean[][] visited, int[][] land, int r, int c){
        // 방문한 적 있거나, 석유가 없다면 메서드를 종료한다.
        if(visited[r][c] || land[r][c] == 0) return;
        // 반환할 석유 매장량을 선언한다. 석유가 있음을 전제로 하므로 1부터 시작.
        int total = 1;
        // 이번 bfs에서 덩어리가 차지하는 열의 정보를 담을 Set 선언
        Set<Integer> set = new HashSet<>();
        // 좌표 정보를 담을 큐를 선언
        Queue<int[]> queue = new LinkedList<>();
        // 시작점을 방문처리하고 큐에 넣는다.
        int[] start = new int[] {r, c};
        visited[r][c] = true;
        // 열 값을 set에 넣는다
        set.add(c);
        queue.offer(start);
        
        while(!queue.isEmpty()){
            // 큐에서 좌표를 꺼낸다.
            int[] cur = queue.poll();
            // 방향 벡터에 따라서 dfs 진행
            for(int i = 0; i < 4; i++){
                // check : 배열의 범위를 벗어난다면 다음 반복문으로
                if(!check(cur[0]+dr[i], cur[1]+dc[i], land)) continue;
                // 방문한 적이 없고, 매장량이 0이 아니라면
                if(!visited[cur[0]+dr[i]][cur[1]+dc[i]] && land[cur[0]+dr[i]][cur[1]+dc[i]] != 0){
                    // 총 매장량을 더해주고, 방문처리를 해준 뒤 큐에 넣어준다. 열값도 set에 넣는다.
                    total++;
                    set.add(cur[1]+dc[i]);
                    visited[cur[0]+dr[i]][cur[1]+dc[i]] = true;
                    int[] now = new int[] {cur[0]+dr[i], cur[1]+dc[i]};
                    queue.offer(now);
                    
                    // mark에 덩어리 번호를 표시해준다.
                }
            }
        }
        Iterator<Integer> iter = set.iterator(); // set을 Iterator 안에 담기
		while(iter.hasNext()) { // iterator에 다음 값이 있다면
			mark[iter.next()] += total;
		}
        
    }
    
    // 배열 범위를 나갔는지 안나갔는지 체크하는 함수
    public static boolean check(int r, int c, int[][] land){
        return (r>= 0 && r < land.length && c>=0 && c <land[0].length);
    }
}