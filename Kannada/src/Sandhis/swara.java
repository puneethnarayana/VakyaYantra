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
        rules = new String[31][4];
        list();
        System.out.println("\u0CBE \u0940 \u0942 \u0CC8 \u0CCC \u0947 \u094b \u0930\u094d \u0932\u094d");
    }

    public void list() { // first column is swaraa, second column is vowel and third is swaraa.Eg 'ा','आ','ा'
        rules[0][0] = "\u0CBE"; rules[0][1] = "\u0C85"; rules[0][2] = "\u0CBE"; rules[0][3]="savarna Deerga"; //('आ','अ','आ');
        rules[1][0] = "";       rules[1][1] = "\u0C85"; rules[1][2] = "\u0CBE"; rules[1][3]="savarna Deerga"; //('अ','अ','आ');
        rules[2][0] = "\u0CBE"; rules[2][1] = "\u0C86"; rules[2][2] = "\u0CBE"; rules[2][3]="savarna Deerga"; //('आ','आ','आ'); 
        rules[3][0] = "";       rules[3][1] = "\u0C86"; rules[3][2] = "\u0CBE"; rules[3][3]="savarna Deerga"; // ('अ','आ','आ');
        
        rules[4][0] = "\u0CBF"; rules[4][1] = "\u0C87"; rules[4][2] = "\u0CC0"; rules[4][3]="savarna Deerga"; //('इ','ई','ई');
        rules[5][0] = "\u0CC0"; rules[5][1] = "\u0C88"; rules[5][2] = "\u0CC0"; rules[5][3]="savarna Deerga"; //('ई','ई','ई');
        rules[6][0] = "\u0CC0"; rules[6][1] = "\u0C87"; rules[6][2] = "\u0CC0"; rules[6][3]="savarna Deerga"; //('ई','इ','ई');
        rules[7][0] = "\u0CBF"; rules[7][1] = "\u0987"; rules[7][2] = "\u0CC0"; rules[7][3]="savarna Deerga"; // ('इ','इ','ई');
        rules[8][0] = "\u0CC1"; rules[8][1] = "\u0C89"; rules[8][2] = "\u0CC2"; rules[8][3]="savarna Deerga"; //('उ','उ','ऊ');
        rules[9][0] = "\u0CC2"; rules[9][1] = "\u0C8A"; rules[9][2] = "\u0CC2"; rules[9][3]="savarna Deerga"; // ('ऊ','ऊ','ऊ');
        rules[10][0] = "\u0CC1"; rules[10][1] = "\u0C8A"; rules[10][2] = "\u0CC2"; rules[10][3]="savarna Deerga"; //('उ','ऊ','ऊ');
        rules[11][0] = "\u0CC2"; rules[11][1] = "\u0C89"; rules[11][2] = "\u0CC2"; rules[11][3]="savarna Deerga"; // ('ऊ','उ','ऊ');
        
        rules[12][0] = ""; rules[12][1] = "\u0C88"; rules[12][2] = "\u0CC7"; rules[12][3]="Guna "; //आ','इ','ए '
        rules[13][0] = "\u0CBE"; rules[13][1] = "\u0C88"; rules[13][2] = "\u0CC7"; rules[13][3]="Guna"; //आ','ई','ए '
        rules[14][0] = "\u0CBE";       rules[14][1] = "\u0C87"; rules[14][2] = "\u0CC7"; rules[14][3]="Guna"; //('अ','ई','ए')
        rules[15][0] = "";       rules[15][1] = "\u0C87"; rules[15][2] = "\u0CC7"; rules[15][3]="Guna"; //अ','इ','ए ');
        rules[16][0] = "";       rules[16][1] = "\u0C89"; rules[16][2] = "\u0CCB"; rules[16][3]="Guna"; //('अ','उ','ओ');
        rules[17][0] = "\u0CBE"; rules[17][1] = "\u0C89"; rules[17][2] = "\u0CCB"; rules[17][3]="Guna"; //आ','उ','ओ');
        rules[18][0] = "\u0CBE"; rules[18][1] = "\u0C8a"; rules[18][2] = "\u0CCB"; rules[18][3]="Guna"; //('आ','ऊ','ओ');
        rules[19][0] = "";       rules[19][1] = "\u0C8a"; rules[19][2] = "\u0CCB"; rules[19][3]="Guna"; // ('अ','ऊ','ओ');
        rules[20][0] = "";       rules[20][1] = "\u0C8b"; rules[20][2] = "\u0CB0\u0CCd"; rules[20][3]="Guna"; //('अ','ऋ','अर्');
        rules[21][0] = "\u0CBE"; rules[21][1] = "\u0C8b"; rules[21][2] = "\u0CB0\u0CCd"; rules[21][3]="Guna"; // ('आ','ऋ','अर्');
        
        rules[22][0] = "";       rules[22][1] = "\u0C8f"; rules[22][2] = "\u0CC8"; rules[22][3]="Vriddi"; //('अ','ए','ऐ');
        rules[23][0] = "";       rules[23][1] = "\u0C90"; rules[23][2] = "\u0CC8"; rules[23][3]="Vriddi"; // ('अ','ऐ','ऐ');
        rules[24][0] = "\u0CBE"; rules[24][1] = "\u0C90"; rules[24][2] = "\u0CC8"; rules[24][3]="Vriddi"; //('आ','ऐ','ऐ');
        rules[25][0] = "\u0CBE"; rules[25][1] = "\u0C8e"; rules[25][2] = "\u0CC8"; rules[25][3]="Vriddi"; // ('आ','ए','ऐ');
        rules[26][0] = "";       rules[26][1] = "\u0C92"; rules[26][2] = "\u0CCC"; rules[26][3]="Vriddi"; //('अ','ओ','औ');
        rules[27][0] = "";       rules[27][1] = "\u0C94"; rules[27][2] = "\u0CCC"; rules[27][3]="Vriddi"; // ('अ','औ','औ');
        rules[28][0] = "\u0CBE"; rules[28][1] = "\u0C92"; rules[28][2] = "\u0CCC"; rules[28][3]="Vriddi"; // ('आ','ओ','औ');
        rules[29][0] = "\u0CBE"; rules[29][1] = "\u0C94"; rules[29][2] = "\u0CCC"; rules[29][3]="Vriddi"; //('आ','औ','औ');
        rules[30][0]=""  ; rules[30][1]="\u0c85"; rules[30][2]="\u0caf"; rules[30][3]="yakaraagama";
        	
        	}
   
    String first, second;
    String first1, second1;
    public ArrayList<String> result = new ArrayList<String>();
    String[] swaraas1 ={"\u0caf","\u0CBE","\u0CC0","\u0CC2","\u0CC8","\u0CCB","\u0CCC","\u0cc6","\u0CC7","\u0cca","\u0CB0\u0CCD","\u0CB2\u0CCD"}; 
    //{"ा", "ी","ू","ै","ौ","े", "ो","र्","ल्"};
   
    
    boolean flag = false;

   ArrayList<String> process(String word) throws SQLException {
        int count=0;
         while (count < 10) {
        String d = swaraas1[count];
        int index = 0;
        
        int fromindex = 0;
        while (fromindex <= word.length() && index != -1) {
            if (d != null) {
               // System.out.println(d);
            	index = word.indexOf(d, fromindex);
                //System.out.println("index" + index);
            }
            	
            if (index != -1) {
                first = (String) word.subSequence(0, index);
                System.out.println(first);
                if (d.equals("ರ್") || d.equals("ಲ್")) {
                    second = (String) word.subSequence(index + 2, word.length());
                } else {
                    second = (String) word.subSequence(index + 1, word.length());
                }
                System.out.println("words" + " " + first + " " + second);

                for (int i = 0; i < 31; i++) {
                    if(flag==true){
                    	break;
                    }
                	if (rules[i][2].equals(d)) {
                        

                        first1 = first + rules[i][0];
                        System.out.println("first1"+" "+first1);
                        second1 = rules[i][1] + second;
                        System.out.println("second1"+" "+second1);
                       /* db ob=new db();
                        if (ob.findMeaning(first1) != null && ob.findMeaning(second1) != null) {
                               flag = true;
                               result.add("T"+" "+first1+" "+second1);
                        }
                        else if(ob.findMeaning(first1) != null)
                        {
                            result.add("F"+" "+first1+" "+second1);
                        }*/
                System.out.println(first1+" "+second1);
                        flag = true;
                        result.add("T"+" "+first1+" "+second1);
                
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
