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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("{\n");
        builder.append("\tid: ");
        builder.append("\t" + this.id);
        builder.append(",\n");
        builder.append("\tnome: ");
        builder.append("\t" + this.nome);
        builder.append(",\n");
        builder.append("\tquantidade: ");
        builder.append("\t" + this.quantidade);
        builder.append(",\n");
        builder.append("}\n");
        
        return builder.toString();
    }
    
    
}
