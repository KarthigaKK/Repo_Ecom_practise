
public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a=345;
		int reverse=0;
		
		while(a!=0)
		{
			int digit=a%10;//5
			
			reverse=digit+reverse*10;//5+0;4+5*10=54;3+54*10=543
			a=a/10; //34
			
		}
		
		System.out.println(reverse);
	}

}
