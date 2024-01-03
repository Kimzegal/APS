import java.util.*;

/*
 * 첫 아이디어 : 좌우의 갯수로 판단해봅시다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        boolean[] cntX = new boolean[1000001];
        boolean[] cntY = new boolean[1000001];
        List<Integer> pointX = new ArrayList<>();
        List<Integer> pointY = new ArrayList<>();
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            int x = read();
            if(!cntX[x]) {
                cntX[x] = true;
                pointX.add(x);
            }
            int y = read();
            if(!cntY[y]){
                cntY[y] = true;
                pointY.add(y);
            }
            arr[i] = new int[] {x,y};
        }

        int[] ans = new int[N];
        Arrays.fill(ans, Integer.MAX_VALUE);

        PriorityQueue<Integer> pq;
        for(int i = 0; i < pointX.size(); i++){
            for(int j = 0; j < pointY.size(); j++){
                pq = new PriorityQueue<>();
                for(int k = 0; k < arr.length; k++){
                    pq.add(Math.abs(pointX.get(i)-arr[k][0]) + Math.abs(pointY.get(j)-arr[k][1]));
                }
                int cur = 0;
                for(int k = 0; k < N; k++){
                    cur += pq.poll();
                    ans[k] = Math.min(cur, ans[k]);
                }
            }
        }

        sb.append(0).append(" ");
        for(int i = 1; i < N; i++){
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static int read() throws Exception{
        int n = 0;
        boolean isNumber = false;
        while(true){
            int cur = System.in.read();
            if(cur <= 32){
                if(isNumber){
                    return n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}