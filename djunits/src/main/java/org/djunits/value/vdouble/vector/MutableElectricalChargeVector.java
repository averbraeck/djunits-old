package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.ElectricalCharge;

/**
 * Mutable ElectricalCharge Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableElectricalChargeVector extends MutableDoubleVector.Rel<ElectricalChargeUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableElectricalChargeVector(final ElectricalChargeUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableElectricalChargeVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract ElectricalChargeVector immutable();

    /** {@inheritDoc} */
    public abstract MutableElectricalChargeVector toDense();

    /** {@inheritDoc} */
    public abstract MutableElectricalChargeVector toSparse();

    /**
     * Double Dense Relative Immutable ElectricalCharge class.
     */
    public static class Dense extends MutableElectricalChargeVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double ElectricalCharge Vector. An electricalcharge is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double ElectricalCharge Vector
         * @param unit U; the unit of the new Dense Immutable ElectricalCharge Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final ElectricalChargeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An electricalcharge is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable ElectricalCharge Vector
         * @param unit U; the unit of the new Relative Dense Immutable ElectricalCharge Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final ElectricalChargeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;ElectricalCharge&gt;; the values of the Scalar ElectricalCharge entries in the new Relative
         *            Dense Immutable ElectricalCharge Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<ElectricalChargeUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable ElectricalCharge Vector. An electricalcharge is always relative.
         * @param values ElectricalCharge[]; the values of the Scalar ElectricalCharge entries in the new Relative Dense
         *            Immutable ElectricalCharge Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final ElectricalCharge[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable ElectricalCharge Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final ElectricalChargeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalChargeVector immutable()
        {
            setCopyOnWrite(true);
            return new ElectricalChargeVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalChargeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableElectricalChargeVector.Dense result =
                new MutableElectricalChargeVector.Dense(getData(), getUnit());
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
        public final MutableElectricalChargeVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalChargeVector toSparse()
        {
            return new MutableElectricalChargeVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable ElectricalCharge class.
     */
    public static class Sparse extends MutableElectricalChargeVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable ElectricalCharge Vector. An electricalcharge is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable ElectricalCharge Vector
         * @param unit ElectricalChargeUnit; the unit of the new Relative Sparse Immutable ElectricalCharge Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final ElectricalChargeUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable ElectricalCharge Vector. An electricalcharge is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            ElectricalCharge Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<ElectricalChargeUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double ElectricalCharge Vector. An electricalcharge is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double ElectricalCharge Vector
         * @param unit U; the unit of the new Sparse Immutable ElectricalCharge Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final ElectricalChargeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable ElectricalCharge Vector. An electricalcharge is always relative.
         * @param values ElectricalCharge[]; the values of the Scalar ElectricalCharge entries in the new Relative Sparse
         *            Immutable ElectricalCharge Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final ElectricalCharge[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable ElectricalCharge Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final ElectricalChargeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalChargeVector immutable()
        {
            setCopyOnWrite(true);
            return new ElectricalChargeVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalChargeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableElectricalChargeVector.Sparse result =
                new MutableElectricalChargeVector.Sparse(getData(), getUnit());
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
        public final MutableElectricalChargeVector toDense()
        {
            return new MutableElectricalChargeVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalChargeVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final ElectricalCharge get(final int index) throws ValueException
    {
        return (ElectricalCharge) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector copy()
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
    public final ElectricalChargeVector plus(final ElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalChargeVector minus(final ElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalChargeVector times(final ElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalChargeVector divide(final ElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalChargeVector plus(final MutableElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalChargeVector minus(final MutableElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalChargeVector times(final MutableElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalChargeVector divide(final MutableElectricalChargeVector rel) throws ValueException
    {
        return ElectricalChargeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector abs()
    {
        return (MutableElectricalChargeVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector acos()
    {
        return (MutableElectricalChargeVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector asin()
    {
        return (MutableElectricalChargeVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector atan()
    {
        return (MutableElectricalChargeVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector cbrt()
    {
        return (MutableElectricalChargeVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector ceil()
    {
        return (MutableElectricalChargeVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector cos()
    {
        return (MutableElectricalChargeVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector cosh()
    {
        return (MutableElectricalChargeVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector exp()
    {
        return (MutableElectricalChargeVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector expm1()
    {
        return (MutableElectricalChargeVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector floor()
    {
        return (MutableElectricalChargeVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector log()
    {
        return (MutableElectricalChargeVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector log10()
    {
        return (MutableElectricalChargeVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector log1p()
    {
        return (MutableElectricalChargeVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector pow(final double x)
    {
        return (MutableElectricalChargeVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector rint()
    {
        return (MutableElectricalChargeVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector round()
    {
        return (MutableElectricalChargeVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector signum()
    {
        return (MutableElectricalChargeVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector sin()
    {
        return (MutableElectricalChargeVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector sinh()
    {
        return (MutableElectricalChargeVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector sqrt()
    {
        return (MutableElectricalChargeVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector tan()
    {
        return (MutableElectricalChargeVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector tanh()
    {
        return (MutableElectricalChargeVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector toDegrees()
    {
        return (MutableElectricalChargeVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector toRadians()
    {
        return (MutableElectricalChargeVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector inv()
    {
        return (MutableElectricalChargeVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector multiplyBy(final double constant)
    {
        return (MutableElectricalChargeVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableElectricalChargeVector divideBy(final double constant)
    {
        return (MutableElectricalChargeVector) super.divideBy(constant);
    }

}
