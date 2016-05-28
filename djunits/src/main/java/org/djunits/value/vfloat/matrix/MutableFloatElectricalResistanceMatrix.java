package org.djunits.value.vfloat.matrix;

import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalResistance;

/**
 * Mutable FloatElectricalResistanceMatrix, a matrix of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalResistanceMatrix
        extends
        MutableTypedFloatMatrixRel<ElectricalResistanceUnit, FloatElectricalResistanceMatrix, MutableFloatElectricalResistanceMatrix, FloatElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalResistanceMatrix
     * @param unit U; the unit of the new Relative Immutable FloatElectricalResistanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalResistanceMatrix(final float[][] values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalResistanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalResistanceMatrix(final FloatElectricalResistance[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalResistanceMatrix(final FloatMatrixData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalResistanceMatrix instantiateType(final FloatMatrixData fmd,
            final ElectricalResistanceUnit unit)
    {
        return new FloatElectricalResistanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalResistanceMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalResistanceUnit unit)
    {
        return new MutableFloatElectricalResistanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance get(final int row, final int column) throws ValueException
    {
        return new FloatElectricalResistance(getInUnit(row, column, getUnit()), getUnit());
    }

}
