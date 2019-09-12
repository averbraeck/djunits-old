package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.function.DimensionlessFunctions;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.DoubleFunctionsDimensionless;
import org.djunits4.value.vdouble.scalar.Dimensionless;

/**
 * Mutable Double DimensionlessMatrix, a matrix of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableDimensionlessMatrix extends
        AbstractMutableDoubleMatrixRel<DimensionlessUnit, DimensionlessMatrix, MutableDimensionlessMatrix, Dimensionless>
        implements DimensionlessFunctions<MutableDimensionlessMatrix>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DimensionlessMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double DimensionlessMatrix
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Double DimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableDimensionlessMatrix(final double[][] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double DimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableDimensionlessMatrix(final Dimensionless[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    MutableDimensionlessMatrix(final DoubleMatrixData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final DimensionlessMatrix instantiateType(final DoubleMatrixData dmd, final DimensionlessUnit unit)
    {
        return new DimensionlessMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDimensionlessMatrix instantiateMutableType(final DoubleMatrixData dmd, final DimensionlessUnit unit)
    {
        return new MutableDimensionlessMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Dimensionless instantiateScalar(final double value, final DimensionlessUnit unit)
    {
        return new Dimensionless(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix acos()
    {
        apply(DoubleFunctionsDimensionless.ACOS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix asin()
    {
        apply(DoubleFunctionsDimensionless.ASIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix atan()
    {
        apply(DoubleFunctionsDimensionless.ATAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix cbrt()
    {
        apply(DoubleFunctionsDimensionless.CBRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix cos()
    {
        apply(DoubleFunctionsDimensionless.COS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix cosh()
    {
        apply(DoubleFunctionsDimensionless.COSH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix exp()
    {
        apply(DoubleFunctionsDimensionless.EXP);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix expm1()
    {
        apply(DoubleFunctionsDimensionless.EXPM1);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix log()
    {
        apply(DoubleFunctionsDimensionless.LOG);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix log10()
    {
        apply(DoubleFunctionsDimensionless.LOG10);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix log1p()
    {
        apply(DoubleFunctionsDimensionless.LOG1P);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix pow(final double x)
    {
        apply(DoubleFunctionsDimensionless.POW((float) x));
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix signum()
    {
        apply(DoubleFunctionsDimensionless.SIGNUM);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix sin()
    {
        apply(DoubleFunctionsDimensionless.SIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix sinh()
    {
        apply(DoubleFunctionsDimensionless.SINH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix sqrt()
    {
        apply(DoubleFunctionsDimensionless.SQRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix tan()
    {
        apply(DoubleFunctionsDimensionless.TAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix tanh()
    {
        apply(DoubleFunctionsDimensionless.TANH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessMatrix inv()
    {
        apply(DoubleFunctionsDimensionless.INV);
        return this;
    }

}
