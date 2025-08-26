import java.util.*;
public class Hello {

    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		ArrayList<Integer> index = new ArrayList<>();
		
		for(int i = 0 ; i < s.length() ; i++){
		    if(s.charAt(i) == 'a') index.add(i);
		}
		
		int len = index.size();
		
		int mid = index.get(len / 2 );
		
		System.out.print(calculate(index ,mid ,len));

		sc.close();

	}
	
	
	private static long calculate(ArrayList<Integer> indexes, int midV, int len){
	    
	    long res = 0;
		int  mid = len / 2 , done = 0 , ind = mid - 1;
	    
	    while( ind >= 0 ){
	        res += (midV - indexes.get(ind--) - 1 - (done++));
	    }
	    
	    done = 0;
	    
	    mid++;
	    
	    while ( mid < len ){
	        res += ((indexes.get(mid++) - midV) - 1 - done++);
	    }
	    
	    return res;
	}
}