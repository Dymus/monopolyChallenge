package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ctr.CardSetManager;
import model.BoardSystem;
import model.CardSet;
import model.CardSetType;
import model.Player;
import model.Property;
import model.City;

import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JSplitPane;

public class CardSetTracker extends JFrame implements Runnable {
	private static CardSetManager csM;
	private static JLabel lblNewLabel;
	private static JLabel lblNewLabel_19;
	private static JLabel lblNewLabel_24;
	private static JLabel lblNewLabel_19_1;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_25;
	private static JLabel lblNewLabel_2;
	private static JLabel lblNewLabel_26;
	private static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_27;
	private static JLabel lblNewLabel_4;
	private static JLabel lblNewLabel_28;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_29;
	private static JLabel lblNewLabel_6;
	private static JLabel lblNewLabel_30;
	private static JLabel lblNewLabel_7;
	private static JLabel lblNewLabel_23;
	private static JLabel lblNewLabel_8;
	private static JLabel lblNewLabel_31;
	private static JLabel lblNewLabel_9;
	private static JLabel lblNewLabel_33;
	private static JLabel lblNewLabel_10;
	private static JLabel lblNewLabel_34;
	private static JLabel lblNewLabel_11;
	private static JLabel lblNewLabel_35;
	private static JLabel lblNewLabel_12;
	private static JLabel lblNewLabel_36;
	private static JLabel lblNewLabel_13;
	private static JLabel lblNewLabel_37;
	private static JLabel lblNewLabel_14;
	private static JLabel lblNewLabel_38;
	private static JLabel lblNewLabel_15;
	private static JLabel lblNewLabel_16;
	private static JLabel lblNewLabel_17;
	private static JLabel lblNewLabel_18;
	private static JLabel lblNewLabel_20;
	private static JLabel lblNewLabel_21;
	private static JLabel lblNewLabel_22;
	private static JLabel lblNewLabel_32;
	private JPanel contentPane;
	private static JLabel lblNewLabel_39;
	private static JLabel lblNewLabel_40;
	private static JLabel lblNewLabel_41;
	private static JLabel lblNewLabel_42;
	private static JLabel lblNewLabel_43;
	private static JLabel lblNewLabel_44;
	private static JLabel lblNewLabel_45;
	private static JLabel lblNewLabel_46;
	private static JLabel lblNewLabel_47;
	private static JLabel lblNewLabel_48;
	private static JLabel lblNewLabel_49;
	private static JLabel lblNewLabel_50;
	private static JLabel lblNewLabel_51;
	private static JLabel lblNewLabel_52;
	private static JLabel lblNewLabel_53;
	private static JLabel lblNewLabel_54;
	private static JLabel lblNewLabel_55;
	private static JLabel lblNewLabel_56;
	private static JLabel lblNewLabel_57;
	private static JLabel lblNewLabel_58;
	private static JLabel lblNewLabel_59;
	private static JLabel lblNewLabel_60;
	private static JLabel lblNewLabel_61;
	private static JLabel lblNewLabel_62;
	private static JLabel lblNewLabel_63;
	private static JLabel lblNewLabel_64;
	private static JLabel lblNewLabel_65;
	private static JLabel lblNewLabel_66;
	private static JLabel lblNewLabel_67;
	private static JLabel lblNewLabel_68;
	private static JLabel lblNewLabel_69;
	private static JLabel lblNewLabel_70;
	private static JLabel lblNewLabel_71;
	private static JLabel lblNewLabel_72;
	private static JLabel lblNewLabel_73;
	private static JLabel lblNewLabel_74;
	private static JLabel lblNewLabel_75;
	private static JLabel lblNewLabel_76;
	private static JLabel lblNewLabel_77;
	private static JLabel lblNewLabel_78;

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
					CardSetTracker frame = new CardSetTracker(csM);
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
	public CardSetTracker(CardSetManager csM) {
		this.csM = csM; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Brown:");
		lblNewLabel.setForeground(new Color(160, 82, 45));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_19 = new JLabel("Owner:");
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 7;
		gbc_lblNewLabel_19.gridy = 1;
		contentPane.add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		lblNewLabel_24 = new JLabel("Green:");
		lblNewLabel_24.setForeground(new Color(0, 128, 0));
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_24.gridx = 12;
		gbc_lblNewLabel_24.gridy = 1;
		contentPane.add(lblNewLabel_24, gbc_lblNewLabel_24);
		
		lblNewLabel_19_1 = new JLabel("Owner:");
		GridBagConstraints gbc_lblNewLabel_19_1 = new GridBagConstraints();
		gbc_lblNewLabel_19_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_19_1.gridx = 19;
		gbc_lblNewLabel_19_1.gridy = 1;
		contentPane.add(lblNewLabel_19_1, gbc_lblNewLabel_19_1);
		
		lblNewLabel_1 = new JLabel("MEDITERRANEAN AVENUE");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_39 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_39 = new GridBagConstraints();
		gbc_lblNewLabel_39.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_39.gridx = 7;
		gbc_lblNewLabel_39.gridy = 2;
		contentPane.add(lblNewLabel_39, gbc_lblNewLabel_39);
		
		lblNewLabel_25 = new JLabel("PACIFIC AVENUE");
		GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
		gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_25.gridx = 13;
		gbc_lblNewLabel_25.gridy = 2;
		contentPane.add(lblNewLabel_25, gbc_lblNewLabel_25);
		
		lblNewLabel_56 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_56 = new GridBagConstraints();
		gbc_lblNewLabel_56.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_56.gridx = 19;
		gbc_lblNewLabel_56.gridy = 2;
		contentPane.add(lblNewLabel_56, gbc_lblNewLabel_56);
		
		lblNewLabel_2 = new JLabel("BALTIC AVENUE");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		lblNewLabel_40 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_40 = new GridBagConstraints();
		gbc_lblNewLabel_40.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_40.gridx = 7;
		gbc_lblNewLabel_40.gridy = 3;
		contentPane.add(lblNewLabel_40, gbc_lblNewLabel_40);
		
		lblNewLabel_26 = new JLabel("NORTH CAROLINA AVENUE");
		GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
		gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_26.gridx = 13;
		gbc_lblNewLabel_26.gridy = 3;
		contentPane.add(lblNewLabel_26, gbc_lblNewLabel_26);
		
		lblNewLabel_57 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_57 = new GridBagConstraints();
		gbc_lblNewLabel_57.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_57.gridx = 19;
		gbc_lblNewLabel_57.gridy = 3;
		contentPane.add(lblNewLabel_57, gbc_lblNewLabel_57);
		
		lblNewLabel_3 = new JLabel("Light blue:");
		lblNewLabel_3.setForeground(new Color(0, 191, 255));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_27 = new JLabel("PENNSYLVANIA AVENUE");
		GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
		gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_27.gridx = 13;
		gbc_lblNewLabel_27.gridy = 4;
		contentPane.add(lblNewLabel_27, gbc_lblNewLabel_27);
		
		lblNewLabel_58 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_58 = new GridBagConstraints();
		gbc_lblNewLabel_58.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_58.gridx = 19;
		gbc_lblNewLabel_58.gridy = 4;
		contentPane.add(lblNewLabel_58, gbc_lblNewLabel_58);
		
		lblNewLabel_4 = new JLabel("ORIENTAL AVENUE");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_41 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_41 = new GridBagConstraints();
		gbc_lblNewLabel_41.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_41.gridx = 7;
		gbc_lblNewLabel_41.gridy = 5;
		contentPane.add(lblNewLabel_41, gbc_lblNewLabel_41);
		
		lblNewLabel_28 = new JLabel("Dark blue:");
		lblNewLabel_28.setForeground(new Color(0, 0, 255));
		GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
		gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_28.gridx = 12;
		gbc_lblNewLabel_28.gridy = 5;
		contentPane.add(lblNewLabel_28, gbc_lblNewLabel_28);
		
		lblNewLabel_5 = new JLabel("VERMONT AVENUE");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_42 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_42 = new GridBagConstraints();
		gbc_lblNewLabel_42.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_42.gridx = 7;
		gbc_lblNewLabel_42.gridy = 6;
		contentPane.add(lblNewLabel_42, gbc_lblNewLabel_42);
		
		lblNewLabel_29 = new JLabel("PARK PLACE");
		GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
		gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_29.gridx = 13;
		gbc_lblNewLabel_29.gridy = 6;
		contentPane.add(lblNewLabel_29, gbc_lblNewLabel_29);
		
		lblNewLabel_59 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_59 = new GridBagConstraints();
		gbc_lblNewLabel_59.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_59.gridx = 19;
		gbc_lblNewLabel_59.gridy = 6;
		contentPane.add(lblNewLabel_59, gbc_lblNewLabel_59);
		
		lblNewLabel_6 = new JLabel("CONNECTICUT AVENUE");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 7;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblNewLabel_43 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_43 = new GridBagConstraints();
		gbc_lblNewLabel_43.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_43.gridx = 7;
		gbc_lblNewLabel_43.gridy = 7;
		contentPane.add(lblNewLabel_43, gbc_lblNewLabel_43);
		
		lblNewLabel_30 = new JLabel("BOARDWALK");
		GridBagConstraints gbc_lblNewLabel_30 = new GridBagConstraints();
		gbc_lblNewLabel_30.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_30.gridx = 13;
		gbc_lblNewLabel_30.gridy = 7;
		contentPane.add(lblNewLabel_30, gbc_lblNewLabel_30);
		
		lblNewLabel_60 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_60 = new GridBagConstraints();
		gbc_lblNewLabel_60.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_60.gridx = 19;
		gbc_lblNewLabel_60.gridy = 7;
		contentPane.add(lblNewLabel_60, gbc_lblNewLabel_60);
		
		lblNewLabel_7 = new JLabel("Pink:");
		lblNewLabel_7.setForeground(new Color(255, 0, 255));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridheight = 2;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 8;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("ST.CHARLES PLACE");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 10;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		lblNewLabel_44 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_44 = new GridBagConstraints();
		gbc_lblNewLabel_44.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_44.gridx = 7;
		gbc_lblNewLabel_44.gridy = 10;
		contentPane.add(lblNewLabel_44, gbc_lblNewLabel_44);
		
		lblNewLabel_9 = new JLabel("STATES AVENUE");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 11;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		lblNewLabel_45 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_45 = new GridBagConstraints();
		gbc_lblNewLabel_45.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_45.gridx = 7;
		gbc_lblNewLabel_45.gridy = 11;
		contentPane.add(lblNewLabel_45, gbc_lblNewLabel_45);
		
		lblNewLabel_10 = new JLabel("VIRGINIA AVENUE");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 12;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		lblNewLabel_46 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_46 = new GridBagConstraints();
		gbc_lblNewLabel_46.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_46.gridx = 7;
		gbc_lblNewLabel_46.gridy = 12;
		contentPane.add(lblNewLabel_46, gbc_lblNewLabel_46);
		
		lblNewLabel_11 = new JLabel("Orange:");
		lblNewLabel_11.setForeground(new Color(255, 165, 0));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 13;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("ST. JAMES PLACE");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 2;
		gbc_lblNewLabel_12.gridy = 14;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		lblNewLabel_47 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_47 = new GridBagConstraints();
		gbc_lblNewLabel_47.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_47.gridx = 7;
		gbc_lblNewLabel_47.gridy = 14;
		contentPane.add(lblNewLabel_47, gbc_lblNewLabel_47);
		
		lblNewLabel_13 = new JLabel("TENNESSEE AVENUE");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 2;
		gbc_lblNewLabel_13.gridy = 15;
		contentPane.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		lblNewLabel_48 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_48 = new GridBagConstraints();
		gbc_lblNewLabel_48.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_48.gridx = 7;
		gbc_lblNewLabel_48.gridy = 15;
		contentPane.add(lblNewLabel_48, gbc_lblNewLabel_48);
		
		lblNewLabel_14 = new JLabel("NEW YORK AVENUE");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 2;
		gbc_lblNewLabel_14.gridy = 16;
		contentPane.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		lblNewLabel_49 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_49 = new GridBagConstraints();
		gbc_lblNewLabel_49.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_49.gridx = 7;
		gbc_lblNewLabel_49.gridy = 16;
		contentPane.add(lblNewLabel_49, gbc_lblNewLabel_49);
		
		lblNewLabel_23 = new JLabel("Railroads:");
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_23.gridx = 12;
		gbc_lblNewLabel_23.gridy = 16;
		contentPane.add(lblNewLabel_23, gbc_lblNewLabel_23);
		
		lblNewLabel_15 = new JLabel("Red:");
		lblNewLabel_15.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 1;
		gbc_lblNewLabel_15.gridy = 17;
		contentPane.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		lblNewLabel_31 = new JLabel("READING RAILROAD");
		GridBagConstraints gbc_lblNewLabel_31 = new GridBagConstraints();
		gbc_lblNewLabel_31.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_31.gridx = 13;
		gbc_lblNewLabel_31.gridy = 17;
		contentPane.add(lblNewLabel_31, gbc_lblNewLabel_31);
		
		lblNewLabel_61 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_61 = new GridBagConstraints();
		gbc_lblNewLabel_61.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_61.gridx = 19;
		gbc_lblNewLabel_61.gridy = 17;
		contentPane.add(lblNewLabel_61, gbc_lblNewLabel_61);
		
		lblNewLabel_16 = new JLabel("KENTUCKY AVENUE");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 2;
		gbc_lblNewLabel_16.gridy = 18;
		contentPane.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		lblNewLabel_50 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_50 = new GridBagConstraints();
		gbc_lblNewLabel_50.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_50.gridx = 7;
		gbc_lblNewLabel_50.gridy = 18;
		contentPane.add(lblNewLabel_50, gbc_lblNewLabel_50);
		
		lblNewLabel_33 = new JLabel("PENNSYLVANIA RAILROAD");
		GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
		gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_33.gridx = 13;
		gbc_lblNewLabel_33.gridy = 18;
		contentPane.add(lblNewLabel_33, gbc_lblNewLabel_33);
		
		lblNewLabel_62 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_62 = new GridBagConstraints();
		gbc_lblNewLabel_62.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_62.gridx = 19;
		gbc_lblNewLabel_62.gridy = 18;
		contentPane.add(lblNewLabel_62, gbc_lblNewLabel_62);
		
		lblNewLabel_17 = new JLabel("INDIANA AVENUE");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 2;
		gbc_lblNewLabel_17.gridy = 19;
		contentPane.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		lblNewLabel_51 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_51 = new GridBagConstraints();
		gbc_lblNewLabel_51.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_51.gridx = 7;
		gbc_lblNewLabel_51.gridy = 19;
		contentPane.add(lblNewLabel_51, gbc_lblNewLabel_51);
		
		lblNewLabel_34 = new JLabel("B. & O. RAILROAD");
		GridBagConstraints gbc_lblNewLabel_34 = new GridBagConstraints();
		gbc_lblNewLabel_34.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_34.gridx = 13;
		gbc_lblNewLabel_34.gridy = 19;
		contentPane.add(lblNewLabel_34, gbc_lblNewLabel_34);
		
		lblNewLabel_63 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_63 = new GridBagConstraints();
		gbc_lblNewLabel_63.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_63.gridx = 19;
		gbc_lblNewLabel_63.gridy = 19;
		contentPane.add(lblNewLabel_63, gbc_lblNewLabel_63);
		
		lblNewLabel_18 = new JLabel("ILLINOI AVENUE");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 2;
		gbc_lblNewLabel_18.gridy = 20;
		contentPane.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		lblNewLabel_52 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_52 = new GridBagConstraints();
		gbc_lblNewLabel_52.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_52.gridx = 7;
		gbc_lblNewLabel_52.gridy = 20;
		contentPane.add(lblNewLabel_52, gbc_lblNewLabel_52);
		
		lblNewLabel_35 = new JLabel("SHORT LINE");
		GridBagConstraints gbc_lblNewLabel_35 = new GridBagConstraints();
		gbc_lblNewLabel_35.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_35.gridx = 13;
		gbc_lblNewLabel_35.gridy = 20;
		contentPane.add(lblNewLabel_35, gbc_lblNewLabel_35);
		
		lblNewLabel_64 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_64 = new GridBagConstraints();
		gbc_lblNewLabel_64.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_64.gridx = 19;
		gbc_lblNewLabel_64.gridy = 20;
		contentPane.add(lblNewLabel_64, gbc_lblNewLabel_64);
		
		lblNewLabel_20 = new JLabel("Yellow:");
		lblNewLabel_20.setForeground(new Color(255, 255, 0));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 1;
		gbc_lblNewLabel_20.gridy = 21;
		contentPane.add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		lblNewLabel_36 = new JLabel("Utilies:");
		GridBagConstraints gbc_lblNewLabel_36 = new GridBagConstraints();
		gbc_lblNewLabel_36.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_36.gridx = 12;
		gbc_lblNewLabel_36.gridy = 21;
		contentPane.add(lblNewLabel_36, gbc_lblNewLabel_36);
		
		lblNewLabel_21 = new JLabel("ATLANTIC AVENUE");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_21.gridx = 2;
		gbc_lblNewLabel_21.gridy = 22;
		contentPane.add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		lblNewLabel_53 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_53 = new GridBagConstraints();
		gbc_lblNewLabel_53.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_53.gridx = 7;
		gbc_lblNewLabel_53.gridy = 22;
		contentPane.add(lblNewLabel_53, gbc_lblNewLabel_53);
		
		lblNewLabel_37 = new JLabel("ELECTRIC COMPANY");
		GridBagConstraints gbc_lblNewLabel_37 = new GridBagConstraints();
		gbc_lblNewLabel_37.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_37.gridx = 13;
		gbc_lblNewLabel_37.gridy = 22;
		contentPane.add(lblNewLabel_37, gbc_lblNewLabel_37);
		
		lblNewLabel_65 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_65 = new GridBagConstraints();
		gbc_lblNewLabel_65.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_65.gridx = 19;
		gbc_lblNewLabel_65.gridy = 22;
		contentPane.add(lblNewLabel_65, gbc_lblNewLabel_65);
		
		lblNewLabel_22 = new JLabel("VENTNOR AVENUE");
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_22.gridx = 2;
		gbc_lblNewLabel_22.gridy = 23;
		contentPane.add(lblNewLabel_22, gbc_lblNewLabel_22);
		
		lblNewLabel_54 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_54 = new GridBagConstraints();
		gbc_lblNewLabel_54.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_54.gridx = 7;
		gbc_lblNewLabel_54.gridy = 23;
		contentPane.add(lblNewLabel_54, gbc_lblNewLabel_54);
		
		lblNewLabel_38 = new JLabel("WATER WORKS");
		GridBagConstraints gbc_lblNewLabel_38 = new GridBagConstraints();
		gbc_lblNewLabel_38.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_38.gridx = 13;
		gbc_lblNewLabel_38.gridy = 23;
		contentPane.add(lblNewLabel_38, gbc_lblNewLabel_38);
		
		lblNewLabel_66 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_66 = new GridBagConstraints();
		gbc_lblNewLabel_66.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_66.gridx = 19;
		gbc_lblNewLabel_66.gridy = 23;
		contentPane.add(lblNewLabel_66, gbc_lblNewLabel_66);
		
		lblNewLabel_32 = new JLabel("MARVIN GARDENS");
		GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
		gbc_lblNewLabel_32.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_32.gridx = 2;
		gbc_lblNewLabel_32.gridy = 24;
		contentPane.add(lblNewLabel_32, gbc_lblNewLabel_32);
		
		lblNewLabel_55 = new JLabel("None");
		GridBagConstraints gbc_lblNewLabel_55 = new GridBagConstraints();
		gbc_lblNewLabel_55.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_55.gridx = 7;
		gbc_lblNewLabel_55.gridy = 24;
		contentPane.add(lblNewLabel_55, gbc_lblNewLabel_55);
		
		lblNewLabel_67 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_67 = new GridBagConstraints();
		gbc_lblNewLabel_67.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_67.gridx = 3;
		gbc_lblNewLabel_67.gridy = 25;
		contentPane.add(lblNewLabel_67, gbc_lblNewLabel_67);
		
		lblNewLabel_68 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_68 = new GridBagConstraints();
		gbc_lblNewLabel_68.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_68.gridx = 4;
		gbc_lblNewLabel_68.gridy = 25;
		contentPane.add(lblNewLabel_68, gbc_lblNewLabel_68);
		
		lblNewLabel_69 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_69 = new GridBagConstraints();
		gbc_lblNewLabel_69.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_69.gridx = 5;
		gbc_lblNewLabel_69.gridy = 25;
		contentPane.add(lblNewLabel_69, gbc_lblNewLabel_69);
		
		lblNewLabel_70 = new JLabel("xxx");
		GridBagConstraints gbc_lblNewLabel_70 = new GridBagConstraints();
		gbc_lblNewLabel_70.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_70.gridx = 6;
		gbc_lblNewLabel_70.gridy = 25;
		contentPane.add(lblNewLabel_70, gbc_lblNewLabel_70);
		
		lblNewLabel_71 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_71 = new GridBagConstraints();
		gbc_lblNewLabel_71.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_71.gridx = 8;
		gbc_lblNewLabel_71.gridy = 25;
		contentPane.add(lblNewLabel_71, gbc_lblNewLabel_71);
		
		lblNewLabel_72 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_72 = new GridBagConstraints();
		gbc_lblNewLabel_72.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_72.gridx = 9;
		gbc_lblNewLabel_72.gridy = 25;
		contentPane.add(lblNewLabel_72, gbc_lblNewLabel_72);
		
		lblNewLabel_73 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_73 = new GridBagConstraints();
		gbc_lblNewLabel_73.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_73.gridx = 10;
		gbc_lblNewLabel_73.gridy = 25;
		contentPane.add(lblNewLabel_73, gbc_lblNewLabel_73);
		
		lblNewLabel_78 = new JLabel("xxx");
		GridBagConstraints gbc_lblNewLabel_78 = new GridBagConstraints();
		gbc_lblNewLabel_78.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_78.gridx = 11;
		gbc_lblNewLabel_78.gridy = 25;
		contentPane.add(lblNewLabel_78, gbc_lblNewLabel_78);
		
		lblNewLabel_74 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_74 = new GridBagConstraints();
		gbc_lblNewLabel_74.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_74.gridx = 14;
		gbc_lblNewLabel_74.gridy = 25;
		contentPane.add(lblNewLabel_74, gbc_lblNewLabel_74);
		
		lblNewLabel_75 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_75 = new GridBagConstraints();
		gbc_lblNewLabel_75.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_75.gridx = 15;
		gbc_lblNewLabel_75.gridy = 25;
		contentPane.add(lblNewLabel_75, gbc_lblNewLabel_75);
		
		lblNewLabel_76 = new JLabel("x");
		GridBagConstraints gbc_lblNewLabel_76 = new GridBagConstraints();
		gbc_lblNewLabel_76.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_76.gridx = 16;
		gbc_lblNewLabel_76.gridy = 25;
		contentPane.add(lblNewLabel_76, gbc_lblNewLabel_76);
		
		lblNewLabel_77 = new JLabel("xxx");
		GridBagConstraints gbc_lblNewLabel_77 = new GridBagConstraints();
		gbc_lblNewLabel_77.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_77.gridx = 17;
		gbc_lblNewLabel_77.gridy = 25;
		contentPane.add(lblNewLabel_77, gbc_lblNewLabel_77);
	}
	
