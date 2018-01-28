package org.djunits.unit.scale;

/**
 * A Scale for standard, e.g. SI, units. Values in these units need no conversion.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 11, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class StandardScale extends LinearScale
{
    /** a ready-to-use instance of the standard scale (they are all the same...). */
    public static final StandardScale SCALE = new StandardScale();

    /**
     * Construct a standard Scale without a transformation.
     */
    public StandardScale()
    {
        super(1.0);
    }

    /** {@inheritDoc} */
    @Override
    public final double toStandardUnit(final double value)
    {
        return value;
    }

    /** {@inheritDoc} */
    @Override
    public final double fromStandardUnit(final double value)
    {
        return value;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isBaseSIScale()
    {
        return true;
    }

}
