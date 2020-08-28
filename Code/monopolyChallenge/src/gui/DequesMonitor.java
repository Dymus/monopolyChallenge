package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BoardSystem;
import model.DrawableCard;

import javax.swing.JLabel;
import javax.swing.JList;

public class DequesMonitor extends JFrame implements Runnable {

	private JPanel contentPane;
	private static JList list;
	private static JList list_1;
	
	@Override
	public void run() {
		main(null);
		while (true) {
			refresh();
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
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
					DequesMonitor frame = new DequesMonitor();
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
	public DequesMonitor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 40, 217, 355);
		contentPane.add(panel);
		
		list = new JList();
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(287, 40, 217, 355);
		contentPane.add(panel_1);
		
		list_1 = new JList();
		panel_1.add(list_1);
		
		JLabel lblNewLabel = new JLabel("Chance cards:");
		lblNewLabel.setBounds(99, 12, 88, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Community chest cards:");
		lblNewLabel_1.setBounds(319, 12, 153, 16);
		contentPane.add(lblNewLabel_1);
	}

	public static void refresh() {
		// Setting chance cards list
		{
			Deque<DrawableCard> chanceCards = BoardSystem.getChanceCards();
			
			ArrayList<String> chanceCardsArrayList = new ArrayList<>();
			Iterator<DrawableCard> chanceIt = chanceCards.iterator();
			DefaultListModel chanceModel = new DefaultListModel();
			
			while (chanceIt.hasNext()) {
				DrawableCard currentChanceCard = chanceIt.next();
				chanceCardsArrayList.add(currentChanceCard.toString());
			}
			
			for (String s : chanceCardsArrayList) {
				chanceModel.addElement(s);
			}
			
			list.setModel(chanceModel);
		}
		
		// Setting community chest cards list
		{
			Deque<DrawableCard> communityChestCards = BoardSystem.getCommunityChestCards();
		
			ArrayList<String> communityChestCardsArrayList = new ArrayList<>();
			Iterator<DrawableCard> communityIt = communityChestCards.iterator();
			DefaultListModel communityModel = new DefaultListModel();
			
			while (communityIt.hasNext()) {
				DrawableCard currentCommunityChestCard = communityIt.next();
				communityChestCardsArrayList.add(currentCommunityChestCard.toString());
			}
			
			for (String s : communityChestCardsArrayList) {
				communityModel.addElement(s);
			}
			
			list_1.setModel(communityModel);
		}
		
	}
}
