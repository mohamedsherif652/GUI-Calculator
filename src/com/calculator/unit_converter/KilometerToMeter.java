package com.calculator.unit_converter;

/**
 * Created by mohamedsherif on 12/21/16.
 */
public class KilometerToMeter extends UnitConverter {
    public KilometerToMeter(double numA, boolean isFlipped){
        this.numA = numA;
        this.isFlipped = isFlipped;
    }

    @Override
    public double convert(){
        if(isFlipped){
            return numA / 1000;
        } else {
            return numA * 1000;
        }
    }
}
