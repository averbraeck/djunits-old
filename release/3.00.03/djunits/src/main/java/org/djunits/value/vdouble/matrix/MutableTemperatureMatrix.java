package org.djunits.value.vdouble.matrix;

import org.djunits.unit.TemperatureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Temperature;

/**
 * Mutable Temperature Matrix.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableTemperatureMatrix
        extends AbstractMutableDoubleMatrixRel<TemperatureUnit, TemperatureMatrix, MutableTemperatureMatrix, Temperature>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable Double TemperatureMatrix.
     * @param values double[][]; the values of the entries in the new Relative Mutable Double TemperatureMatrix
     * @param unit U; the unit of the new Relative Mutable Double TemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableTemperatureMatrix(final double[][] values, final TemperatureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable Double
     *            TemperatureMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableTemperatureMatrix(final Temperature[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable Double TemperatureMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTemperatureMatrix(final DoubleMatrixData data, final TemperatureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTemperatureMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableTemperatureMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final TemperatureMatrix instantiateType(final DoubleMatrixData dmd, final TemperatureUnit unit)
    {
        return new TemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableTemperatureMatrix instantiateMutableType(final DoubleMatrixData dmd, final TemperatureUnit unit)
    {
        return new MutableTemperatureMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Temperature instantiateScalar(final double value, final TemperatureUnit unit)
    {
        return new Temperature(value, unit);
    }

}
