import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
/**
 * The AdminWindow class allows the administrator of the system to enter his/her data.
 * @author BusyB
 */
public class AdminWindow extends JFrame {
	
	public void hello() {
		JFrame jf = new AdminWindow();
		jf.setBackground(new java.awt.Color(255, 255, 140));
		JTextPane jta = new JTextPane();
        JButton button = new JButton("OK");
        jf.setLayout(new BorderLayout());
        jf.setSize(800, 700);
        jf.add(button, BorderLayout.SOUTH);
        jf.add(jta, BorderLayout.CENTER);
        jta.setText("Hello! Welcome to BusyB! "
        		+ " It's time to set the initial settings.");
        jf.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               jf.dispose();
               adminSettingsEntry();
            }
        });
	}
	public void adminSettingsEntry() {
		JFrame adminSettings = new JFrame("Admin Settings");
		adminSettings.setLayout(new BorderLayout());
        adminSettings.setSize(800, 700);
        JTextPane jta = new JTextPane();
        adminSettings.add(jta, BorderLayout.CENTER);
        jta.setText("You are the administrator of the system."
        		+ " Please complete the following form: ");
        adminSettings.getContentPane();
        adminSettings.setLayout(null);
        JLabel title = new JLabel("Administrator Data Entry");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(700, 30);
        title.setLocation(300, 30);
        adminSettings.add(title);
        JLabel surname = new JLabel("Surname");
        surname.setFont(new Font("Arial", Font.PLAIN, 20));
        surname.setSize(100, 20);
        surname.setLocation(100, 100);
        adminSettings.add(surname);
        adminSettings.setVisible(true);
        JTextField tsurname = new JTextField();
        tsurname.setFont(new Font("Arial", Font.PLAIN, 15));
        tsurname.setSize(190, 20);
        tsurname.setLocation(300, 100);
        adminSettings.add(tsurname);
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 200);
        adminSettings.add(name);
        adminSettings.setVisible(true);
        JTextField tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(300, 200);
        adminSettings.add(tname);
        JLabel phonenumber = new JLabel("Phonenumber");
        phonenumber.setFont(new Font("Arial", Font.PLAIN, 20));
        phonenumber.setSize(100, 20);
        phonenumber.setLocation(100, 300);
        adminSettings.add(phonenumber);
        adminSettings.setVisible(true);
        JTextField tphonenumber = new JTextField();
        tphonenumber.setFont(new Font("Arial", Font.PLAIN, 15));
        tphonenumber.setSize(190, 20);
        tphonenumber.setLocation(300, 300);
        adminSettings.add(tphonenumber);
        JLabel email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 400);
        adminSettings.add(email);
        adminSettings.add(jta, BorderLayout.CENTER);
        adminSettings.setVisible(true);
        JTextField temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setLocation(300, 400);
        adminSettings.add(temail);
        JLabel birthdate = new JLabel("Birth Date");
        birthdate.setFont(new Font("Arial", Font.PLAIN, 20));
        birthdate.setSize(100, 20);
        birthdate.setLocation(100, 500);
        adminSettings.add(birthdate);
        adminSettings.setVisible(true);
        JTextField tbirthdate = new JTextField();
        tbirthdate.setFont(new Font("Arial", Font.PLAIN, 15));
        tbirthdate.setSize(190, 20);
        tbirthdate.setLocation(300, 500);
        adminSettings.add(tbirthdate);
        JButton button = new JButton("OK");
        adminSettings.add(button, BorderLayout.SOUTH);
        //button.setVisible(true);
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
        	String admnSurname = tsurname.getText();
            String admnName = tname.getText();
            String admnPhonenumber = tphonenumber.getText();
            String admnEmail = temail.getText();
            String admnBirthdate = tbirthdate.getText();
            Department admin = new Department("Administrator");
            Employee admn = new BasicEmployee(admnName, admnSurname, admnPhonenumber, admnEmail, admnBirthdate, admin.getId());
            adminSettings.dispose();
          }
        });
        /**
         * The "Administrator" department is created.
         * This department has only one Employee.
         */
        }
}
/**
 * End of AdminWindow class.
 */
