package org.djunits4.value.vfloat.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.FloatLuminousFlux;

/**
 * Mutable FloatLuminousFluxMatrix, a matrix of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-05T12:36:36.406Z")
public class MutableFloatLuminousFluxMatrix extends AbstractMutableFloatMatrixRel<LuminousFluxUnit, FloatLuminousFluxMatrix,
        MutableFloatLuminousFluxMatrix, FloatLuminousFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatLuminousFluxMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatLuminousFluxMatrix
     * @param unit LuminousFluxUnit; the unit of the new Relative Immutable FloatLuminousFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MutableFloatLuminousFluxMatrix(final float[][] values, final LuminousFluxUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatLuminousFluxMatrix.
     * @param values FloatLuminousFlux[][]; the values of the entries in the new Relative Immutable Float
     *            FloatLuminousFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MutableFloatLuminousFluxMatrix(final FloatLuminousFlux[][] values, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit LuminousFluxUnit; the unit
     */
    MutableFloatLuminousFluxMatrix(final FloatMatrixData data, final LuminousFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLuminousFluxMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLuminousFluxMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousFluxMatrix instantiateType(final FloatMatrixData fmd, final LuminousFluxUnit unit)
    {
        return new FloatLuminousFluxMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLuminousFluxMatrix instantiateMutableType(final FloatMatrixData fmd,
            final LuminousFluxUnit unit)
    {
        return new MutableFloatLuminousFluxMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLuminousFlux instantiateScalar(final float value, final LuminousFluxUnit unit)
    {
        return new FloatLuminousFlux(value, unit);
    }

}
