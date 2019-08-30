package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Immutable FloatIlluminanceMatrix, a matrix of values with a IlluminanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatIlluminanceMatrix extends
    AbstractFloatMatrixRel<IlluminanceUnit, FloatIlluminanceMatrix, MutableFloatIlluminanceMatrix, FloatIlluminance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatIlluminanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatIlluminanceMatrix
     * @param unit U; the unit of the new Relative Immutable FloatIlluminanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatIlluminanceMatrix(final float[][] values, final IlluminanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatIlluminanceMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatIlluminanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatIlluminanceMatrix(final FloatIlluminance[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatIlluminanceMatrix(final FloatMatrixData data, final IlluminanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatIlluminanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatIlluminanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatIlluminanceMatrix instantiateType(final FloatMatrixData fmd, final IlluminanceUnit unit)
    {
        return new FloatIlluminanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatIlluminanceMatrix instantiateMutableType(final FloatMatrixData fmd, final IlluminanceUnit unit)
    {
        return new MutableFloatIlluminanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatIlluminance instantiateScalar(final float value, final IlluminanceUnit unit)
    {
        return new FloatIlluminance(value, unit);
    }

    
}
