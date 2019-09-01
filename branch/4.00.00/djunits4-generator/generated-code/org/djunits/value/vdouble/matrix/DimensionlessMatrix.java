package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double DimensionlessMatrix, a matrix of values with a DimensionlessUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class DimensionlessMatrix extends
AbstractDoubleMatrixRel<DimensionlessUnit, DimensionlessMatrix, MutableDimensionlessMatrix, Dimensionless>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DimensionlessMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double DimensionlessMatrix
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Double DimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DimensionlessMatrix(final double[][] values, final DimensionlessUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessMatrix.
     * @param values Dimensionless[][]; the values of the entries in the new Relative Immutable Double DimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DimensionlessMatrix(final Dimensionless[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    DimensionlessMatrix(final DoubleMatrixData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final DimensionlessMatrix instantiateType(final DoubleMatrixData dmd, final DimensionlessUnit unit)
    {
        return new DimensionlessMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDimensionlessMatrix instantiateMutableType(final DoubleMatrixData dmd, final DimensionlessUnit unit)
    {
        return new MutableDimensionlessMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Dimensionless instantiateScalar(final double value, final DimensionlessUnit unit)
    {
        return new Dimensionless(value, unit);
    }


    
}
