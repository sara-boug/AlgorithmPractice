import java.util.Arrays;

public class recursions {
	static void reverse(int[]  array1  , int[] array2, int n , int i ) { 
		 
		 if(i==array1.length-1) { 
			 return ;
		 }else { 
			 array2[i]= array1[n];
			 reverse(array1 ,array2, n-1,i+1 );
		 }
 	 }
	static void mean(int[] array, int i, double j) { 
		if( i  >=array.length) { 

			j=j/(i+1);
	         System.out.println(j);

		 return ;
		}  

         j =j+  array[i];
        mean(array ,i+1,j);		
	}
	static  int  even_sum(int[] array , int n) { 
		 if(n >=array.length) { 
			 return 0;
		 }
		 if(array[n] %2 ==0) { 
			 
			 return array[n] +even_sum(array, n+1); 
		 } else { 
			return even_sum(array, n+1);
			 
		 }
		
 	}

	static boolean palindrome(int[] array ,int i , int n) {
		if(array[i] !=array[n]) { 
			return false; 
		}  
		  if(i== (array.length/2)-1) {
				return true;

		  }
		  palindrome(array, i+1, n-1);
		  return true;
		
	}
	public static void main(String[] args) {
 		
		int[] array1= {1,2,3,2,1} ; 
		int[] array2 = new int[array1.length];
		int n= array1.length-1; 
		int i=0;
		double j=0;
        /* reverse(array1, array2 , n,i);
         System.out.println(  Arrays.toString( array2));
         mean(array1, i,j);*/
		//System.out.println( even_sum(array1,i));
		System.out.println( palindrome(array1,i, n));
 
	}

}
