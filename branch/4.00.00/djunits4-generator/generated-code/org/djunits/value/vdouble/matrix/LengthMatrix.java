package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Length Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class LengthMatrix extends AbstractDoubleMatrixRel<LengthUnit, LengthMatrix, MutableLengthMatrix, Length>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double LengthMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double LengthMatrix
     * @param unit LengthUnit; the unit of the new Relative Immutable Double LengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public LengthMatrix(final double[][] values, final LengthUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LengthMatrix.
     * @param values Length[][]; the values of the entries in the new Relative Immutable Double LengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public LengthMatrix(final Length[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LengthMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit LengthUnit; the unit
     */
    LengthMatrix(final DoubleMatrixData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final LengthMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final LengthMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final LengthMatrix instantiateType(final DoubleMatrixData dmd, final LengthUnit unit)
    {
        return new LengthMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLengthMatrix
        instantiateMutableType(final DoubleMatrixData dmd, final LengthUnit unit)
    {
        return new MutableLengthMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Length instantiateScalar(final double value, final LengthUnit unit)
    {
        return new Length(value, unit);
    }
        
}