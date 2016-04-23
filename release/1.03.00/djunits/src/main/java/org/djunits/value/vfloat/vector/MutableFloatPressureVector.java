package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.PressureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatPressure;

/**
 * Mutable FloatPressureVector, a vector of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatPressureVector extends
        MutableTypedFloatVectorRel<PressureUnit, FloatPressureVector, MutableFloatPressureVector, FloatPressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatPressureVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatPressureVector
     * @param unit U; the unit of the new Relative Immutable FloatPressureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPressureVector(final float[] values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatPressureVector
     * @param unit U; the unit of the new Relative Immutable FloatPressureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPressureVector(final List<Float> values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatPressureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureVector(final FloatPressure[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatPressureVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureVector(final List<FloatPressure> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatPressureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatPressureVector(final SortedMap<Integer, FloatPressure> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatPressureVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatPressureVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatPressureVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatPressureVector(final SortedMap<Integer, Float> values, final PressureUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatPressureVector(final FloatVectorData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatPressureVector instantiateType(final FloatVectorData dvd, final PressureUnit unit)
    {
        return new FloatPressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatPressureVector instantiateMutableType(final FloatVectorData dvd, final PressureUnit unit)
    {
        return new MutableFloatPressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatPressure get(final int index) throws ValueException
    {
        return new FloatPressure(getInUnit(index, getUnit()), getUnit());
    }

}
