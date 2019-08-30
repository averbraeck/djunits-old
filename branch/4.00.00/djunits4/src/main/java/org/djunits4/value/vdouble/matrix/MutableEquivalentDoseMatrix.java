package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.EquivalentDoseUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.EquivalentDose;

/**
 * Mutable Double EquivalentDoseMatrix, a matrix of values with a EquivalentDoseUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableEquivalentDoseMatrix extends
        AbstractMutableDoubleMatrixRel<EquivalentDoseUnit, EquivalentDoseMatrix, MutableEquivalentDoseMatrix, EquivalentDose>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double EquivalentDoseMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double EquivalentDoseMatrix
     * @param unit U; the unit of the new Relative Immutable Double EquivalentDoseMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableEquivalentDoseMatrix(final double[][] values, final EquivalentDoseUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double EquivalentDoseMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Immutable Double
     *            EquivalentDoseMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableEquivalentDoseMatrix(final EquivalentDose[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
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
    protected final MutableEquivalentDoseMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final EquivalentDoseUnit unit)
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
