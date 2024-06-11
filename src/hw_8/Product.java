package hw_8;

import lombok.Getter;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Product {
    private int id;
    private ProductType type;
    private double price;
    private boolean hasDiscount;
    private LocalDate date;

    private Product(ProductBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.price = builder.price;
        this.hasDiscount = builder.hasDiscount;
        this.date = builder.date;
    }

    public int getId() {
        return id;
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public LocalDate getDate() {
        return date;
    }

    public static class ProductBuilder {
        private int id;
        private ProductType type;
        private double price;
        private boolean hasDiscount;
        private LocalDate date = LocalDate.now();

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

        public ProductBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
