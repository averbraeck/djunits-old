package org.djunits.value.vdouble.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Position;

/**
 * Immutable Position Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class PositionMatrix
        extends AbstractDoubleMatrixAbs<PositionUnit, LengthUnit, PositionMatrix, LengthMatrix, MutablePositionMatrix, Position>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double LengthMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Immutable Double LengthMatrix
     * @param unit PositionUnit; the unit of the new Absolute Immutable Double LengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public PositionMatrix(final double[][] values, final PositionUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double LengthMatrix.
     * @param values Position[][]; the values of the entries in the new Absolute Immutable Double LengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public PositionMatrix(final Position[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double LengthMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit PositionUnit; the unit
     */
    PositionMatrix(final DoubleMatrixData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final PositionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final PositionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final PositionMatrix instantiateTypeAbs(final DoubleMatrixData dmd, final PositionUnit unit)
    {
        return new PositionMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LengthMatrix instantiateTypeRel(final DoubleMatrixData dmd, final LengthUnit unit)
    {
        return new LengthMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutablePositionMatrix instantiateMutableType(final DoubleMatrixData dmd, final PositionUnit unit)
    {
        return new MutablePositionMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Position instantiateScalar(final double value, final PositionUnit unit)
    {
        return new Position(value, unit);
    }

}
