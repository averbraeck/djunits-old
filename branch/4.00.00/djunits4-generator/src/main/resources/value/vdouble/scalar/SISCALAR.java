package org.djunits4.value.vdouble.scalar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.djunits4.Throw;
import org.djunits4.unit.*;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueUtil;

/**
 * Easy access methods for the generic Relative SI DoubleScalar.
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
public class SIScalar extends AbstractDoubleScalarRel<SIUnit, SIScalar>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct SI scalar.
     * @param value double value
     * @param unit unit for the double value
     */
    public SIScalar(final double value, final SIUnit unit)
    {
        super(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value Scalar from which to construct this instance
     */
    public SIScalar(final SIScalar value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final SIScalar instantiateRel(final double value, final SIUnit unit)
    {
        return new SIScalar(value, unit);
    }

    /**
     * Construct SI scalar.
     * @param value double value in SI units
     * @param unit the unit to use for the SI scalar
     * @return the new scalar with the SI value
     */
    public static final SIScalar createSI(final double value, final SIUnit unit)
    {
        return new SIScalar(value, unit);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static SIScalar interpolate(final SIScalar zero, final SIScalar one, final double ratio)
    {
        return new SIScalar(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static SIScalar max(final SIScalar r1, final SIScalar r2)
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
    public static SIScalar max(final SIScalar r1, final SIScalar r2, final SIScalar... rn)
    {
        SIScalar maxr = (r1.gt(r2)) ? r1 : r2;
        for (SIScalar r : rn)
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
    public static SIScalar min(final SIScalar r1, final SIScalar r2)
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
    public static SIScalar min(final SIScalar r1, final SIScalar r2, final SIScalar... rn)
    {
        SIScalar minr = (r1.lt(r2)) ? r1 : r2;
        for (SIScalar r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Calculate the division of SI and SI, which results in a Dimensionless scalar.
     * @param v SI scalar
     * @return Dimensionless scalar as a division of SI and SI
     */
    public final Dimensionless divideBy(final SIScalar v)
    {
        return new Dimensionless(this.getSI() / v.getSI(), DimensionlessUnit.SI);
    }

    /**********************************************************************************/
    /******************************** 'CAST AS' METHODS *******************************/
    /**********************************************************************************/

    /**
     * Return the current scalar transformed to a scalar in the same scalar type as the example. Of course the SI dimensionality
     * has to match, otherwise the scalar cannot be transformed.
     * @param example an example object that serves as the 'template', e.g. Speed.ZERO
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(final K example)
    {
        Throw.when(!(getUnit().getBaseUnit().getSiDimensions().equals(example.getUnit().getBaseUnit().getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), example.toString());
        return example.instantiateRel(this.si, example.getUnit().getBaseUnit().getStandardUnit());
    }

    /**
     * Return the current scalar transformed to a scalar in the same scalar type as the example. Of course the SI dimensionality
     * has to match, otherwise the scalar cannot be transformed.
     * @param example an example object that serves as the 'template', e.g. Speed.ZERO
     * @param displayUnit the unit in which the value will be displayed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(final K example, final KU displayUnit)
    {
        Throw.when(!(getUnit().getBaseUnit().getSiDimensions().equals(example.getUnit().getBaseUnit().getSiDimensions())),
                UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), example.toString());
        return example.instantiateRel(ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
    }

    /**
     * Return the current scalar transformed to a scalar in the given class type. Of course the SI dimensionality has to match,
     * otherwise the scalar cannot be transformed.
     * @param returnClass the class of the
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(final Class<K> returnClass)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", double.class);
            K result = (K) createSI.invoke(returnClass, this.si);
            Throw.when(!(getUnit().getBaseUnit().getSiDimensions().equals(result.getUnit().getBaseUnit().getSiDimensions())),
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
     * @param returnClass the class of the
     * @param displayUnit the unit in which the value will be displayed
     * @return K; the scalar that has been transformed into the right scalar type and unit
     */
    @SuppressWarnings("unchecked")
    public final <KU extends Unit<KU>, K extends AbstractDoubleScalarRel<KU, K>> K as(Class<K> returnClass,
            final KU displayUnit)
    {
        try
        {
            Method createSI = returnClass.getMethod("createSI", double.class);
            K result = (K) createSI.invoke(returnClass, this.si);
            Throw.when(!(getUnit().getBaseUnit().getSiDimensions().equals(result.getUnit().getBaseUnit().getSiDimensions())),
                    UnitRuntimeException.class, "cannot cast %s to %s", this.toString(), result.toString());
            return result.instantiateRel(ValueUtil.expressAsUnit(this.si, displayUnit), displayUnit);
        }
        catch (InvocationTargetException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException exception)
        {
            throw new UnitRuntimeException(exception);
        }
    }

    %%ASMETHODS%%

}
