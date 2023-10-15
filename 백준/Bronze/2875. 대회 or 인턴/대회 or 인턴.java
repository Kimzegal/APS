import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		int N = read();
		int M = read();
		int K = read();
		int max = 0;
		
		for(int i=0; i<=K; i++) {
			max = Math.max(Math.min((N-i)/2, M-(K-i)),max);
		}

		System.out.println(max);
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