package Sandhis;

import java.util.ArrayList;
import wordProcessor.db;

/**
 *
 * @author Priya
 */
public class vyanjan{
    String map[][] ;
   
        ArrayList<Character> swaras = new ArrayList<Character>();
        ArrayList<Character> vowels = new ArrayList<Character>();
        ArrayList<String> wordList = new ArrayList<String>();
        Character getVowel(Character a)
    {
        boolean istrue =  false;
        int index=0;
        
        for(int i =0 ;i<swaras.size() && !istrue ;i++)
        {
            if(swaras.get(i).compareTo(a) == 0)
            {
                istrue = true;
                index = i;
            }
        }
        
        if(istrue)
            return vowels.get(index);
        else
            return 'अ';
            
    }
   public vyanjan()
    {
        swaras.add('ा'); swaras.add('ि'); swaras.add('ी'); swaras.add('ु'); swaras.add('ू');
        swaras.add('े');swaras.add('ै'); swaras.add('ो');swaras.add('ौ');

        vowels.add('आ');vowels.add('इ');vowels.add('ई'); vowels.add('उ');
        vowels.add('ऊ');vowels.add('ए');vowels.add('ऐ'); vowels.add('ओ'); vowels.add('औ');
        map = new String[5][2];
        map[0][0]="क्"; map[0][1]="ग";
        map[1][0]="च्"; map[1][1]="ज";
        map[2][0]="त्"; map[2][1]="द";
        map[3][0]="प्"; map[3][1]="ब";
        map[4][0]="ट्"; map[4][1]="ड";
       
    }
    public ArrayList<String> process(String word)
    {
        boolean result=rule1(word);
        if(!result)
        {
            result = rule2(word);
        }
        if(!result)
        {
            result=rule3(word);
            System.out.print(result+" "+"rule2");
        }
        if(!result)
        {
            result=rule4(word);
            System.out.print(result+" "+"rule2");
        }
        
        if(wordList.size()>0)
            return wordList;
        else
            return null;
    }
      boolean rule1(String word) {
        boolean flag = false;
        int count = 0, index;
        String first,second;
        while (flag == false && count < 5) {
            index=word.indexOf(map[count][1]);
            if(index!=-1 && index+1<word.length()-1)
            {
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                
                
                first = first + map[count][0];

                if (swaras.contains(second.charAt(0))) {
                    char map = getVowel(second.charAt(0));
                    second = map + (String) second.subSequence(1, second.length());
                } else if (((String) second.subSequence(0, 1)).equals("्")) {
                    second = (String) second.subSequence(1, second.length());
                } else {
                    second = "अ" + second;
                }
                
                 
                flag = store(first,second);
            }
            count++;
        }
        return flag;
    }
      
    boolean rule2(String word) {
        boolean flag = false;
        int count = 0, index;
        String first,second;
        while (flag == false && count < 5) {
            index=word.indexOf(map[count][0]);
            if(index!=-1 && index+1<word.length()-1)
            {
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                
                
                first = first + map[count][1];

                if (swaras.contains(second.charAt(0))) {
                    char map = getVowel(second.charAt(0));
                    second = map + (String) second.subSequence(1, second.length());
                } else if (((String) second.subSequence(0, 1)).equals("्")) {
                    first=first+"्";
                    second = (String) second.subSequence(1, second.length());
                } else {
                    second = "अ" + second;
                }
                
                flag = store(first,second);
            }
            count++;
        }
        return flag;
    }
    
    boolean rule3(String word)
    {
        String[] vs={"च्च", "च्छ", "ज्ज", "ज्झ" ,"ट्ट", "ट्ढ" ,"ड्ड", "ड्ढ" ,"ल्ल","न्न" };
        boolean flag = false;
        int count = 0, index;
        String first="",second="";
        while (flag == false && count < 10) {
           // System.out.println(count+" "+first+" "+second);
            index=word.indexOf(vs[count]);
            if(index!=-1 && index+2<word.length()-1)
            {
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 2, word.length());
                
                first = first + "त्";
                
               flag = store(first,second);
            }
            else if(index!=-1 && count == 1 && index+3<word.length()-1)
            {
                second = (String) word.subSequence(index + 3, word.length());
                second="श"+second;
                //second.replaceAll("छ","श")
                //System.out.println(first+" "+second+" "+count+"pp");
                flag = store(first,second);
            }
            count++;
        }
            index=word.indexOf("द्ध");
            if(index!=-1 && index+2<word.length()-1 && flag==false)
            {
                first = (String) word.subSequence(0, index);
                first = first + "त्";
                second = (String) word.subSequence(index + 3, word.length());
                second="ह"+second;
                flag = store(first,second);
            }
        return flag;
    }
    boolean rule4(String word){
        int index=0;
        boolean flag=false;
        String first, second;
        index=word.indexOf("ं");
         if(index!=-1 && index+1<word.length()-1)
            {
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                
                first = first + "म्";
                
               flag = store(first,second);
            }
     return false;   
    }
    
    boolean store(String first,String second)
    {
         db d=new db();
        if (d.findMeaning(first) != null  && d.findMeaning(second) != null) {
                    
                    wordList.add("T"+" "+first+" "+second);
                    return true;
                }
                else if (d.findMeaning(first) != null ){//&& d.findMeaning(second) != null) {
                    
                    wordList.add ( "F"+" "+first+" "+second);
                }
        return false;
    }
    
}
//public class vyanjan {
//    public static void main(String args[])
//    {
//        consonantSandhi cs = new consonantSandhi();
//        System.out.println(cs.process("सम्पत्कामः"));
//    }
//}
