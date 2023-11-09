package com.demo.stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        System.out.println("1. List all distinct project in non-ascending order");
        employeeList.stream()
            .flatMap(employee -> employee.getProjects().stream())
            .collect(Collectors.toSet()).stream()
            .sorted((a, b) -> a.getName().compareTo(b.getName()))
            .forEach(project -> System.out.println(project.getName()));
        
        System.out.println("\n2. Print full name of any employee whose firstName starts with ‘A’.");
        employeeList.stream().filter(employee -> employee.getFirstName().startsWith("A"))
            .forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));

        System.out.println("\n3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)");
        employeeList.stream().filter(employee -> employee.getId().startsWith("2023"))
            .forEach(employee -> System.out.println(employee));

        System.out.println("\n4. Sort employees based on firstName, for same firstName sort by salary.");
        employeeList.stream()
            .sorted((a, b) -> b.getSalary() - a.getSalary())
            .sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()))
            .forEach(System.out::println);

        System.out.println("\n5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).");
        employeeList.stream()
            .sorted((a, b) -> b.getSalary() - a.getSalary())
            .limit(3).forEach( em -> System.out.println(em.getFirstName() + " " + em.getLastName()) );

        System.out.println("\n6. Print min salary.");
        int minSalary = employeeList.stream().map(employee -> employee.getSalary())
            .min(Comparator.naturalOrder()).get();
        System.out.println("Min salary: " + minSalary);

        System.out.println("\n7. Print list of all employee with min salary.");
        employeeList.stream().filter(employee -> employee.getSalary() == minSalary);
        
        System.out.println("\n8. List of people working on more than 2 projects.");
        employeeList.stream().filter(employee -> employee.getProjects().size() > 2)
            .forEach(System.out::println );

        System.out.println("\n9. Count of total laptops assigned to the employees.");
        long totalLaptopsAssignedToEmployees = employeeList.stream()
            .map(Employee::getTotalLaptopsAssigned)
            .count();
        System.out.println(totalLaptopsAssignedToEmployees);

        // 10. Count of all projects with Robert Downey Jr as PM.
        
        // 11. List of all projects with Robert Downey Jr as PM.
        // 12. List of all people working with Robert Downey Jr.
        // 13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.
        // 14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.
            
  }
}
