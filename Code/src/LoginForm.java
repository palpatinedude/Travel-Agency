import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class LoginForm extends JDialog{
    private JPanel loginpanel;
    private JTextField tfusername;
    private JPasswordField tfpassword;
    private JButton login;
    private JButton cancel;

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginpanel);
        setMinimumSize(new Dimension(450,250));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=tfusername.getText();
                String password=tfpassword.getText();

                user=getUser(username,password);
                if(user!=null){
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(LoginForm.this,"Username or Password invalid or incomplete fields","try again",JOptionPane.ERROR_MESSAGE);
                    tfusername.setText("");
                    tfpassword.setText("");
                }

            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });setVisible(true);
    }

    public static User user;
    private User getUser(String username,String password){
        User user=null;
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter all fields", "try again!", JOptionPane.ERROR_MESSAGE);
            tfusername.setText("");
            tfpassword.setText("");
            return null;
        }
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/travel_agency","root","28022002");
                //here travel_agency is database name, root is username and 28022002 password
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery( "SELECT * FROM it WHERE it_AT='"+username+"'AND password='"+password+"'");
                if (rs.next()) {
                    user = new User();
                    user.username = rs.getString("it_AT");
                    user.password = rs.getString("password");
                    dispose();
                }
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                con.close();
                st.close();
            }catch(Exception e){ System.out.println(e);}

        return user;
        }
}



