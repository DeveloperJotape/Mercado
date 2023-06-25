package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Product;
import utils.Utils;

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

            for(Product p : products){ // Percorre a lista de produtos

                if(p.getId() == id){ // Verifica se o ID que o usuário informou bate com o ID de um produto

                    int quantity = 0;

                    try {

                        quantity = cart.get(p);  

                        /* Checa se o produto (p) está no carrinho
                            Será adicionado + 1 toda vez que um novo produto for adicionado ao carrinho*/
                        cart.put(p, quantity+1);     

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
                            checkout(); //Metodo finalizar compra
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

    private static void viewCart(){
         
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------PRODUTOS NO SEU CARRINHO------------------");
        System.out.println("------------------------------------------------------------");
        
        if(cart.size() > 0){
        
            for(Product p : cart.keySet()){

                System.out.println("Produto: " + p + 
                                    "\nQuantidade: " + cart.get(p));  

            }

        } else {

            System.out.println("Carrinho está vazio!");

        }

        menu();

    }

    private static void checkout(){

        Double purchaseValue = 0.0;
        System.out.println("Seus produtos: ");

        for(Product p : cart.keySet()){

            int quantity = cart.get(p);
            purchaseValue += p.getPrice() * quantity;
            System.out.println(p);
            System.out.println("Quantidade: " + quantity);
            System.out.println("------------------------------");

        }

        System.out.println("Valor total da compra: " + Utils.doubleToString(purchaseValue));
        cart.clear(); // Limpa o carrinho após a compra

        System.out.println("------------------------------------------------------------");
        System.out.println("-----------------OBRIGADO PELA PREFERÊNCIA!-----------------");
        System.out.println("------------------------------------------------------------");

        menu();

    }

}
