package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AngleSlope DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AngleSlope
{
    /**
     * Easy access methods for the Relative AngleSlope DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;AngleSlopeUnit&gt; value = new DoubleScalar.Rel&lt;AngleSlopeUnit&gt;(100.0,
     * AngleSlopeUnit.SI);</i><br>
     * we can now write <br>
     * <i>AngleSlope.Rel value = new AngleSlope.Rel(100.0, AngleSlopeUnit.SI);</i><br>
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
    class Rel extends TypedDoubleScalarRel<AngleSlopeUnit, AngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AngleSlope.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AngleSlope.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final AngleSlope.Rel value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlope.Rel instantiateTypeRel(final double value, final AngleSlopeUnit unit)
        {
            return new AngleSlope.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
         * @param value the double value
         * @param unit the unit
         * @return A a new absolute instance of the DoubleScalar of the right type
         */
        protected final AngleSlope.Abs instantiateTypeAbs(final double value, final AngleSlopeUnit unit)
        {
            return new AngleSlope.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AngleSlope.Rel
            interpolate(final AngleSlope.Rel zero, final AngleSlope.Rel one, final double ratio)
        {
            return new AngleSlope.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AngleSlope.Abs plus(final AngleSlope.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleslope scalar.
         */
        public final AngleSlope.Abs toAbs()
        {
            return new AngleSlope.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AngleSlope and AngleSlope, which results in a Dimensionless scalar.
         * @param v AngleSlope scalar
         * @return Dimensionless scalar as a division of AngleSlope and AngleSlope
         */
        public final Dimensionless.Rel divideBy(final AngleSlope.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the Absolute AngleSlope DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;AngleSlopeUnit&gt; value = new DoubleScalar.Abs&lt;AngleSlopeUnit&gt;(100.0,
     * AngleSlopeUnit.SI);</i><br>
     * we can now write <br>
     * <i>AngleSlope.Abs value = new AngleSlope.Abs(100.0, AngleSlopeUnit.SI);</i><br>
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
    class Abs extends TypedDoubleScalarAbs<AngleSlopeUnit, AngleSlope.Abs, AngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AngleSlope.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AngleSlope.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final AngleSlope.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlope.Abs instantiateTypeAbs(final double value, final AngleSlopeUnit unit)
        {
            return new AngleSlope.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AngleSlope.Rel instantiateTypeRel(final double value, final AngleSlopeUnit unit)
        {
            return new AngleSlope.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AngleSlope.Abs
            interpolate(final AngleSlope.Abs zero, final AngleSlope.Abs one, final double ratio)
        {
            return new AngleSlope.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

    }
}
