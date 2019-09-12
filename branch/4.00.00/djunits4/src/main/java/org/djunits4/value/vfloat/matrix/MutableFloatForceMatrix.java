package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.ForceUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatForce;

/**
 * Mutable FloatForceMatrix, a matrix of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatForceMatrix
        extends AbstractMutableFloatMatrixRel<ForceUnit, FloatForceMatrix, MutableFloatForceMatrix, FloatForce>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatForceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatForceMatrix
     * @param unit ForceUnit; the unit of the new Relative Immutable FloatForceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatForceMatrix(final float[][] values, final ForceUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatForceMatrix.
     * @param values FloatForce[][]; the values of the entries in the new Relative Immutable Float FloatForceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatForceMatrix(final FloatForce[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ForceUnit; the unit
     */
    MutableFloatForceMatrix(final FloatMatrixData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatForceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatForceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForceMatrix instantiateType(final FloatMatrixData fmd, final ForceUnit unit)
    {
        return new FloatForceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatForceMatrix instantiateMutableType(final FloatMatrixData fmd, final ForceUnit unit)
    {
        return new MutableFloatForceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForce instantiateScalar(final float value, final ForceUnit unit)
    {
        return new FloatForce(value, unit);
    }

}
