package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the Angle FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-10-16 02:04:00 +0200 (Fri, 16 Oct 2015) $, @version $Revision: 113 $, by $Author: averbraeck $,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface FloatAngle
{
    /**
     * Easy access methods for the Angle FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;AngleUnit&gt; value = new FloatScalar.Rel&lt;AngleUnit&gt;(100.0, AngleUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAngle.Rel value = new FloatAngle.Rel(100.0, AngleUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-10-16 02:04:00 +0200 (Fri, 16 Oct 2015) $, @version $Revision: 113 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Rel extends TypedFloatScalarRel<AngleUnit, FloatAngle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatAngle.Rel ZERO = new FloatAngle.Rel(0.0f, AngleUnit.SI);

        /**
         * Construct FloatAngle.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AngleUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAngle.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatAngle.Rel value)
        {
            super(value);
        }

        /**
         * Construct FloatAngle.Rel scalar using a double value.
         * @param value double value
         * @param unit unit for the resulting float value
         */
        public Rel(final double value, final AngleUnit unit)
        {
            super((float) value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngle.Rel instantiateTypeRel(final float value, final AngleUnit unit)
        {
            return new FloatAngle.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
         * @param value the float value
         * @param unit the unit
         * @return A a new absolute instance of the FloatScalar of the right type
         */
        protected final FloatAngle.Abs instantiateTypeAbs(final float value, final AngleUnit unit)
        {
            return new FloatAngle.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAngle.Rel
            interpolate(final FloatAngle.Rel zero, final FloatAngle.Rel one, final float ratio)
        {
            return new FloatAngle.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAngle.Abs plus(final FloatAngle.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angle scalar.
         */
        public final FloatAngle.Abs toAbs()
        {
            return new FloatAngle.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatAngle and FloatAngle, which results in a FloatDimensionless scalar.
         * @param v FloatAngle scalar
         * @return FloatDimensionless scalar as a division of FloatAngle and FloatAngle
         */
        public final FloatDimensionless divideBy(final FloatAngle.Rel v)
        {
            return new FloatDimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the Angle FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;AngleUnit&gt; value = new FloatScalar.Abs&lt;AngleUnit&gt;(100.0, AngleUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAngle.Abs value = new FloatAngle.Abs(100.0, AngleUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-10-16 02:04:00 +0200 (Fri, 16 Oct 2015) $, @version $Revision: 113 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Abs extends TypedFloatScalarAbs<AngleUnit, FloatAngle.Abs, FloatAngle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final FloatAngle.Abs ZERO = new FloatAngle.Abs(0.0f, AngleUnit.SI);

        /**
         * Construct FloatAngle.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AngleUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAngle.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AngleUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatAngle.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatAngle.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngle.Abs instantiateTypeAbs(final float value, final AngleUnit unit)
        {
            return new FloatAngle.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAngle.Rel instantiateTypeRel(final float value, final AngleUnit unit)
        {
            return new FloatAngle.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAngle.Abs
            interpolate(final FloatAngle.Abs zero, final FloatAngle.Abs one, final float ratio)
        {
            return new FloatAngle.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                zero.getUnit());
        }

    }
}
