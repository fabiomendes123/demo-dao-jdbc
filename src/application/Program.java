package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE NR 1: Seller findByID =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE NR 2: Seller findDepartment =====");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE NR 3: Seller insertSeller =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id= " + newSeller.getId());
		
		System.out.println("\n=== TESTE NR 5: Seller updateSeller =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update( seller);
		System.out.println("Update Copleted");
		
		System.out.println("\n=== TESTE NR 4: Seller findAll =====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TESTE NR 6: Seller Delete =====");
		System.out.println("enter id for deletation: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("delete completed");
		
		sc.close();
	}

}
