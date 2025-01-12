package L03_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Double>> shopProducts = new TreeMap<>();

        while (!"Revision".equals(input)) {
            String[] tokens = input.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            shopProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopProducts.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (String shopName : shopProducts.keySet()) {
            System.out.println(shopName + "->");
            LinkedHashMap<String, Double> products = shopProducts.get(shopName);
            for (String productName : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productName, products.get(productName));
            }
        }
    }
}
