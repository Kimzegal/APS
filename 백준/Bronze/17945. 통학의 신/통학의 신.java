import java.util.*;

/*
 * 두번째 아이디어 : 덜 돌린다
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int A = read();
        int B = read();
        for(int i = -1000; i < 1001; i++){
            if(i*i + 2*A*i + B == 0){
                System.out.print(i+" ");
            }
        }
    }
    public static int read() throws Exception{
        int n = 0;
        boolean isNumber = false;
        boolean isNegative = false;
        while(true){
            int cur = System.in.read();
            if(cur == '-'){
                isNegative = true;
            }
            else if(cur <= 32){
                if(isNumber){
                    if(isNegative) return ~n+1;
                    else return n;
                }
            }
            else{
                isNumber = true;
                n = (n<<3) + (n<<1) + (cur&15);
            }
        }
    }
}