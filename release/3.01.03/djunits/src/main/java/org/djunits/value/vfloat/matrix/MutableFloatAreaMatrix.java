package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatArea;

/**
 * Mutable FloatAreaMatrix, a matrix of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAreaMatrix
        extends AbstractMutableFloatMatrixRel<AreaUnit, FloatAreaMatrix, MutableFloatAreaMatrix, FloatArea>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatAreaMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatAreaMatrix
     * @param unit AreaUnit; the unit of the new Relative Immutable FloatAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAreaMatrix(final float[][] values, final AreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatAreaMatrix.
     * @param values FloatArea[][]; the values of the entries in the new Relative Immutable Float FloatAreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAreaMatrix(final FloatArea[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit AreaUnit; the unit
     */
    MutableFloatAreaMatrix(final FloatMatrixData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAreaMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAreaMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAreaMatrix instantiateType(final FloatMatrixData fmd, final AreaUnit unit)
    {
        return new FloatAreaMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAreaMatrix instantiateMutableType(final FloatMatrixData fmd, final AreaUnit unit)
    {
        return new MutableFloatAreaMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatArea instantiateScalar(final float value, final AreaUnit unit)
    {
        return new FloatArea(value, unit);
    }

}
