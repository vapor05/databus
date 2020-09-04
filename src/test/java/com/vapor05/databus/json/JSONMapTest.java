package com.vapor05.databus.json;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JSONMapTest {
    
    public JSONMapTest() {
    }

    @Test
    public void testParse() throws Exception
    {
        JSONMap dm = new JSONMap("{boolean: true, integer: 456, double: 98.76, " +
                "string1: \"value\", string2: \'value2\', array: [1,2,3,4]}");
        
        assertTrue(dm.get("boolean").equals(Boolean.TRUE));
        assertTrue(dm.get("integer").equals(456l));
        assertTrue(dm.get("double").equals(98.76));
        assertTrue(dm.get("string1").equals("value"));
        assertTrue(dm.get("string2").equals("value2"));
        assertTrue(dm.get("array").equals(new JSONList("[1,2,3,4]")));
    }
    
    @Test
    public void testEquals()
    {
        JSONMap data1;
        JSONMap data2;
        JSONMap data3;
        
        data1 = new JSONMap("{key: 4, column: value}");
        data2 = new JSONMap("{key: 4, column: value}");
        data3 = new JSONMap("{key: 2, column: diffvalue}");
        
        assertTrue(data1.equals(data2));
        assertFalse(data1.equals(data3));
        
        data2.put("newkey", 78);
        assertFalse(data1.equals(data2));
        data1 = new JSONMap();
        data2 = new JSONMap();
        assertTrue(data1.equals(data2));
    }
    
}
