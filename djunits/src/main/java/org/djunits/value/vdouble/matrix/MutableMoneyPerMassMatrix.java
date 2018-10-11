package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerMass;

/**
 * Mutable Double MoneyPerMassMatrix, a matrix of values with a MoneyPerMassUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyPerMassMatrix
        extends AbstractMutableDoubleMatrixRel<MoneyPerMassUnit, MoneyPerMassMatrix, MutableMoneyPerMassMatrix, MoneyPerMass>
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
    public MutableMoneyPerMassMatrix(final double[][] values, final MoneyPerMassUnit unit, final StorageType storageType)
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
    public MutableMoneyPerMassMatrix(final MoneyPerMass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyPerMassUnit; the unit
     */
    MutableMoneyPerMassMatrix(final DoubleMatrixData data, final MoneyPerMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
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
