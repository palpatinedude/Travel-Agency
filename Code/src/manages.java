import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class manages extends  JDialog {
    private JPanel panel1;
    private JButton PRINTButton1;
    private JTextField mngATvar;
    private JTextField mngbrvar;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JButton INSERTButton;

    public manages(JFrame parent) {
        super(parent);
        setTitle("MANAGES");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);





        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String mng_br_code=mngbrvar.getText();
                String mng_AT=mngATvar.getText();
                if(mng_AT.isEmpty() || mng_br_code.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    mngbrvar.setText("");
                    mngATvar.setText("");

                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO manages(mng_adm_AT,mng_br_code) VALUES(?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,mngATvar.getText());
                        st.setString(2,mngbrvar.getText());



                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored added");
                        con.close();
                    }catch(Exception e){ System.out.println(e);}
                }

            }
        });


        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String mng_br_code=mngbrvar.getText();
                String mng_AT=mngATvar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM manages WHERE mng_adm_AT=? ";
                    if( mng_br_code.isEmpty()   ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,mngbrvar.getText());
                        st.setString(2,mngATvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        mngbrvar.setText("");
                        mngATvar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });


        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String mng_br_code=mngbrvar.getText();
                String mng_AT=mngATvar.getText();
                try{

                    String sql="UPDATE worker SET mng_br_code='"+mng_br_code+"'"
                            +"WHERE mng_admin_AT="+mng_AT;
                    if( mng_br_code.isEmpty()  ){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        mngbrvar.setText("");
                        mngATvar.setText("");

                        con.close();

                    }}catch(Exception e){ System.out.println(e);}
            }
        });
        PRINTButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
