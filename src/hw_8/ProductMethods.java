package hw_8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductMethods {
    List<Product> products = new ArrayList<>();

    public List<Product> listOfExpensiveBooks(List<Product> products){
        return products.stream()
                .filter(item -> (item.getType().equals(ProductType.BOOK) && item.getPrice() > 250))
                .collect(Collectors.toList());
    }

    public List<Product>  listOfDiscountedBooks(List<Product> products){
        return products.stream()
                .filter(item ->(item.getType().equals(ProductType.BOOK) && item.isHasDiscount()))
                .map(item -> new Product.ProductBuilder(item.getType(),
                        item.getPrice() * 0.9).hasDiscount(true).build())
                .collect(Collectors.toList());
    }

    public Product cheapestProduct(Product product) {
        return products.stream()
                .filter(item -> item.getType().equals(ProductType.BOOK))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [category: Book] not found!"));
    }

    public List<Product> latestProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .toList();
    }

    public double overallPrice(List<Product> products) {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                .filter(item ->(item.getDate().getYear() == currentDate.getYear() &&
                        item.getType().equals(ProductType.BOOK) &&
                        item.getPrice() <= 75))
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<ProductType, List<Product>> groupByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
