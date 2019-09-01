package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatAbsorbedDoseMatrix, a matrix of values with a AbsorbedDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatAbsorbedDoseMatrix extends
    AbstractMutableFloatMatrixRel<AbsorbedDoseUnit, FloatAbsorbedDoseMatrix, MutableFloatAbsorbedDoseMatrix, FloatAbsorbedDose> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAbsorbedDoseMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAbsorbedDoseMatrix
     * @param unit AbsorbedDoseUnit; the unit of the new Relative Immutable FloatAbsorbedDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAbsorbedDoseMatrix(final float[][] values, final AbsorbedDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAbsorbedDoseMatrix.
     * @param values FloatAbsorbedDose[][]; the values of the entries in the new Relative Immutable Float
     *            FloatAbsorbedDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAbsorbedDoseMatrix(final FloatAbsorbedDose[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AbsorbedDoseUnit; the unit
     */
    MutableFloatAbsorbedDoseMatrix(final FloatMatrixData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsorbedDoseMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAbsorbedDoseMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsorbedDoseMatrix instantiateType(final FloatMatrixData fmd, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDoseMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAbsorbedDoseMatrix instantiateMutableType(final FloatMatrixData fmd, final AbsorbedDoseUnit unit)
    {
        return new MutableFloatAbsorbedDoseMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAbsorbedDose instantiateScalar(final float value, final AbsorbedDoseUnit unit)
    {
        return new FloatAbsorbedDose(value, unit);
    }
    


}
