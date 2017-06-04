package DAO;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.util.TreeSet;

import Managerment_pd.SwingShow;
import Model.Product;
import Model.Res;

import pre_pd.Json;

import pre_pd.MyListDouble;

import pre_pd.SearchTreeDsw;

public class ModulProduct {
	public File dataFile;
	private static List<Product> items;
	private static List<Product> item = new ArrayList<Product>();
	private static List<Product> itemdecode = new ArrayList<Product>();
	private static List<Product> itemSearch = new ArrayList<Product>();
	private static List<Product> itemdeafcode = new ArrayList<Product>();
	SearchTreeDsw t = new SearchTreeDsw();

	// 1.1. Load data from file
	public void inputData() {
		try {
			items = Json.readList(dataFile, Product.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	// 1.2. Input & add new item // thay the bang swing
	public void addData(String code, String name, Double price, int sale, int quality) {
		if (item.isEmpty() && itemSearch.isEmpty()) {
		
			Product fds = new Product();
			fds.pcode = code;
			fds.pro_name = name;
			fds.price = price;
			fds.sale = sale;
			fds.quantity = quality;
			fds.pro_image_url = "ABC";
			items.add(fds);
			
			for (Product product : item) {
				// System.out.Println("kt inside add rong" + product );
			}
			SwingShow.showaftersort(items);
	
		} else if (!item.isEmpty()) {
		  
			Product fds = new Product();
			fds.pcode = code;
			fds.pro_name = name;
			fds.price = price;
			fds.sale = sale;
			fds.quantity = quality;
			fds.pro_image_url = "ABC";
			item.add(fds);
			
			for (Product product : item) {
				// System.out.Println("kt inside add k rong" + product );
			}
			SwingShow.showaftersort(item);
		}
		
		
	}

	// 1.3. Display data
	public void displayData() {
		int count = 1;
		if (item.isEmpty()) {
			for (Product ik : items) {
				// System.out.Println(count++);
				// System.out.Println(ik);
			}

		} else if (!item.isEmpty()) {
			for (Product ik : item) {
				// System.out.Println(count++);
				// System.out.Println(ik);
			}

		}

	}

	public static void displayDataSwing(String t) {
		if (!item.isEmpty()) {
			SwingShow.ShowData(t, item);
			for (Product ik : item) {

				// System.out.Println("swing: " + ik);
			}
		} else if (item.isEmpty()) {
			item = items;
			
			SwingShow.ShowData(t, item);
			for (Product ik : items) {

				// System.out.Println("swing: " + ik);
			}
		}

	}

	// public static void convertItem() {
	// if (item.isEmpty()) {
	// item = items;
	// }
	//
	// }

	// 1.4. Save product list to file
	public void SavePdl() {
		File f = Res.getDesktopFile("test3.json");

		try {
			if (item.isEmpty()) {
				Json.writeList(f, items);
			} else
				Json.writeList(f, item);

			// System.out.Println("save to file " + item);
			// System.out.Println("Saved");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 1.5. Search by pcode

	public void searchByPcode(String s) {
		Product fs = null;
		itemSearch.clear();
		if (itemSearch.isEmpty()) {
			if (!item.isEmpty()) {

				for (Product product : item) {
					t.addMany(product.pcode);
				}
				boolean r = t.search(s); // thay the bang swing
				 // System.out.Println("Tim 17: " + r);
				if (r == true) {
					for (Product ik : item) {
						if (ik.getPcode().equals(s)) { // thay the bang
																	// swing
							fs = ik;
						}
						
					}
					itemSearch.add(fs);
				}
			} else if(item.isEmpty()) {
				item = items;
				for (Product product : item) {
					t.addMany(product.pcode);
				}
				boolean r = t.search(s); // thay the bang swing
				if (r == true) {
					for (Product ik : item) {
						if (ik.getPcode().equals(s)) { // thay the bang
																	// swing
							fs = ik;
							break;
						}
						
					}
					itemSearch.add(fs);
				}
				 // System.out.Println("Tim 17: " + r);
			}
			SwingShow.showaftersort(itemSearch);
			// System.out.Println(itemSearch);
		}
		
		 
	}

	// 1.6. Delete by pcode
	public void removeByNote(String s) {
		if (item.isEmpty()) {
			for (Product product : items) {
				t.addMany(product.pcode);
			}
		} else {
			for (Product product : item) {
				t.addMany(product.pcode);
			}
		}

		t.remove(s); // nhap tu swing

		t.dumpde(true);
	}

	public void deleteBy_pcode(List<String> spcode) {
		Product f = null;
		List<Product> itemdecode2 = new ArrayList<Product>();
		if (!item.isEmpty()) {

			for (String string : spcode) {
				for (Product ik : item) {

					if (string.equals(ik.pcode)) {
						f = ik;
						// System.out.Println("delete by code " + f);
					}

				}

				itemdecode2.add(f);
			}
			item = itemdecode2;

		} else if (item.isEmpty()) {

			for (String string : spcode) {
				for (Product ik : items) {

					if (string.equals(ik.pcode)) {
						f = ik;
						// System.out.Println("delete by code items " + f);

					}

				}
				itemdecode.add(f);

			}

			item = itemdecode;
		}

		for (Product string : item) {
			// System.out.Println("sau khi xoa: " + string);
		}
		SwingShow.showaftersort(item);
	}

	// 1.7. Sort by pcode
	public void sortByPcode() {
		if (item.isEmpty()) {
			for (Product product : items) {
				// System.out.Println("dung chay vao day");
				t.addMany(product.pcode);
			}
		} else if (!item.isEmpty()) {
			
			for (Product product : item) {
				// System.out.Println("Chay vao sortbycode : " + product);
				t.addMany(product.pcode);
			}
		}

		// System.out.Println("day la sort");
		t.collect(new TreeSet<String>());

	}

	public void getsort(List<Object> list) {
		Product f = null;
		itemSearch.clear();
	
		if (itemSearch.isEmpty()) {
			
			if (item.isEmpty()) {
				for (Object string : list) {
					for (Product product : items) {
						
						if (product.pcode.equals(string)) {
							// System.out.Println("among get sort : " + product.pcode);
							// System.out.Println("among get sort : " + string);
							f = product;
							 break;

						}

					}
					itemSearch.add(f);
				}
				for (Product pd : itemSearch) {
					// System.out.Println("sau khi sort cua items :" + pd);
				}
			} else if (!item.isEmpty()) {
				for (Object string : list) {
					
					for (Product product : item) {

						if (string.equals(product.pcode)) {
							// System.out.Println("strong sort cua item :" + string);
							f = product;
							 break;
							
						}
						
					}
					 itemSearch.add(f);
				}
				for (Product pd : itemSearch) {
					// System.out.Println("sau khi sort cua item :" + pd);
				}
			}
		}
		SwingShow.showaftersort(itemSearch);

	}

	// 1.8. Delete the node after the node having code = xCode
	public void removeByAfNode(String s) {
		MyListDouble<String> ml = new MyListDouble<String>();
		if (item.isEmpty()) {
			for (Product product : items) {
				ml.add(product.pcode);
			}
		} else if (!item.isEmpty()) {
			for (Product product : item) {
				ml.add(product.pcode);
			}
		}

		ml.removeByNameMany(s);
		ml.dump();

	}

	public void getAdbxc(List<String> ssh) {
		Product f = null;
		itemdeafcode.clear();
		if (itemdeafcode.isEmpty()) {
			if (item.isEmpty()) {
				for (String ss : ssh) {

					for (Product ik : items) {

						if (ik.pcode.equals(ss)) {

							f = ik;
						}

					}
					itemdeafcode.add(f);
				}
			} else if (!item.isEmpty()) {
				for (String ss : ssh) {

					for (Product ik : item) {

						if (ik.pcode.equals(ss)) {

							f = ik;
						}

					}
					itemdeafcode.add(f);
				}
			}

			item = itemdeafcode;
			SwingShow.showaftersort(item);
		}
	
	}
}
