package com.vapor05.databus.dataframe;

import com.vapor05.databus.json.JSONMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataFrameTest {
    
    @Test
    public void testShow() 
    {
        ByteArrayOutputStream outTest = new ByteArrayOutputStream();
        DataFrameRow[] data = new DataFrameRow[] {
            new DataFrameRow(new Integer[] {2,4,6,8,10}),
            new DataFrameRow(new String[] {"a","b","c","e","f"}),
            new DataFrameRow(new Double[] {1.1,2.2,3.3,4.4,5.5})
        };
        HashMap<String, Integer> columns = new HashMap<>(Map.of(
            "ints", 0,
            "strs", 1,
            "doubles", 2
        ));
        String expected = "|ints      |strs      |doubles   |\n" +
            "|2         |a         |1.1       |\n" +
            "|4         |b         |2.2       |\n" +
            "|6         |c         |3.3       |\n" +
            "|8         |e         |4.4       |\n" +
            "|10        |f         |5.5       |\n";

        DataFrame df = new DataFrame(columns, data);
        df.show(new PrintStream(outTest));
        assertEquals(expected, outTest.toString());
    }
    
}
