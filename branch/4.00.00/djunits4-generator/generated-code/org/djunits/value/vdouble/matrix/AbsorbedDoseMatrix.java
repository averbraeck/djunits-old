package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double AbsorbedDoseMatrix, a matrix of values with a AbsorbedDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "org.djunits.generator.GenerateDJUNIT", date = "2019-09-03T23:30:17.259Z")
public class AbsorbedDoseMatrix extends
AbstractDoubleMatrixRel<AbsorbedDoseUnit, AbsorbedDoseMatrix, MutableAbsorbedDoseMatrix, AbsorbedDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AbsorbedDoseMatrix
     * @param unit AbsorbedDoseUnit; the unit of the new Relative Immutable Double AbsorbedDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AbsorbedDoseMatrix(final double[][] values, final AbsorbedDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseMatrix.
     * @param values AbsorbedDose[][]; the values of the entries in the new Relative Immutable Double AbsorbedDoseMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AbsorbedDoseMatrix(final AbsorbedDose[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AbsorbedDoseUnit; the unit
     */
    AbsorbedDoseMatrix(final DoubleMatrixData data, final AbsorbedDoseUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AbsorbedDoseMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AbsorbedDoseMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsorbedDoseMatrix instantiateType(final DoubleMatrixData dmd, final AbsorbedDoseUnit unit)
    {
        return new AbsorbedDoseMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAbsorbedDoseMatrix instantiateMutableType(final DoubleMatrixData dmd, final AbsorbedDoseUnit unit)
    {
        return new MutableAbsorbedDoseMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AbsorbedDose instantiateScalar(final double value, final AbsorbedDoseUnit unit)
    {
        return new AbsorbedDose(value, unit);
    }


    
}
