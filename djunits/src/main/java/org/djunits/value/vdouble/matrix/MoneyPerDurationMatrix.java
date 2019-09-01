package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerDuration;

/**
 * Immutable Double MoneyPerDurationMatrix, a matrix of values with a MoneyPerDurationUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MoneyPerDurationMatrix extends
        AbstractDoubleMatrixRel<MoneyPerDurationUnit, MoneyPerDurationMatrix, MutableMoneyPerDurationMatrix, MoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerDurationMatrix
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Immutable Double MoneyPerDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerDurationMatrix(final double[][] values, final MoneyPerDurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerDurationMatrix.
     * @param values MoneyPerDuration[][]; the values of the entries in the new Relative Immutable Double MoneyPerDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerDurationMatrix(final MoneyPerDuration[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyPerDurationUnit; the unit
     */
    MoneyPerDurationMatrix(final DoubleMatrixData data, final MoneyPerDurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerDurationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerDurationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerDurationMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerDurationUnit unit)
    {
        return new MoneyPerDurationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerDurationMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final MoneyPerDurationUnit unit)
    {
        return new MutableMoneyPerDurationMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerDuration instantiateScalar(final double value, final MoneyPerDurationUnit unit)
    {
        return new MoneyPerDuration(value, unit);
    }

}
