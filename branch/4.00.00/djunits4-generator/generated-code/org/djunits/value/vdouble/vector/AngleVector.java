package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Relative Angle Vector.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AngleVector extends AbstractDoubleVectorRel<AngleUnit, AngleVector, MutableAngleVector, Angle>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Immutable Double AngleVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AngleVector
     * @param unit U; the unit of the new Relative Immutable Double AngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AngleVector(final double[] values, final AngleUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AngleVector
     * @param unit U; the unit of the new Relative Immutable Double AngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AngleVector(final List<Double> values, final AngleUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double AngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AngleVector(final Angle[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AngleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AngleVector(final List<Angle> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double AngleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AngleVector(final SortedMap<Integer, Angle> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AngleVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double AngleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AngleVector(final SortedMap<Integer, Double> values, final AngleUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleVector.
     * @param data an internal data object
     * @param unit the unit
     */
    AngleVector(final DoubleVectorData data, final AngleUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleVector instantiateType(final DoubleVectorData dvd, final AngleUnit unit)
    {
        return new AngleVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAngleVector
        instantiateMutableType(final DoubleVectorData dvd, final AngleUnit unit)
    {
        return new MutableAngleVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Angle instantiateScalar(final double value, final AngleUnit unit)
    {
        return new Angle(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final AngleVector toDense()
    {
        return this.data.isDense() ? (AngleVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleVector toSparse()
    {
        return this.data.isSparse() ? (AngleVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
        
    /**
     * Return an array of Angle Scalars from this vector.
     * @return Angle[]; an array of Angle Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Angle[] toArray()
    {
        Angle[] array = new Angle[size()];
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