/*
 * 첫번째 아이디어 : 냅다 반복문을 돌린다.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        /*
        배열 선언 및 값 대입
         */
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            arr[i] = read();
        }

        /*
        sum 변수를 만들고, 배열의 시작점을 늘려가며 완탐
         */
        int sum = 0; // 반복회차 값
        int max = 0; // 최대값(답)
        int dif = 100; // 100과의 차이
        for(int i = 0; i < 10; i++){
            sum += arr[i];
            if(Math.abs(100-sum) <= dif){
                dif = Math.min(dif, Math.abs(100-sum));
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
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