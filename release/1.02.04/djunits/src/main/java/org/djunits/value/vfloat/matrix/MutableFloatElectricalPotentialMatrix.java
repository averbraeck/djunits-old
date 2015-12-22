package org.djunits.value.vfloat.matrix;

import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalPotential;

/**
 * Mutable FloatElectricalPotentialMatrix, a matrix of values with a ElectricalPotentialUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalPotentialMatrix
    extends
    MutableTypedFloatMatrixRel<ElectricalPotentialUnit, FloatElectricalPotentialMatrix, MutableFloatElectricalPotentialMatrix, FloatElectricalPotential>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalPotentialMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalPotentialMatrix
     * @param unit U; the unit of the new Relative Immutable FloatElectricalPotentialMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalPotentialMatrix(final float[][] values, final ElectricalPotentialUnit unit,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalPotentialMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalPotentialMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalPotentialMatrix(final FloatElectricalPotential[][] values,
        final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalPotentialMatrix(final FloatMatrixData data, final ElectricalPotentialUnit unit)
    {
        super(data, unit);
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
    public final FloatElectricalPotential get(final int row, final int column) throws ValueException
    {
        return new FloatElectricalPotential(getInUnit(row, column, getUnit()), getUnit());
    }

}
