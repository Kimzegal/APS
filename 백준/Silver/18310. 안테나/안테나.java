import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] house = new int[100001];
		
		for(int i=0; i<N; i++) {
			house[Integer.parseInt(st.nextToken())] += 1;
		}
		
		int cnt = (N-1)/2;
		for(int i=1; i<=100000; i++) {
			if(house[i]!=0) {
				cnt-=house[i];
				if(cnt<0) {System.out.println(i); break;}
			}
		}
	}
}