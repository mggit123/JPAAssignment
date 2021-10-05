package com.tech.proj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StudentMain {
	private final static EntityManager2 entityManager = JPAConnection.getEntityManager();
	private static boolean quit;
	private static Scanner sc = new Scanner(System.in);
	private static int id;
	private static String name;
	private static String address;
	private static long phone;

	public static void main(String[] args) {
		System.out.println("Press 1 Insert the Element\nPress 2 Display all Data\nPress 3 Display By Id\nPress 4 "
				+ "Update the Data By Id\nPress 5 Delete By Id\nPress 6 Quit the Program");
		try {
			while (!quit) {
				entityManager.getTransaction().begin();
				String str = "" + sc.next().charAt(0);
				switch (str.toLowerCase()) {
				case "1":
					System.out.println("Enter the name ,Address And Phone");
					name = sc.next();
					address = sc.next();
					phone = sc.nextLong();
					insertStudent(name, address, phone);
					System.err.println("Do you want to y/n");
					break;
				case "2":
					List<Student> studentAll = selectStudentAll();
					studentAll.forEach(i -> System.out.println(i));
					System.out.println("*************************************************************");
					System.err.println("Do you want to y/n");
					break;
				case "3":
					System.out.println("Enter the id");
					int id1 = sc.nextInt();
					System.out.println("Student Details : " + selectStudent(id1));
					System.err.println("Do you want to  y/n");
					break;
				case "4":
					System.out.println("Enter the id");
					id = sc.nextInt();
					updateStudent(id);
					System.err.println("Do you want to y/n");
					break;
				case "5":
					System.out.println("Enter the id");
					int id3 = sc.nextInt();
					deleteStudent(id3);
					System.err.println("Do you want to y/n");
					break;
				case "6":
					System.err.println("Shutdown...");
					quit = true;
					break;
				case "n":
					System.err.println("Shutdown...");
					quit = true;
					break;
				case "y":
					System.out.println("Press 1 Insert the Element\nPress 2 Display all Data\nPress 3 Display By "
							+ "Id\nPress 4 Update the Data By Id\nPress 5 Delete By Id\nPress 6 Quit the Program");
					break;
				default:
					System.err.println("Please Enter the Correct option");
					break;

				}
				entityManager.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JPAConnection.closeConn();
			sc.close();
		}
	}

	private static List<Student> selectStudentAll() {
		Query query = entityManager.createQuery("from Student");
		return query.getResultList();
	}

	public static void insertStudent(String name, String address, long phone) {
		entityManager.persist(new Student(name, address, phone));
	}

	public static Student selectStudent(int id) {
		Student find = entityManager.find(Student.class, id);
		if (find == null) {
			try {
				throw new IdNotFoundException("Id Not Found...");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return null;
		} else {
			String selectQuery = "from Student where rollNo=:id";
			Query setParameter = entityManager.createQuery(selectQuery).setParameter("id", id);
			return (Student) setParameter.getSingleResult();
		}
	}

	public static void deleteStudent(int id) {
		Student find = selectStudent(id);
		String delete = "delete from Student where rollNo =: id";
		Query query = entityManager.createQuery(delete).setParameter("id", id);
		query.executeUpdate();
	}

	public static int updateStudent(int id) {
		Student student = selectStudent(id);
		System.err.println("Do you want to update name y/n");
		String str = sc.next();
		if (str.equalsIgnoreCase("y")) {
			System.out.println("Enter the Name");
			name = sc.next();
		} else {
			name = student.getName();
		}
		System.err.println("Do you want to update address y/n");
		String str1 = sc.next();
		if (str1.equalsIgnoreCase("y")) {
			System.out.println("Enter the Address.");
			address = sc.next();
		} else {
			address = student.getAddress();
		}
		System.err.println("Do you want to update Phone y/n");
		String str2 = sc.next();
		if (str2.equalsIgnoreCase("y")) {
			System.out.println("Enter the Phone no.");
			phone = sc.nextLong();
		} else {
			phone = student.getPhone();
		}
		String update = "update Student set name=:name ,address=:add,phone=:ph where rollNo=:id";
		Query query = entityManager.createQuery(update).setParameter("name", name).setParameter("add", address)
				.setParameter("ph", phone).setParameter("id", id);
		return query.executeUpdate();
	}
}
