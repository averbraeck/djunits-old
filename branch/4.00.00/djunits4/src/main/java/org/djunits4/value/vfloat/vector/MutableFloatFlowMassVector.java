package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.unit.FlowMassUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.scalar.FloatFlowMass;

/**
 * Mutable Float FlowMassVector, a vector of values with a FlowMassUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class MutableFloatFlowMassVector
        extends AbstractMutableFloatVectorRel<FlowMassUnit, FloatFlowMassVector, MutableFloatFlowMassVector, FloatFlowMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float FlowMassVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float FlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Immutable Float FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatFlowMassVector(final float[] values, final FlowMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FlowMassVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float FlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Immutable Float FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatFlowMassVector(final List<Float> values, final FlowMassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FlowMassVector.
     * @param values FloatFlowMass[]; the values of the entries in the new Relative Immutable Float FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFlowMassVector(final FloatFlowMass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FlowMassVector.
     * @param values List&lt;FloatFlowMass&gt;; the values of the entries in the new Relative Immutable Float FlowMassVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFlowMassVector(final List<FloatFlowMass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FlowMassVector.
     * @param values SortedMap&lt;Integer, FloatFlowMass&gt;; the values of the entries in the new Relative Sparse Mutable Float
     *            FlowMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatFlowMassVector(final SortedMap<Integer, FloatFlowMass> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float FlowMassVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            FlowMassVector
     * @param unit FlowMassUnit; the unit of the new Relative Sparse Mutable Float FlowMassVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatFlowMassVector(final SortedMap<Integer, Float> values, final FlowMassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit the unit
     */
    MutableFloatFlowMassVector(final FloatVectorData data, final FlowMassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowMassVector instantiateType(final FloatVectorData dvd, final FlowMassUnit unit)
    {
        return new FloatFlowMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatFlowMassVector instantiateMutableType(final FloatVectorData dvd, final FlowMassUnit unit)
    {
        return new MutableFloatFlowMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatFlowMass instantiateScalar(final float value, final FlowMassUnit unit)
    {
        return new FloatFlowMass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFlowMassVector toDense()
    {
        return this.data.isDense() ? (MutableFloatFlowMassVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatFlowMassVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatFlowMassVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatFlowMass Scalars from this vector.
     * @return FloatFlowMass[]; an array of FloatFlowMass Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatFlowMass[] toArray()
    {
        FloatFlowMass[] array = new FloatFlowMass[size()];
        for (int i = 0; i < size(); i++)
        {
            try
            {
                array[i] = get(i);
            }
            catch (ValueException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

}
