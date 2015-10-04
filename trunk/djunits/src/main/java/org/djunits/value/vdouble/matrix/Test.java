package org.djunits.value.vdouble.matrix;

import org.ojalgo.access.Access2D.Factory;
import org.ojalgo.matrix.BasicMatrix;
import org.ojalgo.matrix.PrimitiveMatrix;

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
public class Test
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        final double[][] data = new double[][] { { 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 }, { 7.0, 8.0, 9.0 } };
        final Factory<PrimitiveMatrix> matrixFactory = PrimitiveMatrix.FACTORY;
        final BasicMatrix m = matrixFactory.rows(data);
        System.out.println(m.getDeterminant().doubleValue());
        System.out.println(m.getEigenvalues());
        System.out.println(m.invert() + "\n");

        final double[][] data2 = new double[][] { { 1.0, 2.0, 3.0, 4.0 }, { 4.0, 5.0, 6.0, 7.0 }, { 7.0, 8.0, 9.0, 10.0 } };
        final BasicMatrix m2 = matrixFactory.rows(data2);
        //System.out.println(m2.getDeterminant().doubleValue());
        System.out.println(m2.getEigenvalues());
        System.out.println(m2.invert());

    }

}

