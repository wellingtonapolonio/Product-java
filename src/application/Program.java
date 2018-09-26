package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import javax.swing.JOptionPane;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class program {
	public static void main(String[] args) throws ParseException{
	Locale.setDefault(Locale.US);
	
	
	List<Product>list = new ArrayList<>();
	String aux;
	aux= JOptionPane.showInputDialog("\"Enter the number of products:");
	int num = Integer.parseInt(aux);
	for (int i =1; i<=num;i++) {
		 JOptionPane.showMessageDialog(null,"Product #"+i +"date" );
	aux= JOptionPane.showInputDialog("Common, used or imported (c/u/i)?");
		char xT = aux.charAt(0);
		
		String name = JOptionPane.showInputDialog("Name");
	
		aux= JOptionPane.showInputDialog("Price");
		double price = Double.parseDouble(aux);
		
		if (xT =='c') {
			list.add(new Product(name, price));
		}
		else if (xT == 'u') {
			aux= JOptionPane.showInputDialog("Manufacture date (DD/MM/YYYY): ");
			Date d =  new SimpleDateFormat("dd/MM/yyyy").parse(aux);
			list.add(new UsedProduct(name, price, d));
		}
		else {
			aux= JOptionPane.showInputDialog("Customs fee: ");
			double customsFree = Double.parseDouble(aux);
			list.add(new ImportedProduct(name, price, customsFree));
		}
		
		
	}
	JOptionPane.showMessageDialog(null, "\"PRICE TAGS: \")");
	for (Product p : list) {
		
		JOptionPane.showMessageDialog(null,p.priceTag());
	}
	System.exit(0);
	
	}

}
