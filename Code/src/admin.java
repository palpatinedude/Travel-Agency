import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class admin extends  JDialog{
    private JPanel panel1;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JTextField adm_ATvar;
    private JTextField adm_typevar;
    private JTextField adm_diplomavar;
    private JButton button4;


    public admin(JFrame parent)
    {
        super(parent);
        setTitle("ADMIN");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        button1.addActionListener(new ActionListener()  {//insert
            @Override
            public void actionPerformed(ActionEvent a) {
                String adm_AT=adm_ATvar.getText();
                String adm_type=adm_typevar.getText();
                String adm_diploma=adm_diplomavar.getText();

                if(adm_AT.isEmpty() || adm_type.isEmpty() || adm_diploma.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter all data");
              }else{
                  try{
                  Class.forName("com.mysql.jdbc.Driver");
                      Connection con = DriverManager.getConnection(
                              "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                  //here travel_agency is database name, root is username and 28022002 password
                      String sql="INSERT INTO admin(adm_AT,adm_type,adm_diploma) VALUES(?,?,?)";
                      PreparedStatement st=con.prepareStatement(sql);
                      st.setString(1,adm_ATvar.getText());
                      st.setString(2,adm_typevar.getText());
                      st.setString(3,adm_diplomavar.getText());
                      st.executeUpdate();
                      JOptionPane.showMessageDialog(null,"Recored added");
                      con.close();
                  }catch(Exception e){ System.out.println(e);}
              }
            }
        });
        button2.addActionListener(new ActionListener() {//delete
            @Override
            public void actionPerformed(ActionEvent a) {
                String adm_AT=adm_ATvar.getText();
                String adm_type=adm_typevar.getText();
                String adm_diploma=adm_diplomavar.getText();

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM admin WHERE adm_AT=?  ";
                    if( adm_AT.isEmpty() || adm_type.isEmpty()  || adm_diploma.isEmpty() ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,adm_ATvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        adm_ATvar.setText("");
                        adm_typevar.setText("");
                        adm_diplomavar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}
            }

        });
        button3.addActionListener(new ActionListener() {//update
            @Override
            public void actionPerformed(ActionEvent a) {
                String adm_AT=adm_ATvar.getText();
                String adm_type=adm_typevar.getText();
                String adm_diploma=adm_diplomavar.getText();

                try{

                    String sql="UPDATE admin SET adm_type='"+adm_type+"',adm_diploma='"+adm_diploma+"'"
                            +"WHERE adm_AT="+adm_AT;
                    if( adm_AT.isEmpty() || adm_type.isEmpty()  || adm_diploma.isEmpty() ){
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        adm_diplomavar.setText("");
                        adm_typevar.setText("");
                        adm_ATvar.setText("");
                        con.close();

                    }}catch(Exception e){ System.out.println(e);}

            }
        });
        button4.addActionListener(new ActionListener() {//print
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });setVisible(true);
    }
}
