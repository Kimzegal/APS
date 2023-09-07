import java.util.*;


// 기다린 시간이 최소가 되어야 하므로,
// 

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = Integer.MAX_VALUE;
        ans = new int[k];
        for(int i = 0 ; i <= k; i++){
            list.add(new PriorityQueue<>((int[] o1,int[] o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            else return o1[0]-o2[0];}));
        }
        
        
        for(int i = 0; i < reqs.length; i++){
            int types = reqs[i][2];
            list.get(types).offer(new int[] {reqs[i][0], reqs[i][1]});
        }
        
        
        for(int i = 1; i <= n-k+1; i++){
            answer = Math.min(consult(k, n, 1, i, i),answer);    
        }
        
        
        return answer;
    }
    
    public static List<PriorityQueue<int[]>> list = new ArrayList<>();
    public static int[] ans;
    public static StringBuilder sb = new StringBuilder();
    
    public static int consult(int k, int n, int types, int num, int total){
        if(k < types){
      
            return 0;
        }
        
        if(total > n){
            return 10000000;
        }
        
        else{
            PriorityQueue<Integer> consulter = new PriorityQueue<>();
            PriorityQueue<int[]> tmpQueue = new PriorityQueue<>((int[] o1,int[] o2)->{
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                else return o1[0]-o2[0];});
            
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < num; i++) consulter.add(0);
        
            while(!list.get(types).isEmpty()){
                int[] curStudent = list.get(types).poll();

                int availConsult = consulter.poll();
                int waitingTime = availConsult-curStudent[0];
                if(waitingTime < 0) waitingTime = 0;
                sum += waitingTime;
                consulter.offer(Math.max(availConsult,curStudent[0])+curStudent[1]);
                tmpQueue.offer(curStudent);
            }
            
            ans[types-1] = sum;
            list.set(types, tmpQueue);
            
            for(int i = 1; i <= n-k+1; i++){
                int now = sum+consult(k,n,types+1,i, total+i);
                min = Math.min(min, now);
            }
            
            return min;
        }
    }
}

// 멘토 n명
// 1~k 상담유형
// 멘토는 자기가 담당하는 유형의 상담만 가능
// 한명만 상담가능
