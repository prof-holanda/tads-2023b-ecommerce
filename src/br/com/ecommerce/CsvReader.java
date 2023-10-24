/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public CsvReader(File file, int delimiter) throws IOException {
        this.stream = new FileInputStream(file);
        this. delimiter = delimiter;
    }
    
    
}
