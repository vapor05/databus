package com.vapor05.databus.json;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JSONListTest {
    
    public JSONListTest() {
    }

    @Test
    public void testParse()
    {
        JSONList array = new JSONList("[true, 762, 74.12, \"string1\", \'string2\']");
        assertTrue(array.get(0).equals(Boolean.TRUE));
        assertTrue(array.get(1).equals(762l));
        assertTrue(array.get(2).equals(74.12));
        assertTrue(array.get(3).equals("string1"));
        assertTrue(array.get(4).equals("string2"));
    }
    
}
