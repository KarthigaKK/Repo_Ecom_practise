package main;

public class Hangman {

	public int countAlphabets(String word, char alphabet) {
		// TODO Auto-generated method stub
		int result=0;
		char[] words=word.toCharArray();
		
		for(char oneword:words)
		{
			if(oneword == alphabet) {
				result++;
			}
			
		}
		return result;
	}

	

}
