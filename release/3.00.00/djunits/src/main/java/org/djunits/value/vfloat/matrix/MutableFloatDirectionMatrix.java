package org.djunits.value.vfloat.matrix;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DirectionUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatDirection;

/**
 * Mutable FloatDirection Matrix.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatDirectionMatrix extends AbstractMutableFloatMatrixAbs<DirectionUnit, AngleUnit, FloatDirectionMatrix,
        FloatAngleMatrix, MutableFloatDirectionMatrix, FloatDirection>
{
    /** */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new Absolute Mutable FloatDirectionMatrix.
     * @param values float[][]; the values of the entries in the new Absolute Mutable FloatDirectionMatrix
     * @param unit U; the unit of the new Absolute Mutable FloatDirectionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDirectionMatrix(final float[][] values, final DirectionUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Absolute Mutable FloatDirectionMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDirectionMatrix(final FloatDirection[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Absolute Mutable FloatDirectionMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatDirectionMatrix(final FloatMatrixData data, final DirectionUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDirectionMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDirectionMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDirectionMatrix instantiateTypeAbs(final FloatMatrixData fmd, final DirectionUnit unit)
    {
        return new FloatDirectionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleMatrix instantiateTypeRel(final FloatMatrixData fmd, final AngleUnit unit)
    {
        return new FloatAngleMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDirectionMatrix instantiateMutableType(final FloatMatrixData fmd, final DirectionUnit unit)
    {
        return new MutableFloatDirectionMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDirection instantiateScalar(final float value, final DirectionUnit unit)
    {
        return new FloatDirection(value, unit);
    }

}
