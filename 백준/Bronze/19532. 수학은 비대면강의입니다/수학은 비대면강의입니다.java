	import java.io.*;
	import java.util.*;
	
	public class Main {
	
		public static void main(String[] args) throws IOException {
			
			int a = read();
			int b = read();
			int c = read();
			int d = read();
			int e = read();
			int f = read();
			
			label:
			for(int i=-999; i<=999; i++) {
				for(int j=-999; j<=999; j++) {
					if((a*i + b*j == c) && (d*i + e*j == f)) {
						System.out.println(i+" "+j);
                        return;
					}
				}
			}
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