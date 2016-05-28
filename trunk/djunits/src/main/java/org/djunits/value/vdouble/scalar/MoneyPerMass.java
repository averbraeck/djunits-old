package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerMass DoubleScalar, which is relative by definition. Instead of:
 * 
 * <pre>
 * DoubleScalar.Rel&lt;MoneyPerMassUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerMassUnit&gt;(100.0, MoneyPerMassUnit.SI);
 * </pre>
 * 
 * we can now write:
 * 
 * <pre>
 * MoneyPerMass value = new MoneyPerMass(100.0, MoneyPerMassUnit.SI);
 * </pre>
 * 
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerMass extends TypedDoubleScalarRel<MoneyPerMassUnit, MoneyPerMass>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct MoneyPerMass scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public MoneyPerMass(final double value, final MoneyPerMassUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct MoneyPerMass scalar.
     * @param value Scalar from which to construct this instance
     */
    public MoneyPerMass(final MoneyPerMass value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerMass instantiateTypeRel(final double value, final MoneyPerMassUnit unit)
    {
        return new MoneyPerMass(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static MoneyPerMass interpolate(final MoneyPerMass zero, final MoneyPerMass one, final double ratio)
    {
        return new MoneyPerMass(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static MoneyPerMass max(final MoneyPerMass r1, final MoneyPerMass r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two monetary scalars
     */
    public static MoneyPerMass max(final MoneyPerMass r1, final MoneyPerMass r2, final MoneyPerMass... rn)
    {
        MoneyPerMass maxr = (r1.gt(r2)) ? r1 : r2;
        for (MoneyPerMass r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two monetary scalars
     */
    public static MoneyPerMass min(final MoneyPerMass r1, final MoneyPerMass r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two monetary scalars
     */
    public static MoneyPerMass min(final MoneyPerMass r1, final MoneyPerMass r2, final MoneyPerMass... rn)
    {
        MoneyPerMass minr = (r1.lt(r2)) ? r1 : r2;
        for (MoneyPerMass r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of MoneyPerMass and MoneyPerMass, which results in a Dimensionless scalar.
     * @param v MoneyPerMass scalar
     * @return Dimensionless scalar as a division of MoneyPerMass and MoneyPerMass
     */
    public final Dimensionless divideBy(final MoneyPerMass v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of MoneyPerMass and Mass, which results in a Money scalar.
     * @param v MoneyPerMass scalar
     * @return Money scalar as a multiplication of MoneyPerMass and Mass
     */
    public final Money multiplyBy(final Mass v)
    {
        return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
    }

}
