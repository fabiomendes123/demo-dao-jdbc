package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE NR 1: department findByID =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		
		//System.out.println("\n=== TESTE NR 1: department insertDepartment =====");
		//Department newDepartment = new Department(null, "Music");
		//departmentDao.insert(newDepartment);
		//System.out.println("Inserted! New Id= " + newDepartment.getId());
		
		
		System.out.println("\n=== TESTE NR 2: Department updateDepartment =====");
		department = departmentDao.findById(6);
		department.setName("D2");
		departmentDao.update(department);
		System.out.println("Update Copleted");
		
		System.out.println("\n=== TESTE NR 4: Seller findAll =====");
		List<Department>list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n=== TESTE NR 6: Seller Delete =====");
		System.out.println("enter id for deletation: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("delete completed");
				
		sc.close();
	}

}
