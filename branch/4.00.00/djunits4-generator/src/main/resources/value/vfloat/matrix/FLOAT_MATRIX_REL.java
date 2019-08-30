package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable Float%Type%Matrix, a matrix of values with a %Type%Unit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Float%Type%Matrix extends
    AbstractFloatMatrixRel<%Type%Unit, Float%Type%Matrix, MutableFloat%Type%Matrix, Float%Type%>
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
    public Float%Type%Matrix(final float[][] values, final %Type%Unit unit, final StorageType storageType)
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
    public Float%Type%Matrix(final Float%Type%[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    Float%Type%Matrix(final FloatMatrixData data, final %Type%Unit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Float%Type%Matrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final Float%Type%Matrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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

