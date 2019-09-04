package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.MathFunctionsDimensionless;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.DoubleMathFunctions;
import org.djunits.value.vdouble.scalar.Dimensionless;

/**
 * Mutable Double DimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class MutableDimensionlessVector extends
        AbstractMutableDoubleVectorRel<DimensionlessUnit, DimensionlessVector, MutableDimensionlessVector, Dimensionless>
        implements MathFunctionsDimensionless<MutableDimensionlessVector>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values double[]; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Double DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDimensionlessVector(final double[] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values List&lt;Double&gt;; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Double DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDimensionlessVector(final List<Double> values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values Dimensionless[]; the values of the entries in the new Relative Immutable Double DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDimensionlessVector(final Dimensionless[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values List&lt;Dimensionless&gt;; the values of the entries in the new Relative Immutable Double
     *            DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDimensionlessVector(final List<Dimensionless> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values SortedMap&lt;Integer, Dimensionless&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Double DimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableDimensionlessVector(final SortedMap<Integer, Dimensionless> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Double DimensionlessVector.
     * @param values SortedMap&lt;Integer, Double&gt;; the map of indexes to values of the Relative Sparse Mutable Double
     *            DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Sparse Mutable Double DimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableDimensionlessVector(final SortedMap<Integer, Double> values, final DimensionlessUnit unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data DoubleVectorData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    MutableDimensionlessVector(final DoubleVectorData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final DimensionlessVector instantiateType(final DoubleVectorData dvd, final DimensionlessUnit unit)
    {
        return new DimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableDimensionlessVector instantiateMutableType(final DoubleVectorData dvd, final DimensionlessUnit unit)
    {
        return new MutableDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final Dimensionless instantiateScalar(final double value, final DimensionlessUnit unit)
    {
        return new Dimensionless(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector toDense()
    {
        return this.data.isDense() ? (MutableDimensionlessVector) this : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector toSparse()
    {
        return this.data.isSparse() ? (MutableDimensionlessVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of Dimensionless Scalars from this vector.
     * @return Dimensionless[]; an array of Dimensionless Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public Dimensionless[] toArray()
    {
        Dimensionless[] array = new Dimensionless[size()];
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

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector acos()
    {
        assign(DoubleMathFunctions.ACOS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector asin()
    {
        assign(DoubleMathFunctions.ASIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector atan()
    {
        assign(DoubleMathFunctions.ATAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector cbrt()
    {
        assign(DoubleMathFunctions.CBRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector cos()
    {
        assign(DoubleMathFunctions.COS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector cosh()
    {
        assign(DoubleMathFunctions.COSH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector exp()
    {
        assign(DoubleMathFunctions.EXP);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector expm1()
    {
        assign(DoubleMathFunctions.EXPM1);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector log()
    {
        assign(DoubleMathFunctions.LOG);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector log10()
    {
        assign(DoubleMathFunctions.LOG10);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector log1p()
    {
        assign(DoubleMathFunctions.LOG1P);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector pow(final double x)
    {
        assign(DoubleMathFunctions.POW((float) x));
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector signum()
    {
        assign(DoubleMathFunctions.SIGNUM);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector sin()
    {
        assign(DoubleMathFunctions.SIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector sinh()
    {
        assign(DoubleMathFunctions.SINH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector sqrt()
    {
        assign(DoubleMathFunctions.SQRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector tan()
    {
        assign(DoubleMathFunctions.TAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector tanh()
    {
        assign(DoubleMathFunctions.TANH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableDimensionlessVector inv()
    {
        assign(DoubleMathFunctions.INV);
        return this;
    }

}
