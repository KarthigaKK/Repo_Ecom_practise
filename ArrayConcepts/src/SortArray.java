import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arry[]={11, 23, 13, 43, 62, 10, 12, 31, 17};
        
        //sort array
      
        
        ArrayList<Integer> list=new ArrayList<>();
        
          //COnvert array to list
     for(int i=0;i<arry.length;i++)
     {
    	 for(int j=1;j<arry.length;j++)
    	 {
    		 if(arry[i]<arry[j])
    		 {
    			
    			 if(!list.contains(arry[i]))
    			 {
    				 list.add(arry[i]);
    			 }
    		 }
    	 }
    	 
    	
    	
     }
    // Collections.sort(list,Comparator.reverseOrder());
   // System.out.println(list);
     
    List<Integer> newint= list.stream().sorted().collect(Collectors.toList());
     System.out.println(newint);
        
        
	}

}
