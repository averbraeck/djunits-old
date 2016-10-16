package org.djunits.value.vdouble.scalar;

import org.djunits.unit.*;

/**
 * Easy access methods for the Absolute %TypeAbs% DoubleScalar. Instead of:
 * <pre>DoubleScalar.Abs&lt;%TypeUnit%&gt; value = new DoubleScalar.Abs&lt;%TypeUnit%&gt;(100.0, %TypeUnit%.SI);</pre>
 * we can now write:
 * <pre>%TypeAbs% value = new %TypeAbs%(100.0, %TypeUnit%.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class %TypeAbs% extends AbstractDoubleScalarAbs<%TypeUnit%, %TypeAbs%, %TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final %TypeAbs% ZERO = new %TypeAbs%(0.0, %TypeUnit%.SI);

    /**
     * Construct %TypeAbs% scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public %TypeAbs%(final double value, final %TypeUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct %TypeAbs% scalar.
     * @param value Scalar from which to construct this instance
     */
    public %TypeAbs%(final %TypeAbs% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeAbs% instantiateAbs(final double value, final %TypeUnit% unit)
    {
        return new %TypeAbs%(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final %TypeRel% instantiateRel(final double value, final %TypeUnit% unit)
    {
        return new %TypeRel%(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static %TypeAbs% interpolate(final %TypeAbs% zero, final %TypeAbs% one, final double ratio)
    {
        return new %TypeAbs%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }

    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static %TypeAbs% max(final %TypeAbs% a1, final %TypeAbs% a2)
    {
        return (a1.gt(a2)) ? a1 : a2;
    }

    /**
     * Return the maximum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the maximum value of more than two absolute scalars
     */
    public static %TypeAbs% max(final %TypeAbs% a1, final %TypeAbs% a2, final %TypeAbs%... an)
    {
        %TypeAbs% maxa = (a1.gt(a2)) ? a1 : a2;
        for (%TypeAbs% a : an)
        {
            if (a.gt(maxa))
            {
                maxa = a;
            }
        }
        return maxa;
    }

    /**
     * Return the minimum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the minimum value of two absolute scalars
     */
    public static %TypeAbs% min(final %TypeAbs% a1, final %TypeAbs% a2)
    {
        return (a1.lt(a2)) ? a1 : a2;
    }

    /**
     * Return the minimum value of more than two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @param an the other scalars
     * @return the minimum value of more than two absolute scalars
     */
    public static %TypeAbs% min(final %TypeAbs% a1, final %TypeAbs% a2, final %TypeAbs%... an)
    {
        %TypeAbs% mina = (a1.lt(a2)) ? a1 : a2;
        for (%TypeAbs% a : an)
        {
            if (a.lt(mina))
            {
                mina = a;
            }
        }
        return mina;
    }

%FORMULAS%%TypeAbs%%
}

