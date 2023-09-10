import java.util.StringTokenizer;
import java.io.*;

public class Main {
	
	public static int N, M;
	public static int[] answer;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		
		combination(0);
		
		bw.write(sb.toString());
		bw.close();

	}
	
	public static void combination(int depth) {
		if(depth == M) {
			for(int num : answer) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
		
		else {
			for(int i = 0; i < N; i++) {
				answer[depth] = i+1;
				combination(depth+1);
			}
		}
	}
}