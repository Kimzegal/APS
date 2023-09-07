import java.util.*;


// 기다린 시간이 최소가 된다.
// 일찍 예약한 사람은 무조건 일찍 상담한다는 조건이 붙어있다.
// 일찍 나온 사람이 더 짧게 기다릴 수 있는 멘토에게 상담을 받아야 한다. 간단하게 증명해보자.
// 상담이 끝난시간이 a,b(a<b)인 멘토가 있고, 상담 시작시간이 n,m(n<m)인 상담자가 있다.
// 기본적으로 기다린 시간은 a-n, b-m이므로 어떻게 받든 (a+b)-(n+m)으로 같다.
// 그러나 만약 기다린 시간이 음수면 0으로 변한다. 즉, 음수값이 클수록 손해가 발생한다.
// 예를 들어 a<b이므로, a-n이 음수라면 b-n은 절대값이 이보다 더 큰 음수이므로 더 큰 손해가 발생한다.
// 이러한 손해를 최소화하기 위해서 빨리 상담받는 사람이 먼저 끝난 멘토한테 가야한다.


class Solution {
    public static List<ArrayList<int[]>> list = new ArrayList<>(); // 각 유형별로 참가자 정보를 담을 리스트
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = Integer.MAX_VALUE; //최소값을 비교해야 하므로 초기값은 매우 크게
        for(int i = 0 ; i <= k; i++){
            list.add(new ArrayList<>());
        }
        
        
        for(int i = 0; i < reqs.length; i++){
            int types = reqs[i][2];
            list.get(types).add(new int[] {reqs[i][0], reqs[i][1]}); //리스트에 [시각, 상담시간]의 배열을 담음
        }
        
        // 각 상담 유형별로, 상담사는 최소 1명, 최대 n-k+1명을 넘을 수 없음
        for(int i = 1; i <= n-k+1; i++){
            answer = Math.min(consult(k, n, 1, i, i),answer);    
        }
        
        
        return answer;
    }
    
   
    // k(유형수), n(상담사수), types(현재유형), num(배정상담사수), total(총 상담사수)
    public static int consult(int k, int n, int types, int num, int total){
        // 기저조건 : 0 반환
        if(k < types){
      
            return 0;
        }
        // 상담사수를 초과하면 불가능한 값이므로, 큰 수를 반환해서 min 조건에 걸리지 않게 한다.
        if(total > n){
            return 10000000;
        }
        
        else{
            PriorityQueue<Integer> consulter = new PriorityQueue<>();
            // 더 일찍 끝난 멘토를 먼저 꺼내기 위해 우선순위 큐 선언
            
            int sum = 0; // 이번 유형만에서의 총 기다린 시간
            int min = Integer.MAX_VALUE; // 이번 유형까지의 누적 기다린시간
            
            for(int i = 0; i < num; i++) consulter.add(0); // 멘토를 큐에 투입
        
            for(int[] curStudent : list.get(types)){

                int availConsult = consulter.poll();
                // 멘토 상담 종료시간 - 참가자 상담 시작시간 = 기다린 시간
                int waitingTime = availConsult-curStudent[0];
                // 기다리지 않은 경우 처리
                if(waitingTime < 0) waitingTime = 0;
                sum += waitingTime;
                // 이번 상담사의 상담 종료시간을 갱신하고 다시 큐에 넣는다.
                consulter.offer(Math.max(availConsult,curStudent[0])+curStudent[1]);
            }
            
            for(int i = 1; i <= n-k+1; i++){
                // 이후 회차의 상담사수를 변하면서 백트래킹하여, 값을 누적해서 더해준 값을 min과 비교한다.
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
