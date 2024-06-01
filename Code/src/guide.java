import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class guide extends  JDialog{
    private JPanel panel1;
    private JTextField gui_ATvar;
    private JTextField gui_langvar;
    private JButton PRINTButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JButton INSERTButton;

    public guide(JFrame parent) {
        super(parent);
        setTitle("GUIDE");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String gui_AT=gui_ATvar.getText();
                String gui_language=gui_langvar.getText();
                if(gui_AT.isEmpty() || gui_language.isEmpty()  ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    gui_ATvar.setText("");
                    gui_langvar.setText("");


                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO guide(gui_AT,gui_cv) VALUES(?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,gui_ATvar.getText());
                        st.setString(2,gui_langvar.getText());


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
                String gui_AT=gui_ATvar.getText();
                String gui_language=gui_langvar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM guide WHERE gui_AT=? ";
                    if( gui_language.isEmpty() || gui_AT.isEmpty()    ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,gui_ATvar.getText());



                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        gui_ATvar.setText("");
                        gui_langvar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String gui_AT=gui_ATvar.getText();
                String gui_language=gui_langvar.getText();
                try{

                    String sql="UPDATE guide SET gui_cv='"+gui_language+"'"
                            +"WHERE gui_AT="+gui_AT;
                    if( gui_AT.isEmpty() || gui_language.isEmpty()   ){
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        gui_langvar.setText("");
                        gui_ATvar.setText("");

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
