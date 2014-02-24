package wordProcessor;

import java.util.HashSet;

/**
 *
 * @author VAIO
 */
class sandhi {

    String poss1, poss2, actualword1, patternword1, actualword2, patternword2;
    char[] allvowels = {'ा', 'ि', 'ी', 'ो', 'ौ', 'ु', 'ू', 'ा', 'े', 'ै'};
    char[] gunavowels = {'ो', 'े'};
    char[] vriddhi = {'ै', 'ौ'};
    char[] savarna = {'ा', 'ी', 'ू', 'ऋ'};
    char[] consonent = {'क', 'ख', 'ग', 'घ', 'च', 'छ', 'ज', 'झ', 'ट', 'ठ', 'ड', 'ढ', 'त', 'न', 'थ', 'द', 'ध', 'प', 'फ', 'ब', 'भ', 'म', 'ण', 'य', 'स', 'ल', 'व', 'श', 'ष', 'र'};
    String[] yanapossibility = {"य", "या", "यु", "यू", "ये", "यै", "यौ"};
    HashSet<Character> vowels;
    HashSet<Character> gunvowels;
    HashSet<Character> savarnavowels;
    HashSet<Character> vriddhivowels;
    HashSet<Character> consonents;
    HashSet<String> yana;
    char lastbut1ofpattern1;
    char lastcharofpattern1;
    char lastchar1, firstchar2;
    String yanacomp, finalstr;

    void init() {
        vowels = new HashSet<Character>();
        for (int i = 0; i < allvowels.length; i++) {
            vowels.add(new Character(allvowels[i]));
        }
        gunvowels = new HashSet<Character>();
        for (int i = 0; i < gunavowels.length; i++) {
            gunvowels.add(new Character(gunavowels[i]));
        }
        vriddhivowels = new HashSet<Character>();
        for (int i = 0; i < vriddhi.length; i++) {
            vriddhivowels.add(new Character(vriddhi[i]));
        }
        savarnavowels = new HashSet<Character>();
        for (int i = 0; i < savarna.length; i++) {
            savarnavowels.add(new Character(savarna[i]));
        }
        consonents = new HashSet<Character>();
        for (int i = 0; i < consonent.length; i++) {
            consonents.add(new Character(consonent[i]));
        }
        yana = new HashSet<String>();
        for (int i = 0; i < yanapossibility.length; i++) {
            yana.add(new String(yanapossibility[i]));
        }
    }

    public String getSandhifrombeg(String word1, String word2, String word3) {
        //word1=actual word1
        //word2=pattern word1
        //word3=pattern word2
        actualword1 = word1;
        patternword1 = word2;
        patternword2 = word3;
        //Syatem.out.println("the 3 words are : ")
        init();
        lastchar1 = actualword1.charAt(word1.length() - 1);
        //System.out.println("last character of actual 1st word is : " + lastchar1);
        //System.out.println("pattern of word 1 is : " + patternword1);
        lastcharofpattern1 = patternword1.charAt(patternword1.length() - 1);
        //System.out.println("last character of pattern 1st word is : " + lastcharofpattern1);
        lastbut1ofpattern1 = patternword1.charAt(patternword1.length() - 2);
        //System.out.println("last but 1 character of pattern 1st word is : " + lastbut1ofpattern1);
        yanacomp = lastbut1ofpattern1 + "" + lastcharofpattern1 + "";
        //System.out.println("yanacomp : " + yanacomp);

        // lastword+_____->lastcharofpattern
        if (gunvowels.contains(lastcharofpattern1)) {
            checkGuna(0);
        } else if (vriddhivowels.contains(lastcharofpattern1)) {
            checkVriddhi(0);
        } else if (yana.contains(yanacomp) || lastcharofpattern1 == 'य') {
            checkYana(0);
        } else if (savarnavowels.contains(lastcharofpattern1)) {
            checkSavarna(0);
        }
        finalstr = poss1 + "+" + poss2;
        return finalstr;
    }

