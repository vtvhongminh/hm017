package Managerment_pd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.table.DefaultTableModel;

import DAO.ModulCus;

import Model.Customer;


public class SwingShowCus {
	private static JFrame f = new JFrame();

	JButton b1, b2, b3, b4, b5, b6;
	static JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	static JLabel lb1, lb2, lb3, lb4, lb5, lb6;

	private static DefaultTableModel model = new DefaultTableModel();
	private static JTable jtable;
	private static JPanel pn;
	private static ModulCus md = new ModulCus();
	// GridBagConstraints gbc = new GridBagConstraints();

	public static <T> void ShowData(String title, List<Customer> x) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(1000, 1000);
		f.setTitle("CUSTOMER MANAGERMENT");
		jtable = new JTable(model);
		model.addColumn("Code");
		model.addColumn("Name");
		model.addColumn("Quality");
		/////////
	
		/////////
		for (Customer p : x) {
			model.addRow(new Object[] { p.ccode, p.cus_name, p.phone });
		}
		model.fireTableDataChanged();
		pn = new JPanel();
		pn.setPreferredSize(new Dimension(600, 600));
		pn.add(new JScrollPane(jtable));

		JPanel panel = new JPanel(new GridBagLayout());
		f.add(panel);
		f.setSize(1000, 1000);

		f.getContentPane().add(panel, BorderLayout.NORTH);

		GridBagConstraints c = new GridBagConstraints();

		JButton b1 = new JButton("Add");
		b1.setPreferredSize(new Dimension(140, 40));
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String h = null, g = null, z = null;
				
			
				h = tf1.getText();
				g = tf2.getText();
				z = tf3.getText();
				
				md.addData(h, g, z);
				md.displayData();
			
			}
		});
		c.gridx = 0;
		c.gridy = 1;
		panel.add(b1, c);
		c.insets = new Insets(10, 10, 10, 10);
		///////////
		JButton b2 = new JButton("Delete");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				md.removeByNote(tf6.getText());
				
			
			}
			
		});
		b2.setPreferredSize(new Dimension(140, 40));
		c.gridx = 0;
		c.gridy = 2;
		panel.add(b2, c);

		JButton b3 = new JButton("Delete after Code");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				md.removeByAfNode(tf6.getText().trim());
			}
		});
		b3.setPreferredSize(new Dimension(140, 40));
		c.gridx = 0;
		c.gridy = 3;
		panel.add(b3, c);

		JButton b4 = new JButton("Search");
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				md.searchByPcode(tf6.getText());
			}
		});
		b4.setPreferredSize(new Dimension(140, 40));
		c.gridx = 0;
		c.gridy = 4;
		panel.add(b4, c);

		JButton b5 = new JButton("Sort");
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				md.sortByPcode();
			}
		});
		b5.setPreferredSize(new Dimension(140, 40));
		c.gridx = 0;
		c.gridy = 5;
		panel.add(b5, c);

		c.gridx = 0;
		c.gridy = 6;
		JButton b6 = new JButton("Save to File");
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				md.SavePdl();
				
			}
		});
		b6.setPreferredSize(new Dimension(140, 40));
		panel.add(b6, c);

		tf1 = new JTextField("Code");
		tf1.setPreferredSize(new Dimension(150, 40));
		c.gridx = 2;
		c.gridy = 1;
		panel.add(tf1, c);

		tf2 = new JTextField("Name");
		tf2.setPreferredSize(new Dimension(150, 40));
		c.gridx = 2;
		c.gridy = 2;
		panel.add(tf2, c);

		tf3 = new JTextField("09129999");
		tf3.setPreferredSize(new Dimension(150, 40));
		c.gridx = 2;
		c.gridy = 3;
		panel.add(tf3, c);

	

		tf6 = new JTextField();
		tf6.setPreferredSize(new Dimension(150, 40));
		c.gridx = 2;
		c.gridy = 6;
		panel.add(tf6, c);

		// ////////////
		lb1 = new JLabel("Code : ");
		lb1.setPreferredSize(new Dimension(150, 40));
		c.gridx = 1;
		c.gridy = 1;
		panel.add(lb1, c);

		lb2 = new JLabel("Name : ");
		lb2.setPreferredSize(new Dimension(150, 40));
		c.gridx = 1;
		c.gridy = 2;
		panel.add(lb2, c);

		lb3 = new JLabel("Phone : ");
		lb3.setPreferredSize(new Dimension(150, 40));
		c.gridx = 1;
		c.gridy = 3;
		panel.add(lb3, c);

		lb6 = new JLabel("Search : ");
		lb6.setPreferredSize(new Dimension(150, 40));
		c.gridx = 1;
		c.gridy = 6;
		panel.add(lb6, c);
		//////////////

		f.add(pn);
		f.setVisible(true);

	}
	public static void showaftersort(List<Customer> tt){
		model.setRowCount(0);
		for (Customer ps : tt) {
			// System.out.Println("ben swing : " + ps);
			model.addRow(new Object[] { ps.ccode, ps.cus_name, ps.phone });
		}
	}

}
