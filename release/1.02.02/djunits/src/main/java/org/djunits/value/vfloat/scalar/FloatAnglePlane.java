package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AnglePlane FloatScalar. Instead of <br>
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
public interface FloatAnglePlane
{
    /**
     * Easy access methods for the AnglePlane FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;AnglePlaneUnit&gt; value = new FloatScalar.Rel&lt;AnglePlaneUnit&gt;(100.0, AnglePlaneUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAnglePlane.Rel value = new FloatAnglePlane.Rel(100.0, AnglePlaneUnit.SI);</i><br>
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
    class Rel extends TypedFloatScalarRel<AnglePlaneUnit, FloatAnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAnglePlane.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAnglePlane.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatAnglePlane.Rel value)
        {
            super(value);
        }

        /**
         * Construct FloatAnglePlane.Rel scalar using a double value.
         * @param value double value
         * @param unit unit for the resulting float value
         */
        public Rel(final double value, final AnglePlaneUnit unit)
        {
            super((float) value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlane.Rel instantiateTypeRel(final float value, final AnglePlaneUnit unit)
        {
            return new FloatAnglePlane.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable FloatScalar of the right type. Each extending class must implement this method.
         * @param value the float value
         * @param unit the unit
         * @return A a new absolute instance of the FloatScalar of the right type
         */
        protected final FloatAnglePlane.Abs instantiateTypeAbs(final float value, final AnglePlaneUnit unit)
        {
            return new FloatAnglePlane.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAnglePlane.Rel interpolate(final FloatAnglePlane.Rel zero, final FloatAnglePlane.Rel one,
            final float ratio)
        {
            return new FloatAnglePlane.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FloatAnglePlane.Abs plus(final FloatAnglePlane.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleplane scalar.
         */
        public final FloatAnglePlane.Abs toAbs()
        {
            return new FloatAnglePlane.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FloatAnglePlane and FloatAnglePlane, which results in a FloatDimensionless scalar.
         * @param v FloatAnglePlane scalar
         * @return FloatDimensionless scalar as a division of FloatAnglePlane and FloatAnglePlane
         */
        public final FloatDimensionless.Rel divideBy(final FloatAnglePlane.Rel v)
        {
            return new FloatDimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the AnglePlane FloatScalar. Instead of <br>
     * <i>FloatScalar.Abs&lt;AnglePlaneUnit&gt; value = new FloatScalar.Abs&lt;AnglePlaneUnit&gt;(100.0, AnglePlaneUnit.SI);</i><br>
     * we can now write <br>
     * <i>FloatAnglePlane.Abs value = new FloatAnglePlane.Abs(100.0, AnglePlaneUnit.SI);</i><br>
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
    class Abs extends TypedFloatScalarAbs<AnglePlaneUnit, FloatAnglePlane.Abs, FloatAnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FloatAnglePlane.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FloatAnglePlane.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AnglePlaneUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct FloatAnglePlane.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatAnglePlane.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlane.Abs instantiateTypeAbs(final float value, final AnglePlaneUnit unit)
        {
            return new FloatAnglePlane.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final FloatAnglePlane.Rel instantiateTypeRel(final float value, final AnglePlaneUnit unit)
        {
            return new FloatAnglePlane.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static FloatAnglePlane.Abs interpolate(final FloatAnglePlane.Abs zero, final FloatAnglePlane.Abs one,
            final float ratio)
        {
            return new FloatAnglePlane.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

    }
}
