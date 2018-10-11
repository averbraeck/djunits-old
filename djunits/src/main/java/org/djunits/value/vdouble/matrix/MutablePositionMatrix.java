package org.djunits.value.vdouble.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.PositionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Position;

/**
 * Mutable Position Matrix.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutablePositionMatrix extends
        AbstractMutableDoubleMatrixAbs<PositionUnit, LengthUnit, PositionMatrix, LengthMatrix, MutablePositionMatrix, Position>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double PositionMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Mutable Double PositionMatrix
     * @param unit PositionUnit; the unit of the new Absolute Mutable Double PositionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePositionMatrix(final double[][] values, final PositionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionMatrix.
     * @param values Position[][]; the values of the entries in the new Absolute Mutable Double PositionMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePositionMatrix(final Position[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double PositionMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit PositionUnit; the unit
     */
    MutablePositionMatrix(final DoubleMatrixData data, final PositionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePositionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePositionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
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
