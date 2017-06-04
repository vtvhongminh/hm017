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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.table.DefaultTableModel;

import DAO.ModulOrder;

import Model.Ordering;

public class SwingShowOrder {
	private static JFrame f = new JFrame();

	JButton b1, b2, b3, b4, b5, b6;
	static JTextField tf1, tf2, tf3, tf4, tf5, tf6;
	static JLabel lb1, lb2, lb3, lb4, lb5, lb6;

	private static DefaultTableModel model = new DefaultTableModel();
	private static JTable jtable;
	private static JPanel pn;
	private static ModulOrder md = new ModulOrder();
	// GridBagConstraints gbc = new GridBagConstraints();

	public static <T> void ShowData(String title, List<Ordering> x) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(1000, 1000);
		f.setTitle("Ordering MANAGERMENT");
		jtable = new JTable(model);
		model.addColumn("PCode");
		model.addColumn("Ccode");
		model.addColumn("Quality");
		/////////
		JMenuBar mb = new JMenuBar();
		JMenu open = new JMenu("Open");
		mb.add(open);

		JMenuItem mnProduct = new JMenuItem("Product");
		open.add(mnProduct);
		JMenuItem mnCus = new JMenuItem("Customer");
		open.add(mnCus);
		f.setJMenuBar(mb);
		mnProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Main_pd.runproduct();

			}
		});
		mnCus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Main_pd.runcus();
		
			}
		});
		/////////
		for (Ordering ps : x) {
			model.addRow(new Object[] { ps.pcode, ps.ccode, ps.quantity });
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
		b1.setPreferredSize(new Dimension(250, 40));
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String h = null, g = null;
				int z = 0;

				h = tf1.getText();
				g = tf2.getText();
				z = Integer.parseInt(tf3.getText());

				md.addData(h, g, z);
				//md.displayData();

			}
		});
		c.gridx = 0;
		c.gridy = 1;
		panel.add(b1, c);
		c.insets = new Insets(10, 10, 10, 10);
		///////////
		

		JButton b3 = new JButton("Sort by Pcode or back to begining");
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				md.sortByPcode();
	
			}
		});
		b3.setPreferredSize(new Dimension(250, 40));
		c.gridx = 0;
		c.gridy = 2;
		panel.add(b3, c);

	

		JButton b5 = new JButton("Sort by Ccode");
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				md.sortByCcode();
			}
		});
		b5.setPreferredSize(new Dimension(250, 40));
		c.gridx = 0;
		c.gridy = 3;
		panel.add(b5, c);

	
	
		JButton b4 = new JButton("Clear sort");
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				md.sortByCcode();
			}
		});
		b4.setPreferredSize(new Dimension(250, 40));
		c.gridx = 0;
		c.gridy = 4;
		panel.add(b4, c);
		
		
		
		

		tf1 = new JTextField("PCode");
		tf1.setPreferredSize(new Dimension(150, 40));
		c.gridx = 2;
		c.gridy = 1;
		panel.add(tf1, c);

		tf2 = new JTextField("CCode");
		tf2.setPreferredSize(new Dimension(150, 40));
		c.gridx = 2;
		c.gridy = 2;
		panel.add(tf2, c);

		tf3 = new JTextField("Quan");
		tf3.setPreferredSize(new Dimension(150, 40));
		c.gridx = 2;
		c.gridy = 3;
		panel.add(tf3, c);

	

		// ////////////
		lb1 = new JLabel("Product Code : ");
		lb1.setPreferredSize(new Dimension(150, 40));
		c.gridx = 1;
		c.gridy = 1;
		panel.add(lb1, c);

		lb2 = new JLabel("Customer Code : ");
		lb2.setPreferredSize(new Dimension(150, 40));
		c.gridx = 1;
		c.gridy = 2;
		panel.add(lb2, c);

		lb3 = new JLabel("Quality : ");
		lb3.setPreferredSize(new Dimension(150, 40));
		c.gridx = 1;
		c.gridy = 3;
		panel.add(lb3, c);

	
		//////////////

		f.add(pn);
		f.setVisible(true);

	}

	public static void showaftersort(List<Ordering> tt) {
		model.setRowCount(0);
		for (Ordering ps : tt) {
			// System.out.Println("ben swing : " + ps);
			model.addRow(new Object[] { ps.pcode, ps.ccode, ps.quantity });
		}
	}
	public static void showaftersorts(List<Ordering> tt) {
		model.setRowCount(0);
		for (Ordering ps : tt) {
			// System.out.Println("ben swing : " + ps);
			model.addRow(new Object[] { ps.pcode, ps.ccode, ps.quantity });
		}
	}


}
