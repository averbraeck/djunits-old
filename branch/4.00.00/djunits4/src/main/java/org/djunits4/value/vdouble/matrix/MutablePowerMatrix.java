package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.PowerUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Power;

/**
 * Mutable Double PowerMatrix, a matrix of values with a PowerUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutablePowerMatrix extends AbstractMutableDoubleMatrixRel<PowerUnit, PowerMatrix, MutablePowerMatrix, Power>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double PowerMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double PowerMatrix
     * @param unit PowerUnit; the unit of the new Relative Immutable Double PowerMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePowerMatrix(final double[][] values, final PowerUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PowerMatrix.
     * @param values Power[][]; the values of the entries in the new Relative Immutable Double PowerMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePowerMatrix(final Power[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit PowerUnit; the unit
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
