package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatAmountOfSubstanceMatrix, a matrix of values with a AmountOfSubstanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatAmountOfSubstanceMatrix extends
    AbstractFloatMatrixRel<AmountOfSubstanceUnit, FloatAmountOfSubstanceMatrix, MutableFloatAmountOfSubstanceMatrix, FloatAmountOfSubstance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAmountOfSubstanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAmountOfSubstanceMatrix
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable FloatAmountOfSubstanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatAmountOfSubstanceMatrix(final float[][] values, final AmountOfSubstanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAmountOfSubstanceMatrix.
     * @param values FloatAmountOfSubstance; the values of the entries in the new Relative Immutable FloatAmountOfSubstanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatAmountOfSubstanceMatrix(final FloatAmountOfSubstance[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AmountOfSubstanceUnit; the unit
     */
    FloatAmountOfSubstanceMatrix(final FloatMatrixData data, final AmountOfSubstanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAmountOfSubstanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatAmountOfSubstanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAmountOfSubstanceMatrix instantiateType(final FloatMatrixData fmd, final AmountOfSubstanceUnit unit)
    {
        return new FloatAmountOfSubstanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAmountOfSubstanceMatrix instantiateMutableType(final FloatMatrixData fmd, final AmountOfSubstanceUnit unit)
    {
        return new MutableFloatAmountOfSubstanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAmountOfSubstance instantiateScalar(final float value, final AmountOfSubstanceUnit unit)
    {
        return new FloatAmountOfSubstance(value, unit);
    }

    
}
