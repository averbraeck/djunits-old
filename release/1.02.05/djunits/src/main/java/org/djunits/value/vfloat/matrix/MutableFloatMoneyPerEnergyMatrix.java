package org.djunits.value.vfloat.matrix;

import org.djunits.unit.MoneyPerEnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerEnergy;

/**
 * Mutable FloatMoneyPerEnergyMatrix, a matrix of values with a MoneyPerEnergyUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerEnergyMatrix
    extends
    MutableTypedFloatMatrixRel<MoneyPerEnergyUnit, FloatMoneyPerEnergyMatrix, MutableFloatMoneyPerEnergyMatrix, FloatMoneyPerEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMoneyPerEnergyMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMoneyPerEnergyMatrix
     * @param unit U; the unit of the new Relative Immutable FloatMoneyPerEnergyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerEnergyMatrix(final float[][] values, final MoneyPerEnergyUnit unit,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerEnergyMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerEnergyMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerEnergyMatrix(final FloatMoneyPerEnergy[][] values, final StorageType storageType)
        throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatMoneyPerEnergyMatrix(final FloatMatrixData data, final MoneyPerEnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerEnergyMatrix instantiateType(final FloatMatrixData fmd, final MoneyPerEnergyUnit unit)
    {
        return new FloatMoneyPerEnergyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerEnergyMatrix instantiateMutableType(final FloatMatrixData fmd,
        final MoneyPerEnergyUnit unit)
    {
        return new MutableFloatMoneyPerEnergyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerEnergy get(final int row, final int column) throws ValueException
    {
        return new FloatMoneyPerEnergy(getInUnit(row, column, getUnit()), getUnit());
    }

}
