package com.vapor05.databus.dataframe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataFrameRowTest {

    @Test
    public void testSumInt() 
    {
        DataFrameRow<Integer> row = new DataFrameRow(new Integer[]{2,4,6,8,10});
        int expected = 30;
        int actual;
        
        actual = row.sumInt();
        assertEquals(expected, actual);
    }
    
}
