
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		System.out.println(factorial(n));
//5!=5*4*3*2*1=120--n*(n-1)--5*4!,5*4*3!,5*4*3*2!,5*4*3*2*1!
	}
	
	public static int factorial(int n)
	{
		if(n==1)
		{
			return 1;
		}
		else
		{
			return n * factorial(n-1);
		}
	}

}
