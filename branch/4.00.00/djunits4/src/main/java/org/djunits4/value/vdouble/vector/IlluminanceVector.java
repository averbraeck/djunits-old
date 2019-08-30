package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.IlluminanceUnit;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.Illuminance;

/**
 * Immutable Double IlluminanceVector, a vector of values with a IlluminanceUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class IlluminanceVector
        extends AbstractDoubleVectorRel<IlluminanceUnit, IlluminanceVector, MutableIlluminanceVector, Illuminance>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double IlluminanceVector
     * @param unit U; the unit of the new Relative Immutable Double IlluminanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public IlluminanceVector(final double[] values, final IlluminanceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double IlluminanceVector
     * @param unit U; the unit of the new Relative Immutable Double IlluminanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public IlluminanceVector(final List<Double> values, final IlluminanceUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            IlluminanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public IlluminanceVector(final Illuminance[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values List; the values of the entries in the new Relative Immutable Double IlluminanceVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public IlluminanceVector(final List<Illuminance> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            IlluminanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public IlluminanceVector(final SortedMap<Integer, Illuminance> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double IlluminanceVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double IlluminanceVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double IlluminanceVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public IlluminanceVector(final SortedMap<Integer, Double> values, final IlluminanceUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    IlluminanceVector(final DoubleVectorData data, final IlluminanceUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final IlluminanceVector instantiateType(final DoubleVectorData dvd, final IlluminanceUnit unit)
    {
        return new IlluminanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableIlluminanceVector instantiateMutableType(final DoubleVectorData dvd, final IlluminanceUnit unit)
    {
        return new MutableIlluminanceVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Illuminance instantiateScalar(final double value, final IlluminanceUnit unit)
    {
        return new Illuminance(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final IlluminanceVector toDense()
    {
        return this.data.isDense() ? (IlluminanceVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final IlluminanceVector toSparse()
    {
        return this.data.isSparse() ? (IlluminanceVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Illuminance Scalars from this vector.
     * @return Illuminance[]; an array of Illuminance Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Illuminance[] toArray()
    {
        Illuminance[] array = new Illuminance[size()];
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
