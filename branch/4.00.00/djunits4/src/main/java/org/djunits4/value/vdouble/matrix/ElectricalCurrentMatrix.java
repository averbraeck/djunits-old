package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.ElectricalCurrent;

/**
 * Immutable Double ElectricalCurrentMatrix, a matrix of values with a ElectricalCurrentUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ElectricalCurrentMatrix extends AbstractDoubleMatrixRel<ElectricalCurrentUnit, ElectricalCurrentMatrix,
        MutableElectricalCurrentMatrix, ElectricalCurrent>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ElectricalCurrentMatrix
     * @param unit U; the unit of the new Relative Immutable Double ElectricalCurrentMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ElectricalCurrentMatrix(final double[][] values, final ElectricalCurrentUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ElectricalCurrentMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            ElectricalCurrentMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ElectricalCurrentMatrix(final ElectricalCurrent[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    ElectricalCurrentMatrix(final DoubleMatrixData data, final ElectricalCurrentUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrentMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrentMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCurrentMatrix instantiateType(final DoubleMatrixData dmd, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrentMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableElectricalCurrentMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final ElectricalCurrentUnit unit)
    {
        return new MutableElectricalCurrentMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ElectricalCurrent instantiateScalar(final double value, final ElectricalCurrentUnit unit)
    {
        return new ElectricalCurrent(value, unit);
    }

}
