package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BoardSystem;
import model.Player;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

public class PlayerStatTracker extends JFrame implements Runnable {
	private static JPanel contentPane;
	private static JPanel panel;
	private static JPanel panel_1;
	private static JLabel lblNewLabel;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_4;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_5_1;
	private static JLabel lblNewLabel_4_1;
	private static JLabel lblNewLabel_3_1;
	private static JLabel lblNewLabel_2_1;
	private static JLabel lblNewLabel_1_1;
	private static JLabel lblNewLabel_8;

	@Override
	public void run() {
		main(null);	
		while(true) {
			refresh();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerStatTracker frame = new PlayerStatTracker();
					frame.setAlwaysOnTop (true);
					refresh();
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
	public PlayerStatTracker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(160, 16, 100, 100);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(160, 126, 100, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(160, 149, 100, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(160, 172, 100, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(160, 195, 100, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(160, 218, 100, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(160, 241, 100, 13);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_5_1 = new JLabel("New label");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(342, 241, 100, 13);
		contentPane.add(lblNewLabel_5_1);
		
		lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(342, 218, 100, 13);
		contentPane.add(lblNewLabel_4_1);
		
		lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(342, 195, 100, 13);
		contentPane.add(lblNewLabel_3_1);
		
		lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(342, 172, 100, 13);
		contentPane.add(lblNewLabel_2_1);
		
		lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(342, 149, 100, 13);
		contentPane.add(lblNewLabel_1_1);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(342, 126, 100, 13);
		contentPane.add(lblNewLabel_8);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(342, 16, 100, 100);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_6 = new JLabel("Name:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(62, 125, 100, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Money:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(62, 148, 100, 13);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Playing:");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_2.setBounds(62, 171, 100, 13);
		contentPane.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Position:");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_3.setBounds(62, 194, 100, 13);
		contentPane.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("Bot:");
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_4.setBounds(62, 241, 100, 13);
		contentPane.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("ID:");
		lblNewLabel_6_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_5.setBounds(62, 216, 100, 13);
		contentPane.add(lblNewLabel_6_5);
	}
	
	private static void refresh() {
		ArrayList<Player> players = BoardSystem.getActivePlayers();
		Player p1 = players.get(0);
		Player p2 = players.get(1);
		
		// P1
		
		lblNewLabel.setText(p1.getName());
		lblNewLabel_1.setText(String.valueOf(p1.getMoney()));
		lblNewLabel_2.setText(String.valueOf(p1.isPlaying()));
		lblNewLabel_3.setText(String.valueOf(p1.getPosition()));
		lblNewLabel_4.setText(String.valueOf(p1.getId()));
		lblNewLabel_5.setText(String.valueOf(p1.isBot()));

		// P2
		lblNewLabel_8.setText(p2.getName());
		lblNewLabel_1_1.setText(String.valueOf(p2.getMoney()));
		lblNewLabel_2_1.setText(String.valueOf(p2.isPlaying()));
		lblNewLabel_3_1.setText(String.valueOf(p2.getPosition()));
		lblNewLabel_4_1.setText(String.valueOf(p2.getId()));
		lblNewLabel_5_1.setText(String.valueOf(p2.isBot()));
	}
}
