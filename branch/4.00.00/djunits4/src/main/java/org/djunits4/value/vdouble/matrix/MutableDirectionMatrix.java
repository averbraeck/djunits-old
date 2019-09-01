package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Direction;

/**
 * Mutable Direction Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableDirectionMatrix extends AbstractMutableDoubleMatrixAbs<DirectionUnit, AngleUnit, DirectionMatrix,
        AngleMatrix, MutableDirectionMatrix, Direction>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double DirectionMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Mutable Double DirectionMatrix
     * @param unit DirectionUnit; the unit of the new Absolute Mutable Double DirectionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDirectionMatrix(final double[][] values, final DirectionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionMatrix.
     * @param values Direction[][]; the values of the entries in the new Absolute Mutable Double DirectionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDirectionMatrix(final Direction[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double DirectionMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit DirectionUnit; the unit
     */
    MutableDirectionMatrix(final DoubleMatrixData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDirectionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDirectionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final DirectionMatrix instantiateTypeAbs(final DoubleMatrixData dmd, final DirectionUnit unit)
    {
        return new DirectionMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleMatrix instantiateTypeRel(final DoubleMatrixData dmd, final AngleUnit unit)
    {
        return new AngleMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDirectionMatrix instantiateMutableType(final DoubleMatrixData dmd, final DirectionUnit unit)
    {
        return new MutableDirectionMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Direction instantiateScalar(final double value, final DirectionUnit unit)
    {
        return new Direction(value, unit);
    }

}
