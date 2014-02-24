/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandhis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Priya
 */
public class test {
   
    public static void main(String args[])
    {
//         yanasandhi vs = new yanasandhi();
//        String word ="इत्याह";// इत्यादि अत्याचार देव्यालाय गत्यवरोध यद्यप्यन्ग
//        
//        //यद्यपि has prob
//        
////        word=vs.process(word);
////       System.out.println("Vyanjan sandhi split = "+word);
//        visargaSandhi vs = new visargaSandhi();
//        System.out.println(vs.process("कोस्मिन्")); इत्याह
//         vyanjan v = new vyanjan();
//         System.out.print(v.process("जगन्नाथ"));
////        swara v = new swara();
////        try {
////            System.out.print(v.process("मृद्व्यतिरेकेण "));
////        } catch (SQLException ex) {
////            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
//        }
        mulitipleSplit ms = new mulitipleSplit();
        ArrayList<String> solution=ms.process("महालयास्ति");
        System.out.println("Result");
        for(int i=0;i<solution.size();i++)
        {
            System.out.println(solution.get(i));
        }
    }
}
