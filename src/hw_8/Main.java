package hw_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Product>  listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product.ProductBuilder(ProductType.BOOK, 20).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.BOOK, 50).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.BOOK, 260).hasDiscount(true).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.CAR, 10200).hasDiscount(true).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.CAR, 5000).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.CAR, 10000).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.TOY,70).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.TOY,100).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.TOY,2000).build());

        ProductMethods productMethods = new ProductMethods();
        Map<ProductType, List<Product>> discountedProducts = productMethods.groupByType(listOfProducts);
        System.out.println("{");
        for(Map.Entry<ProductType, List<Product>> entry : discountedProducts.entrySet()) {
            System.out.println(entry.getKey());
            for(Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
        System.out.println("}");

    }
}
