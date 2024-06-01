import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class reservation extends  JDialog{
    private JPanel panel1;
    private JTextField residvar;
    private JTextField seatnumvar;
    private JTextField namevar;
    private JTextField lnamevar;
    private JTextField adultvar;
    private JButton INSERTButton;
    private JButton PRINTButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;

    public reservation(JFrame parent) {
        super(parent);
        setTitle("RESERVATION");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String res_tr_id=residvar.getText();
                String res_setnum=seatnumvar.getText();
                String res_name=namevar.getText();
                String res_lname=lnamevar.getText();
                String res_isadult=adultvar.getText();

                if(res_isadult.isEmpty() || res_lname.isEmpty() || res_name.isEmpty() || res_tr_id.isEmpty() || res_setnum.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    adultvar.setText("");
                    namevar.setText("");
                    lnamevar.setText("");
                    residvar.setText("");
                    seatnumvar.setText("");
                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO reservation(res_tr_id,res_seatnum,res_name,res_lname,res_isadult) VALUES(?,?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,residvar.getText());
                        st.setString(2,seatnumvar.getText());
                        st.setString(3,namevar.getText());
                        st.setString(4,lnamevar.getText());
                        st.setString(5,adultvar.getText());


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

                String res_tr_id=residvar.getText();
                String res_setnum=seatnumvar.getText();
                String res_name=namevar.getText();
                String res_lname=lnamevar.getText();
                String res_isadult=adultvar.getText();

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM reservation WHERE res_tr_id=? ";
                    if(res_isadult.isEmpty() || res_lname.isEmpty()  || res_name.isEmpty()  || res_setnum.isEmpty() ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,residvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        residvar.setText("");
                        seatnumvar.setText("");
                        namevar.setText("");
                        lnamevar.setText("");
                        seatnumvar.setText("");
                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                String res_tr_id=residvar.getText();
                String res_setnum=seatnumvar.getText();
                String res_name=namevar.getText();
                String res_lname=lnamevar.getText();
                String res_isadult=adultvar.getText();
                try{


                    String sql="UPDATE reservation SET res_seatnum='"+res_setnum+"',res_name='"+res_name+"',res_lname='"+res_lname+"',res_isadult='"+res_isadult+"'"
                            +"WHERE res_tr_id="+res_tr_id;
                    if( res_isadult.isEmpty() || res_lname.isEmpty()  || res_name.isEmpty() || res_setnum.isEmpty()){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        residvar.setText("");
                        seatnumvar.setText("");
                        namevar.setText("");
                        lnamevar.setText("");
                        adultvar.setText("");
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
