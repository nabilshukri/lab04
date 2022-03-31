package tcpservertranslate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param output 
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Language Translator");
		title.setBounds(202, 0, 309, 89);
		title.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 26));
		contentPane.add(title);
		
		JLabel englishtitle = new JLabel("English");
		englishtitle.setBounds(279, 116, 104, 33);
		englishtitle.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 24));
		contentPane.add(englishtitle);
		
		JTextArea englishArea = new JTextArea();
		englishArea.setBounds(132, 159, 379, 62);
		contentPane.add(englishArea);
		
		JLabel BMlbl = new JLabel("1. Bahasa Malaysia");
		BMlbl.setBounds(143, 312, 252, 33);
		BMlbl.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 24));
		contentPane.add(BMlbl);
		
		JLabel Arabiclbl = new JLabel("2. Arabic");
		Arabiclbl.setBounds(142, 355, 203, 33);
		Arabiclbl.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 24));
		contentPane.add(Arabiclbl);
		
		JLabel Koreanlbl = new JLabel("3. Korean");
		Koreanlbl.setBounds(143, 398, 192, 33);
		Koreanlbl.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 24));
		contentPane.add(Koreanlbl);
		
		JTextArea choiceArea = new JTextArea();
		choiceArea.setBounds(178, 448, 62, 48);
		contentPane.add(choiceArea);
		
		JButton tButton = new JButton("Enter");
		tButton.setBounds(262, 448, 104, 48);
		tButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String english = englishArea.getText();
				String choice = choiceArea.getText();
				try {
					Translator trans = new Translator(english,choice);
					dispose();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//trans.String(english);
			}
		});
		tButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
		contentPane.add(tButton);
		
		JLabel lblTranslateTo = new JLabel("Translate to");
		lblTranslateTo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 26));
		lblTranslateTo.setBounds(132, 244, 309, 89);
		contentPane.add(lblTranslateTo);
		
		
	}
	
}
