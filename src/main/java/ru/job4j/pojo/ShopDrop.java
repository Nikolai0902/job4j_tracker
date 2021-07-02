package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int i) {
        for (int index = i; index < products.length - 1; index++) {
            products[index] = products[index + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
