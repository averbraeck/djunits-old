package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerVolume DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyPerVolumeUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerVolumeUnit&gt;(100.0,
 * MoneyPerVolumeUnit.SI);</i><br>
 * we can now write <br>
 * <i>MoneyPerVolume value = new MoneyPerVolume(100.0, MoneyPerVolumeUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerVolume extends TypedDoubleScalarRel<MoneyPerVolumeUnit, MoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerVolume scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerVolume(final double value, final MoneyPerVolumeUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerVolume scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerVolume(final MoneyPerVolume value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerVolume instantiateTypeRel(final double value, final MoneyPerVolumeUnit unit)
    {
        return new MoneyPerVolume(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerVolume interpolate(final MoneyPerVolume zero, final MoneyPerVolume one, final double ratio)
    {
        return new MoneyPerVolume(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
            zero.getUnit());
    }

    /**
     * Calculate the division of MoneyPerVolume and MoneyPerVolume, which results in a Dimensionless scalar.
     * @param v MoneyPerVolume scalar
     * @return Dimensionless scalar as a division of MoneyPerVolume and MoneyPerVolume
     */
    public final Dimensionless divideBy(final MoneyPerVolume v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerVolume and Volume, which results in a Money scalar.
     * @param v MoneyPerVolume scalar
     * @return Money scalar as a multiplication of MoneyPerVolume and Volume
     */
    public final Money multiplyBy(final Volume v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
