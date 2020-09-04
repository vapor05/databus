
package com.vapor05.databus.dataframe;

import java.util.HashMap;
import java.util.Set;

public class DataFrame {
    
    private HashMap<String, Integer> columns;
    private DataFrameRow[] data;
    
    public DataFrame (HashMap<String, Integer> columns, DataFrameRow[] data)
    {
        this.columns = columns;
        this.data = data;
    }
    
    public Set<String> getColumns()
    {
        return columns.keySet();
    }
    
    public int getRowCount()
    {
        return data.length;
    }
    
    public DataFrameRow getColumn(String column)
    {
        int index = columns.get(column);
        
        return data[index];
    }
    
    public int sum(String column)
    {
        DataFrameRow row;
        
        row = getColumn(column);
        
        return row.sumInt();
    }
}
