package OneToMany.dao;

import java.util.List;

import OneToMany.dto.Company;
import OneToMany.dto.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CompanyDao {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shubham");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void saveCompany(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		List<Employee> list = company.getList();
		for(Employee employee : list) {
			entityManager.persist(employee);
		}
		entityManager.persist(company);
		entityTransaction.commit();
		System.out.println("Company details saved successfully");
	}
	
	public void updateCompany(int id, Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Company receivedCompany = entityManager.find(Company.class, id);
		if(receivedCompany!=null) {
			company.setId(id);
			company.setName(receivedCompany.getName());
			company.setList(company.getList());
			company.setGst(receivedCompany.getGst());
			
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
			System.out.println("Company Details updated successfully");
			
		}else {
			System.out.println("Company doesn't exist");
		}
	}
	
	public void findEmployee(int cId, int empId) {
		EntityManager entityManager = getEntityManager();
		
		Company company = entityManager.find(Company.class,cId);
		
		List<Employee> list = company.getList();
		for(Employee employee : list) {
			if(employee.getId() == empId) {
				System.out.println("Employee found successfully");
				System.out.println(employee);
				break;
			}
		}
	}
	
	public void deleteEmployee(int cId, int empId) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Company company = entityManager.find(Company.class, cId);
		
		List<Employee> list = company.getList();
		
		for(Employee employee : list) {			
			if(employee.getId() == empId) {
				entityManager.remove(employee);
				break;
			}
		}
		entityTransaction.commit();
		System.out.println("Employee removed from company");
	}
	
	public void deleteCompany(int cId) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Company company = entityManager.find(Company.class, cId);
		
		entityManager.remove(company);
		System.out.println("Company Deleted Sucessful");
	}
}
