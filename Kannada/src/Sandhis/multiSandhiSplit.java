package Sandhis;
import java.util.*;
import wordProcessor.db;
/**
 *
 * @author Priya
 */
public class multiSandhiSplit
{
    ArrayList<String> globalResult = new ArrayList<String>();
    String mainWord;
    
    public ArrayList<String> process(String word)
    {
        mainWord = word;
        return(SubProcess(word));
    }
   public ArrayList<String> SubProcess(String word)
   {
//       if(word.equals(mainWord))
//           if(!globalResult.isEmpty())
//           globalResult.clear();
        try{
                        swara sd = new swara();
                        ArrayList<String> f = sd.process(word);
                        if (f != null) {
                           System.out.println("Swar Sandhi");
                           check(f);
                        }
                        if (f == null) {
                            yanasandhi y = new yanasandhi();//Yan sandhi
                           // f = y.process(word);
                            if (f != null) {
                                System.out.println("Yan Sandhi");
                                check(f);//jTextPane2.setText(f);
                            }
                        }
                        if (f == null) {
                            visargaSandhi vs = new visargaSandhi(); //visarga sandhi
                            String r = vs.process(word);
                            if (r != null) {
                                check(r);
                                System.out.println("Visarga Sandhi");
                                
                            }
                        }
                       
                        if (f == null) {
                            vyanjan v = new vyanjan(); //vyanjan sandhi
                           f = v.process(word);
                            if (f != null) {
                                check(f);//jTextPane2.setText(f);
                            }
                        }
        }catch(Exception e)
        {
            
        }
        return globalResult;
   }
    boolean check(ArrayList<String> wordList) {
        
        Collections.sort(wordList);
        String[] arr;
        for(int i=wordList.size()-1;i>=0;i--)
        {
            System.out.println();
            arr=wordList.get(i).split(" ");
            System.out.println(wordList.get(i));
            String first = arr[1];
            String second = arr[2];
            String t = arr[0];
        
            if(t.equals("T"))
            {
                System.out.println(first+" "+second);
                globalResult.add(first);
                globalResult.add(second);
                return true;
            }
            else
            {
                globalResult.add(first);
                SubProcess(second);
            }
                
        }
        return false;
    }
    boolean check(String word)
    {
        System.out.println();
            String[] arr=word.split(" ");
            System.out.println(word);
            String first = arr[1];
            String second = arr[2];
            String t = arr[0];
        
            if(t.equals("T"))
            {
                System.out.println(first+" "+second);
                globalResult.add(first);
                globalResult.add(second);
                return true;
            }
            else
            {
                globalResult.add(first);
                SubProcess(second);
            }
             return false;
    }
   
}

