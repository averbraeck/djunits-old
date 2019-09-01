package org.djunits.value.vfloat.matrix;

import org.djunits.unit.MoneyPerAreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerArea;

/**
 * Immutable FloatMoneyPerAreaMatrix, a matrix of values with a MoneyPerAreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyPerAreaMatrix extends
        AbstractFloatMatrixRel<MoneyPerAreaUnit, FloatMoneyPerAreaMatrix, MutableFloatMoneyPerAreaMatrix, FloatMoneyPerArea>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMoneyPerAreaMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMoneyPerAreaMatrix
     * @param unit MoneyPerAreaUnit; the unit of the new Relative Immutable FloatMoneyPerAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerAreaMatrix(final float[][] values, final MoneyPerAreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerAreaMatrix.
     * @param values FloatMoneyPerArea[][]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerAreaMatrix(final FloatMoneyPerArea[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MoneyPerAreaUnit; the unit
     */
    FloatMoneyPerAreaMatrix(final FloatMatrixData data, final MoneyPerAreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerAreaMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerAreaMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerAreaMatrix instantiateType(final FloatMatrixData fmd, final MoneyPerAreaUnit unit)
    {
        return new FloatMoneyPerAreaMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerAreaMatrix instantiateMutableType(final FloatMatrixData fmd,
            final MoneyPerAreaUnit unit)
    {
        return new MutableFloatMoneyPerAreaMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerArea instantiateScalar(final float value, final MoneyPerAreaUnit unit)
    {
        return new FloatMoneyPerArea(value, unit);
    }

}
