package org.djunits.value.vfloat.matrix;

import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalPotential;

/**
 * Immutable FloatElectricalPotentialMatrix, a matrix of values with a ElectricalPotentialUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatElectricalPotentialMatrix extends AbstractFloatMatrixRel<ElectricalPotentialUnit,
        FloatElectricalPotentialMatrix, MutableFloatElectricalPotentialMatrix, FloatElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalPotentialMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalPotentialMatrix
     * @param unit ElectricalPotentialUnit; the unit of the new Relative Immutable FloatElectricalPotentialMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalPotentialMatrix(final float[][] values, final ElectricalPotentialUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalPotentialMatrix.
     * @param values FloatElectricalPotential[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalPotentialMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalPotentialMatrix(final FloatElectricalPotential[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalPotentialUnit; the unit
     */
    FloatElectricalPotentialMatrix(final FloatMatrixData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotentialMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalPotentialMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotentialMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotentialMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalPotentialMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalPotentialUnit unit)
    {
        return new MutableFloatElectricalPotentialMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalPotential instantiateScalar(final float value, final ElectricalPotentialUnit unit)
    {
        return new FloatElectricalPotential(value, unit);
    }

}
