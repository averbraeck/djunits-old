package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.LuminousIntensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatLuminousIntensity;

/**
 * Mutable FloatLuminousIntensityMatrix, a matrix of values with a LuminousIntensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatLuminousIntensityMatrix extends AbstractMutableFloatMatrixRel<LuminousIntensityUnit,
        FloatLuminousIntensityMatrix, MutableFloatLuminousIntensityMatrix, FloatLuminousIntensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLuminousIntensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLuminousIntensityMatrix
     * @param unit U; the unit of the new Relative Immutable FloatLuminousIntensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLuminousIntensityMatrix(final float[][] values, final LuminousIntensityUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLuminousIntensityMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatLuminousIntensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLuminousIntensityMatrix(final FloatLuminousIntensity[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatLuminousIntensityMatrix(final FloatMatrixData data, final LuminousIntensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLuminousIntensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLuminousIntensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousIntensityMatrix instantiateType(final FloatMatrixData fmd, final LuminousIntensityUnit unit)
    {
        return new FloatLuminousIntensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLuminousIntensityMatrix instantiateMutableType(final FloatMatrixData fmd,
            final LuminousIntensityUnit unit)
    {
        return new MutableFloatLuminousIntensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousIntensity instantiateScalar(final float value, final LuminousIntensityUnit unit)
    {
        return new FloatLuminousIntensity(value, unit);
    }

}
