package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Product;

/**
 * Classe responsável por operações relacionadas ao Mercado
 * 
 * @author João Pedro
 * @version 1.0
 * @since 22/06/2023
 * 
 */

public class Market {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Product> products; 
    private static Map<Product, Integer> cart; 

    public static void main(String[] args) {

        products = new ArrayList<>(products);
        cart = new HashMap<>();

        menu();

    }

    private static void menu(){

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------SUPERMERCADO------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("--------------------ESCOLHA UMA OPERAÇÃO--------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("|   1- Cadastrar    |");
        System.out.println("|   2- Listar       |");
        System.out.println("|   3- Comprar      |");
        System.out.println("|   4- Carrinho     |");
        System.out.println("|   5- Sair         |");
        System.out.println("------------------------------------------------------------");
        System.out.println("    Digite sua escolha e confirme: ");

        int option = sc.nextInt();

        switch(option){
            case 1:
                //registerProduct();
                break;

            case 2:
                //listProduct();
                break;
            
            case 3:
                //buyProduct();
                break;

            case 4:
                //viewCart();
                break;
                
            case 5:
                System.out.println("------------------------------------------------------------");
                System.out.println("-----------------OBRIGADO PELA PREFERÊNCIA!-----------------");
                System.out.println("-----------------------VOLTE SEMPRE!!-----------------------");
                System.out.println("------------------------------------------------------------");
                System.exit(0);    

            default:
                System.out.println("------------------------------------------------------------");
                System.out.println("-----------------------OPÇÃO INVÁLIDA-----------------------");
                System.out.println("------------------------------------------------------------");
                menu();
                break;
        }

    }

    private static void registerProduct(){

        System.out.println("------------------------------------------------------------");
        System.out.println("Nome do produto: ");
        String name = sc.nextLine();

        System.out.println("Preço do produto: ");
        Double price = sc.nextDouble();

        Product product = new Product(name, price);
        products.add(product);

        System.out.println(product.getName() + " cadastrado com sucesso!");
        System.out.println("------------------------------------------------------------");
        menu();

    }

    private static void listProduct(){



    }

}
