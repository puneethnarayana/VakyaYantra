package Sandhis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import wordProcessor.*;

/**
 *
 * @author Priya
 */
public class Swar { //Deerga, Guna, Vriddi Sandhis

    String[][] rules;

    public Swar() {
        rules = new String[30][4];
        list();
        System.out.println("\u093E \u0940 \u0942 \u0948 \u094c \u0947 \u094b \u0930\u094d \u0932\u094d");
    }

    public void list() { // first column is swara, second column is vowel and third is swara.Eg 'ा','आ','ा'
        rules[0][0] = "\u093E"; rules[0][1] = "\u0906"; rules[0][2] = "\u093E"; rules[0][3]="savarna Deerga"; //('आ','आ','आ'); 
        rules[1][0] = "";       rules[1][1] = "\u0906"; rules[1][2] = "\u093E"; rules[1][3]="savarna Deerga"; // ('अ','आ','आ');
        rules[2][0] = "\u093E"; rules[2][1] = "\u0905"; rules[2][2] = "\u093E"; rules[2][3]="savarna Deerga"; //('आ','अ','आ');
        rules[3][0] = "";       rules[3][1] = "\u0905"; rules[3][2] = "\u093E"; rules[3][3]="savarna Deerga"; //('अ','अ','आ');
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
    ArrayList<String> left = new ArrayList<String>();
    ArrayList<String> right = new ArrayList<String>();
    String first, second;
    String first1, second1;
    public ArrayList<String> globalResult = new ArrayList<String>();
    String[] swaras1 ={"\u093E","\u0940","\u0942","\u0948","\u094c","\u0947","\u094b","\u0930\u094d","\u0932\u094d"}; //{"ा", "ी","ू","ै","ौ","े", "ो","र्","ल्"};
    String mainWord;

    public String process(String word) throws SQLException {

        int i, j = 0;

        mainWord = word;
        boolean fl = false;

        if (!fl) {
            fl = splitFunction(word);         //guna Sandhi
            if (fl) {
                String result = globalResult.get(0);
                
                for (i = 1; i < globalResult.size(); i++) {
                    
                    result = result + " " + globalResult.get(i);
                }
                return result;
            }
        }

        return null;
    }
    boolean flag = false;

    boolean gunasandhi(String word, int count) throws SQLException {
        String d = swaras1[count];
        int index = 0;

        if (d != null) {
            index = word.indexOf(d);
        }

        if (index != -1) {
            first = (String) word.subSequence(0, index);


            if (d.equals("र्") || d.equals("ल्")) {
                second = (String) word.subSequence(index + 2, word.length());
            } else {
                second = (String) word.subSequence(index + 1, word.length());
            }
            System.out.println("words" + " " + first + " " + second);
            connect c = new connect();
            ResultSet S = null, s1 = null;
            String r, q, q2;
            r = first;
            try {

                db dbObject = new db();
                String meaning;
                meaning = dbObject.findMeaning(r);
                if (meaning != null) {
                    left.add(r);
                }
                q = "select meaning,word from Dict where word like '" + r + "_'";
                r = second;
                q2 = "select meaning,word from Dict where word like '_" + r + "'";
                S = c.getResult(q);
                s1 = c.getResult(q2);

                while (S.next()) {
                    left.add(S.getString(2));
                   
                }

                while (s1.next()) {
                    right.add(s1.getString(2));

                }

            } catch (Exception e) {
            } finally {
                c.closeConnection();
            }

            flag = map(left, right, d, first, second);
            if (flag) {
                return true;
            }
        }


        return false;
    }

    boolean splitFunction(String word) throws SQLException {

        flag = false;
        int count = 0;
        while (count < 9) {
            if (mainWord != null && mainWord.equals(word)) {
                if (!globalResult.isEmpty()) {
                    globalResult.clear();
                }
            }
            if (gunasandhi(word, count)) {
                return true;
            }
            count++;
        }
        return false;
    }
    boolean f = false;

    boolean map(ArrayList<String> left, ArrayList<String> right, String swara, String first, String second) throws SQLException {
        boolean flag1 = false, flag2 = false;
        
        String app1 = null, app2 = null, q1;
        
        try {
            for (int i = 0; i < 30; i++) {
                if (rules[i][2].equals(swara)) {
                    flag1 = flag2 = false;
                    app1 = rules[i][0];
                    app2 = rules[i][1];


                    first1 = first + app1;

                    if (flag1 == false) {
                        flag1 = check(left, first1);
                    }

                    second1 = app2 + second;
//System.out.println(first1+" "+second1);
                    flag2 = check(right, second1);
                    if (flag1 && flag2) {
                            System.out.println("true0");
                        if (!globalResult.contains(first1)) {
                            globalResult.add(first1);
                        }
                        globalResult.add(second1);

                        return true;
                    } else if (flag1 && !flag2) {
                        if (!globalResult.contains(first1)) {
                            globalResult.add(first1);
                        }
                        f = splitFunction(second1);
                        if (f) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
        } finally {
         
        }
        return false;
    }

    boolean check(ArrayList<String> al, String word) {
        boolean checkflag = false;
        for (int i = 0; i < al.size() && !checkflag; i++) {
            if (word.equals(al.get(i))) {
                System.out.println("success" + word + " " + al.get(i));
                checkflag = true;
            }
        }
        return checkflag;
    }
}

//public class Swar {
//
//    public static void main(String args[]) throws SQLException {
//        swarSandhi sd = new swarSandhi();
//        String result = sd.process("जलौघः");//महालय");//कवीशः");//भानूदयः
//        System.out.println(resu lt); //कवि ईशः");//भानु उदयः
//    }
//}
