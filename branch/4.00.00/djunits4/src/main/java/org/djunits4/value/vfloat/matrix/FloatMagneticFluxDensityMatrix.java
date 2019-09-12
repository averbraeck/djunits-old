package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.MagneticFluxDensityUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatMagneticFluxDensity;

/**
 * Immutable FloatMagneticFluxDensityMatrix, a matrix of values with a MagneticFluxDensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class FloatMagneticFluxDensityMatrix extends AbstractFloatMatrixRel<MagneticFluxDensityUnit,
        FloatMagneticFluxDensityMatrix, MutableFloatMagneticFluxDensityMatrix, FloatMagneticFluxDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMagneticFluxDensityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMagneticFluxDensityMatrix
     * @param unit MagneticFluxDensityUnit; the unit of the new Relative Immutable FloatMagneticFluxDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public FloatMagneticFluxDensityMatrix(final float[][] values, final MagneticFluxDensityUnit unit,
            final StorageType storageType) throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMagneticFluxDensityMatrix.
     * @param values FloatMagneticFluxDensity; the values of the entries in the new Relative Immutable
     *            FloatMagneticFluxDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public FloatMagneticFluxDensityMatrix(final FloatMagneticFluxDensity[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MagneticFluxDensityUnit; the unit
     */
    FloatMagneticFluxDensityMatrix(final FloatMatrixData data, final MagneticFluxDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFluxDensityMatrix instantiateType(final FloatMatrixData fmd,
            final MagneticFluxDensityUnit unit)
    {
        return new FloatMagneticFluxDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMagneticFluxDensityMatrix instantiateMutableType(final FloatMatrixData fmd,
            final MagneticFluxDensityUnit unit)
    {
        return new MutableFloatMagneticFluxDensityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFluxDensity instantiateScalar(final float value, final MagneticFluxDensityUnit unit)
    {
        return new FloatMagneticFluxDensity(value, unit);
    }

}
