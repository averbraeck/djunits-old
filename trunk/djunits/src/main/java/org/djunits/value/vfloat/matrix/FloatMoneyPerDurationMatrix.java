package org.djunits.value.vfloat.matrix;

import org.djunits.unit.MoneyPerDurationUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerDuration;

/**
 * Immutable FloatMoneyPerDurationMatrix, a matrix of values with a MoneyPerDurationUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyPerDurationMatrix extends AbstractFloatMatrixRel<MoneyPerDurationUnit, FloatMoneyPerDurationMatrix,
        MutableFloatMoneyPerDurationMatrix, FloatMoneyPerDuration>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMoneyPerDurationMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMoneyPerDurationMatrix
     * @param unit MoneyPerDurationUnit; the unit of the new Relative Immutable FloatMoneyPerDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerDurationMatrix(final float[][] values, final MoneyPerDurationUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerDurationMatrix.
     * @param values FloatMoneyPerDuration[][]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerDurationMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerDurationMatrix(final FloatMoneyPerDuration[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MoneyPerDurationUnit; the unit
     */
    FloatMoneyPerDurationMatrix(final FloatMatrixData data, final MoneyPerDurationUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerDurationMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerDurationMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerDurationMatrix instantiateType(final FloatMatrixData fmd, final MoneyPerDurationUnit unit)
    {
        return new FloatMoneyPerDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerDurationMatrix instantiateMutableType(final FloatMatrixData fmd,
            final MoneyPerDurationUnit unit)
    {
        return new MutableFloatMoneyPerDurationMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerDuration instantiateScalar(final float value, final MoneyPerDurationUnit unit)
    {
        return new FloatMoneyPerDuration(value, unit);
    }

}
