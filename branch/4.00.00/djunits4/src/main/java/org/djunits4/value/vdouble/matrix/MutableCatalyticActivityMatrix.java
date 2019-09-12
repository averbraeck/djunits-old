package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.CatalyticActivityUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.CatalyticActivity;

/**
 * Mutable Double CatalyticActivityMatrix, a matrix of values with a CatalyticActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MutableCatalyticActivityMatrix extends AbstractMutableDoubleMatrixRel<CatalyticActivityUnit,
        CatalyticActivityMatrix, MutableCatalyticActivityMatrix, CatalyticActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double CatalyticActivityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double CatalyticActivityMatrix
     * @param unit CatalyticActivityUnit; the unit of the new Relative Immutable Double CatalyticActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableCatalyticActivityMatrix(final double[][] values, final CatalyticActivityUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double CatalyticActivityMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double CatalyticActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableCatalyticActivityMatrix(final CatalyticActivity[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit CatalyticActivityUnit; the unit
     */
    MutableCatalyticActivityMatrix(final DoubleMatrixData data, final CatalyticActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableCatalyticActivityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableCatalyticActivityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final CatalyticActivityMatrix instantiateType(final DoubleMatrixData dmd, final CatalyticActivityUnit unit)
    {
        return new CatalyticActivityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableCatalyticActivityMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final CatalyticActivityUnit unit)
    {
        return new MutableCatalyticActivityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final CatalyticActivity instantiateScalar(final double value, final CatalyticActivityUnit unit)
    {
        return new CatalyticActivity(value, unit);
    }

}
