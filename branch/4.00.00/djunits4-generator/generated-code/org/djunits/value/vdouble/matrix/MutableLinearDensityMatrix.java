package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double LinearDensityMatrix, a matrix of values with a LinearDensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableLinearDensityMatrix extends
    AbstractMutableDoubleMatrixRel<LinearDensityUnit, LinearDensityMatrix, MutableLinearDensityMatrix, LinearDensity> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double LinearDensityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double LinearDensityMatrix
     * @param unit LinearDensityUnit; the unit of the new Relative Immutable Double LinearDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLinearDensityMatrix(final double[][] values, final LinearDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LinearDensityMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double LinearDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLinearDensityMatrix(final LinearDensity[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit LinearDensityUnit; the unit
     */
    MutableLinearDensityMatrix(final DoubleMatrixData data, final LinearDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLinearDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final LinearDensityMatrix instantiateType(final DoubleMatrixData dmd, final LinearDensityUnit unit)
    {
        return new LinearDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLinearDensityMatrix instantiateMutableType(final DoubleMatrixData dmd, final LinearDensityUnit unit)
    {
        return new MutableLinearDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LinearDensity instantiateScalar(final double value, final LinearDensityUnit unit)
    {
        return new LinearDensity(value, unit);
    }
    


}
