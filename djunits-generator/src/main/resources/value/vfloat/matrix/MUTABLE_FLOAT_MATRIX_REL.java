package org.djunits.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.*;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.*;

/**
 * Mutable Float%Type%Matrix, a matrix of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>

 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloat%Type%Matrix extends
    AbstractMutableFloatMatrixRel<%Type%Unit, Float%Type%Matrix, MutableFloat%Type%Matrix, Float%Type%> %DIMLESS%
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float%Type%Matrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable Float%Type%Matrix
     * @param unit U; the unit of the new Relative Immutable Float%Type%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloat%Type%Matrix(final float[][] values, final %Type%Unit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float%Type%Matrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            Float%Type%Matrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloat%Type%Matrix(final Float%Type%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloat%Type%Matrix(final FloatMatrixData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Matrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloat%Type%Matrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%Type%Matrix instantiateType(final FloatMatrixData fmd, final %Type%Unit unit)
    {
        return new Float%Type%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloat%Type%Matrix instantiateMutableType(final FloatMatrixData fmd, final %Type%Unit unit)
    {
        return new MutableFloat%Type%Matrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Float%Type% instantiateScalar(final float value, final %Type%Unit unit)
    {
        return new Float%Type%(value, unit);
    }
    

%FORMULAS%%Type%%

}

