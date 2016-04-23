package org.djunits.value.vfloat.scalar;

import org.djunits.unit.*;

/**
 * Easy access methods for the %Type% FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;%TypeUnit%&gt; value = new FloatScalar.Rel&lt;%TypeUnit%&gt;(100.0, %TypeUnit%.SI);</i><br>
 * we can now write <br>
 * <i>Float%TypeRel% value = new Float%TypeRel%(100.0, %TypeUnit%.SI);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
 * unit used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Float%TypeRel% extends TypedFloatScalarRel<%TypeUnit%, Float%TypeRel%>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /** constant with value zero. */
    public static final Float%TypeRel% ZERO = new Float%TypeRel%(0.0f, %TypeUnit%.SI);

    /**
     * Construct Float%TypeRel% scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public Float%TypeRel%(final float value, final %TypeUnit% unit)
    {
        super(value, unit);
    }

    /**
     * Construct Float%TypeRel% scalar.
     * @param value Scalar from which to construct this instance
     */
    public Float%TypeRel%(final Float%TypeRel% value)
    {
        super(value);
    }

    /**
     * Construct Float%TypeRel% scalar using a double value.
     * @param value double value
     * @param unit unit for the resulting float value
     */
    public Float%TypeRel%(final double value, final %TypeUnit% unit)
    {
        super((float) value, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%TypeRel% instantiateTypeRel(final float value, final %TypeUnit% unit)
    {
        return new Float%TypeRel%(value, unit);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    protected final Float%TypeAbs% instantiateTypeAbs(final float value, final %TypeUnit% unit)
    {
        return new Float%TypeAbs%(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Float%TypeRel% interpolate(final Float%TypeRel% zero, final Float%TypeRel% one, final float ratio)
    {
        return new Float%TypeRel%(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
            .getUnit());
    }
    
    /**
     * Relative scalar plus Absolute scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final Float%TypeAbs% plus(final Float%TypeAbs% v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
            : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
    }

    /**
     * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
     * @return an absolute version of this %typerel% scalar.
     */
    public final Float%TypeAbs% toAbs()
    {
        return new Float%TypeAbs%(getInUnit(), getUnit());
    }

%FORMULAS%%TypeRel%%
}

