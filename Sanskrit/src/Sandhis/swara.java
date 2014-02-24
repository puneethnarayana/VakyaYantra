package Sandhis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import wordProcessor.*;

/**
 *
 * @author Priya
 */
class swara { //Deerga, Guna, Vriddi Sandhis

    String[][] rules;

    public swara() {
        rules = new String[30][4];
        list();
        System.out.println("\u093E \u0940 \u0942 \u0948 \u094c \u0947 \u094b \u0930\u094d \u0932\u094d");
    }

    public void list() { // first column is swaraa, second column is vowel and third is swaraa.Eg 'ा','आ','ा'
        rules[0][0] = "\u093E"; rules[0][1] = "\u0905"; rules[0][2] = "\u093E"; rules[0][3]="savarna Deerga"; //('आ','अ','आ');
        rules[1][0] = "";       rules[1][1] = "\u0905"; rules[1][2] = "\u093E"; rules[1][3]="savarna Deerga"; //('अ','अ','आ');
        rules[2][0] = "\u093E"; rules[2][1] = "\u0906"; rules[2][2] = "\u093E"; rules[2][3]="savarna Deerga"; //('आ','आ','आ'); 
        rules[3][0] = "";       rules[3][1] = "\u0906"; rules[3][2] = "\u093E"; rules[3][3]="savarna Deerga"; // ('अ','आ','आ');
        
        rules[4][0] = "\u093F"; rules[4][1] = "\u0908"; rules[4][2] = "\u0940"; rules[4][3]="savarna Deerga"; //('इ','ई','ई');
        rules[5][0] = "\u0940"; rules[5][1] = "\u0908"; rules[5][2] = "\u0940"; rules[5][3]="savarna Deerga"; //('ई','ई','ई');
        rules[6][0] = "\u0940"; rules[6][1] = "\u0907"; rules[6][2] = "\u0940"; rules[6][3]="savarna Deerga"; //('ई','इ','ई');
        rules[7][0] = "\u093F"; rules[7][1] = "\u0907"; rules[7][2] = "\u0940"; rules[7][3]="savarna Deerga"; // ('इ','इ','ई');
        rules[8][0] = "\u0941"; rules[8][1] = "\u0909"; rules[8][2] = "\u0942"; rules[8][3]="savarna Deerga"; //('उ','उ','ऊ');
        rules[9][0] = "\u0942"; rules[9][1] = "\u090a"; rules[9][2] = "\u0942"; rules[9][3]="savarna Deerga"; // ('ऊ','ऊ','ऊ');
        rules[10][0] = "\u0941"; rules[10][1] = "\u090a"; rules[10][2] = "\u0942"; rules[10][3]="savarna Deerga"; //('उ','ऊ','ऊ');
        rules[11][0] = "\u0942"; rules[11][1] = "\u0909"; rules[11][2] = "\u0942"; rules[11][3]="savarna Deerga"; // ('ऊ','उ','ऊ');
        
        rules[12][0] = "\u093E"; rules[12][1] = "\u0907"; rules[12][2] = "\u0947"; rules[12][3]="Guna "; //आ','इ','ए '
        rules[13][0] = "\u093E"; rules[13][1] = "\u0908"; rules[13][2] = "\u0947"; rules[13][3]="Guna"; //आ','ई','ए '
        rules[14][0] = "";       rules[14][1] = "\u0908"; rules[14][2] = "\u0947"; rules[14][3]="Guna"; //('अ','ई','ए')
        rules[15][0] = "";       rules[15][1] = "\u0907"; rules[15][2] = "\u0947"; rules[15][3]="Guna"; //अ','इ','ए ');
        rules[16][0] = "";       rules[16][1] = "\u0909"; rules[16][2] = "\u094b"; rules[16][3]="Guna"; //('अ','उ','ओ');
        rules[17][0] = "\u093E"; rules[17][1] = "\u0909"; rules[17][2] = "\u094b"; rules[17][3]="Guna"; //आ','उ','ओ');
        rules[18][0] = "\u093E"; rules[18][1] = "\u090a"; rules[18][2] = "\u094b"; rules[18][3]="Guna"; //('आ','ऊ','ओ');
        rules[19][0] = "";       rules[19][1] = "\u090a"; rules[19][2] = "\u094b"; rules[19][3]="Guna"; // ('अ','ऊ','ओ');
        rules[20][0] = "";       rules[20][1] = "\u090b"; rules[20][2] = "\u0930\u094d"; rules[20][3]="Guna"; //('अ','ऋ','अर्');
        rules[21][0] = "\u093E"; rules[21][1] = "\u090b"; rules[21][2] = "\u0930\u094d"; rules[21][3]="Guna"; // ('आ','ऋ','अर्');
        
        rules[22][0] = "";       rules[22][1] = "\u090f"; rules[22][2] = "\u0948"; rules[22][3]="Vriddi"; //('अ','ए','ऐ');
        rules[23][0] = "";       rules[23][1] = "\u0910"; rules[23][2] = "\u0948"; rules[23][3]="Vriddi"; // ('अ','ऐ','ऐ');
        rules[24][0] = "\u093E"; rules[24][1] = "\u0910"; rules[24][2] = "\u0948"; rules[24][3]="Vriddi"; //('आ','ऐ','ऐ');
        rules[25][0] = "\u093E"; rules[25][1] = "\u090f"; rules[25][2] = "\u0948"; rules[25][3]="Vriddi"; // ('आ','ए','ऐ');
        rules[26][0] = "";       rules[26][1] = "\u0913"; rules[26][2] = "\u094c"; rules[26][3]="Vriddi"; //('अ','ओ','औ');
        rules[27][0] = "";       rules[27][1] = "\u0914"; rules[27][2] = "\u094c"; rules[27][3]="Vriddi"; // ('अ','औ','औ');
        rules[28][0] = "\u093E"; rules[28][1] = "\u0913"; rules[28][2] = "\u094c"; rules[28][3]="Vriddi"; // ('आ','ओ','औ');
        rules[29][0] = "\u093E"; rules[29][1] = "\u0914"; rules[29][2] = "\u094c"; rules[29][3]="Vriddi"; //('आ','औ','औ');
        
       
    }
   
