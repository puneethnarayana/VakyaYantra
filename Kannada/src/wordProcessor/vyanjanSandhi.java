package wordProcessor;

import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author priya
 */
class vSandi {
    ArrayList<String> vyanjans3 = new ArrayList<String>();
    ArrayList<String> vyanjans1 = new ArrayList<String>();
    ArrayList<Character> swaras = new ArrayList<Character>();
    ArrayList<Character> vowels = new ArrayList<Character>();
    String first, second;
    String newrule[][];
    String newrule1[][];
    String newrule2[][];
    db d;

    vSandi() {
        d = new db();
       /* swaras.add("ै");
        swaras.add("ौ");
        swaras.add("ा");
        swaras.add("ी");
        swaras.add("ू");
        swaras.add("े");
        swaras.add("ो");*/
        
        swaras.add('ा'); swaras.add('ि');swaras.add('ी'); swaras.add('ु');swaras.add('ू');
        swaras.add('े');swaras.add('ै');swaras.add('ो');swaras.add('ौ');

        vowels.add('आ');vowels.add('इ');vowels.add('ई'); vowels.add('उ');
        vowels.add('ऊ');vowels.add('ए');vowels.add('ऐ'); vowels.add('ओ'); vowels.add('औ');

        vyanjans3.add("ग");
        vyanjans3.add("ज");
        vyanjans3.add("द");
        vyanjans3.add("ब");
        vyanjans3.add("ड");

        vyanjans1.add("क्");
        vyanjans1.add("च्");
        vyanjans1.add("त्");
        vyanjans1.add("प्");
        vyanjans1.add("ट्");
        
        newrule = new String[5][3];
        
        newrule1 = new String[21][3];
        newrule2 = new String[17][3];
        // append only left, right remians the remaining word
        
        newrule1[0][0] = "क्";
        newrule1[0][1] = "द";
        newrule1[0][2] = "ग्";
        
        newrule1[1][0] = "ट्";
        newrule1[1][1] = "द";
        newrule1[1][2] = "ड्";
        
        newrule1[2][0] = "क्";
        newrule1[2][1] = "म";
        newrule1[2][2] = "ङ्"; 
        
        newrule1[3][0] = "ट्";
        newrule1[3][1] = "म";
        newrule1[3][2] = "ण्";
        
        newrule1[4][0] = "त्";
        newrule1[4][1] = "म";
        newrule1[4][2] = "न्";
        
        newrule1[5][0] = "म्";
        newrule1[5][1] = "क";
        newrule1[5][2] = "ङ्";
        
        newrule1[6][0] = "म्";
        newrule1[6][1] = "ग";
        newrule1[6][2] = "ङ्";
        
        newrule1[7][0] = "म्";
        newrule1[7][1] = "च";
        newrule1[7][2] = "ञ्";
        
        newrule1[8][0] = "म्";
        newrule1[8][1] = "ज";
        newrule1[8][2] = "ञ्";
        
        newrule1[9][0] = "म्";
        newrule1[9][1] = "त";
        newrule1[9][2] = "न्";
        
        newrule1[10][0] = "म्";
        newrule1[10][1] = "द";
        newrule1[10][2] = "न्";
        
        newrule1[11][0] = "म्";
        newrule1[11][1] = "प";
        newrule1[11][2] = "म्";
        
        newrule1[12][0] = "म्";
        newrule1[12][1] = "भ";
        newrule1[12][2] = "म्"; //done
        
        newrule1[13][0] = "म्";
        newrule1[13][1] = "य";
        newrule1[13][2] = "ं";
        
        newrule1[14][0] = "म्";
        newrule1[14][1] = "र";
        newrule1[14][2] = "ं";
        
        newrule1[15][0] = "म्";
        newrule1[15][1] = "ल";
        newrule1[15][2] = "ं";
        
        newrule1[16][0] = "म्";
        newrule1[16][1] = "व";
        newrule1[16][2] = "ं";
        
        newrule1[17][0] = "म्";
        newrule1[17][1] = "श";
        newrule1[17][2] = "ं";
        
        newrule1[18][0] = "म्";
        newrule1[18][1] = "स";
        newrule1[18][2] = "ं";
        
        newrule1[19][0] = "म्";
        newrule1[19][1] = "ह";
        newrule1[19][2] = "ं";
        
        newrule1[20][0] = "त्";
        newrule1[20][1] = "भ";
        newrule1[20][2] = "द्";
        
        //APPEND LEFT AND RIGHT, no more comparison
        
        newrule2[0][0] = "क्";
        newrule2[0][1] = "ग";
        newrule2[0][2] = "ग्ग";
        
        newrule2[1][0] = "क्";
        newrule2[1][1] = "भ्";
        newrule2[1][2] = "ग्भ";
       
        newrule2[2][0] = "क्";
        newrule2[2][1] = "ज";
        newrule2[2][2] = "ग्ज";
        
        newrule2[3][0] = "त्";
        newrule2[3][1] = "घ";
        newrule2[3][2] = "द्";
        
        newrule2[4][0] = "त्";
        newrule2[4][1] = "य";
        newrule2[4][2] = "द्य";
        
        newrule2[5][0] = "त्";
        newrule2[5][1] = "ध";
        newrule2[5][2] = "द्ध";
        
        newrule2[6][0] = "प";
        newrule2[6][1] = "ज";
        newrule2[6][2] = "ब्ज";
        
        newrule2[7][0] = "त्";
        newrule2[7][1] = "न";
        newrule2[7][2] = "न्न";
        
        newrule2[8][0] = "प";
        newrule2[8][1] = "म";
        newrule2[8][2] = "म्म";  
        
        newrule2[9][0] = "त्";
        newrule2[9][1] = "च";
        newrule2[9][2] = "च्च"; 
        
        newrule2[10][0] = "त्";
        newrule2[10][1] = "छ";
        newrule2[10][2] = "च्छ"; 
        
        newrule2[11][0] = "त्";
        newrule2[11][1] = "ज";
        newrule2[11][2] = "ज्ज";
        
        newrule2[12][0] = "त्";
        newrule2[12][1] = "ट";
        newrule2[12][2] = "ट्ट";
        
        newrule2[13][0] = "त्";
        newrule2[13][1] = "ड";
        newrule2[13][2] = "ड्ड"; 
        
        newrule2[14][0] = "त्";
        newrule2[14][1] = "ल";
        newrule2[14][2] = "ल्ल";
        
        newrule2[15][0] = "त्";
        newrule2[15][1] = "श";
        newrule2[15][2] = "च्छ";
        
        newrule2[16][0] = "त्";
        newrule2[16][1] = "ह";
        newrule2[16][2] = "द्ध"; 
        
        
        
        
        
        
        newrule[0][0] = "क्";
        newrule[0][1] = "अ";
        newrule[0][2] = "ग";
             
        newrule[1][0] = "च्";
        newrule[1][1] = "अ";
        newrule[1][2] = "ज";
        
        newrule[2][0] = "त्";
        newrule[2][1] = "अ";
        newrule[2][2] = "द";
        
        newrule[3][0] = "प्";
        newrule[3][1] = "अ";
        newrule[3][2] = "ब";
        
        newrule[4][0] = "ट्";
        newrule[4][1] = "अ";
        newrule[4][2] = "ड";
        
               
      //  ""
      //  ""
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
            return null;//'अ';
            
    }
    
