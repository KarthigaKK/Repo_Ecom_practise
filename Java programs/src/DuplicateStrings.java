import java.util.HashMap;
	import java.util.Map;
	import java.util.Map.Entry;
public class DuplicateStrings {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			String str="JavaJavaJ2EE";
			
			Map<Character,Integer> countduplicatemap=new HashMap<Character,Integer>();
			
			char[] chars=str.toCharArray();
			
			for(char c:chars)
			{
				if(countduplicatemap.containsKey(c))
				{
					countduplicatemap.put(c, countduplicatemap.get(c)+1);
				}
				else
				{
					countduplicatemap.put(c, 1);
				}
			}
			
			for (Entry<Character,Integer> e :countduplicatemap.entrySet())
			{
				if(e.getValue()>1)
				{
					System.out.println(e.getKey()+"  "+e.getValue());
				}
			}
			

		}

	}



