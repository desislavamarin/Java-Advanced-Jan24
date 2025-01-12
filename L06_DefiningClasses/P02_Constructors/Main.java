package L06_DefiningClasses.P02_Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (count-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car = null;
            if (data.length == 1) {
                car = new Car(data[0]);
            } else {
                String brand = data[0];
                String model = data[1];
                int horsePower = Integer.parseInt(data[2]);
                car = new Car(brand, model, horsePower);
            }

            cars.add(car);
        }

        cars.forEach(c -> System.out.println(c.carInfo()));
    }
}
