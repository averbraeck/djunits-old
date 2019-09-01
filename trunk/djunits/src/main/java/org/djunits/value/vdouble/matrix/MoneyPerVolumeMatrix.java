package org.djunits.value.vdouble.matrix;

import org.djunits.unit.MoneyPerVolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.MoneyPerVolume;

/**
 * Immutable Double MoneyPerVolumeMatrix, a matrix of values with a MoneyPerVolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MoneyPerVolumeMatrix
        extends AbstractDoubleMatrixRel<MoneyPerVolumeUnit, MoneyPerVolumeMatrix, MutableMoneyPerVolumeMatrix, MoneyPerVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MoneyPerVolumeMatrix
     * @param unit MoneyPerVolumeUnit; the unit of the new Relative Immutable Double MoneyPerVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MoneyPerVolumeMatrix(final double[][] values, final MoneyPerVolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MoneyPerVolumeMatrix.
     * @param values MoneyPerVolume[][]; the values of the entries in the new Relative Immutable Double MoneyPerVolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MoneyPerVolumeMatrix(final MoneyPerVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MoneyPerVolumeUnit; the unit
     */
    MoneyPerVolumeMatrix(final DoubleMatrixData data, final MoneyPerVolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerVolumeMatrix instantiateType(final DoubleMatrixData dmd, final MoneyPerVolumeUnit unit)
    {
        return new MoneyPerVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMoneyPerVolumeMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final MoneyPerVolumeUnit unit)
    {
        return new MutableMoneyPerVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MoneyPerVolume instantiateScalar(final double value, final MoneyPerVolumeUnit unit)
    {
        return new MoneyPerVolume(value, unit);
    }

}
