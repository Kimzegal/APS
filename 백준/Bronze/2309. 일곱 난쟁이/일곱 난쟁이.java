import java.util.*;

/*
 * 첫 아이디어 : 좌우의 갯수로 판단해봅시다.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = read();
            sum += arr[i];
        }

        Arrays.sort(arr);

        int a = -1;
        int b = -1;

        label:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) continue;
                if (sum - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                    break label;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == a || i == b) continue;
            System.out.println(arr[i]);
        }
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