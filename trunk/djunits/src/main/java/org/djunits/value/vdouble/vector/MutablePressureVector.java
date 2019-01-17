package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.PressureUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Pressure;

/**
 * Mutable Double PressureVector, a vector of values with a PressureUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutablePressureVector
        extends AbstractMutableDoubleVectorRel<PressureUnit, PressureVector, MutablePressureVector, Pressure>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double PressureVector
     * @param unit PressureUnit; the unit of the new Relative Immutable Double PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePressureVector(final double[] values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double PressureVector
     * @param unit PressureUnit; the unit of the new Relative Immutable Double PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePressureVector(final List<Double> values, final PressureUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values Pressure[]; the values of the entries in the new Relative Immutable Double PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePressureVector(final Pressure[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values List&lt;Pressure&gt;; the values of the entries in the new Relative Immutable Double PressureVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePressureVector(final List<Pressure> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values SortedMap&lt;Integer, Pressure&gt;; the values of the entries in the new Relative Sparse Mutable Double
     *            PressureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutablePressureVector(final SortedMap<Integer, Pressure> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double PressureVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            PressureVector
     * @param unit PressureUnit; the unit of the new Relative Sparse Mutable Double PressureVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutablePressureVector(final SortedMap<Integer, Double> values, final PressureUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit PressureUnit; the unit
     */
    MutablePressureVector(final DoubleVectorData data, final PressureUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final PressureVector instantiateType(final DoubleVectorData dvd, final PressureUnit unit)
    {
        return new PressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutablePressureVector instantiateMutableType(final DoubleVectorData dvd, final PressureUnit unit)
    {
        return new MutablePressureVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Pressure instantiateScalar(final double value, final PressureUnit unit)
    {
        return new Pressure(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePressureVector toDense()
    {
        return this.data.isDense() ? (MutablePressureVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutablePressureVector toSparse()
    {
        return this.data.isSparse() ? (MutablePressureVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Pressure Scalars from this vector.
     * @return Pressure[]; an array of Pressure Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Pressure[] toArray()
    {
        Pressure[] array = new Pressure[size()];
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
