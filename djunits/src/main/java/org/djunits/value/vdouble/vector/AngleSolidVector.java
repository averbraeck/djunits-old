package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AngleSolid;

/**
 * Immutable Double AngleSolidVector, a vector of values with a AngleSolidUnit.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class AngleSolidVector
        extends AbstractDoubleVectorRel<AngleSolidUnit, AngleSolidVector, MutableAngleSolidVector, AngleSolid>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double AngleSolidVector
     * @param unit U; the unit of the new Relative Immutable Double AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AngleSolidVector(final double[] values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AngleSolidVector
     * @param unit U; the unit of the new Relative Immutable Double AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AngleSolidVector(final List<Double> values, final AngleSolidUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double
     *            AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AngleSolidVector(final AngleSolid[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values List; the values of the entries in the new Relative Immutable Double AngleSolidVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AngleSolidVector(final List<AngleSolid> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double
     *            AngleSolidVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public AngleSolidVector(final SortedMap<Integer, AngleSolid> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double AngleSolidVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double AngleSolidVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double AngleSolidVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public AngleSolidVector(final SortedMap<Integer, Double> values, final AngleSolidUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    AngleSolidVector(final DoubleVectorData data, final AngleSolidUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolidVector instantiateType(final DoubleVectorData dvd, final AngleSolidUnit unit)
    {
        return new AngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableAngleSolidVector instantiateMutableType(final DoubleVectorData dvd, final AngleSolidUnit unit)
    {
        return new MutableAngleSolidVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final AngleSolid instantiateScalar(final double value, final AngleSolidUnit unit)
    {
        return new AngleSolid(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolidVector toDense()
    {
        return this.data.isDense() ? (AngleSolidVector) this : instantiateType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final AngleSolidVector toSparse()
    {
        return this.data.isSparse() ? (AngleSolidVector) this : instantiateType(this.data.toSparse(), getUnit());
    }

}
