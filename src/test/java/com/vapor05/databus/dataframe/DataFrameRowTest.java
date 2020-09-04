package com.vapor05.databus.dataframe;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataFrameRowTest {

    @Test
    public void testgetStream() 
    {
        DataFrameRow<Integer> row = new DataFrameRow(new Integer[]{2,4,6,8,10});
        Stream<Integer> stream = row.getStream();
        assertEquals(5L, stream.count());
    }
    
}
