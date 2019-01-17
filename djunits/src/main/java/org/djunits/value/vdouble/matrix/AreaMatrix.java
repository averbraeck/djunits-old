package org.djunits.value.vdouble.matrix;

import org.djunits.unit.AreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Area;

/**
 * Immutable Double AreaMatrix, a matrix of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AreaMatrix extends AbstractDoubleMatrixRel<AreaUnit, AreaMatrix, MutableAreaMatrix, Area>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AreaMatrix.
     * @param values double[][]; the values of the entries in the new Relative Immutable Double AreaMatrix
     * @param unit AreaUnit; the unit of the new Relative Immutable Double AreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AreaMatrix(final double[][] values, final AreaUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AreaMatrix.
     * @param values Area[][]; the values of the entries in the new Relative Immutable Double AreaMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AreaMatrix(final Area[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data DoubleMatrixData; an internal data object
     * @param unit AreaUnit; the unit
     */
    AreaMatrix(final DoubleMatrixData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AreaMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AreaMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final AreaMatrix instantiateType(final DoubleMatrixData dmd, final AreaUnit unit)
    {
        return new AreaMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAreaMatrix instantiateMutableType(final DoubleMatrixData dmd, final AreaUnit unit)
    {
        return new MutableAreaMatrix(dmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Area instantiateScalar(final double value, final AreaUnit unit)
    {
        return new Area(value, unit);
    }

}
