package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.LuminousIntensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatLuminousIntensity;

/**
 * Immutable FloatLuminousIntensityMatrix, a matrix of values with a LuminousIntensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatLuminousIntensityMatrix extends AbstractFloatMatrixRel<LuminousIntensityUnit, FloatLuminousIntensityMatrix,
        MutableFloatLuminousIntensityMatrix, FloatLuminousIntensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLuminousIntensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLuminousIntensityMatrix
     * @param unit LuminousIntensityUnit; the unit of the new Relative Immutable FloatLuminousIntensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatLuminousIntensityMatrix(final float[][] values, final LuminousIntensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLuminousIntensityMatrix.
     * @param values FloatLuminousIntensity[][]; the values of the entries in the new Relative Immutable Float
     *            FloatLuminousIntensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatLuminousIntensityMatrix(final FloatLuminousIntensity[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LuminousIntensityUnit; the unit
     */
    FloatLuminousIntensityMatrix(final FloatMatrixData data, final LuminousIntensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLuminousIntensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatLuminousIntensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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
