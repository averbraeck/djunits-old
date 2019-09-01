package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatDimensionlessMatrix, a matrix of values with a DimensionlessUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatDimensionlessMatrix extends
    AbstractMutableFloatMatrixRel<DimensionlessUnit, FloatDimensionlessMatrix, MutableFloatDimensionlessMatrix, FloatDimensionless>  implements MathFunctionsDimensionless<MutableFloatDimensionlessMatrix>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatDimensionlessMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatDimensionlessMatrix
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable FloatDimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDimensionlessMatrix(final float[][] values, final DimensionlessUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDimensionlessMatrix.
     * @param values FloatDimensionless[][]; the values of the entries in the new Relative Immutable Float
     *            FloatDimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDimensionlessMatrix(final FloatDimensionless[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    MutableFloatDimensionlessMatrix(final FloatMatrixData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionlessMatrix instantiateType(final FloatMatrixData fmd, final DimensionlessUnit unit)
    {
        return new FloatDimensionlessMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDimensionlessMatrix instantiateMutableType(final FloatMatrixData fmd, final DimensionlessUnit unit)
    {
        return new MutableFloatDimensionlessMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionless instantiateScalar(final float value, final DimensionlessUnit unit)
    {
        return new FloatDimensionless(value, unit);
    }
    

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix acos()
    {
        assign(FloatMathFunctions.ACOS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix asin()
    {
        assign(FloatMathFunctions.ASIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix atan()
    {
        assign(FloatMathFunctions.ATAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix cbrt()
    {
        assign(FloatMathFunctions.CBRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix cos()
    {
        assign(FloatMathFunctions.COS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix cosh()
    {
        assign(FloatMathFunctions.COSH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix exp()
    {
        assign(FloatMathFunctions.EXP);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix expm1()
    {
        assign(FloatMathFunctions.EXPM1);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix log()
    {
        assign(FloatMathFunctions.LOG);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix log10()
    {
        assign(FloatMathFunctions.LOG10);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix log1p()
    {
        assign(FloatMathFunctions.LOG1P);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix pow(final double x)
    {
        assign(FloatMathFunctions.POW((float) x));
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix signum()
    {
        assign(FloatMathFunctions.SIGNUM);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix sin()
    {
        assign(FloatMathFunctions.SIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix sinh()
    {
        assign(FloatMathFunctions.SINH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix sqrt()
    {
        assign(FloatMathFunctions.SQRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix tan()
    {
        assign(FloatMathFunctions.TAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix tanh()
    {
        assign(FloatMathFunctions.TANH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessMatrix inv()
    {
        assign(FloatMathFunctions.INV);
        return this;
    }
    
   

}
