import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class phone extends  JDialog{
    private JPanel panel1;
    private JTextField phbrvar;
    private JTextField numvar;
    private JButton PRINTButton;
    private JButton UPDATEButton;
    private JButton INSERTButton;
    private JButton DELETEButton;

    public phone(JFrame parent) {
        super(parent);
        setTitle("PHONE");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                String ph_br_code=phbrvar.getText();
                String ph_number=numvar.getText();

                if(ph_br_code.isEmpty() || ph_number.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    phbrvar.setText("");
                    numvar.setText("");

                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO phone(ph_br_code,ph_number) VALUES(?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,phbrvar.getText());
                        st.setString(2,numvar.getText());



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

                String ph_br_code=phbrvar.getText();
                String ph_number=numvar.getText();

                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM phone WHERE ph_br_code=? ";
                    if( ph_number.isEmpty()   ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,phbrvar.getText());



                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        phbrvar.setText("");
                        numvar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}
            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                String ph_br_code=phbrvar.getText();
                String ph_number=numvar.getText();
                try{

                    String sql="UPDATE phone SET ph_number='"+ph_number+"'"
                            +"WHERE ph_br_code="+ph_br_code;
                    if(ph_number.isEmpty()  ){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        phbrvar.setText("");
                        numvar.setText("");

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
