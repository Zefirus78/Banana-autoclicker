package hw_8;

import lombok.Getter;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Product {
    @Getter
    private int id;
    @Getter
    private ProductType type;
    @Getter
    private double price;
    @Getter
    private boolean hasDiscount;
    @Getter
    private Date date;
    private Double discountedPrice;

    private Product(ProductBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.price = builder.price;
        this.hasDiscount = builder.hasDiscount;
        this.date = builder.date;
        discountedPrice = this.price - this.price * 0.1;
    }

    public static class ProductBuilder {
        private int id;
        private ProductType type;
        private double price;
        private boolean hasDiscount;
        private Date date;

        public ProductBuilder(ProductType type, double price) {
            this.type = type;
            this.price = price;
        }

        public ProductBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder hasDiscount(boolean hasDiscount) {
            this.hasDiscount = hasDiscount;
            return this;
        }

        public ProductBuilder date(Date date) {
            this.date = date;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
    public static void listOfExpensiveBooks(List<Product> products){
        List<Product> listOfExpensiveBooks = products.stream()
                .filter(item -> (item.getType().equals(ProductType.BOOK) && item.getPrice() > 250))
                .toList();
        System.out.println(listOfExpensiveBooks);
    }

    public static void  listOfDiscountedBooks(List<Product> products){
        List<Product> listOfExpensiveBooks = products.stream()
                .filter(item ->item.getType().equals(ProductType.BOOK) && item.hasDiscount)
                .map(item -> (item.getPrice() - item.getPrice() * 0.1))
                .toList();
    }

    public static void cheapestProduct(List<Product> products) throws NoSuchProductFoundException {
        try {
            Optional<Product> cheapestProduct = products.stream()
                    .filter(item -> item.getType().equals(ProductType.BOOK))
                    .min(Comparator.comparing(Product::getPrice));
            System.out.println(cheapestProduct.get());
        } catch (Exception e) {
            throw new NoSuchProductFoundException("Product in category 'Book' not found");
        }
    }




}
