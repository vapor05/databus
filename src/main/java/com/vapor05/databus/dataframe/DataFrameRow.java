package com.vapor05.databus.dataframe;

import java.util.Arrays;
import java.util.stream.Stream;

public class DataFrameRow<T> {
    
    private T[] vector;
    
    public DataFrameRow(T[] vector)
    {
        this.vector = vector;
    }
    
    public int sumInt()
    {
        Stream<Integer> stream = (Stream<Integer>) Arrays.stream(vector);
        
        
        return stream.reduce(0, (subtotal, element) -> subtotal + element);
    }
    
    public long sumLong()
    {
        Stream<Long> stream = (Stream<Long>) Arrays.stream(vector);
        
        
        return stream.reduce(0L, (subtotal, element) -> subtotal + element);
    }
    
    public double sumDouble()
    {
        Stream<Double> stream = (Stream<Double>) Arrays.stream(vector);
        
        return stream.reduce(0.0, (subtotal, element) -> subtotal + element);
    }
            
}
