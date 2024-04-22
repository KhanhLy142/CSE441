import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public int getId() {
        return id;
    }

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department + ", Code: " + code + ", Salary Rate: " + salaryRate;
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeEmployees();
    
        boolean running = true;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Display Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            String choiceInput = scanner.nextLine(); // Đọc dữ liệu từ bàn phím
            int choice = -1; // Khởi tạo giá trị lựa chọn mặc định
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue; // Quay lại đầu vòng lặp để yêu cầu lựa chọn hợp lệ
            }
    
            switch (choice) {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (running);
        scanner.close();
    }    
    private static void initializeEmployees() {
        employees.add(new Employee(1, "John Doe", 30, "IT", "EMP001", 5000));
        employees.add(new Employee(2, "Jane Smith", 35, "HR", "EMP002", 4500));
        employees.add(new Employee(3, "Michael Johnson", 28, "Finance", "EMP003", 4800));
        employees.add(new Employee(4, "Emily Davis", 32, "Marketing", "EMP004", 5200));
        employees.add(new Employee(5, "David Brown", 40, "IT", "EMP005", 5100));
        employees.add(new Employee(6, "Sarah Wilson", 33, "HR", "EMP006", 4700));
employees.add(new Employee(7, "Christopher Lee", 29, "Finance", "EMP007", 4900));
        employees.add(new Employee(8, "Jessica Martinez", 36, "Marketing", "EMP008", 5300));
        employees.add(new Employee(9, "Matthew Taylor", 31, "IT", "EMP009", 5200));
        employees.add(new Employee(10, "Amanda Thomas", 34, "HR", "EMP010", 4600));
    }

    private static void displayEmployees() {
        System.out.println("\nEmployee List:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void addEmployee() {
        System.out.println("\nAdding Employee:");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Salary Rate: ");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        employees.add(new Employee(id, name, age, department, code, salaryRate));
        System.out.println("Employee added successfully.");
    }

    private static void removeEmployee() {
        System.out.println("\nRemoving Employee:");
        System.out.print("Enter the ID of the employee to remove: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean removed = false;
        for (Employee employee : employees) {
            if (employee.getId() == idToRemove) {
                employees.remove(employee);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee with ID " + idToRemove + " not found.");
        }
    }
}