package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.AmountOfSubstanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.AmountOfSubstance;

/**
 * Immutable Double AmountOfSubstanceMatrix, a matrix of values with a AmountOfSubstanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class AmountOfSubstanceMatrix extends AbstractDoubleMatrixRel<AmountOfSubstanceUnit, AmountOfSubstanceMatrix,
        MutableAmountOfSubstanceMatrix, AmountOfSubstance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AmountOfSubstanceMatrix
     * @param unit AmountOfSubstanceUnit; the unit of the new Relative Immutable Double AmountOfSubstanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AmountOfSubstanceMatrix(final double[][] values, final AmountOfSubstanceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AmountOfSubstanceMatrix.
     * @param values AmountOfSubstance[][]; the values of the entries in the new Relative Immutable Double
     *            AmountOfSubstanceMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AmountOfSubstanceMatrix(final AmountOfSubstance[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AmountOfSubstanceUnit; the unit
     */
    AmountOfSubstanceMatrix(final DoubleMatrixData data, final AmountOfSubstanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AmountOfSubstanceMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AmountOfSubstanceMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AmountOfSubstanceMatrix instantiateType(final DoubleMatrixData dmd, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAmountOfSubstanceMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final AmountOfSubstanceUnit unit)
    {
        return new MutableAmountOfSubstanceMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AmountOfSubstance instantiateScalar(final double value, final AmountOfSubstanceUnit unit)
    {
        return new AmountOfSubstance(value, unit);
    }

}
