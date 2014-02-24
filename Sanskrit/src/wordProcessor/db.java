package wordProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author priya
 */
public class db {

    connect c;

    public db() {
        c = new connect();
    }
    public void closeConnection() throws SQLException
    {
        c.closeConnection();
    }
    public String findMeaning(String word) {

        String meaning = null;
        ResultSet S = null, s1 = null;
        String string, r, q, q2;
        try {
            q = "select meaning,word from Dict where word like '" + word + "'";
            S = c.getResult(q);
            if (S.next()) {
                meaning = S.getString(1);
            }
        } catch (Exception e) {
        }

        return meaning;
    }

    String symbolMap(String symbol) {
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        try {
            q = "select symbol from symbolMapping where map='" + symbol + "' ";
            S = c.getResult(q);
            if (S.next()) {
                map = S.getString(1);
            }
        } catch (Exception e) {
        }
        return map;
    }

   public String getMap(String symbol) {
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        try {
            q = "select map from symbolMapping where symbol='" + symbol + "' ";
            S = c.getResult(q);
            if (S.next()) {

                map = S.getString(1);
            }
        } catch (Exception e) {
        }
        return map;
    }

    String getUnicodeMap(char symbol) {
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        try {
            q = "select english from characterMapping where sanskrit='" + symbol + "' ";
            S = c.getResult(q);

            if (S.next()) {
                map = S.getString(1);
            } else {
                q = "select english from swaraMapping where sanskrit='" + symbol + "'";
                S = c.getResult(q);
                if (S.next()) {
                    map = S.getString(1);
                }
            }
        } catch (Exception e) {
        }
        return map;
    }

    String getCharMap(String symbol, int position) {

      
        String map = null;
        connect c = new connect();

        ResultSet S = null, s1 = null;
        String string, r, q, q2;

        if (position == 0) {
    
            try {
                q = "select sanskrit from characterMapping where english='" + symbol + "' ";
                S = c.getResult(q);

                if (S.next()) {
                    map = S.getString(1);
                   
                }
            } catch (Exception e) {
            }
            return map;
        } else {
            try {
            
                q = "select sanskrit from swaraMapping where english='" + symbol + "'";
                S = c.getResult(q);

                if (S.next()) {
                    map = S.getString(1);
                } else {
                    q = "select sanskrit from characterMapping where english='" + symbol + "'";
                    S = c.getResult(q);
                    if (S.next()) {
                        map = S.getString(1);
                    }
                }
            } catch (Exception e) {
            }

        }
        return map;
    }
}
 
    

