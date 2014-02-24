package transliteration;
import transliteration.*;

public class Vowel {


public static  boolean is_Vowel(char c)
	{
		//System.out.println("came in is_Vowel: Checking whether string is a Vowel");
		if( c == 'a' || c == 'A' || c == 'i' || c == 'I' || c == 'u' || c == 'U' || c == 'f' || 
			c == 'F' || c == 'x' || c == 'X' || c == 'e' || c == 'E' || c == 'o' || c == 'O' )
			{
			//System.out.println("Is a Vowel");
			return true; 
		}
		
		return false;

	}


public static  boolean is_Vowel(String s1)
	{
		
		if( s1.length() != 1 )
			return false;
		
		return is_Vowel(s1.charAt(0));

	}

public static  boolean is_consonant(char c)
	{
		
		if( c == 'k' || c == 'K' || c == 'g' || c == 'G' || c == 'N' || 
			c == 'c' || c == 'C' || c == 'j' || c == 'J' || c == 'Y' || 
			c == 't' || c == 'T' || c == 'd' || c == 'D' || c == 'R' || 
			c == 'w' || c == 'W' || c == 'q' || c == 'Q' || c == 'n' || 
			c == 'p' || c == 'P' || c == 'b' || c == 'B' || c == 'm' || 
			c == 'y' || c == 'r' || c == 'l' || c == 'v' || c == 'L' || 
			c == 'S' || c == 'z' || c == 's' || c == 'h'  )
			{
			//System.out.println("Is a Consonant");
			return true; 
		}
		
		return false;

	}

public static  boolean is_consonant(String s1)
	{
		if( s1.length() != 1 )
			return false;
		
		return is_consonant(s1.charAt(0));

	}
} //end of class
