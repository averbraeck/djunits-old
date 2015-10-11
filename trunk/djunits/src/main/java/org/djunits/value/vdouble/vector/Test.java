package org.djunits.value.vdouble.vector;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.value.DataType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Acceleration;

/**
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 4, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public final class Test
{
    /** */
    private Test()
    {
        // empty constructor
    }

    /**
     * @param args args
     * @throws ValueException ve
     */
    public static void main(final String[] args) throws ValueException
    {
        double[] v1 = new double[]{1.0, 0.0, 3.0, 2.0, 4.0, 0.0, 9.0, 15.0, 20.0, 30.0};
        AccelerationVector av1 = new AccelerationVector(v1, AccelerationUnit.KM_PER_HOUR_2, DataType.DENSE);
        System.out.println("Sparse= " + av1.toSparse().toString(true, true));
        Acceleration acc = av1.get(4);
        System.out.println("acc[4]= " + acc);
        System.out.println("zSum of " + av1.toString(true, true) + " = " + av1.zSum());
        AccelerationVector av2 = av1.mutable().sqrt().immutable();
        System.out.println("Sqrt   = " + av2.toString(true, true));
        MutableAccelerationVector mav3 = av2.mutable();
        System.out.println("mav3   = " + mav3.toString(true, true));
        System.out.println("sin    = " + av1.mutable().sin().toString(true, true));
        System.out.println("exp    = " + av1.mutable().exp().toString(true, true));
        System.out.println("Sparse pow(2.0) = " + av1.toSparse().mutable().pow(2.0).toString(true, true));
        System.out.println("Sparse pow(2.0) = " + av1.mutable().toSparse().pow(2.0).toString(true, true));
        System.out.println("Sparse pow(2.0) = " + av1.mutable().pow(2.0).toSparse().toString(true, true));
        AccelerationVector av4 = av1.plus(av2).toSparse();
        System.out.println("av1 + av2 = " + av4.toString(true, true));
        AccelerationVector av5 = av1.minus(av2).toSparse();
        System.out.println("av1 - av2 = " + av5.toString(true, true));
        AccelerationVector av6 = av1.times(av2);
        System.out.println("av1 * av2 = " + av6.toString(true, true));
        AccelerationVector av7 = av1.divide(av2).toSparse();
        System.out.println("av1 / av2 = " + av7.toString(true, true));

        LengthVector.Rel lvr1 = new LengthVector.Rel(v1, LengthUnit.KILOMETER, DataType.DENSE);
        System.out.println("zSum of " + lvr1.toString(true, true) + " = " + lvr1.zSum());
    }

}
