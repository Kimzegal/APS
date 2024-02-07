import java.util.*;
import java.io.*;

/*
 * 첫번째 아이디어 : 숫자의 범위가 매우 크므로, 4개의 점을 일일이 찾을 수는 없다.
 * 기본적으로 X좌표(B)를 기준으로 오름차순 정렬하되, 같은 X좌표에선 Y좌표(A)를 기준으로 오름차순 정렬한다.
 * 그 후, N번의 반복문을 돌려 그 좌표값을 왼쪽 아래로 둔 채로 3번의 이진탐색으로 나머지 점의 존재여부를 찾는다.
 * 시간 복잡도는 NlogN 이다.
 */
public class Main {
    public static List<Integer> primes = new ArrayList<>();
    public static int N,A,B;
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        N = read();
        A = read();
        B = read();

        arr = new int[N][2];

        for(int i = 0; i < N; i++){
            arr[i][0] = read();
            arr[i][1] = read();
        }
        // 람다식을 이용하여 위에서 말한 오름차순 정렬 구현
        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        
        int ans = 0;
        
        for(int i = 0; i < N; i++){
            boolean rightbot = binarySearch(arr[i][0]+A, arr[i][1]);
            boolean lefttop = binarySearch(arr[i][0], arr[i][1]+B);
            boolean righttop = binarySearch(arr[i][0]+A, arr[i][1]+B);
            
            if(rightbot && lefttop && righttop) ans++;
        }

        System.out.println(ans);
    }
    
    public static boolean binarySearch(int x, int y){
        int s = 0;
        int e = arr.length - 1;
        boolean ans = false;
        while(s<=e){
            int mid = (s+e)/2; // 중간값
            if(arr[mid][0] < x) {
                s = mid + 1; 
            }
            else if(arr[mid][0] > x){
                e = mid - 1;
            }
            else{
                if(arr[mid][1] < y){
                    s = mid + 1;
                }
                else if(arr[mid][1] > y){
                    e = mid - 1;
                }
                else{
                    ans = true;
                    break;
                }
            }
        }
        return ans;
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