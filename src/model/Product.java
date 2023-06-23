package model;

import utils.Utils;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + this.getId() 
            + ", name=" + this.getName() 
                + ", price=" + Utils.doubleToString(this.getPrice()) + "]";
    }   

}
