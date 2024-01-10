/*
 * 첫번째 아이디어 : 냅다 반복문을 돌린다.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        /*
         입력받기
         */
        int a = read();
        int b = read();
        int c = read();
        int d = read();
        int e = read();
        int f = read();

        for(int i = -999; i <= 999; i++){
            for(int j = -999; j <= 999; j++){
                if(a*i + b*j == c && d*i + e*j == f){
                    System.out.print(i+" "+j);
                    return;
                }
            }
        }
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
                    int now = isNegative ? -n : n;
                    return now;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}