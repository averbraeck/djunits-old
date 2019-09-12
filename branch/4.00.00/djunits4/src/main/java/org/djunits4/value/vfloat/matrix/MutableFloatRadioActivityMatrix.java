package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.RadioActivityUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatRadioActivity;

/**
 * Mutable FloatRadioActivityMatrix, a matrix of values with a RadioActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatRadioActivityMatrix extends AbstractMutableFloatMatrixRel<RadioActivityUnit, FloatRadioActivityMatrix,
        MutableFloatRadioActivityMatrix, FloatRadioActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatRadioActivityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatRadioActivityMatrix
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable FloatRadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatRadioActivityMatrix(final float[][] values, final RadioActivityUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatRadioActivityMatrix.
     * @param values FloatRadioActivity[][]; the values of the entries in the new Relative Immutable Float
     *            FloatRadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatRadioActivityMatrix(final FloatRadioActivity[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit RadioActivityUnit; the unit
     */
    MutableFloatRadioActivityMatrix(final FloatMatrixData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatRadioActivityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatRadioActivityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatRadioActivityMatrix instantiateType(final FloatMatrixData fmd, final RadioActivityUnit unit)
    {
        return new FloatRadioActivityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatRadioActivityMatrix instantiateMutableType(final FloatMatrixData fmd,
            final RadioActivityUnit unit)
    {
        return new MutableFloatRadioActivityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatRadioActivity instantiateScalar(final float value, final RadioActivityUnit unit)
    {
        return new FloatRadioActivity(value, unit);
    }

}
