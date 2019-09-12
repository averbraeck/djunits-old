package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.IlluminanceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Illuminance;

/**
 * Mutable Double IlluminanceMatrix, a matrix of values with a IlluminanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableIlluminanceMatrix
        extends AbstractMutableDoubleMatrixRel<IlluminanceUnit, IlluminanceMatrix, MutableIlluminanceMatrix, Illuminance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double IlluminanceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double IlluminanceMatrix
     * @param unit IlluminanceUnit; the unit of the new Relative Immutable Double IlluminanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableIlluminanceMatrix(final double[][] values, final IlluminanceUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double IlluminanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableIlluminanceMatrix(final Illuminance[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit IlluminanceUnit; the unit
     */
    MutableIlluminanceMatrix(final DoubleMatrixData data, final IlluminanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableIlluminanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableIlluminanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final IlluminanceMatrix instantiateType(final DoubleMatrixData dmd, final IlluminanceUnit unit)
    {
        return new IlluminanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableIlluminanceMatrix instantiateMutableType(final DoubleMatrixData dmd, final IlluminanceUnit unit)
    {
        return new MutableIlluminanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Illuminance instantiateScalar(final double value, final IlluminanceUnit unit)
    {
        return new Illuminance(value, unit);
    }

}