    String first, second;
    String first1, second1;
    public ArrayList<String> result = new ArrayList<String>();
    String[] swaraas1 ={"\u093E","\u0940","\u0942","\u0948","\u094c","\u0947","\u094b","\u0930\u094d","\u0932\u094d"}; 
    //{"ा", "ी","ू","ै","ौ","े", "ो","र्","ल्"};
   
    
    boolean flag = false;

   ArrayList<String> process(String word) throws SQLException {
        int count=0;
         while (count < 9) {
        String d = swaraas1[count];
        int index = 0;
        
        int fromindex = 0;
        while (fromindex <= word.length() && index != -1) {
            if (d != null) {
                index = word.indexOf(d, fromindex);
            }

            if (index != -1) {
                first = (String) word.subSequence(0, index);
                if (d.equals("र्") || d.equals("ल्")) {
                    second = (String) word.subSequence(index + 2, word.length());
                } else {
                    second = (String) word.subSequence(index + 1, word.length());
                }
                System.out.println("words" + " " + first + " " + second);

                for (int i = 0; i < 30; i++) {
                    if (rules[i][2].equals(d)) {
                        

                        first1 = first + rules[i][0];

                        second1 = rules[i][1] + second;
                        db ob=new db();
                        if (ob.findMeaning(first1) != null && ob.findMeaning(second1) != null) {
                               flag = true;
                               result.add("T"+" "+first1+" "+second1);
                        }
                        else if(ob.findMeaning(first1) != null)
                        {
                            result.add("F"+" "+first1+" "+second1);
                        }
                    }
                }
            }
            fromindex = index + 1;
        }
        count++;
         }
         if(result.size()>0)
             return result;
         else
             return null;
    }
}

/*public class swara {

    public static void main(String args[]) throws SQLException {
        swaraSandhi sd = new swaraSandhi();
        String result = sd.process("आलयास्थि");//महालय");//कवीशः");//भानूदयः
        System.out.println(result); //कवि ईशः");//भानु उदयः
    }
}*/
