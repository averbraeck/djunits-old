package org.djunits.value.vfloat.matrix;

import org.djunits.unit.LinearDensityUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLinearDensity;

/**
 * Mutable FloatLinearDensityMatrix, a matrix of values with a LinearDensityUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatLinearDensityMatrix extends AbstractMutableFloatMatrixRel<LinearDensityUnit, FloatLinearDensityMatrix,
        MutableFloatLinearDensityMatrix, FloatLinearDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLinearDensityMatrix
     * @param unit U; the unit of the new Relative Immutable FloatLinearDensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLinearDensityMatrix(final float[][] values, final LinearDensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLinearDensityMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatLinearDensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLinearDensityMatrix(final FloatLinearDensity[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatLinearDensityMatrix(final FloatMatrixData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLinearDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLinearDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensityMatrix instantiateType(final FloatMatrixData fmd, final LinearDensityUnit unit)
    {
        return new FloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLinearDensityMatrix instantiateMutableType(final FloatMatrixData fmd,
            final LinearDensityUnit unit)
    {
        return new MutableFloatLinearDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLinearDensity instantiateScalar(final float value, final LinearDensityUnit unit)
    {
        return new FloatLinearDensity(value, unit);
    }

}