package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerVolume;

/**
 * Mutable Double MoneyPerVolumeMatrix, a matrix of values with a MoneyPerVolumeUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMoneyPerVolumeMatrix extends
        MutableTypedDoubleMatrixRel<MoneyPerVolumeUnit, MoneyPerVolumeMatrix, MutableMoneyPerVolumeMatrix, MoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerVolumeMatrix
     * @param unit U; the unit of the new Relative Immutable Double MoneyPerVolumeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMoneyPerVolumeMatrix(final double[][] values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            MoneyPerVolumeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMoneyPerVolumeMatrix(final MoneyPerVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableMoneyPerVolumeMatrix(final DoubleMatrixData data, final MoneyPerVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerVolumeMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerVolumeUnit unit)
    {
        return new MoneyPerVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerVolumeMatrix instantiateMutableType(final DoubleMatrixData dmd, final MoneyPerVolumeUnit unit)
    {
        return new MutableMoneyPerVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolume get(final int row, final int column) throws ValueException
    {
        return new MoneyPerVolume(getInUnit(row, column, getUnit()), getUnit());
    }

}
