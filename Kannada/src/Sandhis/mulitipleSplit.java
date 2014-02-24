package Sandhis;
import java.util.*;
import wordProcessor.db;
/**
 *
 * @author Priya
 */
public class mulitipleSplit
{
    ArrayList<String> globalResult = new ArrayList<String>();
    String mainWord;
    
    public ArrayList<String> process(String word)
    {
        mainWord = word;
        SubProcess(word);
        return(globalResult);
    }
   public boolean SubProcess(String word)
   {
//       if(word.equals(mainWord))
//           if(!globalResult.isEmpty())
//           globalResult.clear();
       boolean flag=false;
        try{
                        swara sd = new swara();
                        ArrayList<String> f = sd.process(word);
                        if (f != null) {
                           System.out.println("Swar Sandhi");
                           flag=check(f);
                        }
                        
                        if (!flag) {
                            yanasandhi y = new yanasandhi();//Yan sandhi
                            String r = y.process(word);
                            if (r != null) {
                                System.out.println("Yan Sandhi");
                                flag=check(r);//jTextPane2.setText(f);
                                System.out.println("flag="+flag);
                            }
                        }
                        
                        if (!flag) {
                            
                            visargaSandhi vs = new visargaSandhi(); //visarga sandhi
                            String r = vs.process(word);
                            if (r != null) {
                                System.out.println("Visarga Sandhi "+r);
                                flag=check(r);
                                System.out.println("Visarga Sandhi");
                            }
                        }
                       
                        if (!flag) {
                            vyanjan v = new vyanjan(); //vyanjan sandhi
                           f = v.process(word);
                            if (f != null) {
                                flag=check(f);//jTextPane2.setText(f);
                            }
                        }
        }catch(Exception e)
        {
            
        }
        return flag;
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
                if(SubProcess(second)){
                    globalResult.add(first);
                    return true;
                }
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
                if(SubProcess(second)){
                    globalResult.add(first);
                    return true;
                }
            }
             return false;
    }
   
}

