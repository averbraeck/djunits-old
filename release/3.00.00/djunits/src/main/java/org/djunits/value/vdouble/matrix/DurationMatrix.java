package org.djunits.value.vdouble.matrix;

import org.djunits.unit.DurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Duration;

/**
 * Immutable Duration Matrix.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DurationMatrix extends AbstractDoubleMatrixRel<DurationUnit, DurationMatrix, MutableDurationMatrix, Duration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double DurationMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double DurationMatrix
     * @param unit U; the unit of the new Relative Immutable Double DurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DurationMatrix(final double[][] values, final DurationUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            DurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DurationMatrix(final Duration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DurationMatrix.
     * @param data an internal data object
     * @param unit the unit
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
    protected final MutableDurationMatrix instantiateMutableType(final DoubleMatrixData dmd, final DurationUnit unit)
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
