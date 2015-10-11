package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.VolumeUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Volume;

/**
 * Mutable Volume Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableVolumeVector extends MutableDoubleVector.Rel<VolumeUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableVolumeVector(final VolumeUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableVolumeVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract VolumeVector immutable();

    /** {@inheritDoc} */
    public abstract MutableVolumeVector toDense();

    /** {@inheritDoc} */
    public abstract MutableVolumeVector toSparse();

    /**
     * Double Dense Relative Immutable Volume class.
     */
    public static class Dense extends MutableVolumeVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Volume Vector. An volume is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Volume Vector
         * @param unit U; the unit of the new Dense Immutable Volume Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final VolumeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An volume is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Volume Vector
         * @param unit U; the unit of the new Relative Dense Immutable Volume Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final VolumeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Volume&gt;; the values of the Scalar Volume entries in the new Relative Dense Immutable Volume
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<VolumeUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Volume Vector. An volume is always relative.
         * @param values Volume[]; the values of the Scalar Volume entries in the new Relative Dense Immutable Volume Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Volume[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Volume Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final VolumeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final VolumeVector immutable()
        {
            setCopyOnWrite(true);
            return new VolumeVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableVolumeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableVolumeVector.Dense result = new MutableVolumeVector.Dense(getData(), getUnit());
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
        public final MutableVolumeVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableVolumeVector toSparse()
        {
            return new MutableVolumeVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Volume class.
     */
    public static class Sparse extends MutableVolumeVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Volume Vector. An volume is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Volume Vector
         * @param unit VolumeUnit; the unit of the new Relative Sparse Immutable Volume Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final VolumeUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Volume Vector. An volume is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Volume
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<VolumeUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Volume Vector. An volume is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Volume Vector
         * @param unit U; the unit of the new Sparse Immutable Volume Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final VolumeUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Volume Vector. An volume is always relative.
         * @param values Volume[]; the values of the Scalar Volume entries in the new Relative Sparse Immutable Volume Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Volume[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Volume Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final VolumeUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final VolumeVector immutable()
        {
            setCopyOnWrite(true);
            return new VolumeVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableVolumeVector mutable()
        {
            setCopyOnWrite(true);
            final MutableVolumeVector.Sparse result = new MutableVolumeVector.Sparse(getData(), getUnit());
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
        public final MutableVolumeVector toDense()
        {
            return new MutableVolumeVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableVolumeVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Volume get(final int index) throws ValueException
    {
        return (Volume) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector copy()
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
    public final VolumeVector plus(final VolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final VolumeVector minus(final VolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final VolumeVector times(final VolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final VolumeVector divide(final VolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final VolumeVector plus(final MutableVolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final VolumeVector minus(final MutableVolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final VolumeVector times(final MutableVolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final VolumeVector divide(final MutableVolumeVector rel) throws ValueException
    {
        return VolumeVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector abs()
    {
        return (MutableVolumeVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector acos()
    {
        return (MutableVolumeVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector asin()
    {
        return (MutableVolumeVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector atan()
    {
        return (MutableVolumeVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector cbrt()
    {
        return (MutableVolumeVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector ceil()
    {
        return (MutableVolumeVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector cos()
    {
        return (MutableVolumeVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector cosh()
    {
        return (MutableVolumeVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector exp()
    {
        return (MutableVolumeVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector expm1()
    {
        return (MutableVolumeVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector floor()
    {
        return (MutableVolumeVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector log()
    {
        return (MutableVolumeVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector log10()
    {
        return (MutableVolumeVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector log1p()
    {
        return (MutableVolumeVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector pow(final double x)
    {
        return (MutableVolumeVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector rint()
    {
        return (MutableVolumeVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector round()
    {
        return (MutableVolumeVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector signum()
    {
        return (MutableVolumeVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector sin()
    {
        return (MutableVolumeVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector sinh()
    {
        return (MutableVolumeVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector sqrt()
    {
        return (MutableVolumeVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector tan()
    {
        return (MutableVolumeVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector tanh()
    {
        return (MutableVolumeVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector toDegrees()
    {
        return (MutableVolumeVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector toRadians()
    {
        return (MutableVolumeVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector inv()
    {
        return (MutableVolumeVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector multiplyBy(final double constant)
    {
        return (MutableVolumeVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableVolumeVector divideBy(final double constant)
    {
        return (MutableVolumeVector) super.divideBy(constant);
    }

}