    public String getSandhifromlast(String word1, String word2, String word3) {
        init();
        actualword2 = word1;
        patternword2 = word2;
        patternword1 = word3;
        firstchar2 = actualword2.charAt(0);
        lastcharofpattern1 = patternword1.charAt(patternword1.length() - 1);
        lastbut1ofpattern1 = patternword1.charAt(patternword1.length() - 2);
        yanacomp = lastbut1ofpattern1 + "" + lastcharofpattern1 + "";
        if (gunvowels.contains(lastcharofpattern1)) {
            checkGuna(1);
        } else if (vriddhivowels.contains(lastcharofpattern1)) {
            checkVriddhi(1);
        } else if (yana.contains(yanacomp) || lastcharofpattern1 == 'य') {
            checkYana(1);
        } else if (savarnavowels.contains(lastcharofpattern1)) {
            checkSavarna(1);
        }
        finalstr = poss1 + "+" + poss2;
        return finalstr;
    }

    void checkGuna(int flag) {
        //System.out.println("Guna sandhi detected");
        if (flag == 0) {
            if (lastcharofpattern1 == 'ो') {
                poss1 = actualword1 + " " + 'उ' + patternword2;
                poss2 = actualword1 + " " + 'ऊ' + patternword2;
            } else if (lastcharofpattern1 == 'े') {
                poss1 = actualword1 + " " + 'इ' + patternword2;
                poss2 = actualword1 + " " + 'ई' + patternword2;
            }
        } else if (flag == 1) {
            poss1 = patternword1.substring(0, patternword1.length() - 1) + "" + " " + actualword2;
            poss2 = patternword1.substring(0, patternword1.length() - 1) + "ा" + " " + actualword2;
        }
    }

    void checkVriddhi(int flag) {
        //System.out.println("Vriddhi sandhi detected");
        if (flag == 0) {
            if (lastcharofpattern1 == 'ौ') {
                poss1 = actualword1 +" " + 'ओ' + patternword2;
                poss2 = actualword1 +" " + 'औ' + patternword2;
            } else if (lastcharofpattern1 == 'ै') {
                poss1 = actualword1 +" " + 'ए' + patternword2;
                poss2 = actualword1 +" " + 'ऐ' + patternword2;
            }
        } else if (flag == 1) {
            poss1 = patternword1.substring(0, patternword1.length() - 1) + " " + actualword2;
            poss2 = patternword1.substring(0, patternword1.length() - 1) + "ा" +" " + actualword2;
        }
    }

    void checkYana(int flag) {
        //System.out.println("Yana sandhi detected");
        if (flag == 0) {

            if (lastcharofpattern1 == 'य') {
                poss1 = actualword1 +" " + 'अ' + patternword2;
            } else if (yanacomp.equals("या")) {
                poss1 = actualword1 +" " + 'आ' + patternword2;
            } else if (yanacomp.equals("यु")) {
                poss1 = actualword1 +" " + 'उ' + patternword2;
            } else if (yanacomp.equals("यू")) {
                poss1 = actualword1 +" " + 'ऊ' + patternword2;
            } else if (yanacomp.equals("ये")) {
                poss1 = actualword1 +" " + 'ए' + patternword2;
            } else if (yanacomp.equals("यै")) {
                poss1 = actualword1 +" " + 'ऐ' + patternword2;
            } else if (yanacomp.equals("यौ")) {
                poss1 = actualword1 +" " + 'औ' + patternword2;
            }
            poss2 = poss1;
        }
        if (flag == 1) {
            if (yanacomp.equals("यु") || yanacomp.equals("यू") || yanacomp.equals("ये") || yanacomp.equals("या") || yanacomp.equals("यौ")) {
                poss1 = patternword1.substring(0, patternword1.length() - 3) + 'ि' + " " +actualword2;
                poss2 = poss1;
            } else if (lastcharofpattern1 == 'य') {
                poss1 = patternword1.substring(0, patternword1.length() - 2) + 'ि' +" " + actualword2 + "";
                poss2 = patternword1.substring(0, patternword1.length() - 2) + 'ी' +" " + actualword2 + "";
            } else if (yanacomp.equals("यै")) {
                poss1 = patternword1.substring(0, patternword1.length() - 3) + 'ि' +" " + actualword2 + "";
                poss2 = patternword1.substring(0, patternword1.length() - 3) + 'ी' +" " + actualword2 + "";
            }
        }
    }

