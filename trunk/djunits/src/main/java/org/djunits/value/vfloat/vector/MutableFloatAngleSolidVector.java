package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAngleSolid;

/**
 * Mutable Float AngleSolidVector, a vector of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatAngleSolidVector extends
        AbstractMutableFloatVectorRel<AngleSolidUnit, FloatAngleSolidVector, MutableFloatAngleSolidVector, FloatAngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float AngleSolidVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float AngleSolidVector
     * @param unit U; the unit of the new Relative Immutable Float AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleSolidVector(final float[] values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AngleSolidVector.
     * @param values List; the values of the entries in the new Relative Immutable Float AngleSolidVector
     * @param unit U; the unit of the new Relative Immutable Float AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleSolidVector(final List<Float> values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AngleSolidVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleSolidVector(final FloatAngleSolid[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AngleSolidVector.
     * @param values List; the values of the entries in the new Relative Immutable Float AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleSolidVector(final List<FloatAngleSolid> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AngleSolidVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float
     *            AngleSolidVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatAngleSolidVector(final SortedMap<Integer, FloatAngleSolid> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float AngleSolidVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float AngleSolidVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float AngleSolidVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatAngleSolidVector(final SortedMap<Integer, Float> values, final AngleSolidUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatAngleSolidVector(final FloatVectorData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolidVector instantiateType(final FloatVectorData dvd, final AngleSolidUnit unit)
    {
        return new FloatAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatAngleSolidVector instantiateMutableType(final FloatVectorData dvd, final AngleSolidUnit unit)
    {
        return new MutableFloatAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatAngleSolid instantiateScalar(final float value, final AngleSolidUnit unit)
    {
        return new FloatAngleSolid(value, unit);
    }

    /**
     * Create a dense version of this FloatVector.
     * @return the dense version of this FloatVector
     */
    public final MutableFloatAngleSolidVector toDense()
    {
        return this.data.isDense() ? (MutableFloatAngleSolidVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /**
     * Create a sparse version of this FloatVector.
     * @return the sparse version of this FloatVector
     */
    public final MutableFloatAngleSolidVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatAngleSolidVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
