import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
public class AdminWindow extends JFrame {
	//This class allows the administrator of the system to enter his/her data.
	public void hello() {
		JFrame jf = new AdminWindow();
		JTextPane jta = new JTextPane();
        JButton button = new JButton("OK");
        jf.setLayout(new BorderLayout());
        jf.setSize(400, 300);
        jf.add(button, BorderLayout.SOUTH);
        jf.add(jta, BorderLayout.CENTER);
        jta.setText("Hello! Welcome to BusyB! "
        		+ " It's time to set the initial settings.");
        jf.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               jf.dispose();
               adminSettingsEntry();
            }
        });
	}
	public void adminSettingsEntry() {
		JFrame adminSettings = new JFrame("Admin Settings");
		adminSettings.setLayout(new BorderLayout());
        adminSettings.setSize(400, 300);
        JTextPane jta = new JTextPane();
        adminSettings.add(jta, BorderLayout.CENTER);
        jta.setText("You are the administrator of the system."
        		+ " Please complete the following form: ");
        adminSettings.getContentPane();
        adminSettings.setLayout(null);
        JLabel title = new JLabel("Administrator Data Entry");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
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
        tsurname.setLocation(200, 100);
        adminSettings.add(tsurname);
        JLabel  = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        adminSettings.add(name);
        adminSettings.setVisible(true);
        JTextField tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        adminSettings.add(tname);
	}
	public static void main (String [] args) {
		AdminWindow aw = new AdminWindow();
		aw.hello();
	
	}
}
