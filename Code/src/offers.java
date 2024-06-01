import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class offers extends  JDialog{
    private JPanel panel1;
    private JTextField offeridvar;
    private JTextField startvar;
    private JTextField endvar;
    private JTextField costvar;
    private JTextField dstidvar;
    private JButton PRINTButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JButton INSERTButton;

    public offers(JFrame parent) {
        super(parent);
        setTitle("OFFERS");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String offer_id=offeridvar.getText();
                String start_date=startvar.getText();
                String end_date=endvar.getText();
                String cost_per=costvar.getText();
                String offer_dst_id=dstidvar.getText();

                if(offer_id.isEmpty() || offer_dst_id.isEmpty() || end_date.isEmpty() || start_date.isEmpty() || cost_per.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    offeridvar.setText("");
                    startvar.setText("");
                    endvar.setText("");
                    costvar.setText("");
                    dstidvar.setText("");
                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO offers(offer_id,start_date,end_date,cost_per,offer_dst_id) VALUES(?,?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,offeridvar.getText());
                        st.setString(2,startvar.getText());
                        st.setString(3,endvar.getText());
                        st.setString(4,costvar.getText());
                        st.setString(5,dstidvar.getText());


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
                String offer_id=offeridvar.getText();
                String start_date=startvar.getText();
                String end_date=endvar.getText();
                String cost_per=costvar.getText();
                String offer_dst_id=dstidvar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM offers WHERE offer_id=? ";
                    if( offer_dst_id.isEmpty() || end_date.isEmpty()  || start_date.isEmpty() || cost_per.isEmpty() ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,offeridvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        offeridvar.setText("");
                        startvar.setText("");
                        endvar.setText("");
                        costvar.setText("");
                        dstidvar.setText("");
                        con.close();}
                }catch(Exception e){ System.out.println(e);}


            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String offer_id=offeridvar.getText();
                String start_date=startvar.getText();
                String end_date=endvar.getText();
                String cost_per=costvar.getText();
                String offer_dst_id=dstidvar.getText();
                try{

                    String sql="UPDATE worker SET start_date='"+start_date+"',end_date='"+end_date+"',cost_per='"+cost_per+"',offer_dst_id='"+offer_dst_id+"'"
                            +"WHERE offer_id="+offer_id;
                    if( end_date.isEmpty() || start_date.isEmpty()  || cost_per.isEmpty() || offer_dst_id.isEmpty()){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        offeridvar.setText("");
                        startvar.setText("");
                        endvar.setText("");
                        costvar.setText("");
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
