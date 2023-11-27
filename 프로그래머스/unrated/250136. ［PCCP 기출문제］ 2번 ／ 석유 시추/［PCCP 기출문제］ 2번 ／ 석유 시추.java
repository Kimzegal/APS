import java.util.*;

class Solution {
    // 방향 벡터 선언
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int[][] mark;
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int mark_num = 1;
    

    public int solution(int[][] land) {
        int answer = 0;
        mark = new int[land.length][land[0].length];
        
        // bfs를 먼저 돌려서, 각 칸에서 얼마를 얻을 수 있는지 표시
        
        boolean[][] visited = new boolean[land.length][land[0].length];
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                bfs(visited, land, i, j);
            }
        }
        
        for(int i = 0; i < land[0].length; i++){
            boolean[] marked = new boolean[mark_num];
            int sum = 0;
            for(int j = 0; j < land.length; j++){
                if(mark[j][i] != 0 && !marked[mark[j][i]-1]){
                    marked[mark[j][i]-1] = true;
                    sum += map.get(mark[j][i]);
                }
            }
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
    
    public static void bfs(boolean[][] visited, int[][] land, int r, int c){
        // 방문한 적 있거나, 석유가 없다면 메서드를 종료합니다.
        if(visited[r][c] || land[r][c] == 0) return;
        // 반환할 석유 매장량을 선언합니다.
        int total = 1;
        // 좌표 정보를 담을 큐를 선언합니다.
        Queue<int[]> queue = new LinkedList<>();
        // 시작점을 방문처리하고 큐에 넣습니다.
        int[] start = new int[] {r, c};
        visited[r][c] = true;
        mark[r][c] = mark_num;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            // 큐에서 좌표를 꺼냅니다.
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                if(!check(cur[0]+dr[i], cur[1]+dc[i], land)) continue;
                if(!visited[cur[0]+dr[i]][cur[1]+dc[i]] && land[cur[0]+dr[i]][cur[1]+dc[i]] != 0){
                    total++;
                    visited[cur[0]+dr[i]][cur[1]+dc[i]] = true;
                    mark[cur[0]+dr[i]][cur[1]+dc[i]] = mark_num;
                    int[] now = new int[] {cur[0]+dr[i], cur[1]+dc[i]};
                    queue.offer(now);
                }
            }
        }
        
        map.put(mark_num++, total);
        
    }
    
    public static boolean check(int r, int c, int[][] land){
        return (r>= 0 && r < land.length && c>=0 && c <land[0].length);
    }
}