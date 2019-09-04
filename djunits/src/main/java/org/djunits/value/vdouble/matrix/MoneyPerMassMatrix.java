package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerMass;

/**
 * Immutable Double MoneyPerMassMatrix, a matrix of values with a MoneyPerMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MoneyPerMassMatrix
        extends AbstractDoubleMatrixRel<MoneyPerMassUnit, MoneyPerMassMatrix, MutableMoneyPerMassMatrix, MoneyPerMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerMassMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerMassMatrix
     * @param unit MoneyPerMassUnit; the unit of the new Relative Immutable Double MoneyPerMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerMassMatrix(final double[][] values, final MoneyPerMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerMassMatrix.
     * @param values MoneyPerMass[][]; the values of the entries in the new Relative Immutable Double MoneyPerMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerMassMatrix(final MoneyPerMass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyPerMassUnit; the unit
     */
    MoneyPerMassMatrix(final DoubleMatrixData data, final MoneyPerMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerMassMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerMassUnit unit)
    {
        return new MoneyPerMassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerMassMatrix instantiateMutableType(final DoubleMatrixData dmd, final MoneyPerMassUnit unit)
    {
        return new MutableMoneyPerMassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerMass instantiateScalar(final double value, final MoneyPerMassUnit unit)
    {
        return new MoneyPerMass(value, unit);
    }

}
