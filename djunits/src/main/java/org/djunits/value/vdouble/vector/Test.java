package org.djunits.value.vdouble.vector;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.ValueException;

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
        double[] v1 = new double[]{1.0, 2.0, 3.0, 4.0, 6.0, 8.0, 9.0, 15.0, 20.0, 30.0};
        AccelerationVector av1 = new AccelerationVector.Dense(v1, AccelerationUnit.METER_PER_SECOND_2);
        System.out.println("zSum of " + av1.toString(true, true) + " = " + av1.zSum());
        AccelerationVector av2 = av1.mutable().sqrt().immutable();
        System.out.println("Sqrt of " + av1.toString(true, true) + " = " + av2.toString(true, true));
        MutableAccelerationVector mav3 = av2.mutable();
        System.out.println("mav3 = " + mav3.toString(true, true));
        System.out.println("sin " + av1.toString(true, true) + " = " + av1.mutable().sin().toString(true, true));
        System.out.println("exp " + av1.toString(true, true) + " = " + av1.mutable().exp().toString(true, true));
        System.out.println("Sparse pow(2.0) " + av1.toString(true, true) + " = "
            + av1.toSparse().mutable().pow(2.0).toString(true, true));
        System.out.println("Sparse pow(2.0) " + av1.toString(true, true) + " = "
            + av1.mutable().toSparse().pow(2.0).toString(true, true));
        System.out.println("Sparse pow(2.0) " + av1.toString(true, true) + " = "
            + av1.mutable().pow(2.0).toSparse().toString(true, true));
        AccelerationVector av4 = av1.plus(av2).toSparse();
        System.out.println("av1 + av2 = " + av4.toString(true, true));
    }

}
