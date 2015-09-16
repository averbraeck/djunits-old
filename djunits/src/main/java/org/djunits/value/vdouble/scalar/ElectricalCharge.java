package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the ElectricalCharge DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass.Rel margin = new Mass.Rel(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface ElectricalCharge extends UNITS
{
    /**
     * Easy access methods for the ElectricalCharge DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
     * we can now write <br>
     * <i>Length.Rel margin = new Length.Rel(0.2, METER);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Rel extends DoubleScalar.Rel<ElectricalChargeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalCharge.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final ElectricalChargeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalCharge.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<ElectricalChargeUnit> value)
        {
            super(value);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static ElectricalCharge.Rel interpolate(final ElectricalCharge.Rel zero, final ElectricalCharge.Rel one,
                final double ratio)
        {
            return new ElectricalCharge.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                    zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel abs()
        {
            return new ElectricalCharge.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel acos()
        {
            return new ElectricalCharge.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel asin()
        {
            return new ElectricalCharge.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel atan()
        {
            return new ElectricalCharge.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel cbrt()
        {
            return new ElectricalCharge.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel ceil()
        {
            return new ElectricalCharge.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel cos()
        {
            return new ElectricalCharge.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel cosh()
        {
            return new ElectricalCharge.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel exp()
        {
            return new ElectricalCharge.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel expm1()
        {
            return new ElectricalCharge.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel floor()
        {
            return new ElectricalCharge.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel log()
        {
            return new ElectricalCharge.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel log10()
        {
            return new ElectricalCharge.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel log1p()
        {
            return new ElectricalCharge.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel rint()
        {
            return new ElectricalCharge.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel round()
        {
            return new ElectricalCharge.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel signum()
        {
            return new ElectricalCharge.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel sin()
        {
            return new ElectricalCharge.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel sinh()
        {
            return new ElectricalCharge.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel sqrt()
        {
            return new ElectricalCharge.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel tan()
        {
            return new ElectricalCharge.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel tanh()
        {
            return new ElectricalCharge.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel inv()
        {
            return new ElectricalCharge.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel toDegrees()
        {
            return new ElectricalCharge.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel toRadians()
        {
            return new ElectricalCharge.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel pow(final double x)
        {
            return new ElectricalCharge.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel multiplyBy(final double factor)
        {
            return new ElectricalCharge.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Rel divideBy(final double divisor)
        {
            return new ElectricalCharge.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalCharge.Rel plus(final ElectricalCharge.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Rel(getInUnit() + v.getInUnit(), getUnit())
                    : new ElectricalCharge.Rel(this.si + v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalCharge.Rel minus(final ElectricalCharge.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new ElectricalCharge.Rel(this.si - v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalCharge.Abs plus(final ElectricalCharge.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new ElectricalCharge.Abs(this.si + v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative electricalcharge scalar.
         */
        public final ElectricalCharge.Abs toAbs()
        {
            return new ElectricalCharge.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalCharge and ElectricalCharge, which results in a Dimensionless scalar.
         * @param v ElectricalCharge scalar
         * @return Dimensionless scalar as a division of ElectricalCharge and ElectricalCharge
         */
        public final Dimensionless.Rel divideBy(final ElectricalCharge.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of ElectricalCharge and Time, which results in a ElectricalCurrent scalar.
         * @param v ElectricalCharge scalar
         * @return ElectricalCurrent scalar as a division of ElectricalCharge and Time
         */
        public final ElectricalCurrent.Rel divideBy(final Time.Rel v)
        {
            return new ElectricalCurrent.Rel(this.si / v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the division of ElectricalCharge and ElectricalCurrent, which results in a Time scalar.
         * @param v ElectricalCharge scalar
         * @return Time scalar as a division of ElectricalCharge and ElectricalCurrent
         */
        public final Time.Rel divideBy(final ElectricalCurrent.Rel v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

    }

    /**
     * Easy access methods for the ElectricalCharge DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;LengthUnit&gt; margin = new DoubleScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
     * we can now write <br>
     * <i>Length.Rel margin = new Length.Rel(0.2, METER);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    public static class Abs extends DoubleScalar.Abs<ElectricalChargeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalCharge.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final ElectricalChargeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalCharge.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<ElectricalChargeUnit> value)
        {
            super(value);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static ElectricalCharge.Abs interpolate(final ElectricalCharge.Abs zero, final ElectricalCharge.Abs one,
                final double ratio)
        {
            return new ElectricalCharge.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                    zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs abs()
        {
            return new ElectricalCharge.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs acos()
        {
            return new ElectricalCharge.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs asin()
        {
            return new ElectricalCharge.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs atan()
        {
            return new ElectricalCharge.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs cbrt()
        {
            return new ElectricalCharge.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs ceil()
        {
            return new ElectricalCharge.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs cos()
        {
            return new ElectricalCharge.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs cosh()
        {
            return new ElectricalCharge.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs exp()
        {
            return new ElectricalCharge.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs expm1()
        {
            return new ElectricalCharge.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs floor()
        {
            return new ElectricalCharge.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs log()
        {
            return new ElectricalCharge.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs log10()
        {
            return new ElectricalCharge.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs log1p()
        {
            return new ElectricalCharge.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs rint()
        {
            return new ElectricalCharge.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs round()
        {
            return new ElectricalCharge.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs signum()
        {
            return new ElectricalCharge.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs sin()
        {
            return new ElectricalCharge.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs sinh()
        {
            return new ElectricalCharge.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs sqrt()
        {
            return new ElectricalCharge.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs tan()
        {
            return new ElectricalCharge.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs tanh()
        {
            return new ElectricalCharge.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs inv()
        {
            return new ElectricalCharge.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs toDegrees()
        {
            return new ElectricalCharge.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs toRadians()
        {
            return new ElectricalCharge.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs pow(final double x)
        {
            return new ElectricalCharge.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs multiplyBy(final double factor)
        {
            return new ElectricalCharge.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCharge.Abs divideBy(final double divisor)
        {
            return new ElectricalCharge.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalCharge.Abs plus(final ElectricalCharge.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new ElectricalCharge.Abs(this.si + v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalCharge.Rel minus(final ElectricalCharge.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new ElectricalCharge.Rel(this.si - v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalCharge.Abs minus(final ElectricalCharge.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCharge.Abs(getInUnit() - v.getInUnit(), getUnit())
                    : new ElectricalCharge.Abs(this.si - v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute electricalcharge scalar.
         */
        public final ElectricalCharge.Rel toRel()
        {
            return new ElectricalCharge.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalCharge and ElectricalCharge, which results in a Dimensionless scalar.
         * @param v ElectricalCharge scalar
         * @return Dimensionless scalar as a division of ElectricalCharge and ElectricalCharge
         */
        public final Dimensionless.Abs divideBy(final ElectricalCharge.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of ElectricalCharge and Time, which results in a ElectricalCurrent scalar.
         * @param v ElectricalCharge scalar
         * @return ElectricalCurrent scalar as a division of ElectricalCharge and Time
         */
        public final ElectricalCurrent.Abs divideBy(final Time.Abs v)
        {
            return new ElectricalCurrent.Abs(this.si / v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the division of ElectricalCharge and ElectricalCurrent, which results in a Time scalar.
         * @param v ElectricalCharge scalar
         * @return Time scalar as a division of ElectricalCharge and ElectricalCurrent
         */
        public final Time.Abs divideBy(final ElectricalCurrent.Abs v)
        {
            return new Time.Abs(this.si / v.si, TimeUnit.SI);
        }

    }
}
