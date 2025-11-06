package fromdiscord;

import java.util.*;
import java.util.stream.Collectors;

public class task4 {
    public List<Employee> generate() {
        List<Employee> result = new LinkedList<>();
        result.add(new Employee("Jan", 14, "A"));
        result.add(new Employee("Ryś", 16, "B"));
        result.add(new Employee("Krzyś", 17, "C"));
        result.add(new Employee("Julek", 19, "A"));
        result.add(new Employee("Jan", 22, "B"));
        result.add(new Employee("Grześ", 44, "C"));
        result.add(new Employee("Piotr", 55, "C"));
        result.add(new Employee("Paweł", 66, "A"));
        result.add(new Employee("Jan", 77, "B"));
        result.add(new Employee("Jan", 88, "A"));
        return result;
    }

    public static final List<Employee> emps = new task4().generate();

    public static void main(String[] args) {

        List<Employee> empsUnder25 = emps.stream()
                .filter(employee -> employee.getAge() < 25)
                .toList();
        System.out.println(empsUnder25);

        List<String> empsUnder25list = empsUnder25.stream()
                .map(Employee::getName)
                .sorted()
                .toList();
        System.out.println(empsUnder25list);

        Map<String, List<String>> grouping = emps.stream()
                .filter(employee -> employee.getAge() < 25)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(grouping);

    }
}

class Employee {
    private String name;
    private int age;
    private String department;

    public Employee(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, department);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}