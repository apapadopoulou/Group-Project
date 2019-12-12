import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Request {
    class GraphicPane extends JComponent {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GraphicPane() {
            super();
        }
    
        @Override public void paint(Graphics g) {
            g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
            g.drawString("Hello,please type your request", 30, 30);
        }
    }
    
    public Request() {
        JFrame jf = new JFrame("Request");
        GraphicPane gp = new GraphicPane();
        
        jf.setBounds(0,0, 800, 600);
        jf.setLayout(new BorderLayout());        
        jf.add(gp, BorderLayout.CENTER);
        
        // Remember, the method show() is deprecated
        jf.setVisible(true);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        Container contentPane = jf.getContentPane();  
        SpringLayout layout = new SpringLayout();  
        contentPane.setLayout(layout);  

          
        JTextField textField = new JTextField("", 15);  
         
        contentPane.add(textField);  
   
        
        
        layout.putConstraint(SpringLayout.NORTH, textField,6,SpringLayout.NORTH, contentPane);  
        layout.putConstraint(SpringLayout.EAST, contentPane,6,SpringLayout.EAST, textField);  
        layout.putConstraint(SpringLayout.SOUTH, contentPane,6,SpringLayout.SOUTH, textField);  

        jf.pack();  
        jf.setVisible(true);  
    }  
   
    public static void main(String[] args) {
        new Request();
          }  
   }
