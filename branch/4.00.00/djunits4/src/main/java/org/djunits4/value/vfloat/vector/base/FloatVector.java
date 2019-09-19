package org.djunits4.value.vfloat.vector.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.stream.IntStream;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.scale.Scale;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalar;
import org.djunits4.value.vfloat.vector.FloatSIVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;
import org.djunits4.value.vfloat.vector.data.FloatVectorDataSparse;

/**
 * FloatVector utility methods, e.g., for creating FloatVectors from different types of data.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public final class FloatVector
{
    /** The cache to make the lookup of the constructor for a Immutable Vector belonging to a unit faster. */
    private static Map<Unit<?>, Constructor<? extends AbstractFloatVector<?, ?, ?>>> CACHE_DATA = new HashMap<>();

    /** Do not instantiate. */
    private FloatVector()
    {
        // Utility class.
    }

    /**
     * Instantiate the FloatVector based on its unit. Rigid check on types for the compiler.
     * @param values float[]; the values
     * @param unit U; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated FloatVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiate(final float[] values, final U unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(values, unit, storageType);
    }

    /**
     * Instantiate the FloatVector based on its unit. Rigid check on types for the compiler.
     * @param valueList List&lt;Float&gt;; the values
     * @param unit U; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated FloatVector with the values expressed in their unit
     * @throws ValueRuntimeException on vector init error
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiate(final List<Float> valueList, final U unit,
                    final StorageType storageType) throws ValueRuntimeException
    {
        return instantiateAnonymous(valueList, unit, storageType);
    }

    /**
     * Instantiate the FloatVector based on its unit. Rigid check on types for the compiler.
     * @param valueMap Map&lt;Integer, Float&gt;; the values
     * @param unit U; the unit in which the values are expressed
     * @param length int; the size of the vector
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated FloatVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiate(final SortedMap<Integer, Float> valueMap, final U unit,
                    final int length, final StorageType storageType)
    {
        return instantiateAnonymous(valueMap, unit, length, storageType);
    }

    /**
     * Instantiate the Mutable FloatVector based on its unit. Rigid check on types for the compiler.
     * @param values FloatVectorData; the values
     * @param unit U; the unit in which the values are expressed
     * @return V; an instantiated mutable FloatVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiate(final FloatVectorData values, final U unit)
    {
        return instantiateAnonymous(values, unit);
    }

    /**
     * Instantiate the FloatVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values float[]; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated FloatVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiateAnonymous(final float[] values, final Unit<?> unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(FloatVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the FloatVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param valueList List&lt;Float&gt;; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated FloatVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiateAnonymous(final List<Float> valueList, final Unit<?> unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(FloatVectorData.instantiate(valueList, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the FloatVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param valueMap Map&lt;Integer, Float&gt;; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param length int; the size of the vector
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated FloatVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiateAnonymous(final SortedMap<Integer, Float> valueMap,
                    final Unit<?> unit, final int length, final StorageType storageType)
    {
        return instantiateAnonymous(FloatVectorData.instantiate(valueMap, length, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the Immutable FloatVector based on its unit. Loose check for types on the compiler. This allows the unit to
     * be specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values FloatVectorData; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @return V; an instantiated FloatVector with the values expressed in their unit
     */
    @SuppressWarnings("unchecked")
    protected static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>,
            V extends AbstractFloatVector<U, S, V>> V instantiateAnonymous(final FloatVectorData values, final Unit<?> unit)
    {
        try
        {
            Constructor<? extends AbstractFloatVector<?, ?, ?>> vectorConstructor = CACHE_DATA.get(unit);
            if (vectorConstructor == null)
            {
                if (!unit.getClass().getSimpleName().endsWith("Unit"))
                {
                    throw new ClassNotFoundException("Unit " + unit.getClass().getSimpleName()
                            + " name does not end with 'Unit'. Cannot find corresponding vector");
                }
                Class<? extends AbstractFloatVector<?, ?, ?>> vectorClass;
                if (unit instanceof SIUnit)
                {
                    vectorClass = FloatSIVector.class;
                }
                else
                {
                    vectorClass = (Class<AbstractFloatVector<?, ?, ?>>) Class.forName("org.djunits4.value.vfloat.vector.Float"
                            + unit.getClass().getSimpleName().replace("Unit", "") + "Vector");
                }
                vectorConstructor = vectorClass.getDeclaredConstructor(FloatVectorData.class, unit.getClass());
                CACHE_DATA.put(unit, vectorConstructor);
            }
            return (V) vectorConstructor.newInstance(values, unit);
        }
        catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | ClassNotFoundException | NoSuchMethodException exception)
        {
            throw new UnitRuntimeException("Cannot instantiate AbstractFloatVector of unit " + unit.toString() + ". Reason: "
                    + exception.getMessage());
        }
    }

    /**
     * Construct a new Relative Immutable Float Vector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float Vector
     * @param unit Unit; the unit of the new Relative Immutable Float Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>> V create(
            final float[] values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        return instantiate(FloatVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Float Vector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float Vector
     * @param unit Unit; the unit of the new Relative Immutable Float Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>> V create(
            final List<Float> values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        return instantiate(FloatVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Float Vector.
     * @param values []; the values of the entries in the new Relative Immutable Float Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>> V create(
            final S[] values, final StorageType storageType) throws ValueRuntimeException
    {
        U unit = values[0].getUnit();
        return instantiate(FloatVectorData.instantiate(values, storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Float Vector.
     * @param valueList List&lt;&gt;; the values of the entries in the new Relative Immutable Float Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>> V create(
            final List<S> valueList, final StorageType storageType) throws ValueRuntimeException
    {
        U unit = valueList.get(0).getUnit();
        switch (storageType)
        {
            case DENSE:
            {
                float[] valuesSI = new float[valueList.size()];
                IntStream.range(0, valueList.size()).parallel().forEach(i -> valuesSI[i] = valueList.get(i).si);
                return create(valuesSI, unit, StorageType.DENSE);
            }

            case SPARSE:
            {
                int size = valueList.size();
                int non0 = (int) valueList.parallelStream().filter(e -> e.si != 0.0).count();
                int[] indices = new int[non0];
                float[] values = new float[non0];
                int index = 0;
                for (int i = 0; i < valueList.size(); i++)
                {
                    float si = valueList.get(i).si;
                    if (si != 0.0)
                    {
                        indices[index] = i;
                        values[index] = si;
                        index++;
                    }
                }
                return instantiate(new FloatVectorDataSparse(values, indices, size), unit);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }

    }

    /**
     * Construct a new Relative Immutable Float Vector.
     * @param valueMap SortedMap&lt;Integer, &gt;; the values of the entries in the new Relative Sparse Mutable Float Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>> V create(
            final SortedMap<Integer, S> valueMap, final int length, final StorageType storageType) throws ValueRuntimeException
    {
        U unit = valueMap.values().iterator().next().getUnit();
        switch (storageType)
        {
            case DENSE:
            {
                float[] valuesSI = new float[length];
                valueMap.keySet().parallelStream().forEach(i -> valuesSI[i] = valueMap.get(i).si);
                return create(valuesSI, unit, StorageType.DENSE);
            }

            case SPARSE:
            {
                int non0 = (int) valueMap.keySet().parallelStream().filter(i -> valueMap.get(i).si != 0.0).count();
                int[] indices = new int[non0];
                float[] valuesSI = new float[non0];
                int index = 0;
                for (int i = 0; i < valueMap.size(); i++)
                {
                    float si = valueMap.get(i).si;
                    if (si != 0.0)
                    {
                        indices[index] = i;
                        valuesSI[index] = si;
                        index++;
                    }
                }
                return instantiate(new FloatVectorDataSparse(valuesSI, indices, length), unit);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Construct a new Relative Immutable Float Vector.
     * @param valueMap SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float Vector
     * @param unit Unit; the unit of the new Relative Sparse Mutable Float Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractFloatScalar<U, S>, V extends AbstractFloatVector<U, S, V>> V create(
            final SortedMap<Integer, Float> valueMap, final U unit, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        switch (storageType)
        {
            case DENSE:
            {
                float[] values = new float[length];
                valueMap.keySet().parallelStream().forEach(i -> values[i] = valueMap.get(i));
                return create(values, unit, StorageType.DENSE);
            }

            case SPARSE:
            {
                final Scale scale = unit.getScale();
                boolean zeroBasedScale = scale.toStandardUnit(0.0) == 0.0;
                int non0;
                if (zeroBasedScale)
                {
                    non0 = (int) valueMap.keySet().parallelStream().filter(i -> valueMap.get(i) != 0.0).count();
                }
                else
                {
                    non0 = (int) valueMap.keySet().parallelStream().filter(i -> scale.toStandardUnit(valueMap.get(i)) != 0.0)
                            .count();
                }
                int[] indices = new int[non0];
                float[] valuesSI = new float[non0];
                int index = 0;
                for (int i = 0; i < valueMap.size(); i++)
                {
                    float si = (float) (zeroBasedScale ? valueMap.get(i) : scale.toStandardUnit(valueMap.get(i)));
                    if (si != 0.0)
                    {
                        indices[index] = i;
                        valuesSI[index] = si;
                        index++;
                    }
                }
                return instantiate(new FloatVectorDataSparse(valuesSI, indices, length), unit);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in FloatVectorData.instantiate: " + storageType);
        }
    }
}
