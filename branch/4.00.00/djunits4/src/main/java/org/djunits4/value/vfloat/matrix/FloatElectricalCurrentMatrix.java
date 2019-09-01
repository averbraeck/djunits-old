package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatElectricalCurrent;

/**
 * Immutable FloatElectricalCurrentMatrix, a matrix of values with a ElectricalCurrentUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class FloatElectricalCurrentMatrix extends AbstractFloatMatrixRel<ElectricalCurrentUnit, FloatElectricalCurrentMatrix,
        MutableFloatElectricalCurrentMatrix, FloatElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalCurrentMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalCurrentMatrix
     * @param unit ElectricalCurrentUnit; the unit of the new Relative Immutable FloatElectricalCurrentMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatElectricalCurrentMatrix(final float[][] values, final ElectricalCurrentUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalCurrentMatrix.
     * @param values FloatElectricalCurrent[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalCurrentMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatElectricalCurrentMatrix(final FloatElectricalCurrent[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit ElectricalCurrentUnit; the unit
     */
    FloatElectricalCurrentMatrix(final FloatMatrixData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrentMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalCurrentMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCurrentMatrix instantiateType(final FloatMatrixData fmd, final ElectricalCurrentUnit unit)
    {
        return new FloatElectricalCurrentMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalCurrentMatrix instantiateMutableType(final FloatMatrixData fmd,
            final ElectricalCurrentUnit unit)
    {
        return new MutableFloatElectricalCurrentMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalCurrent instantiateScalar(final float value, final ElectricalCurrentUnit unit)
    {
        return new FloatElectricalCurrent(value, unit);
    }

}
