package com.infotech.fisglobal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.logging.Logger;

public class ClientTest {

	public static List<Customer> readCustomerFile(String filepath) {
		List<Customer> customers = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(filepath))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				if (parts.length == 7) {
					int custNo = Integer.parseInt(parts[0]);
					String firstName = parts[1];
					String lastName = parts[2];
					String gender = parts[3];
					int age = Integer.parseInt(parts[4]);
					String profession = parts[5];
					String contactNo = parts[6];
					String emailId = parts[7];
					Customer customer = new Customer(custNo, firstName, lastName, lastName, gender, age, profession,
							contactNo, emailId);
					customers.add(customer);
				} else {
					System.out.println("Invalid line format: " + line);
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		return customers;

	}

	public static void main(String[] args) {

		List<Customer> cust = readCustomerFile("customers.txt");
		for (Customer customer : cust) {
			System.out.println(customer.getCustNo() + "," + customer.getFirstName() + "," + customer.getLastName() + ","
					+ customer.getGender() + "," + customer.getAge() + "," + customer.getProfession() + ","
					+ customer.getEmailId());
		}

		iterateUsingList_Iterator("customers.txt");
	}

	private static void iterateUsingList_Iterator(String filepath) {
		System.out.println("========Iterate the data using list_iterator==========");

		try (Scanner scanner = new Scanner(new File(filepath))) {
			ListIterator<Customer> listiterator = new ListIterator<Customer>() {

				@Override
				public boolean hasNext() {
					return scanner.hasNextLine();
				}

				@Override
				public Customer next() {
					String line = scanner.nextLine();
					String[] parts = line.split(",");
					int custNo = Integer.parseInt(parts[0]);
					String firstName = parts[1];
					String lastName = parts[2];
					String gender = parts[3];
					int age = Integer.parseInt(parts[4]);
					String profession = parts[5];
					String contactNo = parts[6];
					String emailId = parts[7];

					return new Customer(custNo, firstName, lastName, gender, emailId, age, profession, contactNo,
							emailId);
				}

				@Override
				public boolean hasPrevious() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public Customer previous() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int nextIndex() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public int previousIndex() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub

				}

				@Override
				public void set(Customer e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void add(Customer e) {
					// TODO Auto-generated method stub

				}
			};
			while (listiterator.hasNext()) {
				Customer customer = listiterator.next();
				System.out.println(customer);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
