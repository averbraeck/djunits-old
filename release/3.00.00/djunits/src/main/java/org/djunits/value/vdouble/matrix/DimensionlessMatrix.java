package org.djunits.value.vdouble.matrix;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Dimensionless;

/**
 * Immutable Double DimensionlessMatrix, a matrix of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class DimensionlessMatrix
        extends AbstractDoubleMatrixRel<DimensionlessUnit, DimensionlessMatrix, MutableDimensionlessMatrix, Dimensionless>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DimensionlessMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double DimensionlessMatrix
     * @param unit U; the unit of the new Relative Immutable Double DimensionlessMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public DimensionlessMatrix(final double[][] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            DimensionlessMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public DimensionlessMatrix(final Dimensionless[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    DimensionlessMatrix(final DoubleMatrixData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final DimensionlessMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final DimensionlessMatrix instantiateType(final DoubleMatrixData dmd, final DimensionlessUnit unit)
    {
        return new DimensionlessMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDimensionlessMatrix instantiateMutableType(final DoubleMatrixData dmd, final DimensionlessUnit unit)
    {
        return new MutableDimensionlessMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Dimensionless instantiateScalar(final double value, final DimensionlessUnit unit)
    {
        return new Dimensionless(value, unit);
    }

}