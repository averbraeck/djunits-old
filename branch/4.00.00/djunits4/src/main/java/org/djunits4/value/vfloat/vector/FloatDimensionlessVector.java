package org.djunits4.value.vfloat.vector;

import javax.annotation.Generated;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.function.DimensionlessFunctions;
import org.djunits4.value.vfloat.function.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.FloatDimensionless;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable Float FloatDimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatDimensionlessVector
        extends AbstractFloatVectorRel<DimensionlessUnit, FloatDimensionless, FloatDimensionlessVector>
        implements DimensionlessFunctions<DimensionlessUnit, FloatDimensionlessVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an FloatDimensionlessVector from an internal data object.
     * @param data FloatVectorData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    public FloatDimensionlessVector(final FloatVectorData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<FloatDimensionless> getScalarClass()
    {
        return FloatDimensionless.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatDimensionlessVector instantiateVector(final FloatVectorData fvd, final DimensionlessUnit displayUnit)
    {
        return new FloatDimensionlessVector(fvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public FloatDimensionless instantiateScalarSI(final float valueSI, final DimensionlessUnit displayUnit)
    {
        FloatDimensionless result = FloatDimensionless.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector acos()
    {
        return assign(FloatMathFunctions.ACOS);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector asin()
    {
        return assign(FloatMathFunctions.ASIN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector atan()
    {
        return assign(FloatMathFunctions.ATAN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector cbrt()
    {
        return assign(FloatMathFunctions.CBRT);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector cos()
    {
        return assign(FloatMathFunctions.COS);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector cosh()
    {
        return assign(FloatMathFunctions.COSH);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector exp()
    {
        return assign(FloatMathFunctions.EXP);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector expm1()
    {
        return assign(FloatMathFunctions.EXPM1);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector log()
    {
        return assign(FloatMathFunctions.LOG);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector log10()
    {
        return assign(FloatMathFunctions.LOG10);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector log1p()
    {
        return assign(FloatMathFunctions.LOG1P);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector pow(final double x)
    {
        return assign(FloatMathFunctions.POW((float) x));
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector signum()
    {
        return assign(FloatMathFunctions.SIGNUM);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector sin()
    {
        return assign(FloatMathFunctions.SIN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector sinh()
    {
        return assign(FloatMathFunctions.SINH);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector sqrt()
    {
        return assign(FloatMathFunctions.SQRT);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector tan()
    {
        return assign(FloatMathFunctions.TAN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector tanh()
    {
        return assign(FloatMathFunctions.TANH);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessVector inv()
    {
        return assign(FloatMathFunctions.INV);
    }

}
