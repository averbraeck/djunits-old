package org.djunits4.value.vfloat.matrix;

import org.djunits4.unit.AbsoluteLinearUnit;
import org.djunits4.unit.Unit;
import org.djunits4.value.MathFunctionsAbs;
import org.djunits4.value.MathFunctionsRel;
import org.djunits4.value.StorageType;
import org.djunits4.value.ValueException;
import org.djunits4.value.vfloat.FloatMathFunctions;
import org.djunits4.value.vfloat.scalar.FloatScalar;

/**
 * MutableFloatMatrix.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public abstract class MutableFloatMatrix
{
    /**
     * ABSOLUTE implementation of MutableFloatVector.
     * @param <AU> Absolute unit
     * @param <RU> Relative unit
     */
    public static class Abs<AU extends AbsoluteLinearUnit<AU, RU>, RU extends Unit<RU>> extends
            AbstractMutableFloatMatrixAbs<AU, RU, FloatMatrix.Abs<AU, RU>, FloatMatrix.Rel<RU>, MutableFloatMatrix.Abs<AU, RU>,
                    FloatScalar.Abs<AU, RU>>
            implements MathFunctionsAbs<MutableFloatMatrix.Abs<AU, RU>>, FloatMathFunctions<MutableFloatMatrix.Abs<AU, RU>>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Absolute Mutable FloatMatrix.
         * @param values float[][]; the values of the entries in the new Absolute Mutable FloatMatrix
         * @param unit AU; the unit of the new Absolute Mutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Abs(final float[][] values, final AU unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatMatrix.
         * @param values FloatScalar.Abs&lt;AU, RU&gt;[][]; the values of the entries in the new Absolute Mutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Abs(final FloatScalar.Abs<AU, RU>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Absolute Mutable FloatMatrix.
         * @param data FloatMatrixData; an internal data object
         * @param unit AU; the unit
         */
        Abs(final FloatMatrixData data, final AU unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableFloatMatrix.Abs<AU, RU> toDense()
        {
            return this.data.isDense() ? this : instantiateMutableType(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableFloatMatrix.Abs<AU, RU> toSparse()
        {
            return this.data.isSparse() ? this : instantiateMutableType(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatMatrix.Abs<AU, RU> instantiateTypeAbs(final FloatMatrixData dmd, final AU unit)
        {
            return new FloatMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatMatrix.Rel<RU> instantiateTypeRel(final FloatMatrixData dmd, final RU unit)
        {
            return new FloatMatrix.Rel<RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatMatrix.Abs<AU, RU> instantiateMutableType(final FloatMatrixData dmd, final AU unit)
        {
            return new MutableFloatMatrix.Abs<AU, RU>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatScalar.Abs<AU, RU> instantiateScalar(final float value, final AU unit)
        {
            return new FloatScalar.Abs<AU, RU>(value, unit);
        }
    }

    /**
     * RELATIVE implementation of MutableFloatMatrix.
     * @param <U> Unit the unit for which this Matrix will be created
     */
    public static class Rel<U extends Unit<U>>
            extends AbstractMutableFloatMatrixRel<U, FloatMatrix.Rel<U>, MutableFloatMatrix.Rel<U>, FloatScalar.Rel<U>>
            implements MathFunctionsRel<MutableFloatMatrix.Rel<U>>, FloatMathFunctions<MutableFloatMatrix.Rel<U>>
    {
        /**  */
        private static final long serialVersionUID = 20151003L;

        /**
         * Construct a new Relative Mutable FloatMatrix.
         * @param values float[][]; the values of the entries in the new Relative Mutable FloatMatrix
         * @param unit U; the unit of the new Relative Mutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values is null
         */
        public Rel(final float[][] values, final U unit, final StorageType storageType) throws ValueException
        {
            super(values, unit, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatMatrix.
         * @param values FloatScalar.Rel&lt;U&gt;[][]; the values of the entries in the new Relative Mutable FloatMatrix
         * @param storageType StorageType; the data type to use (e.g., DENSE or SPARSE)
         * @throws ValueException when values has zero entries
         */
        public Rel(final FloatScalar.Rel<U>[][] values, final StorageType storageType) throws ValueException
        {
            super(values, storageType);
        }

        /**
         * Construct a new Relative Mutable FloatMatrix.
         * @param data FloatMatrixData; an internal data object
         * @param unit U; the unit
         */
        Rel(final FloatMatrixData data, final U unit)
        {
            super(data, unit);
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableFloatMatrix.Rel<U> toDense()
        {
            return this.data.isDense() ? this : new MutableFloatMatrix.Rel<U>(this.data.toDense(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        @SuppressWarnings("designforextension")
        public MutableFloatMatrix.Rel<U> toSparse()
        {
            return this.data.isSparse() ? this : new MutableFloatMatrix.Rel<U>(this.data.toSparse(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatMatrix.Rel<U> instantiateType(final FloatMatrixData dmd, final U unit)
        {
            return new FloatMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final MutableFloatMatrix.Rel<U> instantiateMutableType(final FloatMatrixData dmd, final U unit)
        {
            return new MutableFloatMatrix.Rel<U>(dmd, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatScalar.Rel<U> instantiateScalar(final float value, final U unit)
        {
            return new FloatScalar.Rel<U>(value, unit);
        }
    }
}
