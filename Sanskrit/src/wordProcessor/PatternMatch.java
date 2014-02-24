package wordProcessor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import wordProcessor.SandhiPattern;
import wordProcessor.connect;

/**
 *
 * @author Vidyasekar
 */

public class PatternMatch
{
    /**
     * @param args the command line arguments
     */
     void print(String resultbeg, String resultlast)
     {
                String beg1, beg2, end1, end2;
                beg1=resultbeg.substring(0,resultbeg.indexOf("+"));
                beg2=resultbeg.substring(resultbeg.indexOf("+")+1, resultbeg.length());
                end1=resultlast.substring(0,resultlast.indexOf("+"));
                end2=resultlast.substring(resultlast.indexOf("+")+1, resultlast.length());
                if(!(beg1.equals("null"))&&!(beg2.equals("null"))&&!(end1.equals("null"))&&!(end2.equals("null")))
                {
                    //System.out.println(beg1+"  "+beg2+"  "+end1+"  "+end2);
                    if(beg1.equals(beg2))
                        System.out.println(beg1);
                    else if(end1.equals(end2))
                        System.out.println(end1);
                    else if(beg1.equals(end2))
                        System.out.println(beg1);
                    else if(end1.equals(beg2))
                        System.out.println(end1);
                    else if(end1.equals(beg1))
                        System.out.println(end1);
                    else if(end2.equals(beg2))
                        System.out.println(end2);
                }
     }

    public ArrayList<String> sandhiPatternCheck(String input) throws SQLException
    {
        // TODO code application logic here
        ArrayList<String> arr1=new ArrayList<String>();
        ResultSet result1 = null, result2 = null;
        String [] output1 = new String[5];
        String [] output2 = new String[5];
        String [] pattern1 = new String[5];
        String [] pattern2 = new String[5];
        SandhiPattern wp = new SandhiPattern();
        int index1=0, index2=0;
	connect sanskritdb = new connect();
        result1 = sanskritdb.getResult("select word, pattern, position from sandhilookup where position = 0");
        result2 = sanskritdb.getResult("select word, pattern, position from sandhilookup where position = 1");
        //String input = JOptionPane.showInputDialog(null,"Enter a sanskrit word");
        //String output1="", output2="";
        //userInput oui = new userInput(input);//object userInput
        //System.out.println(oui.input);
        //oui.formatInput(); vibakthi rules
        //System.out.println(oui.input);
        try
        {
            //System.out.println("Patterns found at the start");
            result1.first();
            do
            {
                if(input.indexOf(result1.getString(2))==0)
                {
                    output1[index1]=result1.getString(1);
                    pattern1[index1++]=result1.getString(2);
                    //System.out.println(result2.getString(1));
                }
            }while(result1.next());
            //System.out.println("Patterns found at the end");
            result2.first();
            do
            {
                if(input.endsWith(result2.getString(2)))
                {
                    output2[index2]=result2.getString(1);
                    pattern2[index2++]=result2.getString(2);
                    //System.out.println(result1.getString(1));
                }
            }while(result2.next());
        }
        catch(Exception ex)
        {

        }
        System.out.println("Words found at the start");
        for(int i=0;i<index1;i++)
        {
            System.out.println(output1[i]);
        }
        System.out.println("Words found at the end");
        for(int i=0;i<index2;i++)
        {
            System.out.println(output2[i]);
        }

        System.out.println("Possible choices from sandhi and cominations are");
        for(int i=0;i<index1;i++)
        {
            for(int j=0;j<index2;j++)
            {
                //System.out.println(output1[i]+ " " + output2[j]);
                //System.out.println(output1[i]+ " " +pattern1[i] + " " + pattern2[j]);
                String resultbeg=new String(), resultlast=new String();
                try
                {
                resultbeg = wp.getbeg(output1[i],pattern1[i] , pattern2[j]);
                }
                catch(Exception ex)
                {

                }
                try
                {
                resultlast = wp.getlast(output2[j],pattern2[i] , pattern1[j]);
                }
                catch(Exception ex)
                {

                }
                if(!resultbeg.isEmpty()&&!resultlast.isEmpty())
                {
                    if(resultbeg.equals("null+null")||resultlast.equals("null+null"))
                    {

                    }
                    else
                    {
                        //System.out.println(resultbeg);
                        //System.out.println(resultlast);
/*                        System.out.println(resultbeg.substring(resultbeg.indexOf("+")+1));
                        System.out.println(resultbeg.substring(0,resultbeg.indexOf("+")));
                        System.out.println(resultlast.substring(resultlast.indexOf("+")+1));
                        System.out.println(resultlast.substring(0,resultlast.indexOf("+")));*/

                        arr1.add(resultbeg.substring(resultbeg.indexOf("+")+1));
                        arr1.add(resultbeg.substring(0,resultbeg.indexOf("+")));
                        arr1.add(resultlast.substring(resultlast.indexOf("+")+1));
                        arr1.add(resultlast.substring(0,resultlast.indexOf("+")));
                    }
                    //print(resultbeg, resultlast);
                }
                /*if(resultbeg!=null)
                    System.out.println(resultbeg);
                if(resultlast!=null)
                    System.out.println(resultlast);*/
                //s.checkbeg(output1[i],pattern1[i] , pattern2[j]);
                //s.checkend(output2[i],pattern1[i] , pattern2[j]);
            }
        }
    return arr1;
    }
}