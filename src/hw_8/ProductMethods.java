package hw_8;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductMethods {
    public void listOfExpensiveBooks(List<Product> products){
        List<Product> listOfExpensiveBooks = products.stream()
                .filter(item -> (item.getType().equals(ProductType.BOOK) && item.getPrice() > 250))
                .toList();
        System.out.println(listOfExpensiveBooks);
    }

    public void  listOfDiscountedBooks(List<Product> products){
        List<Product> listOfDiscountedBooks = products.stream()
                .filter(item ->(item.getType().equals(ProductType.BOOK) && item.isHasDiscount()))
                .map(item -> new Product.ProductBuilder(item.getType(),
                        item.getPrice() * 0.9).hasDiscount(true).build())
                .toList();
        System.out.println(listOfDiscountedBooks);
    }

    public void cheapestProduct(List<Product> products) {
        Product cheapestProduct = products.stream()
                .filter(item -> item.getType().equals(ProductType.BOOK))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [category: Book] not found!"));
        System.out.println(cheapestProduct);
    }

    public void latestProducts(List<Product> products) {
        List<Product> latestProducts = products.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .toList();
        System.out.println(latestProducts);
    }

    public void overallPrice(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        double overallPrice = products.stream()
                .filter(item ->(item.getDate().getYear() == currentDate.getYear() &&
                        item.getType().equals(ProductType.BOOK) &&
                        item.getPrice() <= 75))
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total Price of the products: " + overallPrice);
    }

    public void groupByType(List<Product> products) {
        Map<ProductType, List<Product>> groupByType = products.stream()
                .collect(Collectors.groupingBy(Product::getType));
        System.out.println(groupByType);
    }
}
