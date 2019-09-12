package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.TemperatureUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.Temperature;

/**
 * Immutable Temperature Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class TemperatureMatrix
        extends AbstractDoubleMatrixRel<TemperatureUnit, TemperatureMatrix, MutableTemperatureMatrix, Temperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double TemperatureMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double TemperatureMatrix
     * @param unit TemperatureUnit; the unit of the new Relative Immutable Double TemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public TemperatureMatrix(final double[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureMatrix.
     * @param values Temperature[][]; the values of the entries in the new Relative Immutable Double TemperatureMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public TemperatureMatrix(final Temperature[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double TemperatureMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit TemperatureUnit; the unit
     */
    TemperatureMatrix(final DoubleMatrixData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final TemperatureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final TemperatureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final TemperatureMatrix instantiateType(final DoubleMatrixData dmd, final TemperatureUnit unit)
    {
        return new TemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTemperatureMatrix instantiateMutableType(final DoubleMatrixData dmd, final TemperatureUnit unit)
    {
        return new MutableTemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Temperature instantiateScalar(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

}
