package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Direction Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DirectionMatrix extends
        AbstractDoubleMatrixAbs<DirectionUnit, AngleUnit, DirectionMatrix, AngleMatrix, MutableDirectionMatrix, Direction>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double AngleMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Immutable Double AngleMatrix
     * @param unit U; the unit of the new Absolute Immutable Double AngleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DirectionMatrix(final double[][] values, final DirectionUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double AngleMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double AngleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DirectionMatrix(final Direction[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double AngleMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    DirectionMatrix(final DoubleMatrixData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final DirectionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DirectionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
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
    protected final MutableDirectionMatrix
        instantiateMutableType(final DoubleMatrixData dmd, final DirectionUnit unit)
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