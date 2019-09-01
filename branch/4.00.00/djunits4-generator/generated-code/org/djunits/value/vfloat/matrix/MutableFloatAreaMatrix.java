package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatAreaMatrix, a matrix of values with a AreaUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatAreaMatrix extends
    AbstractMutableFloatMatrixRel<AreaUnit, FloatAreaMatrix, MutableFloatAreaMatrix, FloatArea> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAreaMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAreaMatrix
     * @param unit AreaUnit; the unit of the new Relative Immutable FloatAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAreaMatrix(final float[][] values, final AreaUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAreaMatrix.
     * @param values FloatArea[][]; the values of the entries in the new Relative Immutable Float
     *            FloatAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAreaMatrix(final FloatArea[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AreaUnit; the unit
     */
    MutableFloatAreaMatrix(final FloatMatrixData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAreaMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAreaMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAreaMatrix instantiateType(final FloatMatrixData fmd, final AreaUnit unit)
    {
        return new FloatAreaMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAreaMatrix instantiateMutableType(final FloatMatrixData fmd, final AreaUnit unit)
    {
        return new MutableFloatAreaMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatArea instantiateScalar(final float value, final AreaUnit unit)
    {
        return new FloatArea(value, unit);
    }
    


}
