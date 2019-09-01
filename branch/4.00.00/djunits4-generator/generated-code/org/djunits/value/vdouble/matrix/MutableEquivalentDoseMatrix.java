package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Mutable Double EquivalentDoseMatrix, a matrix of values with a EquivalentDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableEquivalentDoseMatrix extends
    AbstractMutableDoubleMatrixRel<EquivalentDoseUnit, EquivalentDoseMatrix, MutableEquivalentDoseMatrix, EquivalentDose> 
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EquivalentDoseMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double EquivalentDoseMatrix
     * @param unit EquivalentDoseUnit; the unit of the new Relative Immutable Double EquivalentDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableEquivalentDoseMatrix(final double[][] values, final EquivalentDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseMatrix.
     * @param values %TypeAbs%[][]; the values of the entries in the new Relative Immutable Double EquivalentDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableEquivalentDoseMatrix(final EquivalentDose[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit EquivalentDoseUnit; the unit
     */
    MutableEquivalentDoseMatrix(final DoubleMatrixData data, final EquivalentDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEquivalentDoseMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEquivalentDoseMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final EquivalentDoseMatrix instantiateType(final DoubleMatrixData dmd, final EquivalentDoseUnit unit)
    {
        return new EquivalentDoseMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableEquivalentDoseMatrix instantiateMutableType(final DoubleMatrixData dmd, final EquivalentDoseUnit unit)
    {
        return new MutableEquivalentDoseMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final EquivalentDose instantiateScalar(final double value, final EquivalentDoseUnit unit)
    {
        return new EquivalentDose(value, unit);
    }
    


}
