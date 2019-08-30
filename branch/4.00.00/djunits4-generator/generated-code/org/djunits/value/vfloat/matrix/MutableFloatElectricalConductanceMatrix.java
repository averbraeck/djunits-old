package org.djunits4.value.vfloat.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.*;

/**
 * Mutable FloatElectricalConductanceMatrix, a matrix of values with a ElectricalConductanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalConductanceMatrix extends
    AbstractMutableFloatMatrixRel<ElectricalConductanceUnit, FloatElectricalConductanceMatrix, MutableFloatElectricalConductanceMatrix, FloatElectricalConductance> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalConductanceMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatElectricalConductanceMatrix
     * @param unit U; the unit of the new Relative Immutable FloatElectricalConductanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalConductanceMatrix(final float[][] values, final ElectricalConductanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalConductanceMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalConductanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalConductanceMatrix(final FloatElectricalConductance[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalConductanceMatrix(final FloatMatrixData data, final ElectricalConductanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalConductanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatElectricalConductanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductanceMatrix instantiateType(final FloatMatrixData fmd, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalConductanceMatrix instantiateMutableType(final FloatMatrixData fmd, final ElectricalConductanceUnit unit)
    {
        return new MutableFloatElectricalConductanceMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalConductance instantiateScalar(final float value, final ElectricalConductanceUnit unit)
    {
        return new FloatElectricalConductance(value, unit);
    }
    


}
