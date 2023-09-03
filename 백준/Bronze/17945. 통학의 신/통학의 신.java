import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		for(int i = -1000; i <= 1000; i++) {
			int cur = i*i + 2*i*A + B;
			if(cur == 0){
				System.out.print(i+" ");
			}
		}
	}
}