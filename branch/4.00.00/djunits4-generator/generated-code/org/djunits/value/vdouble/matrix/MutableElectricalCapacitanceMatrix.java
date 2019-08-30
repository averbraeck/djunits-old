package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double ElectricalCapacitanceMatrix, a matrix of values with a ElectricalCapacitanceUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableElectricalCapacitanceMatrix extends
    AbstractMutableDoubleMatrixRel<ElectricalCapacitanceUnit, ElectricalCapacitanceMatrix, MutableElectricalCapacitanceMatrix, ElectricalCapacitance> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalCapacitanceMatrix
     * @param unit U; the unit of the new Relative Immutable Double ElectricalCapacitanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableElectricalCapacitanceMatrix(final double[][] values, final ElectricalCapacitanceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCapacitanceMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            ElectricalCapacitanceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableElectricalCapacitanceMatrix(final ElectricalCapacitance[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableElectricalCapacitanceMatrix(final DoubleMatrixData data, final ElectricalCapacitanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCapacitanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCapacitanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCapacitanceMatrix instantiateType(final DoubleMatrixData dmd, final ElectricalCapacitanceUnit unit)
    {
        return new ElectricalCapacitanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalCapacitanceMatrix instantiateMutableType(final DoubleMatrixData dmd, final ElectricalCapacitanceUnit unit)
    {
        return new MutableElectricalCapacitanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCapacitance instantiateScalar(final double value, final ElectricalCapacitanceUnit unit)
    {
        return new ElectricalCapacitance(value, unit);
    }
    


}
