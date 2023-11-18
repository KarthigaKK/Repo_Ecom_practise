
public class AddTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a= {{1,2},{1,2}};
		int[][] b= {{2,3},{3,4}};
		int[][] c=new int[2][2];
		
		for(int i=0;i<2;i++)
		{
			for(int j=0;j<2;j++)
			{
				c[i][j]=a[i][j]+b[i][j];
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
