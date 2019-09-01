package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatEquivalentDoseMatrix, a matrix of values with a EquivalentDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatEquivalentDoseMatrix extends
    AbstractMutableFloatMatrixRel<EquivalentDoseUnit, FloatEquivalentDoseMatrix, MutableFloatEquivalentDoseMatrix, FloatEquivalentDose> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatEquivalentDoseMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatEquivalentDoseMatrix
     * @param unit EquivalentDoseUnit; the unit of the new Relative Immutable FloatEquivalentDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEquivalentDoseMatrix(final float[][] values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatEquivalentDoseMatrix.
     * @param values FloatEquivalentDose[][]; the values of the entries in the new Relative Immutable Float
     *            FloatEquivalentDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEquivalentDoseMatrix(final FloatEquivalentDose[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit EquivalentDoseUnit; the unit
     */
    MutableFloatEquivalentDoseMatrix(final FloatMatrixData data, final EquivalentDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatEquivalentDoseMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatEquivalentDoseMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEquivalentDoseMatrix instantiateType(final FloatMatrixData fmd, final EquivalentDoseUnit unit)
    {
        return new FloatEquivalentDoseMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatEquivalentDoseMatrix instantiateMutableType(final FloatMatrixData fmd, final EquivalentDoseUnit unit)
    {
        return new MutableFloatEquivalentDoseMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEquivalentDose instantiateScalar(final float value, final EquivalentDoseUnit unit)
    {
        return new FloatEquivalentDose(value, unit);
    }
    


}
