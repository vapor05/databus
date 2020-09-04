
package com.vapor05.databus.json;

import java.util.HashMap;
import java.util.List;

public class JSONMap extends HashMap<String, Object> {
    
    public JSONMap() {}
    
    public JSONMap(String json)
    {
        this(new JSONTokener(json));
    }
    
    public JSONMap(JSONTokener tokener)
    {
        char c;
        String key;
        
        if (tokener.nextClean() != '{') throw tokener.syntaxError("A JSON text must start with '{'");
        
        for (;;)
        {
            c = tokener.nextClean();
            
            switch (c)
            {
                case 0:
                    throw tokener.syntaxError("A JSON text must end with '}'");
                case '}':
                    return;
                default:
                    tokener.back();
                    key = tokener.nextValue().toString();
            }
            
            c = tokener.nextClean();
            
            if (c != ':') throw tokener.syntaxError("Expected a ':' after a key");
            
            if (!this.containsKey(key)) this.put(key, tokener.nextValue());
            
            switch (tokener.nextClean())
            {
                case ';':
                case ',':
                    if (tokener.nextClean() == '}') return;
                    
                    tokener.back();
                    
                    break;
                case '}':
                    return;
                default:
                    throw tokener.syntaxError("Expected a ',' or '}'");
            }
        }
    }
    
    public String getString(String key) throws JSONException
    {
        Object value = super.get(key);
        
        if (value == null) throw new JSONException(value + " is not a valid string");
        
        return value.toString();
    }
    
    public String getString(String key, String defaultValue) throws JSONException
    {
        Object value = super.get(key);
        
        if (value == null) return defaultValue;
        
        return value.toString();
    }
    
    public int getInt(String key) throws JSONException
    {
        Object value = super.get(key);
        
        if (value instanceof Number) return ((Number)value).intValue();
        if (value instanceof String) return Integer.parseInt((String)value);
        
        throw new JSONException(value + " is not a valid integer");
    }
    
    public long getLong(String key) throws JSONException
    {
        Object value = super.get(key);
        
        if (value instanceof Number) return ((Number)value).longValue();
        if (value instanceof String) return Long.parseLong((String)value);
        
        throw new JSONException(value + " is not a valid integer");
    }
    
    public JSONMap getJSONMap(String key) throws JSONException
    {
        Object value = super.get(key);
        
        if (value instanceof JSONMap) return (JSONMap) value;
        
        throw new JSONException(value + " is not a valid DataObject");
    }
    
    public double getDouble(String key) throws JSONException
    {
        Object value = super.get(key);
        
        if (value instanceof Number) return ((Number)value).doubleValue();
        if (value instanceof String) return Double.parseDouble((String)value);
        
        throw new JSONException(value + " is not a valid double");
    }
    
    public JSONList getJSONList(String key)
    {
        Object value = super.get(key);
        JSONList array = new JSONList();
        
        if (value instanceof JSONList) return (JSONList) value;
        if (value instanceof List) return new JSONList((List) value);
        
        array.add(value);
        
        return array;
    }
    
    public boolean getBoolean(String key) throws JSONException
    {
        Object value = super.get(key);
        
        if (value instanceof Boolean) return ((Boolean)value).booleanValue();
        if (value instanceof String) return (Boolean.valueOf((String)value));
        
        throw new JSONException(value + " is not a valid boolean");
    }
    
    @Override
    public boolean equals(Object object)
    {
        return object instanceof JSONMap ? super.equals(object) : false;
    }
    
}
