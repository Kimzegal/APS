/*
 * 첫번째 아이디어 : 냅다 반복문을 돌린다.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        /*
         입력받기
         */
        int A = read();
        int B = read();
        int C = read();
        int N = read();

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                for(int k = 0; k <= N; k++){
                    if(A*i + B*j + C*k == N) {
                        System.out.println(1);
                        return;
                    }
                }

            }
        }

        System.out.println(0);
    }
    public static int read() throws Exception{
        int n = 0;
        int cur;
        boolean isNumber = false;
        while(true){
            cur = System.in.read();
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