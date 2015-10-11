package org.djunits.value.vdouble.matrix;

import org.djunits.unit.Unit;
import org.djunits.value.Absolute;
import org.djunits.value.DenseData;
import org.djunits.value.Relative;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.ValueUtil;
import org.djunits.value.vdouble.DoubleFunction;
import org.djunits.value.vdouble.DoubleMathFunctions;
import org.djunits.value.vdouble.DoubleMathFunctionsImpl;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * MutableDoubleMatrix.
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version 26 jun, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> Unit; the unit of this MutableDoubleMatrix
 */
public abstract class MutableDoubleMatrix<U extends Unit<U>> extends DoubleMatrix<U> implements
    WriteDoubleMatrixFunctions<U>, DoubleMathFunctions<MutableDoubleMatrix<U>>
{
    /**  */
    private static final long serialVersionUID = 20151003L;

    /**
     * Construct a new MutableDoubleMatrix.
     * @param unit U; the unit of the new MutableDoubleMatrix
     */
    protected MutableDoubleMatrix(final U unit)
    {
        super(unit);
    }

    /** If set, any modification of the data must be preceded by replacing the data with a local copy. */
    private boolean copyOnWrite = false;

    /**
     * Retrieve the value of the copyOnWrite flag.
     * @return boolean
     */
    private boolean isCopyOnWrite()
    {
        return this.copyOnWrite;
    }

    /**
     * Change the copyOnWrite flag.
     * @param copyOnWrite boolean; the new value for the copyOnWrite flag
     */
    final void setCopyOnWrite(final boolean copyOnWrite)
    {
        this.copyOnWrite = copyOnWrite;
    }

    /** ============================================================================================ */
    /** ================================= ABSOLUTE IMPLEMENTATION ================================== */
    /** ============================================================================================ */

    /**
     * @param <U> Unit the unit for which this Matrix will be created
     */
    public abstract static class Abs<U extends Unit<U>> extends MutableDoubleMatrix<U> implements Absolute
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute MutableDoubleMatrix.
         * @param unit U; the unit of the new Absolute MutableDoubleMatrix
         */
        protected Abs(final U unit)
        {
            super(unit);
        }

        /**
         * ABSOLUTE DENSE implementation of MutableDoubleMatrix.
         * @param <U> Unit the unit for which this Matrix will be created
         */
        public static class Dense<U extends Unit<U>> extends Abs<U> implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Dense MutableDoubleMatrix.
             * @param values double[][]; the initial values of the entries in the new Absolute Dense MutableDoubleMatrix
             * @param unit U; the unit of the new Absolute Dense MutableDoubleMatrix
             * @throws ValueException when values is null, or is not rectangular
             */
            public Dense(final double[][] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense MutableDoubleMatrix.
             * @param values DoubleScalar.Abs&lt;U&gt;[][]; the initial values of the entries in the new Absolute Dense
             *            MutableDoubleMatrix
             * @throws ValueException when values has zero entries, or is not rectangular
             */
            public Dense(final DoubleScalar.Abs<U>[][] values) throws ValueException
            {
                super(checkNonEmpty(values)[0][0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Absolute Dense Mutable DoubleMatrix.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleMatrixDataDense data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final DoubleMatrix.Abs.Dense<U> immutable()
            {
                setCopyOnWrite(true);
                return new DoubleMatrix.Abs.Dense<U>(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Abs.Dense<U> mutable()
            {
                setCopyOnWrite(true);
                final MutableDoubleMatrix.Abs.Dense<U> result =
                    new MutableDoubleMatrix.Abs.Dense<U>(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Abs.Dense<U> copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleMatrixDataDense getData()
            {
                return (DoubleMatrixDataDense) this.data;
            }
        }

        /**
         * ABSOLUTE SPARSE implementation of MutableDoubleMatrix.
         * @param <U> Unit the unit for which this Matrix will be created
         */
        public static class Sparse<U extends Unit<U>> extends Abs<U> implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Absolute Sparse MutableDoubleMatrix.
             * @param values double[][]; the initial values of the entries in the new Absolute Sparse MutableDoubleMatrix
             * @param unit U; the unit of the new Absolute Sparse MutableDoubleMatrix
             * @throws ValueException when values is null, or is not rectangular
             */
            public Sparse(final double[][] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values);
            }

            /**
             * Construct a new Absolute Sparse MutableDoubleMatrix.
             * @param values DoubleScalar.Abs&lt;U&gt;[][]; the initial values of the entries in the new Absolute Sparse
             *            MutableDoubleMatrix
             * @throws ValueException when values has zero entries, or is not rectangular
             */
            public Sparse(final DoubleScalar.Abs<U>[][] values) throws ValueException
            {
                super(checkNonEmpty(values)[0][0].getUnit());
                this.data = initializeSparse(values);
            }

            /**
             * Construct a new Absolute Sparse Mutable DoubleMatrix.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleMatrixDataSparse data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final DoubleMatrix.Abs.Sparse<U> immutable()
            {
                setCopyOnWrite(true);
                return new DoubleMatrix.Abs.Sparse<U>(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Abs.Sparse<U> mutable()
            {
                setCopyOnWrite(true);
                final MutableDoubleMatrix.Abs.Sparse<U> result =
                    new MutableDoubleMatrix.Abs.Sparse<U>(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Abs.Sparse<U> copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleMatrixDataSparse getData()
            {
                return (DoubleMatrixDataSparse) this.data;
            }
        }

        /** {@inheritDoc} */
        @Override
        public final DoubleScalar.Abs<U> get(final int row, final int column) throws ValueException
        {
            return new DoubleScalar.Abs<U>(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Increment the value by the supplied value and return the result.
         * @param increment DoubleMatrix.Rel&lt;U&gt;; amount by which the value is incremented
         * @return MutableDoubleMatrix.Abs&lt;U&gt;
         * @throws ValueException when the size of increment is not identical to the size of this
         */
        public final MutableDoubleMatrix.Abs<U> incrementBy(final DoubleMatrix.Rel<U> increment) throws ValueException
        {
            return (MutableDoubleMatrix.Abs<U>) incrementByImpl(increment);
        }

        /**
         * Decrement the value by the supplied value and return the result.
         * @param decrement DoubleMatrix.Rel&lt;U&gt;; amount by which the value is decremented
         * @return MutableDoubleMatrix.Abs&lt;U&gt;
         * @throws ValueException when the size of increment is not identical to the size of this
         */
        public final MutableDoubleMatrix.Abs<U> decrementBy(final DoubleMatrix.Rel<U> decrement) throws ValueException
        {
            return (MutableDoubleMatrix.Abs<U>) decrementByImpl(decrement);
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> abs()
        {
            assign(DoubleMathFunctionsImpl.ABS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> acos()
        {
            assign(DoubleMathFunctionsImpl.ACOS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> asin()
        {
            assign(DoubleMathFunctionsImpl.ASIN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> atan()
        {
            assign(DoubleMathFunctionsImpl.ATAN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> cbrt()
        {
            assign(DoubleMathFunctionsImpl.CBRT);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> ceil()
        {
            assign(DoubleMathFunctionsImpl.CEIL);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> cos()
        {
            assign(DoubleMathFunctionsImpl.COS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> cosh()
        {
            assign(DoubleMathFunctionsImpl.COSH);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> exp()
        {
            assign(DoubleMathFunctionsImpl.EXP);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> expm1()
        {
            assign(DoubleMathFunctionsImpl.EXPM1);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> floor()
        {
            assign(DoubleMathFunctionsImpl.FLOOR);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> log()
        {
            assign(DoubleMathFunctionsImpl.LOG);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> log10()
        {
            assign(DoubleMathFunctionsImpl.LOG10);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> log1p()
        {
            assign(DoubleMathFunctionsImpl.LOG1P);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> pow(final double x)
        {
            assign(DoubleMathFunctionsImpl.POW(x));
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> rint()
        {
            assign(DoubleMathFunctionsImpl.RINT);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> round()
        {
            assign(DoubleMathFunctionsImpl.ROUND);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> signum()
        {
            assign(DoubleMathFunctionsImpl.SIGNUM);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> sin()
        {
            assign(DoubleMathFunctionsImpl.SIN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> sinh()
        {
            assign(DoubleMathFunctionsImpl.SINH);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> sqrt()
        {
            assign(DoubleMathFunctionsImpl.SQRT);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> tan()
        {
            assign(DoubleMathFunctionsImpl.TAN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> tanh()
        {
            assign(DoubleMathFunctionsImpl.TANH);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> toDegrees()
        {
            assign(DoubleMathFunctionsImpl.TO_DEGREES);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> toRadians()
        {
            assign(DoubleMathFunctionsImpl.TO_RADIANS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> inv()
        {
            assign(DoubleMathFunctionsImpl.INV);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> multiplyBy(final double constant)
        {
            assign(DoubleMathFunctionsImpl.MULT(constant));
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Abs<U> divideBy(final double constant)
        {
            assign(DoubleMathFunctionsImpl.DIV(constant));
            return this;
        }

    }

    /**
     * @param <U> Unit
     */
    public abstract static class Rel<U extends Unit<U>> extends MutableDoubleMatrix<U> implements Relative
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative MutableDoubleMatrix.
         * @param unit U; the unit of the new Relative MutableDoubleMatrix
         */
        protected Rel(final U unit)
        {
            super(unit);
        }

        /**
         * RELATIVE DENSE implementation of MutableDoubleMatrix.
         * @param <U> Unit the unit for which this Matrix will be created
         */
        public static class Dense<U extends Unit<U>> extends Rel<U> implements DenseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Relative Dense MutableDoubleMatrix.
             * @param values double[][]; the initial values of the entries in the new Relative Dense MutableDoubleMatrix
             * @param unit U; the unit of the new Relative Dense MutableDoubleMatrix
             * @throws ValueException when values is null, or is not rectangular
             */
            public Dense(final double[][] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense MutableDoubleMatrix.
             * @param values DoubleScalar.Rel&lt;U&gt;[][]; the initial values of the entries in the new Relative Dense
             *            MutableDoubleMatrix
             * @throws ValueException when values has zero entries, or is not rectangular
             */
            public Dense(final DoubleScalar.Rel<U>[][] values) throws ValueException
            {
                super(checkNonEmpty(values)[0][0].getUnit());
                this.data = initializeDense(values);
            }

            /**
             * Construct a new Relative Dense Mutable DoubleMatrix.
             * @param data an internal data object
             * @param unit the unit
             */
            Dense(final DoubleMatrixDataDense data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final DoubleMatrix.Rel.Dense<U> immutable()
            {
                setCopyOnWrite(true);
                return new DoubleMatrix.Rel.Dense<U>(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Rel.Dense<U> mutable()
            {
                setCopyOnWrite(true);
                final MutableDoubleMatrix.Rel.Dense<U> result =
                    new MutableDoubleMatrix.Rel.Dense<U>(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Rel.Dense<U> copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleMatrixDataDense getData()
            {
                return (DoubleMatrixDataDense) this.data;
            }
        }

        /**
         * RELATIVE SPARSE implementation of MutableDoubleMatrix.
         * @param <U> Unit the unit for which this Matrix will be created
         */
        public static class Sparse<U extends Unit<U>> extends Rel<U> implements SparseData
        {
            /**  */
            private static final long serialVersionUID = 20151003L;

            /**
             * Construct a new Relative Sparse MutableDoubleMatrix.
             * @param values double[][]; the initial values of the entries in the new Relative Sparse MutableDoubleMatrix
             * @param unit U; the unit of the new Relative Sparse MutableDoubleMatrix
             * @throws ValueException when values is null, or is not rectangular
             */
            public Sparse(final double[][] values, final U unit) throws ValueException
            {
                super(unit);
                this.data = initializeSparse(values);
            }

            /**
             * Construct a new Relative Sparse MutableDoubleMatrix.
             * @param values DoubleScalar.Rel&lt;U&gt;[][]; the initial values of the entries in the new Relative Sparse
             *            MutableDoubleMatrix
             * @throws ValueException when values has zero entries, or is not rectangular
             */
            public Sparse(final DoubleScalar.Rel<U>[][] values) throws ValueException
            {
                super(checkNonEmpty(values)[0][0].getUnit());
                this.data = initializeSparse(values);
            }

            /**
             * Construct a new Relative Sparse Mutable DoubleMatrix.
             * @param data an internal data object
             * @param unit the unit
             */
            Sparse(final DoubleMatrixDataSparse data, final U unit)
            {
                super(unit);
                this.data = data.copy();
            }

            /** {@inheritDoc} */
            @Override
            public final DoubleMatrix.Rel.Sparse<U> immutable()
            {
                setCopyOnWrite(true);
                return new DoubleMatrix.Rel.Sparse<U>(getData(), getUnit());
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Rel.Sparse<U> mutable()
            {
                setCopyOnWrite(true);
                final MutableDoubleMatrix.Rel.Sparse<U> result =
                    new MutableDoubleMatrix.Rel.Sparse<U>(getData(), getUnit());
                result.setCopyOnWrite(true);
                return result;
            }

            /** {@inheritDoc} */
            @Override
            public final MutableDoubleMatrix.Rel.Sparse<U> copy()
            {
                return mutable();
            }

            /** {@inheritDoc} */
            @Override
            protected final DoubleMatrixDataSparse getData()
            {
                return (DoubleMatrixDataSparse) this.data;
            }
        }

        /** {@inheritDoc} */
        @Override
        public final DoubleScalar.Rel<U> get(final int row, final int column) throws ValueException
        {
            return new DoubleScalar.Rel<U>(getInUnit(row, column, getUnit()), getUnit());
        }

        /**
         * Increment the value by the supplied value and return the result.
         * @param increment DoubleMatrix.Rel&lt;U&gt;; amount by which the value is incremented
         * @return MutableDoubleMatrix.Rel&lt;U&gt;
         * @throws ValueException when the size of increment is not identical to the size of this
         */
        public final MutableDoubleMatrix.Rel<U> incrementBy(final DoubleMatrix.Rel<U> increment) throws ValueException
        {
            return (MutableDoubleMatrix.Rel<U>) incrementByImpl(increment);
        }

        /**
         * Decrement the value by the supplied value and return the result.
         * @param decrement DoubleMatrix.Rel&lt;U&gt;; amount by which the value is decremented
         * @return MutableDoubleMatrix.Rel&lt;U&gt;
         * @throws ValueException when the size of increment is not identical to the size of this
         */
        public final MutableDoubleMatrix.Rel<U> decrementBy(final DoubleMatrix.Rel<U> decrement) throws ValueException
        {
            return (MutableDoubleMatrix.Rel<U>) decrementByImpl(decrement);
        }

        /**********************************************************************************/
        /********************************** MATH METHODS **********************************/
        /**********************************************************************************/

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> abs()
        {
            assign(DoubleMathFunctionsImpl.ABS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> acos()
        {
            assign(DoubleMathFunctionsImpl.ACOS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> asin()
        {
            assign(DoubleMathFunctionsImpl.ASIN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> atan()
        {
            assign(DoubleMathFunctionsImpl.ATAN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> cbrt()
        {
            assign(DoubleMathFunctionsImpl.CBRT);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> ceil()
        {
            assign(DoubleMathFunctionsImpl.CEIL);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> cos()
        {
            assign(DoubleMathFunctionsImpl.COS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> cosh()
        {
            assign(DoubleMathFunctionsImpl.COSH);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> exp()
        {
            assign(DoubleMathFunctionsImpl.EXP);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> expm1()
        {
            assign(DoubleMathFunctionsImpl.EXPM1);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> floor()
        {
            assign(DoubleMathFunctionsImpl.FLOOR);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> log()
        {
            assign(DoubleMathFunctionsImpl.LOG);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> log10()
        {
            assign(DoubleMathFunctionsImpl.LOG10);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> log1p()
        {
            assign(DoubleMathFunctionsImpl.LOG1P);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> pow(final double x)
        {
            assign(DoubleMathFunctionsImpl.POW(x));
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> rint()
        {
            assign(DoubleMathFunctionsImpl.RINT);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> round()
        {
            assign(DoubleMathFunctionsImpl.ROUND);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> signum()
        {
            assign(DoubleMathFunctionsImpl.SIGNUM);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> sin()
        {
            assign(DoubleMathFunctionsImpl.SIN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> sinh()
        {
            assign(DoubleMathFunctionsImpl.SINH);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> sqrt()
        {
            assign(DoubleMathFunctionsImpl.SQRT);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> tan()
        {
            assign(DoubleMathFunctionsImpl.TAN);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> tanh()
        {
            assign(DoubleMathFunctionsImpl.TANH);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> toDegrees()
        {
            assign(DoubleMathFunctionsImpl.TO_DEGREES);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> toRadians()
        {
            assign(DoubleMathFunctionsImpl.TO_RADIANS);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> inv()
        {
            assign(DoubleMathFunctionsImpl.INV);
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> multiplyBy(final double constant)
        {
            assign(DoubleMathFunctionsImpl.MULT(constant));
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableDoubleMatrix.Rel<U> divideBy(final double constant)
        {
            assign(DoubleMathFunctionsImpl.DIV(constant));
            return this;
        }

    }

    /**
     * Make (immutable) DoubleMatrix equivalent for any type of MutableDoubleMatrix.
     * @return DoubleMatrix&lt;U&gt;; immutable version of this DoubleMatrix
     */
    public abstract DoubleMatrix<U> immutable();

    /**
     * Check the copyOnWrite flag and, if it is set, make a deep copy of the data and clear the flag.
     */
    protected final void checkCopyOnWrite()
    {
        if (isCopyOnWrite())
        {
            this.data = this.data.copy();
            setCopyOnWrite(false);
        }
    }

    /** {@inheritDoc} */
    @Override
    public final void setSI(final int row, final int column, final double valueSI) throws ValueException
    {
        checkIndex(row, column);
        checkCopyOnWrite();
        safeSet(row, column, valueSI);
    }

    /** {@inheritDoc} */
    @Override
    public final void set(final int row, final int column, final DoubleScalar<U> value) throws ValueException
    {
        setSI(row, column, value.getSI());
    }

    /** {@inheritDoc} */
    @Override
    public final void setInUnit(final int row, final int column, final double value, final U valueUnit)
        throws ValueException
    {
        setSI(row, column, ValueUtil.expressAsSIUnit(value, valueUnit));
    }

    /**
     * Execute a function on a cell by cell basis. Note: because many functions have to act on zero cells or can generate cells
     * with a zero value, the functions have to be applied on a dense dataset which has to be transformed back to a dense
     * dataset if necessary.
     * @param doubleFunction the function to apply
     */
    public final void assign(final DoubleFunction doubleFunction)
    {
        checkCopyOnWrite();
        if (this.data instanceof DoubleMatrixDataDense)
        {
            ((DoubleMatrixDataDense) this.data).assign(doubleFunction);
        }
        else
        {
            DoubleMatrixDataDense dvmd = ((DoubleMatrixDataSparse) this.data).toDense();
            dvmd.assign(doubleFunction);
            this.data = dvmd.toSparse();
        }
    }

    /**********************************************************************************/
    /******************************* NON-STATIC METHODS *******************************/
    /**********************************************************************************/

    /**
     * Increment the values in this MutableDoubleMatrix by the corresponding values in a DoubleMatrix.
     * @param increment DoubleMatrix&lt;U&gt;; the values by which to increment the corresponding values in this
     *            MutableDoubleMatrix
     * @return MutableDoubleMatrix&lt;U&gt;; this modified MutableDoubleMatrix
     * @throws ValueException when the matrices do not have the same size
     */
    private MutableDoubleMatrix<U> incrementValueByValue(final DoubleMatrix<U> increment) throws ValueException
    {
        checkSizeAndCopyOnWrite(increment);
        for (int row = rows(); --row >= 0;)
        {
            for (int column = columns(); --column >= 0;)
            {
                safeSet(row, column, safeGet(row, column) + increment.safeGet(row, column));
            }
        }
        return this;
    }

    /**
     * Decrement the values in this MutableDoubleMatrix by the corresponding values in a DoubleMatrix.
     * @param decrement DoubleMatrix&lt;U&gt;; the values by which to decrement the corresponding values in this
     *            MutableDoubleMatrix
     * @return MutableDoubleMatrix&lt;U&gt;; this modified MutableDoubleMatrix
     * @throws ValueException when the matrices do not have the same size
     */
    private MutableDoubleMatrix<U> decrementValueByValue(final DoubleMatrix<U> decrement) throws ValueException
    {
        checkSizeAndCopyOnWrite(decrement);
        for (int row = rows(); --row >= 0;)
        {
            for (int column = columns(); --column >= 0;)
            {
                safeSet(row, column, safeGet(row, column) - decrement.safeGet(row, column));
            }
        }
        return this;
    }

    /**
     * Increment the values in this MutableDoubleMatrix by the corresponding values in a Relative DoubleMatrix. <br>
     * Only Relative values are allowed; adding an Absolute value to an Absolute value is not allowed. Adding an Absolute value
     * to an existing Relative value would require the result to become Absolute, which is a type change that is impossible. For
     * that operation use a static method.
     * @param rel DoubleMatrix.Rel&lt;U&gt;; the Relative DoubleMatrix
     * @return MutableDoubleMatrix&lt;U&gt;; this modified MutableDoubleMatrix
     * @throws ValueException when the matrices do not have the same size
     */
    protected final MutableDoubleMatrix<U> incrementByImpl(final DoubleMatrix.Rel<U> rel) throws ValueException
    {
        return incrementValueByValue(rel);
    }

    /**
     * Decrement the corresponding values of this Relative DoubleMatrix from the values of this MutableDoubleMatrix. <br>
     * Only Relative values are allowed; subtracting an Absolute value from a Relative value is not allowed. Subtracting an
     * Absolute value from an existing Absolute value would require the result to become Relative, which is a type change that
     * is impossible. For that operation use a static method.
     * @param rel DoubleMatrix.Rel&lt;U&gt;; the Relative DoubleMatrix
     * @return MutableDoubleMatrix&lt;U&gt;; this modified MutableDoubleMatrix
     * @throws ValueException when the matrices do not have the same size
     */
    protected final MutableDoubleMatrix<U> decrementByImpl(final DoubleMatrix.Rel<U> rel) throws ValueException
    {
        return decrementValueByValue(rel);
    }

    /**
     * Scale the values in this MutableDoubleMatrix by the corresponding values in a DoubleMatrix.
     * @param factor DoubleMatrix&lt;?&gt;; contains the values by which to scale the corresponding values in this
     *            MutableDoubleMatrix
     * @throws ValueException when the matrices do not have the same size
     */
    protected final void scaleValueByValue(final DoubleMatrix<?> factor) throws ValueException
    {
        checkSizeAndCopyOnWrite(factor);
        for (int row = rows(); --row >= 0;)
        {
            for (int column = columns(); --column >= 0;)
            {
                safeSet(row, column, safeGet(row, column) * factor.safeGet(row, column));
            }
        }
    }

    /**
     * Scale the values in this MutableDoubleMatrix by the corresponding values in a double array.
     * @param factor double[][]; contains the values by which to scale the corresponding values in this MutableDoubleMatrix
     * @return MutableDoubleMatrix&lt;U&gt;; this modified MutableDoubleMatrix
     * @throws ValueException when the matrix and the array do not have the same size
     */
    protected final MutableDoubleMatrix<U> scaleValueByValue(final double[][] factor) throws ValueException
    {
        checkSizeAndCopyOnWrite(factor);
        for (int row = rows(); --row >= 0;)
        {
            for (int column = columns(); --column >= 0;)
            {
                safeSet(row, column, safeGet(row, column) * factor[row][column]);
            }
        }
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public final void normalize() throws ValueException
    {
        double sum = zSum();
        if (0 == sum)
        {
            throw new ValueException("zSum is 0; cannot normalize");
        }
        checkCopyOnWrite();
        for (int row = rows(); --row >= 0;)
        {
            for (int column = columns(); --column >= 0;)
            {
                // TODO parallel divide by factor
                safeSet(row, column, safeGet(row, column) / sum);
            }
        }
    }

    /**
     * Check sizes and copy the data if the copyOnWrite flag is set.
     * @param other DoubleMatrix&lt;?&gt;; partner for the size check
     * @throws ValueException when the matrices do not have the same size
     */
    private void checkSizeAndCopyOnWrite(final DoubleMatrix<?> other) throws ValueException
    {
        checkSize(other);
        checkCopyOnWrite();
    }

    /**
     * Check sizes and copy the data if the copyOnWrite flag is set.
     * @param other double[][]; partner for the size check
     * @throws ValueException when the matrices do not have the same size
     */
    private void checkSizeAndCopyOnWrite(final double[][] other) throws ValueException
    {
        checkSize(other);
        checkCopyOnWrite();
    }

}
