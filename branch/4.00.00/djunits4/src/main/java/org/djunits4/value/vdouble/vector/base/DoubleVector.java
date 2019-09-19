package org.djunits4.value.vdouble.vector.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.scale.Scale;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;
import org.djunits4.value.vdouble.vector.data.DoubleVectorData;
import org.djunits4.value.vdouble.vector.data.DoubleVectorDataSparse;

/**
 * DoubleVector utility methods, e.g., for creating DoubleVectors from different types of data.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public final class DoubleVector
{
    /** The cache to make the lookup of the constructor for a Immutable Vector belonging to a unit faster. */
    private static Map<Unit<?>, Constructor<? extends AbstractDoubleVector<?, ?, ?>>> CACHE_DATA = new HashMap<>();

    /** Do not instantiate. */
    private DoubleVector()
    {
        // Utility class.
    }

    /**
     * Instantiate the DoubleVector based on its unit. Rigid check on types for the compiler.
     * @param values double[]; the values
     * @param unit U; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated DoubleVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiate(final double[] values, final U unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(values, unit, storageType);
    }

    /**
     * Instantiate the DoubleVector based on its unit. Rigid check on types for the compiler.
     * @param valueList List&lt;Double&gt;; the values
     * @param unit U; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated DoubleVector with the values expressed in their unit
     * @throws ValueRuntimeException on vector init error
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiate(final List<Double> valueList, final U unit,
                    final StorageType storageType) throws ValueRuntimeException
    {
        return instantiateAnonymous(valueList, unit, storageType);
    }

    /**
     * Instantiate the DoubleVector based on its unit. Rigid check on types for the compiler.
     * @param valueMap Map&lt;Integer, Double&gt;; the values
     * @param unit U; the unit in which the values are expressed
     * @param length int; the size of the vector
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated DoubleVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiate(final Map<Integer, Double> valueMap, final U unit,
                    final int length, final StorageType storageType)
    {
        return instantiateAnonymous(valueMap, unit, length, storageType);
    }

    /**
     * Instantiate the Mutable DoubleVector based on its unit. Rigid check on types for the compiler.
     * @param values DoubleVectorData; the values
     * @param unit U; the unit in which the values are expressed
     * @return V; an instantiated mutable DoubleVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiate(final DoubleVectorData values, final U unit)
    {
        return instantiateAnonymous(values, unit);
    }

    /**
     * Instantiate the DoubleVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values double[]; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated DoubleVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiateAnonymous(final double[] values, final Unit<?> unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(DoubleVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the DoubleVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param valueList List&lt;Double&gt;; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated DoubleVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiateAnonymous(final List<Double> valueList, final Unit<?> unit,
                    final StorageType storageType)
    {
        return instantiateAnonymous(DoubleVectorData.instantiate(valueList, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the DoubleVector based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param valueMap Map&lt;Integer, Double&gt;; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @param length int; the size of the vector
     * @param storageType StorageType; whether the vector is SPARSE or DENSE
     * @return V; an instantiated DoubleVector with the values expressed in their unit
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiateAnonymous(final Map<Integer, Double> valueMap,
                    final Unit<?> unit, final int length, final StorageType storageType)
    {
        return instantiateAnonymous(DoubleVectorData.instantiate(valueMap, length, unit.getScale(), storageType), unit);
    }

    /**
     * Instantiate the Immutable DoubleVector based on its unit. Loose check for types on the compiler. This allows the unit to
     * be specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param values DoubleVectorData; the values
     * @param unit Unit&lt;?&gt;; the unit in which the values are expressed
     * @return V; an instantiated DoubleVector with the values expressed in their unit
     */
    @SuppressWarnings("unchecked")
    protected static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>,
            V extends AbstractDoubleVector<U, S, V>> V instantiateAnonymous(final DoubleVectorData values, final Unit<?> unit)
    {
        try
        {
            Constructor<? extends AbstractDoubleVector<?, ?, ?>> vectorConstructor = CACHE_DATA.get(unit);
            if (vectorConstructor == null)
            {
                if (!unit.getClass().getSimpleName().endsWith("Unit"))
                {
                    throw new ClassNotFoundException("Unit " + unit.getClass().getSimpleName()
                            + " name does not end with 'Unit'. Cannot find corresponding vector");
                }
                Class<? extends AbstractDoubleVector<?, ?, ?>> vectorClass;
                if (unit instanceof SIUnit)
                {
                    throw new UnitRuntimeException("Cannot instantiate AbstractDoubleVector of unit " + unit.toString());
                }
                else
                {
                    vectorClass = (Class<AbstractDoubleVector<?, ?, ?>>) Class.forName("org.djunits4.value.vdouble.vector."
                            + unit.getClass().getSimpleName().replace("Unit", "") + "Vector");
                }
                vectorConstructor = vectorClass.getDeclaredConstructor(DoubleVectorData.class, unit.getClass());
                CACHE_DATA.put(unit, vectorConstructor);
            }
            return (V) vectorConstructor.newInstance(values, unit);
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
        {
            throw new UnitRuntimeException("Cannot instantiate AbstractDoubleVector of unit " + unit.toString() + ". Reason: "
                    + exception.getMessage());
        }
    }

    /**
     * Construct a new Relative Immutable Double Vector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double Vector
     * @param unit Unit; the unit of the new Relative Immutable Double Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>> V create(
            final double[] values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        return instantiate(DoubleVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Double Vector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double Vector
     * @param unit Unit; the unit of the new Relative Immutable Double Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>> V create(
            final List<Double> values, final U unit, final StorageType storageType) throws ValueRuntimeException
    {
        return instantiate(DoubleVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Double Vector.
     * @param values []; the values of the entries in the new Relative Immutable Double Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>> V create(
            final S[] values, final StorageType storageType) throws ValueRuntimeException
    {
        U unit = values[0].getUnit();
        return instantiate(DoubleVectorData.instantiate(values, storageType), unit);
    }

    /**
     * Construct a new Relative Immutable Double Vector.
     * @param valueList List&lt;&gt;; the values of the entries in the new Relative Immutable Double Vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>> V create(
            final List<S> valueList, final StorageType storageType) throws ValueRuntimeException
    {
        U unit = valueList.get(0).getUnit();
        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI = valueList.parallelStream().mapToDouble(s -> s.getSI()).toArray();
                return create(valuesSI, unit, StorageType.DENSE);
            }

            case SPARSE:
            {
                int size = valueList.size();
                int non0 = (int) valueList.parallelStream().filter(e -> e.si != 0.0).count();
                int[] indices = new int[non0];
                double[] values = new double[non0];
                int index = 0;
                for (int i = 0; i < valueList.size(); i++)
                {
                    double si = valueList.get(i).si;
                    if (si != 0.0)
                    {
                        indices[index] = i;
                        values[index] = si;
                        index++;
                    }
                }
                return instantiate(new DoubleVectorDataSparse(values, indices, size), unit);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }

    }

    /**
     * Construct a new Relative Immutable Double Vector.
     * @param valueMap SortedMap&lt;Integer, &gt;; the values of the entries in the new Relative Sparse Mutable Double Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values has zero entries
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>> V create(
            final SortedMap<Integer, S> valueMap, final int length, final StorageType storageType) throws ValueRuntimeException
    {
        U unit = valueMap.values().iterator().next().getUnit();
        switch (storageType)
        {
            case DENSE:
            {
                double[] valuesSI = new double[length];
                valueMap.keySet().parallelStream().forEach(i -> valuesSI[i] = valueMap.get(i).si);
                return create(valuesSI, unit, StorageType.DENSE);
            }

            case SPARSE:
            {
                int non0 = (int) valueMap.keySet().parallelStream().filter(i -> valueMap.get(i).si != 0.0).count();
                int[] indices = new int[non0];
                double[] valuesSI = new double[non0];
                int index = 0;
                for (int i = 0; i < valueMap.size(); i++)
                {
                    double si = valueMap.get(i).si;
                    if (si != 0.0)
                    {
                        indices[index] = i;
                        valuesSI[index] = si;
                        index++;
                    }
                }
                return instantiate(new DoubleVectorDataSparse(valuesSI, indices, length), unit);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

    /**
     * Construct a new Relative Immutable Double Vector.
     * @param valueMap SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            Vector
     * @param unit Unit; the unit of the new Relative Sparse Mutable Double Vector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return Vector of the specified unit
     * @throws ValueRuntimeException when values is null
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>, V extends AbstractDoubleVector<U, S, V>> V create(
            final SortedMap<Integer, Double> valueMap, final U unit, final int length, final StorageType storageType)
            throws ValueRuntimeException
    {
        switch (storageType)
        {
            case DENSE:
            {
                double[] values = new double[length];
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
                double[] valuesSI = new double[non0];
                int index = 0;
                for (Integer key : valueMap.keySet())
                {
                    double si = zeroBasedScale ? valueMap.get(key) : scale.toStandardUnit(valueMap.get(key));
                    if (si != 0.0)
                    {
                        indices[index] = key;
                        valuesSI[index] = si;
                        index++;
                    }
                }
                return instantiate(new DoubleVectorDataSparse(valuesSI, indices, length), unit);
            }

            default:
                throw new ValueRuntimeException("Unknown data type in DoubleVectorData.instantiate: " + storageType);
        }
    }

}
