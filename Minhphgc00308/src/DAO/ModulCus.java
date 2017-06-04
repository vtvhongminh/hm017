package DAO;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.util.TreeSet;

import Managerment_pd.SwingShowCus;
import Model.Customer;
import Model.Res;
import pre_order.MyListDoubleOrder;
import pre_order.SearchTreeDswOrder;
import pre_pd.Json;

import pre_pd.MyListDouble;

public class ModulCus {
	public File dataFile;
	private static List<Customer> items;
	private static List<Customer> item = new ArrayList<Customer>();
	private static List<Customer> itemdecode = new ArrayList<Customer>();
	private static List<Customer> itemSearch = new ArrayList<Customer>();
	private static List<Customer> itemdeafcode = new ArrayList<Customer>();
	SearchTreeDswOrder tc = new SearchTreeDswOrder();

	// 1.1. Load data from file
	public void inputData() {
		try {
			items = Json.readList(dataFile, Customer.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sai o day");
		}
	}

	// 1.2. Input & add new item // thay the bang swing
	public void addData(String code, String name, String phone) {
		if (item.isEmpty() && itemSearch.isEmpty()) {
		
			Customer fds = new Customer();
			fds.ccode = code;
			fds.cus_name = name;
			fds.phone = phone;
			items.add(fds);
			
			for (Customer Customer : item) {
				System.out.println("kt inside add rong" + Customer );
			}
			SwingShowCus.showaftersort(items);
	
		} else if (!item.isEmpty()) {
		  
			Customer fds = new Customer();
			fds.ccode = code;
			fds.cus_name = name;
			fds.phone = phone;
			items.add(fds);
			
		
			for (Customer Customer : item) {
				System.out.println("kt inside add k rong" + Customer );
			}
			SwingShowCus.showaftersort(item);
		}
		
		
	}

	// 1.3. Display data
	public void displayData() {
		int count = 1;
		if (item.isEmpty()) {
			for (Customer ik : items) {
				System.out.println(count++);
				System.out.println(ik);
			}

		} else if (!item.isEmpty()) {
			for (Customer ik : item) {
				System.out.println(count++);
				System.out.println(ik);
			}

		}

	}

	public static void displayDataSwing(String t) {
		if (!item.isEmpty()) {
			SwingShowCus.ShowData(t, item);
			for (Customer ik : item) {

				System.out.println("swing: " + ik);
			}
		} else if (item.isEmpty()) {
			item = items;
			
			SwingShowCus.ShowData(t, item);
			for (Customer ik : items) {

				System.out.println("swing: " + ik);
			}
		}

	}

	// public static void convertItem() {
	// if (item.isEmpty()) {
	// item = items;
	// }
	//
	// }

	// 1.4. Save Customer list to file
	public void SavePdl() {
		File f = Res.getDesktopFile("test3.json");

		try {
			if (item.isEmpty()) {
				Json.writeList(f, items);
			} else
				Json.writeList(f, item);

			System.out.println("save to file " + item);
			System.out.println("Saved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 1.5. Search by pcode

	public void searchByPcode(String s) {
		Customer fs = null;
		itemSearch.clear();
		if (itemSearch.isEmpty()) {
			if (!item.isEmpty()) {

				for (Customer Customer : item) {
					tc.addMany(Customer.ccode);
				}
				boolean r = tc.search(s); // thay the bang swing
				 System.out.println("Tim 17: " + r);
				if (r == true) {
					for (Customer ik : item) {
						if (ik.getCcode().equals(s)) { // thay the bang
																	// swing
							fs = ik;
						}
						
					}
					itemSearch.add(fs);
				}
			} else if(item.isEmpty()) {
				item = items;
				for (Customer Customer : item) {
					tc.addMany(Customer.ccode);
				}
				boolean r = tc.search(s); // thay the bang swing
				if (r == true) {
					for (Customer ik : item) {
						if (ik.getCcode().equals(s)) { // thay the bang
																	// swing
							fs = ik;
							break;
						}
						
					}
					itemSearch.add(fs);
				}
				 System.out.println("Tim 17: " + r);
			}
			SwingShowCus.showaftersort(itemSearch);
			System.out.println(itemSearch);
		}
	
		 
	}

	// 1.6. Delete by pcode
	public void removeByNote(String s) {
		if (item.isEmpty()) {
			for (Customer Customer : items) {
				tc.addMany(Customer.ccode);
			}
		} else {
			for (Customer Customer : item) {
				tc.addMany(Customer.ccode);
			}
		}

		tc.remove(s); // nhap tu swing

		tc.dumpde(true);
	}

	public void deleteBy_pcode(List<String> spcode) {
		Customer f = null;
		List<Customer> itemdecode2 = new ArrayList<Customer>();
		if (!item.isEmpty()) {

			for (String string : spcode) {
				for (Customer ik : item) {

					if (string.equals(ik.ccode)) {
						f = ik;
						System.out.println("delete by code " + f);
					}

				}

				itemdecode2.add(f);
			}
			item = itemdecode2;

		} else if (item.isEmpty()) {

			for (String string : spcode) {
				for (Customer ik : items) {

					if (string.equals(ik.ccode)) {
						f = ik;
						System.out.println("delete by code items " + f);

					}

				}
				itemdecode.add(f);

			}

			item = itemdecode;
		}

		for (Customer string : item) {
			System.out.println("sau khi xoa: " + string);
		}
		SwingShowCus.showaftersort(item);
	}

	// 1.7. Sort by pcode
	public void sortByPcode() {
		if (item.isEmpty()) {
			for (Customer Customer : items) {
				System.out.println("dung chay vao day");
				tc.addMany(Customer.ccode);
			}
		} else if (!item.isEmpty()) {
			
			for (Customer Customer : item) {
				System.out.println("Chay vao sortbycode : " + Customer);
				tc.addMany(Customer.ccode);
			}
		}

		System.out.println("day la sort");
		tc.collect(new TreeSet<String>());

	}

	public void getsort(List<Object> list) {
		Customer f = null;
		itemSearch.clear();
		
		if (itemSearch.isEmpty()) {
			
			if (item.isEmpty()) {
				for (Object string : list) {
					for (Customer Customer : items) {
						
						if (Customer.ccode.equals(string)) {
							System.out.println("among get sort : " + Customer.ccode);
							System.out.println("among get sort : " + string);
							f = Customer;
							 break;

						}

					}
					itemSearch.add(f);
				}
				for (Customer pd : itemSearch) {
					System.out.println("sau khi sort cua items :" + pd);
				}
			} else if (!item.isEmpty()) {
				for (Object string : list) {
					
					for (Customer Customer : item) {

						if (string.equals(Customer.ccode)) {
							System.out.println("strong sort cua item :" + string);
							f = Customer;
							 break;
							
						}
						
					}
					 itemSearch.add(f);
				}
				for (Customer pd : itemSearch) {
					System.out.println("sau khi sort cua item :" + pd);
				}
			}
		}
		SwingShowCus.showaftersort(itemSearch);

	}

	// 1.8. Delete the node after the node having code = xCode
	public void removeByAfNode(String s) {
		MyListDoubleOrder<String> ml = new MyListDoubleOrder<String>();
		if (item.isEmpty()) {
			for (Customer Customer : items) {
				ml.add(Customer.ccode);
			}
		} else if (!item.isEmpty()) {
			for (Customer Customer : item) {
				ml.add(Customer.ccode);
			}
		}

		ml.removeByNameMany(s);
		ml.dump();

	}

	public void getAdbxc(List<String> ssh) {
		Customer f = null;
		itemdeafcode.clear();
		if (itemdeafcode.isEmpty()) {
			if (item.isEmpty()) {
				for (String ss : ssh) {

					for (Customer ik : items) {

						if (ik.ccode.equals(ss)) {

							f = ik;
						}

					}
					itemdeafcode.add(f);
				}
			} else if (!item.isEmpty()) {
				for (String ss : ssh) {

					for (Customer ik : item) {

						if (ik.ccode.equals(ss)) {

							f = ik;
						}

					}
					itemdeafcode.add(f);
				}
			}

			item = itemdeafcode;
			SwingShowCus.showaftersort(item);
		}
	
	}
}
