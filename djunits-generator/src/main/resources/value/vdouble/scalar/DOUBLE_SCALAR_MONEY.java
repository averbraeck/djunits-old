package org.djunits.value.vdouble.scalar;

import java.util.regex.Matcher;

import org.djunits.unit.*;

/**
 * Easy access methods for the %Type% DoubleScalar, which is relative by definition. Instead of:
 * <pre>DoubleScalar.Rel&lt;%Type%Unit&gt; value = new DoubleScalar.Rel&lt;%Type%Unit&gt;(100.0,
 * %Type%Unit.SI);</pre>
 * we can now write:
 * <pre>%Type% value = new %Type%(100.0, %Type%Unit.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-16 02:04:00 +0200 (Fri, 16 Oct 2015) $, @version $Revision: 113 $, by $Author: averbraeck $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class %Type% extends AbstractDoubleScalarRel<%Type%Unit, %Type%>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /**
     * Construct %Type% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %Type%(final double value, final %Type%Unit unit)
    {
        super(value, unit);
    }

    /**
     * Construct %Type% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %Type%(final %Type% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final %Type% instantiateRel(final double value, final %Type%Unit unit)
    {
        return new %Type%(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %Type% interpolate(final %Type% zero, final %Type% one, final double ratio)
    {
        return new %Type%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }
    
    /**
     * Return the maximum value of two monetary scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two monetary scalars
     */
    public static %Type% max(final %Type% r1, final %Type% r2)
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
    public static %Type% max(final %Type% r1, final %Type% r2, final %Type%... rn)
    {
        %Type% maxr = (r1.gt(r2)) ? r1 : r2;
        for (%Type% r : rn)
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
    public static %Type% min(final %Type% r1, final %Type% r2)
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
    public static %Type% min(final %Type% r1, final %Type% r2, final %Type%... rn)
    {
        %Type% minr = (r1.lt(r2)) ? r1 : r2;
        for (%Type% r : rn)
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

