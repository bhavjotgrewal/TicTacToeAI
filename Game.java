import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Game {
	final char board[][] = {{ '_', '_', '_' }, 
                      { '_', '_', '_' }, 
                      { '_', '_', '_' }}; 
    private Font font = new Font("Verdana", Font.BOLD, 20);
	private JFrame f = new JFrame("Game");

	ArrayList<JButton> buttons = new ArrayList<JButton>();

	JButton x0y0 = new JButton();
	JButton x0y1 = new JButton();
	JButton x0y2 = new JButton();
	JButton x1y0 = new JButton();
	JButton x1y1 = new JButton();
	JButton x1y2 = new JButton();
	JButton x2y0 = new JButton();
	JButton x2y1 = new JButton();
	JButton x2y2 = new JButton();	

	int row;
	int col;

    public Game() {

        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(3,3));

		buttons.add(x0y0);
		buttons.add(x0y1);
		buttons.add(x0y2);
		buttons.add(x1y0);
		buttons.add(x1y1);
		buttons.add(x1y2);
		buttons.add(x2y0);
		buttons.add(x2y1);
		buttons.add(x2y2);

		for (JButton button: buttons) {
			button.setPreferredSize(new Dimension(100,100));
			button.setFont(font);
			button.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent arg0) {
					button.setText("O");
					doMove(board, x0y0, x0y1, x0y2,  x1y0, x1y1, x1y2, x2y0, x2y1, x2y2);
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
			f.add(button);
		}
		
        f.setVisible(true);
		f.setSize(300,300);

	}

	static void doMove(char board[][], JButton x0y0, JButton x0y1, JButton x0y2, JButton x1y0, JButton x1y1, JButton x1y2, JButton x2y0, JButton x2y1, JButton x2y2 ) {
		
		Functions.Move bestMove = Functions.findBestMove(board);

			int row = bestMove.row;
			int col = bestMove.col;

			board[row][col] = 'X';

			if (row == 0) {
				if (col == 0) {
					x0y0.setText("X");
				}
				else if (col == 1) {
					x0y1.setText("X");
				}
				else if (col == 2) {
					x0y2.setText("X");
				}
			}
			else if (row == 1) {
				if (col == 0) {
					x1y0.setText("X");
				}
				else if (col == 1) {
					x1y1.setText("X");
				}
				else if (col == 2) {
					x1y2.setText("X");
				}
			}
			else if (row == 2) {
				if (col == 0) {
					x2y0.setText("X");
				}
				else if (col == 1) {
					x2y1.setText("X");
				}
				else if (col == 2) {
					x2y2.setText("X");
				}
			}
	}

}
