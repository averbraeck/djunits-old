package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerArea DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyPerAreaUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerAreaUnit&gt;(100.0,
 * MoneyPerAreaUnit.SI);</i><br>
 * we can now write <br>
 * <i>MoneyPerArea value = new MoneyPerArea(100.0, MoneyPerAreaUnit.SI);</i><br>
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
public class MoneyPerArea extends TypedDoubleScalarRel<MoneyPerAreaUnit, MoneyPerArea>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerArea scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerArea(final double value, final MoneyPerAreaUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerArea scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerArea(final MoneyPerArea value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerArea instantiateTypeRel(final double value, final MoneyPerAreaUnit unit)
    {
        return new MoneyPerArea(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerArea interpolate(final MoneyPerArea zero, final MoneyPerArea one, final double ratio)
    {
        return new MoneyPerArea(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Calculate the division of MoneyPerArea and MoneyPerArea, which results in a Dimensionless scalar.
     * @param v MoneyPerArea scalar
     * @return Dimensionless scalar as a division of MoneyPerArea and MoneyPerArea
     */
    public final Dimensionless divideBy(final MoneyPerArea v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerArea and Area, which results in a Money scalar.
     * @param v MoneyPerArea scalar
     * @return Money scalar as a multiplication of MoneyPerArea and Area
     */
    public final Money multiplyBy(final Area v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
