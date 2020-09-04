import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Game {
    private Font font = new Font("Verdana", Font.BOLD, 20);
    private JFrame f = new JFrame("Game");

    public Game() {

        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 9; i++) {
            JButton b = new JButton();
            b.setPreferredSize(new Dimension(100,100));
            b.setFont(font);
            b.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent arg0) {
					b.setText("X");
				}
				@Override
				public void mouseEntered(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseExited(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mousePressed(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseReleased(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
            });
            f.add(b);
        }
        f.setVisible(true);
        f.setSize(300,300);

    }

}
