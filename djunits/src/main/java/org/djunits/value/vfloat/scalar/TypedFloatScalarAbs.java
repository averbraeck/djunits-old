package org.djunits.value.vfloat.scalar;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;

/**
 * Absolute Immutable typed scalar. <br>
 * Note: Each scalar class should implement the static interpolate(zero, one, ratio).
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-04 20:47:10 +0200 (Sun, 04 Oct 2015) $, @version $Revision: 86 $, by $Author: averbraeck $, initial
 * version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <A> the absolute scalar type
 * @param <R> the relative scalar type
 */
public abstract class TypedFloatScalarAbs<U extends Unit<U>, A extends TypedFloatScalarAbs<U, A, R>, R extends TypedFloatScalarRel<U, R>>
        extends FloatScalar.Abs<U> implements Absolute
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct Abs scalar.
     * @param value float value
     * @param unit unit for the float value
     */
    public TypedFloatScalarAbs(final float value, final U unit)
    {
        super(value, unit);
    }

    /**
     * Construct Abs scalar.
     * @param value Scalar from which to construct this instance
     */
    public TypedFloatScalarAbs(final A value)
    {
        super(value);
    }

    /**
     * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return A a new absolute instance of the FloatScalar of the right type
     */
    protected abstract A instantiateTypeAbs(final float value, final U unit);

    /**
     * Construct a new Relative Immutable FloatScalar of the right type. Each extending class must implement this method.
     * @param value the float value
     * @param unit the unit
     * @return R a new relative instance of the FloatScalar of the right type
     */
    protected abstract R instantiateTypeRel(final float value, final U unit);

    /* Note: Each scalar class should implement the static interpolate(zero, one, ratio). */

    /** {@inheritDoc} */
    @Override
    public final A ceil()
    {
        return instantiateTypeAbs((float) Math.ceil(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final A floor()
    {
        return instantiateTypeAbs((float) Math.floor(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final A rint()
    {
        return instantiateTypeAbs((float) Math.rint(getInUnit()), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final A round()
    {
        return instantiateTypeAbs(Math.round(getInUnit()), getUnit());
    }

    /**
     * Absolute scalar plus Relative scalar = Absolute scalar.
     * @param v the value to add
     * @return sum of this value and v as a new object
     */
    public final A plus(final R v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit()) : instantiateTypeAbs(
                this.si + v.si, getUnit().getStandardUnit());
    }

    /**
     * Absolute scalar minus Absolute scalar = Relative scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final R minus(final A v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeRel(getInUnit() - v.getInUnit(), getUnit()) : instantiateTypeRel(
                this.si - v.si, getUnit().getStandardUnit());
    }

    /**
     * Absolute scalar minus Relative scalar = Absolute scalar.
     * @param v the value to subtract
     * @return difference of this value and v as a new object
     */
    public final A minus(final R v)
    {
        return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() - v.getInUnit(), getUnit()) : instantiateTypeAbs(
                this.si - v.si, getUnit().getStandardUnit());
    }

    /**
     * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
     * @return a relative version of this absolute length scalar.
     */
    public final R toRel()
    {
        return instantiateTypeRel(getInUnit(), getUnit());
    }

}
