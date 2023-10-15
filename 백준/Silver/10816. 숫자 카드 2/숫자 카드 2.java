import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[20_000_001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cards[Integer.parseInt(st.nextToken())+10_000_000]++;
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M; i++) {
			sb.append(cards[Integer.parseInt(st.nextToken())+10_000_000]).append(' ');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}