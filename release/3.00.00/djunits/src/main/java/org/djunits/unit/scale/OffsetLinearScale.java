package org.djunits.unit.scale;

/**
 * A Scale for linear transformations with an offset that has to be applied first when converting to the standard (SI) unit,
 * before the scaling takes place, e.g. for Temperature. As an example, transform from Degrees Fahrenheit to Kelvin (SI). The
 * conversion is K = (F + 459.67) × 5⁄9, and F = K × 9⁄5 − 459.67.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 11, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class OffsetLinearScale extends LinearScale implements Scale
{
    /** The offset that has to be taken into account for conversions, multiplied by the conversionFactorToStandardUnit. */
    private final double offsetToStandardUnit;

    /**
     * Construct a Scale for linear transformations with an offset, e.g. for Temperature.
     * @param conversionFactorToStandardUnit the conversion factor by which this number has to be multiplied to convert it to
     *            the standard (e.g., SI) unit.
     * @param offsetToStandardUnit the offset that has to be taken into account for conversions; when converting to a standard
     *            unit, the offset is applied first.
     */
    public OffsetLinearScale(final double conversionFactorToStandardUnit, final double offsetToStandardUnit)
    {
        super(conversionFactorToStandardUnit);
        this.offsetToStandardUnit = offsetToStandardUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final double toStandardUnit(final double value)
    {
        return (value + this.offsetToStandardUnit) * getConversionFactorToStandardUnit();
    }

    /** {@inheritDoc} */
    @Override
    public final double fromStandardUnit(final double value)
    {
        return (value / getConversionFactorToStandardUnit()) - this.offsetToStandardUnit;
    }

    /**
     * @return offsetToStandardUnit
     */
    public final double getOffsetToStandardUnit()
    {
        return this.offsetToStandardUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isBaseSIScale()
    {
        return getConversionFactorToStandardUnit() == 1.0 && this.offsetToStandardUnit == 0.0;
    }

}
