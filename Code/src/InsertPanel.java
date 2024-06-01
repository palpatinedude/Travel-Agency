import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InsertPanel extends JDialog {
    private JPanel panel1;
    private JButton ok1;
    private JButton ok2;
    private JButton ok3;
    private JButton ok4;
    private JButton ok5;
    private JButton ok6;
    private JButton ok7;
    private JButton ok8;
    private JButton ok9;
    private JButton ok10;
    private JButton ok11;
    private JButton ok12;
    private JButton ok13;
    private JButton ok14;
    private JButton ok15;
    private JButton ok16;
    private JButton ok17;
    private JButton ok18;
    private JButton CANCELButton;


    public InsertPanel(JFrame parent) {
        super(parent);
        setTitle("ACTION");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 650));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ok1.addActionListener(new ActionListener() {//admin
            @Override
            public void actionPerformed(ActionEvent e) {
                admin admin=new admin(null);
                admin.show();

            }
        });
        ok2.addActionListener(new ActionListener() {//branch
            @Override
            public void actionPerformed(ActionEvent e) {
                branch branch=new branch(null);
                branch.show();
            }
        });
        ok3.addActionListener(new ActionListener() {//destination
            @Override
            public void actionPerformed(ActionEvent e) {
                destination dst=new destination(null);
                dst.show();

            }
        });
        ok4.addActionListener(new ActionListener() {//driver
            @Override
            public void actionPerformed(ActionEvent e) {
                driver drv=new driver(null);
                drv.show();

            }
        });
        ok5.addActionListener(new ActionListener() {//event
            @Override
            public void actionPerformed(ActionEvent e) {
                event event=new event(null);
                event.show();

            }
        });
        ok6.addActionListener(new ActionListener() {//guide
            @Override
            public void actionPerformed(ActionEvent e) {
                guide gui=new guide(null);
                gui.show();

            }
        });

        ok7.addActionListener(new ActionListener() {//it
            @Override
            public void actionPerformed(ActionEvent e) {
                it it =new it(null);
                it.show();

            }
        });
        ok8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//language
                language lng=new language(null);
                lng.show();

            }
        });
        ok9.addActionListener(new ActionListener() {//log_reservation
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ok10.addActionListener(new ActionListener() {//log_trip
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ok11.addActionListener(new ActionListener() {//manages
            @Override
            public void actionPerformed(ActionEvent e) {
                manages mng=new manages(null);
                mng.show();

            }
        });
        ok12.addActionListener(new ActionListener() {//offers
            @Override
            public void actionPerformed(ActionEvent e) {
                offers offers=new offers(null);
                offers.show();

            }
        });
        ok13.addActionListener(new ActionListener() {//phone
            @Override
            public void actionPerformed(ActionEvent e) {
                phone phone=new phone(null);
                phone.show();

            }
        });
        ok14.addActionListener(new ActionListener() {//reservation
            @Override
            public void actionPerformed(ActionEvent e) {
                reservation res=new reservation(null);
                res.show();

            }
        });
        ok15.addActionListener(new ActionListener() {//reservation_offers
            @Override
            public void actionPerformed(ActionEvent e) {
                reservation_offers resoffers=new reservation_offers(null);
                resoffers.show();

            }
        });
        ok16.addActionListener(new ActionListener() {//travel_to
            @Override
            public void actionPerformed(ActionEvent e) {
                travel_to totr=new travel_to(null);
                totr.show();
            }
        });
        ok17.addActionListener(new ActionListener() {//trip
            @Override
            public void actionPerformed(ActionEvent e) {
                trip tr=new trip(null);
                tr.show();

            }
        });
        ok18.addActionListener(new ActionListener() {//worker
            @Override
            public void actionPerformed(ActionEvent e) {
                worker worker=new worker(null);
                worker.show();
            }
        });

        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });setVisible(true);
    }

}
