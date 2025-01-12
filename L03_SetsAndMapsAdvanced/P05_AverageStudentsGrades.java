package L03_SetsAndMapsAdvanced;

import java.util.*;

public class P05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            List<Double> currentGrades = new ArrayList<>();

            if (students.containsKey(name)) {
                currentGrades = students.get(name);
            }
            currentGrades.add(grade);
            students.put(name, currentGrades);
        }

        for (String studentName : students.keySet()) {
            System.out.print(studentName + " -> ");
            double sum = 0;
            List<Double> studentGrades = students.get(studentName);
            for (Double grade : studentGrades) {
                sum += grade;
                System.out.printf("%.2f ", grade);
            }

            System.out.printf("(avg: %.2f)%n", Math.round(sum / studentGrades.size() * 100) / 100.0);
        }
    }
}
