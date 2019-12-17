import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
public class AdminWindow extends JFrame {
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
        jta.setText("You are the administrator of the system. Please complete the following form: ");
        adminSettings.setVisible(true);
	}
	public static void main (String [] args) {
		AdminWindow aw = new AdminWindow();
		aw.hello();
	
	}
}
