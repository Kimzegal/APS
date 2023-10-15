import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<PriorityQueue<Integer>> graph = new ArrayList<>();
	
	static public void addV() {
		graph.add(new PriorityQueue<>());
	}
	
	static void addE(int v, int e) {
		graph.get(v).offer(e);
		graph.get(e).offer(v);
	}
	
    public static void main(String[] args)throws IOException{
    	int N = read();
    	int M = read();
    	for(int i = 0; i <= N; i++) addV();
    	visited = new boolean[N+1];
    	for(int i = 0; i < M; i++) {
    		int u = read();
    		int v = read();
    		addE(u, v);
    	}
    	
    	bfs(1);
    	
    	int cnt = 0;
    	for(int i = 2; i<= N; i++) {
    		if(visited[i]) cnt++; 
    	}
    	
    	System.out.println(cnt);
    }
    
    static boolean[] visited;
    
    static void bfs(int start) {
    	Queue<Integer> queue = new LinkedList<>();
    	queue.offer(start);
    	visited[start] = true;
    	
    	while(!queue.isEmpty()) {
    		int now = queue.poll();
    		while(!graph.get(now).isEmpty()) {
    			int tmp = graph.get(now).poll();
    			if(!visited[tmp]) {
    				queue.offer(tmp);
    				visited[tmp] = true;
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