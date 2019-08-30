package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.CatalyticActivityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatCatalyticActivity;

/**
 * Mutable FloatCatalyticActivityMatrix, a matrix of values with a CatalyticActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatCatalyticActivityMatrix extends AbstractMutableFloatMatrixRel<CatalyticActivityUnit,
        FloatCatalyticActivityMatrix, MutableFloatCatalyticActivityMatrix, FloatCatalyticActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatCatalyticActivityMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatCatalyticActivityMatrix
     * @param unit CatalyticActivityUnit; the unit of the new Relative Immutable FloatCatalyticActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatCatalyticActivityMatrix(final float[][] values, final CatalyticActivityUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatCatalyticActivityMatrix.
     * @param values FloatCatalyticActivity[][]; the values of the entries in the new Relative Immutable Float
     *            FloatCatalyticActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatCatalyticActivityMatrix(final FloatCatalyticActivity[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit CatalyticActivityUnit; the unit
     */
    MutableFloatCatalyticActivityMatrix(final FloatMatrixData data, final CatalyticActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatCatalyticActivityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatCatalyticActivityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatCatalyticActivityMatrix instantiateType(final FloatMatrixData fmd, final CatalyticActivityUnit unit)
    {
        return new FloatCatalyticActivityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatCatalyticActivityMatrix instantiateMutableType(final FloatMatrixData fmd,
            final CatalyticActivityUnit unit)
    {
        return new MutableFloatCatalyticActivityMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatCatalyticActivity instantiateScalar(final float value, final CatalyticActivityUnit unit)
    {
        return new FloatCatalyticActivity(value, unit);
    }

}
