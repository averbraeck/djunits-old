package org.djunits.value.vfloat.scalar;

import org.djunits.value.Relative;
import org.djunits.unit.*;

/**
 * Easy access methods for the %Type% FloatScalar, which is relative by definition. An example is Speed. Instead of:
 * <pre>FloatScalar.Rel&lt;%Type%Unit&gt; value = new FloatScalar.Rel&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</pre>
 * we can now write:
 * <pre>Float%Type% value = new Float%Type%(100.0, %Type%Unit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Float%Type% extends AbstractFloatScalarRel<%Type%Unit, Float%Type%> %DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Float%Type% ZERO = new Float%Type%(0.0f, %Type%Unit.SI);

    /** constant with value NaN. */
    @SuppressWarnings("checkstyle:constantname")
    public static final Float%Type% NaN = new Float%Type%(Float.NaN, %Type%Unit.SI);

    /** constant with value POSITIVE_INFINITY. */
    public static final Float%Type% POSITIVE_INFINITY = new Float%Type%(Float.POSITIVE_INFINITY, %Type%Unit.SI);

    /** constant with value NEGATIVE_INFINITY. */
    public static final Float%Type% NEGATIVE_INFINITY = new Float%Type%(Float.NEGATIVE_INFINITY, %Type%Unit.SI);

    /** constant with value MAX_VALUE. */
    public static final Float%Type% POS_MAXVALUE = new Float%Type%(Float.MAX_VALUE, %Type%Unit.SI);

    /** constant with value -MAX_VALUE. */
    public static final Float%Type% NEG_MAXVALUE = new Float%Type%(-Float.MAX_VALUE, %Type%Unit.SI);

    /**
     * Construct Float%Type% scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public Float%Type%(final float value, final %Type%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct Float%Type% scalar.
     * @param value Scalar from which to construct this instance
     */
    public Float%Type%(final Float%Type% value)
    {
        super(value);
    }

    /**
     * Construct Float%Type% scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public Float%Type%(final double value, final %Type%Unit unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%Type% instantiateRel(final float value, final %Type%Unit unit)
    {
        return new Float%Type%(value, unit);
    }

    /**
     * Construct Float%Type% scalar.
     * @param value float value in SI units
     * @return the new scalar with the SI value
     */
    public static final Float%Type% createSI(final float value)
    {
        return new Float%Type%(value, %Type%Unit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Float%Type% interpolate(final Float%Type% zero, final Float%Type% one, final float ratio)
    {
        return new Float%Type%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Float%Type% max(final Float%Type% r1, final Float%Type% r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Float%Type% max(final Float%Type% r1, final Float%Type% r2, final Float%Type%... rn)
    {
        Float%Type% maxr = (r1.gt(r2)) ? r1 : r2;
        for (Float%Type% r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Float%Type% min(final Float%Type% r1, final Float%Type% r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Float%Type% min(final Float%Type% r1, final Float%Type% r2, final Float%Type%... rn)
    {
        Float%Type% minr = (r1.lt(r2)) ? r1 : r2;
        for (Float%Type% r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

%FORMULAS%%Type%%
}


