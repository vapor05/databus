package com.vapor05.databus.importer;

import com.vapor05.databus.json.JSONException;
import com.vapor05.databus.json.JSONList;
import com.vapor05.databus.json.JSONMap;
import java.io.IOException;

public interface Importer {
    
    public JSONList<JSONMap> readAll() throws JSONException, IOException;
    
    public void finish() throws IOException;
}
