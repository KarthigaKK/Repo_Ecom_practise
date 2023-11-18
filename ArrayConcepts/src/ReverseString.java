
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String name="MADAM";
       String reversedname="";
       
       for(int i=name.length()-1;i>=0;i--)
       {
    	   reversedname=reversedname+name.charAt(i);
    	   
    	  
       }
     
       System.out.println(reversedname);
       
       if(name.equals(reversedname))
       {
    	   System.out.println("Reversed string and given string are same Palindrome:"+" "+reversedname);
       }
	}

}
