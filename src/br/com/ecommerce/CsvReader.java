package br.com.ecommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author rf1792
 */
public class CsvReader {
    private final InputStream stream;
    
    private final int delimiter;
    
    private static int LF = 10;
    
    private int next = -1;
    
    public CsvReader(File file, int delimiter) throws IOException {
        this.stream = new FileInputStream(file);
        this. delimiter = delimiter;
        
        next = stream.read();
    }
    
    public String next() throws IOException {
        StringBuilder builder = new StringBuilder();
        
        while(hasNext() && (next != delimiter && next != CsvReader.LF)) {
            builder.append((char)next);
            next = stream.read();
        }
        
        next = stream.read();
        
        return builder.toString();
    }
    
    public int nextInt() throws IOException {
        return Integer.parseInt(this.next());
    }
    
    public boolean hasNext() {
        return next != -1;
    }
}
