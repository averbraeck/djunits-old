package org.djunits.value.vfloat.scalar;

import org.djunits.unit.*;

/**
 * Easy access methods for the %TypeAbs% FloatScalar. Instead of:
 * <pre>FloatScalar.Abs&lt;%TypeAbsUnit%&gt; value = new FloatScalar.Abs&lt;%TypeAbsUnit%&gt;(100.0, %TypeAbsUnit%.SI);</pre>
 * we can now write:
 * <pre>Float%TypeAbs% value = new Float%TypeAbs%(100.0, %TypeAbsUnit%.SI);</pre>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Float%TypeAbs% extends AbstractFloatScalarAbs<%TypeAbsUnit%, Float%TypeAbs%, %TypeRelUnit%, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Float%TypeAbs% ZERO = new Float%TypeAbs%(0.0f, %TypeAbsUnit%.BASE);

    /**
     * Construct Float%TypeAbs% scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public Float%TypeAbs%(final float value, final %TypeAbsUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct Float%TypeAbs% scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public Float%TypeAbs%(final double value, final %TypeAbsUnit% unit)
    {
        super((float) value, unit);
    }

    /**
     * Construct Float%TypeAbs% scalar.
     * @param value Scalar from which to construct this instance
     */
    public Float%TypeAbs%(final Float%TypeAbs% value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TypeAbs% instantiateAbs(final float value, final %TypeAbsUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%TypeRel% instantiateRel(final float value, final %TypeRelUnit% unit)
    {
        return new Float%TypeRel%(value, unit);
    }

    /**
     * Construct Float%TypeAbs% scalar.
     * @param value float value in BASE units
     * @return the new scalar with the BASE value
     */
    public static final Float%TypeAbs% createSI(final float value)
    {
        return new Float%TypeAbs%(value, %TypeAbsUnit%.BASE);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Float%TypeAbs% interpolate(final Float%TypeAbs% zero, final Float%TypeAbs% one, final float ratio)
    {
        return new Float%TypeAbs%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }
    
    /**
     * Return the maximum value of two absolute scalars.
     * @param a1 the first scalar
     * @param a2 the second scalar
     * @return the maximum value of two absolute scalars
     */
    public static Float%TypeAbs% max(final Float%TypeAbs% a1, final Float%TypeAbs% a2)
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
    public static Float%TypeAbs% max(final Float%TypeAbs% a1, final Float%TypeAbs% a2, final Float%TypeAbs%... an)
    {
        Float%TypeAbs% maxa = (a1.gt(a2)) ? a1 : a2;
        for (Float%TypeAbs% a : an)
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
    public static Float%TypeAbs% min(final Float%TypeAbs% a1, final Float%TypeAbs% a2)
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
    public static Float%TypeAbs% min(final Float%TypeAbs% a1, final Float%TypeAbs% a2, final Float%TypeAbs%... an)
    {
        Float%TypeAbs% mina = (a1.lt(a2)) ? a1 : a2;
        for (Float%TypeAbs% a : an)
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

