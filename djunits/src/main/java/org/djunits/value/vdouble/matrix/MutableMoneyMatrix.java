package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Money;

/**
 * Mutable Double MoneyMatrix, a matrix of values with a MoneyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyMatrix extends AbstractMutableDoubleMatrixRel<MoneyUnit, MoneyMatrix, MutableMoneyMatrix, Money>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyMatrix
     * @param unit MoneyUnit; the unit of the new Relative Immutable Double MoneyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyMatrix(final double[][] values, final MoneyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyMatrix.
     * @param values Money[][]; the values of the entries in the new Relative Immutable Double MoneyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyMatrix(final Money[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyUnit; the unit
     */
    MutableMoneyMatrix(final DoubleMatrixData data, final MoneyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyMatrix instantiateType(final DoubleMatrixData dmd, final MoneyUnit unit)
    {
        return new MoneyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyMatrix instantiateMutableType(final DoubleMatrixData dmd, final MoneyUnit unit)
    {
        return new MutableMoneyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Money instantiateScalar(final double value, final MoneyUnit unit)
    {
        return new Money(value, unit);
    }

}
