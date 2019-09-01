package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Duration Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class DurationMatrix extends AbstractDoubleMatrixRel<DurationUnit, DurationMatrix, MutableDurationMatrix, Duration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double DurationMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double DurationMatrix
     * @param unit DurationUnit; the unit of the new Relative Immutable Double DurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DurationMatrix(final double[][] values, final DurationUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationMatrix.
     * @param values Duration[][]; the values of the entries in the new Relative Immutable Double DurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DurationMatrix(final Duration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit DurationUnit; the unit
     */
    DurationMatrix(final DoubleMatrixData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final DurationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DurationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final DurationMatrix instantiateType(final DoubleMatrixData dmd, final DurationUnit unit)
    {
        return new DurationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDurationMatrix
        instantiateMutableType(final DoubleMatrixData dmd, final DurationUnit unit)
    {
        return new MutableDurationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Duration instantiateScalar(final double value, final DurationUnit unit)
    {
        return new Duration(value, unit);
    }
        
}