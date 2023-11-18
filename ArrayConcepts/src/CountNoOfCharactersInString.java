import java.util.HashMap;

public class CountNoOfCharactersInString {
	
	public static void countCharacters(String inputstr)
	{
		HashMap<Character, Integer> hashholder=new HashMap<Character,Integer>();//Empty hashmap
		
		char[] toArray=inputstr.toCharArray();//character(['K','a',]
		
		for(char c:toArray)
		{
			if(hashholder.containsKey(c))
			{
				hashholder.put(c, hashholder.get(c)+1);
			}
			else
			{
				hashholder.put(c, 1);//k=1,a=2,r=1,t=1,h=1,i=1,g=1
			}
		}
		
		System.out.println(hashholder);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		countCharacters("KarthigaKalyan is checking for job for is");

	}

}
