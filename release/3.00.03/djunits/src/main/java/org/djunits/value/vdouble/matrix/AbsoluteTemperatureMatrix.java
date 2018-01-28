package org.djunits.value.vdouble.matrix;

import org.djunits.unit.AbsoluteTemperatureUnit;
import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AbsoluteTemperature;

/**
 * Immutable AbsoluteTemperature Matrix.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AbsoluteTemperatureMatrix extends AbstractDoubleMatrixAbs<AbsoluteTemperatureUnit, TemperatureUnit,
        AbsoluteTemperatureMatrix, TemperatureMatrix, MutableAbsoluteTemperatureMatrix, AbsoluteTemperature>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Immutable Double TemperatureMatrix.
     * @param values double[][]; the values of the entries in the new Absolute Immutable Double TemperatureMatrix
     * @param unit U; the unit of the new Absolute Immutable Double TemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AbsoluteTemperatureMatrix(final double[][] values, final AbsoluteTemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TemperatureMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Immutable Double
     *            TemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AbsoluteTemperatureMatrix(final AbsoluteTemperature[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Immutable Double TemperatureMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    AbsoluteTemperatureMatrix(final DoubleMatrixData data, final AbsoluteTemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsoluteTemperatureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateTypeAbs(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AbsoluteTemperatureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateTypeAbs(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsoluteTemperatureMatrix instantiateTypeAbs(final DoubleMatrixData dmd, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final TemperatureMatrix instantiateTypeRel(final DoubleMatrixData dmd, final TemperatureUnit unit)
    {
        return new TemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAbsoluteTemperatureMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final AbsoluteTemperatureUnit unit)
    {
        return new MutableAbsoluteTemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsoluteTemperature instantiateScalar(final double value, final AbsoluteTemperatureUnit unit)
    {
        return new AbsoluteTemperature(value, unit);
    }

}
