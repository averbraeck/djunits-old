package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.MagneticFluxDensityUnit;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.MagneticFluxDensity;

/**
 * Immutable Double MagneticFluxDensityMatrix, a matrix of values with a MagneticFluxDensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-06T11:09:13.414Z")
public class MagneticFluxDensityMatrix extends AbstractDoubleMatrixRel<MagneticFluxDensityUnit, MagneticFluxDensityMatrix,
        MutableMagneticFluxDensityMatrix, MagneticFluxDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MagneticFluxDensityMatrix
     * @param unit MagneticFluxDensityUnit; the unit of the new Relative Immutable Double MagneticFluxDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values is null
     */
    public MagneticFluxDensityMatrix(final double[][] values, final MagneticFluxDensityUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityMatrix.
     * @param values MagneticFluxDensity[][]; the values of the entries in the new Relative Immutable Double
     *            MagneticFluxDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueRuntimeException when values has zero entries
     */
    public MagneticFluxDensityMatrix(final MagneticFluxDensity[][] values, final StorageType storageType) throws ValueRuntimeException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MagneticFluxDensityUnit; the unit
     */
    MagneticFluxDensityMatrix(final DoubleMatrixData data, final MagneticFluxDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MagneticFluxDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MagneticFluxDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxDensityMatrix instantiateType(final DoubleMatrixData dmd, final MagneticFluxDensityUnit unit)
    {
        return new MagneticFluxDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMagneticFluxDensityMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final MagneticFluxDensityUnit unit)
    {
        return new MutableMagneticFluxDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxDensity instantiateScalar(final double value, final MagneticFluxDensityUnit unit)
    {
        return new MagneticFluxDensity(value, unit);
    }

}
