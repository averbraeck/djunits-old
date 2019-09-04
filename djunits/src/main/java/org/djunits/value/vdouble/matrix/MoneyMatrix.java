package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Money;

/**
 * Immutable Double MoneyMatrix, a matrix of values with a MoneyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MoneyMatrix extends AbstractDoubleMatrixRel<MoneyUnit, MoneyMatrix, MutableMoneyMatrix, Money>
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
    public MoneyMatrix(final double[][] values, final MoneyUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyMatrix.
     * @param values Money[][]; the values of the entries in the new Relative Immutable Double MoneyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyMatrix(final Money[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyUnit; the unit
     */
    MoneyMatrix(final DoubleMatrixData data, final MoneyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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
