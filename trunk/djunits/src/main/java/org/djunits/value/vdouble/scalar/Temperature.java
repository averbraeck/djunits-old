package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.TemperatureUnit;

/**
 * Easy access methods for the Temperature DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
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
public interface Temperature
{
    /**
     * Easy access methods for the Relative Temperature DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;TemperatureUnit&gt; value = new DoubleScalar.Rel&lt;TemperatureUnit&gt;(100.0,
     * TemperatureUnit.SI);</i><br>
     * we can now write <br>
     * <i>Temperature.Rel value = new Temperature.Rel(100.0, TemperatureUnit.SI);</i><br>
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
    class Rel extends TypedDoubleScalarRel<TemperatureUnit, Temperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final Temperature.Rel ZERO = new Temperature.Rel(0.0, TemperatureUnit.SI);

        /**
         * Construct Temperature.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Temperature.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final Temperature.Rel value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Temperature.Rel instantiateTypeRel(final double value, final TemperatureUnit unit)
        {
            return new Temperature.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
         * @param value the double value
         * @param unit the unit
         * @return A a new absolute instance of the DoubleScalar of the right type
         */
        protected final Temperature.Abs instantiateTypeAbs(final double value, final TemperatureUnit unit)
        {
            return new Temperature.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Temperature.Rel interpolate(final Temperature.Rel zero, final Temperature.Rel one,
            final double ratio)
        {
            return new Temperature.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Temperature.Abs plus(final Temperature.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative temperature scalar.
         */
        public final Temperature.Abs toAbs()
        {
            return new Temperature.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Temperature and Temperature, which results in a Dimensionless scalar.
         * @param v Temperature scalar
         * @return Dimensionless scalar as a division of Temperature and Temperature
         */
        public final Dimensionless divideBy(final Temperature.Rel v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the Absolute Temperature DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;TemperatureUnit&gt; value = new DoubleScalar.Abs&lt;TemperatureUnit&gt;(100.0,
     * TemperatureUnit.SI);</i><br>
     * we can now write <br>
     * <i>Temperature.Abs value = new Temperature.Abs(100.0, TemperatureUnit.SI);</i><br>
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
    class Abs extends TypedDoubleScalarAbs<TemperatureUnit, Temperature.Abs, Temperature.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final Temperature.Abs ZERO = new Temperature.Abs(0.0, TemperatureUnit.SI);

        /**
         * Construct Temperature.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final TemperatureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Temperature.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final Temperature.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Temperature.Abs instantiateTypeAbs(final double value, final TemperatureUnit unit)
        {
            return new Temperature.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Temperature.Rel instantiateTypeRel(final double value, final TemperatureUnit unit)
        {
            return new Temperature.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Temperature.Abs interpolate(final Temperature.Abs zero, final Temperature.Abs one,
            final double ratio)
        {
            return new Temperature.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

    }
}
