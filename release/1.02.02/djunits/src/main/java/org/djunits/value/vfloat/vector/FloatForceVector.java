package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ForceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatForce;

/**
 * Immutable FloatForceVector, a vector of values with a ForceUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class FloatForceVector extends
    TypedFloatVectorRel<ForceUnit, FloatForceVector, MutableFloatForceVector, FloatForce>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatForceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatForceVector
     * @param unit U; the unit of the new Relative Immutable FloatForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatForceVector(final float[] values, final ForceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatForceVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatForceVector
     * @param unit U; the unit of the new Relative Immutable FloatForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatForceVector(final List<Float> values, final ForceUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatForceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float FloatForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatForceVector(final FloatForce[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatForceVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatForceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatForceVector(final List<FloatForce> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatForceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatForceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public FloatForceVector(final SortedMap<Integer, FloatForce> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatForceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatForceVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatForceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public FloatForceVector(final SortedMap<Integer, Float> values, final ForceUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    FloatForceVector(final FloatVectorData data, final ForceUnit unit)
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
    public final FloatForce get(final int index) throws ValueException
    {
        return new FloatForce(getInUnit(index, getUnit()), getUnit());
    }

}
