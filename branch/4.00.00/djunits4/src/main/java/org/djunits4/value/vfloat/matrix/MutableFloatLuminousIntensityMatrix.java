package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousIntensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatLuminousIntensity;

/**
 * Mutable FloatLuminousIntensityMatrix, a matrix of values with a LuminousIntensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.312Z")
public class MutableFloatLuminousIntensityMatrix extends AbstractMutableFloatMatrixRel<LuminousIntensityUnit,
        FloatLuminousIntensityMatrix, MutableFloatLuminousIntensityMatrix, FloatLuminousIntensity>
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
    public MutableFloatLuminousIntensityMatrix(final float[][] values, final LuminousIntensityUnit unit,
            final StorageType storageType) throws ValueException
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
    public MutableFloatLuminousIntensityMatrix(final FloatLuminousIntensity[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LuminousIntensityUnit; the unit
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
