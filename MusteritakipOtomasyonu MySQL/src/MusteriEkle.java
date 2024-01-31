
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Semih Durbal
 */
public class MusteriEkle extends javax.swing.JFrame {





    private Connection con = null;

    private PreparedStatement preparedStatement = null;

    private Statement statement = null;

    public MusteriEkle(){
        initComponents();


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



    public void MusteriEkle(){

        String sorgu = "Insert Into musteriler (musteri_ismi,urun_ismi,urun_fiyati,urun_adedi,musteri_borcu,gun,ay,yil) VALUES (?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,musteriIsmiTextField.getText());
            preparedStatement.setString(2,urunIsmiTextField.getText());
            preparedStatement.setInt(3, Integer.parseInt(urunBirimFiyatiTextField.getText()));
            preparedStatement.setInt(4, Integer.parseInt(urunAdediTextField.getText()));
            preparedStatement.setInt(5,(Integer.parseInt(urunBirimFiyatiTextField.getText()) * Integer.parseInt(urunAdediTextField.getText())));
            preparedStatement.setInt(6, Integer.parseInt(gunTextField.getText()));
            preparedStatement.setInt(7, Integer.parseInt(ayTextField.getText()));
            preparedStatement.setInt(8, Integer.parseInt(yilTextField.getText()));

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public ArrayList<musteriler> musterileriGetir(){
        try {
            ArrayList<musteriler> cikti = new ArrayList<musteriler>();

            statement = con.createStatement();
            String sorgu = "Select * From musteriler";
            ResultSet rs = statement.executeQuery(sorgu);

            while(rs.next()){
                String musteriAd = rs.getString("musteri_ismi");
                String urunAd = rs.getString("urun_ismi");
                int urunFiyat = rs.getInt("urun_fiyati");
                int urunAdet = rs.getInt("urun_adedi");
                int musteriBorc = rs.getInt("musteri_borcu");
                int gun = rs.getInt("gun");
                int ay = rs.getInt("ay");
                int yil = rs.getInt("yil");

                cikti.add(new musteriler(musteriAd, urunAd, urunAdet, urunFiyat, musteriBorc, gun, ay, yil));

            }
            return cikti;


        } catch (SQLException ex) {
            Logger.getLogger(MusteriEkle.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void musteriSil(String musAd){
        String sorgu = "Delete From musteriler where musteri_ismi = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setString(1,musAd);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void musteriGuncelle(String musAd ,String urAd , int urF , int urA , int gun , int ay , int yil){
        String sorgu = "Update musteriler set musteri_ismi =? , urun_ismi = ? , urun_fiyati=? , urun_adedi = ? , gun = ? , ay =? , yil =? where musteri_ismi";

        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,musAd);
            preparedStatement.setString(2,urAd);
            preparedStatement.setString(3, String.valueOf(urF));
            preparedStatement.setString(4, String.valueOf(urA));
            preparedStatement.setString(5, String.valueOf(gun));
            preparedStatement.setString(6, String.valueOf(ay));
            preparedStatement.setString(7, String.valueOf(yil));

            preparedStatement.executeUpdate();


        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        musteriIsmiTextField = new javax.swing.JTextField();
        urunIsmiTextField = new javax.swing.JTextField();
        urunAdediTextField = new javax.swing.JTextField();
        urunBirimFiyatiTextField = new javax.swing.JTextField();
        gunTextField = new javax.swing.JTextField();
        ayTextField = new javax.swing.JTextField();
        yilTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        toplamborcTextField = new javax.swing.JTextField();
        musteriEkleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Müşteri İsmi : ");

        jLabel2.setText("Ürün İsmi :");

        jLabel3.setText("Ürün Adedi :");

        jLabel4.setText("Ürün Birim Fiyatı :");

        jLabel5.setText("Son İşlem Tarihi :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Toplam Müşteri Borcu");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setText("gün");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel8.setText("ay");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel9.setText("yıl");

        toplamborcTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        toplamborcTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toplamborcTextFieldActionPerformed(evt);
            }
        });

        musteriEkleButton.setFont(new java.awt.Font("Snap ITC", 3, 24)); // NOI18N
        musteriEkleButton.setText("Müşteri Ekle");
        musteriEkleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musteriEkleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(musteriIsmiTextField)
                                        .addComponent(urunIsmiTextField)
                                        .addComponent(urunAdediTextField)
                                        .addComponent(urunBirimFiyatiTextField)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(gunTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(yilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(toplamborcTextField))
                                .addGap(41, 41, 41))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(musteriEkleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(musteriIsmiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(urunIsmiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(urunAdediTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(urunBirimFiyatiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(gunTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(yilTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(toplamborcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(88, 88, 88)))
                                .addComponent(musteriEkleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>




    private void toplamborcTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void musteriEkleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MusteriEkle();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusteriEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusteriEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField ayTextField;
    private javax.swing.JTextField gunTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton musteriEkleButton;
    private javax.swing.JTextField musteriIsmiTextField;
    private javax.swing.JTextField toplamborcTextField;
    private javax.swing.JTextField urunAdediTextField;
    private javax.swing.JTextField urunBirimFiyatiTextField;
    private javax.swing.JTextField urunIsmiTextField;
    private javax.swing.JTextField yilTextField;
    // End of variables declaration
}
