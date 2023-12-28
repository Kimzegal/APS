/*
 * 정렬을 하지 않는 방법
 */
public class Main {
    public static void main(String[] args) throws Exception{

        int N = read();
        int[] cnt = new int[100001];
        int sum = 0; // 누적값

        for(int i = 0; i < N; i++){
            cnt[read()]++;
        }

        for(int i = 0; i < 100001; i++){
            if(cnt[i] == 0) continue; // 해당하는 수가 없으면 스킵

            sum += cnt[i]; // 갯수만큼 더해준다

            if(sum >= (N+1)/2) { // 5개면 3번째, 6개면 3~4 ... 따라서 +1후 /2

                System.out.println(i);
                return;
            }
        }
    }

    public static int read() throws Exception{
        int n = 0; // 반환 값
        boolean isNumber = false; // 띄어쓰기가 2개 이상 있는 경우 대비
        while(true){
            int input = System.in.read();
            if(input <= 32) {
                if(isNumber) return n; // 숫자 끝
            }
            else{
                isNumber = true;
                n = (n << 3) + (n << 1) + (input&15); // 자릿수 올리고 input 더하기
            }
        }
    }
}