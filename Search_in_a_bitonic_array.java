
public class Search_in_a_bitonic_array {
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
	
	public int findRight (int[] a , int n, int low , int high ) {  //searching on the left side
		 while(low<=high) {
          int mid=low+(high-low)/2 ;
           if(n<a[mid])  high= mid-1; 
           else if(n>a[mid])  low=mid+1;
           else return mid;

 	    }    
		return -1;
	}
	public int findLeft (int[] a , int n, int low , int high ) {  //searching on the left side
		 while(low<=high) {
         int mid=low+(high-low)/2 ;
          if(n>a[mid])  high= mid-1; 
          else if(n<a[mid])  low=mid+1;
          else return mid;

	    }    
		return -1;
	}


	public int findNumber(int a[],int n) {  // applying the search on both sides 
		 int mid =findMaxIndex(a , 0 , a.length-1);
 		 if(findRight(a, n, 0 ,mid)!=-1)  return findRight(a, n,  0 ,mid); 
		
   	     else if(findLeft(a, n, mid, a.length )!=-1) return findLeft(a, n, mid, a.length); 
		else return -1; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=  {1,2,3, 50, 10, 9, 7, 6};
 		 Search_in_a_bitonic_array s = new  Search_in_a_bitonic_array() ;
     	System.out.print( s.findNumber(a,6));
	}
	
	

}