    String process(String word) {
        String f = null;
        f = rule1(word);
        if (f==null) {
            f=rule2(word);
        }
        if(f==null)
            f=rule3(word);
        return f;
    }
    
    String rule2(String word){
    
        boolean flag = false;
        int count = 0, index=0,preindex=0,incnt=0,loopcnt=0;
        Character ch;
        Character newval=null;
        ArrayList<String> finalres = new ArrayList<String>();
        
        
        while (flag == false && count < 17 ) 
        {
            System.out.println("Newrul = "+newrule2[count][2]);
            
            index = word.indexOf(newrule2[count][2],preindex);
            preindex = index+1;
            System.out.println("Index ="+index);
            while(index!=-1 && index != 0 && index+1 < word.length() )
            {
                incnt++;
            
                String first1, second1;
                first = (String) word.subSequence(0, index);
                int wlen = newrule2[count][2].length();
                second = (String) word.subSequence(index + wlen, word.length());
                
                first1 = first + newrule2[count][0];
                second1 = newrule2[count][1] + second;
                
              /*  
                ch = second.charAt(0);
                newval = findVowel(ch);
                
                if(newval == null)
                    second1 = 'अ' + second;
                else
                    second1 = newval + (String)second.subSequence(1, second.length());
                */
                //second1= newrule[1][count] + second;
                System.out.println(first1+" "+second1);
                
                if (d.findMeaning(first1) != null && d.findMeaning(second1) != null)  
                {
                   // System.out.println(first1 + " " + second1);
                    //JOptionPane.showMessageDialog(null, first1+"+"+second1);
                    finalres.add(first1);
                    finalres.add(second1);
                    System.out.println("Splits are");
                    for(int i=0;i<finalres.size();i++)
                        System.out.println(i+" = "+finalres.get(i));
                    flag = true;
                    return (first1+" "+second1);
                }
                
              /*  if(d.findMeaning(first1) != null)
                {
                    System.out.println("Only first = "+first1);
                    finalres.add(first1);
                    word=second1;
                    System.out.println("New word = "+word);
                    count = 0;
                    for(int i=0;i<finalres.size();i++)
                        System.out.println(i+" = "+finalres.get(i));
                    preindex = 0;
                }*/
                index = word.indexOf(newrule2[count][2],preindex);
                preindex = index+1;
                System.out.println("Index ="+index);
            }
            //}
            if(incnt > 0 || loopcnt >0)
                count++;
            else
                count = 0;
            
            loopcnt++;
        }
        return null;
        
    }
    
    
    String rule1(String word){
        boolean flag = false;
        int count = 0, index=0,preindex=0,incnt=0,loopcnt=0;
        Character ch;
        Character newval=null;
        ArrayList<String> finalres = new ArrayList<String>();
        
        
        while (flag == false && count < 21 ) 
        {
            System.out.println("Newrul = "+newrule1[count][2]);
            
            index = word.indexOf(newrule1[count][2],preindex);
            preindex = index+1;
            System.out.println("Index ="+index);
            while(index!=-1 && index != 0 && index+1 < word.length() )
            {
                incnt++;
            
                String first1, second1;
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                first1 = first + newrule1[count][0];
                second1 = second;
              /*  ch = second.charAt(0);
                newval = findVowel(ch);
                
                if(newval == null)
                    second1 = 'अ' + second;
                else
                    second1 = newval + (String)second.subSequence(1, second.length());*/
                
                //second1= newrule[1][count] + second;
                System.out.println(first1+" "+second1);
                
                if (d.findMeaning(first1) != null && d.findMeaning(second1) != null)  
                {
                   // System.out.println(first1 + " " + second1);
                    //JOptionPane.showMessageDialog(null, first1+"+"+second1);
                    finalres.add(first1);
                    finalres.add(second1);
                    System.out.println("Splits are");
                    for(int i=0;i<finalres.size();i++)
                        System.out.println(i+" = "+finalres.get(i));
                    flag = true;
                    return (first1+" "+second1);
                }
                
            /*    if(d.findMeaning(first1) != null)
                {
                    System.out.println("Only first = "+first1);
                    finalres.add(first1);
                    word=second1;
                    System.out.println("New word = "+word);
                    count = 0;
                    for(int i=0;i<finalres.size();i++)
                        System.out.println(i+" = "+finalres.get(i));
                    preindex = 0;
                }*/
                index = word.indexOf(newrule1[count][2],preindex);
                preindex = index+1;
                System.out.println("Index ="+index);
            }
            //}
           if(incnt > 0 || loopcnt>0)
                count++;
            else
                count = 0;
            
            loopcnt++;
        }
        return null;
    }
    
