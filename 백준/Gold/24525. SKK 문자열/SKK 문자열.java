import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int [300001];
        //-200000~100000;
        int[] prefixSK = new int [str.length()+1];
        int[] prefix = new int [str.length()+1];
        int max = -1;
        for(int i=1; i<=str.length(); i++) {
        	prefix[i] = prefix[i-1];
        	prefixSK[i] = prefixSK[i-1];
        	if(str.charAt(i-1)=='S') {
        		prefix[i]-=2;
        		prefixSK[i]++;
        	}
        	else if(str.charAt(i-1)=='K') {
        		prefix[i]+=1;
        		prefixSK[i]++;
        	}
        	if(prefix[i]==0&&prefixSK[i]!=0){
        		max=i;
        		continue;
        	}
        	
        	int hash = prefix[i]+200000;
        	if(cnt[hash]==0) cnt[hash]= i;
        	else if(prefixSK[i] - prefixSK[cnt[hash]]!=0) {
        		int length = i-(cnt[hash]);
        		if(max<length) max=length;
        	}
        }
        
        System.out.println(max);
        
    }
}