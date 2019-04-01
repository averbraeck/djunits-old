package org.djunits.value.vfloat.matrix;

import org.djunits.unit.EnergyUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatEnergy;

/**
 * Mutable FloatEnergyMatrix, a matrix of values with a EnergyUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatEnergyMatrix
        extends AbstractMutableFloatMatrixRel<EnergyUnit, FloatEnergyMatrix, MutableFloatEnergyMatrix, FloatEnergy>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatEnergyMatrix.
     * @param values float[][]; the values of the entries in the new Relative Immutable FloatEnergyMatrix
     * @param unit EnergyUnit; the unit of the new Relative Immutable FloatEnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatEnergyMatrix(final float[][] values, final EnergyUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatEnergyMatrix.
     * @param values FloatEnergy[][]; the values of the entries in the new Relative Immutable Float FloatEnergyMatrix
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatEnergyMatrix(final FloatEnergy[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data FloatMatrixData; an internal data object
     * @param unit EnergyUnit; the unit
     */
    MutableFloatEnergyMatrix(final FloatMatrixData data, final EnergyUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatEnergyMatrix toDense()
    {
        return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatEnergyMatrix toSparse()
    {
        return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEnergyMatrix instantiateType(final FloatMatrixData fmd, final EnergyUnit unit)
    {
        return new FloatEnergyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatEnergyMatrix instantiateMutableType(final FloatMatrixData fmd, final EnergyUnit unit)
    {
        return new MutableFloatEnergyMatrix(fmd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatEnergy instantiateScalar(final float value, final EnergyUnit unit)
    {
        return new FloatEnergy(value, unit);
    }

}
