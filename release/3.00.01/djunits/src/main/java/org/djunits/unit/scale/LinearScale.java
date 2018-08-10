package org.djunits.unit.scale;

/**
 * A Scale for linear transformations not involving a zero-offset, e.g. for Length, Time, Area. <br>
 * A linear scale is a scale that is linearly relates a unit to the underlying SI standard unit. E.g. Mile is linearly related
 * to meter (the SI unit for length) and the conversion is zero-based (0 miles equals 0 meter). Unlike temperature in degrees
 * Celsius which is <strong>not</strong> linearly related to the Kelvin (the SI unit for temperature) because the conversion is
 * not zero-based (0&deg;C is 273.15K).
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("checkstyle:designforextension")
    public boolean isBaseSIScale()
    {
        return this.conversionFactorToStandardUnit == 1.0;
    }

}