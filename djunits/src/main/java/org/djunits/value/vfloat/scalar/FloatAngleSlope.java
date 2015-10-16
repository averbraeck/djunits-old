package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleSlopeUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
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
public interface FloatAngleSlope
{
    /**
     * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;AngleSlopeUnit&gt; value = new FloatScalar.Rel&lt;AngleSlopeUnit&gt;(100.0, AngleSlopeUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAngleSlope.Rel value = new FloatAngleSlope.Rel(100.0, AngleSlopeUnit.SI);</i><br>
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
    class Rel extends TypedFloatScalarRel<AngleSlopeUnit, FloatAngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAngleSlope.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAngleSlope.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatAngleSlope.Rel value)
        {
            super(value);
        }

        /**
         * Construct FloatAngleSlope.Rel scalar using a double value.
         * @param value double value
         * @param unit unit for the resulting float value
         */
        public Rel(final double value, final AngleSlopeUnit unit)
        {
            super((float) value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlope.Rel instantiateTypeRel(final float value, final AngleSlopeUnit unit)
        {
            return new FloatAngleSlope.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
         * @param value the float value
         * @param unit the unit
         * @return A a new absolute instance of the FloatScalar of the right type
         */
        protected final FloatAngleSlope.Abs instantiateTypeAbs(final float value, final AngleSlopeUnit unit)
        {
            return new FloatAngleSlope.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAngleSlope.Rel interpolate(final FloatAngleSlope.Rel zero, final FloatAngleSlope.Rel one,
            final float ratio)
        {
            return new FloatAngleSlope.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAngleSlope.Abs plus(final FloatAngleSlope.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleslope scalar.
         */
        public final FloatAngleSlope.Abs toAbs()
        {
            return new FloatAngleSlope.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatAngleSlope and FloatAngleSlope, which results in a FloatDimensionless scalar.
         * @param v FloatAngleSlope scalar
         * @return FloatDimensionless scalar as a division of FloatAngleSlope and FloatAngleSlope
         */
        public final FloatDimensionless.Rel divideBy(final FloatAngleSlope.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the AngleSlope FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;AngleSlopeUnit&gt; value = new FloatScalar.Abs&lt;AngleSlopeUnit&gt;(100.0, AngleSlopeUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAngleSlope.Abs value = new FloatAngleSlope.Abs(100.0, AngleSlopeUnit.SI);</i><br>
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
    class Abs extends TypedFloatScalarAbs<AngleSlopeUnit, FloatAngleSlope.Abs, FloatAngleSlope.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAngleSlope.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AngleSlopeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAngleSlope.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AngleSlopeUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatAngleSlope.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatAngleSlope.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlope.Abs instantiateTypeAbs(final float value, final AngleSlopeUnit unit)
        {
            return new FloatAngleSlope.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngleSlope.Rel instantiateTypeRel(final float value, final AngleSlopeUnit unit)
        {
            return new FloatAngleSlope.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAngleSlope.Abs interpolate(final FloatAngleSlope.Abs zero, final FloatAngleSlope.Abs one,
            final float ratio)
        {
            return new FloatAngleSlope.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

    }
}
