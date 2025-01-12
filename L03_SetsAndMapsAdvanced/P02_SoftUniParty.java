package L03_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> regular = new TreeSet<>();
        TreeSet<String> VIP = new TreeSet<>();

        String input = scanner.nextLine();

        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                VIP.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }

        while (!"END".equals(input)) {
            VIP.remove(input);
            regular.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(VIP.size() + regular.size());
        for (String vipGuest : VIP) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regular) {
            System.out.println(regularGuest);
        }
    }
}
