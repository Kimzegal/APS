import java.util.Arrays;

/*
 * 동전의 종류와 갯수는 무한하기 때문에, 가치 합의 특정값이 될 수 있는 동전묶음은 무수히 많다.
 * 범위 역시 100000 밖에 되지 않기 때문에, 해당 가치(인덱스)의 코인 갯수를 나타내는 배열을 선언하고,
 * 반복문을 통해 이 배열을 모두 채웠을 때 k+1번쨰 배열의 값을 출력하면 된다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        // 가치가 같은 동전이 여러개 주어질 수 있으므로, 이를 판별하여 반복횟수를 줄임
        boolean[] visited = new boolean[100001];
        int[] coin = new int[n];
        // 가치가 같은 동전이 있다면, 배열의 끝부분을 표현하는 배열 선언
        int idx = 0;

        // coin 배열에 입력값 넣기
        for(int i = 0; i < n; i++){
            int tmp = read();
            if(!visited[tmp]){
                visited[tmp] = true;
                coin[idx++] = tmp;
            }
        }

        int[] dp = new int[k+1];

        for(int i = 1; i <= k; i++){
            dp[i] = 10001;
        }

        // dp 수행을 모든 가치값에서 수행
        for(int i = 0; i < k; i++) {
            // 값 비교 및 최신화를 모든 동전 묶음에서 실행
            for(int j = 0; j < idx; j++){
                // 배열의 범위를 초과하지 않는선에서, dp가 바뀌지 않았거나 동전갯수가 현재가 더작은경우
                if(i + coin[j] <= k && dp[i] + 1 < dp[i+coin[j]]){
                    dp[i+coin[j]] = dp[i] + 1;
                }
            }
        }

        if(dp[k] == 10001) System.out.println(-1);
        else System.out.println(dp[k]);

    }
// 빠른 입출력
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

/* 테스트케이스 오류발생시
    1. 배열의 범위를 초과하는지 잘 확인할 것
    2. -1 을 출력해야하는 조건을 잘 검사할 것
    3. dp 배열을 너무 큰수로 하면 오버플로우
    4. dp 배열을 초기화 안하면 처음 부분 제외하면 0인지 아닌지 확인할 것
 */
