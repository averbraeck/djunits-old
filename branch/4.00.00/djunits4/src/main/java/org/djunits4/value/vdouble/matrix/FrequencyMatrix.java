package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.FrequencyUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Frequency;

/**
 * Immutable Double FrequencyMatrix, a matrix of values with a FrequencyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class FrequencyMatrix extends AbstractDoubleMatrixRel<FrequencyUnit, FrequencyMatrix, MutableFrequencyMatrix, Frequency>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double FrequencyMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double FrequencyMatrix
     * @param unit FrequencyUnit; the unit of the new Relative Immutable Double FrequencyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FrequencyMatrix(final double[][] values, final FrequencyUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double FrequencyMatrix.
     * @param values Frequency[][]; the values of the entries in the new Relative Immutable Double FrequencyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FrequencyMatrix(final Frequency[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit FrequencyUnit; the unit
     */
    FrequencyMatrix(final DoubleMatrixData data, final FrequencyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FrequencyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FrequencyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FrequencyMatrix instantiateType(final DoubleMatrixData dmd, final FrequencyUnit unit)
    {
        return new FrequencyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFrequencyMatrix instantiateMutableType(final DoubleMatrixData dmd, final FrequencyUnit unit)
    {
        return new MutableFrequencyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Frequency instantiateScalar(final double value, final FrequencyUnit unit)
    {
        return new Frequency(value, unit);
    }

}
