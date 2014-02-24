package wordProcessor;
import transliteration.*;
import SandhiJoin.sandhiJoin;

import java.util.*;
/**
 *
 * @author priya
 */
public class join {
    ArrayList<Character> swaras=new ArrayList<Character>();
    private Hashtable<String,String> unicode;
    public join()
    {
        unicode = new Hashtable<String,String>();
        swaras.add('\u093E'); // ा
        swaras.add('\u093F'); // ि
        swaras.add('\u0940'); // ी
        swaras.add('\u0941'); // ु
        swaras.add('\u0942'); // ू
        swaras.add('\u0947'); // े
        swaras.add('\u0948'); // ै
        swaras.add('\u094b'); // ो
        swaras.add('\u094c'); // ौ
        swaras.add('\u094d'); // ्
	
        unicode.put("\u093E","A"); // ा
        unicode.put("\u093F","i"); // ि
        unicode.put("\u0940","I"); // ी
        unicode.put("\u0941","u"); // ु
        unicode.put("\u0942","U"); // ू
        
        unicode.put("\u0947","e"); // े
        unicode.put("\u0948","ai");// ै
        unicode.put("\u094b","o"); // ो
        unicode.put("\u094c","au");// ौ
        unicode.put("\u094d","");// ्
        
	unicode.put("\u0905","a");
	unicode.put("\u0906","A" );
	unicode.put("\u0907","i" );
	unicode.put("\u0908","I");
	unicode.put("\u0909","u");
	unicode.put("\u090a","U");
        
	unicode.put("\u090b","RRi");
	unicode.put("\u0960","RRI");
	unicode.put("\u090c","LLi");
	unicode.put("\u0961","LLI");
	unicode.put("\u090f","e");
	unicode.put("\u0910","ai");
	unicode.put("\u0913","o");
	unicode.put("\u0914","au");
	
	unicode.put("\u0915","ka");
	unicode.put("\u0916","kha");
	unicode.put("\u0917","ga");
	unicode.put("\u0918","gha");
        
	unicode.put("\u0919","~Na");
        
	unicode.put("\u091a","ca");
	unicode.put("\u091b","Cha");
	unicode.put("\u091c","ja");
	unicode.put("\u091d","jha");
        
	unicode.put("\u091e","~na");
        
	unicode.put("\u091f","Ta"); // Ta as in Tom
	unicode.put("\u0920","Tha"); 
	unicode.put("\u0921","Da"); // Da as in David
	unicode.put("\u0922","Dha");
	unicode.put("\u0923","Na");
        
	unicode.put("\u0924","ta"); // ta as in tamasha
	unicode.put("\u0925","tha"); // tha as in thanks
	unicode.put("\u0926","da"); // da as in darvaaza
	unicode.put("\u0927","dha"); // dha as in dhanusha
	unicode.put("\u0928","na");
        
	unicode.put("\u092a","pa");
	unicode.put("\u092b","pha");
	unicode.put("\u092c","ba");
	unicode.put("\u092d","bha");
	unicode.put("\u092e","ma");
        
	unicode.put("\u092f","ya");
	unicode.put("\u0930","ra");
	unicode.put("\u0932","la");
	
//	unicode.put("\u0933","L"); // the Marathi and Vedic 'L'
	
	unicode.put("\u0935","va");
	unicode.put("\u0936","sha");
	unicode.put("\u0937","Sa");
	unicode.put("\u0938","sa");
	unicode.put("\u0939","ha");
        
	unicode.put("\u0902","M"); // anusvara
	unicode.put("\u0903","H"); // visarga
        unicode.put("\u0950","OM");
        unicode.put("\u093d",".a");//avagraha
        
	unicode.put("\u0901","~"); // anunAsika - cchandra bindu, using ~ to represent it\
	//unicode.put("\u093d","'"); // avagraha using "'"
	//unicode.put("\u0969","3"); // 3 equals to pluta
	//unicode.put("\u014F","8");//8 equals to upadhamaniya 
//	unicode.put("8", "\u0306\u032F");//8 equals to upadhamaniya 

	unicode.put("\u0964","|"); //devangari double danda
	//unicode.put("||", "\u0965");
    }

    public String StoE(String word)
    {
        db d=new db();
        String result="";
       //System.out.println("द्य".length());
        for(int i=0;i<word.length();i++)
        {
           // if(unicode.get(word.charAt(i)+"")!=null)

            result=result+unicode.get(word.charAt(i)+"");
            if(i+1<word.length())
                if(swaras.contains(word.charAt(i+1)))
                  result=result.substring(0,result.length()-1);
        }

        return result;
    }
    
