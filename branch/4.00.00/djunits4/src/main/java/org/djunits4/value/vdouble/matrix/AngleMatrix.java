package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.AngleUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Angle;

/**
 * Immutable Angle Matrix.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AngleMatrix extends AbstractDoubleMatrixRel<AngleUnit, AngleMatrix, MutableAngleMatrix, Angle>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double AngleMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AngleMatrix
     * @param unit AngleUnit; the unit of the new Relative Immutable Double AngleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AngleMatrix(final double[][] values, final AngleUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleMatrix.
     * @param values Angle[][]; the values of the entries in the new Relative Immutable Double AngleMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AngleMatrix(final Angle[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleMatrix.
     * @param data DoubleMatrixData; an internal data object
     * @param unit AngleUnit; the unit
     */
    AngleMatrix(final DoubleMatrixData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleMatrix instantiateType(final DoubleMatrixData dmd, final AngleUnit unit)
    {
        return new AngleMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAngleMatrix instantiateMutableType(final DoubleMatrixData dmd, final AngleUnit unit)
    {
        return new MutableAngleMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Angle instantiateScalar(final double value, final AngleUnit unit)
    {
        return new Angle(value, unit);
    }

}
