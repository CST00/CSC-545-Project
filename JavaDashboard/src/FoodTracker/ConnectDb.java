package FoodTracker;
import java.sql.Connection;
import java.sql.DriverManager;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import javax.swing.JOptionPane;

public class ConnectDb {
    public static Connection setupConnection() {
        String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
        String jdbcUrl = "jdbc:oracle:thin:@157.89.28.31:1521:cscdb";

        String username = "c##MayfieldJ545";
        String password = "Pa$$3412";
        
        try {
            // Load jdbc driver and connect to the oracle database
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            return conn;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    static void close(Connection conn) {
        if(conn != null)
            try {
                conn.close();
            }
            catch(Throwable whatever)
            {}
    }

    static void close(OraclePreparedStatement st){
        if(st != null)
            try {
                st.close();
            }
            catch(Throwable whatever)
            {}
    }

    static void close(OracleResultSet rs) {
        if(rs != null)
            try {
                rs.close();
            }
            catch(Throwable whatever)
            {}
    }
}