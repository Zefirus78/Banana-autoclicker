package hw_8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product>  listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product.ProductBuilder(ProductType.BOOK, 20).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.BOOK, 50).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.BOOK, 260).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.CAR, 10200).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.CAR, 5000).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.CAR, 10000).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.TOY,70).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.TOY,100).build());
        listOfProducts.add(new Product.ProductBuilder(ProductType.TOY,2000).build());

        ProductMethods productMethods = new ProductMethods();

        productMethods.listOfExpensiveBooks(listOfProducts);
    }
}
