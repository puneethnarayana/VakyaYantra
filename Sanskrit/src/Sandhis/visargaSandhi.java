package Sandhis;
import java.util.*;
import wordProcessor.db;
/**
 *
 * @author priya
 */
public class visargaSandhi {

    String first, second;
    ArrayList<Character> swaras = new ArrayList<Character>();
    String result = null;
    ArrayList<Character> vowels = new ArrayList<Character>();
    db d;
    public visargaSandhi() {
         d = new db();
        swaras.add('ा'); swaras.add('ि'); swaras.add('ी'); swaras.add('ु'); swaras.add('ू');
        swaras.add('े');swaras.add('ै'); swaras.add('ो');swaras.add('ौ');

        vowels.add('आ');vowels.add('इ');vowels.add('ई'); vowels.add('उ');
        vowels.add('ऊ');vowels.add('ए');vowels.add('ऐ'); vowels.add('ओ'); vowels.add('औ');

    }
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
    public String process(String word) {
        String f=null;
        String[] temp = new String[2];
        String first1,second1;
        int index = 0;
        if ((index = word.indexOf("ो")) != -1) //rule1: अ + : + Soft consonant(SC) or अ => अ: -> ओ , if अ-> ऽ(avagraha)
        {
            
            if ((index = word.indexOf("ऽ")) != -1)
            {
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                first1=first.subSequence(0, index - 1) + "ः";
                second1="अ" + second;
                f=display(first1,second1);
            } 
            else
            {
               
                index = word.indexOf("ो");
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                first1=first+ "ः";
                second1=second;
                 //System.out.println(first1+"ppin  मःppinरथ "+second1);
                f=display(first1,second1);
            }
            if(f!=null)
                return f;
        }
        if ((index = word.indexOf("र्")) != -1) //Rule 4a: Vowels(except अ,आ) + : + SC or V => र्
        {
           System.out.println("in");
            first = (String) word.subSequence(0, index);
            second = (String) word.subSequence(index + 2, word.length());
            char ch = word.charAt(first.length() - 1);
            if (swaras.contains(ch) && first.charAt(0) != 'ा')
            {
                first = first + "ः";
            }
            f=display(first,second);
            if(f!=null)
                return f;
        }
        if ((index = word.indexOf("र")) != -1) //Rule 4a: Vowels(except अ,आ) + : + SC or V => र्
        {
            
            boolean flag=false;
            int count = 0;
            count = word.split("र").length;
            do
            {
           
            first = (String) word.subSequence(0, index);
            second = (String) word.subSequence(index + 1, word.length());
           
            if (first.length()>0 && second.length()>0) {
                char ch = first.charAt(first.length() - 1);
                if (swaras.contains(ch) && first.charAt(0) != 'ा') {
                    first = first + "ः";
                }
                ch = second.charAt(0);
                if (swaras.contains(ch)) {
                    StringBuilder s = new StringBuilder(second);
                    s.setCharAt(0, getVowel(ch));
                    second = s.toString();
                }
                f = display(first, second);
                if(f!=null) flag=true;
            }
            count--;
            index = word.indexOf("र",index+1);
            }while(count > 0 && flag==false && index!=-1);
            if(f!=null)
                return f;
        }
        if ((index = word.indexOf("ी")) != -1 || (index = word.indexOf("ा")) != -1 || (index = word.indexOf("ू")) != -1)
        {                                  //Rule 4b. drops : ,if preceding vowel is short becomes long!
            if (word.length() - 1 >= index + 1) {
                if (word.charAt(index + 1) == 'र') {

                    if (word.charAt(index) == 'ी') {
                        first1=word.substring(0, index) + "ि" + "ः" ;
                        second1=word.substring(index + 1, word.length());
                        f=display(first1,second1);
                        return f;
                    } else if (word.charAt(index) == 'ा') {
                        first1= word.substring(0, index) + "ः" ;
                        second1=word.substring(index + 1, word.length());
                        f=display(first1,second1);
                    } else if (word.charAt(index) == 'ू') {
                        first1=  word.substring(0, index) + "ु" + "ः";
                        second1=word.substring(index + 1, word.length());
                        f=display(first1,second1);
                    }
                }
            }
            if(f!=null)
                return f;
        }
        if ((index = word.indexOf("श्")) != -1) {
            boolean flag = false;
            int count = 0;
            count = word.split("श्").length;
            System.out.println("in");
            do {
                if (word.charAt(index + 2) == 'च' || word.charAt(index + 2) == 'छ'|| word.charAt(index + 2) == 'श') {
                    first1 = word.substring(0, index) + "ः";
                    second1 = word.substring(index + 2, word.length());
                    f = display(first1, second1);
                }
                count--;
                index = word.indexOf("श्", index + 1);
            } while (count > 0 && flag == false && index != -1);
            if(f!=null)
                return f;
        }
        
        if ((index = word.indexOf("ष्")) != -1) {
            boolean flag = false;
            int count = 0;
            count = word.split("ष्").length;
            System.out.println("in");
            do {
                if (word.charAt(index + 2) == 'ट' || word.charAt(index + 2) == 'ठ'|| word.charAt(index + 2) == 'ष') {
                    first1 = word.substring(0, index) + "ः";
                    second1 = word.substring(index + 2, word.length());
                    f = display(first1, second1);
                }
                count--;
                index = word.indexOf("ष्", index + 1);
            } while (count > 0 && flag == false && index != -1);
            if(f!=null)
                return f;
        }
        if ((index = word.indexOf("स्")) != -1) {
            boolean flag = false;
            int count = 0;
            count = word.split("स्").length;
            do {
                if (word.charAt(index + 2) == 'त' || word.charAt(index + 2) == 'थ' || word.charAt(index + 2) == 'स') {
                    first1 = word.substring(0, index) + "ः";
                    second1 = word.substring(index + 2, word.length());
                    f = display(first1, second1);
                }
                count--;
                index = word.indexOf("स्", index + 1);
            } while (count > 0 && flag == false && index != -1);
            if(f!=null)
                return f;
        }
        return null;
    }

