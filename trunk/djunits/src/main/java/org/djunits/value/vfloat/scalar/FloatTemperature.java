package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the Temperature FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatTemperature
{
    /**
     * Easy access methods for the Temperature FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;TemperatureUnit&gt; value = new FloatScalar.Rel&lt;TemperatureUnit&gt;(100.0,
     * TemperatureUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatTemperature.Rel value = new FloatTemperature.Rel(100.0, TemperatureUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Rel extends TypedFloatScalarRel<TemperatureUnit, FloatTemperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatTemperature.Rel ZERO = new FloatTemperature.Rel(0.0f, TemperatureUnit.SI);

        /**
         * Construct FloatTemperature.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatTemperature.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatTemperature.Rel value)
        {
            super(value);
        }

        /**
         * Construct FloatTemperature.Rel scalar using a double value.
         * @param value double value
         * @param unit unit for the resulting float value
         */
        public Rel(final double value, final TemperatureUnit unit)
        {
            super((float) value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperature.Rel instantiateTypeRel(final float value, final TemperatureUnit unit)
        {
            return new FloatTemperature.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
         * @param value the float value
         * @param unit the unit
         * @return A a new absolute instance of the FloatScalar of the right type
         */
        protected final FloatTemperature.Abs instantiateTypeAbs(final float value, final TemperatureUnit unit)
        {
            return new FloatTemperature.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatTemperature.Rel interpolate(final FloatTemperature.Rel zero, final FloatTemperature.Rel one,
            final float ratio)
        {
            return new FloatTemperature.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatTemperature.Abs plus(final FloatTemperature.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative temperature scalar.
         */
        public final FloatTemperature.Abs toAbs()
        {
            return new FloatTemperature.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatTemperature and FloatTemperature, which results in a FloatDimensionless scalar.
         * @param v FloatTemperature scalar
         * @return FloatDimensionless scalar as a division of FloatTemperature and FloatTemperature
         */
        public final FloatDimensionless divideBy(final FloatTemperature.Rel v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the Temperature FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;TemperatureUnit&gt; value = new FloatScalar.Abs&lt;TemperatureUnit&gt;(100.0,
     * TemperatureUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatTemperature.Abs value = new FloatTemperature.Abs(100.0, TemperatureUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Abs extends TypedFloatScalarAbs<TemperatureUnit, FloatTemperature.Abs, FloatTemperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatTemperature.Abs ZERO = new FloatTemperature.Abs(0.0f, TemperatureUnit.SI);

        /**
         * Construct FloatTemperature.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatTemperature.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final TemperatureUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatTemperature.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatTemperature.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperature.Abs instantiateTypeAbs(final float value, final TemperatureUnit unit)
        {
            return new FloatTemperature.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatTemperature.Rel instantiateTypeRel(final float value, final TemperatureUnit unit)
        {
            return new FloatTemperature.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatTemperature.Abs interpolate(final FloatTemperature.Abs zero, final FloatTemperature.Abs one,
            final float ratio)
        {
            return new FloatTemperature.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

    }
}
