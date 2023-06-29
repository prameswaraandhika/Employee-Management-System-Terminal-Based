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
        List<Employee> listTemp = new ArrayList<>();
        System.out.println("==>Search feature");
        System.out.println("Enter index command or type 'x' to cancel");
        System.out.println("1. Name");
        System.out.println("2. Position");
        System.out.print("Enter command: ");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("x")) {
            System.out.println("Search feature canceled");
            displayMenu();
        } 

        if (input.matches("\\d")) {
            byte command = Byte.parseByte(input);
            switch (command) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    for (Employee employee : listEmployee) {
                        if (employee.getName().equalsIgnoreCase(name)) {
                            listTemp.add(employee);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter posisi: ");
                    String posisi = sc.nextLine();
                    for (Employee employee : listEmployee) {
                        if (employee.getName().equalsIgnoreCase(posisi)) {
                            listTemp.add(employee);
                        }
                    }
                    break;
                default:
                    System.out.println("data tidak ditemukan");
                    break;
            }
        }
        displayResultSearch(listTemp);
        displayMenu();
    }

    private static void displayResultSearch(List<Employee> listTemp) {
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║     Employee Management   ║");
        System.out.println("╠═══════════════════════════╣");
        System.out.println("| ID |   Nama   |  Posisi   |");
        System.out.println("+----+----------+-----------+");
        if (listTemp.isEmpty()) {
            System.out.println("|  No Records Found         ");
        } else {
            for (Employee employee : listTemp) {
                System.out.printf("| %d  |  %-5s   |  %-8s  \n", employee.getId(), employee.getName(),
                        employee.getPosisi());
            }
        }
        System.out.println("\n");
    }

    private static void editEmployee() {
        System.out.println("==>Edit feature");
        System.out.println("Enter employee id or type 'x' to cancel");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("x")) {
            System.out.println("Updated canceled...");
            displayMenu();
        }

        if (input.matches("\\d")) {
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
                    System.out.print("position: ");
                    String updatePosisi = sc.nextLine();
                    if (updatePosisi.equalsIgnoreCase("x")) {
                        displayMenu();
                        break;
                    } else {
                        employee.setPosisi(updatePosisi);
                    }
                }
            }
        }
        displayMenu();
    }

    private static void removeEmployee() {
        System.out.println("==>Remove feature");
        System.out.println("Enter employee id or type 'x' to cancel");
        System.out.print("id: ");
        boolean employeeRemoved = false;
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("x")) {
            System.out.println("Removal canceled...");
        }

        // List<Employee> temp = new CopyOnWriteArrayList<>(listEmployee);
        // for (Employee employee : temp) {
        // if (employee.id() == id) {
        // listEmployee.remove(employee);
        // }
        // } use CopyOnWriteArrayList
        if (input.matches("\\d")) {
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

        System.out.print("position: ");
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

        System.out.print("Enter command: ");
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
                System.out.println("Goodbye, see you");
                System.exit(0);
            default:
                System.out.println("Invalid optionr");
                System.out.println("Program berhenti");
                System.exit(0);
        }
    }

    private static void initializeRecords() {
        listEmployee.add(new Employee(1, "dika", "programmer"));
        listEmployee.add(new Employee(2, "udin", "designer"));
        listEmployee.add(new Employee(3, "rina", "admin"));
    }
}
