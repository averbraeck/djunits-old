package org.djunits.value.vfloat.matrix;

import org.djunits.unit.VolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatVolume;

/**
 * Immutable FloatVolumeMatrix, a matrix of values with a VolumeUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatVolumeMatrix
        extends AbstractFloatMatrixRel<VolumeUnit, FloatVolumeMatrix, MutableFloatVolumeMatrix, FloatVolume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatVolumeMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatVolumeMatrix
     * @param unit U; the unit of the new Relative Immutable FloatVolumeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatVolumeMatrix(final float[][] values, final VolumeUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatVolumeMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatVolumeMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatVolumeMatrix(final FloatVolume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatVolumeMatrix(final FloatMatrixData data, final VolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatVolumeMatrix instantiateType(final FloatMatrixData fmd, final VolumeUnit unit)
    {
        return new FloatVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatVolumeMatrix instantiateMutableType(final FloatMatrixData fmd, final VolumeUnit unit)
    {
        return new MutableFloatVolumeMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatVolume instantiateScalar(final float value, final VolumeUnit unit)
    {
        return new FloatVolume(value, unit);
    }

}
