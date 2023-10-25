package br.com.ecommerce;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProdutoCsvReader {
    public static Map<Integer, Produto> carregarTodos() {        
        Map<Integer, Produto> produtos = new HashMap<>();
        
        try{
            
            File arquivoProdutos = new File(
                "C:\\Users\\rf1792\\projetos\\ecommerce\\src\\br\\com\\ecommerce\\produtos.csv"
            );
            CsvReader reader = new CsvReader(arquivoProdutos, ';');
            
            reader.next();
            reader.next();
            reader.next();
            
            while (reader.hasNext()) {
                Produto p = new Produto(
                        reader.nextInt(),
                        reader.next(),
                        reader.nextInt()
                );
                
                produtos.put(p.getId(), p);
            }
            
            
        } catch( IOException e) {
            e.printStackTrace();
        }
        
        return produtos;
    }
}
