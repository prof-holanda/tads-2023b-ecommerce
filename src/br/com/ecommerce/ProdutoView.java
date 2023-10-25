
package br.com.ecommerce;

import java.util.Arrays;
import java.util.Scanner;


public class ProdutoView {
    private static ProdutoService produtoService;
    private static Scanner intput;
    
    public static void main(String[] args) {
        produtoService = new ProdutoService();
        intput = new Scanner(System.in);
        int escolha = -1;
        
        while(escolha != 0) {
            System.out.println("Seja bem vindo ao ecommerce!");
            System.out.println("\tDigite 1 para comprar um produto");
            System.out.println("\tDigite 2 para dar baixa no estoque");
            System.out.println("\tDigite 0 para sair");
            System.out.print(">");
            escolha = intput.nextInt();
            
            switch (escolha) {
                case 1:
                    ProdutoView.comprarProduto();
                    break;
                case 2:
                    ProdutoView.darBaixaNoEstoque();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    private static void comprarProduto() {
        try {
            System.out.println("Informe o código do produto e a quantidade separados por vírgula ex: 1,2");
            String[] compra = intput.next().split(",");
            Produto p = produtoService.comprar(
                    Integer.parseInt(compra[0]),
                    Integer.parseInt(compra[1]));
            
            System.out.println("Produto: ");
            System.out.println(p);
            System.out.println("Comprado com sucesso!!!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private static void darBaixaNoEstoque() {
        System.out.println("Informe os códigos dos produtos separados por vírgula ex: 1,2,3.");
            Arrays.stream(intput.next().split(","))
                    .map(Integer::parseInt)
                    .forEach(id -> {
                        try {
                            Produto p = produtoService.remove(id);
            
                            System.out.println("Produto: ");
                            System.out.println(p);
                            System.out.println("Removido com sucesso!!!");
                        } catch (Exception e) {
                            System.out.println(e.toString());
                        }
                    });
    }
}
