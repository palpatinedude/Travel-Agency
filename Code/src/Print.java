import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Print extends  JDialog {
    private JPanel panel1;
    private JTable table1;
    private JButton EXITButton;
    private JScrollPane showtable;

    public Print(JFrame parent) {
        setTitle("Display");
        setContentPane(panel1);
        setContentPane(table1);
        setContentPane(showtable);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        try{
            String sql="SELECT * FROM worker";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travel_agency", "root", "28022002");
            PreparedStatement pt=con.prepareStatement(sql);
            ResultSet rs=pt.executeQuery();
            DefaultTableModel model= (DefaultTableModel) table1.getModel();
            while(rs.next()){
                model.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        }catch (Exception e){System.out.println("Error : "+e.getMessage());}

        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}







