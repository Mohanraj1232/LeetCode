import java.util.*;
public class Hello {
    
    
    private static int diffs[][] = {
        {0 ,1},
        {1 ,0},
        {-1 ,0},
        {0 ,-1},
    };

    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt() , C = sc.nextInt();
		
		sc.nextLine();
		
		char grid[][] = new char[R][C];

		int rR = 0 , rC = 0;
		
		Queue<State> queue = new LinkedList<>();

		HashMap<String,Integer> maskmap = new HashMap<>();

		int carrot = 0;
		
		for(int r = 0 ; r < R ; r++){
		    for(int c = 0 ; c < C ; c++){
		        grid[r][c] = sc.next().charAt(0);
		        
		        if(grid[r][c] == 'R') {
					rR = r;
					rC = c;
		            queue.offer(new State(r ,c ,0 ,0));
		        }else if(grid[r][c] == 'C') {
					carrot++;
					maskmap.put(r + "," + c, carrot);
				}
		    }
		    sc.nextLine();
		}
		boolean visited[][][] = new boolean[R][C][1 << carrot];

		visited[queue.peek().row][queue.peek().col][0] = true;
		
		
		while(!queue.isEmpty()){
		    
		    int size = queue.size();
		    
		    for(int i = 0 ; i < size ; i++){
		        
		        State cur = queue.poll();
		        
		        for(int diff[] : diffs){
		            int nR = cur.row + diff[0] , nC = cur.col + diff[1];
		            
		            
		            if (Boundary(R, C, nR, nC) && grid[nR][nC] != '1' && !visited[nR][nC][cur.mask]) {
						int newmask = cur.mask;

						if (grid[nR][nC] == 'C'){
							newmask |= (1 << (maskmap.get(nR + "," + nC) - 1));
							queue.offer(new State(rR, rC, cur.moves + 1, newmask));
						}

						if (newmask == (1 << carrot) - 1) {
							System.out.print(cur.moves + 1);
							return;
						}
						visited[nR][nC][newmask] = true;
						queue.offer(new State(nR, nC, cur.moves + 1, newmask));

					}

		        }
		    }
		}
		
		System.out.print(-1);

	}
	
	
	private static boolean Boundary(int R ,int C ,int row ,int col){
	    return row >= 0 && col >= 0 && row < R && col < C;
	}
}

class State{
	int row , col , moves , mask;
	State(int row , int col , int moves , int mask){
		this.row = row;
		this.col = col;
		this.moves = moves;
		this.mask = mask;
	}
}