package org.djunits4.value.vdouble.vector;

import java.util.Arrays;

import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.vector.base.DoubleVector;

/**
 * Test.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class TestNewVector
{
   public static void main(final String[] args) throws ValueRuntimeException, UnitException
   {
       AreaVector av = DoubleVector.create(new double[] {1.5,2.1,3.9}, AreaUnit.SQUARE_METER, StorageType.DENSE);
       System.out.println(av);
       
       AreaVector av2 = av.mutable();
       av2.ceil();
       System.out.println(av2);
       System.out.println(av);
       try
       {
           av.ceil();
       }
       catch (ValueRuntimeException e)
       {
           System.out.println("Modifying immutable throwed an exception as expected");
       }
       
       AreaVector avimm = DoubleVector.create(new double[] {1.5,2.1,3.9}, AreaUnit.SQUARE_METER, StorageType.SPARSE);
       System.out.println("\n" + avimm);
       
       SIVector siv = SIVector.of(new double[] {1.5,2.1,3.9}, "m2", StorageType.SPARSE);
       System.out.println("\n" + siv);
       System.out.println(siv.asArea(AreaUnit.ACRE));
       AreaVector vv = siv.as(AreaUnit.ACRE);
       System.out.println(vv);
       System.out.println(siv.as(AreaUnit.ACRE).toString());
       
       SIVector siv2 = siv.times(siv);
       System.out.println("\n" + siv2);
       
       AreaVector avnew = DoubleVector.create(new double[] {1.5,2.1,3.9}, AreaUnit.SQUARE_METER, StorageType.DENSE);
       System.out.println("\n" + avnew);

       Area[] aa = av.getScalars();
       System.out.println(Arrays.asList(aa));
   }
    
}

