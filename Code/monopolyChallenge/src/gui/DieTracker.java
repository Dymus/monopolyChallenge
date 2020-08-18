package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Die;

import javax.swing.JLabel;

public class DieTracker extends JFrame implements Runnable {

	private static JPanel contentPane;
	private static JLabel lblNewLabel;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_4;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_6;
	private static JLabel lblNewLabel_7;
	private static JLabel lblNewLabel_8;
	private static JLabel lblNewLabel_9;
	
	
	

	
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
					DieTracker frame = new DieTracker();
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
	public DieTracker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("First roll:");
		lblNewLabel.setBounds(22, 21, 129, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Second roll:");
		lblNewLabel_1.setBounds(22, 49, 129, 16);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Result:");
		lblNewLabel_2.setBounds(22, 77, 129, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Rolled double:");
		lblNewLabel_3.setBounds(22, 105, 129, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Times rolled double:");
		lblNewLabel_4.setBounds(22, 133, 129, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(163, 21, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(163, 49, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(163, 77, 61, 16);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(163, 105, 61, 16);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(163, 133, 61, 16);
		contentPane.add(lblNewLabel_9);
	}
	
	private static void refresh() { 
		lblNewLabel_5.setText(String.valueOf(Die.getFirstRoll()));
		lblNewLabel_6.setText(String.valueOf(Die.getSecondRoll()));
		lblNewLabel_7.setText(String.valueOf(Die.getResult()));
		lblNewLabel_8.setText(String.valueOf(Die.isRolledDouble()));
		lblNewLabel_9.setText(String.valueOf(Die.getTimesRolledDouble()));
	}
}
