import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class it extends  JDialog{
    private JPanel panel1;
    private JTextField itATvar;
    private JTextField itpassvar;
    private JTextField startvar;
    private JTextField endvar;
    private JButton UPDATEButton;
    private JButton PRINTButton;
    private JButton INSERTButton;
    private JButton DELETEButton;

    public it(JFrame parent) {
        super(parent);
        setTitle("IT");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String it_AT=itATvar.getText();
                String it_pass=itpassvar.getText();
                String it_start=startvar.getText();
                String it_end=endvar.getText();
                if(it_AT.isEmpty() || it_pass.isEmpty() || it_start.isEmpty() || it_end.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    itATvar.setText("");
                    itpassvar.setText("");
                    endvar.setText("");
                    startvar.setText("");

                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO it(it_AT,it_password,id_start,it_end) VALUES(?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,itATvar.getText());
                        st.setString(2,itpassvar.getText());
                        st.setString(3,startvar.getText());
                        st.setString(4,endvar.getText());



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
                String it_AT=itATvar.getText();
                String it_pass=itpassvar.getText();
                String it_start=startvar.getText();
                String it_end=endvar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM it WHERE it_AT=? ";
                    if( it_pass.isEmpty() || it_end.isEmpty()  || it_start.isEmpty() ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,itpassvar.getText());



                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        itpassvar.setText("");
                        itATvar.setText("");
                        endvar.setText("");
                        startvar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String it_AT=itATvar.getText();
                String it_pass=itpassvar.getText();
                String it_start=startvar.getText();
                String it_end=endvar.getText();
                try{

                    String sql="UPDATE it SET it_password='"+it_pass+"',it_start='"+it_start+"',it_end='"+it_end+"'"
                            +"WHERE it_AT="+it_AT;
                    if( it_end.isEmpty() || it_start.isEmpty()  || it_pass.isEmpty() ){
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        itATvar.setText("");
                        itpassvar.setText("");
                        endvar.setText("");
                        startvar.setText("");

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
