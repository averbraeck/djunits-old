package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerEnergy;

/**
 * Immutable Double MoneyPerEnergyMatrix, a matrix of values with a MoneyPerEnergyUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MoneyPerEnergyMatrix extends
    TypedDoubleMatrixRel<MoneyPerEnergyUnit, MoneyPerEnergyMatrix, MutableMoneyPerEnergyMatrix, MoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerEnergyMatrix
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerEnergyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerEnergyMatrix(final double[][] values, final MoneyPerEnergyUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerEnergyMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerEnergyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerEnergyMatrix(final MoneyPerEnergy[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MoneyPerEnergyMatrix(final DoubleMatrixData data, final MoneyPerEnergyUnit unit)
    {
        super(data, unit);
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
    public final MoneyPerEnergy get(final int row, final int column) throws ValueException
    {
        return new MoneyPerEnergy(getInUnit(row, column, getUnit()), getUnit());
    }

}
