package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerArea;

/**
 * Immutable Double MoneyPerAreaMatrix, a matrix of values with a MoneyPerAreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MoneyPerAreaMatrix
        extends AbstractDoubleMatrixRel<MoneyPerAreaUnit, MoneyPerAreaMatrix, MutableMoneyPerAreaMatrix, MoneyPerArea>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerAreaMatrix
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Immutable Double MoneyPerAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerAreaMatrix(final double[][] values, final MoneyPerAreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerAreaMatrix.
     * @param values MoneyPerArea[][]; the values of the entries in the new Relative Immutable Double MoneyPerAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerAreaMatrix(final MoneyPerArea[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyPerAreaUnit; the unit
     */
    MoneyPerAreaMatrix(final DoubleMatrixData data, final MoneyPerAreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerAreaMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerAreaMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerAreaMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerAreaUnit unit)
    {
        return new MoneyPerAreaMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerAreaMatrix instantiateMutableType(final DoubleMatrixData dmd, final MoneyPerAreaUnit unit)
    {
        return new MutableMoneyPerAreaMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerArea instantiateScalar(final double value, final MoneyPerAreaUnit unit)
    {
        return new MoneyPerArea(value, unit);
    }

}
