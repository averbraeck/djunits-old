package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerEnergy;

/**
 * Mutable Double MoneyPerEnergyMatrix, a matrix of values with a MoneyPerEnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyPerEnergyMatrix extends
        AbstractMutableDoubleMatrixRel<MoneyPerEnergyUnit, MoneyPerEnergyMatrix, MutableMoneyPerEnergyMatrix, MoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerEnergyMatrix
     * @param unit MoneyPerEnergyUnit; the unit of the new Relative Immutable Double MoneyPerEnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerEnergyMatrix(final double[][] values, final MoneyPerEnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyMatrix.
     * @param values MoneyPerEnergy[][]; the values of the entries in the new Relative Immutable Double MoneyPerEnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerEnergyMatrix(final MoneyPerEnergy[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyPerEnergyUnit; the unit
     */
    MutableMoneyPerEnergyMatrix(final DoubleMatrixData data, final MoneyPerEnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMoneyPerEnergyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerEnergyMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerEnergyUnit unit)
    {
        return new MoneyPerEnergyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerEnergyMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final MoneyPerEnergyUnit unit)
    {
        return new MutableMoneyPerEnergyMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerEnergy instantiateScalar(final double value, final MoneyPerEnergyUnit unit)
    {
        return new MoneyPerEnergy(value, unit);
    }

}
