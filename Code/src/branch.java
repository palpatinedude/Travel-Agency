import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class branch extends JDialog {
    private JPanel panel1;
    private JTextField br_streetvar;
    private JTextField br_numvar;
    private JTextField br_cityvar;
    private JButton PRINTButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JButton INSERTButton;
    private JTextField br_codevar;

    public branch(JFrame parent) {
        super(parent);
        setTitle("BRANCH");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



            INSERTButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    String br_code=br_codevar.getText();
                    String br_street=br_streetvar.getText();
                    String br_num=br_numvar.getText();
                    String br_city=br_cityvar.getText();

                    if(br_code.isEmpty() || br_street.isEmpty() || br_num.isEmpty() || br_city.isEmpty() ){
                        JOptionPane.showMessageDialog(null,"Enter all data");
                        br_cityvar.setText("");
                        br_streetvar.setText("");
                        br_numvar.setText("");
                        br_codevar.setText("");

                    }else{
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                            //here travel_agency is database name, root is username and 28022002 password
                            String sql="INSERT INTO branch(br_code,br_street,br_num,br_city) VALUES(?,?,?,?)";
                            PreparedStatement st=con.prepareStatement(sql);
                            st.setString(1,br_codevar.getText());
                            st.setString(2,br_streetvar.getText());
                            st.setString(3,br_numvar.getText());
                            st.setString(4,br_cityvar.getText());


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
                    String br_code=br_codevar.getText();
                    String br_street=br_streetvar.getText();
                    String br_num=br_numvar.getText();
                    String br_city=br_cityvar.getText();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="DELETE FROM branch WHERE br_code=? ";
                        if( br_code.isEmpty() || br_street.isEmpty()  || br_num.isEmpty() || br_city.isEmpty()){
                            PreparedStatement st=con.prepareStatement(sql);
                            st.setString(1,br_codevar.getText());


                            st.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Recored deleted");
                            br_codevar.setText("");
                            br_streetvar.setText("");
                            br_numvar.setText("");
                            br_cityvar.setText("");
                            con.close();}
                    }catch(Exception e){ System.out.println(e);}

                }
            });
            UPDATEButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent a) {
                    String br_code=br_codevar.getText();
                    String br_street=br_streetvar.getText();
                    String br_num=br_numvar.getText();
                    String br_city=br_cityvar.getText();

                    try{

                        String sql="UPDATE branch SET br_num='"+br_num+"',br_street='"+br_street+"',br_city='"+br_city+"'"
                                +"WHERE br_code="+br_code;
                        if( br_city.isEmpty() || br_num.isEmpty()  || br_street.isEmpty() ){
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                            PreparedStatement st=con.prepareStatement(sql);
                            st.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Recored updated");
                            br_codevar.setText("");
                            br_cityvar.setText("");
                            br_numvar.setText("");
                            br_streetvar.setText("");
                            con.close();

                        }}catch(Exception e){ System.out.println(e);}

                }
            });
            PRINTButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });setVisible(true);
        }
    }
