package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.MassUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatMass;

/**
 * Mutable FloatMassMatrix, a matrix of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMassMatrix
        extends AbstractMutableFloatMatrixRel<MassUnit, FloatMassMatrix, MutableFloatMassMatrix, FloatMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatMassMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatMassMatrix
     * @param unit U; the unit of the new Relative Immutable FloatMassMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMassMatrix(final float[][] values, final MassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatMassMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float FloatMassMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMassMatrix(final FloatMass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatMassMatrix(final FloatMatrixData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatMassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMassMatrix instantiateType(final FloatMatrixData fmd, final MassUnit unit)
    {
        return new FloatMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMassMatrix instantiateMutableType(final FloatMatrixData fmd, final MassUnit unit)
    {
        return new MutableFloatMassMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMass instantiateScalar(final float value, final MassUnit unit)
    {
        return new FloatMass(value, unit);
    }

}
