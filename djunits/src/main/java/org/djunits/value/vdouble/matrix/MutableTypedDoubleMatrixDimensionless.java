package org.djunits.value.vdouble.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.MathFunctionsDimensionless;
import org.djunits.value.StorageType;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.DoubleMathFunctions;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Relative Mutable typed Matrix.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
abstract class MutableTypedDoubleMatrixDimensionless<U extends Unit<U>, R extends TypedDoubleMatrixRel<U, R, MR, S>, MR extends MutableTypedDoubleMatrixDimensionless<U, R, MR, S>, S extends DoubleScalar.Rel<U>>
        extends MutableTypedDoubleMatrixRel<U, R, MR, S> implements
        MathFunctionsDimensionless<MutableTypedDoubleMatrixDimensionless<U, R, MR, S>>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values double[]; the values of the entries in the new Relative Mutable DoubleMatrix
     * @param unit U; the unit of the new Relative Mutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values is null
     */
    MutableTypedDoubleMatrixDimensionless(final double[][] values, final U unit, final StorageType storageType)
            throws ValueException
    {
        super(values, unit, storageType);
    }

    /**
     * Construct a new Relative Mutable DoubleMatrix.
     * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Mutable DoubleMatrix
     * @param storageType the data type to use (e.g., DENSE or SPARSE)
     * @throws ValueException when values has zero entries
     */
    MutableTypedDoubleMatrixDimensionless(final S[][] values, final StorageType storageType) throws ValueException
    {
        super(values, storageType);
    }

    /**
     * @param data an internal data object
     * @param unit the unit
     */
    MutableTypedDoubleMatrixDimensionless(final DoubleMatrixData data, final U unit)
    {
        super(data, unit);
    }

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
