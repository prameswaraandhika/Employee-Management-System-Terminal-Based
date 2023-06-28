import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class Main {
    static List<Employee> listEmployee = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║     Employee Management   ║");
        System.out.println("╠═══════════════════════════╣");
        initializeRecords();
        displayRecords();
        displayActions();
    }

    private static void initializeRecords() {
        listEmployee.add(new Employee(1, "dika", "programmer"));
        listEmployee.add(new Employee(2, "udin", "designer"));
        listEmployee.add(new Employee(3, "rina", "admin"));
    }

    private static void displayActions() {
        System.out.println("==> Select an Action");
        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Edit");
        System.out.println("4. Search");
        System.out.println("5. Sort");
    }

    private static void displayRecords() {
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
    }
}
