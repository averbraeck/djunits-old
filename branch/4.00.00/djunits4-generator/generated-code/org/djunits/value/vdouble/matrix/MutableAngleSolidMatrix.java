package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double AngleSolidMatrix, a matrix of values with a AngleSolidUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableAngleSolidMatrix extends
    AbstractMutableDoubleMatrixRel<AngleSolidUnit, AngleSolidMatrix, MutableAngleSolidMatrix, AngleSolid> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AngleSolidMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AngleSolidMatrix
     * @param unit AngleSolidUnit; the unit of the new Relative Immutable Double AngleSolidMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableAngleSolidMatrix(final double[][] values, final AngleSolidUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double AngleSolidMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableAngleSolidMatrix(final AngleSolid[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AngleSolidUnit; the unit
     */
    MutableAngleSolidMatrix(final DoubleMatrixData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolidMatrix instantiateType(final DoubleMatrixData dmd, final AngleSolidUnit unit)
    {
        return new AngleSolidMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAngleSolidMatrix instantiateMutableType(final DoubleMatrixData dmd, final AngleSolidUnit unit)
    {
        return new MutableAngleSolidMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolid instantiateScalar(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }
    


}
