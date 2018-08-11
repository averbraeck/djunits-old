package org.djunits.demo.examples;

import org.djunits.unit.LengthUnit;
import org.djunits.value.vdouble.scalar.Length;

/**
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 11, 2018 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="http://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public final class ShowDisplayUnit
{
    /** */
    private ShowDisplayUnit()
    {
        // Utility class 
    }

    /**
     * @param args args (blank)
     */
    public static void main(final String[] args)
    {
        Length length = new Length(10.00, LengthUnit.KILOMETER);
        System.out.println("original len: " + length);
        System.out.println("original si : " + length.si);
        length.setDisplayUnit(LengthUnit.METER);
        System.out.println("changed len: " + length);
        System.out.println("changed si : " + length.si);
    }

}

