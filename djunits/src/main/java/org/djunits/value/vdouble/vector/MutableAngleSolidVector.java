package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AngleSolidUnit;
import org.djunits.value.DenseData;
import org.djunits.value.SparseData;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.AngleSolid;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Mutable AngleSolid Vector.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public abstract class MutableAngleSolidVector extends MutableDoubleVector.Rel<AngleSolidUnit>
{
    /** */
    private static final long serialVersionUID = 20151006L;

    /**
     * @param unit the unit to use
     */
    public MutableAngleSolidVector(final AngleSolidUnit unit)
    {
        super(unit);
    }

    /** {@inheritDoc} */
    @Override
    public abstract MutableAngleSolidVector mutable();

    /** {@inheritDoc} */
    @Override
    public abstract AngleSolidVector immutable();

    /** {@inheritDoc} */
    public abstract MutableAngleSolidVector toDense();

    /** {@inheritDoc} */
    public abstract MutableAngleSolidVector toSparse();

    /**
     * Double Dense Relative Immutable AngleSolid class.
     */
    public static class Dense extends MutableAngleSolidVector implements DenseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double AngleSolid Vector. An anglesolid is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double AngleSolid Vector
         * @param unit U; the unit of the new Dense Immutable AngleSolid Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final AngleSolidUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An anglesolid is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable AngleSolid Vector
         * @param unit U; the unit of the new Relative Dense Immutable AngleSolid Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final AngleSolidUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;AngleSolid&gt;; the values of the Scalar AngleSolid entries in the new Relative Dense Immutable
         *            AngleSolid Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<AngleSolidUnit>> values) throws ValueException
        {
            super(checkNonEmptyLR(values).get(0).getUnit());
            this.data = initializeDenseLR(values);
        }

        /**
         * Construct a new Relative Dense Immutable AngleSolid Vector. An anglesolid is always relative.
         * @param values AngleSolid[]; the values of the Scalar AngleSolid entries in the new Relative Dense Immutable
         *            AngleSolid Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final AngleSolid[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values);
        }

        /**
         * Construct a new Relative Dense Mutable AngleSolid Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Dense(final DoubleVectorDataDense data, final AngleSolidUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolidVector immutable()
        {
            setCopyOnWrite(true);
            return new AngleSolidVector.Dense(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSolidVector mutable()
        {
            setCopyOnWrite(true);
            final MutableAngleSolidVector.Dense result = new MutableAngleSolidVector.Dense(getData(), getUnit());
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
        public final MutableAngleSolidVector toDense()
        {
            return copy();
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSolidVector toSparse()
        {
            return new MutableAngleSolidVector.Sparse(getData().toSparse(), getUnit());
        }
    }

    /**
     * Double Sparse Relative Immutable AngleSolid class.
     */
    public static class Sparse extends MutableAngleSolidVector implements SparseData
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Sparse Immutable AngleSolid Vector. An anglesolid is always relative.
         * @param values Map; the map of indexes to values of the Relative Sparse Immutable AngleSolid Vector
         * @param unit AngleSolidUnit; the unit of the new Relative Sparse Immutable AngleSolid Vector
         * @param length the size of the vector
         * @throws ValueException when values is null
         */
        public Sparse(final SortedMap<Integer, Double> values, final AngleSolidUnit unit, final int length)
            throws ValueException
        {
            super(unit);
            this.data = initializeSparse(values, length);
        }

        /**
         * Construct a new Sparse Immutable AngleSolid Vector. An anglesolid is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable AngleSolid
         *            Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<AngleSolidUnit>> values, final int length)
            throws ValueException
        {
            super(checkNonEmptyMR(values).get(values.firstKey()).getUnit());
            this.data = initializeSparseMR(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double AngleSolid Vector. An anglesolid is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double AngleSolid Vector
         * @param unit U; the unit of the new Sparse Immutable AngleSolid Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final AngleSolidUnit unit) throws ValueException
        {
            super(unit);
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Immutable AngleSolid Vector. An anglesolid is always relative.
         * @param values AngleSolid[]; the values of the Scalar AngleSolid entries in the new Relative Sparse Immutable
         *            AngleSolid Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final AngleSolid[] values) throws ValueException
        {
            super(checkNonEmpty(values)[0].getUnit());
            this.data = initializeDense(values).toSparse();
        }

        /**
         * Construct a new Relative Sparse Mutable AngleSolid Vector.
         * @param data an internal data object
         * @param unit the unit
         */
        Sparse(final DoubleVectorDataSparse data, final AngleSolidUnit unit)
        {
            super(unit);
            this.data = data.copy();
        }

        /** {@inheritDoc} */
        @Override
        public final AngleSolidVector immutable()
        {
            setCopyOnWrite(true);
            return new AngleSolidVector.Sparse(getData(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSolidVector mutable()
        {
            setCopyOnWrite(true);
            final MutableAngleSolidVector.Sparse result = new MutableAngleSolidVector.Sparse(getData(), getUnit());
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
        public final MutableAngleSolidVector toDense()
        {
            return new MutableAngleSolidVector.Dense(getData().toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final MutableAngleSolidVector toSparse()
        {
            return copy();
        }
    }

    /**********************************************************************************/
    /**************************** TYPED CALCULATION METHODS ***************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final AngleSolid get(final int index) throws ValueException
    {
        return (AngleSolid) super.get(index);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector copy()
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
    public final AngleSolidVector plus(final AngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AngleSolidVector minus(final AngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AngleSolidVector times(final AngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AngleSolidVector divide(final AngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Add a Relative value to this Relative value for a vector or matrix. The addition is done value by value and store the
     * result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise the
     * result is a dense vector or matrix.
     * @param rel the right operand
     * @return the addition of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AngleSolidVector plus(final MutableAngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Subtract a Relative value from this Relative value for a vector or matrix. The subtraction is done value by value and
     * store the result in a new Relative value. If both operands are sparse, the result is a sparse vector or matrix, otherwise
     * the result is a dense vector or matrix.
     * @param rel the right operand
     * @return the subtraction of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AngleSolidVector minus(final MutableAngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().minus(rel.getData()), getUnit());
    }

    /**
     * Multiply a Relative value with this Relative value for a vector or matrix. The multiplication is done value by value and
     * store the result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise
     * the result is a sparse vector or matrix.
     * @param rel the right operand
     * @return the multiplication of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AngleSolidVector times(final MutableAngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**
     * Divide this Relative value by a Relative value for a vector or matrix. The division is done value by value and store the
     * result in a new Relative value. If both operands are dense, the result is a dense vector or matrix, otherwise the result
     * is a sparse vector or matrix.
     * @param rel the right operand
     * @return the division of this vector and the operand
     * @throws ValueException in case this vector or matrix and the operand have a different size
     */
    public final AngleSolidVector divide(final MutableAngleSolidVector rel) throws ValueException
    {
        return AngleSolidVector.instantiate(this.getData().plus(rel.getData()), getUnit());
    }

    /**********************************************************************************/
    /********************************** MATH METHODS **********************************/
    /**********************************************************************************/

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector abs()
    {
        return (MutableAngleSolidVector) super.abs();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector acos()
    {
        return (MutableAngleSolidVector) super.acos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector asin()
    {
        return (MutableAngleSolidVector) super.asin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector atan()
    {
        return (MutableAngleSolidVector) super.atan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector cbrt()
    {
        return (MutableAngleSolidVector) super.cbrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector ceil()
    {
        return (MutableAngleSolidVector) super.ceil();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector cos()
    {
        return (MutableAngleSolidVector) super.cos();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector cosh()
    {
        return (MutableAngleSolidVector) super.cosh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector exp()
    {
        return (MutableAngleSolidVector) super.exp();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector expm1()
    {
        return (MutableAngleSolidVector) super.expm1();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector floor()
    {
        return (MutableAngleSolidVector) super.floor();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector log()
    {
        return (MutableAngleSolidVector) super.log();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector log10()
    {
        return (MutableAngleSolidVector) super.log10();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector log1p()
    {
        return (MutableAngleSolidVector) super.log1p();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector pow(final double x)
    {
        return (MutableAngleSolidVector) super.pow(x);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector rint()
    {
        return (MutableAngleSolidVector) super.rint();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector round()
    {
        return (MutableAngleSolidVector) super.round();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector signum()
    {
        return (MutableAngleSolidVector) super.signum();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector sin()
    {
        return (MutableAngleSolidVector) super.sin();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector sinh()
    {
        return (MutableAngleSolidVector) super.sinh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector sqrt()
    {
        return (MutableAngleSolidVector) super.sqrt();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector tan()
    {
        return (MutableAngleSolidVector) super.tan();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector tanh()
    {
        return (MutableAngleSolidVector) super.tanh();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector toDegrees()
    {
        return (MutableAngleSolidVector) super.toDegrees();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector toRadians()
    {
        return (MutableAngleSolidVector) super.toRadians();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector inv()
    {
        return (MutableAngleSolidVector) super.inv();
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector multiplyBy(final double constant)
    {
        return (MutableAngleSolidVector) super.multiplyBy(constant);
    }

    /** {@inheritDoc} */
    @Override
    public final MutableAngleSolidVector divideBy(final double constant)
    {
        return (MutableAngleSolidVector) super.divideBy(constant);
    }

}
