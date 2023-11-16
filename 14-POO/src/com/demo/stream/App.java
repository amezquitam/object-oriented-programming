package com.demo.stream;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        System.out.println("1. List all distinct project in non-ascending order");
        employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .collect(Collectors.toSet()).stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.println(project.getName()));

        System.out.println("\n2. Print full name of any employee whose firstName starts with ‘A’.");
        employeeList.stream().filter(employee -> employee.getFirstName().startsWith("A"))
                .forEach(employee -> System.out.println(employee.getFirstName() + " " + employee.getLastName()));

        System.out.println("\n3. List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)");
        employeeList.stream().filter(employee -> employee.getId().startsWith("2023"))
                .forEach(System.out::println);

        System.out.println("\n4. Sort employees based on firstName, for same firstName sort by salary.");
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .sorted(Comparator.comparing(Employee::getFirstName))
                .forEach(System.out::println);

        System.out.println("\n5. Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).");
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .limit(3).forEach(em -> System.out.println(em.getFirstName() + " " + em.getLastName()));

        System.out.println("\n6. Print min salary.");
        int minSalary = employeeList.stream()
                .map(Employee::getSalary)
                .min(Comparator.naturalOrder())
                .orElse(0);
        System.out.println("Min salary: " + minSalary);

        System.out.println("\n7. Print list of all employee with min salary.");
        employeeList.stream()
                .filter(employee -> employee.getSalary() == minSalary)
                .forEach(System.out::println);

        System.out.println("\n8. List of people working on more than 2 projects.");
        employeeList.stream().filter(employee -> employee.getProjects().size() > 2)
                .forEach(System.out::println);

        System.out.println("\n9. Count of total laptops assigned to the employees.");
        long totalLaptopsAssignedToEmployees = employeeList.stream()
                .map(Employee::getTotalLaptopsAssigned)
                .count();
        System.out.println(totalLaptopsAssignedToEmployees);

        System.out.println("\n10. Count of all projects with Robert Downey Jr as PM.");
        long numOfProjectsWithRobertAsPM =
                employeeList.stream().flatMap(employee -> employee.getProjects().stream()).distinct()
                        .filter(project -> project.getProjectManager().equals("Robert Downey Jr")).count();
        System.out.println(numOfProjectsWithRobertAsPM);

        System.out.println("\n11. List of all projects with Robert Downey Jr as PM.");
        employeeList.stream().flatMap(employee -> employee.getProjects().stream()).distinct()
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .forEach(System.out::println);

        System.out.println("\n12. List of all people working with Robert Downey Jr.");
        employeeList.stream().filter(
                employee -> employee.getProjects().stream().anyMatch(
                        project -> project.getProjectManager().equals("Robert Downey Jr")
                )
        ).forEach(System.out::println);

        System.out.println("\n13. Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year.");
        var employeeByYearMap = employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4)));
        System.out.println(employeeByYearMap);

        System.out.println("\n14. Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year.");
        var employeeCountByYearMap = employeeList.stream().collect(
            Collectors.groupingBy(
                    employee -> employee.getId().substring(0, 4),
                    Collectors.mapping(Employee::getFirstName, Collectors.counting())
            )
        );
        System.out.println(employeeCountByYearMap);
    }
}
