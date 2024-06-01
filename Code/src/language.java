import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class language extends  JDialog{
    private JPanel panel1;
    private JTextField lngguivar;
    private JTextField lngvar;
    private JButton UPDATEButton;
    private JButton PRINTButton;
    private JButton DELETEButton;
    private JButton INSERTButton;

    public language(JFrame parent) {
        super(parent);
        setTitle("LANGUAGE");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String lng_AT=lngguivar.getText();
                String lng=lngvar.getText();
                if(lng_AT.isEmpty() || lng.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    lngguivar.setText("");
                    lngvar.setText("");

                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO language(lng_gui_AT,lng_language) VALUES(?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,lngguivar.getText());
                        st.setString(2,lngvar.getText());



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
                String lng_AT=lngguivar.getText();
                String lng=lngvar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM language WHERE lng_gui_AT=? ";
                    if( lng.isEmpty()   ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,lngguivar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        lngguivar.setText("");
                        lngvar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String lng_AT=lngguivar.getText();
                String lng=lngvar.getText();
                try{

                    String sql="UPDATE language SET lng_language='"+lng+"'"
                            +"WHERE lng_gui_AT="+lng_AT;
                    if(lng.isEmpty()  ){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        lngvar.setText("");
                        lngguivar.setText("");

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
