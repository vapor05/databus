package com.vapor05.databus.importer;

import com.vapor05.databus.json.JSONList;
import com.vapor05.databus.json.JSONMap;
import java.io.File;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CSVImporterTest {

    @Test
    public void testReadAll() throws Exception
    {
        File input = new File("src/test/resources/importer/csv/testdata.csv");
        CSVImporter reader = new CSVImporter(input);
        JSONList<JSONMap> expectedData = new JSONList("[{id:'1',col1:'45',date:2020-07-24,stringCol:abcd,floatCol:'234.5'},"
                + "{id:'2',col1:'90',date:2019-02-12,stringCol:some data,floatCol:'9.087'},"
                + "{id:'3',col1:'4',date:2020-09-08,stringCol:some more data in this column,floatCol:'4.0'},"
                + "{id:'4',col1:'10',date:2008-02-23,stringCol:some string data,floatCol:'0.00008'},"
                + "{id:'5',col1:'982346',date:1998-05-28,stringCol:efgi,floatCol:'89.06'}]");
        JSONList<JSONMap> actualData = reader.readAll();
        reader.finish();
        
        assertEquals(expectedData, actualData);
    }
    
}
