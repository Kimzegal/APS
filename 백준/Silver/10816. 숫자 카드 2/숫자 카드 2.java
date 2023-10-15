import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[]args)throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = read();
		int[] cards = new int[20_000_001];
		for(int i = 0; i < N; i++) {
			cards[read()+10_000_000]++;
		}

		int M = read();
		for(int i = 0 ; i < M; i++) {
			sb.append(cards[read()+10_000_000]).append(' ');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
        static int read() throws IOException{
    	int n = 0;
    	boolean isNumber = false;
    	boolean isNegative = false;
    	while(true) {
    		int input = System.in.read();
    		if(input<=32) {
    			if(!isNumber) continue;
    			else return isNegative?n*(-1):n;
    		}
    		
    		else if(input=='-') isNegative = true;
    		else {
    			isNumber = true;
    			n = (n<<3)+(n<<1)+(input&15);
    		}
    	}
    }
}