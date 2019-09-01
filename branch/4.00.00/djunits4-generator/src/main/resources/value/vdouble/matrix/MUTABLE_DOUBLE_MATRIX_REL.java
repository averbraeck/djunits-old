package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double %Type%Matrix, a matrix of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class Mutable%Type%Matrix extends
    AbstractMutableDoubleMatrixRel<%Type%Unit, %Type%Matrix, Mutable%Type%Matrix, %Type%> %DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double %Type%Matrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double %Type%Matrix
     * @param unit %Type%Unit; the unit of the new Relative Immutable Double %Type%Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public Mutable%Type%Matrix(final double[][] values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double %Type%Matrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double %Type%Matrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public Mutable%Type%Matrix(final %Type%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit %Type%Unit; the unit
     */
    Mutable%Type%Matrix(final DoubleMatrixData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Matrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Mutable%Type%Matrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final %Type%Matrix instantiateType(final DoubleMatrixData dmd, final %Type%Unit unit)
    {
        return new %Type%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mutable%Type%Matrix instantiateMutableType(final DoubleMatrixData dmd, final %Type%Unit unit)
    {
        return new Mutable%Type%Matrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final %Type% instantiateScalar(final double value, final %Type%Unit unit)
    {
        return new %Type%(value, unit);
    }
    

%FORMULAS%%Type%%

}

