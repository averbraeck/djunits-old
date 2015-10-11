package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ForceUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Force;

/**
 * Mutable Force Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableForceVector extends MutableDoubleVector.Rel<ForceUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableForceVector(final ForceUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableForceVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract ForceVector immutable();

    /** {@inheritDoc} */
    public abstract MutableForceVector toDense();

    /** {@inheritDoc} */
    public abstract MutableForceVector toSparse();

    /**
     * Double Dense Relative Immutable Force class.
     */
    public static class Dense extends MutableForceVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Force Vector. An force is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Force Vector
         * @param unit U; the unit of the new Dense Immutable Force Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final ForceUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An force is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Force Vector
         * @param unit U; the unit of the new Relative Dense Immutable Force Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final ForceUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Force&gt;; the values of the Scalar Force entries in the new Relative Dense Immutable Force
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<ForceUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Force Vector. An force is always relative.
         * @param values Force[]; the values of the Scalar Force entries in the new Relative Dense Immutable Force Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Force[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Force Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final ForceUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final ForceVector immutable()
        {
            setCopyOnWrite(true);
            return new ForceVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableForceVector mutable()
        {
            setCopyOnWrite(true);
            final MutableForceVector.Dense result = new MutableForceVector.Dense(getData(), getUnit());
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
        public final MutableForceVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableForceVector toSparse()
        {
            return new MutableForceVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Force class.
     */
    public static class Sparse extends MutableForceVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Force Vector. An force is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Force Vector
         * @param unit ForceUnit; the unit of the new Relative Sparse Immutable Force Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final ForceUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Force Vector. An force is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Force
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<ForceUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Force Vector. An force is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Force Vector
         * @param unit U; the unit of the new Sparse Immutable Force Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final ForceUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Force Vector. An force is always relative.
         * @param values Force[]; the values of the Scalar Force entries in the new Relative Sparse Immutable Force Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Force[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Force Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final ForceUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final ForceVector immutable()
        {
            setCopyOnWrite(true);
            return new ForceVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableForceVector mutable()
        {
            setCopyOnWrite(true);
            final MutableForceVector.Sparse result = new MutableForceVector.Sparse(getData(), getUnit());
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
        public final MutableForceVector toDense()
        {
            return new MutableForceVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableForceVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Force get(final int index) throws ValueException
    {
        return (Force) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector copy()
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
    public final ForceVector plus(final ForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ForceVector minus(final ForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ForceVector times(final ForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ForceVector divide(final ForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ForceVector plus(final MutableForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ForceVector minus(final MutableForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ForceVector times(final MutableForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ForceVector divide(final MutableForceVector rel) throws ValueException
    {
        return ForceVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector abs()
    {
        return (MutableForceVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector acos()
    {
        return (MutableForceVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector asin()
    {
        return (MutableForceVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector atan()
    {
        return (MutableForceVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector cbrt()
    {
        return (MutableForceVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector ceil()
    {
        return (MutableForceVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector cos()
    {
        return (MutableForceVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector cosh()
    {
        return (MutableForceVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector exp()
    {
        return (MutableForceVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector expm1()
    {
        return (MutableForceVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector floor()
    {
        return (MutableForceVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector log()
    {
        return (MutableForceVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector log10()
    {
        return (MutableForceVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector log1p()
    {
        return (MutableForceVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector pow(final double x)
    {
        return (MutableForceVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector rint()
    {
        return (MutableForceVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector round()
    {
        return (MutableForceVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector signum()
    {
        return (MutableForceVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector sin()
    {
        return (MutableForceVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector sinh()
    {
        return (MutableForceVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector sqrt()
    {
        return (MutableForceVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector tan()
    {
        return (MutableForceVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector tanh()
    {
        return (MutableForceVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector toDegrees()
    {
        return (MutableForceVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector toRadians()
    {
        return (MutableForceVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector inv()
    {
        return (MutableForceVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector multiplyBy(final double constant)
    {
        return (MutableForceVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableForceVector divideBy(final double constant)
    {
        return (MutableForceVector) super.divideBy(constant);
    }

}
