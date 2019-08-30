package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatElectricalResistance;

/**
 * Immutable FloatElectricalResistanceMatrix, a matrix of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatElectricalResistanceMatrix extends AbstractFloatMatrixRel<ElectricalResistanceUnit,
        FloatElectricalResistanceMatrix, MutableFloatElectricalResistanceMatrix, FloatElectricalResistance>
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
    public FloatElectricalResistanceMatrix(final float[][] values, final ElectricalResistanceUnit unit,
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
    public FloatElectricalResistanceMatrix(final FloatElectricalResistance[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatElectricalResistanceMatrix(final FloatMatrixData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
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
    protected final FloatElectricalResistance instantiateScalar(final float value, final ElectricalResistanceUnit unit)
    {
        return new FloatElectricalResistance(value, unit);
    }

}
