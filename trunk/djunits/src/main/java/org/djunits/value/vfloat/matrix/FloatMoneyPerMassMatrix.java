package org.djunits.value.vfloat.matrix;

import org.djunits.unit.MoneyPerMassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerMass;

/**
 * Immutable FloatMoneyPerMassMatrix, a matrix of values with a MoneyPerMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyPerMassMatrix extends
        AbstractFloatMatrixRel<MoneyPerMassUnit, FloatMoneyPerMassMatrix, MutableFloatMoneyPerMassMatrix, FloatMoneyPerMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMoneyPerMassMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMoneyPerMassMatrix
     * @param unit MoneyPerMassUnit; the unit of the new Relative Immutable FloatMoneyPerMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerMassMatrix(final float[][] values, final MoneyPerMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerMassMatrix.
     * @param values FloatMoneyPerMass[][]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerMassMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerMassMatrix(final FloatMoneyPerMass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MoneyPerMassUnit; the unit
     */
    FloatMoneyPerMassMatrix(final FloatMatrixData data, final MoneyPerMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerMassMatrix instantiateType(final FloatMatrixData fmd, final MoneyPerMassUnit unit)
    {
        return new FloatMoneyPerMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerMassMatrix instantiateMutableType(final FloatMatrixData fmd,
            final MoneyPerMassUnit unit)
    {
        return new MutableFloatMoneyPerMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerMass instantiateScalar(final float value, final MoneyPerMassUnit unit)
    {
        return new FloatMoneyPerMass(value, unit);
    }

}
