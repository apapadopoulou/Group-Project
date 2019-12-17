import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
public class Admin {
	private int sigrating;
	private String fullname;
	private String department;
	public Admin(int sigrating, String fullname, String department) {
		this.sigrating = sigrating;
		this.fullname = fullname;
		this.department = department;
	}
	public int getSigrating() {
		return sigrating;
	}
	public void setSigrating(int sigrating) {
		this.sigrating = sigrating;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public static void hello() {
		JFrame jf = new JFrame("Hello!");
		JTextPane jta = new JTextPane();
        JButton button = new JButton("OK");
        jf.setLayout(new BorderLayout());
        jf.setSize(400, 300);
        jf.add(button, BorderLayout.SOUTH);
        jf.add(jta, BorderLayout.CENTER);
        jta.setText("Hello! Welcome to BusyB! "
        		+ " It's time to set the initial settings.");
        jf.setVisible(true);
	}
	public static void initialDataEntry() {
		addWindowListener(new WindowAdapter()
	      {
	      public void windowClosing(WindowEvent e)
	      {
	         dispose();
	         System.exit(0); //calling the method is a must
	      }
	      });
	}
	public static void main (String [] args) {
		hello();
	}

}
