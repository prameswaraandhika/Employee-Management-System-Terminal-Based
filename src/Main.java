import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import model.Employee;

public class Main {
    static List<Employee> listEmployee = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        initializeRecords();
        displayMenu();
    }

    private static void sortEmployee() {
    }

    private static void searchEmployee() {
    }

    private static void editEmployee() {
        System.out.println("Edit feature");
        System.out.println("Enter employee id or type 'x' to cancel");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("x")) {
            System.out.println("Updated canceled...");
            displayMenu();
        }

        try {

            long id = Long.parseLong(input);
            for (Employee employee : listEmployee) {
                if (employee.getId() == id) {
                    System.out.print("name: ");
                    String updateName = sc.nextLine();
                    if (updateName.equalsIgnoreCase("x")) {
                        displayMenu();
                        break;
                    } else {
                        employee.setName(updateName);
                    }
                    System.out.println("position: ");
                    String updatePosisi = sc.nextLine();
                    if (updatePosisi.equalsIgnoreCase("x")) {
                        displayMenu();
                        break;
                    } else {
                        employee.setPosisi(updatePosisi);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        // boolean employeeRemoved = false;
        // Iterator<Employee> iterator = listEmployee.iterator();
        // while (iterator.hasNext()) {
        // Employee employee = iterator.next();
        // if (employee.id() == id) {
        // tempId = employee.id();
        // iterator.remove();
        // employeeRemoved = true;
        // }
        // }

        // if (!employeeRemoved) {
        // System.out.printf("data of id %d not found\n\n", id);
        // } else {
        // System.out.print("name: ");
        // String nama = sc.nextLine();

        // if (nama.equalsIgnoreCase("x")) {
        // System.out.println("Employee addition canceled.");
        // displayMenu();
        // }

        // System.out.println("position: ");
        // String posisi = sc.nextLine();

        // if (posisi.equalsIgnoreCase("x")) {
        // System.out.println("Employee addition canceled.");
        // displayMenu();
        // }
        // listEmployee.add(new Employee(tempId, nama, posisi));
        // }

        displayMenu();

    }

    private static void removeEmployee() {
        System.out.println("Remove feature");
        System.out.println("Enter employee id or type 'x' to cancel");
        System.out.print("id: ");
        boolean employeeRemoved = false;
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("x")) {
            System.out.println("Removal canceled...");
            displayMenu();
        }

        // List<Employee> temp = new CopyOnWriteArrayList<>(listEmployee);
        // for (Employee employee : temp) {
        // if (employee.id() == id) {
        // listEmployee.remove(employee);
        // }
        // } use CopyOnWriteArrayList
        try {

            long id = Long.parseLong(input);
            Iterator<Employee> iterator = listEmployee.iterator();
            while (iterator.hasNext()) {
                Employee employee = iterator.next();
                if (employee.getId() == id) {
                    iterator.remove();
                    employeeRemoved = true;
                }
            }

            if (!employeeRemoved) {
                System.out.printf("data of id %d not found\n\n", id);
            } else {
                System.out.printf("data of id %d has been removed\n\n", id);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return;
        }

        displayMenu();
    }

    private static void addEmployee() {
        System.out.println("Enter employee details or type 'x' to cancel");
        System.out.print("name: ");
        String nama = sc.nextLine();

        if (nama.equalsIgnoreCase("x")) {
            System.out.println("Employee addition canceled.");
            displayMenu();
        }

        System.out.println("position: ");
        String posisi = sc.nextLine();

        if (posisi.equalsIgnoreCase("x")) {
            System.out.println("Employee addition canceled.");
            displayMenu();
        }

        int id = listEmployee.size() + 1;
        listEmployee.add(new Employee(id, nama, posisi));
        System.out.println("Employee added successfully.");
        displayMenu();
    }

    private static void initializeRecords() {
        listEmployee.add(new Employee(1, "dika", "programmer"));
        listEmployee.add(new Employee(2, "udin", "designer"));
        listEmployee.add(new Employee(3, "rina", "admin"));
    }

    private static void displayMenu() {
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║     Employee Management   ║");
        System.out.println("╠═══════════════════════════╣");
        System.out.println("| ID |   Nama   |  Posisi   |");
        System.out.println("+----+----------+-----------+");
        if (listEmployee.isEmpty()) {
            System.out.println("|  No Records Found         ");
        } else {
            for (Employee employee : listEmployee) {
                System.out.printf("| %d  |  %-5s   |  %-8s  \n", employee.getId(), employee.getName(),
                        employee.getPosisi());
            }
        }
        System.out.println("+----+----------+-----------+");
        System.out.println("==> Select an Action");
        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Edit");
        System.out.println("4. Search");
        System.out.println("5. Sort");
        System.out.println("6. Exit");

        System.out.print("==> ");
        byte action = sc.nextByte();
        sc.nextLine();
        switch (action) {
            case 1:
                addEmployee();
                break;
            case 2:
                removeEmployee();
                break;
            case 3:
                editEmployee();
                break;
            case 4:
                searchEmployee();
                break;
            case 5:
                sortEmployee();
                break;
            case 6:
                System.out.println("Sampai jumpa, Program berhenti");
                return;
            default:
                System.out.println("Pilihan tidak terdaftar");
                System.out.println("Program berhenti");
                return;
        }
    }
}
