package org.djunits4.value.vdouble.matrix;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.FunctionsAbs;
import org.djunits4.value.MathFunctionsAbs;
import org.djunits4.value.MathFunctionsRel;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vdouble.DoubleMathFunctions;
import org.djunits4.value.vdouble.scalar.DoubleScalar;

/**
 * MutableDoubleMatrix.
 * <p>
 * This file was generated by the djunits value classes generator, 26 jun, 2015
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2019-01-18 00:35:01 +0100 (Fri, 18 Jan 2019) $, @version $Revision: 324 $, by $Author: averbraeck $,
 * initial version 26 jun, 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class MutableDoubleMatrix
{
    /**
     * ABSOLUTE implementation of MutableDoubleVector.
     * @param <AU> Absolute unit
     * @param <RU> Relative unit
     */
    public static class Abs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> extends
            AbstractMutableDoubleMatrixAbs<AU, RU, DoubleMatrix.Abs<AU, RU>, DoubleMatrix.Rel<RU>,
                    MutableDoubleMatrix.Abs<AU, RU>, DoubleScalar.Abs<AU, RU>>
            implements MathFunctionsAbs<MutableDoubleMatrix.Abs<AU, RU>>,
            FunctionsAbs<AU, RU, DoubleMatrix.Abs<AU, RU>, DoubleMatrix.Rel<RU>>,
            DoubleMathFunctions<MutableDoubleMatrix.Abs<AU, RU>>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable DoubleMatrix.
         * @param values double[][]; the values of the entries in the new Absolute Mutable DoubleMatrix
         * @param unit AU; the unit of the new Absolute Mutable DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final double[][] values, final AU unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleMatrix.
         * @param values DoubleScalar.Abs&lt;AU, RU&gt;[][]; the values of the entries in the new Absolute Mutable DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final DoubleScalar.Abs<AU, RU>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable DoubleMatrix.
         * @param data DoubleMatrixData; an internal data object
         * @param unit AU; the unit
         */
        Abs(final DoubleMatrixData data, final AU unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableDoubleMatrix.Abs<AU, RU> toDense()
        {
            return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableDoubleMatrix.Abs<AU, RU> toSparse()
        {
            return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleMatrix.Abs<AU, RU> instantiateTypeAbs(final DoubleMatrixData dmd, final AU unit)
        {
            return new DoubleMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleMatrix.Rel<RU> instantiateTypeRel(final DoubleMatrixData dmd, final RU unit)
        {
            return new DoubleMatrix.Rel<RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDoubleMatrix.Abs<AU, RU> instantiateMutableType(final DoubleMatrixData dmd, final AU unit)
        {
            return new MutableDoubleMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleScalar.Abs<AU, RU> instantiateScalar(final double value, final AU unit)
        {
            return new DoubleScalar.Abs<AU, RU>(value, unit);
        }
    }

    /**
     * RELATIVE implementation of MutableDoubleMatrix.
     * @param <U> Unit the unit for which this Matrix will be created
     */
    public static class Rel<U extends Unit<U>>
            extends AbstractMutableDoubleMatrixRel<U, DoubleMatrix.Rel<U>, MutableDoubleMatrix.Rel<U>, DoubleScalar.Rel<U>>
            implements MathFunctionsRel<MutableDoubleMatrix.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Mutable DoubleMatrix.
         * @param values double[][]; the values of the entries in the new Relative Mutable DoubleMatrix
         * @param unit U; the unit of the new Relative Mutable DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final double[][] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleMatrix.
         * @param values DoubleScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable DoubleMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final DoubleScalar.Rel<U>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable DoubleMatrix.
         * @param data DoubleMatrixData; an internal data object
         * @param unit U; the unit
         */
        Rel(final DoubleMatrixData data, final U unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableDoubleMatrix.Rel<U> toDense()
        {
            return this.data.isDense() ? this : new MutableDoubleMatrix.Rel<U>(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableDoubleMatrix.Rel<U> toSparse()
        {
            return this.data.isSparse() ? this : new MutableDoubleMatrix.Rel<U>(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleMatrix.Rel<U> instantiateType(final DoubleMatrixData dmd, final U unit)
        {
            return new DoubleMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableDoubleMatrix.Rel<U> instantiateMutableType(final DoubleMatrixData dmd, final U unit)
        {
            return new MutableDoubleMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final DoubleScalar.Rel<U> instantiateScalar(final double value, final U unit)
        {
            return new DoubleScalar.Rel<U>(value, unit);
        }
    }
}
