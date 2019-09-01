package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatRadioActivityMatrix, a matrix of values with a RadioActivityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatRadioActivityMatrix extends
    AbstractFloatMatrixRel<RadioActivityUnit, FloatRadioActivityMatrix, MutableFloatRadioActivityMatrix, FloatRadioActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatRadioActivityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatRadioActivityMatrix
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable FloatRadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatRadioActivityMatrix(final float[][] values, final RadioActivityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatRadioActivityMatrix.
     * @param values FloatRadioActivity; the values of the entries in the new Relative Immutable FloatRadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatRadioActivityMatrix(final FloatRadioActivity[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit RadioActivityUnit; the unit
     */
    FloatRadioActivityMatrix(final FloatMatrixData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatRadioActivityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatRadioActivityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatRadioActivityMatrix instantiateType(final FloatMatrixData fmd, final RadioActivityUnit unit)
    {
        return new FloatRadioActivityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatRadioActivityMatrix instantiateMutableType(final FloatMatrixData fmd, final RadioActivityUnit unit)
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
