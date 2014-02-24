
package transliteration;
 //import sandhi.*; 

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
	matra.put("A", "\u0CBE");
	matra.put("i", "\u0CBF");
	matra.put("I", "\u0CC0");
	matra.put("u", "\u0CC1");
	matra.put("U", "\u0CC2");
	matra.put("RRi", "\u0CC3");
	matra.put("RRI", "\u0CC4");
	//matra.put("LLi", "\u0C8C");
	//m0atra.put("LLI", "\u0CE1");
	//matra.put("X", "\u0963");
	matra.put("e", "\u0CC6");
	matra.put("E", "\u0CC7");
	matra.put("Z","\u0CC8");
	
	matra.put("o", "\u0CCA");
	matra.put("O", "\u0CCB");
	matra.put("V", "\u0CCC");
	

	
	unicode.put("a", "\u0C85");
	unicode.put("A", "\u0C86");
	unicode.put("i", "\u0C87");
	unicode.put("I", "\u0C88");
	unicode.put("u", "\u0C89");
	unicode.put("U", "\u0C8A");
	unicode.put("f", "\u0C8B");
	unicode.put("F", "\u0CE0");
	unicode.put("x", "\u0C8C");
	unicode.put("X", "\u0CE1");
	//unicode.put("F", "\u0960");
	//unicode.put("x", "\u090c");
	//unicode.put("X", "\u0961");
	unicode.put("e", "\u0C8E");
	unicode.put("E", "\u0C8F");
	unicode.put("V","\u0C90");
	unicode.put("o", "\u0C92");
	unicode.put("O", "\u0C93");
	unicode.put("Z","\u0C94");
	
	unicode.put("k", "\u0C95");
	unicode.put("K", "\u0C96");
	unicode.put("g", "\u0C97");
	unicode.put("G", "\u0C98");
	unicode.put("N", "\u0C99");
	unicode.put("c", "\u0C9A");
	unicode.put("C", "\u0C9B");
	unicode.put("j", "\u0C9C");
	unicode.put("J", "\u0C9D");
	unicode.put("Y", "\u0C9E");
	unicode.put("w", "\u0C9F"); // Ta 
	unicode.put("W", "\u0CA0"); 
	unicode.put("q", "\u0CA1"); // Da 
	unicode.put("Q", "\u0CA2");
	unicode.put("R", "\u09A3");
	unicode.put("t", "\u0CA4"); // ta 
	unicode.put("T", "\u0CA5"); // tha 
	unicode.put("d", "\u0CA6"); // da
	unicode.put("D", "\u0CA7"); // dha 
	unicode.put("n", "\u0CA8");
	unicode.put("p", "\u0CAA");
	unicode.put("P", "\u0CAB");
	unicode.put("b", "\u0CAC");
	unicode.put("B", "\u0CAD");
	unicode.put("m", "\u0CAE");
	unicode.put("y", "\u0CAF");
	unicode.put("r", "\u0CB0");
	unicode.put("l", "\u0CB2");
	
	unicode.put("L", "\u09B3"); 
	
	unicode.put("v", "\u0CB5");
	unicode.put("S", "\u0CB6");
	unicode.put("z", "\u0CB7");
	unicode.put("s", "\u0CB8");
	unicode.put("h", "\u0CB9");
	unicode.put("M", "\u0C82"); // anusvara
	unicode.put("H", "\u0C83"); // visarga
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
			shabda[counter++] = "\u0CCD";//unicode.get("halant");
			//System.out.println(" shabda [" + (counter - 1) + "] ==  " + shabda[counter-1]);
		}
	
		else if (vowel.is_Vowel(varna))
		{
			if ( counter == 0 )
			{ shabda[counter++] = unicode.get(varna); }
			else if( (shabda[counter - 1].toString()).equals("\u0CCD") )
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
