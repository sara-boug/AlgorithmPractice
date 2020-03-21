
public class Search_in_a_bitonic_array {
	
	//solution inspired from greeksforgreeks
	public Search_in_a_bitonic_array(int[] a) { 
		
	   //System.out.print( findMax(a,0, a.length-1)); 
		
	}
	
	//first we find the highest numbers through binarySearch
	
	public int findMaxIndex(int[] a , int low , int high) { 
	   if (high == low) 
	       return low;  
	  if((high==low+1) && a[low]<a[high]) { 
		  return high;
	  }	
	
	  if((high==low+1) && a[low]>=a[high]) { 
		  return low;
	  }	
	   int mid=high%2==0 ? (high+low)/2 :((high+low)/2)-1; // in the case the width is not in not even 

	  if(a[mid]>a[mid+1] && a[mid]>a[mid-1]) return mid;

	  if(a[mid]> a[mid+1] && a[mid] <a[mid-1]) { 
		 return  findMaxIndex(a, low , mid-1); 
	  }else { 
		  return findMaxIndex(a, mid+1 , high); 
	  }
	  
 	}
	
	public int findleft (int[] a , int n, int mid) {  //searching on the left side
  	    if ( mid <a.length ) {
 	    	   if( n>a[mid]) return -1; 
 	           if(a[mid]==n) return mid ;
                return findleft(a, n, mid+1); 
                
 	    }    

		return -1;

	}
	
	public int findright (int[] a , int n, int mid) {  //searching on the left side
	    if (mid >=0  ) {
 	    	   if( n>a[mid]) return -1; 
 	           if(a[mid]==n) return mid ;
               return     findright(a, n, mid-1); 
  	    }    
		return -1;
	}

	public int findNumber(int a[],int n) {  // applying the search on both sides 
		int mid =findMaxIndex(a , 0 , a.length-1);
		if(findleft(a, n, mid )!=-1)  return findleft(a, n, mid ); 
		
		else if(findright(a, n, mid )!=-1) return findright(a, n, mid );
		else return -1; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=  {3, 50, 10, 9, 7, 6};
 		 Search_in_a_bitonic_array s = new  Search_in_a_bitonic_array(a) ;
		System.out.print( s.findNumber(a,3));
	}
	
	

}
