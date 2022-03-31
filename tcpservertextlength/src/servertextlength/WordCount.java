package servertextlength;

import java.io.IOException;

public class WordCount {

	public WordCount(String string) throws Exception {
		getTextLength(string);
	}
	
	public void getTextLength(String string) throws IOException {
		  
		System.out.println(wordcount(string) + " words."); 
		int numwords = wordcount(string);
		
		
		String textLength=String.valueOf(numwords);
		System.out.println(textLength);
		
		ServerTextApplication app = new ServerTextApplication();
		app.Continue(textLength);
		
	}
	
	static int wordcount(String string)  
	{  
		int count=0;  

		char ch[]= new char[string.length()];     
		for(int i=0;i<string.length();i++)  
		{  
			ch[i]= string.charAt(i);  
			if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)))  
				count++;  
		}  
		return count;  
	} 
	
}
