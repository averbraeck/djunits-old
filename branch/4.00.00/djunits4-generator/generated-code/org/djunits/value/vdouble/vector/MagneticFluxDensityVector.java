package org.djunits4.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits4.unit.*;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.scalar.*;

/**
 * Immutable Double MagneticFluxDensityVector, a vector of values with a MagneticFluxDensityUnit. 
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MagneticFluxDensityVector extends
    AbstractDoubleVectorRel<MagneticFluxDensityUnit, MagneticFluxDensityVector, MutableMagneticFluxDensityVector, MagneticFluxDensity>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MagneticFluxDensityVector
     * @param unit U; the unit of the new Relative Immutable Double MagneticFluxDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MagneticFluxDensityVector(final double[] values, final MagneticFluxDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MagneticFluxDensityVector
     * @param unit U; the unit of the new Relative Immutable Double MagneticFluxDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MagneticFluxDensityVector(final List<Double> values, final MagneticFluxDensityUnit unit, final StorageType storageType)
        throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            MagneticFluxDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MagneticFluxDensityVector(final MagneticFluxDensity[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MagneticFluxDensityVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MagneticFluxDensityVector(final List<MagneticFluxDensity> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            MagneticFluxDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MagneticFluxDensityVector(final SortedMap<Integer, MagneticFluxDensity> values, final int length, final StorageType storageType)
        throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MagneticFluxDensityVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MagneticFluxDensityVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MagneticFluxDensityVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MagneticFluxDensityVector(final SortedMap<Integer, Double> values, final MagneticFluxDensityUnit unit, final int length,
        final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MagneticFluxDensityVector(final DoubleVectorData data, final MagneticFluxDensityUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxDensityVector instantiateType(final DoubleVectorData dvd, final MagneticFluxDensityUnit unit)
    {
        return new MagneticFluxDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMagneticFluxDensityVector instantiateMutableType(final DoubleVectorData dvd, final MagneticFluxDensityUnit unit)
    {
        return new MutableMagneticFluxDensityVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MagneticFluxDensity instantiateScalar(final double value, final MagneticFluxDensityUnit unit)
    {
        return new MagneticFluxDensity(value, unit);
    }
    
    /** {@inheritDoc} */
    @Override
    public final MagneticFluxDensityVector toDense()
    {
        return this.data.isDense() ? (MagneticFluxDensityVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MagneticFluxDensityVector toSparse()
    {
        return this.data.isSparse() ? (MagneticFluxDensityVector) this : instantiateType(this.data.toSparse(), getUnit());
    }
    
    /**
     * Return an array of MagneticFluxDensity Scalars from this vector.
     * @return MagneticFluxDensity[]; an array of MagneticFluxDensity Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public MagneticFluxDensity[] toArray()
    {
        MagneticFluxDensity[] array = new MagneticFluxDensity[size()];
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
