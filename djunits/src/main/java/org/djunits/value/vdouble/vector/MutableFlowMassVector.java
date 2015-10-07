package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.FlowMassUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.FlowMass;

/**
 * Mutable FlowMass Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableFlowMassVector extends MutableDoubleVector.Rel<FlowMassUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableFlowMassVector(final FlowMassUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableFlowMassVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract FlowMassVector immutable();

    /** {@inheritDoc} */
    public abstract MutableFlowMassVector toDense();

    /** {@inheritDoc} */
    public abstract MutableFlowMassVector toSparse();

    /**
     * Double Dense Relative Immutable FlowMass class.
     */
    public static class Dense extends MutableFlowMassVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double FlowMass Vector. An flowmass is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double FlowMass Vector
         * @param unit U; the unit of the new Dense Immutable FlowMass Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final FlowMassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An flowmass is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable FlowMass Vector
         * @param unit U; the unit of the new Relative Dense Immutable FlowMass Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final FlowMassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;FlowMass&gt;; the values of the Scalar FlowMass entries in the new Relative Dense Immutable
         *            FlowMass Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<FlowMassUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable FlowMass Vector. An flowmass is always relative.
         * @param values FlowMass[]; the values of the Scalar FlowMass entries in the new Relative Dense Immutable FlowMass
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final FlowMass[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable FlowMass Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final FlowMassUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMassVector immutable()
        {
            setCopyOnWrite(true);
            return new FlowMassVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFlowMassVector mutable()
        {
            setCopyOnWrite(true);
            final MutableFlowMassVector.Dense result = new MutableFlowMassVector.Dense(getData(), getUnit());
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
        public final MutableFlowMassVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFlowMassVector toSparse()
        {
            return new MutableFlowMassVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable FlowMass class.
     */
    public static class Sparse extends MutableFlowMassVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable FlowMass Vector. An flowmass is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable FlowMass Vector
         * @param unit FlowMassUnit; the unit of the new Relative Sparse Immutable FlowMass Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final FlowMassUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable FlowMass Vector. An flowmass is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable FlowMass
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<FlowMassUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double FlowMass Vector. An flowmass is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double FlowMass Vector
         * @param unit U; the unit of the new Sparse Immutable FlowMass Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final FlowMassUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable FlowMass Vector. An flowmass is always relative.
         * @param values FlowMass[]; the values of the Scalar FlowMass entries in the new Relative Sparse Immutable FlowMass
         *            Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final FlowMass[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable FlowMass Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final FlowMassUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMassVector immutable()
        {
            setCopyOnWrite(true);
            return new FlowMassVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFlowMassVector mutable()
        {
            setCopyOnWrite(true);
            final MutableFlowMassVector.Sparse result = new MutableFlowMassVector.Sparse(getData(), getUnit());
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
        public final MutableFlowMassVector toDense()
        {
            return new MutableFlowMassVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFlowMassVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final FlowMass get(final int index) throws ValueException
    {
        return (FlowMass) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector copy()
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
    public final FlowMassVector plus(final FlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FlowMassVector minus(final FlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FlowMassVector times(final FlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FlowMassVector divide(final FlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FlowMassVector plus(final MutableFlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FlowMassVector minus(final MutableFlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FlowMassVector times(final MutableFlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final FlowMassVector divide(final MutableFlowMassVector rel) throws ValueException
    {
        return FlowMassVector.instantiate(this.getData().divide(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector abs()
    {
        return (MutableFlowMassVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector acos()
    {
        return (MutableFlowMassVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector asin()
    {
        return (MutableFlowMassVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector atan()
    {
        return (MutableFlowMassVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector cbrt()
    {
        return (MutableFlowMassVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector ceil()
    {
        return (MutableFlowMassVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector cos()
    {
        return (MutableFlowMassVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector cosh()
    {
        return (MutableFlowMassVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector exp()
    {
        return (MutableFlowMassVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector expm1()
    {
        return (MutableFlowMassVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector floor()
    {
        return (MutableFlowMassVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector log()
    {
        return (MutableFlowMassVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector log10()
    {
        return (MutableFlowMassVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector log1p()
    {
        return (MutableFlowMassVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector pow(final double x)
    {
        return (MutableFlowMassVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector rint()
    {
        return (MutableFlowMassVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector round()
    {
        return (MutableFlowMassVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector signum()
    {
        return (MutableFlowMassVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector sin()
    {
        return (MutableFlowMassVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector sinh()
    {
        return (MutableFlowMassVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector sqrt()
    {
        return (MutableFlowMassVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector tan()
    {
        return (MutableFlowMassVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector tanh()
    {
        return (MutableFlowMassVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector toDegrees()
    {
        return (MutableFlowMassVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector toRadians()
    {
        return (MutableFlowMassVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector inv()
    {
        return (MutableFlowMassVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector multiplyBy(final double constant)
    {
        return (MutableFlowMassVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableFlowMassVector divideBy(final double constant)
    {
        return (MutableFlowMassVector) super.divideBy(constant);
    }

}
