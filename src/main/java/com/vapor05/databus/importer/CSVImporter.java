package com.vapor05.databus.importer;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.vapor05.databus.json.JSONException;
import com.vapor05.databus.json.JSONList;
import com.vapor05.databus.json.JSONMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVImporter implements Importer {

    private final File inputCsv;
    private final CSVReader reader;
    
    public CSVImporter(File inputCsv) throws FileNotFoundException
    {
        this.inputCsv = inputCsv;
        reader = new CSVReader(new FileReader(inputCsv));
    }
    
    public CSVImporter(String inputCsv) throws FileNotFoundException
    {
        this(new File(inputCsv));
    }
    
    @Override
    public JSONList<JSONMap> readAll() throws JSONException, IOException 
    {
        JSONList<JSONMap> data = new JSONList();
        String[] line;
        String[] header;
        JSONMap row;
        
        try {
            // get header
            header = reader.readNext();
            
            while ((line = reader.readNext()) != null)
            {
                row = new JSONMap();
                
                for (int i = 0; i < header.length; i++) row.put(header[i], line[i]);
                
                data.add(row);
            }
        } catch (CsvValidationException ex) {
            throw new IOException(ex.getMessage());
        }
        
        return data;
    }

    @Override
    public void finish() throws IOException 
    {
        reader.close();
    }
    
}
