import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class driver extends  JDialog{
    private JPanel panel1;
    private JTextField drv_ATvar;
    private JTextField drv_licvar;
    private JTextField drv_routevar;
    private JTextField drv_expevar;
    private JButton INSERTButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JButton PRINTButton;

    public driver(JFrame parent) {
        super(parent);
        setTitle("DRIVER");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);





        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String drv_AT=drv_ATvar.getText();
                String drv_license=drv_licvar.getText();
                String drv_route=drv_routevar.getText();
                String drv_experience=drv_expevar.getText();
                if(drv_AT.isEmpty() || drv_license.isEmpty() ||drv_route.isEmpty() || drv_experience.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    drv_ATvar.setText("");
                    drv_expevar.setText("");
                    drv_licvar.setText("");
                    drv_routevar.setText("");

                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO driver(drv_AT,drv_license,drv_route,drv_experience) VALUES(?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,drv_ATvar.getText());
                        st.setString(2,drv_licvar.getText());
                        st.setString(3,drv_routevar.getText());
                        st.setString(4,drv_expevar.getText());


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
                String drv_AT=drv_ATvar.getText();
                String drv_license=drv_licvar.getText();
                String drv_route=drv_routevar.getText();
                String drv_experience=drv_expevar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM driver WHERE drv_AT=? ";
                    if( drv_experience.isEmpty() || drv_route.isEmpty()  || drv_license.isEmpty()  ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,drv_ATvar.getText());

                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                       drv_ATvar.setText("");
                        drv_expevar.setText("");
                        drv_licvar.setText("");
                        drv_routevar.setText("");
                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String drv_AT=drv_ATvar.getText();
                String drv_license=drv_licvar.getText();
                String drv_route=drv_routevar.getText();
                String drv_experience=drv_expevar.getText();
                try{

                    String sql="UPDATE driver SET drv_license='"+drv_license+"',drv_route='"+drv_route+"',drv_experience='"+drv_experience+"'"
                            +"WHERE drv_AT="+drv_AT;
                    if(  drv_route.isEmpty()  || drv_experience.isEmpty()  || drv_license.isEmpty() ){
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        drv_routevar.setText("");
                        drv_licvar.setText("");
                        drv_expevar.setText("");
                        drv_ATvar.setText("");
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
