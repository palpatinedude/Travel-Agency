import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class event extends  JDialog{
    private JPanel panel1;
    private JTextField evtrvar;
    private JTextField evstartvar;
    private JTextField evendvar;
    private JTextField evdescrvar;
    private JButton INSERTButton;
    private JButton PRINTButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;

    public event(JFrame parent){
        super(parent);
        setTitle("EVENT");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String ev_id=evtrvar.getText();
                String ev_start=evstartvar.getText();
                String ev_end=evendvar.getText();
                String ev_descr=evdescrvar.getText();
                if(ev_end.isEmpty() || ev_id.isEmpty() || ev_descr.isEmpty() || ev_start.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                    evdescrvar.setText("");
                    evendvar.setText("");
                    evtrvar.setText("");
                    evdescrvar.setText("");

                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="INSERT INTO event(ev_tr_id,ev_start,ev_end,ev_descr) VALUES(?,?,?,?)";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1,evtrvar.getText());
                        st.setString(2,evstartvar.getText());
                        st.setString(3,evendvar.getText());
                        st.setString(4,evdescrvar.getText());



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
                String ev_id=evtrvar.getText();
                String ev_start=evstartvar.getText();
                String ev_end=evendvar.getText();
                String ev_descr=evdescrvar.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                    //here travel_agency is database name, root is username and 28022002 password
                    String sql="DELETE FROM event WHERE ev_tr_id=? ";
                    if( ev_end.isEmpty() || ev_start.isEmpty()  || ev_descr.isEmpty() ){
                        PreparedStatement st=con.prepareStatement(sql);
                        st.setString(1, evtrvar.getText());


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored deleted");
                        evtrvar.setText("");
                        evendvar.setText("");
                        evstartvar.setText("");
                        evdescrvar.setText("");

                        con.close();}
                }catch(Exception e){ System.out.println(e);}

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String ev_id=evtrvar.getText();
                String ev_start=evstartvar.getText();
                String ev_end=evendvar.getText();
                String ev_descr=evdescrvar.getText();
                try{

                    String sql="UPDATE event SET ev_start='"+ev_start+"',ev_end='"+ev_end+"',ev_descr='"+ev_descr+"'"
                            +"WHERE ev_tr_id="+ev_id;
                    if( ev_end.isEmpty() || ev_descr.isEmpty()  || ev_start.isEmpty() ){
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        evendvar.setText("");
                        evstartvar.setText("");
                        evtrvar.setText("");
                        evdescrvar.setText("");

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
