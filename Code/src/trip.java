import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class trip extends  JDialog{
    private JPanel panel1;
    private JTextField tridvar;
    private JTextField departurevar;
    private JTextField returnvar;
    private JTextField seatsvar;
    private JTextField costvar;
    private JTextField brcodevar;
    private JTextField guivar;
    private JTextField drvvar;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JButton PRINTButton;
    private JButton INSERTButton;

    public trip(JFrame parent) {
        super(parent);
        setTitle("TRIP");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        INSERTButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent a) {
                String tr_id=tridvar.getText();
                String tr_departure=departurevar.getText();
                String tr_return=returnvar.getText();
                String tr_maxseats=seatsvar.getText();
                String tr_cost=costvar.getText();
                String tr_gui_AT=guivar.getText();
                String tr_drv_AT=drvvar.getText();
                String tr_br_code=brcodevar.getText();

                    if(tr_br_code.isEmpty() || tr_cost.isEmpty() || tr_departure.isEmpty() || tr_gui_AT.isEmpty() || tr_return.isEmpty() || tr_drv_AT.isEmpty() || tr_maxseats.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter all data");
                        tridvar.setText("");
                        seatsvar.setText("");
                        costvar.setText("");
                        departurevar.setText("");
                        returnvar.setText("");
                        drvvar.setText("");
                        guivar.setText("");
                        brcodevar.setText("");
                    }else{
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection(
                                    "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                            //here travel_agency is database name, root is username and 28022002 password
                            String sql="INSERT INTO trip(tr_id,tr_departure,tr_return,tr_maxseats,tr_cost,tr_br_code,tr_gui_AT,tr_drv_AT) VALUES(?,?,?,?,?,?,?,?)";
                            PreparedStatement st=con.prepareStatement(sql);
                            st.setString(1,tridvar.getText());
                            st.setString(2,departurevar.getText());
                            st.setString(3,returnvar.getText());
                            st.setString(4,seatsvar.getText());
                            st.setString(5,costvar.getText());
                            st.setString(6,brcodevar.getText());
                            st.setString(7,guivar.getText());
                            st.setString(8,drvvar.getText());

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
                String tr_id=tridvar.getText();
                String tr_departure=departurevar.getText();
                String tr_return=returnvar.getText();
                String tr_maxseats=seatsvar.getText();
                String tr_cost=costvar.getText();
                String tr_gui_AT=guivar.getText();
                String tr_drv_AT=drvvar.getText();
                String tr_br_code=brcodevar.getText();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        //here travel_agency is database name, root is username and 28022002 password
                        String sql="DELETE FROM trip WHERE tr_id=? ";
                        if( tr_drv_AT.isEmpty() || tr_maxseats.isEmpty()  || tr_return.isEmpty() || tr_gui_AT.isEmpty() || tr_departure.isEmpty()   || tr_cost.isEmpty() || tr_br_code.isEmpty() ){
                            PreparedStatement st=con.prepareStatement(sql);
                            st.setString(1,tridvar.getText());

                            st.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Recored deleted");
                            guivar.setText("");
                            drvvar.setText("");
                            brcodevar.setText("");
                            returnvar.setText("");
                            departurevar.setText("");
                            seatsvar.setText("");
                            costvar.setText("");
                            tridvar.setText("");
                            con.close();}
                    }catch(Exception e){ System.out.println(e);}

                }


        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String tr_id=tridvar.getText();
                String tr_departure=departurevar.getText();
                String tr_return=returnvar.getText();
                String tr_maxseats=seatsvar.getText();
                String tr_cost=costvar.getText();
                String tr_gui_AT=guivar.getText();
                String tr_drv_AT=drvvar.getText();
                String tr_br_code=brcodevar.getText();
                try{

                    String sql="UPDATE trip SET tr_departure='"+tr_departure+"',tr_return='"+tr_return+"',tr_maxseats='"+tr_maxseats+"'tr_cost='"+tr_cost+"',tr_gui_AT='"+tr_gui_AT+"',tr_drv_AT='"+tr_drv_AT+"',tr_br_code='"+tr_br_code+"'"
                            +"WHERE tr_id="+tr_id;
                    if( tr_br_code.isEmpty() || tr_cost.isEmpty()  || tr_departure.isEmpty() || tr_return.isEmpty() || tr_gui_AT.isEmpty()  || tr_maxseats.isEmpty() || tr_drv_AT.isEmpty()){

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Recored updated");
                        tridvar.setText("");
                        departurevar.setText("");
                        returnvar.setText("");
                        seatsvar.setText("");
                        costvar.setText("");
                        brcodevar.setText("");
                        guivar.setText("");
                        drvvar.setText("");
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
