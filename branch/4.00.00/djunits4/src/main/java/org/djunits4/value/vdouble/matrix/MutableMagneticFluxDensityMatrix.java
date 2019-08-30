package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.MagneticFluxDensityUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.MagneticFluxDensity;

/**
 * Mutable Double MagneticFluxDensityMatrix, a matrix of values with a MagneticFluxDensityUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMagneticFluxDensityMatrix extends AbstractMutableDoubleMatrixRel<MagneticFluxDensityUnit,
        MagneticFluxDensityMatrix, MutableMagneticFluxDensityMatrix, MagneticFluxDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double MagneticFluxDensityMatrix
     * @param unit MagneticFluxDensityUnit; the unit of the new Relative Immutable Double MagneticFluxDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMagneticFluxDensityMatrix(final double[][] values, final MagneticFluxDensityUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityMatrix.
     * @param values MagneticFluxDensity[][]; the values of the entries in the new Relative Immutable Double
     *            MagneticFluxDensityMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMagneticFluxDensityMatrix(final MagneticFluxDensity[][] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit MagneticFluxDensityUnit; the unit
     */
    MutableMagneticFluxDensityMatrix(final DoubleMatrixData data, final MagneticFluxDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMagneticFluxDensityMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMagneticFluxDensityMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxDensityMatrix instantiateType(final DoubleMatrixData dmd, final MagneticFluxDensityUnit unit)
    {
        return new MagneticFluxDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMagneticFluxDensityMatrix instantiateMutableType(final DoubleMatrixData dmd,
            final MagneticFluxDensityUnit unit)
    {
        return new MutableMagneticFluxDensityMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxDensity instantiateScalar(final double value, final MagneticFluxDensityUnit unit)
    {
        return new MagneticFluxDensity(value, unit);
    }

}
