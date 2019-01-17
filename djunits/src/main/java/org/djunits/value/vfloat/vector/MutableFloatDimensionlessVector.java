package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.value.MathFunctionsDimensionless;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.FloatMathFunctions;
import org.djunits.value.vfloat.scalar.FloatDimensionless;

/**
 * Mutable Float DimensionlessVector, a vector of values with a DimensionlessUnit.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 9, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class MutableFloatDimensionlessVector extends AbstractMutableFloatVectorRel<DimensionlessUnit, FloatDimensionlessVector,
        MutableFloatDimensionlessVector, FloatDimensionless>
        implements MathFunctionsDimensionless<MutableFloatDimensionlessVector>
{
    /** */
    private static final long serialVersionUID = 20151109L;

    /**
     * Construct a new Relative Immutable Float DimensionlessVector.
     * @param values float[]; the values of the entries in the new Relative Immutable Float DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Float DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDimensionlessVector(final float[] values, final DimensionlessUnit unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DimensionlessVector.
     * @param values List&lt;Float&gt;; the values of the entries in the new Relative Immutable Float DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Immutable Float DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDimensionlessVector(final List<Float> values, final DimensionlessUnit unit,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DimensionlessVector.
     * @param values FloatDimensionless[]; the values of the entries in the new Relative Immutable Float DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDimensionlessVector(final FloatDimensionless[] values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DimensionlessVector.
     * @param values List&lt;FloatDimensionless&gt;; the values of the entries in the new Relative Immutable Float
     *            DimensionlessVector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDimensionlessVector(final List<FloatDimensionless> values, final StorageType storageType)
            throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DimensionlessVector.
     * @param values SortedMap&lt;Integer, FloatDimensionless&gt;; the values of the entries in the new Relative Sparse Mutable
     *            Float DimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    public MutableFloatDimensionlessVector(final SortedMap<Integer, FloatDimensionless> values, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Immutable Float DimensionlessVector.
     * @param values SortedMap&lt;Integer, Float&gt;; the map of indexes to values of the Relative Sparse Mutable Float
     *            DimensionlessVector
     * @param unit DimensionlessUnit; the unit of the new Relative Sparse Mutable Float DimensionlessVector
     * @param length int; the size of the vector
     * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    public MutableFloatDimensionlessVector(final SortedMap<Integer, Float> values, final DimensionlessUnit unit,
            final int length, final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * @param data FloatVectorData; an internal data object
     * @param unit DimensionlessUnit; the unit
     */
    MutableFloatDimensionlessVector(final FloatVectorData data, final DimensionlessUnit unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionlessVector instantiateType(final FloatVectorData dvd, final DimensionlessUnit unit)
    {
        return new FloatDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final MutableFloatDimensionlessVector instantiateMutableType(final FloatVectorData dvd,
            final DimensionlessUnit unit)
    {
        return new MutableFloatDimensionlessVector(dvd, unit);
    }

    /** {@inheritDoc} */
    @Override
    protected final FloatDimensionless instantiateScalar(final float value, final DimensionlessUnit unit)
    {
        return new FloatDimensionless(value, unit);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector toDense()
    {
        return this.data.isDense() ? (MutableFloatDimensionlessVector) this
                : instantiateMutableType(this.data.toDense(), getUnit());
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector toSparse()
    {
        return this.data.isSparse() ? (MutableFloatDimensionlessVector) this
                : instantiateMutableType(this.data.toSparse(), getUnit());
    }

    /**
     * Return an array of FloatDimensionless Scalars from this vector.
     * @return FloatDimensionless[]; an array of FloatDimensionless Scalars from this vector
     * @throws RuntimeException wrapping a ValueException on error getting one of the values
     */
    public FloatDimensionless[] toArray()
    {
        FloatDimensionless[] array = new FloatDimensionless[size()];
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
    public final MutableFloatDimensionlessVector acos()
    {
        assign(FloatMathFunctions.ACOS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector asin()
    {
        assign(FloatMathFunctions.ASIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector atan()
    {
        assign(FloatMathFunctions.ATAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector cbrt()
    {
        assign(FloatMathFunctions.CBRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector cos()
    {
        assign(FloatMathFunctions.COS);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector cosh()
    {
        assign(FloatMathFunctions.COSH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector exp()
    {
        assign(FloatMathFunctions.EXP);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector expm1()
    {
        assign(FloatMathFunctions.EXPM1);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector log()
    {
        assign(FloatMathFunctions.LOG);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector log10()
    {
        assign(FloatMathFunctions.LOG10);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector log1p()
    {
        assign(FloatMathFunctions.LOG1P);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector pow(final double x)
    {
        assign(FloatMathFunctions.POW((float) x));
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector signum()
    {
        assign(FloatMathFunctions.SIGNUM);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector sin()
    {
        assign(FloatMathFunctions.SIN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector sinh()
    {
        assign(FloatMathFunctions.SINH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector sqrt()
    {
        assign(FloatMathFunctions.SQRT);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector tan()
    {
        assign(FloatMathFunctions.TAN);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector tanh()
    {
        assign(FloatMathFunctions.TANH);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFloatDimensionlessVector inv()
    {
        assign(FloatMathFunctions.INV);
        return this;
    }

}
