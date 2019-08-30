package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.ElectricalResistance;

/**
 * Immutable Double ElectricalResistanceMatrix, a matrix of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ElectricalResistanceMatrix extends AbstractDoubleMatrixRel<ElectricalResistanceUnit, ElectricalResistanceMatrix,
        MutableElectricalResistanceMatrix, ElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalResistanceMatrix
     * @param unit ElectricalResistanceUnit; the unit of the new Relative Immutable Double ElectricalResistanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalResistanceMatrix(final double[][] values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalResistanceMatrix.
     * @param values ElectricalResistance[][]; the values of the entries in the new Relative Immutable Double
     *            ElectricalResistanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalResistanceMatrix(final ElectricalResistance[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit ElectricalResistanceUnit; the unit
     */
    ElectricalResistanceMatrix(final DoubleMatrixData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalResistanceMatrix instantiateType(final DoubleMatrixData dmd, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalResistanceMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final ElectricalResistanceUnit unit)
    {
        return new MutableElectricalResistanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalResistance instantiateScalar(final double value, final ElectricalResistanceUnit unit)
    {
        return new ElectricalResistance(value, unit);
    }

}
