package org.djunits4.value.vfloat.scalar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.Throw;
import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueUtil;

/**
 * Easy access methods for the Relative SI FloatScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSIScalar extends AbstractFloatScalarRel<SIUnit, FloatSIScalar>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct SI scalar.
     * @param value float; the float value
     * @param unit unit for the float value
     */
    public FloatSIScalar(final float value, final SIUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value Scalar from which to construct this instance
     */
    public FloatSIScalar(final FloatSIScalar value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatSIScalar instantiateRel(final float value, final SIUnit unit)
    {
        return new FloatSIScalar(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value float; the float value in SI units
     * @param unit SIUnit; the unit to use for the SI scalar
     * @return FloatSIScalar; the new scalar with the SI value
     */
    public static final FloatSIScalar createSI(final float value, final SIUnit unit)
    {
        return new FloatSIScalar(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatSIScalar; the low value
     * @param one FloatSIScalar; the high value
     * @param ratio double; the ratio between 0 and 1, inclusive
     * @return FloatSIScalar; a Scalar at the ratio between
     */
    public static FloatSIScalar interpolate(final FloatSIScalar zero, final FloatSIScalar one, final float ratio)
    {
        return new FloatSIScalar(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @return FloatSIScalar; the maximum value of two relative scalars
     */
    public static FloatSIScalar max(final FloatSIScalar r1, final FloatSIScalar r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @param rn FloatSIScalar...; the other scalars
     * @return FloatSIScalar; the maximum value of more than two relative scalars
     */
    public static FloatSIScalar max(final FloatSIScalar r1, final FloatSIScalar r2, final FloatSIScalar... rn)
    {
        FloatSIScalar maxr = (r1.gt(r2)) ? r1 : r2;
        for (FloatSIScalar r : rn)
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
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @return FloatSIScalar; the minimum value of two relative scalars
     */
    public static FloatSIScalar min(final FloatSIScalar r1, final FloatSIScalar r2)
    {
        return (r1.lt(r2)) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @param rn FloatSIScalar...; the other scalars
     * @return FloatSIScalar; the minimum value of more than two relative scalars
     */
    public static FloatSIScalar min(final FloatSIScalar r1, final FloatSIScalar r2, final FloatSIScalar... rn)
    {
        FloatSIScalar minr = (r1.lt(r2)) ? r1 : r2;
        for (FloatSIScalar r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of SI and SI, which results in a FloatDimensionless scalar.
     * @param v FloatSIScalar; SI scalar
     * @return FloatDimensionless scalar as a division of SI and SI
     */
    public final FloatDimensionless divideBy(final FloatSIScalar v)
    {
        return new FloatDimensionless(this.getSI() / v.getSI(), DimensionlessUnit.SI);
    }

    /**********************************************************************************/
    /******************************** 'CAST AS' METHODS *******************************/
    /**********************************************************************************/

    /**
     * Return the current scalar transformed to a scalar in the same scalar type as the example. Of course the SI dimensionality
     * has to match, otherwise the scalar cannot be transformed.
     * @param example K; an example object that serves as the 'template', e.g. Speed.ZERO
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(final K example)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(example.getUnit().getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), example.toString());
        return example.instantiateRel(this.si, example.getUnit().getUnitBase().getStandardUnit());
    }

    /**
     * Return the current scalar transformed to a scalar in the same scalar type as the example. Of course the SI dimensionality
     * has to match, otherwise the scalar cannot be transformed.
     * @param example K; an example object that serves as the 'template', e.g. Speed.ZERO
     * @param displayUnit KU; the unit in which the value will be displayed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(final K example, final KU displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(example.getUnit().getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), example.toString());
        return example.instantiateRel((float) ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
    }

    /**
     * Return the current scalar transformed to a scalar in the given class type. Of course the SI dimensionality has to match,
     * otherwise the scalar cannot be transformed.
     * @param returnClass K; the class of the FloatScalar to be constructed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(final Class<K> returnClass)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", float.class);
            K result = (K) createSI.invoke(returnClass, this.si);
            Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(result.getUnit().getUnitBase().getSiDimensions())),
                    UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), result.toString());
            return result;
        }
        catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    /**
     * Return the current scalar transformed to a scalar in the given class type. Of course the SI dimensionality has to match,
     * otherwise the scalar cannot be transformed.
     * @param returnClass K; the class of the FloatScalar to be constructed
     * @param displayUnit KU; the unit in which the value will be displayed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractFloatScalarRel<KU, K>> K as(Class<K> returnClass, final KU displayUnit)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", float.class);
            K result = (K) createSI.invoke(returnClass, this.si);
            Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(result.getUnit().getUnitBase().getSiDimensions())),
                    UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), result.toString());
            return result.instantiateRel((float) ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
        }
        catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    %%ASMETHODS%%

}
