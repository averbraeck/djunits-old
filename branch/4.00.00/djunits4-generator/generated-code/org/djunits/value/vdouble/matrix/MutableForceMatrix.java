package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double ForceMatrix, a matrix of values with a ForceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableForceMatrix extends
    AbstractMutableDoubleMatrixRel<ForceUnit, ForceMatrix, MutableForceMatrix, Force> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ForceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ForceMatrix
     * @param unit ForceUnit; the unit of the new Relative Immutable Double ForceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableForceMatrix(final double[][] values, final ForceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double ForceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableForceMatrix(final Force[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ForceUnit; the unit
     */
    MutableForceMatrix(final DoubleMatrixData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ForceMatrix instantiateType(final DoubleMatrixData dmd, final ForceUnit unit)
    {
        return new ForceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableForceMatrix instantiateMutableType(final DoubleMatrixData dmd, final ForceUnit unit)
    {
        return new MutableForceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Force instantiateScalar(final double value, final ForceUnit unit)
    {
        return new Force(value, unit);
    }
    


}
