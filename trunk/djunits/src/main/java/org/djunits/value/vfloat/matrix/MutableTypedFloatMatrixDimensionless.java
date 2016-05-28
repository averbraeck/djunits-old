package org.djunits.value.vfloat.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsDimensionless;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.FloatMathFunctions;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Relative Mutable typed Dimensionless Matrix.
 * <p>
 * Copyright (c) 2013-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the unit
 * @param <R> the matrix type
 * @param <MR> the mutable matrix type
 * @param <S> the scalar type
 */
abstract class MutableTypedFloatMatrixDimensionless<U extends Unit<U>, R extends TypedFloatMatrixRel<U, R, MR, S>, MR extends MutableTypedFloatMatrixDimensionless<U, R, MR, S>, S extends FloatScalar.Rel<U>>
        extends MutableTypedFloatMatrixRel<U, R, MR, S> implements
        MathFunctionsDimensionless<MutableTypedFloatMatrixDimensionless<U, R, MR, S>>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values float[]; the values of the entries in the new Relative Mutable FloatMatrix
     * @param unit U; the unit of the new Relative Mutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedFloatMatrixDimensionless(final float[][] values, final U unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable FloatMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedFloatMatrixDimensionless(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * Construct a new Relative Mutable FloatMatrix.
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTypedFloatMatrixDimensionless(final FloatMatrixData data, final U unit)
    {
        super(data, unit);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR acos()
    {
        assign(FloatMathFunctions.ACOS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR asin()
    {
        assign(FloatMathFunctions.ASIN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR atan()
    {
        assign(FloatMathFunctions.ATAN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR cbrt()
    {
        assign(FloatMathFunctions.CBRT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR cos()
    {
        assign(FloatMathFunctions.COS);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR cosh()
    {
        assign(FloatMathFunctions.COSH);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR exp()
    {
        assign(FloatMathFunctions.EXP);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR expm1()
    {
        assign(FloatMathFunctions.EXPM1);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR log()
    {
        assign(FloatMathFunctions.LOG);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR log10()
    {
        assign(FloatMathFunctions.LOG10);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR log1p()
    {
        assign(FloatMathFunctions.LOG1P);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR pow(final double x)
    {
        assign(FloatMathFunctions.POW((float) x));
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR signum()
    {
        assign(FloatMathFunctions.SIGNUM);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR sin()
    {
        assign(FloatMathFunctions.SIN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR sinh()
    {
        assign(FloatMathFunctions.SINH);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR sqrt()
    {
        assign(FloatMathFunctions.SQRT);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR tan()
    {
        assign(FloatMathFunctions.TAN);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR tanh()
    {
        assign(FloatMathFunctions.TANH);
        return (MR) this;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public final MR inv()
    {
        assign(FloatMathFunctions.INV);
        return (MR) this;
    }
}
