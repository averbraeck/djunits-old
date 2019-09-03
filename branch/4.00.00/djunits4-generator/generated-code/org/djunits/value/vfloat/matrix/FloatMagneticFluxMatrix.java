package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatMagneticFluxMatrix, a matrix of values with a MagneticFluxUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatMagneticFluxMatrix extends
    AbstractFloatMatrixRel<MagneticFluxUnit, FloatMagneticFluxMatrix, MutableFloatMagneticFluxMatrix, FloatMagneticFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMagneticFluxMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMagneticFluxMatrix
     * @param unit MagneticFluxUnit; the unit of the new Relative Immutable FloatMagneticFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatMagneticFluxMatrix(final float[][] values, final MagneticFluxUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMagneticFluxMatrix.
     * @param values FloatMagneticFlux; the values of the entries in the new Relative Immutable FloatMagneticFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatMagneticFluxMatrix(final FloatMagneticFlux[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit MagneticFluxUnit; the unit
     */
    FloatMagneticFluxMatrix(final FloatMatrixData data, final MagneticFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatMagneticFluxMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFluxMatrix instantiateType(final FloatMatrixData fmd, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFluxMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMagneticFluxMatrix instantiateMutableType(final FloatMatrixData fmd, final MagneticFluxUnit unit)
    {
        return new MutableFloatMagneticFluxMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMagneticFlux instantiateScalar(final float value, final MagneticFluxUnit unit)
    {
        return new FloatMagneticFlux(value, unit);
    }

    
}
