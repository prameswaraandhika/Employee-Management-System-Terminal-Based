import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Employee;

public class Main {
    static List<Employee> listEmployee = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        displayMenu();
    }

    private static void sortEmployee() {
    }

    private static void searchEmployee() {
    }

    private static void editEmployee() {
    }

    private static void removeEmployee() {
    }

    private static void addEmployee() {
        System.out.println("Enter employee details or type 'x' to cancel");
        System.out.println("Masukan nama: ");
        String nama = sc.nextLine();

        if (nama.equalsIgnoreCase("x")) {
            System.out.println("Employee addition canceled.");
            displayMenu();
        }

        System.out.println("Masukan posisi: ");
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
        System.out.println("|  Nama   |  Posisi      |");
        System.out.println("+----------+-------------+");
        if (listEmployee.isEmpty()) {
            System.out.println("|  No Records Found      |");
        } else {
            for (Employee employee : listEmployee) {
                System.out.printf("|  %-5s  |  %-10s  |\n", employee.name(), employee.position());
            }
        }
        System.out.println("+----------+-------------+");
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
                System.out.println("sampai jumpa, Program berhenti");
                return;
            default:
                System.out.println("Pilihan tidak terdaftar");
                System.out.println("Program berhenti");
                return;
        }
    }
}
