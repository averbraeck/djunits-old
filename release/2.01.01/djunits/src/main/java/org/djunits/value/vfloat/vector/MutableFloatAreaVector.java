package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AreaUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatArea;

/**
 * Mutable Float AreaVector, a vector of values with a AreaUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAreaVector
        extends AbstractMutableFloatVectorRel<AreaUnit, FloatAreaVector, MutableFloatAreaVector, FloatArea>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float AreaVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float AreaVector
     * @param unit U; the unit of the new Relative Immutable Float AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAreaVector(final float[] values, final AreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AreaVector.
     * @param values List; the values of the entries in the new Relative Immutable Float AreaVector
     * @param unit U; the unit of the new Relative Immutable Float AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAreaVector(final List<Float> values, final AreaUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AreaVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAreaVector(final FloatArea[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AreaVector.
     * @param values List; the values of the entries in the new Relative Immutable Float AreaVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAreaVector(final List<FloatArea> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AreaVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float AreaVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAreaVector(final SortedMap<Integer, FloatArea> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AreaVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float AreaVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float AreaVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAreaVector(final SortedMap<Integer, Float> values, final AreaUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatAreaVector(final FloatVectorData data, final AreaUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAreaVector instantiateType(final FloatVectorData dvd, final AreaUnit unit)
    {
        return new FloatAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAreaVector instantiateMutableType(final FloatVectorData dvd, final AreaUnit unit)
    {
        return new MutableFloatAreaVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatArea instantiateScalar(final float value, final AreaUnit unit)
    {
        return new FloatArea(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAreaVector toDense()
    {
        return this.data.isDense() ? (MutableFloatAreaVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatAreaVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatAreaVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
