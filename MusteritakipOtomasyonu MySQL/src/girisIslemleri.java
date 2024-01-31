
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class girisIslemleri {
    private Connection con = null;

    private PreparedStatement preparedStatement = null;

    private Statement statement = null;

    public girisIslemleri(){
        String url = "jdbc:mysql://"+DatabaseMySQL.host+":"+DatabaseMySQL.port+"/"+DatabaseMySQL.db_ismi+"?useUnicode = true&chracterEncoding = utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Bulunamadı.");
        }
        try {
            con = DriverManager.getConnection(url,DatabaseMySQL.kullanici_adi,DatabaseMySQL.parola);
            System.out.println("Bağlantı Başarılı");
        } catch (SQLException e) {
            System.out.println("Bağlantı Başarısız");
        }
    }


    public boolean girisYap(String kullanici_adi , String parola){
        String sorgu2 = "Select * from admin where kullanici_adi = ? and parola = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu2);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(girisIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public boolean girisYap2(String kullanici_adi , String parola){
        String sorgu = "Select * from kullanicilar where kullanici_adi = ? and parola = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(girisIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
