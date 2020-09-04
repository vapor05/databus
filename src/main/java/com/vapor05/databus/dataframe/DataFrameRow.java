package com.vapor05.databus.dataframe;

import java.util.Arrays;
import java.util.stream.Stream;

public class DataFrameRow<T> {
    
    private T[] vector;
    
    public DataFrameRow(T[] vector)
    {
        this.vector = vector;
    }
    
    public T[] getVector()
    {
        return vector;
    }
    
    public Stream<T> getStream()
    {
        return Arrays.stream(vector);
    }       
}
