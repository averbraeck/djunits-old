package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.LuminousFluxUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.LuminousFlux;

/**
 * Mutable Double LuminousFluxMatrix, a matrix of values with a LuminousFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableLuminousFluxMatrix
        extends AbstractMutableDoubleMatrixRel<LuminousFluxUnit, LuminousFluxMatrix, MutableLuminousFluxMatrix, LuminousFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double LuminousFluxMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double LuminousFluxMatrix
     * @param unit LuminousFluxUnit; the unit of the new Relative Immutable Double LuminousFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableLuminousFluxMatrix(final double[][] values, final LuminousFluxUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double LuminousFluxMatrix.
     * @param values LuminousFlux[][]; the values of the entries in the new Relative Immutable Double LuminousFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableLuminousFluxMatrix(final LuminousFlux[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit LuminousFluxUnit; the unit
     */
    MutableLuminousFluxMatrix(final DoubleMatrixData data, final LuminousFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLuminousFluxMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableLuminousFluxMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousFluxMatrix instantiateType(final DoubleMatrixData dmd, final LuminousFluxUnit unit)
    {
        return new LuminousFluxMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableLuminousFluxMatrix instantiateMutableType(final DoubleMatrixData dmd, final LuminousFluxUnit unit)
    {
        return new MutableLuminousFluxMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final LuminousFlux instantiateScalar(final double value, final LuminousFluxUnit unit)
    {
        return new LuminousFlux(value, unit);
    }

}
