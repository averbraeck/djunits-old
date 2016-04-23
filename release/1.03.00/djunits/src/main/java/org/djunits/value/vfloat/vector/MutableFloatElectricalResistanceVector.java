package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatElectricalResistance;

/**
 * Mutable FloatElectricalResistanceVector, a vector of values with a ElectricalResistanceUnit.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatElectricalResistanceVector
        extends
        MutableTypedFloatVectorRel<ElectricalResistanceUnit, FloatElectricalResistanceVector, MutableFloatElectricalResistanceVector, FloatElectricalResistance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceVector.
     * @param values float[]; the values of the entries in the new Relative Immutable FloatElectricalResistanceVector
     * @param unit U; the unit of the new Relative Immutable FloatElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalResistanceVector(final float[] values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatElectricalResistanceVector
     * @param unit U; the unit of the new Relative Immutable FloatElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalResistanceVector(final List<Float> values, final ElectricalResistanceUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float
     *            FloatElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalResistanceVector(final FloatElectricalResistance[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceVector.
     * @param values List; the values of the entries in the new Relative Immutable FloatElectricalResistanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalResistanceVector(final List<FloatElectricalResistance> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            FloatElectricalResistanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatElectricalResistanceVector(final SortedMap<Integer, FloatElectricalResistance> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable FloatElectricalResistanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable FloatElectricalResistanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable FloatElectricalResistanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatElectricalResistanceVector(final SortedMap<Integer, Float> values, final ElectricalResistanceUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatElectricalResistanceVector(final FloatVectorData data, final ElectricalResistanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatElectricalResistanceVector instantiateType(final FloatVectorData dvd,
            final ElectricalResistanceUnit unit)
    {
        return new FloatElectricalResistanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatElectricalResistanceVector instantiateMutableType(final FloatVectorData dvd,
            final ElectricalResistanceUnit unit)
    {
        return new MutableFloatElectricalResistanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final FloatElectricalResistance get(final int index) throws ValueException
    {
        return new FloatElectricalResistance(getInUnit(index, getUnit()), getUnit());
    }

}