    public String performJoin(String string1, String string2)
    {
        string1=StoE(string1);
        string2=StoE(string2);
        string1 = this.transform(string1);
        string2=this.transform(string2);
        System.out.println(string1+" "+string2);
     
        sandhiJoin sj=new sandhiJoin();
        String ret=sj.process(string1, string2);
        choose_encoding encod=new choose_encoding();
        String s1 = this.transformBack(ret);
        s1 = encod.get_raw_to_dvn_view(s1);
        
        System.out.println(s1);
  
        return(s1);
    }
    public String transform(String alter)
    {
        alter=alter.replace("H","h"); 
        alter=alter.replace("Ch","ch");
        
        alter=alter.replace("sh","11"); // dont change order sh->S, S->Sh
        alter=alter.replace("S","Sh");
        alter=alter.replace("11","S");
        
       // alter=alter.replace("M","m");
        
        alter=alter.replace("~N","~G");
        alter=alter.replace("~n","~J");   
        
        alter = alter.replaceAll("~G","22");  // dont change order (~ to ~M)
        alter = alter.replaceAll("~J","11");
        alter = alter.replace("~","~M");
        alter = alter.replaceAll("11","~J");
        alter = alter.replaceAll("22","~G");
        
       
        return alter;
    }
    public String transformBack(String alter)
    {
         
        
        alter=alter.replace("&","\u093d"); //avagraha

        StringBuilder newAlter = new StringBuilder(alter);
        
        if(alter.endsWith("h"))
        {
           newAlter.setCharAt(alter.length()-1, 'H');
          // newAlter.setLength(alter.length()-1);
           alter =  newAlter.toString();
           System.out.println(alter+"new alter");
        }
        
        alter=alter.replace("ch","Ch");
        
        alter=alter.replace("Sh","11");
        alter=alter.replace("S","sh");    // S->sh Sh->S
        alter=alter.replace("11","S");
        
        
        
       // alter=alter.replace("M","m");
        
        alter = alter.replace("~G","~N");
        alter = alter.replace("~J","~n");   
        
        alter = alter.replaceAll("~N","22");  // dont change order (~ to ~M)
        alter = alter.replaceAll("~n","11");
        alter = alter.replace("~M","~");
        alter = alter.replaceAll("11","~n");
        alter = alter.replaceAll("22","~N");
        
        return alter;
    }
    public static void main(String[] args)
    {
        join j=new join();
        String ret1="मूदं";
        String ret2="असिशमषं";                           // check for anuswara in sandhJoin pgm...
        ret1=j.performJoin(ret1,ret2);
        System.out.println("\u0944");
        
    }
}
    /* public String EtoS(String word)
    {
        db d=new db();
        ArrayList<String> swaras=new ArrayList<String>();
        swaras.add("ा"); swaras.add("ी"); swaras.add("ू");swaras.add("ि");
        swaras.add("े");swaras.add("ो");swaras.add("ौ");swaras.add("ै");swaras.add("ु");
        String result=""; 
        for(int i=0;i<word.length();i++)
        {
         
            String x=word.charAt(i)+"";
            String r=null;
            if(i==0)
                if(word.charAt(i+1)=='i' || word.charAt(i+1)=='u')
                {
                    x=x+word.charAt(i+1)+"";
                    r=d.getCharMap(x,0);
                    i++;
                }
            if(r==null)
            for(int j=0;j<3;j++)
            {
                r=d.getCharMap(x+"",i+j);
               
                if(r!=null)
                {
                    i=i+j;
                    break;
                }
                else if(  j==2 && x.length()==3 && (r=d.getCharMap(x.substring(0,x.length()-1)+"a",i+j))!=null )
                {
                    
                    i++; 
                        break;
                }
                else
                {
                    if((i+j+1)< word.length())
                    {
                        x=word.substring(i,i+j+2);
                        
                    }
                }
               
                
            }
            
            if(r==null )
            {
               
                x="";
                if(i+1 < (word.length()))
                {
                    x=null;
                x=word.charAt(i+1)+"";
                }
                
                    r=d.getCharMap(x,i+1);
                    if(swaras.contains(r))
                    {
                        
                         x=word.charAt(i)+"a";
                        r=d.getCharMap(x+"",i);
                        if(word.charAt(i+1)=='a')i++;
                    }
                    else
                    {
                         x=word.charAt(i)+"a";
                         r=d.getCharMap(x,i);
                         r=r+"्";
                    }
            }

            result=result+r;
      
            
        }

        return result;
    }

*/
    



