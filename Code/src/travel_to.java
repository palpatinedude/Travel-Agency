import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class travel_to extends  JDialog{
    private JPanel panel1;
    private JTextField totrvar;
    private JTextField dstvar;
    private JTextField arrivalvar;
    private JTextField departurevar;
    private JButton INSERTButton;
    private JButton PRINTButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;

    public travel_to(JFrame parent) {
        super(parent);
        setTitle("TRAVEL_TO");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                String to_tr_id=totrvar.getText();
                String to_dst_id=dstvar.getText();
                String to_arrival=arrivalvar.getText();
                String to_departure=departurevar.getText();

                if(to_arrival.isEmpty() || to_departure.isEmpty() || to_tr_id.isEmpty() || to_dst_id.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    totrvar.setText("");
                    departurevar.setText("");
                    dstvar.setText("");
                    arrivalvar.setText("");

                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO travel_to(to_tr_id,to_dst_id,to_arrival,to_departure) VALUES(?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,totrvar.getText());
                        st.setString(2,dstvar.getText());
                        st.setString(3,arrivalvar.getText());
                        st.setString(4,departurevar.getText());



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

                String to_tr_id=totrvar.getText();
                String to_dst_id=dstvar.getText();
                String to_arrival=arrivalvar.getText();
                String to_departure=departurevar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM travel_to WHERE to_tr_id=? ";
                    if( to_arrival.isEmpty() || to_departure.isEmpty()  || to_dst_id.isEmpty() ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,totrvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        totrvar.setText("");
                        arrivalvar.setText("");
                        departurevar.setText("");
                        dstvar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                String to_tr_id=totrvar.getText();
                String to_dst_id=dstvar.getText();
                String to_arrival=arrivalvar.getText();
                String to_departure=departurevar.getText();
                try{

                    String sql="UPDATE travel_to SET to_dst_id='"+to_dst_id+"',to_arrival='"+to_arrival+"',to_departure='"+to_departure+"'"
                            +"WHERE to_tr_id="+to_tr_id;
                    if( to_arrival.isEmpty() || to_departure.isEmpty()  || to_dst_id.isEmpty() ){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        totrvar.setText("");
                        dstvar.setText("");
                        arrivalvar.setText("");
                        departurevar.setText("");

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
