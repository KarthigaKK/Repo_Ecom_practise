
public class PrintPyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*  
		*
		* *
		* * *
		* * * *
		* */
		
//		for(int i=1;i<=5;i++) //For four rows
//		{
//			for(int j=1;j<=i;j++) //each row
//			{
//				System.out.print("*");
//				System.out.print("\t");
//			}
//			System.out.println();
//		}
		
		/*
		 KARTHI
		 KARTH
		 KART
		 KAR
		 KA
		 K
		 * 
		 */
		
		String ptn="KARTHI";
		
	
		for(int i=ptn.length()-1;i>=0;i--)//6 rows,5,4,3,2,1 (5<=0,5>=0)
		{
			for(int j=0;j<=i;j++)//each row j<6;
			{
			     System.out.print(ptn.charAt(j));//KARTHI
			     System.out.print("\t");
			}
			System.out.println(" ");
		}
		
	}

}
