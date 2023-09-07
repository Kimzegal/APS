import java.util.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int[][] visited = new int[onboard.length][51];
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2)->{
            return o1[2]-o2[2];
        });
        
        for(int i = 0; i < onboard.length; i++){
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }
        queue.offer(new int[] {0,temperature+10,0});
        visited[0][temperature+10] = 0;
        int answer = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0] == onboard.length-1){
                answer = cur[2];
                break;
            }
            
            if(cur[0]+1 < onboard.length && cur[1]+1 <51){
                if((onboard[cur[0]+1] == 1 && cur[1]+1 <=t2+10 && cur[1]+1 >=t1+10)||onboard[cur[0]+1] == 0){
                    int elect = temperature+10 > cur[1] ? 0 : a;
                    if(visited[cur[0]+1][cur[1]+1] > cur[2]+elect){
                        visited[cur[0]+1][cur[1]+1] = cur[2]+elect;
                        queue.offer(new int[] {cur[0]+1, cur[1]+1, cur[2]+elect});    
                    }          
                }
            }
            
            if(cur[0]+1 < onboard.length && cur[1]-1 >=0){
                if((onboard[cur[0]+1] == 1 && cur[1]-1 <=t2+10 && cur[1]-1 >=t1+10)||onboard[cur[0]+1] == 0){
                    int elect = temperature+10 < cur[1] ? 0 : a;
                    if(visited[cur[0]+1][cur[1]-1] > cur[2]+elect){

                        visited[cur[0]+1][cur[1]-1] = cur[2]+elect;
                        queue.offer(new int[] {cur[0]+1, cur[1]-1, cur[2]+elect});    
                    }
                }
            }
            if(cur[0]+1 < onboard.length){
                if((onboard[cur[0]+1] == 1 && cur[1] <=t2+10 && cur[1] >=t1+10)||onboard[cur[0]+1] == 0){
                    int elect = temperature+10 == cur[1] ? 0 : b;
                    if(visited[cur[0]+1][cur[1]] > cur[2]+elect){
                        visited[cur[0]+1][cur[1]] = cur[2]+elect;
                        queue.offer(new int[] {cur[0]+1, cur[1], cur[2]+elect});    
                    }
                }
            }
            
        }
        
    
        

        return answer;
    }
    
}