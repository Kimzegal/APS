import java.util.*;
import java.io.*;

/*
    누적합을 배열을 구한뒤에, 앞에서부터 차근차근 세어나가보자.
 */
public class Main {
    public static int N,M;
    public static int[] arr;
    public static int ans;
    public static int max;
    public static void main(String[] args) throws Exception {
        N = read(); // 구슬의 수
        M = read(); // 그룹의 수

        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = read();
            max = Math.max(arr[i], max);
        }

        binarySearch();

    }

    public static void binarySearch(){
        int s = max;
        int e = 30000;

       StringBuilder sb = new StringBuilder();
        List<Integer> groups = new ArrayList<>();

        while(s<=e) {
            List<Integer> list = new ArrayList<>();
            int mid = (s + e) / 2;
            int group = 0; // 그룹당 구슬의 갯수
            int cur = 0; // 반복문 내에서 현재 구슬까지의 합
            int cnt = M; // 남은 그룹 갯수

            for(int i = 0; i < N; i++){
                if(cur + arr[i] <= mid){ // 이번구슬까지 더했을때도 최대값과 같거나 작다면
                    group++; //하나 더해주고
                    cur += arr[i]; // 구슬의 합을 더해준다.
                    if(cur == mid){ // 만약 딱 떨어진다면??
                        list.add(group);  // group만큼을 sb에 넣어주고
                        group = 0; // 초기화
                        cnt--; // 남은 그룹갯수는 줄어들고
                        cur = 0; // 현재 총합은 0이 된다.
                    }
                }
                else{ // 이번구슬을 더하면 최댓값이 넘어든다면 그게 그룹이된다.
                    list.add(group);
                    group = 1;
                    cnt--;
                    cur = arr[i]; // 현재 총합은 현재 구슬이 된다.
                }
            }

            if(cur != 0) {
                list.add(group);
                cnt--; // 남은 구슬이 있다면, 당연히 카운트는 줄어들어야 한다. (그게 마지막 그룹이됨)
            }

            if(cnt >= 0) { // 만약 그룹이 딱 M개만큼 있거나, 그보다 더 적다고 가정하자.
                ans = mid; // 답은 mid가 되고
                groups = list; // 답을 저장해 둔다.
                e = mid - 1; // 더작은 최소값으로
            }

            else{
                s = mid + 1;
            }
        }

        int now = groups.size();

        for(int group : groups){
            while(group > 1 && now < M){
                sb.append(1).append(" ");
                now++;
                group--;
            }
            sb.append(group).append(" ");
        }
        System.out.println(ans);
        System.out.println(sb);
    }


    public static int read() throws Exception{
        int n = 0;
        int cur;
        boolean isNumber = false;
        boolean isNegative = false;
        while(true){
            cur = System.in.read();
            if(cur == '-'){
                isNegative = true;
            }
            else if(cur <= 32){
                if(isNumber){
                    return isNegative ? -n : n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }

}