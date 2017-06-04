package DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.util.TreeSet;

import Managerment_pd.SwingShowOrder;
import Model.Ordering;
import Model.Ordering;
import Model.Res;
import pre_order.MyListDoubleOrder;
import pre_order.SearchTreeDswOrder;
import pre_pd.Json;

import pre_pd.MyListDouble;

public class ModulOrder {
	public File dataFile;
	private static List<Ordering> items;
	private static List<Ordering> item = new ArrayList<Ordering>();
	private static List<Ordering> itemdecode = new ArrayList<Ordering>();
	private static List<Ordering> itemSearch = new ArrayList<Ordering>();
	private static List<Ordering> itemSearchP = new ArrayList<Ordering>();
	SearchTreeDswOrder tc = new SearchTreeDswOrder();

	// 1.1. Load data from file
	public void inputData() {
		try {
			items = Json.readList(dataFile, Ordering.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sai o day");
		}
	}

	// 1.2. Input & add new item // thay the bang swing
	public void addData(String code, String name, int quality) {

		Ordering fds = new Ordering();
		fds.ccode = code;
		fds.pcode = name;
		fds.quantity = quality;
		items.add(fds);

		for (Ordering Ordering : item) {
			System.out.println("kt inside add rong" + Ordering);
		}

		SwingShowOrder.showaftersort(items);

	}

	// 1.3. Display data

	public static void displayDataSwing(String t) {

		SwingShowOrder.ShowData(t, items);
	}

	// 1.7. Sort by pcode
	public void sortByPcode() {
		for (Ordering Ordering : items) {

			tc.addMany(Ordering.pcode);
		}

		tc.collects(new TreeSet<String>());

	}

	public void sortByCcode() {

		for (Ordering Ordering : items) {

			tc.addMany(Ordering.ccode);
		}

		tc.collect(new TreeSet<String>());

	}

	/////////// by ccode
	public void getsort(List<Object> list) {
		Ordering f = null;
		itemSearch.clear();
	
		if (itemSearch.isEmpty()) {

			for (Object string : list) {
				for (Ordering Ordering : items) {

					if (Ordering.ccode.equals(string)) {
						f = Ordering;
					
					}
				}
				itemSearch.add(f);
			}

		}
		SwingShowOrder.showaftersort(itemSearch);

	}

	/////////// by pcode
	public void getsortp(List<Object> list) {
		Ordering f = null;
		itemSearchP.clear();
	
		if (itemSearchP.isEmpty()) {

			for (Object string : list) {
				for (Ordering O : items) {

					if (O.pcode.equals(string)) {
						f = O;
						System.out.println("kiem tra item : " + string);

					}

				}
				itemSearchP.add(f);
			}
		}
		try {
			SwingShowOrder.showaftersorts(itemSearchP);
		} catch (Exception e) {
			clearsort();
			
		}
		

	}
	public void clearsort(){
		
		SwingShowOrder.showaftersorts(items);
	}

}
