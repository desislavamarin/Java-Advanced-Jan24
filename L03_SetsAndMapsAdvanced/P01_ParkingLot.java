package L03_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!"END".equals(input)) {
            String[] inputParts = input.split(",\\s+");
            String command = inputParts[0];
            if ("IN".equals(command)) {
                parkingLot.add(inputParts[1]);
            } else if ("OUT".equals(command)) {
                parkingLot.remove(inputParts[1]);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }

        for (String carNumber : parkingLot) {
            System.out.println(carNumber);
        }
    }
}
