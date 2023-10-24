package br.com.ecommerce;

public class Produto {
    private int id;
    private String nome;
    private int quantidade;

    public Produto(int id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public void decrementaEstoque(int quantidade) throws Exception {
        if (this.quantidade - quantidade < 0) {
            throw new Exception("Não foi possível remover essa quantidade do estoque!");
        }
        
        this.quantidade -= quantidade;
    }
}
