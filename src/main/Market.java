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
                registerProduct();
                break;

            case 2:
                listProduct();
                break;
            
            case 3:
                buyProduct();
                break;

            case 4:
                viewCart();
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

        if(products.size() > 0){

            System.out.println("------------------------------------------------------------");
            System.out.println("Lista de Produtos \n");

            for(Product p : products){ /* Para cada produto existente */

                System.out.println(p);

            }

            System.out.println("------------------------------------------------------------");

        } else {

            System.out.println("------------------------------------------------------------");
            System.out.println("------------NÃO EXISTE NENHUM PRODUTO CADASTRADO------------");
            System.out.println("------------------------------------------------------------");

        }

        menu();

    }

    private static void buyProduct(){

        if(products.size() > 0){ //Caso exista produtos cadastrados

            System.out.println("------------------------------------------------------------");
            System.out.println("--------------------PRODUTOS DISPONÍVEIS--------------------");
            System.out.println("------------------------------------------------------------\n");

            for(Product p : products){ /* Para cada produto existente */

                System.out.println("    " + p + "\n");

            }

            System.out.println("\nCódigo do produto: ");
            int id = Integer.parseInt(sc.next());
            boolean isPresent = false;

            for(Product p : products){

                if(p.getId() == id){

                    int amout = 0;

                    try {

                        amout = cart.get(p);  

                        /* Checa se o produto (p) está no carrinho
                            Será adicionado + 1 toda vez que um novo produto for adicionado ao carrinho*/
                        cart.put(p, amout+1);     

                    } catch (NullPointerException e) { /* Caso não exista produto será lançada uma excessão */
                        
                        // Caso o produto seja o primeiro do carrinho
                        cart.put(p, 1);

                    }

                    System.out.println(p.getName() + " adicionado ao carrinho!");
                    isPresent = true;

                    if(isPresent){

                        System.out.println("Deseja adicionar outro produto?"
                        +                   "\n 1- Sim"
                        +                   "\n 2- Finalizar compra"
                        +                   "\nDigite e confirme sua escolha: ");
                        int option = Integer.parseInt(sc.next());

                        if(option == 1){
                            buyProduct(); //Retorna o mesmo método caso o usuário queria prosseguir a compra
                        }else{
                            //checkout(); //Metodo finalizar compra
                        }

                    } else {

                        System.out.println("------------------------------------------------------------");
                        System.out.println("-------------------PRODUTO NÃO ENCONTRADO-------------------");
                        System.out.println("------------------------------------------------------------");
                        menu(); 

                    }

                } 

            }   

        } else { // Caso não exista nenhum produto cadastrado

            System.out.println("------------------------------------------------------------");
            System.out.println("------------NÃO EXISTE NENHUM PRODUTO CADASTRADO------------");
            System.out.println("------------------------------------------------------------");
            menu();

        }
    }

}
