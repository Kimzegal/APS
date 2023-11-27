import java.util.*;

class Solution {
    // 방향 벡터 선언
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    // 마크 배열 : 해당 석유가 '몇번째 석유 덩어리인지' 체크하기 위한 배열
    public static int[][] mark;
    // 마크 넘버 : 1부터 시작(0번은 석유가 아닌 곳)하여, 매 석유 덩어리를 찾을 때마다 늘어남
    public static int mark_num = 1;
    // map : 덩어리 번호와 매장량을 key-value로 저장하기 위함
    public static Map<Integer, Integer> map = new HashMap<>();
    

    public int solution(int[][] land) {
        int answer = 0;
        // mark를 land와 같은 크기의 배열을 선언
        mark = new int[land.length][land[0].length];
        // 전체적으로 bfs를 먼저 돌리기 위한 방문 배열 선언
        boolean[][] visited = new boolean[land.length][land[0].length];
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                // bfs 메서드
                bfs(visited, land, i, j);
            }
        }
        // bfs가 끝나면 mark엔 각 덩어리 번호가 입력되어 있다.
        // 따라서, 다시 열따라 반복문을 돌려서 최고 매장량을 찾아야 한다.
        for(int i = 0; i < land[0].length; i++){
            // 덩어리의 갯수와 동일한 방문배열 선언 : "그 덩어리를 이번 열에서 이미 시추했는지"
            boolean[] marked = new boolean[mark_num+1]; // +1해줘서 코드를 깔끔하게.
            // 이번 열에서의 시추량
            int sum = 0;
            for(int j = 0; j < land.length; j++){
                // 석유 덩어리가 매장되어 있고, 아직 그 덩어리를 방문한 적 없다면
                if(mark[j][i] != 0 && !marked[mark[j][i]]){
                    // 방문체크하고, 그 덩어리에 해당하는 매장량을 sum에 더해준다.
                    marked[mark[j][i]] = true;
                    sum += map.get(mark[j][i]);
                }
            }
            // answer은 그중 최고값
            answer = Math.max(sum, answer);
        }
        
        return answer;
    }
    
    
    public static void bfs(boolean[][] visited, int[][] land, int r, int c){
        // 방문한 적 있거나, 석유가 없다면 메서드를 종료한다.
        if(visited[r][c] || land[r][c] == 0) return;
        // 반환할 석유 매장량을 선언한다. 석유가 있음을 전제로 하므로 1부터 시작.
        int total = 1;
        // 좌표 정보를 담을 큐를 선언
        Queue<int[]> queue = new LinkedList<>();
        // 시작점을 방문처리하고 큐에 넣는다.
        int[] start = new int[] {r, c};
        visited[r][c] = true;
        mark[r][c] = mark_num;
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
                    // 총 매장량을 더해주고, 방문처리를 해준 뒤 큐에 넣어준다.
                    total++;
                    visited[cur[0]+dr[i]][cur[1]+dc[i]] = true;
                    int[] now = new int[] {cur[0]+dr[i], cur[1]+dc[i]};
                    queue.offer(now);
                    
                    // mark에 덩어리 번호를 표시해준다.
                    mark[cur[0]+dr[i]][cur[1]+dc[i]] = mark_num;
                }
            }
        }
        // 모든게 끝났으면 이번 덩어리에 해당하는 매장량을 map에 넣어주고, 다음 덩어리를 체크한다.
        map.put(mark_num++, total);
        
    }
    
    // 배열 범위를 나갔는지 안나갔는지 체크하는 함수
    public static boolean check(int r, int c, int[][] land){
        return (r>= 0 && r < land.length && c>=0 && c <land[0].length);
    }
}