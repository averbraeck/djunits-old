package org.djunits4.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import javax.annotation.Generated;

import org.djunits4.Throw;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.si.SIDimensions;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.ValueRuntimeException;
import org.djunits4.value.storage.StorageType;
import org.djunits4.value.vfloat.scalar.*;
import org.djunits4.value.vfloat.scalar.base.AbstractFloatScalarRel;
import org.djunits4.value.vfloat.vector.*;
import org.djunits4.value.vfloat.vector.base.AbstractFloatVectorRel;
import org.djunits4.value.vfloat.vector.base.FloatVector;
import org.djunits4.value.vfloat.vector.data.FloatVectorData;

/**
 * Easy access methods for the generic Relative SI FloatVector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
 * All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
@Generated(value = "GenerateDJUNIT")
public class FloatSIVector extends AbstractFloatVectorRel<SIUnit, SIScalar, FloatSIVector>
{
    /** */
    private static final long serialVersionUID = 20150901L;

    /**
     * Construct a new Relative FloatSIVector.
     * @param values float[]; the values of the entries in the new Relative FloatSIVector
     * @param unit SIUnit; the unit of the new Relative FloatSIVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return FloatSIVector; the FloatSIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static FloatSIVector create(final float[] values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new FloatSIVector(FloatVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative FloatSIVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative FloatSIVector
     * @param unit SIUnit; the unit of the new Relative FloatSIVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return FloatSIVector; the FloatSIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static FloatSIVector create(final List<Float> values, final SIUnit unit, final StorageType storageType)
            throws ValueRuntimeException
    {
        return new FloatSIVector(FloatVectorData.instantiate(values, unit.getScale(), storageType), unit);
    }

    /**
     * Construct a new Relative FloatSIVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse 
     *            FloatSIVector
     * @param unit SIUnit; the unit of the new Relative Sparse FloatSIVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @return FloatSIVector; the FloatSIVector of the given unit
     * @throws ValueRuntimeException when values is null
     */
    public static FloatSIVector create(final SortedMap<Integer, Float> values, final SIUnit unit, final int length,
            final StorageType storageType) throws ValueRuntimeException
    {
        return FloatVector.create(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit SIUnit; the unit
     */
    public FloatSIVector(final FloatVectorData data, final SIUnit unit)
    {
        super(data, unit);
    }

    /**
     * Return an array of SIScalar Scalars from this vector.
     * @return SIScalar[]; an array of SIScalar Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public SIScalar[] toArray()
    {
        SIScalar[] array = new SIScalar[size()];
        for (int i = 0; i < size(); i++)
        {
            try
            {
                array[i] = get(i);
            }
            catch (ValueRuntimeException exception)
            {
                throw new RuntimeException(exception);
            }
        }
        return array;
    }

    /**
     * Returns an FloatSIVector based on an array of values and the textual representation of the unit.
     * @param value float[]; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return FloatSIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final float[] value, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(value, "Error parsing FloatSIVector: value is null");
        Throw.whenNull(unitString, "Error parsing FloatSIVector: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FloatSIVector: empty unitString");
        Throw.whenNull(storageType, "Error parsing FloatSIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return FloatSIVector.create(value, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIVector with unit " + unitString);
    }

    /**
     * Returns an FloatSIVector based on an array of values and the textual representation of the unit.
     * @param valueList List&lt;Float&gt;; the values to use
     * @param unitString String; the textual representation of the unit
     * @param storageType StorageType; the storage type to use
     * @return FloatSIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final List<Float> valueList, final String unitString, final StorageType storageType)
    {
        Throw.whenNull(valueList, "Error parsing FloatSIVector: valueList is null");
        Throw.whenNull(unitString, "Error parsing FloatSIVector: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FloatSIVector: empty unitString");
        Throw.whenNull(storageType, "Error parsing FloatSIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return FloatSIVector.create(valueList, unit, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIVector with unit " + unitString);
    }

    /**
     * Returns an FloatSIVector based on a (sparse) map of values and the textual representation of the unit.
     * @param valueMap SortedMap&lt;Integer, Float&gt;; the values to use
     * @param unitString String; the textual representation of the unit
     * @param length int; the size of the vector
     * @param storageType StorageType; the storage type to use
     * @return FloatSIVector; the vector representation of the values in their unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static FloatSIVector of(final SortedMap<Integer, Float> valueMap, final String unitString, final int length,
            final StorageType storageType)
    {
        Throw.whenNull(valueMap, "Error parsing FloatSIVector: valueMap is null");
        Throw.whenNull(unitString, "Error parsing FloatSIVector: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing FloatSIVector: empty unitString");
        Throw.whenNull(storageType, "Error parsing FloatSIVector: storageType is null");
        try
        {
            SIUnit unit = Unit.lookupOrCreateUnitWithSIDimensions(SIDimensions.of(unitString));
            if (unit != null)
            {
                return FloatSIVector.create(valueMap, unit, length, storageType);
            }
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException("Error parsing SIUnit from " + unitString, exception);
        }
        throw new IllegalArgumentException("Error parsing FloatSIVector with unit " + unitString);
    }

    /**********************************************************************************/
    /******************************** 'CAST AS' METHODS *******************************/
    /**********************************************************************************/

    /**
     * Return the current vector transformed to a vector in the given unit. Of course the SI dimensionality has to match,
     * otherwise the vector cannot be transformed. The compiler will check the alignment between the return value and the unit.
     * @param displayUnit KU; the unit in which the vector needs to be expressed
     * @return K; the vector that has been transformed into the right vector type and unit
     */
    public final <U extends Unit<U>, S extends AbstractFloatScalarRel<U, S>,
            V extends AbstractFloatVectorRel<U, S, V>> V as(final U displayUnit)
    {
        Throw.when(!(getUnit().getUnitBase().getSiDimensions().equals(displayUnit.getUnitBase().getSiDimensions())),
                UnitRuntimeException.class, "FloatSIVector with unit %s cannot be converted to a vector with unit %s",
                getUnit(), displayUnit);
        V result = FloatVector.instantiate(this.data, displayUnit.getStandardUnit());
        result.setDisplayUnit(displayUnit);
        return result;
    }

    %%ASMETHODS%%
}
