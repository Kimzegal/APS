import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int total = 0;
        sand = new int[N+4][N+4];
        tor = new int[N+4][N+4];
        for(int r=2; r<N+2; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=2; c<N+2; c++) {
        		sand[r][c] = Integer.parseInt(st.nextToken());
        		total += sand[r][c];
        	}
        }
        tornado = new int[] {(N+3)/2, (N+3)/2};
        
        while(tornado[0]!=2 || tornado[1]!=2) {
        	move();
        	blow();
        }
        
        int rem = 0;
        for(int r=2; r<N+2; r++) {
        	for(int c=2; c<N+2; c++) {
        		rem += sand[r][c];
        	}
        }
        
        System.out.println(total-rem);
    }
    static int N;
    static int before;
    static int[][] sand;
    static int[][] tor;
    static int[] tornado;
    static int[] direction = {0, 1, 1, 2};
    static void move() {
    	before = direction[0];
    	int[] dx = {0, 1, 0, -1};
    	int[] dy = {-1, 0, 1, 0};
    	
    	tornado[0] += dx[direction[0]];
        tornado[1] += dy[direction[0]];
        tor[tornado[0]][tornado[1]]=1;
        
        if(--direction[2]==0) {
        	direction[0] = (direction[0]+1)%4;
        	direction[2] = direction[1];
        	if(--direction[3]==0) {
        		direction[2] = ++direction[1];
        		direction[3] = 2;
        	}
        }
    }
    
    static void blow() {
    	int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    	int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    	int[] dsand = {10, 7, 1, 0, 1, 7, 10, 0};
    	int dir = (4-before)%4*2;
    	int cnt = 0;
    	for(int i=0; i<8; i++) {
    		int now = sand[tornado[0]][tornado[1]]*dsand[i]/100;
    		cnt+=now;
    		sand[tornado[0]+dx[dir]][tornado[1]+dy[dir]]+=now;
    		dir = (dir+1)%8;
    	}
    	int[] dx2 = {-1, 0, 1, 0};
    	int[] dy2 = {0, -1, 0, 1};
    	int[] dsand2 = {2, 5, 2, 0};
    	dir = before;

    	for(int i=0; i<4; i++) {
    		int now = sand[tornado[0]][tornado[1]]*dsand2[i]/100;
    		cnt+=now;
    		sand[tornado[0]+(dx2[dir]*2)][tornado[1]+(dy2[dir]*2)]+=now;
    		dir = (dir+1)%4;
    	}
    	
       	int[] dx3 = {0, 1, 0, -1};
    	int[] dy3 = {-1, 0, 1, 0};
    	int remain = sand[tornado[0]][tornado[1]]-cnt;
    	dir = before;
    	sand[tornado[0]+dx3[dir]][tornado[1]+dy3[dir]]+=remain;
    	sand[tornado[0]][tornado[1]]=0;
    	
    }
    
    static void seeArr(int[][] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                System.out.printf("%4d ",arr[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}