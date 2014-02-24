 package Sandhis;
import java.util.ArrayList;
import wordProcessor.db;

public class yanasandhi {
   
   ArrayList<Character> swaras = new ArrayList<Character>();
   ArrayList<Character> vowels = new ArrayList<Character>();
   ArrayList<String> yana1 = new ArrayList<String>();
   ArrayList<String> yana2 = new ArrayList<String>();
   db d;
   String first, second;
   
    public yanasandhi(){
        
        d = new db();
        
        swaras.add('ा'); swaras.add('ि');swaras.add('ी'); swaras.add('ु');swaras.add('ू');
        swaras.add('े');swaras.add('ै');swaras.add('ो');swaras.add('ौ');
        
        vowels.add('आ');vowels.add('इ');vowels.add('ई'); vowels.add('उ');
        vowels.add('ऊ');vowels.add('ए');vowels.add('ऐ'); vowels.add('ओ'); vowels.add('औ');

        yana1.add("य");
        yana1.add("य");
        yana1.add("व");
        yana1.add("व");
        
        yana2.add("इ");
        yana2.add("ई");
        yana2.add("उ");
        yana2.add("ऊ");
    }
    
    ArrayList<String> left = new ArrayList<String>();
    ArrayList<String> right = new ArrayList<String>();
    ArrayList<String> finalres = new ArrayList<String>();
    String mainWord;
    
     Character findSwaras(Character a)
    {
        boolean istrue =  false;
        System.out.println("Char received ="+a);
        int index=0;
        
        for(int i =0 ;i<vowels.size() && !istrue ;i++)
        {
            System.out.println("Swaras = "+vowels.get(i)+" Char = "+a);
            if(vowels.get(i).compareTo(a) == 0)
            {
                
                istrue = true;
                index = i;
            }
        }
        
        if(istrue)
            return swaras.get(index);
        else
            return 'अ';
    }
        
    Character findVowel(Character a)
    {
        boolean istrue =  false;
        System.out.println("Char received ="+a);
        int index=0;
        
        for(int i =0 ;i<swaras.size() && !istrue ;i++)
        {
            System.out.println("Swaras = "+swaras.get(i)+" Char = "+a);
            if(swaras.get(i).compareTo(a) == 0)
            {
                
                istrue = true;
                index = i;
            }
        }
        
        if(istrue)
            return vowels.get(index);
        else
            return null; //'अ';
            
    }

    public String process(String word) {
        String f = null;
        f = rule1(word);
        return f;
    }
    
    String rule1(String word) {
        boolean flag = false;
        int count = 0, index,preindex=0 , inncnt=0,loopcnt = 0;
        String first1,second1;
        String[] temp = new String[2];
        
        
        String cur = null;
        Character ch,newval=null;
        inncnt = 0;
        
        while(flag == false && count<yana1.size() && loopcnt < 10)
        {
            index = word.indexOf(yana1.get(count),preindex);
            preindex=index+1;
            System.out.println("Index ="+index);
            
            while(index!=-1 && index != 0 && index+1 < word.length() )
             //if (index != -1 && index != 0 && index+1 < word.length()-1) 
             {
                inncnt++;
                cur = yana1.get(count);
            //    temp = word.split(cur);
                
   //             first = temp[0];
   //             second = temp[1];
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                
                System.out.println("First  ="+first);
                System.out.println("Second  ="+second);
                
                ch = yana2.get(count).charAt(0);
                newval = findSwaras(ch);
                first1 = (String)first.subSequence(0, first.length()-1) + newval; //"अ"+ 
                
                System.out.println("First 1 = "+first1);
                
                ch = second.charAt(0);
                newval = findVowel(ch);
                
                if(newval == null)
                    second1 = 'अ' + second;
                else
                    second1 = newval + (String)second.subSequence(1, second.length());
                
                System.out.println("Second 1 = "+second1);
                
                
                if (d.findMeaning(first1) != null && d.findMeaning(second1) != null) 
                {
                    finalres.add(first1);
                    finalres.add(second1);
                    flag = true;
                    System.out.println("Splits are");
                    return("T "+first1+" "+second1);
                    
                }
                else if(d.findMeaning(first1) != null)
                {
                    return("F "+first1+" "+second1);
                }
             
                index = word.indexOf(yana1.get(count),preindex);
                preindex=index+1;
                
             }
            
            if(inncnt > 0 || loopcnt>0)
                count++;
            else
                count = 0;
            
            loopcnt++;
        }
        
        return null;
    }
    
   
    
}
//public class yanasandhi {
//    
//
//    public static void main(String args[]) {
//        ysandhi vs = new ysandhi();
//        String word ="स्वाद्वोदनम्";// इत्यादि अत्याचार देव्यालाय गत्यवरोध यद्यप्यन्ग
//        
//        //यद्यपि has prob
//        
//        word=vs.process(word);
//        System.out.println("Vyanjan sandhi split = "+word);
//    }
//}