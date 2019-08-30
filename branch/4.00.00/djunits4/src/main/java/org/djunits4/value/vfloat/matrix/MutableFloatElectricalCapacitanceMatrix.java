package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.ElectricalCapacitanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatElectricalCapacitance;

/**
 * Mutable FloatElectricalCapacitanceMatrix, a matrix of values with a ElectricalCapacitanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalCapacitanceMatrix extends AbstractMutableFloatMatrixRel<ElectricalCapacitanceUnit,
        FloatElectricalCapacitanceMatrix, MutableFloatElectricalCapacitanceMatrix, FloatElectricalCapacitance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalCapacitanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalCapacitanceMatrix
     * @param unit U; the unit of the new Relative Immutable FloatElectricalCapacitanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalCapacitanceMatrix(final float[][] values, final ElectricalCapacitanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalCapacitanceMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalCapacitanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalCapacitanceMatrix(final FloatElectricalCapacitance[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalCapacitanceMatrix(final FloatMatrixData data, final ElectricalCapacitanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalCapacitanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalCapacitanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCapacitanceMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalCapacitanceMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalCapacitanceUnit unit)
    {
        return new MutableFloatElectricalCapacitanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCapacitance instantiateScalar(final float value, final ElectricalCapacitanceUnit unit)
    {
        return new FloatElectricalCapacitance(value, unit);
    }

}
