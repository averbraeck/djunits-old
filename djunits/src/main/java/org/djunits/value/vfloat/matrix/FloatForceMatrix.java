package org.djunits.value.vfloat.matrix;

import org.djunits.unit.ForceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatForce;

/**
 * Immutable FloatForceMatrix, a matrix of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatForceMatrix extends AbstractFloatMatrixRel<ForceUnit, FloatForceMatrix, MutableFloatForceMatrix, FloatForce>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatForceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatForceMatrix
     * @param unit ForceUnit; the unit of the new Relative Immutable FloatForceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatForceMatrix(final float[][] values, final ForceUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatForceMatrix.
     * @param values FloatForce[][]; the values of the entries in the new Relative Immutable Float FloatForceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatForceMatrix(final FloatForce[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ForceUnit; the unit
     */
    FloatForceMatrix(final FloatMatrixData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatForceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForceMatrix instantiateType(final FloatMatrixData fmd, final ForceUnit unit)
    {
        return new FloatForceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatForceMatrix instantiateMutableType(final FloatMatrixData fmd, final ForceUnit unit)
    {
        return new MutableFloatForceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForce instantiateScalar(final float value, final ForceUnit unit)
    {
        return new FloatForce(value, unit);
    }

}
