package model;

/**
 * Classe responsável por operações relacionadas ao Produto
 * 
 * @author João Pedro
 * @version 1.0
 * @since 22/06/2023
 * 
 */

public class Product {
    
    private static int count = 1;

    private int id;
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.id = count; /* Id irá receber o contador */
        this.name = name;
        this.price = price;
        Product.count += 1;
    }

}
