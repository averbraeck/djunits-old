package org.djunits4.value.vdouble.matrix;

import javax.annotation.Generated;

import org.djunits4.unit.RadioActivityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.RadioActivity;

/**
 * Mutable Double RadioActivityMatrix, a matrix of values with a RadioActivityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableRadioActivityMatrix extends
        AbstractMutableDoubleMatrixRel<RadioActivityUnit, RadioActivityMatrix, MutableRadioActivityMatrix, RadioActivity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double RadioActivityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double RadioActivityMatrix
     * @param unit RadioActivityUnit; the unit of the new Relative Immutable Double RadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableRadioActivityMatrix(final double[][] values, final RadioActivityUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double RadioActivityMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double RadioActivityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableRadioActivityMatrix(final RadioActivity[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit RadioActivityUnit; the unit
     */
    MutableRadioActivityMatrix(final DoubleMatrixData data, final RadioActivityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableRadioActivityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableRadioActivityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final RadioActivityMatrix instantiateType(final DoubleMatrixData dmd, final RadioActivityUnit unit)
    {
        return new RadioActivityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableRadioActivityMatrix instantiateMutableType(final DoubleMatrixData dmd, final RadioActivityUnit unit)
    {
        return new MutableRadioActivityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final RadioActivity instantiateScalar(final double value, final RadioActivityUnit unit)
    {
        return new RadioActivity(value, unit);
    }

}
