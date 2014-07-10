package com.crispico.absence_management.service;

import java.util.List;
import java.util.Set;

import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.Employee;

public class EmployeeService {

	protected EmployeeHibernateDao dao = new EmployeeHibernateDao();
	
	
	public String sayHello(String name) {
		System.out.println(name);
		return "Hello " + name;
	}
	
	public List<Employee> getAllEmployees() {
		return dao.getAll();
	}
	
	/*Adaugare Employee to DB*/
	public void addEmployee(Employee e)
	{	
		dao.save(e);
	}
	
	public void deleteEmployee(Employee e)
	{			
		dao.delete(e);
	}
	
	public void editEmployee(Employee e)
	{			
		dao.update(e);
	}
	
	public Set<Absence> getEmployeeAbsences(Employee e)
	{
		return e.getAbsences();
	}

	public Set<Absence> searchEmployee(Employee e)
	{
		System.out.println("@@@@@@@"+e.toString());
		
		List<Employee> lista = dao.getAll();
		Set<Absence> absente = null;
	
		for(Employee emp : lista)
		{
			if (e.getFirstName()!="" && e.getLastName()!="")
			{				
				if( (e.getFirstName()).equals(emp.getFirstName())&&
						(e.getLastName()).equals(emp.getLastName()))
				{
					absente = getEmployeeAbsences(emp);
					return absente;
				}				
			}
			else if (e.getFirstName()!="")
			{
				if( (e.getFirstName()).equals(emp.getFirstName()))						
				{
					absente = getEmployeeAbsences(emp);
					return absente;
				}	
			}
			else if (e.getLastName()!="")
			{
				if( (e.getLastName()).equals(emp.getLastName()))						
				{
					absente = getEmployeeAbsences(emp);
					return absente;
				}	
			}
		}		
		return absente;
	}
	
	
	
}
