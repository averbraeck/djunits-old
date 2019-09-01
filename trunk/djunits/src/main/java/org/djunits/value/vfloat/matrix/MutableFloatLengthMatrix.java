package org.djunits.value.vfloat.matrix;

import org.djunits.unit.LengthUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatLength;

/**
 * Mutable FloatLength Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableFloatLengthMatrix
        extends AbstractMutableFloatMatrixRel<LengthUnit, FloatLengthMatrix, MutableFloatLengthMatrix, FloatLength>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatLengthMatrix.
     * @param values float[][]; the values of the entries in the new Relative Mutable FloatLengthMatrix
     * @param unit LengthUnit; the unit of the new Relative Mutable FloatLengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatLengthMatrix(final float[][] values, final LengthUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatLengthMatrix.
     * @param values FloatLength[][]; the values of the entries in the new Relative Mutable FloatLengthMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatLengthMatrix(final FloatLength[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatLengthMatrix.
     * @param data FloatMatrixData; an internal data object
     * @param unit LengthUnit; the unit
     */
    MutableFloatLengthMatrix(final FloatMatrixData data, final LengthUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLengthMatrix instantiateType(final FloatMatrixData fmd, final LengthUnit unit)
    {
        return new FloatLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLengthMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatLengthMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatLengthMatrix instantiateMutableType(final FloatMatrixData fmd, final LengthUnit unit)
    {
        return new MutableFloatLengthMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatLength instantiateScalar(final float value, final LengthUnit unit)
    {
        return new FloatLength(value, unit);
    }

}
