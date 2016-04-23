package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Angle;

/**
 * Immutable Relative Angle Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AngleVector extends TypedDoubleVectorRel<AngleUnit, AngleVector, MutableAngleVector, Angle>
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
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            AngleVector
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
    protected final MutableAngleVector instantiateMutableType(final DoubleVectorData dvd, final AngleUnit unit)
    {
        return new MutableAngleVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final Angle get(final int index) throws ValueException
    {
        return new Angle(getInUnit(index, getUnit()), getUnit());
    }

    /**
     * Translate the relative vector into an absolute vector (e.g., before or after a multiplication or division).
     * @return an absolute version of this relative Angle vector.
     */
    public final DirectionVector toAbs()
    {
        return new DirectionVector(getData(), getUnit());
    }

}
