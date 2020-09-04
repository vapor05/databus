package com.vapor05.databus.json;

import java.util.ArrayList;
import java.util.Collection;

public class JSONList<T> extends ArrayList<T> {
    
    public JSONList() {}
    
    public JSONList(String array)
    {
        this(new JSONTokener(array));
    }
    
    public JSONList(Collection<? extends T> collection)
    {
        super(collection);
    }
    
    public JSONList(JSONTokener tokener)
    {
        if (tokener.nextClean() != '[') throw tokener.syntaxError("A DataMapArray test must start with '['");
        
        if (tokener.nextClean() != ']')
        {
            tokener.back();
            
            for (;;)
            {
                if (tokener.nextClean() == ',')
                {
                    tokener.back();
                    add(null);
                }
                else
                {
                    tokener.back();
                    add((T)tokener.nextValue());
                }
                
                switch (tokener.nextClean())
                {
                    case ',' -> {
                        if (tokener.nextClean() == ']') return;
                        
                        tokener.back();
                    }
                    case ']' -> {
                        return;
                    }
                    default -> throw tokener.syntaxError("Expected a ',' or ']'");
                }
            }
        }
    }
}
