import java.util.*;

public class KMP {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine() , key = sc.nextLine();
		
		int lps[] = new int[key.length()];
		
		generateLps(key ,key.length() ,lps);
		
		int res = 0 ,i = 0 ,j = 0;
		
		while(i < s.length()){
		    if(s.charAt(i) == key.charAt(j)){
		        i++;
		        j++;
		        
		        if(j == key.length()){
		            res++;
		            j = 0;
		        }
		    }else{
		        if(j != 0){
		            j = lps[j - 1];
		        }else{
		            i++;
		        }
		    }
		}
		
		System.out.print("Count=" + res);

        sc.close();
		
	}
	
	private static void generateLps(String key ,int len ,int []lps){
	    
	    int ptr = 0 , ind = 1;
	    
	     while(ind < len){
	         if(key.charAt(ind) == key.charAt(ptr)){
	             lps[ind++] = ++ptr;
	         }else{
	             if(ptr != 0)
	                 ptr = lps[ptr - 1];
	             else
	                lps[ind++] = 0;
	         }
	     }
	    
	}
}