    String rule3(String word){
        boolean flag = false;
        int count = 0, index=0,preindex=0,incnt=0,loopcnt=0;
        Character ch;
        Character newval=null;
        ArrayList<String> finalres = new ArrayList<String>();
        
        
        while (flag == false && count < 5 ) 
        {
            System.out.println("Newrul = "+newrule[count][2]);
            
            index = word.indexOf(newrule[count][2],preindex);
            preindex = index+1;
            System.out.println("Index ="+index);
            while(index!=-1 && index != 0 && index+1 < word.length() )
            {
                incnt++;
            
                String first1, second1;
                first = (String) word.subSequence(0, index);
                second = (String) word.subSequence(index + 1, word.length());
                first1 = first + newrule[count][0];
                
                ch = second.charAt(0);
                
                if(ch == '्')
                    second1 = (String)second.subSequence(1, second.length());
                else
                {    
                    newval = findVowel(ch);
                    if(newval == null)
                        second1 = 'अ' + second;
                    else
                        second1 = newval + (String)second.subSequence(1, second.length());
                
                }
                
                //second1= newrule[1][count] + second;
                System.out.println(first1+" "+second1);
                
                if (d.findMeaning(first1) != null && d.findMeaning(second1) != null)  
                {
                   // System.out.println(first1 + " " + second1);
                    //JOptionPane.showMessageDialog(null, first1+"+"+second1);
                    finalres.add(first1);
                    finalres.add(second1);
                    System.out.println("Splits are");
                    for(int i=0;i<finalres.size();i++)
                        System.out.println(i+" = "+finalres.get(i));
                    flag = true;
                    return (first1+" "+second1);
                }
                
             /*   if(d.findMeaning(first1) != null)
                {
                    System.out.println("Only first = "+first1);
                    finalres.add(first1);
                    word=second1;
                    System.out.println("New word = "+word);
                    count = 0;
                    for(int i=0;i<finalres.size();i++)
                        System.out.println(i+" = "+finalres.get(i));
                    preindex = 0;
                } */
                index = word.indexOf(newrule[count][2],preindex);
                preindex = index+1;
                System.out.println("Index ="+index);
            }
            //}
            if(incnt > 0 || loopcnt>0)
                count++;
            else
                count = 0;
            
            loopcnt++;
        }
        return null;
    }
}

public class vyanjanSandhi {
    public static void main(String args[]) {
        vSandi vs = new vSandi();
        String word ="ताञ्जय";//"सद्भवति";///"सुबन्तः";//"दिगम्बरः";//दिगम्बरः//////तदानय//मदङ्के////वागीश दिगम्बरः "वग्घरिः";//"दिक्पालः";//"सद्भवति";///"सुबन्तः";//"दिगम्बरः" तदानय//मदङ्के////सभ्दवति
        word=vs.process(word);
        System.out.println("Vyanjan sandhi split = "+word);
    }
}
