package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.function.DimensionlessFunctions;
import org.djunits4.value.vfloat.function.FloatMathFunctions;
import org.djunits4.value.vfloat.matrix.base.AbstractFloatMatrixRel;
import org.djunits4.value.vfloat.matrix.data.FloatMatrixData;
import org.djunits4.value.vfloat.scalar.FloatDimensionless;
import org.djunits4.value.vfloat.vector.FloatDimensionlessVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Immutable FloatFloatDimensionlessMatrix, a matrix of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-10-01T09:41:03.599Z")
public class FloatDimensionlessMatrix extends
        AbstractFloatMatrixRel<DimensionlessUnit, FloatDimensionless, FloatDimensionlessVector, FloatDimensionlessMatrix>
        implements DimensionlessFunctions<DimensionlessUnit, FloatDimensionlessMatrix>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    public FloatDimensionlessMatrix(final FloatMatrixData data, final DimensionlessUnit unit)
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
    public Class<FloatDimensionlessVector> getVectorClass()
    {
        return FloatDimensionlessVector.class;
    }

    /** {@inheritDoc} */
    @Override
    public FloatDimensionlessMatrix instantiateMatrix(final FloatMatrixData fmd, final DimensionlessUnit displayUnit)
    {
        return new FloatDimensionlessMatrix(fmd, displayUnit);
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
    public final FloatDimensionlessMatrix acos()
    {
        return assign(FloatMathFunctions.ACOS);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix asin()
    {
        return assign(FloatMathFunctions.ASIN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix atan()
    {
        return assign(FloatMathFunctions.ATAN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix cbrt()
    {
        return assign(FloatMathFunctions.CBRT);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix cos()
    {
        return assign(FloatMathFunctions.COS);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix cosh()
    {
        return assign(FloatMathFunctions.COSH);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix exp()
    {
        return assign(FloatMathFunctions.EXP);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix expm1()
    {
        return assign(FloatMathFunctions.EXPM1);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix log()
    {
        return assign(FloatMathFunctions.LOG);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix log10()
    {
        return assign(FloatMathFunctions.LOG10);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix log1p()
    {
        return assign(FloatMathFunctions.LOG1P);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix pow(final double x)
    {
        return assign(FloatMathFunctions.POW((float) x));
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix signum()
    {
        return assign(FloatMathFunctions.SIGNUM);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix sin()
    {
        return assign(FloatMathFunctions.SIN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix sinh()
    {
        return assign(FloatMathFunctions.SINH);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix sqrt()
    {
        return assign(FloatMathFunctions.SQRT);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix tan()
    {
        return assign(FloatMathFunctions.TAN);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix tanh()
    {
        return assign(FloatMathFunctions.TANH);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix inv()
    {
        return assign(FloatMathFunctions.INV);
    }

}
