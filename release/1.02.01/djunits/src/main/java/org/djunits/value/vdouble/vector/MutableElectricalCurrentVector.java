package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.ElectricalCurrent;

/**
 * Mutable ElectricalCurrent Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableElectricalCurrentVector extends MutableDoubleVector.Rel<ElectricalCurrentUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableElectricalCurrentVector(final ElectricalCurrentUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableElectricalCurrentVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract ElectricalCurrentVector immutable();

    /** {@inheritDoc} */
    public abstract MutableElectricalCurrentVector toDense();

    /** {@inheritDoc} */
    public abstract MutableElectricalCurrentVector toSparse();

    /**
     * Double Dense Relative Immutable ElectricalCurrent class.
     */
    public static class Dense extends MutableElectricalCurrentVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double ElectricalCurrent Vector. An electricalcurrent is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double ElectricalCurrent Vector
         * @param unit U; the unit of the new Dense Immutable ElectricalCurrent Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final ElectricalCurrentUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An electricalcurrent is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable ElectricalCurrent Vector
         * @param unit U; the unit of the new Relative Dense Immutable ElectricalCurrent Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final ElectricalCurrentUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;ElectricalCurrent&gt;; the values of the Scalar ElectricalCurrent entries in the new Relative
         *            Dense Immutable ElectricalCurrent Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<ElectricalCurrentUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable ElectricalCurrent Vector. An electricalcurrent is always relative.
         * @param values ElectricalCurrent[]; the values of the Scalar ElectricalCurrent entries in the new Relative Dense
         *            Immutable ElectricalCurrent Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final ElectricalCurrent[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable ElectricalCurrent Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final ElectricalCurrentUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrentVector immutable()
        {
            setCopyOnWrite(true);
            return new ElectricalCurrentVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalCurrentVector mutable()
        {
            setCopyOnWrite(true);
            final MutableElectricalCurrentVector.Dense result =
                new MutableElectricalCurrentVector.Dense(getData(), getUnit());
            result.setCopyOnWrite(true);
            return result;
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataDense getData()
        {
            return (DoubleVectorDataDense) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalCurrentVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalCurrentVector toSparse()
        {
            return new MutableElectricalCurrentVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable ElectricalCurrent class.
     */
    public static class Sparse extends MutableElectricalCurrentVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable ElectricalCurrent Vector. An electricalcurrent is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable ElectricalCurrent Vector
         * @param unit ElectricalCurrentUnit; the unit of the new Relative Sparse Immutable ElectricalCurrent Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final ElectricalCurrentUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable ElectricalCurrent Vector. An electricalcurrent is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            ElectricalCurrent Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<ElectricalCurrentUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double ElectricalCurrent Vector. An electricalcurrent is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double ElectricalCurrent Vector
         * @param unit U; the unit of the new Sparse Immutable ElectricalCurrent Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final ElectricalCurrentUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable ElectricalCurrent Vector. An electricalcurrent is always relative.
         * @param values ElectricalCurrent[]; the values of the Scalar ElectricalCurrent entries in the new Relative Sparse
         *            Immutable ElectricalCurrent Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final ElectricalCurrent[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable ElectricalCurrent Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final ElectricalCurrentUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrentVector immutable()
        {
            setCopyOnWrite(true);
            return new ElectricalCurrentVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalCurrentVector mutable()
        {
            setCopyOnWrite(true);
            final MutableElectricalCurrentVector.Sparse result =
                new MutableElectricalCurrentVector.Sparse(getData(), getUnit());
            result.setCopyOnWrite(true);
            return result;
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataSparse getData()
        {
            return (DoubleVectorDataSparse) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalCurrentVector toDense()
        {
            return new MutableElectricalCurrentVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalCurrentVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final ElectricalCurrent get(final int index) throws ValueException
    {
        return (ElectricalCurrent) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector copy()
    {
        return mutable();
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector plus(final ElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector minus(final ElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector times(final ElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector divide(final ElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector plus(final MutableElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector minus(final MutableElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector times(final MutableElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalCurrentVector divide(final MutableElectricalCurrentVector rel) throws ValueException
    {
        return ElectricalCurrentVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector abs()
    {
        return (MutableElectricalCurrentVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector acos()
    {
        return (MutableElectricalCurrentVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector asin()
    {
        return (MutableElectricalCurrentVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector atan()
    {
        return (MutableElectricalCurrentVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector cbrt()
    {
        return (MutableElectricalCurrentVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector ceil()
    {
        return (MutableElectricalCurrentVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector cos()
    {
        return (MutableElectricalCurrentVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector cosh()
    {
        return (MutableElectricalCurrentVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector exp()
    {
        return (MutableElectricalCurrentVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector expm1()
    {
        return (MutableElectricalCurrentVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector floor()
    {
        return (MutableElectricalCurrentVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector log()
    {
        return (MutableElectricalCurrentVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector log10()
    {
        return (MutableElectricalCurrentVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector log1p()
    {
        return (MutableElectricalCurrentVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector pow(final double x)
    {
        return (MutableElectricalCurrentVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector rint()
    {
        return (MutableElectricalCurrentVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector round()
    {
        return (MutableElectricalCurrentVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector signum()
    {
        return (MutableElectricalCurrentVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector sin()
    {
        return (MutableElectricalCurrentVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector sinh()
    {
        return (MutableElectricalCurrentVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector sqrt()
    {
        return (MutableElectricalCurrentVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector tan()
    {
        return (MutableElectricalCurrentVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector tanh()
    {
        return (MutableElectricalCurrentVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector toDegrees()
    {
        return (MutableElectricalCurrentVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector toRadians()
    {
        return (MutableElectricalCurrentVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector inv()
    {
        return (MutableElectricalCurrentVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector multiplyBy(final double constant)
    {
        return (MutableElectricalCurrentVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalCurrentVector divideBy(final double constant)
    {
        return (MutableElectricalCurrentVector) super.divideBy(constant);
    }

}
