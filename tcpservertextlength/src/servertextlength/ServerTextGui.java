package servertextlength;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerTextGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerTextGui frame = new ServerTextGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerTextGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Words Counter");
		title.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 25));
		title.setBounds(254, 44, 281, 39);
		contentPane.add(title);
		
		JLabel lblEnterText = new JLabel("Enter text:");
		lblEnterText.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 20));
		lblEnterText.setBounds(49, 110, 281, 39);
		contentPane.add(lblEnterText);
		
		textField = new JTextField();
		textField.setBounds(49, 146, 561, 142);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Count");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				try {
					WordCount wordCount = new WordCount(text);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		btnNewButton.setBounds(521, 300, 89, 29);
		contentPane.add(btnNewButton);
	}
}
