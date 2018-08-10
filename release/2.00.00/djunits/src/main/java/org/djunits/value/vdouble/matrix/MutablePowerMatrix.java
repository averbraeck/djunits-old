package org.djunits.value.vdouble.matrix;

import org.djunits.unit.PowerUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Power;

/**
 * Mutable Double PowerMatrix, a matrix of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutablePowerMatrix extends AbstractMutableDoubleMatrixRel<PowerUnit, PowerMatrix, MutablePowerMatrix, Power>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double PowerMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double PowerMatrix
     * @param unit U; the unit of the new Relative Immutable Double PowerMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePowerMatrix(final double[][] values, final PowerUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PowerMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double PowerMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePowerMatrix(final Power[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutablePowerMatrix(final DoubleMatrixData data, final PowerUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePowerMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final PowerMatrix instantiateType(final DoubleMatrixData dmd, final PowerUnit unit)
    {
        return new PowerMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutablePowerMatrix instantiateMutableType(final DoubleMatrixData dmd, final PowerUnit unit)
    {
        return new MutablePowerMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Power instantiateScalar(final double value, final PowerUnit unit)
    {
        return new Power(value, unit);
    }

}