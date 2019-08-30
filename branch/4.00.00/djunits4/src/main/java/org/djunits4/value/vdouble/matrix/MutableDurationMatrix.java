package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.DurationUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Duration;

/**
 * Mutable Duration Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableDurationMatrix
        extends AbstractMutableDoubleMatrixRel<DurationUnit, DurationMatrix, MutableDurationMatrix, Duration>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Double DurationMatrix.
     * @param values double[][]; the values of the entries in the new Relative Mutable Double DurationMatrix
     * @param unit U; the unit of the new Relative Mutable Double DurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDurationMatrix(final double[][] values, final DurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable Double DurationMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDurationMatrix(final Duration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double DurationMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableDurationMatrix(final DoubleMatrixData data, final DurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDurationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDurationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
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
