package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ForceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatForce;

/**
 * Mutable Float ForceVector, a vector of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatForceVector
        extends AbstractMutableFloatVectorRel<ForceUnit, FloatForceVector, MutableFloatForceVector, FloatForce>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float ForceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float ForceVector
     * @param unit U; the unit of the new Relative Immutable Float ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatForceVector(final float[] values, final ForceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ForceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ForceVector
     * @param unit U; the unit of the new Relative Immutable Float ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatForceVector(final List<Float> values, final ForceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ForceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatForceVector(final FloatForce[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ForceVector.
     * @param values List; the values of the entries in the new Relative Immutable Float ForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatForceVector(final List<FloatForce> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ForceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float ForceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatForceVector(final SortedMap<Integer, FloatForce> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float ForceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float ForceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float ForceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatForceVector(final SortedMap<Integer, Float> values, final ForceUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatForceVector(final FloatVectorData data, final ForceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForceVector instantiateType(final FloatVectorData dvd, final ForceUnit unit)
    {
        return new FloatForceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatForceVector instantiateMutableType(final FloatVectorData dvd, final ForceUnit unit)
    {
        return new MutableFloatForceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatForce instantiateScalar(final float value, final ForceUnit unit)
    {
        return new FloatForce(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatForceVector toDense()
    {
        return this.data.isDense() ? (MutableFloatForceVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatForceVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatForceVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
