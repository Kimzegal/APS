import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static int[] answer;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		visited = new boolean[N];
		
		permutation(0);
		
		System.out.println(sb.toString());

	}
	
	public static void permutation(int depth) {
		if(depth == M) {
			for(int num : answer) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
		}
		
		else {
			for(int i = 0; i < N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					answer[depth] = i+1;
					permutation(depth+1);
					visited[i] = false;
				}
			}
		}
	}
}