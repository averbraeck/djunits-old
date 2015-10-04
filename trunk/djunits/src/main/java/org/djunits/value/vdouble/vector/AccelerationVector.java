package org.djunits.value.vdouble.vector;

import java.util.List;
import java.util.SortedMap;

import org.djunits.unit.AccelerationUnit;
import org.djunits.value.ValueException;
import org.djunits.value.vdouble.scalar.Acceleration;
import org.djunits.value.vdouble.scalar.DoubleScalar;

/**
 * Easy access methods for the Acceleration DoubleScalar, which is relative by definition. An example is Money. Instead of <br>
 * <i>DoubleScalar.Rel&lt;MoneyUnit&gt; price = new DoubleScalar.Rel&lt;MoneyUnit&gt;(100.0, MoneyUnit.EUR);</i><br>
 * we can now write <br>
 * <i>Money price = new Money(100.0, EUR);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-09-29 14:14:28 +0200 (Tue, 29 Sep 2015) $, @version $Revision: 73 $, by $Author: pknoppers $, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AccelerationVector
{
    /**
     * Double Dense Relative Immutable Acceleration class.
     */
    public class Dense extends DoubleVector.Rel.Dense<AccelerationUnit>
    {
        /** */
        private static final long serialVersionUID = 20150905L;

        /**
         * Construct a new Dense Immutable Double Acceleration Vector. An acceleration is always relative.
         * @param values double[]; the values of the entries in the new Dense Immutable Double Acceleration Vector
         * @param unit U; the unit of the new Dense Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Dense(final double[] values, final AccelerationUnit unit) throws ValueException
        {
            super(values, unit);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector. An acceleration is always relative.
         * @param values List; the values of the entries in the new Relative Dense Immutable Acceleration Vector
         * @param unit U; the unit of the new Relative Dense Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Dense(final List<Double> values, final AccelerationUnit unit) throws ValueException
        {
            super(values, unit);
        }

        /**
         * Construct a new Relative Dense Immutable DoubleVector.
         * @param values List&lt;Acceleration&gt;; the values of the Scalar Acceleration entries in the new Relative Dense
         *            Immutable DoubleVector
         * @throws ValueException when values has zero entries
         */
        public Dense(final List<DoubleScalar.Rel<AccelerationUnit>> values) throws ValueException
        {
            super(values);
        }

        /**
         * Construct a new Relative Dense Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Acceleration[]; the values of the Scalar Acceleration entries in the new Relative Dense Immutable
         *            Acceleration Vector
         * @throws ValueException when values has zero entries
         */
        public Dense(final Acceleration[] values) throws ValueException
        {
            super(values);
        }

        // /** {@inheritDoc} */
        // @Override
        // public final MutableAccelerationVector.Dense mutable()
        // {
        // return new MutableAccelerationVector.Dense(getData(), getUnit());
        // }

        /** {@inheritDoc} */
        @Override
        public final AccelerationVector.Dense copy()
        {
            return this; // Immutable...
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration get(final int index) throws ValueException
        {
            return (Acceleration) super.get(index);
        }
    }

    /**
     * Double Sparse Relative Immutable Acceleration class.
     */
    public class Sparse extends DoubleVector.Rel.Sparse<AccelerationUnit>
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
        public Sparse(final SortedMap<Integer, Double> values, final AccelerationUnit unit, final int length)
            throws ValueException
        {
            super(values, unit, length);
        }

        /**
         * Construct a new Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values DoubleScalar.Rel&lt;U&gt;[]; the values of the entries in the new Relative Sparse Immutable
         *            Acceleration Vector
         * @param length the size of the vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final SortedMap<Integer, DoubleScalar.Rel<AccelerationUnit>> values, final int length)
            throws ValueException
        {
            super(values, length);
        }

        /**
         * Construct a new Sparse Immutable Double Acceleration Vector. An acceleration is always relative.
         * @param values double[]; the values of the entries in the new Sparse Immutable Double Acceleration Vector
         * @param unit U; the unit of the new Sparse Immutable Acceleration Vector
         * @throws ValueException when values is null
         */
        public Sparse(final double[] values, final AccelerationUnit unit) throws ValueException
        {
            super(values, unit);
        }

        /**
         * Construct a new Relative Sparse Immutable Acceleration Vector. An acceleration is always relative.
         * @param values Acceleration[]; the values of the Scalar Acceleration entries in the new Relative Sparse Immutable
         *            Acceleration Vector
         * @throws ValueException when values has zero entries
         */
        public Sparse(final Acceleration[] values) throws ValueException
        {
            super(values);
        }

        // /** {@inheritDoc} */
        // @Override
        // public final MutableAccelerationVector.Sparse mutable()
        // {
        // return new MutableAccelerationVector.Sparse(getData(), getUnit());
        // }

        /** {@inheritDoc} */
        @Override
        public final AccelerationVector.Sparse copy()
        {
            return this; // Immutable...
        }

        /** {@inheritDoc} */
        @Override
        public final Acceleration get(final int index) throws ValueException
        {
            return (Acceleration) super.get(index);
        }
    }

}
