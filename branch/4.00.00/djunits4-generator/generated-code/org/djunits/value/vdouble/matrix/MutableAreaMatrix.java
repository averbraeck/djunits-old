package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double AreaMatrix, a matrix of values with a AreaUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableAreaMatrix extends
    AbstractMutableDoubleMatrixRel<AreaUnit, AreaMatrix, MutableAreaMatrix, Area> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AreaMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AreaMatrix
     * @param unit AreaUnit; the unit of the new Relative Immutable Double AreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAreaMatrix(final double[][] values, final AreaUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double AreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAreaMatrix(final Area[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AreaUnit; the unit
     */
    MutableAreaMatrix(final DoubleMatrixData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAreaMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AreaMatrix instantiateType(final DoubleMatrixData dmd, final AreaUnit unit)
    {
        return new AreaMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAreaMatrix instantiateMutableType(final DoubleMatrixData dmd, final AreaUnit unit)
    {
        return new MutableAreaMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Area instantiateScalar(final double value, final AreaUnit unit)
    {
        return new Area(value, unit);
    }
    


}
