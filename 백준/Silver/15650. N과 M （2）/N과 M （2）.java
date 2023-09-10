import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[] answer;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		
		combination(0,0);
		
		System.out.println(sb.toString());

	}
	
	public static void combination(int depth, int start) {
		if(depth == M) {
			for(int num : answer) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
		
		else {
			for(int i = start; i < N; i++) {
				answer[depth] = i+1;
				combination(depth+1, i+1);
			}
		}
	}
}