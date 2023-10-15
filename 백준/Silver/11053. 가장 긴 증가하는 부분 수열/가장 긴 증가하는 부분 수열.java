import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[]args) throws IOException {
    	int N = read();
    	int[] arr = new int[N+1];
    	int[] dp = new int[N+1];
    	int max = 0;
    	for(int i = 1; i <= N; i++) {
    		arr[i] = read();
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		for(int j = i-1; j>=0; j--) {
    			if(arr[i] > arr[j]) {
    				dp[i] = Math.max(dp[i], dp[j]+1);
    				max = Math.max(max, dp[i]);
    			}
    		}
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