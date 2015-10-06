package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.DoubleScalar;
import org.djunits.value.vdouble.scalar.ElectricalResistance;

/**
 * Immutable ElectricalResistance Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class ElectricalResistanceVector extends DoubleVector.Rel<ElectricalResistanceUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public ElectricalResistanceVector(final ElectricalResistanceUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableElectricalResistanceVector mutable();

    /** {@inheritDoc} */
    public abstract ElectricalResistanceVector toDense();

    /** {@inheritDoc} */
    public abstract ElectricalResistanceVector toSparse();

    /**
     * Double Dense Relative Immutable ElectricalResistance class.
     */
    public static class Dense extends ElectricalResistanceVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double ElectricalResistance Vector. An electricalresistance is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double ElectricalResistance Vector
         * @param unit U; the unit of the new Dense Immutable ElectricalResistance Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final ElectricalResistanceUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An electricalresistance is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable ElectricalResistance Vector
         * @param unit U; the unit of the new Relative Dense Immutable ElectricalResistance Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final ElectricalResistanceUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;ElectricalResistance&gt;; the values of the Scalar ElectricalResistance entries in the new
         *            Relative Dense Immutable DoubleVector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<ElectricalResistanceUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable ElectricalResistance Vector. An electricalresistance is always relative.
         * @param values ElectricalResistance[]; the values of the Scalar ElectricalResistance entries in the new Relative Dense
         *            Immutable ElectricalResistance Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final ElectricalResistance[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final ElectricalResistanceUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalResistanceVector mutable()
        {
            return new MutableElectricalResistanceVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataDense getData()
        {
            return (DoubleVectorDataDense) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistanceVector toDense()
        {
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistanceVector toSparse()
        {
            return new ElectricalResistanceVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable ElectricalResistance class.
     */
    public static class Sparse extends ElectricalResistanceVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable ElectricalResistance Vector. An electricalresistance is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable ElectricalResistance Vector
         * @param unit ElectricalResistanceUnit; the unit of the new Relative Sparse Immutable ElectricalResistance Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final ElectricalResistanceUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable ElectricalResistance Vector. An electricalresistance is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            ElectricalResistance Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<ElectricalResistanceUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double ElectricalResistance Vector. An electricalresistance is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double ElectricalResistance Vector
         * @param unit U; the unit of the new Sparse Immutable ElectricalResistance Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final ElectricalResistanceUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable ElectricalResistance Vector. An electricalresistance is always relative.
         * @param values ElectricalResistance[]; the values of the Scalar ElectricalResistance entries in the new Relative
         *            Sparse Immutable ElectricalResistance Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final ElectricalResistance[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable DoubleVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final ElectricalResistanceUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableElectricalResistanceVector mutable()
        {
            return new MutableElectricalResistanceVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleVectorDataSparse getData()
        {
            return (DoubleVectorDataSparse) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistanceVector toDense()
        {
            return new ElectricalResistanceVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistanceVector toSparse()
        {
            return this;
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final ElectricalResistance get(final int index) throws ValueException
    {
        return (ElectricalResistance) super.get(index);
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the DoubleVectorData
     * @param unit the unit to use
     * @return an ElectricalResistanceVector
     */
    static ElectricalResistanceVector instantiate(final DoubleVectorData dvData, final ElectricalResistanceUnit unit)
    {
        if (dvData instanceof DoubleVectorDataSparse)
        {
            return new ElectricalResistanceVector.Sparse((DoubleVectorDataSparse) dvData, unit);
        }
        else
        {
            return new ElectricalResistanceVector.Dense((DoubleVectorDataDense) dvData, unit);
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
    public final ElectricalResistanceVector plus(final ElectricalResistanceVector rel) throws ValueException
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
    public final ElectricalResistanceVector minus(final ElectricalResistanceVector rel) throws ValueException
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
    public final ElectricalResistanceVector times(final ElectricalResistanceVector rel) throws ValueException
    {
        return instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final ElectricalResistanceVector divide(final ElectricalResistanceVector rel) throws ValueException
    {
        return instantiate(this.getData().plus(rel.getData()), getUnit());
    }

}
