import java.util.ArrayList;

public class CountRepeatedNumbersArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int a[]= {4,5,5,6,7,7,8,9};
		 
		 ArrayList<Integer> list=new ArrayList<>();
		
		 for(int i=0;i<a.length;i++)
		 {
			 int k=0;
			 if(!list.contains(a[i]))
			 {
				 list.add(a[i]);
				 k++;
			 }
			 for(int j=i+1;j<a.length;j++)
			 {
				 if(a[i]==a[j])
				 {
					 k++;
				 }
				 
				
			 }	
			 if(k>=1)
			 {
			 System.out.println("Number:"+a[i]+"Appeared"+"Count:"+k);
			 }
			 if(k==1)
			 {
				 System.out.println("Appeared once number:"+a[i]);
			 }
		 }
		 
		 
		 
	}

}
