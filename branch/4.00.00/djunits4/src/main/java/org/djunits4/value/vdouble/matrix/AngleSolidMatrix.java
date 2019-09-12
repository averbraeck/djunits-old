package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.AngleSolid;

/**
 * Immutable Double AngleSolidMatrix, a matrix of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class AngleSolidMatrix
        extends AbstractDoubleMatrixRel<AngleSolidUnit, AngleSolidMatrix, MutableAngleSolidMatrix, AngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AngleSolidMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AngleSolidMatrix
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Double AngleSolidMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public AngleSolidMatrix(final double[][] values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidMatrix.
     * @param values AngleSolid[][]; the values of the entries in the new Relative Immutable Double AngleSolidMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public AngleSolidMatrix(final AngleSolid[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AngleSolidUnit; the unit
     */
    AngleSolidMatrix(final DoubleMatrixData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolidMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolidMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolidMatrix instantiateType(final DoubleMatrixData dmd, final AngleSolidUnit unit)
    {
        return new AngleSolidMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAngleSolidMatrix instantiateMutableType(final DoubleMatrixData dmd, final AngleSolidUnit unit)
    {
        return new MutableAngleSolidMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolid instantiateScalar(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }

}
