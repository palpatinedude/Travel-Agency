import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class destination extends  JDialog{
    private JPanel panel1;
    private JTextField dst_idvar;
    private JTextField dst_namevar;
    private JTextField dst_descrvar;
    private JTextField dst_languagevar;
    private JTextField dst_rtypevar;
    private JButton PRINTButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JButton INSERTButton;
    private JTextField dst_locationvar;


    public destination(JFrame parent) {
        super(parent);
        setTitle("DESTINATION");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String dst_id=dst_idvar.getText();
                String dst_name=dst_namevar.getText();
                String dst_language=dst_languagevar.getText();
                String dst_descr=dst_descrvar.getText();
                String dst_location= dst_locationvar.getText();
                String dst_rtype= dst_rtypevar.getText();

                if(dst_id.isEmpty() || dst_descr.isEmpty() || dst_language.isEmpty() || dst_name.isEmpty() || dst_location.isEmpty() || dst_rtype.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    dst_idvar.setText("");
                    dst_descrvar.setText("");
                    dst_namevar.setText("");
                    dst_languagevar.setText("");
                    dst_locationvar.setText("");
                    dst_rtypevar.setText("");
                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO destination(dst_id,dst_name,dst_descr,dst_language,dst_rtype,dst_location) VALUES(?,?,?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,dst_idvar.getText());
                        st.setString(2,dst_namevar.getText());
                        st.setString(3,dst_descrvar.getText());
                        st.setString(4,dst_languagevar.getText());
                        st.setString(5,dst_rtypevar.getText());
                        st.setString(6,dst_locationvar.getText());


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
                String dst_id=dst_idvar.getText();
                String dst_name=dst_namevar.getText();
                String dst_language=dst_languagevar.getText();
                String dst_descr=dst_descrvar.getText();
                String dst_location= dst_locationvar.getText();
                String dst_rtype= dst_rtypevar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM destination WHERE dst_id=? ";
                    if( dst_id.isEmpty() || dst_name.isEmpty()  || dst_language.isEmpty() || dst_descr.isEmpty() || dst_location.isEmpty() || dst_rtype.isEmpty()){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,dst_idvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        dst_idvar.setText("");
                        dst_namevar.setText("");
                        dst_descrvar.setText("");
                        dst_languagevar.setText("");
                        dst_rtypevar.setText("");
                        dst_locationvar.setText("");
                        con.close();}
                }catch(Exception e){ System.out.println(a);}





            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String dst_id=dst_idvar.getText();
                String dst_name=dst_namevar.getText();
                String dst_language=dst_languagevar.getText();
                String dst_descr=dst_descrvar.getText();
                String dst_location= dst_locationvar.getText();
                String dst_rtype= dst_rtypevar.getText();
                try{

                    String sql="UPDATE destination SET dst_name='"+dst_name+"',dst_descr='"+dst_descr+"',dst_language='"+dst_language+"',dst_rtype='"+dst_rtype+"',dst_location='"+dst_location+"'"
                            +"WHERE dst_id"+dst_id;
                    if( dst_name.isEmpty() || dst_descr.isEmpty()  || dst_language.isEmpty() || dst_id.isEmpty()  || dst_rtype.isEmpty() || dst_location.isEmpty()){
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        dst_idvar.setText("");
                        dst_rtypevar.setText("");
                        dst_namevar.setText("");
                        dst_locationvar.setText("");
                        dst_languagevar.setText("");
                        dst_descrvar.setText("");
                        con.close();

                    }}catch(Exception e){ System.out.println(e);}


            }
        });
        PRINTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
