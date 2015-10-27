package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.unit.MoneyUnit;

/**
 * Easy access methods for the MoneyPerMass DoubleScalar, which is relative by definition. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyPerMassUnit&gt; value = new DoubleScalar.Rel&lt;MoneyPerMassUnit&gt;(100.0,
 * MoneyPerMassUnit.SI);</i><br>
 * we can now write <br>
 * <i>MoneyPerMass value = new MoneyPerMass(100.0, MoneyPerMassUnit.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
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
     * Calculate the division of MoneyPerMass and MoneyPerMass, which results in a Dimensionless scalar.
     * @param v MoneyPerMass scalar
     * @return Dimensionless scalar as a division of MoneyPerMass and MoneyPerMass
     */
    public final Dimensionless.Rel divideBy(final MoneyPerMass v)
    {
        return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
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
