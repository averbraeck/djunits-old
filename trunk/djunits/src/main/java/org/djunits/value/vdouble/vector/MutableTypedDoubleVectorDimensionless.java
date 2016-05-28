package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsDimensionless;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.DoubleMathFunctions;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Relative Mutable typed Dimensionless Vector.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the vector type
 * @param <MR> the mutable vector type
 * @param <S> the scalar type
 */
abstract class MutableTypedDoubleVectorDimensionless<U extends Unit<U>, R extends TypedDoubleVectorRel<U, R, MR, S>, MR extends MutableTypedDoubleVectorDimensionless<U, R, MR, S>, S extends DoubleScalar.Rel<U>>
        extends MutableTypedDoubleVectorRel<U, R, MR, S> implements
        MathFunctionsDimensionless<MutableTypedDoubleVectorDimensionless<U, R, MR, S>>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values double[]; the values of the entries in the new Relative Mutable DoubleVector
     * @param unit U; the unit of the new Relative Mutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedDoubleVectorDimensionless(final double[] values, final U unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values List; the values of the entries in the new Relative Mutable DoubleVector
     * @param unit U; the unit of the new Relative Mutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedDoubleVectorDimensionless(final List<Double> values, final U unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedDoubleVectorDimensionless(final S[] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values List; the values of the entries in the new Relative Mutable DoubleVector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedDoubleVectorDimensionless(final List<S> values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Mutable DoubleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedDoubleVectorDimensionless(final SortedMap<Integer, S> values, final int length, final StorageType storageType)
            throws ValueException
    {
        super(values, length, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param values Map; the map of indexes to values of the Relative Sparse Mutable DoubleVector
     * @param unit U; the unit of the new Relative Sparse Mutable DoubleVector
     * @param length the size of the vector
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedDoubleVectorDimensionless(final SortedMap<Integer, Double> values, final U unit, final int length,
            final StorageType storageType) throws ValueException
    {
        super(values, unit, length, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleVector.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTypedDoubleVectorDimensionless(final DoubleVectorData data, final U unit)
    {
        super(data, unit);
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR acos()
    {
        assign(DoubleMathFunctions.ACOS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR asin()
    {
        assign(DoubleMathFunctions.ASIN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR atan()
    {
        assign(DoubleMathFunctions.ATAN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR cbrt()
    {
        assign(DoubleMathFunctions.CBRT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR cos()
    {
        assign(DoubleMathFunctions.COS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR cosh()
    {
        assign(DoubleMathFunctions.COSH);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR exp()
    {
        assign(DoubleMathFunctions.EXP);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR expm1()
    {
        assign(DoubleMathFunctions.EXPM1);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR log()
    {
        assign(DoubleMathFunctions.LOG);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR log10()
    {
        assign(DoubleMathFunctions.LOG10);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR log1p()
    {
        assign(DoubleMathFunctions.LOG1P);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR pow(final double x)
    {
        assign(DoubleMathFunctions.POW(x));
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR signum()
    {
        assign(DoubleMathFunctions.SIGNUM);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR sin()
    {
        assign(DoubleMathFunctions.SIN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR sinh()
    {
        assign(DoubleMathFunctions.SINH);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR sqrt()
    {
        assign(DoubleMathFunctions.SQRT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR tan()
    {
        assign(DoubleMathFunctions.TAN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR tanh()
    {
        assign(DoubleMathFunctions.TANH);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR inv()
    {
        assign(DoubleMathFunctions.INV);
        return (MR) this;
    }
}
