import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Request {
    class GraphicPane extends JComponent {
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
    }

    public static void main(String[] args) {
        new Request();
    }
}