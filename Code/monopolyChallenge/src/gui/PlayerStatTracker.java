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
	private static JLabel lblNewLabel_7;
	private static JLabel lblNewLabel_7_1;
	private static JLabel lblNewLabel_7_2;
	private static JLabel lblNewLabel_7_3;
	private static JLabel lblNewLabel_7_4;
	private static JLabel lblNewLabel_7_5;
	private static JLabel lblNewLabel_6_6;
	private static JLabel lblNewLabel_6_7;
	private static JLabel lblNewLabel_6_8;
	private static JLabel lblNewLabel_9;
	private static JLabel lblNewLabel_10;
	private static JLabel lblNewLabel_11;
	private static JLabel lblNewLabel_12;
	private static JLabel lblNewLabel_13;
	private static JLabel lblNewLabel_14;
	private static JLabel lblNewLabel_15;
	private static JLabel lblNewLabel_16;
	private static JLabel lblNewLabel_17;

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
		setBounds(100, 100, 704, 383);
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
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(6, 128, 149, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Money:");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(6, 151, 149, 13);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Playing:");
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_2.setBounds(6, 174, 149, 13);
		contentPane.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Position:");
		lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_3.setBounds(6, 197, 149, 13);
		contentPane.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("Bot:");
		lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_4.setBounds(6, 244, 149, 13);
		contentPane.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("ID:");
		lblNewLabel_6_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_5.setBounds(6, 219, 149, 13);
		contentPane.add(lblNewLabel_6_5);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.ORANGE);
		panel_1_1.setBounds(524, 16, 100, 100);
		contentPane.add(panel_1_1);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(524, 126, 100, 13);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_7_1 = new JLabel("New label");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_1.setBounds(524, 148, 100, 13);
		contentPane.add(lblNewLabel_7_1);
		
		lblNewLabel_7_2 = new JLabel("New label");
		lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_2.setBounds(524, 171, 100, 13);
		contentPane.add(lblNewLabel_7_2);
		
		lblNewLabel_7_3 = new JLabel("New label");
		lblNewLabel_7_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_3.setBounds(524, 194, 100, 13);
		contentPane.add(lblNewLabel_7_3);
		
		lblNewLabel_7_4 = new JLabel("New label");
		lblNewLabel_7_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_4.setBounds(524, 217, 100, 13);
		contentPane.add(lblNewLabel_7_4);
		
		lblNewLabel_7_5 = new JLabel("New label");
		lblNewLabel_7_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7_5.setBounds(524, 240, 100, 13);
		contentPane.add(lblNewLabel_7_5);
		
		lblNewLabel_6_6 = new JLabel("Imprisoned:");
		lblNewLabel_6_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_6.setBounds(6, 282, 149, 13);
		contentPane.add(lblNewLabel_6_6);
		
		lblNewLabel_6_7 = new JLabel("Banned turns:");
		lblNewLabel_6_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_7.setBounds(6, 307, 149, 13);
		contentPane.add(lblNewLabel_6_7);
		
		lblNewLabel_6_8 = new JLabel("Get Out Of Jail Cards:");
		lblNewLabel_6_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_8.setBounds(6, 332, 149, 13);
		contentPane.add(lblNewLabel_6_8);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(160, 279, 100, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(160, 304, 100, 13);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(160, 329, 100, 13);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(342, 279, 100, 13);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(342, 303, 100, 13);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(342, 328, 100, 13);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_15.setBounds(524, 278, 100, 13);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(524, 306, 100, 13);
		contentPane.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(524, 331, 100, 13);
		contentPane.add(lblNewLabel_17);
	}
	
	private static void refresh() {
//		ArrayList<Player> players = BoardSystem.getActivePlayers();
//		Player p1 = players.get(0);
//		Player p2 = players.get(1);
//		Player p3 = players.get(2);
		
		Player p1 = BoardSystem.getPlayerWithID(1);
		Player p2 = BoardSystem.getPlayerWithID(2);
		Player p3 = BoardSystem.getPlayerWithID(3);
		
		// P1
		
		lblNewLabel.setText(p1.getName());
		lblNewLabel_1.setText(String.valueOf(p1.getMoney()));
		lblNewLabel_2.setText(String.valueOf(p1.isPlaying()));
		lblNewLabel_3.setText(String.valueOf(p1.getPosition()));
		lblNewLabel_4.setText(String.valueOf(p1.getId()));
		lblNewLabel_5.setText(String.valueOf(p1.isBot()));
		lblNewLabel_9.setText(String.valueOf(p1.isImprisoned()));
		lblNewLabel_10.setText(String.valueOf(p1.getBannedTurns()));
		lblNewLabel_11.setText(String.valueOf(p1.getGetOutOfJailCards().size()));

		// P2
		lblNewLabel_8.setText(p2.getName());
		lblNewLabel_1_1.setText(String.valueOf(p2.getMoney()));
		lblNewLabel_2_1.setText(String.valueOf(p2.isPlaying()));
		lblNewLabel_3_1.setText(String.valueOf(p2.getPosition()));
		lblNewLabel_4_1.setText(String.valueOf(p2.getId()));
		lblNewLabel_5_1.setText(String.valueOf(p2.isBot()));
		lblNewLabel_12.setText(String.valueOf(p2.isImprisoned()));
		lblNewLabel_13.setText(String.valueOf(p2.getBannedTurns()));
		lblNewLabel_14.setText(String.valueOf(p2.getGetOutOfJailCards().size()));
		
		// P3
		lblNewLabel_7.setText(p3.getName());
		lblNewLabel_7_1.setText(String.valueOf(p3.getMoney()));
		lblNewLabel_7_2.setText(String.valueOf(p3.isPlaying()));
		lblNewLabel_7_3.setText(String.valueOf(p3.getPosition()));
		lblNewLabel_7_4.setText(String.valueOf(p3.getId()));
		lblNewLabel_7_5.setText(String.valueOf(p3.isBot()));
		lblNewLabel_15.setText(String.valueOf(p3.isImprisoned()));
		lblNewLabel_16.setText(String.valueOf(p3.getBannedTurns()));
		lblNewLabel_17.setText(String.valueOf(p3.getGetOutOfJailCards().size()));
	}
}
