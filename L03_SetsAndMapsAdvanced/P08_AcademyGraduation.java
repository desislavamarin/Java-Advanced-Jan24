package L03_SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> studentGrades = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String studentName = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToDouble(Double::parseDouble)
                                    .toArray();

            studentGrades.put(studentName, scores);
        }

        studentGrades.entrySet().forEach(e -> {
            System.out.printf("%s is graduated with %s%n", e.getKey(), new DecimalFormat("#.################").format(getAverage(e.getValue())));
        });
    }

    private static double getAverage(double[] value) {
        double result = 0;
        for (double r : value) {
            result += r;
        }
        return result / value.length;
    }
}
