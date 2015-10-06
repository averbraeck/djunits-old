package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.MassUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Mass;

/**
 * Mutable Mass Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableMassVector extends MutableDoubleVector.Rel<MassUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableMassVector(final MassUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableMassVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract MassVector immutable();

    /** {@inheritDoc} */
    public abstract MutableMassVector toDense();

    /** {@inheritDoc} */
    public abstract MutableMassVector toSparse();

    /**
     * Double Dense Relative Immutable Mass class.
     */
    public static class Dense extends MutableMassVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Mass Vector. An mass is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Mass Vector
         * @param unit U; the unit of the new Dense Immutable Mass Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final MassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An mass is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Mass Vector
         * @param unit U; the unit of the new Relative Dense Immutable Mass Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final MassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Mass&gt;; the values of the Scalar Mass entries in the new Relative Dense Immutable Mass Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<MassUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Mass Vector. An mass is always relative.
         * @param values Mass[]; the values of the Scalar Mass entries in the new Relative Dense Immutable Mass Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Mass[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Mass Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final MassUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MassVector immutable()
        {
            setCopyOnWrite(true);
            return new MassVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMassVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMassVector.Dense result = new MutableMassVector.Dense(getData(), getUnit());
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
        public final MutableMassVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMassVector toSparse()
        {
            return new MutableMassVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Mass class.
     */
    public static class Sparse extends MutableMassVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Mass Vector. An mass is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Mass Vector
         * @param unit MassUnit; the unit of the new Relative Sparse Immutable Mass Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final MassUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Mass Vector. An mass is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Mass Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<MassUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Mass Vector. An mass is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Mass Vector
         * @param unit U; the unit of the new Sparse Immutable Mass Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final MassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Mass Vector. An mass is always relative.
         * @param values Mass[]; the values of the Scalar Mass entries in the new Relative Sparse Immutable Mass Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Mass[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Mass Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final MassUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MassVector immutable()
        {
            setCopyOnWrite(true);
            return new MassVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMassVector mutable()
        {
            setCopyOnWrite(true);
            final MutableMassVector.Sparse result = new MutableMassVector.Sparse(getData(), getUnit());
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
        public final MutableMassVector toDense()
        {
            return new MutableMassVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableMassVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Mass get(final int index) throws ValueException
    {
        return (Mass) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector copy()
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
    public final MassVector plus(final MassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MassVector minus(final MassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MassVector times(final MassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MassVector divide(final MassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MassVector plus(final MutableMassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MassVector minus(final MutableMassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MassVector times(final MutableMassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final MassVector divide(final MutableMassVector rel) throws ValueException
    {
        return MassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector abs()
    {
        return (MutableMassVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector acos()
    {
        return (MutableMassVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector asin()
    {
        return (MutableMassVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector atan()
    {
        return (MutableMassVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector cbrt()
    {
        return (MutableMassVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector ceil()
    {
        return (MutableMassVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector cos()
    {
        return (MutableMassVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector cosh()
    {
        return (MutableMassVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector exp()
    {
        return (MutableMassVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector expm1()
    {
        return (MutableMassVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector floor()
    {
        return (MutableMassVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector log()
    {
        return (MutableMassVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector log10()
    {
        return (MutableMassVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector log1p()
    {
        return (MutableMassVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector pow(final double x)
    {
        return (MutableMassVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector rint()
    {
        return (MutableMassVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector round()
    {
        return (MutableMassVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector signum()
    {
        return (MutableMassVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector sin()
    {
        return (MutableMassVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector sinh()
    {
        return (MutableMassVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector sqrt()
    {
        return (MutableMassVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector tan()
    {
        return (MutableMassVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector tanh()
    {
        return (MutableMassVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector toDegrees()
    {
        return (MutableMassVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector toRadians()
    {
        return (MutableMassVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector inv()
    {
        return (MutableMassVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector multiplyBy(final double constant)
    {
        return (MutableMassVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableMassVector divideBy(final double constant)
    {
        return (MutableMassVector) super.divideBy(constant);
    }

}
