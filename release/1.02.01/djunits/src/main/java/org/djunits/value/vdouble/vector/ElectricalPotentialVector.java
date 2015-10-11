package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.ElectricalPotential;

/**
 * Immutable ElectricalPotential Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class ElectricalPotentialVector extends DoubleVector.Rel<ElectricalPotentialUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public ElectricalPotentialVector(final ElectricalPotentialUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableElectricalPotentialVector mutable();

    /** {@inheritDoc} */
    public abstract ElectricalPotentialVector toDense();

    /** {@inheritDoc} */
    public abstract ElectricalPotentialVector toSparse();

    /**
     * Double Dense Relative Immutable ElectricalPotential class.
     */
    public static class Dense extends ElectricalPotentialVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double ElectricalPotential Vector. An electricalpotential is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double ElectricalPotential Vector
         * @param unit U; the unit of the new Dense Immutable ElectricalPotential Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final ElectricalPotentialUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An electricalpotential is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable ElectricalPotential Vector
         * @param unit U; the unit of the new Relative Dense Immutable ElectricalPotential Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final ElectricalPotentialUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;ElectricalPotential&gt;; the values of the Scalar ElectricalPotential entries in the new
         *            Relative Dense Immutable DoubleVector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<ElectricalPotentialUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable ElectricalPotential Vector. An electricalpotential is always relative.
         * @param values ElectricalPotential[]; the values of the Scalar ElectricalPotential entries in the new Relative Dense
         *            Immutable ElectricalPotential Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final ElectricalPotential[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final ElectricalPotentialUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalPotentialVector mutable()
        {
            return new MutableElectricalPotentialVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataDense getData()
        {
            return (DoubleVectorDataDense) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotentialVector toDense()
        {
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotentialVector toSparse()
        {
            return new ElectricalPotentialVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable ElectricalPotential class.
     */
    public static class Sparse extends ElectricalPotentialVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable ElectricalPotential Vector. An electricalpotential is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable ElectricalPotential Vector
         * @param unit ElectricalPotentialUnit; the unit of the new Relative Sparse Immutable ElectricalPotential Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final ElectricalPotentialUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable ElectricalPotential Vector. An electricalpotential is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            ElectricalPotential Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<ElectricalPotentialUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double ElectricalPotential Vector. An electricalpotential is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double ElectricalPotential Vector
         * @param unit U; the unit of the new Sparse Immutable ElectricalPotential Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final ElectricalPotentialUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable ElectricalPotential Vector. An electricalpotential is always relative.
         * @param values ElectricalPotential[]; the values of the Scalar ElectricalPotential entries in the new Relative Sparse
         *            Immutable ElectricalPotential Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final ElectricalPotential[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final ElectricalPotentialUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalPotentialVector mutable()
        {
            return new MutableElectricalPotentialVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataSparse getData()
        {
            return (DoubleVectorDataSparse) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotentialVector toDense()
        {
            return new ElectricalPotentialVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotentialVector toSparse()
        {
            return this;
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final ElectricalPotential get(final int index) throws ValueException
    {
        return (ElectricalPotential) super.get(index);
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the DoubleVectorData
     * @param unit the unit to use
     * @return an ElectricalPotentialVector
     */
    static ElectricalPotentialVector instantiate(final DoubleVectorData dvData, final ElectricalPotentialUnit unit)
    {
        if (dvData instanceof DoubleVectorDataSparse)
        {
            return new ElectricalPotentialVector.Sparse((DoubleVectorDataSparse) dvData, unit);
        }
        else
        {
            return new ElectricalPotentialVector.Dense((DoubleVectorDataDense) dvData, unit);
        }
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalPotentialVector plus(final ElectricalPotentialVector rel) throws ValueException
    {
        return instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalPotentialVector minus(final ElectricalPotentialVector rel) throws ValueException
    {
        return instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalPotentialVector times(final ElectricalPotentialVector rel) throws ValueException
    {
        return instantiate(this.getData().times(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalPotentialVector divide(final ElectricalPotentialVector rel) throws ValueException
    {
        return instantiate(this.getData().divide(rel.getData()), getUnit());
    }

}
