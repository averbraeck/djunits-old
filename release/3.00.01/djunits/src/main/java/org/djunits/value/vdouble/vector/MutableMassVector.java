package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MassUnit;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Mass;

/**
 * Mutable Double MassVector, a vector of values with a MassUnit.
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableMassVector extends AbstractMutableDoubleVectorRel<MassUnit, MassVector, MutableMassVector, Mass>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double MassVector
     * @param unit U; the unit of the new Relative Immutable Double MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMassVector(final double[] values, final MassUnit unit, final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MassVector
     * @param unit U; the unit of the new Relative Immutable Double MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMassVector(final List<Double> values, final MassUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Immutable Double MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMassVector(final Mass[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values List; the values of the entries in the new Relative Immutable Double MassVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMassVector(final List<Mass> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable Double MassVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableMassVector(final SortedMap<Integer, Mass> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double MassVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable Double MassVector
     * @param unit U; the unit of the new Relative Sparse Mutable Double MassVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableMassVector(final SortedMap<Integer, Double> values, final MassUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableMassVector(final DoubleVectorData data, final MassUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MassVector instantiateType(final DoubleVectorData dvd, final MassUnit unit)
    {
        return new MassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableMassVector instantiateMutableType(final DoubleVectorData dvd, final MassUnit unit)
    {
        return new MutableMassVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Mass instantiateScalar(final double value, final MassUnit unit)
    {
        return new Mass(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector toDense()
    {
        return this.data.isDense() ? (MutableMassVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector toSparse()
    {
        return this.data.isSparse() ? (MutableMassVector) this : instantiateMutableType(this.data.toSparse(), getUnit());
    }

}