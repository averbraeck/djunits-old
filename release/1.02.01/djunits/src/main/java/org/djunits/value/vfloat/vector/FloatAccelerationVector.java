package org.djunits.value.vfloat.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vfloat.scalar.FloatAcceleration;
import org.djunits.value.vfloat.scalar.FloatScalar;

/**
 * Immutable Acceleration Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class FloatAccelerationVector extends FloatVector.Rel<AccelerationUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public FloatAccelerationVector(final AccelerationUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableFloatAccelerationVector mutable();

    /** {@inheritDoc} */
    public abstract FloatAccelerationVector toDense();

    /** {@inheritDoc} */
    public abstract FloatAccelerationVector toSparse();

    /**
     * Float Dense Relative Immutable Acceleration class.
     */
    public static class Dense extends FloatAccelerationVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Float Acceleration Vector. An acceleration is always relative.
         * @param values float[]; the values of the entries in the new Dense Immutable Float Acceleration Vector
         * @param unit U; the unit of the new Dense Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Dense(final float[] values, final AccelerationUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable FloatVector. An acceleration is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Acceleration Vector
         * @param unit U; the unit of the new Relative Dense Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Float> values, final AccelerationUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable FloatVector.
         * @param values List&lt;Acceleration&gt;; the values of the Scalar Acceleration entries in the new Relative Dense
         *            Immutable FloatVector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<FloatScalar.Rel<AccelerationUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Acceleration[]; the values of the Scalar Acceleration entries in the new Relative Dense Immutable
         *            Acceleration Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final FloatAcceleration[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable FloatVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final FloatVectorDataDense data, final AccelerationUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatAccelerationVector mutable()
        {
            return new MutableFloatAccelerationVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatVectorDataDense getData()
        {
            return (FloatVectorDataDense) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAccelerationVector toDense()
        {
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAccelerationVector toSparse()
        {
            return new FloatAccelerationVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Float Sparse Relative Immutable Acceleration class.
     */
    public static class Sparse extends FloatAccelerationVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable Acceleration Vector
         * @param unit AccelerationUnit; the unit of the new Relative Sparse Immutable Acceleration Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Float> values, final AccelerationUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values FloatScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable Acceleration
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, FloatScalar.Rel<AccelerationUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Float Acceleration Vector. An acceleration is always relative.
         * @param values float[]; the values of the entries in the new Sparse Immutable Float Acceleration Vector
         * @param unit U; the unit of the new Sparse Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Sparse(final float[] values, final AccelerationUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Acceleration[]; the values of the Scalar Acceleration entries in the new Relative Sparse Immutable
         *            Acceleration Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final FloatAcceleration[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable FloatVector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final FloatVectorDataSparse data, final AccelerationUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableFloatAccelerationVector mutable()
        {
            return new MutableFloatAccelerationVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatVectorDataSparse getData()
        {
            return (FloatVectorDataSparse) this.data;
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAccelerationVector toDense()
        {
            return new FloatAccelerationVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FloatAccelerationVector toSparse()
        {
            return this;
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final FloatAcceleration get(final int index) throws ValueException
    {
        return (FloatAcceleration) super.get(index);
    }

    /**
     * Instantiate a vector based on the type of data.
     * @param dvData the FloatVectorData
     * @param unit the unit to use
     * @return an AccelerationVector
     */
    static FloatAccelerationVector instantiate(final FloatVectorData dvData, final AccelerationUnit unit)
    {
        if (dvData instanceof FloatVectorDataSparse)
        {
            return new FloatAccelerationVector.Sparse((FloatVectorDataSparse) dvData, unit);
        }
        else
        {
            return new FloatAccelerationVector.Dense((FloatVectorDataDense) dvData, unit);
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
    public final FloatAccelerationVector plus(final FloatAccelerationVector rel) throws ValueException
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
    public final FloatAccelerationVector minus(final FloatAccelerationVector rel) throws ValueException
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
    public final FloatAccelerationVector times(final FloatAccelerationVector rel) throws ValueException
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
    public final FloatAccelerationVector divide(final FloatAccelerationVector rel) throws ValueException
    {
        return instantiate(this.getData().plus(rel.getData()), getUnit());
    }

}
