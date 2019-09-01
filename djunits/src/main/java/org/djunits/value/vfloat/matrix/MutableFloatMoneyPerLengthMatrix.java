package org.djunits.value.vfloat.matrix;

import org.djunits.unit.MoneyPerLengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerLength;

/**
 * Mutable FloatMoneyPerLengthMatrix, a matrix of values with a MoneyPerLengthUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatMoneyPerLengthMatrix extends AbstractMutableFloatMatrixRel<MoneyPerLengthUnit,
        FloatMoneyPerLengthMatrix, MutableFloatMoneyPerLengthMatrix, FloatMoneyPerLength>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMoneyPerLengthMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMoneyPerLengthMatrix
     * @param unit MoneyPerLengthUnit; the unit of the new Relative Immutable FloatMoneyPerLengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMoneyPerLengthMatrix(final float[][] values, final MoneyPerLengthUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerLengthMatrix.
     * @param values FloatMoneyPerLength[][]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerLengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMoneyPerLengthMatrix(final FloatMoneyPerLength[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MoneyPerLengthUnit; the unit
     */
    MutableFloatMoneyPerLengthMatrix(final FloatMatrixData data, final MoneyPerLengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerLengthMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMoneyPerLengthMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerLengthMatrix instantiateType(final FloatMatrixData fmd, final MoneyPerLengthUnit unit)
    {
        return new FloatMoneyPerLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerLengthMatrix instantiateMutableType(final FloatMatrixData fmd,
            final MoneyPerLengthUnit unit)
    {
        return new MutableFloatMoneyPerLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerLength instantiateScalar(final float value, final MoneyPerLengthUnit unit)
    {
        return new FloatMoneyPerLength(value, unit);
    }

}
