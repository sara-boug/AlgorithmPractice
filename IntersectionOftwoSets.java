import java.util.ArrayList;
import java.util.Collections;

// algorithm to detect the intersection of two sets which comlexity is O(nlogn) Subquadratic
//the Problem : 
/*Intersection of two sets. Given two arrays a[] and b[], each containing nn distinct 2D points
 *  in the plane, design a subquadratic algorithm to count the
 *  number of points that are contained both in array a[] and array b[].
 */

public class IntersectionOftwoSets {
class Point{  // set of 2D points 
	int x ; 
	int y ; 
}
;
	public IntersectionOftwoSets() {
		// TODO Auto-generated constructor stub
		//elements = new ArrayList<Point>() ;
	}
	// push into the set of points 
	public  void  push(  ArrayList <Point> elements,int x , int y) { 
		  Point point = new Point(); 
		  point.x= x; 
		  point.y= y; 
		  elements.add(point); 
	}
    // we need the list to be sorted in order to apply the binary search 
	//we sort the element according to X 
	public int SortandCount(ArrayList <Point>  setA, ArrayList <Point>  setB) { 
		@SuppressWarnings("unchecked")
		ArrayList <Point> seta =(ArrayList<Point>) setA.clone(); 
		@SuppressWarnings("unchecked")
		ArrayList <Point> setb =(ArrayList<Point>) setB.clone(); 
 		int count=0 ; 
		for(int a=0; a<seta.size(); a++) { 
 	 	  for(int b=0; b<setb.size(); b++) { //whenever u find the element the element get removed 
			  if(setb.get(b).x== seta.get(a).x && setb.get(b).y== seta.get(a).y)
			  {
				  count++; 
				  setb.remove(b); 
			  }
 		   }
		} 
          System.out.print(count);        
         return count; 
 	} 
	public static void main(String[] args) {
 
		IntersectionOftwoSets test = new IntersectionOftwoSets(); 
		ArrayList <Point> set1 = new ArrayList<Point>(); 
		ArrayList <Point> set2 = new ArrayList<Point>(); 
		
			test.push(set1, 1,2 );
			test.push(set1, 3,2 );
			test.push(set1, 11,2 );
			test.push(set1, 47,9);
			test.push(set1, 10,20 );
			test.push(set1, 11,22 );
			
			test.push(set2, 1,2 );
			test.push(set2, 3,2 );
			test.push(set2, 11,2 );
			test.push(set2, 47,9);
			test.push(set2, 10,20 );
			test.push(set2, 11,22 );

 
       
        test.SortandCount(set1, set2); 

	}

}
