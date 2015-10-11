package org.djunits.unit.scale;

/**
 * A Scale for linear transformations, e.g. for Length, Time, Area. 
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 11, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class LinearScale implements Scale
{
    /** multiply by this number to convert to the standard (e.g., SI) unit. */
    private final double conversionFactorToStandardUnit;

    /**
     * Construct a Scale for linear transformations.
     * @param conversionFactorToStandardUnit the conversion factor by which this number has to be multiplied to convert it to
     *            the standard (e.g., SI) unit.
     */
    public LinearScale(final double conversionFactorToStandardUnit)
    {
        super();
        this.conversionFactorToStandardUnit = conversionFactorToStandardUnit;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:designforextension")
    @Override
    public double toStandardUnit(final double value)
    {
        return value * this.conversionFactorToStandardUnit;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:designforextension")
    @Override
    public double fromStandardUnit(final double value)
    {
        return value / this.conversionFactorToStandardUnit;
    }

    /**
     * @return conversionFactorToStandardUnit
     */
    public final double getConversionFactorToStandardUnit()
    {
        return this.conversionFactorToStandardUnit;
    }

}
