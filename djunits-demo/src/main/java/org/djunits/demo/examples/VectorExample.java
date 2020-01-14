package org.djunits.demo.examples;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.scale.Scale;
import org.djunits.value.storage.StorageType;
import org.djunits.value.vdouble.function.DoubleFunction;
import org.djunits.value.vdouble.vector.LengthVector;
import org.djunits.value.vdouble.vector.base.DoubleVector;

public class VectorExample
{

    public static void main(final String[] args)
    {
        double[] data = new double[10];
        for (int i = 0; i < data.length; i++)
        {
            data[i] = i * 0.8;
        }
        LengthVector lengthVector = DoubleVector.instantiate(data, LengthUnit.FOOT, StorageType.DENSE);
        System.out.println(lengthVector);
        lengthVector = lengthVector.mutable();
        lengthVector.rint();
        System.out.println(lengthVector);
        
        lengthVector = DoubleVector.instantiate(data, LengthUnit.FOOT, StorageType.DENSE);
        lengthVector = lengthVector.mutable();
        lengthVector.assign(new DoubleFunction() {
            final Scale scale = LengthUnit.FOOT.getScale();
            @Override
            public double apply(final double value)
            {
                return scale.toStandardUnit(Math.rint(scale.fromStandardUnit(value)));
            }});
        System.out.println(lengthVector);
    }
}
