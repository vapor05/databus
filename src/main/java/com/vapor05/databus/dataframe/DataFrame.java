
package com.vapor05.databus.dataframe;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;

public class DataFrame {
    
    private HashMap<String, Integer> columns;
    private HashMap<Integer, String> columnsIndex;
    private DataFrameRow[] data;
    
    public DataFrame (HashMap<String, Integer> columns, DataFrameRow[] data)
    {
        this.columns = columns;
        this.data = data;
        this.columnsIndex = new HashMap();
        
        for (String key : columns.keySet()) columnsIndex.put(columns.get(key), key);
    }
    
    public Set<String> getColumns()
    {
        return columns.keySet();
    }
    
    public int getRowCount()
    {
        return data[0].getVector().length;
    }
    
    public DataFrameRow getColumn(String column)
    {
        int index = columns.get(column);
        
        return data[index];
    }
    
    public void show(PrintStream out)
    {
        DataFrameRow row;
        int maxPrint = 5;
        
        if (getRowCount() <= maxPrint) maxPrint = getRowCount();
            
        printRow(0, out, true);
        
        for (int i = 0; i < maxPrint; i++)
        {
            printRow(i, out, false);
        }
        
        if (getRowCount() > maxPrint)
        {
            out.print(".\n.\n.\n");
            printRow(getRowCount()-1, out, false);
        }
    }
    
    private void printRow(int rowIndex, PrintStream out, Boolean isColumns)
    {
        out.print("|");

        for (int j = 0; j < columns.size(); j++)
        {
            int maxLength = 10;
            String elem;
            
            if (isColumns) elem = columnsIndex.get(j);
            else elem = data[j].getVector()[rowIndex].toString();

            if (elem.length() >= maxLength) elem = elem.substring(0, maxLength);
            else elem = String.format("%-" + maxLength + "s", elem);

            out.print(elem + "|");
        }

        out.print("\n");
    }
}
