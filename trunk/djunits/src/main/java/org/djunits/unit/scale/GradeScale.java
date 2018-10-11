package org.djunits.unit.scale;

/**
 * A Scale for transforming a slope as a grade, where 45 degrees is 1, and 90 degrees is infinite, to radians. The formula is:
 * angle = atan(grade). The factor that is given, is the factor by which the value is multiplied to get a grade. When a scale is
 * constructed for e.g. ratio as a percentage (100% instead of 1), the conversionFactor to apply is 0.01.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 11, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class GradeScale implements Scale
{
    /** Multiply by this number to convert to the standard (e.g., SI) unit. */
    private final double conversionFactorToGrade;

    /**
     * Construct a Scale for transforming a slope as a grade, where 45 degrees is 1, and 90 degrees is infinite, to radians.
     * @param conversionFactorToGrade double; the conversion factor by which this number has to be multiplied to convert it to
     *            the standard (e.g., SI) unit.
     */
    public GradeScale(final double conversionFactorToGrade)
    {
        super();
        this.conversionFactorToGrade = conversionFactorToGrade;
    }

    /** {@inheritDoc} */
    @Override
    public final double toStandardUnit(final double value)
    {
        return Math.atan(value * this.conversionFactorToGrade);
    }

    /** {@inheritDoc} */
    @Override
    public final double fromStandardUnit(final double value)
    {
        return Math.tan(value) / this.conversionFactorToGrade;
    }

    /**
     * @return conversionFactorToGrade
     */
    public final double getConversionFactorToGrade()
    {
        return this.conversionFactorToGrade;
    }

    /** {@inheritDoc} */
    @Override
    public final boolean isBaseSIScale()
    {
        return this.conversionFactorToGrade == 1.0;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(this.conversionFactorToGrade);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GradeScale other = (GradeScale) obj;
        if (Double.doubleToLongBits(this.conversionFactorToGrade) != Double.doubleToLongBits(other.conversionFactorToGrade))
            return false;
        return true;
    }

}
