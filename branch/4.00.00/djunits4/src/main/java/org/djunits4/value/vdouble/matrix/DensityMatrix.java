package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.DensityUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Density;

/**
 * Immutable Double DensityMatrix, a matrix of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class DensityMatrix extends AbstractDoubleMatrixRel<DensityUnit, DensityMatrix, MutableDensityMatrix, Density>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DensityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double DensityMatrix
     * @param unit DensityUnit; the unit of the new Relative Immutable Double DensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public DensityMatrix(final double[][] values, final DensityUnit unit, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityMatrix.
     * @param values Density[][]; the values of the entries in the new Relative Immutable Double DensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public DensityMatrix(final Density[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit DensityUnit; the unit
     */
    DensityMatrix(final DoubleMatrixData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final DensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final DensityMatrix instantiateType(final DoubleMatrixData dmd, final DensityUnit unit)
    {
        return new DensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDensityMatrix instantiateMutableType(final DoubleMatrixData dmd, final DensityUnit unit)
    {
        return new MutableDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Density instantiateScalar(final double value, final DensityUnit unit)
    {
        return new Density(value, unit);
    }

}
