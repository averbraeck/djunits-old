package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double SpeedMatrix, a matrix of values with a SpeedUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class SpeedMatrix extends
AbstractDoubleMatrixRel<SpeedUnit, SpeedMatrix, MutableSpeedMatrix, Speed>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double SpeedMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double SpeedMatrix
     * @param unit SpeedUnit; the unit of the new Relative Immutable Double SpeedMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public SpeedMatrix(final double[][] values, final SpeedUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double SpeedMatrix.
     * @param values Speed[][]; the values of the entries in the new Relative Immutable Double SpeedMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public SpeedMatrix(final Speed[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit SpeedUnit; the unit
     */
    SpeedMatrix(final DoubleMatrixData data, final SpeedUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final SpeedMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final SpeedMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final SpeedMatrix instantiateType(final DoubleMatrixData dmd, final SpeedUnit unit)
    {
        return new SpeedMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableSpeedMatrix instantiateMutableType(final DoubleMatrixData dmd, final SpeedUnit unit)
    {
        return new MutableSpeedMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Speed instantiateScalar(final double value, final SpeedUnit unit)
    {
        return new Speed(value, unit);
    }


    
}
