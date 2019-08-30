package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.MassUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Mass;

/**
 * Immutable Double MassMatrix, a matrix of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MassMatrix extends AbstractDoubleMatrixRel<MassUnit, MassMatrix, MutableMassMatrix, Mass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MassMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MassMatrix
     * @param unit U; the unit of the new Relative Immutable Double MassMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MassMatrix(final double[][] values, final MassUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double MassMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MassMatrix(final Mass[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MassMatrix(final DoubleMatrixData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MassMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MassMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MassMatrix instantiateType(final DoubleMatrixData dmd, final MassUnit unit)
    {
        return new MassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMassMatrix instantiateMutableType(final DoubleMatrixData dmd, final MassUnit unit)
    {
        return new MutableMassMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mass instantiateScalar(final double value, final MassUnit unit)
    {
        return new Mass(value, unit);
    }

}
