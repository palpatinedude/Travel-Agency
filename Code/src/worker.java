import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class worker extends  JDialog{
    private JPanel panel1;
    private JTextField wrk_AT;
    private JTextField wrk_name;
    private JTextField wrk_lname;
    private JTextField wrk_salary;
    private JTextField wrk_br_code;
    private JButton wrkprint;
    private JButton wrkupdate;
    private JButton wrkdelete;
    private JButton wrkinsert;


    public worker(JFrame parent) {
        super(parent);
        setTitle("WORKER");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        wrkinsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String wrkAT=wrk_AT.getText();
                String wrkname=wrk_name.getText();
                String wrklname=wrk_lname.getText();
                String wrksalary=wrk_salary.getText();
                String wrkbrcode=wrk_br_code.getText();
                if(wrkAT.isEmpty() || wrkname.isEmpty() || wrklname.isEmpty() || wrksalary.isEmpty() || wrkbrcode.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    wrk_AT.setText("");
                    wrk_name.setText("");
                    wrk_lname.setText("");
                    wrk_salary.setText("");
                    wrk_br_code.setText("");
                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO worker(wrk_AT,wrk_name,wrk_lname,wrk_salary,wrk_br_code) VALUES(?,?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,wrk_AT.getText());
                        st.setString(2,wrk_name.getText());
                        st.setString(3,wrk_lname.getText());
                        st.setString(4,wrk_salary.getText());
                        st.setString(5,wrk_br_code.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored added");
                        con.close();
                    }catch(Exception e){ System.out.println(e);}
                }
            }
        });
        wrkdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String wrkAT=wrk_AT.getText();
                String wrkname=wrk_name.getText();
                String wrklname=wrk_lname.getText();
                String wrksalary=wrk_salary.getText();
                String wrkbrcode=wrk_br_code.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM worker WHERE wrk_AT=? ";
                    if( wrkname.isEmpty() || wrklname.isEmpty()  || wrkbrcode.isEmpty() || wrksalary.isEmpty()){
                    PreparedStatement st=con.prepareStatement(sql);
                    st.setString(1,wrk_AT.getText());


                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Recored deleted");
                    wrk_AT.setText("");
                    wrk_name.setText("");
                    wrk_lname.setText("");
                    wrk_salary.setText("");
                    wrk_br_code.setText("");
                    con.close();}
                }catch(Exception e){ System.out.println(e);}


            }
        });
        wrkupdate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent a) {
                String wrkAT=wrk_AT.getText();
                String wrkname=wrk_name.getText();
                String wrklname=wrk_lname.getText();
                String wrksalary=wrk_salary.getText();
                String wrkbrcode=wrk_br_code.getText();

                try{

                    String sql="UPDATE worker SET wrk_name='"+wrkname+"',wrk_lname='"+wrklname+"',wrk_br_code='"+wrkbrcode+"'"
                            +"WHERE wrk_AT="+wrkAT;
                    if( wrkname.isEmpty() || wrklname.isEmpty()  || wrkbrcode.isEmpty() || wrksalary.isEmpty()){

                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    PreparedStatement st=con.prepareStatement(sql);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Recored updated");
                        wrk_AT.setText("");
                        wrk_name.setText("");
                        wrk_lname.setText("");
                        wrk_salary.setText("");
                        wrk_br_code.setText("");
                    con.close();

                }}catch(Exception e){ System.out.println(e);}

                }
        });
        wrkprint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Print print=new Print(null);
              print.show();
            }
        });setVisible(true);

    }
}
