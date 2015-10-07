package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.EnergyUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.Energy;

/**
 * Mutable Energy Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableEnergyVector extends MutableDoubleVector.Rel<EnergyUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableEnergyVector(final EnergyUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableEnergyVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract EnergyVector immutable();

    /** {@inheritDoc} */
    public abstract MutableEnergyVector toDense();

    /** {@inheritDoc} */
    public abstract MutableEnergyVector toSparse();

    /**
     * Double Dense Relative Immutable Energy class.
     */
    public static class Dense extends MutableEnergyVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Energy Vector. An energy is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Energy Vector
         * @param unit U; the unit of the new Dense Immutable Energy Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final EnergyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An energy is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Energy Vector
         * @param unit U; the unit of the new Relative Dense Immutable Energy Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final EnergyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Energy&gt;; the values of the Scalar Energy entries in the new Relative Dense Immutable Energy
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<EnergyUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Energy Vector. An energy is always relative.
         * @param values Energy[]; the values of the Scalar Energy entries in the new Relative Dense Immutable Energy Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Energy[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable Energy Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final EnergyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final EnergyVector immutable()
        {
            setCopyOnWrite(true);
            return new EnergyVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableEnergyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableEnergyVector.Dense result = new MutableEnergyVector.Dense(getData(), getUnit());
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
        public final MutableEnergyVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableEnergyVector toSparse()
        {
            return new MutableEnergyVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable Energy class.
     */
    public static class Sparse extends MutableEnergyVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Energy Vector. An energy is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Energy Vector
         * @param unit EnergyUnit; the unit of the new Relative Sparse Immutable Energy Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final EnergyUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Energy Vector. An energy is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Energy
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<EnergyUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Energy Vector. An energy is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Energy Vector
         * @param unit U; the unit of the new Sparse Immutable Energy Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final EnergyUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Energy Vector. An energy is always relative.
         * @param values Energy[]; the values of the Scalar Energy entries in the new Relative Sparse Immutable Energy Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Energy[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable Energy Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final EnergyUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final EnergyVector immutable()
        {
            setCopyOnWrite(true);
            return new EnergyVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableEnergyVector mutable()
        {
            setCopyOnWrite(true);
            final MutableEnergyVector.Sparse result = new MutableEnergyVector.Sparse(getData(), getUnit());
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
        public final MutableEnergyVector toDense()
        {
            return new MutableEnergyVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableEnergyVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final Energy get(final int index) throws ValueException
    {
        return (Energy) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector copy()
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
    public final EnergyVector plus(final EnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final EnergyVector minus(final EnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final EnergyVector times(final EnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final EnergyVector divide(final EnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final EnergyVector plus(final MutableEnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final EnergyVector minus(final MutableEnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final EnergyVector times(final MutableEnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final EnergyVector divide(final MutableEnergyVector rel) throws ValueException
    {
        return EnergyVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector abs()
    {
        return (MutableEnergyVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector acos()
    {
        return (MutableEnergyVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector asin()
    {
        return (MutableEnergyVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector atan()
    {
        return (MutableEnergyVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector cbrt()
    {
        return (MutableEnergyVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector ceil()
    {
        return (MutableEnergyVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector cos()
    {
        return (MutableEnergyVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector cosh()
    {
        return (MutableEnergyVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector exp()
    {
        return (MutableEnergyVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector expm1()
    {
        return (MutableEnergyVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector floor()
    {
        return (MutableEnergyVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector log()
    {
        return (MutableEnergyVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector log10()
    {
        return (MutableEnergyVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector log1p()
    {
        return (MutableEnergyVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector pow(final double x)
    {
        return (MutableEnergyVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector rint()
    {
        return (MutableEnergyVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector round()
    {
        return (MutableEnergyVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector signum()
    {
        return (MutableEnergyVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector sin()
    {
        return (MutableEnergyVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector sinh()
    {
        return (MutableEnergyVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector sqrt()
    {
        return (MutableEnergyVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector tan()
    {
        return (MutableEnergyVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector tanh()
    {
        return (MutableEnergyVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector toDegrees()
    {
        return (MutableEnergyVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector toRadians()
    {
        return (MutableEnergyVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector inv()
    {
        return (MutableEnergyVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector multiplyBy(final double constant)
    {
        return (MutableEnergyVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableEnergyVector divideBy(final double constant)
    {
        return (MutableEnergyVector) super.divideBy(constant);
    }

}
