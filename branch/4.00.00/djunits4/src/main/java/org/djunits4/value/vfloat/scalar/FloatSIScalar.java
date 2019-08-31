package org.djunits4.value.vfloat.scalar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.Throw;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueUtil;

/**
 * Easy access methods for the Relative SI FloatScalar.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-12-22 04:32:39 +0100 (Tue, 22 Dec 2015) $, @version $Revision: 180 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatSIScalar extends AbstractFloatScalarRel<SIUnit, FloatSIScalar>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct SI scalar.
     * @param value float; float value
     * @param unit SIUnit; unit for the float value
     */
    public FloatSIScalar(final float value, final SIUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value FloatSIScalar; Scalar from which to construct this instance
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
     * @param value float; float value in SI units
     * @param unit SIUnit; the unit to use for the SI scalar
     * @return the new scalar with the SI value
     */
    public static final FloatSIScalar createSI(final float value, final SIUnit unit)
    {
        return new FloatSIScalar(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero FloatSIScalar; the low value
     * @param one FloatSIScalar; the high value
     * @param ratio float; the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static FloatSIScalar interpolate(final FloatSIScalar zero, final FloatSIScalar one, final float ratio)
    {
        return new FloatSIScalar(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 FloatSIScalar; the first scalar
     * @param r2 FloatSIScalar; the second scalar
     * @return the maximum value of two relative scalars
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
     * @return the maximum value of more than two relative scalars
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
     * @return the minimum value of two relative scalars
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
     * @return the minimum value of more than two relative scalars
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
     * @param returnClass Class&lt;K&gt;; the class of the
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
     * @param returnClass Class&lt;K&gt;; the class of the
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

    /**
     * Return the current scalar as a speed.
     * @return FloatSpeed; the current scalar as a speed
     */
    public final FloatSpeed asSpeed()
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Speed", this.toString());
        return new FloatSpeed(getSI(), SpeedUnit.SI);
    }

    /**
     * Return the current scalar as a speed, and provide a display unit.
     * @param displayUnit SpeedUnit; the unit in which the value will be displayed
     * @return FloatSpeed; the current scalar as a speed
     */
    public final FloatSpeed asSpeed(final SpeedUnit displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(SpeedUnit.BASE.getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to Speed", this.toString());
        return new FloatSpeed(getSI(), displayUnit); // do not translate -- we have the SI value right here
    }

}
