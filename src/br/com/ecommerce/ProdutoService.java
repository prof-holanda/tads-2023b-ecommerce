package br.com.ecommerce;

import java.util.Map;

public class ProdutoService {
    private final Map<Integer, Produto> produtos;

    public ProdutoService() {
        this.produtos = ProdutoCsvReader.carregarTodos();
    }
    
    private void validaCodigoProduto(int id) throws Exception {
        if (!produtos.containsKey(id)) {
            throw new Exception("O código informado não existe!");
        }
    }
    public Produto comprar(int id, int quantidade) throws Exception {
        validaCodigoProduto(id);
        
        Produto p = produtos.get(id);
        
        p.decrementaEstoque(quantidade);
        
        produtos.put(id, p);
        
        return p;
    }
    
    public Produto remove(int id) throws Exception {
        validaCodigoProduto(id);
        
        Produto p = produtos.get(id);
        
        produtos.remove(id);
        
        return p;
    }
}