    void checkSavarna(int flag) {
        //System.out.println("savarna deergha sandhi detected");
        if (flag == 0) {

            if (lastcharofpattern1 == 'ा') {
                poss1 = actualword1 + " "+ 'अ' + patternword2;
                poss2 = actualword1 + " "+ 'आ' + patternword2;
            } else if (lastcharofpattern1 == 'ी') {
                poss1 = actualword1 + " "+ 'इ' + patternword2;
                poss2 = actualword1 + " "+ 'ई' + patternword2;
            } else if (lastcharofpattern1 == 'ू') {
                poss1 = actualword1 + " "+ 'उ' + patternword2;
                poss2 = actualword1 + " "+ 'ऊ' + patternword2;
            } else if (lastcharofpattern1 == 'ऋ') {
                poss1 = actualword1 + " "+ 'ऋ' + patternword2;
                poss2 = actualword1 + " "+ 'ऋ' + patternword2;
            }
        }
        if (flag == 1) {
            if (lastcharofpattern1 == 'ा') {
                poss1 = patternword1 + " " + actualword2;
                poss2 = patternword1.substring(0, patternword1.length() - 1) + " " +actualword2 + "";
            } else if (lastcharofpattern1 == 'ी') {
                poss1 = patternword1 + " " + actualword2;
                poss2 = patternword1.substring(0, patternword1.length() - 1) + 'ि' + " " +actualword2 + "";
            } else if (lastcharofpattern1 == 'ू') {
                poss1 = patternword1 + " " + actualword2;
                poss2 = patternword1.substring(0, patternword1.length() - 1) + 'ु' + " " +actualword2 + "";
            } else if (lastcharofpattern1 == 'ऋ') {
                poss1 = patternword1 + " " + actualword2;
                poss2 = patternword1.substring(0, patternword1.length() - 1) + 'ऋ' + " " +actualword2 + "";
            }
        }
    }
}

/*public class Wordprocessor {

    public static void main(String args[]) {
        //public void checkfrombeg(String actualfirstword, String fakefirstword, String fakesecondword) {
        sandhi getwords = new sandhi();
        String actualfirstword = "रम", fakefirstword = "रमा", fakesecondword = "लयम", actualsecondword = "आलयम";
        String actualfirstword1 = "मुनि", fakefirstword1 = "मुन्या", fakesecondword1 = "लयम", actualsecondword1 = "आलयम";
        String actualfirstword2 = "मुन", fakefirstword2 = "मुने", fakesecondword2 = "लयम", actualsecondword2 = "इलयम";
        String actualfirstword3 = "रम", fakefirstword3 = "रामौ", fakesecondword3 = "लयम", actualsecondword3 = "ओलयम";

        String finalstrbeg = getwords.getSandhifrombeg(actualfirstword, fakefirstword, fakesecondword);
        System.out.println("the word is : " + finalstrbeg);
        String finalstrlast = getwords.getSandhifromlast(actualsecondword, fakesecondword, fakefirstword);
        System.out.println("the word from last is : " + finalstrlast);
        System.out.println("***************************************************");
        String finalstrbeg1 = getwords.getSandhifrombeg(actualfirstword1, fakefirstword1, fakesecondword1);
        System.out.println("the word1 is : " + finalstrbeg1);
        String finalstrlast1 = getwords.getSandhifromlast(actualsecondword1, fakesecondword1, fakefirstword1);
        System.out.println("the word1 from last is : " + finalstrlast1);
        System.out.println("***************************************************");
        String finalstrbeg2 = getwords.getSandhifrombeg(actualfirstword2, fakefirstword2, fakesecondword2);
        System.out.println("the word2 is : " + finalstrbeg2);
        String finalstrlast2 = getwords.getSandhifromlast(actualsecondword2, fakesecondword2, fakefirstword2);
        System.out.println("the word2 from last is : " + finalstrlast2);
        System.out.println("***************************************************");
        String finalstrbeg3 = getwords.getSandhifrombeg(actualfirstword3, fakefirstword3, fakesecondword3);
        System.out.println("the word3 is : " + finalstrbeg3);
        String finalstrlast3 = getwords.getSandhifromlast(actualsecondword3, fakesecondword3, fakefirstword3);
        System.out.println("the word3 from last is : " + finalstrlast3);
        System.out.println("***************************************************");
    }
}
*/
public class SandhiPattern {

    public String getbeg(String actualfirstword, String fakefirstword, String fakesecondword) {
        sandhi abc = new sandhi();
        String finalstrbeg = abc.getSandhifrombeg(actualfirstword, fakefirstword, fakesecondword);
        return finalstrbeg;
    }

    public String getlast(String actualsecondword, String fakesecondword, String fakefirstword) {
        sandhi abc = new sandhi();
        String finalstrlast = abc.getSandhifromlast(actualsecondword, fakesecondword, fakefirstword);
        return finalstrlast;
    }
}