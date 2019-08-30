package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.MagneticFluxUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.MagneticFlux;

/**
 * Immutable Double MagneticFluxMatrix, a matrix of values with a MagneticFluxUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MagneticFluxMatrix
        extends AbstractDoubleMatrixRel<MagneticFluxUnit, MagneticFluxMatrix, MutableMagneticFluxMatrix, MagneticFlux>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MagneticFluxMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MagneticFluxMatrix
     * @param unit MagneticFluxUnit; the unit of the new Relative Immutable Double MagneticFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MagneticFluxMatrix(final double[][] values, final MagneticFluxUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxMatrix.
     * @param values MagneticFlux[][]; the values of the entries in the new Relative Immutable Double MagneticFluxMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MagneticFluxMatrix(final MagneticFlux[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MagneticFluxUnit; the unit
     */
    MagneticFluxMatrix(final DoubleMatrixData data, final MagneticFluxUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MagneticFluxMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MagneticFluxMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxMatrix instantiateType(final DoubleMatrixData dmd, final MagneticFluxUnit unit)
    {
        return new MagneticFluxMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMagneticFluxMatrix instantiateMutableType(final DoubleMatrixData dmd, final MagneticFluxUnit unit)
    {
        return new MutableMagneticFluxMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFlux instantiateScalar(final double value, final MagneticFluxUnit unit)
    {
        return new MagneticFlux(value, unit);
    }

}
