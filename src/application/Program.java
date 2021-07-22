package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProducts;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Price: ");
			double productPrice = sc.nextDouble();
			
			if(type == 'i') {
				System.out.print("Custom fee: ");
				double productCustomFee = sc.nextDouble();

				list.add( new ImportedProducts(productName, productPrice, productCustomFee));
			}
			else if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date productManufactureDate = sdf.parse(sc.next());
				
				list.add(new UsedProduct(productName, productPrice, productManufactureDate));
			}
			else {

				list.add(new Product(productName, productPrice));
			}
		}
		
		System.out.println("PRICE TAGS: ");
		
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
