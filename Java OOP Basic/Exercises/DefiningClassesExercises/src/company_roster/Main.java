package company_roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Employee>> departments = new HashMap<>();

        int countOfEmployees = Integer.parseInt(bufferedReader.readLine());

        while (countOfEmployees-- > 0) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            if (tokens.length < 4 || tokens.length > 6) {
                continue;
            }
            Employee employee = null;
            switch (tokens.length) {
                case 4:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3]);
                    break;
                case 5:
                    if (tokens[4].matches("\\d+")) {
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]));
                    } else {
                        employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4]);
                    }
                    break;
                case 6:
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]));
                    break;
            }

            if (!departments.containsKey(employee.getDepartment())) {
                departments.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            }

            departments.get(employee.getDepartment()).add(employee);
        }

        Map.Entry<String, List<Employee>> highestDepartment = departments.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(), a.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .findFirst()
                .orElse(null);

        StringBuilder sb = new StringBuilder(String.format("Highest Average Salary: %s", highestDepartment.getKey())).append(System.lineSeparator());

        highestDepartment.getValue()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(e -> sb.append(e).append(System.lineSeparator()));

        System.out.println(sb.toString());
    }
}