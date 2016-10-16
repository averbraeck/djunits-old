package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatMass;

/**
 * Mutable Float MassVector, a vector of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatMassVector
        extends AbstractMutableFloatVectorRel<MassUnit, FloatMassVector, MutableFloatMassVector, FloatMass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float MassVector
     * @param unit U; the unit of the new Relative Immutable Float MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMassVector(final float[] values, final MassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MassVector
     * @param unit U; the unit of the new Relative Immutable Float MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMassVector(final List<Float> values, final MassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Float MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMassVector(final FloatMass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values List; the values of the entries in the new Relative Immutable Float MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMassVector(final List<FloatMass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Float MassVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatMassVector(final SortedMap<Integer, FloatMass> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float MassVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Float MassVector
     * @param unit U; the unit of the new Relative Sparse Mutable Float MassVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatMassVector(final SortedMap<Integer, Float> values, final MassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableFloatMassVector(final FloatVectorData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMassVector instantiateType(final FloatVectorData dvd, final MassUnit unit)
    {
        return new FloatMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatMassVector instantiateMutableType(final FloatVectorData dvd, final MassUnit unit)
    {
        return new MutableFloatMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatMass instantiateScalar(final float value, final MassUnit unit)
    {
        return new FloatMass(value, unit);
    }

    /**
     * Create a dense version of this FloatVector.
     * @return the dense version of this FloatVector
     */
    public final MutableFloatMassVector toDense()
    {
        return this.data.isDense() ? (MutableFloatMassVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /**
     * Create a sparse version of this FloatVector.
     * @return the sparse version of this FloatVector
     */
    public final MutableFloatMassVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatMassVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}
