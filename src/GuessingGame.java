import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnGuess;
	private int theNumber;
	private int countTries=1;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message="";
		try
		{		int guess=Integer.parseInt(guessText);
		if (guess < theNumber) {
			message = guess + " is too low. Try again.";
			countTries++;
		}
		else if (guess > theNumber) {
			message = guess + " is too high. Try again.";
			countTries++;
		}
		else {
			message = guess + " is correct. You won in "+countTries+" tries";
			countTries=1;
			btnGuess.setText("Play again");
			
			btnGuess.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					newGame();
				}
			});
		}
		}catch(Exception e) {
			message="Enter a whole number between 1 and 100";
		}finally
		{lblOutput.setText(message);
		txtGuess.requestFocus();
		txtGuess.selectAll();
		}
	}

	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		btnGuess.setText("Guess!");
	}

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tanishq's HiLow Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to HiLow guessing game !!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(100, 11, 228, 48);
		getContentPane().add(lblNewLabel);

		lblOutput = new JLabel("Guess a num between 1 and 100 :");
		lblOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(10, 70, 282, 35);
		getContentPane().add(lblOutput);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(302, 79, 46, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		btnGuess = new JButton("Guess !");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuess.setBounds(151, 131, 99, 23);
		getContentPane().add(btnGuess);

		JLabel lblNewLabel_2 = new JLabel("Enter a num above and click Guess");
		lblNewLabel_2.setBounds(120, 189, 208, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Or click Finish to exit ->");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(115, 223, 135, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Finish !");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			}
		);
		btnNewButton.setBounds(249, 219, 89, 23);
		getContentPane().add(btnNewButton);
}
		public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}	
}
