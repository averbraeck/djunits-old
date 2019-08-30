package org.djunits4.unit.scale;

/**
 * A Scale for standard, e.g. SI, units. Values in these units need no conversion.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class StandardScale extends LinearScale
{
    /** */
    private static final long serialVersionUID = 20151011L;
    
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
    public String toString()
    {
        return "StandardScale []";
    }
}
