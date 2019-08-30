package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Time;

/**
 * Mutable Time Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableTimeMatrix
        extends AbstractMutableDoubleMatrixAbs<TimeUnit, DurationUnit, TimeMatrix, DurationMatrix, MutableTimeMatrix, Time>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable Double TimeMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Mutable Double TimeMatrix
     * @param unit U; the unit of the new Absolute Mutable Double TimeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTimeMatrix(final double[][] values, final TimeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double TimeMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable Double TimeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTimeMatrix(final Time[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable Double TimeMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTimeMatrix(final DoubleMatrixData data, final TimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTimeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTimeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final TimeMatrix instantiateTypeAbs(final DoubleMatrixData dmd, final TimeUnit unit)
    {
        return new TimeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DurationMatrix instantiateTypeRel(final DoubleMatrixData dmd, final DurationUnit unit)
    {
        return new DurationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTimeMatrix instantiateMutableType(final DoubleMatrixData dmd, final TimeUnit unit)
    {
        return new MutableTimeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Time instantiateScalar(final double value, final TimeUnit unit)
    {
        return new Time(value, unit);
    }

}
