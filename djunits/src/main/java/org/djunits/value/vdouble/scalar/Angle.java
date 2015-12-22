package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AngleUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the Angle DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
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
public interface Angle
{
    /**
     * Easy access methods for the Relative Angle DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;AngleUnit&gt; value = new DoubleScalar.Rel&lt;AngleUnit&gt;(100.0, AngleUnit.SI);</i><br>
     * we can now write <br>
     * <i>Angle.Rel value = new Angle.Rel(100.0, AngleUnit.SI);</i><br>
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
    class Rel extends TypedDoubleScalarRel<AngleUnit, Angle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final Angle.Rel ZERO = new Angle.Rel(0.0, AngleUnit.SI);

        /**
         * Construct Angle.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final AngleUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Angle.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final Angle.Rel value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Angle.Rel instantiateTypeRel(final double value, final AngleUnit unit)
        {
            return new Angle.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
         * @param value the double value
         * @param unit the unit
         * @return A a new absolute instance of the DoubleScalar of the right type
         */
        protected final Angle.Abs instantiateTypeAbs(final double value, final AngleUnit unit)
        {
            return new Angle.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Angle.Rel interpolate(final Angle.Rel zero, final Angle.Rel one, final double ratio)
        {
            return new Angle.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Angle.Abs plus(final Angle.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angle scalar.
         */
        public final Angle.Abs toAbs()
        {
            return new Angle.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Angle and Angle, which results in a Dimensionless scalar.
         * @param v Angle scalar
         * @return Dimensionless scalar as a division of Angle and Angle
         */
        public final Dimensionless divideBy(final Angle.Rel v)
        {
            return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the Absolute Angle DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;AngleUnit&gt; value = new DoubleScalar.Abs&lt;AngleUnit&gt;(100.0, AngleUnit.SI);</i><br>
     * we can now write <br>
     * <i>Angle.Abs value = new Angle.Abs(100.0, AngleUnit.SI);</i><br>
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
    class Abs extends TypedDoubleScalarAbs<AngleUnit, Angle.Abs, Angle.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /** constant with value zero. */
        public static final Angle.Abs ZERO = new Angle.Abs(0.0, AngleUnit.SI);

        /**
         * Construct Angle.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final AngleUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Angle.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final Angle.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final Angle.Abs instantiateTypeAbs(final double value, final AngleUnit unit)
        {
            return new Angle.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final Angle.Rel instantiateTypeRel(final double value, final AngleUnit unit)
        {
            return new Angle.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Angle.Abs interpolate(final Angle.Abs zero, final Angle.Abs one, final double ratio)
        {
            return new Angle.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

    }
}
