package OneToMany.controller;

import java.util.ArrayList;

import OneToMany.dao.CompanyDao;
import OneToMany.dto.Company;
import OneToMany.dto.Employee;

public class CompanyMain {
	public static void main(String[] args) {
				
				Employee e1 = new Employee();
				e1.setName("Raj");
				e1.setAddress("Banglore");
		
				Employee e2 = new Employee();
				e2.setName("Suresh");
				e2.setAddress("Chennai");
		
				Employee e3 = new Employee();
				e3.setName("Raju");
				e3.setAddress("Mumbai");
		
				Company company = new Company();
				company.setName("TATA");
				company.setGst("XYZ123");
		
				ArrayList<Employee> list = new ArrayList<Employee>();
				list.add(e1);
				list.add(e2);
				list.add(e3);
		
				company.setList(list);
		        
				CompanyDao dao = new CompanyDao();
				dao.saveCompany(company);
	}
}
