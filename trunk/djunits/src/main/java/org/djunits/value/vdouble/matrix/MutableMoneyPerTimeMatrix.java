package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerTimeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerTime;

/**
 * Mutable Double MoneyPerTimeMatrix, a matrix of values with a MoneyPerTimeUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyPerTimeMatrix extends
    MutableTypedDoubleMatrixRel<MoneyPerTimeUnit, MoneyPerTimeMatrix, MutableMoneyPerTimeMatrix, MoneyPerTime>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerTimeMatrix
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerTimeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerTimeMatrix(final double[][] values, final MoneyPerTimeUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerTimeMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerTimeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerTimeMatrix(final MoneyPerTime[][] values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableMoneyPerTimeMatrix(final DoubleMatrixData data, final MoneyPerTimeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerTimeMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerTimeUnit unit)
    {
        return new MoneyPerTimeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerTimeMatrix instantiateMutableType(final DoubleMatrixData dmd,
        final MoneyPerTimeUnit unit)
    {
        return new MutableMoneyPerTimeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTime get(final int row, final int column) throws ValueException
    {
        return new MoneyPerTime(getInUnit(row, column, getUnit()), getUnit());
    }

}
