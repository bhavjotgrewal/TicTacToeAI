import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Game {
	char board[][] = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
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
		f.setLayout(new GridLayout(3, 3));

		buttons.add(x0y0);
		buttons.add(x0y1);
		buttons.add(x0y2);
		buttons.add(x1y0);
		buttons.add(x1y1);
		buttons.add(x1y2);
		buttons.add(x2y0);
		buttons.add(x2y1);
		buttons.add(x2y2);

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setPreferredSize(new Dimension(100, 100));
			buttons.get(i).setFont(font);
			final Integer innerI = i;
			buttons.get(i).addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent arg0) {
					buttons.get(innerI).setText("O");

					if (innerI == 0) {
						x0y0.setText("O");
						board[0][0] = 'O';
					}

					else if (innerI == 1) {
						x0y1.setText("O");
						board[0][1] = 'O';
					}

					else if (innerI == 2) {
						x0y2.setText("O");
						board[0][2] = 'O';
					}

					else if (innerI == 3) {
						x1y0.setText("O");
						board[1][0] = 'O';

					} else if (innerI == 4) {
						x1y1.setText("O");
						board[1][1] = 'O';
					}

					else if (innerI == 5) {
						x1y2.setText("O");
						board[1][2] = 'O';

					} else if (innerI == 6) {
						x2y0.setText("O");
						board[2][0] = 'O';
					}

					else if (innerI == 7) {
						x2y1.setText("O");
						board[2][1] = 'O';
					}

					else if (innerI == 8) {
						x2y2.setText("O");
						board[2][2] = 'O';
					}

					// change on board

					Functions.Move bestMove = Functions.findBestMove(board);

					int row = bestMove.row;
					int col = bestMove.col;

					board[row][col] = 'X';

					while (true) {
						if (row == 0) {
							if (col == 0) {
								x0y0.setText("X");
							} else if (col == 1) {
								x0y1.setText("X");
							} else if (col == 2) {
								x0y2.setText("X");
							}
						} else if (row == 1) {
							if (col == 0) {
								x1y0.setText("X");
							} else if (col == 1) {
								x1y1.setText("X");
							} else if (col == 2) {
								x1y2.setText("X");
							}
						} else if (row == 2) {
							if (col == 0) {
								x2y0.setText("X");
							} else if (col == 1) {
								x2y1.setText("X");
							} else if (col == 2) {
								x2y2.setText("X");
							}
						}
						break;
					}

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
			f.add(buttons.get(i));
		}

		f.setVisible(true);
		f.setSize(300, 300);

	}

}
