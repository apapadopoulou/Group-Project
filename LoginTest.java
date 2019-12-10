import javax.swing.JFrame;
import javax.swing.JComponent;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Graphics;

import java.awt.image.BufferedImage;

public class ImageDemo {
    class GraphicPane extends JComponent {
        private BufferedImage bi;
        private JFrame parent;

        public GraphicPane(JFrame parent) {
            this.parent = parent;
            try {
                // reads a file
                this.bi = ImageIO.read(new File("background.png"));
            } catch (IOException ioe) {
                System.err.println("Could not load image");
            }
        }

        @Override public void paint(Graphics g) {
            // drawImage(Image img, int x, int y, ImageObserver observer)
            g.drawImage(bi, 0, 0, parent);
        }
    }

    public ImageDemo() {
        JFrame jf = new JFrame("Hello, World!");
        GraphicPane gp = new GraphicPane(jf);

        jf.setBounds(0,0, 800, 600);
        jf.setLayout(new BorderLayout());
        jf.add(gp, BorderLayout.CENTER);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ImageDemo();
    }
}