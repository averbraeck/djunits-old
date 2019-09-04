package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerLength;

/**
 * Mutable Double MoneyPerLengthMatrix, a matrix of values with a MoneyPerLengthUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableMoneyPerLengthMatrix extends
        AbstractMutableDoubleMatrixRel<MoneyPerLengthUnit, MoneyPerLengthMatrix, MutableMoneyPerLengthMatrix, MoneyPerLength>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerLengthMatrix
     * @param unit MoneyPerLengthUnit; the unit of the new Relative Immutable Double MoneyPerLengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerLengthMatrix(final double[][] values, final MoneyPerLengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerLengthMatrix.
     * @param values MoneyPerLength[][]; the values of the entries in the new Relative Immutable Double MoneyPerLengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerLengthMatrix(final MoneyPerLength[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyPerLengthUnit; the unit
     */
    MutableMoneyPerLengthMatrix(final DoubleMatrixData data, final MoneyPerLengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerLengthMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerLengthMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerLengthUnit unit)
    {
        return new MoneyPerLengthMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerLengthMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final MoneyPerLengthUnit unit)
    {
        return new MutableMoneyPerLengthMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerLength instantiateScalar(final double value, final MoneyPerLengthUnit unit)
    {
        return new MoneyPerLength(value, unit);
    }

}
