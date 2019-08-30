package org.djunits4.value.vdouble.matrix;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double AbsorbedDoseMatrix, a matrix of values with a AbsorbedDoseUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AbsorbedDoseMatrix extends
AbstractDoubleMatrixRel<AbsorbedDoseUnit, AbsorbedDoseMatrix, MutableAbsorbedDoseMatrix, AbsorbedDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AbsorbedDoseMatrix
     * @param unit U; the unit of the new Relative Immutable Double AbsorbedDoseMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AbsorbedDoseMatrix(final double[][] values, final AbsorbedDoseUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AbsorbedDoseMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            AbsorbedDoseMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AbsorbedDoseMatrix(final AbsorbedDose[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
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
