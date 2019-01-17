package org.djunits.value.vfloat.matrix;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDimensionless;

/**
 * Immutable FloatDimensionlessMatrix, a matrix of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatDimensionlessMatrix extends
        AbstractFloatMatrixRel<DimensionlessUnit, FloatDimensionlessMatrix, MutableFloatDimensionlessMatrix, FloatDimensionless>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatDimensionlessMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatDimensionlessMatrix
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable FloatDimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatDimensionlessMatrix(final float[][] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatDimensionlessMatrix.
     * @param values FloatDimensionless[][]; the values of the entries in the new Relative Immutable Float
     *            FloatDimensionlessMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatDimensionlessMatrix(final FloatDimensionless[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    FloatDimensionlessMatrix(final FloatMatrixData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatDimensionlessMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionlessMatrix instantiateType(final FloatMatrixData fmd, final DimensionlessUnit unit)
    {
        return new FloatDimensionlessMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDimensionlessMatrix instantiateMutableType(final FloatMatrixData fmd,
            final DimensionlessUnit unit)
    {
        return new MutableFloatDimensionlessMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionless instantiateScalar(final float value, final DimensionlessUnit unit)
    {
        return new FloatDimensionless(value, unit);
    }

}
