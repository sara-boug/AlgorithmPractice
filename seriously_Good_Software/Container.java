package seriously_Good_Software;
import java.util.*; 

public class Container {
    private  Set<Container> groupe; // describes the containers that 
    private float water;  // describes the water level 


	public Container() {
		groupe = new HashSet<Container>();
		this.water=0; 
		
	}
	
	public void connectTo(Container container) { 

		 if(container == this) { System.out.println("self"); return ;   }
		 this.groupe.add(container); 
		 container.addToGroupe(this);
         for(Container c : this.getGroupe()) {  // else accessing the loop 
             for(Container c2 : c.getGroupe()) {
            	 if(c!=this) {
        	     	 c.addToGroupe(this); // taking into consideration the containers which are indirectly connected
            	 } 
            	 if(c2!=container) {
        		  c2.addToGroupe(container);
            	 }
           } 
      
         }
         
         for(Container c : this.getGroupe()) {  
        	 if(c != container) { 
        		 c.addToGroupe(container); // taking into consideration the containers which are indirectly connected
             }
         }

         this.addWater(this.water); // once connected the quantity of water is divided  between the linked containers 
		  
	}
	public Set<Container> getGroupe() { 
		return this.groupe; 
	}
	public void  addToGroupe(Container c) { 
		 this.groupe.add(c);
	}
	public float  getWater() { 
		return this.water; 
	}
	public void setWater(float  water){ this.water = this.water+ water; }
	
	public void addWater(float  water) { 
		   if(this.groupe.size() ==0) {  // if the current container is not related to any other container 
			   this.setWater(water);    
			   return ; } 
		   float addedWater = water/(this.groupe.size() +1) ;  // the water is added according to the container that are directly 
 		   this.setWater(addedWater);                                     // or indirectly connected to this container
		 
           for(Container c: this.groupe) { 
			   c.setWater(addedWater);
		   }
		   
	}
	
	public static void main(String[] args) { 
		Container container1 = new Container(); 
		Container container2 = new Container(); 
		Container container3= new Container(); 
		Container container4= new Container(); 


		container1.connectTo(container2);
		container2.connectTo(container3);
		container3.connectTo(container1);
		System.out.println(container2.getGroupe().size() ) ; 
 
		container1.addWater(6);
		System.out.println( "container 1 :" + container1.getWater() + "  " + "container 2 : " +container2.getWater() 
		+ "  " + "container 3 : " +container3.getWater()+ "  " + "container 4 : " +container4.getWater());

		
		
    
	} 

}
