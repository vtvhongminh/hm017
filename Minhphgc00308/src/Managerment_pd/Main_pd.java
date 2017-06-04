package Managerment_pd;

import java.util.LinkedList;

import DAO.ModulCus;
import DAO.ModulOrder;
import DAO.ModulProduct;
import Model.Res;

public class Main_pd {



	public static void main(String[] args) {
		//runproduct();
		//runcus();
		runorder();
	}

	public static void runproduct() {
		ModulProduct m = new ModulProduct();
		m.dataFile = Res.getDesktopFile("dsa2017-data/1e2/products.json");
		m.inputData();
	

		ModulProduct.displayDataSwing("Product");
		// m.SavePdl();
	}
	public static void runcus() {
		ModulCus mc= new ModulCus();
		mc.dataFile = Res.getDesktopFile("dsa2017-data/1e2/customers.json");
		mc.inputData();
	

		ModulCus.displayDataSwing("Customer");
	
	}
	public static void runorder() {
		ModulOrder mc = new ModulOrder();
		mc.dataFile = Res.getDesktopFile("dsa2017-data/1e2/orders.json");
		mc.inputData();


		ModulOrder.displayDataSwing("Order");
	
	}
}
