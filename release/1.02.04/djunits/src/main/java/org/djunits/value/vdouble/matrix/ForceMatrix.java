package org.djunits.value.vdouble.matrix;

import org.djunits.unit.ForceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Force;

/**
 * Immutable Double ForceMatrix, a matrix of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class ForceMatrix extends TypedDoubleMatrixRel<ForceUnit, ForceMatrix, MutableForceMatrix, Force>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double ForceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double ForceMatrix
     * @param unit U; the unit of the new Relative Immutable Double ForceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public ForceMatrix(final double[][] values, final ForceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double ForceMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double ForceMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public ForceMatrix(final Force[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    ForceMatrix(final DoubleMatrixData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final ForceMatrix instantiateType(final DoubleMatrixData dmd, final ForceUnit unit)
    {
        return new ForceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableForceMatrix instantiateMutableType(final DoubleMatrixData dmd, final ForceUnit unit)
    {
        return new MutableForceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Force get(final int row, final int column) throws ValueException
    {
        return new Force(getInUnit(row, column, getUnit()), getUnit());
    }

}
