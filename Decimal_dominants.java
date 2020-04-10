import java.util.ArrayList;
import java.util.Arrays;

/* Problem: Decimal dominants. Given an array with nn keys, design an algorithm to find all
 *  values that occur more than n/10n/10 times. The expected running time of your 
 *  algorithm should be linear.

 */
public class Decimal_dominants {
	int[] array; 
	public Decimal_dominants(int[] a) {
		// we will suppose that the array is sorted
		this.array= a; 
		Arrays.sort(this.array);
	}

	public ArrayList<Integer> decimal_dominant() { 
		int n=(array.length/10)+1; 
		ArrayList<Integer>  elements= new ArrayList<Integer>();  // list containing the elements occuring n/10
		if( n>1) { 		
			int lo= 0; 
			int hi=array.length; 
			while(lo<hi) { 
				if(lo+n<hi) {
					if(array[lo]== array[lo+n]) {
						 int j= elements.size()-1;
						 if(j>=0) {
						 if( elements.get(j)!=array[lo] ){elements.add(array[lo]);}	// filtering the duplication 
						 }else { 
							elements.add(array[lo]);
						 }
						lo=lo+n; 
					}else { 
						lo++; 
					}

				}else { 
					break; 
				}
			}
		}
		
		return elements; 
	}
	public static void main(String[] args) {
		 int[] elements= {	1,2,3,4,5,6,7,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,
				 9,9,9,9,9,7,7,8,5,1,1,23,4,7,8,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1
				 ,1,1,1,1,1,1};
		 Decimal_dominants d = new  Decimal_dominants(elements);
	     System.out.print(Arrays.toString(d.decimal_dominant().toArray())); 
		 }
		

	}


