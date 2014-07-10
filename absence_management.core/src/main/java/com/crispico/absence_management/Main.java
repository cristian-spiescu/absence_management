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
import com.crispico.absence_management.service.AbsenceService;

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
		//List<Employee> employees = eDao.getAll();
		String[] nume = new String[8];
		nume[0]="Ana";
		nume[1]="Ion";
		nume[2]="Maria";
		nume[3]="Gheorghe";
		nume[4]="Maricica";
		nume[5]="Gheorghita";
		nume[6]="Anica";
		nume[7]="Ionel";
		
		
		Absence abs = new Absence();
		int nr,nr_angajati=10,numar;
		
		String[] tip = new String[4];
		tip[0]="medical";
		tip[1]="odihna";
		tip[2]="neplatit";
		tip[3]="absent";
		
		t.setType(tip[0]);
		aTDao.save(t);
		t.setType(tip[1]);
		aTDao.save(t);
		t.setType(tip[2]);
		aTDao.save(t);
		t.setType(tip[3]);
		aTDao.save(t);
	/*	
		AbsenceService abss = new AbsenceService();
		
		List<Absence> aux = abss.getAbsencesByEmployee(eDao.getAll().get(0));
		
		//System.out.println("12431");
		System.out.println("uaaaaaaaaaaaaaai ");
		for(Absence absence:aux){
			System.out.println(absence.getEmployee().getFirstName() + " "
					+ absence.getEmployee().getLastName() + " " +
					absence.getStart_date() + " " +
					absence.getEnd_date());
		}*/
		
		//for (Employee employee : employees) {
		for(int i=0;i<nr_angajati;i++){
			Employee employee = new Employee();
			Set<Absence> absences = new HashSet<Absence>();
			//System.out.println(employee);
			//citesc data de start
			//string = new String();
			
			//System.out.println("Introduceti numarul de linii noi");
			Random rand = new Random();
			
			nr = rand.nextInt(8);
			rand = new Random();
			numar = rand.nextInt(8);
			
//			if(employee.getFirstName().equals("John")){
//				nr=0;
//			}
			//nr = Integer.parseInt(scanner.nextLine());
			//e = new Employee();
			employee.setFirstName(nume[nr]);
			employee.setLastName(nume[numar]);
			//eDao.save(employee);
			for(int j=0;j<nr;j++){
				
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
				string = tip[nr%4];
				t.setType(string);
				//aTDao.save(t);
				//absences.add(abs);
				//e.setAbsences(absences);
				a.setType(t);
				absences.add(a);
				
				aDao.save(a);
				
			}
//			if(employee.getFirstName().equals("John")){
//				eDao.delete(employee.getId());
//			}
			employee.setAbsences(absences);
			System.out.println(employee.getFirstName());
			//eDao.save(employee);
		}
		
		
		
		HibernateUtil.getSessionFactory().close();
	}

}
