
package transliteration;
 import Sandhis.*; 

import java.util.*;

import java.lang.Integer.*;

public class devanagari
{
private String transformed;
private Hashtable<String,String> unicode;
private Hashtable<String,String> matra;

public devanagari()
	{
	
	transformed = "";
	unicode = new Hashtable<String,String>();
	matra = new Hashtable<String,String>();
	my_hashtable();
	}

public void my_hashtable( )
	{
		
	matra.put("halant", "\u094d");   //halanta Sign 
	matra.put("A", "\u093E");
	matra.put("i", "\u093F");
	matra.put("I", "\u0940");
	matra.put("u", "\u0941");
	matra.put("U", "\u0942");
	matra.put("f", "\u0943");
	matra.put("F", "\u0944");
	matra.put("x", "\u0962");
	matra.put("X", "\u0963");
	matra.put("e", "\u0947");
	matra.put("E", "\u0948");
	matra.put("o", "\u094b");
	matra.put("O", "\u094c");

	
	unicode.put("a", "\u0905");
	unicode.put("A", "\u0906");
	unicode.put("i", "\u0907");
	unicode.put("I", "\u0908");
	unicode.put("u", "\u0909");
	unicode.put("U", "\u090a");
	unicode.put("f", "\u090b");
	unicode.put("F", "\u0960");
	unicode.put("x", "\u090c");
	unicode.put("X", "\u0961");
	unicode.put("e", "\u090f");
	unicode.put("E", "\u0910");
	unicode.put("o", "\u0913");
	unicode.put("O", "\u0914");
	
	unicode.put("k", "\u0915");
	unicode.put("K", "\u0916");
	unicode.put("g", "\u0917");
	unicode.put("G", "\u0918");
	unicode.put("N", "\u0919");
	unicode.put("c", "\u091a");
	unicode.put("C", "\u091b");
	unicode.put("j", "\u091c");
	unicode.put("J", "\u091d");
	unicode.put("Y", "\u091e");
	unicode.put("w", "\u091f"); // Ta 
	unicode.put("W", "\u0920"); 
	unicode.put("q", "\u0921"); // Da 
	unicode.put("Q", "\u0922");
	unicode.put("R", "\u0923");
	unicode.put("t", "\u0924"); // ta 
	unicode.put("T", "\u0925"); // tha 
	unicode.put("d", "\u0926"); // da
	unicode.put("D", "\u0927"); // dha 
	unicode.put("n", "\u0928");
	unicode.put("p", "\u092a");
	unicode.put("P", "\u092b");
	unicode.put("b", "\u092c");
	unicode.put("B", "\u092d");
	unicode.put("m", "\u092e");
	unicode.put("y", "\u092f");
	unicode.put("r", "\u0930");
	unicode.put("l", "\u0932");
	
	unicode.put("L", "\u0933"); 
	
	unicode.put("v", "\u0935");
	unicode.put("S", "\u0936");
	unicode.put("z", "\u0937");
	unicode.put("s", "\u0938");
	unicode.put("h", "\u0939");
	unicode.put("M", "\u0902"); // anusvara
	unicode.put("H", "\u0903"); // visarga
	unicode.put("~", "\u0901"); // anunAsika - cchandra bindu, using ~ to represent it\
	unicode.put("'", "\u093d"); // avagraha using "'"
	unicode.put("3", "\u0969"); // 3 equals to pluta
	unicode.put("8", "\u014F");//8 equals to upadhamaniya 
//	unicode.put("8", "\u0306\u032F");//8 equals to upadhamaniya 
        unicode.put("9", "\u0950");
	unicode.put("|", "\u0964"); //devangari double danda
	//unicode.put("||", "\u0965");

	}
public String transform(String s1)
	{
	 
	transformed = "";
	//System.out.println(" in devanagari" );
	
	Vowel vowel = new Vowel();

	int str_len = s1.length();

	Object shabda[];
	shabda = new String[str_len*2];
	int counter = 0;

	for (int i = 0; i < str_len ; i++ )
	{
		char c = s1.charAt(i);
		Character character = new Character(c);
		String varna = character.toString();
		
		

		if (vowel.is_consonant(varna) )
		{
			shabda[counter++] = unicode.get(varna);
			//System.out.println(" shabda [" + (counter - 1) + "] ==  " + shabda[counter-1]);
			shabda[counter++] = "\u094d";//unicode.get("halant");
			//System.out.println(" shabda [" + (counter - 1) + "] ==  " + shabda[counter-1]);
		}
	
		else if (vowel.is_Vowel(varna))
		{
			if ( counter == 0 )
			{ shabda[counter++] = unicode.get(varna); }
			else if( (shabda[counter - 1].toString()).equals("\u094d") )
			{
				if( varna.equals("a") )
				{ shabda[--counter] = ""; }
				else 
					{
						shabda[--counter] = matra.get(varna);
						counter++; 
					}
			}
			
			else
			{ shabda[counter++] = unicode.get(varna); }
		
		} 

		else if (unicode.containsKey(varna))
		{
			shabda[counter++] = unicode.get(varna);
		}
		else { shabda[counter++] = varna; }
	} 

	for ( int j = 0; j < counter; j++ )
	{
		transformed += shabda[j];
	}
	
	return transformed; 
	}

}
