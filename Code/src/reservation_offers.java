import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class reservation_offers extends JDialog{
    private JPanel panel1;
    private JTextField residvar;
    private JTextField namevar;
    private JTextField lnamevar;
    private JTextField depositvar;
    private JTextField offeridvar;
    private JButton INSERTButton;
    private JButton PRINTButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;

    public reservation_offers(JFrame parent) {
        super(parent);
        setTitle("RESERVATION_OFFERS");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String res_offer_id=residvar.getText();
                String name=namevar.getText();
                String lname=lnamevar.getText();
                String deposit=depositvar.getText();
                String offer_id=offeridvar.getText();

                if(res_offer_id.isEmpty() || name.isEmpty() || lname.isEmpty() || offer_id.isEmpty() || deposit.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    residvar.setText("");
                    namevar.setText("");
                    lnamevar.setText("");
                    offeridvar.setText("");
                    depositvar.setText("");
                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO reservation_offers(res_offer_id,name,lname,offer_id,deposit) VALUES(?,?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,residvar.getText());
                        st.setString(2,namevar.getText());
                        st.setString(3,lnamevar.getText());
                        st.setString(4,offeridvar.getText());
                        st.setString(5,depositvar.getText());


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
                String res_offer_id=residvar.getText();
                String name=namevar.getText();
                String lname=lnamevar.getText();
                String deposit=depositvar.getText();
                String offer_id=offeridvar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM reservation_offers WHERE res_offer_id=? ";
                    if(name.isEmpty() || lname.isEmpty()  || deposit.isEmpty()  || offer_id.isEmpty() ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,residvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        residvar.setText("");
                        offeridvar.setText("");
                        namevar.setText("");
                        lnamevar.setText("");
                        depositvar.setText("");
                        con.close();}
                }catch(Exception e){ System.out.println(e);}


            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String res_offer_id=residvar.getText();
                String name=namevar.getText();
                String lname=lnamevar.getText();
                String deposit=depositvar.getText();
                String offer_id=offeridvar.getText();
                try{

                    String sql="UPDATE reservation_offers SET name='"+name+"',lname='"+lname+"',deposit='"+deposit+"',offer_id='"+offer_id+"'"
                            +"WHERE res_offer_id="+res_offer_id;
                    if( name.isEmpty() || lname.isEmpty()  || deposit.isEmpty() || offer_id.isEmpty()){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        residvar.setText("");
                        depositvar.setText("");
                        namevar.setText("");
                        lnamevar.setText("");
                        offeridvar.setText("");
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
