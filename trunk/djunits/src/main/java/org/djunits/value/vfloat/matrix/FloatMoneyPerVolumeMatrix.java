package org.djunits.value.vfloat.matrix;

import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMoneyPerVolume;

/**
 * Immutable FloatMoneyPerVolumeMatrix, a matrix of values with a MoneyPerVolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatMoneyPerVolumeMatrix extends AbstractFloatMatrixRel<MoneyPerVolumeUnit, FloatMoneyPerVolumeMatrix,
        MutableFloatMoneyPerVolumeMatrix, FloatMoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMoneyPerVolumeMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMoneyPerVolumeMatrix
     * @param unit MoneyPerVolumeUnit; the unit of the new Relative Immutable FloatMoneyPerVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMoneyPerVolumeMatrix(final float[][] values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMoneyPerVolumeMatrix.
     * @param values FloatMoneyPerVolume[][]; the values of the entries in the new Relative Immutable Float
     *            FloatMoneyPerVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMoneyPerVolumeMatrix(final FloatMoneyPerVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MoneyPerVolumeUnit; the unit
     */
    FloatMoneyPerVolumeMatrix(final FloatMatrixData data, final MoneyPerVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMoneyPerVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerVolumeMatrix instantiateType(final FloatMatrixData fmd, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMoneyPerVolumeMatrix instantiateMutableType(final FloatMatrixData fmd,
            final MoneyPerVolumeUnit unit)
    {
        return new MutableFloatMoneyPerVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMoneyPerVolume instantiateScalar(final float value, final MoneyPerVolumeUnit unit)
    {
        return new FloatMoneyPerVolume(value, unit);
    }

}
