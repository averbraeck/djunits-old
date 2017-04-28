package org.djunits.demo.website;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.matrix.LengthMatrix;
import org.djunits.value.vdouble.matrix.MutableLengthMatrix;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.vector.DoubleVector;

/**
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 16, 2016 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class Test
{

    /**
     * @param args args
     * @throws ValueException on error 
     */
    public static void main(final String[] args) throws ValueException
    {
        DoubleScalar.Rel<JerkUnit> jerk1 = new DoubleScalar.Rel<>(1.2, JerkUnit.SI);
        DoubleScalar.Rel<JerkUnit> jerk2 = jerk1.multiplyBy(2.0);
        double[] sv = new double[] { 1, 2, 3, 4, 5 };
        DoubleVector.Rel<JerkUnit> jerkVector = new DoubleVector.Rel<JerkUnit>(sv, JerkUnit.SI, StorageType.DENSE);
        
        Jerk jjerk1 = new Jerk(1.2, JerkUnit.SI);
        Jerk jjerk2 = jjerk1.multiplyBy(2.0);

        double[][] data = new double[1000][1000];
        for (int i=0; i<1000; i++) { for (int j=0; j<1000; j++) {data[i][j] = 9*i + 2*j * 0.364; }}
        MutableLengthMatrix lengthMatrix = new MutableLengthMatrix(data, LengthUnit.CENTIMETER, StorageType.DENSE);
        lengthMatrix.round();
    }

}
