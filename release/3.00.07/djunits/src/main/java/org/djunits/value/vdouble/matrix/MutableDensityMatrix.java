package org.djunits.value.vdouble.matrix;

import org.djunits.unit.DensityUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Density;

/**
 * Mutable Double DensityMatrix, a matrix of values with a DensityUnit.
 * <p>
 * Copyright (c) 2013-2018 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableDensityMatrix
        extends AbstractMutableDoubleMatrixRel<DensityUnit, DensityMatrix, MutableDensityMatrix, Density>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DensityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double DensityMatrix
     * @param unit U; the unit of the new Relative Immutable Double DensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDensityMatrix(final double[][] values, final DensityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DensityMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double DensityMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDensityMatrix(final Density[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableDensityMatrix(final DoubleMatrixData data, final DensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final DensityMatrix instantiateType(final DoubleMatrixData dmd, final DensityUnit unit)
    {
        return new DensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDensityMatrix instantiateMutableType(final DoubleMatrixData dmd, final DensityUnit unit)
    {
        return new MutableDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Density instantiateScalar(final double value, final DensityUnit unit)
    {
        return new Density(value, unit);
    }

}
