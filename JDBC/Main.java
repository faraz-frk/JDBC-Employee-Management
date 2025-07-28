package JDBC;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        File errorLog = new File("error_log.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
             BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorLog))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    if (parts.length != 4) throw new Exception("Invalid entry");

                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String dept = parts[2].trim();
                    double salary = Double.parseDouble(parts[3].trim());

                    Employee emp = new Employee(id, name, dept, salary);
                    departmentMap.computeIfAbsent(dept, k -> new ArrayList<>()).add(emp);

                } catch (Exception e) {
                    errorWriter.write(line);
                    errorWriter.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Thread> threads = new ArrayList<>();
        for (List<Employee> list : departmentMap.values()) {
            Thread t = new DepartmentInserter(list);
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Data processing completed.");
    }
}