    ArrayList<String> wordList = new ArrayList<String>();
    String display(String first , String second)
    {  
        if (d.findMeaning(first) != null  && d.findMeaning(second) != null) {
                    
                    return ("T"+" "+first+" "+second);
                    
                }
                else if (d.findMeaning(first) != null ){//&& d.findMeaning(second) != null) {
                    
                    return ( "F"+" "+first+" "+second);
                }
        return null;
    }
}

//public class visargaSandhi {
//
//    public static void main(String args[]) {
//        Vsandhi vs = new Vsandhi();
//        String word ="नमस्सदाशिवाय";//"मनस्सुखम्";//"जीवतश्च";//"विषयष्टिका";////"तैर्विना";//"रामोगच्छती";//मूढोऽसि"; //rule1:"मूढः असि";
//        word=vs.process(word);
//        System.out.println("ll"+word);
//    }
//}
//void process(String first, String second) {
//        char ch = first.charAt(first.length() - 1);
//        if (!swaras.contains(ch) && vowels.contains(second.charAt(0))) //rule2: अ + : +  V(vowel) (except अ) => : drops
//        {
//            first = first + "ः";
//            display(first,second);
//        } else if (ch == 'ा' && (vowels.contains(second.charAt(0)) || second.charAt(0) == 'अ'))//rule3: आ + : + (SC) or V(vowel) => : drops
//        {
//            first = first + "ः";
//            display(first,second);
//        }
//    }
//else
//            {
//                index = word.indexOf("ो");
//                first = (String) word.subSequence(0, index);
//            second = (String) word.subSequence(index + 1, word.length());
//                first1= first.subSequence(0, index) + "ः";
//                second1= second;
//               f= display(first1,second1);
//               return f;
//            }

//       if (word.charAt(index + 2) == 'ट' || word.charAt(index + 2) == 'ठ' || word.charAt(index + 2) == 'ष') {
//                if (word.charAt(index) == 'ष') {
//                    first1= word.substring(0, index) + "ः" ;
//                        second1=word.substring(index + 2, word.length());
//                        f=display(first1,second1);
//                        return f;
//                }
//            }
//            if (word.charAt(index + 2) == 'त' || word.charAt(index + 2) == 'थ' || word.charAt(index + 2) == 'स') {
//                if (word.charAt(index) == 'स') {
//                    first1= word.substring(0, index) + "ः";
//                        second1=word.substring(index + 2, word.length());
//                        f=display(first1,second1);
//                        return f;
//                }
//            }