package com.crispico.absence_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.crispico.absence_management.dao.AbsenceHibernateDao;
import com.crispico.absence_management.dao.AbsenceTypeHibernateDao;
import com.crispico.absence_management.dao.EmployeeHibernateDao;
import com.crispico.absence_management.model.Absence;
import com.crispico.absence_management.model.AbsenceType;
import com.crispico.absence_management.model.Employee;

public class Main {

	public static void main(String[] args) throws ParseException {
		EmployeeHibernateDao eDao = new EmployeeHibernateDao();
		AbsenceHibernateDao aDao = new AbsenceHibernateDao();
		AbsenceTypeHibernateDao aTDao = new AbsenceTypeHibernateDao();
		Date date;
		
		//Date begin = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse("May 2, 2014");
		//Date ending = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse("May 6, 2014");
		
		Employee e = new Employee();
		Absence a = new Absence();
		AbsenceType t = new AbsenceType();
		//e.setFirstName("John");
		//e.setLastName("Doe");
		//dao.save(e);
		String string;
		Scanner scanner = new Scanner(System.in);
		List<Employee> employees = eDao.getAll();
		
		
		
		Absence abs = new Absence();
		int nr;
		
		String[] tip = new String[2];
		tip[0]="medical";
		tip[1]="odihna";
		
		for (Employee employee : employees) {
		//for(int i=0;i<nr;i++){
			//e = new Employee();
			Set<Absence> absences = new HashSet<Absence>();
			//System.out.println(employee);
			//citesc data de start
			//string = new String();
			
			//System.out.println("Introduceti numarul de linii noi");
			Random rand = new Random();
			
			nr = rand.nextInt(6);
			if(employee.getFirstName().equals("John")){
				nr=0;
			}
			//nr = Integer.parseInt(scanner.nextLine());
			
			for(int i=0;i<nr;i++){
				
				a = new Absence();
				t = new AbsenceType();
				//string = new String(begin.toString());
				//string = scanner.nextLine();
				//System.out.println("uaaaaai " + string);
				date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse("May 2, 2014");
				a.setStart_date(date);
				//citesc data de sfarsit
				//string = scanner.nextLine();
				//string = new String(begin.toString());
				date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse("May 8, 2014");
				a.setEnd_date(date);
				a.setEmployee(employee);
				//citesc tipul absentei
				string = tip[nr%2];
				t.setType(string);
				aTDao.save(t);
				//absences.add(abs);
				//e.setAbsences(absences);
				a.setType(t);
				absences.add(a);
				
				aDao.save(a);
				
			}
			if(employee.getFirstName().equals("John")){
				eDao.delete(employee.getId());
			}
			employee.setAbsences(absences);
			System.out.println(employee.printAbsences());
		}
		
		
		
		HibernateUtil.getSessionFactory().close();
	}

}