	private static void refresh() {
		CardSet brown = csM.getCardSetWithCardSetType(CardSetType.BROWN);		
		CardSet lightBlue = csM.getCardSetWithCardSetType(CardSetType.LIGHT_BLUE);
		CardSet pink = csM.getCardSetWithCardSetType(CardSetType.PINK);
		CardSet orange = csM.getCardSetWithCardSetType(CardSetType.ORANGE);
		CardSet red = csM.getCardSetWithCardSetType(CardSetType.RED);
		CardSet yellow = csM.getCardSetWithCardSetType(CardSetType.YELLOW);
		CardSet green = csM.getCardSetWithCardSetType(CardSetType.GREEN);
		CardSet darkBlue = csM.getCardSetWithCardSetType(CardSetType.DARK_BLUE);
		
		CardSet railroads = csM.getCardSetWithCardSetType(CardSetType.RAILROADS);
		CardSet utilities = csM.getCardSetWithCardSetType(CardSetType.UTILITIES);
		
		if ( ((City) brown.getCardWithBoardPosition(2)).isOwned() ) lblNewLabel_39.setText(((City) brown.getCardWithBoardPosition(2)).getOwner().getName());
		else lblNewLabel_39.setText("None");
		
		if ( ((City) brown.getCardWithBoardPosition(4)).isOwned() ) lblNewLabel_40.setText(((City) brown.getCardWithBoardPosition(4)).getOwner().getName());
		else lblNewLabel_40.setText("None");
		
		if ( ((Property) railroads.getCardWithBoardPosition(6)).isOwned() ) lblNewLabel_61.setText(((Property) railroads.getCardWithBoardPosition(6)).getOwner().getName());
		else lblNewLabel_61.setText("None");
		
		if ( ((City) lightBlue.getCardWithBoardPosition(7)).isOwned() ) lblNewLabel_41.setText(((City) lightBlue.getCardWithBoardPosition(7)).getOwner().getName());
		else lblNewLabel_41.setText("None");
			
		if ( ((City) lightBlue.getCardWithBoardPosition(9)).isOwned() ) lblNewLabel_42.setText(((City) lightBlue.getCardWithBoardPosition(9)).getOwner().getName());
		else lblNewLabel_42.setText("None");
		
		if ( ((City) lightBlue.getCardWithBoardPosition(10)).isOwned() ) lblNewLabel_43.setText(((City) lightBlue.getCardWithBoardPosition(10)).getOwner().getName());
		else lblNewLabel_43.setText("None");
		
		if ( ((City) pink.getCardWithBoardPosition(12)).isOwned() ) lblNewLabel_44.setText(((City) pink.getCardWithBoardPosition(12)).getOwner().getName());
		else lblNewLabel_44.setText("None");
		
		if ( ((Property) utilities.getCardWithBoardPosition(13)).isOwned() ) lblNewLabel_65.setText(((Property) utilities.getCardWithBoardPosition(13)).getOwner().getName());
		else lblNewLabel_65.setText("None");
		
		if ( ((City) pink.getCardWithBoardPosition(15)).isOwned() ) lblNewLabel_46.setText(((City) pink.getCardWithBoardPosition(15)).getOwner().getName());
		else lblNewLabel_46.setText("None");
		
		if ( ((Property) railroads.getCardWithBoardPosition(16)).isOwned() ) lblNewLabel_62.setText(((Property) railroads.getCardWithBoardPosition(16)).getOwner().getName());
		else lblNewLabel_62.setText("None");
		
		if ( ((City) orange.getCardWithBoardPosition(17)).isOwned() ) lblNewLabel_47.setText(((City) orange.getCardWithBoardPosition(17)).getOwner().getName());
		else lblNewLabel_47.setText("None");
		
		if ( ((City) orange.getCardWithBoardPosition(19)).isOwned() ) lblNewLabel_48.setText(((City) orange.getCardWithBoardPosition(19)).getOwner().getName());
		else lblNewLabel_48.setText("None");
		
		if ( ((City) orange.getCardWithBoardPosition(20)).isOwned() ) lblNewLabel_49.setText(((City) orange.getCardWithBoardPosition(20)).getOwner().getName());
		else lblNewLabel_49.setText("None");
		
		if ( ((City) red.getCardWithBoardPosition(22)).isOwned() ) lblNewLabel_50.setText(((City) red.getCardWithBoardPosition(22)).getOwner().getName());
		else lblNewLabel_50.setText("None");
		
		if ( ((City) red.getCardWithBoardPosition(24)).isOwned() ) lblNewLabel_51.setText(((City) red.getCardWithBoardPosition(24)).getOwner().getName());
		else lblNewLabel_51.setText("None");
		
		if ( ((City) red.getCardWithBoardPosition(25)).isOwned() ) lblNewLabel_52.setText(((City) red.getCardWithBoardPosition(25)).getOwner().getName());
		else lblNewLabel_52.setText("None");
		
		if ( ((Property) railroads.getCardWithBoardPosition(26)).isOwned() ) lblNewLabel_63.setText(((Property) railroads.getCardWithBoardPosition(26)).getOwner().getName());
		else lblNewLabel_63.setText("None");
		
		if ( ((City) yellow.getCardWithBoardPosition(27)).isOwned() ) lblNewLabel_53.setText(((City) yellow.getCardWithBoardPosition(27)).getOwner().getName());
		else lblNewLabel_53.setText("None");
		
		if ( ((City) yellow.getCardWithBoardPosition(28)).isOwned() ) lblNewLabel_54.setText(((City) yellow.getCardWithBoardPosition(28)).getOwner().getName());
		else lblNewLabel_54.setText("None");
		
		if ( ((Property) utilities.getCardWithBoardPosition(29)).isOwned() ) lblNewLabel_66.setText(((Property) utilities.getCardWithBoardPosition(29)).getOwner().getName());
		else lblNewLabel_66.setText("None");

		if ( ((City) yellow.getCardWithBoardPosition(30)).isOwned() ) lblNewLabel_55.setText(((City) yellow.getCardWithBoardPosition(30)).getOwner().getName());
		else lblNewLabel_55.setText("None");
		
		if ( ((City) green.getCardWithBoardPosition(32)).isOwned() ) lblNewLabel_56.setText(((City) green.getCardWithBoardPosition(32)).getOwner().getName());
		else lblNewLabel_56.setText("None");
		
		if ( ((City) green.getCardWithBoardPosition(33)).isOwned() ) lblNewLabel_57.setText(((City) green.getCardWithBoardPosition(33)).getOwner().getName());
		else lblNewLabel_57.setText("None");
		
		if ( ((City) green.getCardWithBoardPosition(35)).isOwned() ) lblNewLabel_58.setText(((City) green.getCardWithBoardPosition(35)).getOwner().getName());
		else lblNewLabel_58.setText("None");
		
		if ( ((Property) railroads.getCardWithBoardPosition(36)).isOwned() ) lblNewLabel_64.setText(((Property) railroads.getCardWithBoardPosition(36)).getOwner().getName());
		else lblNewLabel_64.setText("None");
		
		if ( ((City) darkBlue.getCardWithBoardPosition(38)).isOwned() ) lblNewLabel_59.setText(((City) darkBlue.getCardWithBoardPosition(38)).getOwner().getName());
		else lblNewLabel_59.setText("None");
		
		if ( ((City) darkBlue.getCardWithBoardPosition(40)).isOwned() ) lblNewLabel_60.setText(((City) darkBlue.getCardWithBoardPosition(40)).getOwner().getName());
		else lblNewLabel_60.setText("None");
	}
}
