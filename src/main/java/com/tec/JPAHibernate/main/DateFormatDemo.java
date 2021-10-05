package com.tec.JPAHibernate.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateFormatDemo {
	public static void main(String[] args) {
//		String stringDate="23/12/1996";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the date in dd/MM/yyyy format:");
		String stringDate=scanner.next();
		Date date=null;
		
		try {
			date= new SimpleDateFormat("dd.MM.yyyy").parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.sql.Date date1=new java.sql.Date(date.getTime());
		System.out.println("sql date:"+date1);
		
	}

}
