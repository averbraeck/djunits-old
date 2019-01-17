package org.djunits.value.vdouble.matrix;

import org.djunits.unit.VolumeUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Volume;

/**
 * Mutable Double VolumeMatrix, a matrix of values with a VolumeUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableVolumeMatrix extends AbstractMutableDoubleMatrixRel<VolumeUnit, VolumeMatrix, MutableVolumeMatrix, Volume>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double VolumeMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double VolumeMatrix
     * @param unit VolumeUnit; the unit of the new Relative Immutable Double VolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableVolumeMatrix(final double[][] values, final VolumeUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double VolumeMatrix.
     * @param values Volume[][]; the values of the entries in the new Relative Immutable Double VolumeMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableVolumeMatrix(final Volume[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit VolumeUnit; the unit
     */
    MutableVolumeMatrix(final DoubleMatrixData data, final VolumeUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final VolumeMatrix instantiateType(final DoubleMatrixData dmd, final VolumeUnit unit)
    {
        return new VolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableVolumeMatrix instantiateMutableType(final DoubleMatrixData dmd, final VolumeUnit unit)
    {
        return new MutableVolumeMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Volume instantiateScalar(final double value, final VolumeUnit unit)
    {
        return new Volume(value, unit);
    }

}
