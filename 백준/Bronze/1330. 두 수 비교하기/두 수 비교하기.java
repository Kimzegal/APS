import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        byte[] arr = new byte[25]; // 바이트 배열 설정
        Arrays.fill(arr, (byte)-1);
        System.in.read(arr); // 데이터 읽기

        int A = read(arr);
        int B = read(arr);

        if(A>B) System.out.println(">");
        else if(A<B) System.out.println("<");
        else System.out.println("==");
    }

    public static int pointer = 0;
    // 포인터를 설정
    public static int read(byte[] arr) throws Exception{
        int n = 0;
        int cur;
        boolean isNumber = false;
        boolean isNegative = false;
        while(true){
            cur = arr[pointer++];
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