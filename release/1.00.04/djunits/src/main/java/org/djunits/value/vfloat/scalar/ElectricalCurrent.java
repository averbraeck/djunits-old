package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalChargeUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the ElectricalCurrent FloatScalar. Instead of <br>
 * <i>FloatScalar.Rel&lt;SomeUnit&gt; value = new FloatScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
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
public interface ElectricalCurrent extends UNITS
{
    /**
     * Easy access methods for the ElectricalCurrent FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;LengthUnit&gt; margin = new FloatScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
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
    public static class Rel extends FloatScalar.Rel<ElectricalCurrentUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalCurrent.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final ElectricalCurrentUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalCurrent.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final ElectricalCurrentUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct ElectricalCurrent.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<ElectricalCurrentUnit> value)
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
        public static ElectricalCurrent.Rel interpolate(final ElectricalCurrent.Rel zero, final ElectricalCurrent.Rel one,
                final float ratio)
        {
            return new ElectricalCurrent.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                    zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static ElectricalCurrent.Rel interpolate(final ElectricalCurrent.Rel zero, final ElectricalCurrent.Rel one,
                final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel abs()
        {
            return new ElectricalCurrent.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel acos()
        {
            return new ElectricalCurrent.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel asin()
        {
            return new ElectricalCurrent.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel atan()
        {
            return new ElectricalCurrent.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel cbrt()
        {
            return new ElectricalCurrent.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel ceil()
        {
            return new ElectricalCurrent.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel cos()
        {
            return new ElectricalCurrent.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel cosh()
        {
            return new ElectricalCurrent.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel exp()
        {
            return new ElectricalCurrent.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel expm1()
        {
            return new ElectricalCurrent.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel floor()
        {
            return new ElectricalCurrent.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel log()
        {
            return new ElectricalCurrent.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel log10()
        {
            return new ElectricalCurrent.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel log1p()
        {
            return new ElectricalCurrent.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel rint()
        {
            return new ElectricalCurrent.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel round()
        {
            return new ElectricalCurrent.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel signum()
        {
            return new ElectricalCurrent.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel sin()
        {
            return new ElectricalCurrent.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel sinh()
        {
            return new ElectricalCurrent.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel sqrt()
        {
            return new ElectricalCurrent.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel tan()
        {
            return new ElectricalCurrent.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel tanh()
        {
            return new ElectricalCurrent.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel inv()
        {
            return new ElectricalCurrent.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel toDegrees()
        {
            return new ElectricalCurrent.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel toRadians()
        {
            return new ElectricalCurrent.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel pow(final double x)
        {
            return new ElectricalCurrent.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel multiplyBy(final float factor)
        {
            return new ElectricalCurrent.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative electricalcurrent
         */
        public final ElectricalCurrent.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Rel divideBy(final float divisor)
        {
            return new ElectricalCurrent.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative electricalcurrent
         */
        public final ElectricalCurrent.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalCurrent.Rel plus(final ElectricalCurrent.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Rel(getInUnit() + v.getInUnit(), getUnit())
                    : new ElectricalCurrent.Rel(this.si + v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalCurrent.Rel minus(final ElectricalCurrent.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new ElectricalCurrent.Rel(this.si - v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalCurrent.Abs plus(final ElectricalCurrent.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new ElectricalCurrent.Abs(this.si + v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative electricalcurrent scalar.
         */
        public final ElectricalCurrent.Abs toAbs()
        {
            return new ElectricalCurrent.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalCurrent and ElectricalCurrent, which results in a Dimensionless scalar.
         * @param v ElectricalCurrent scalar
         * @return Dimensionless scalar as a division of ElectricalCurrent and ElectricalCurrent
         */
        public final Dimensionless.Rel divideBy(final ElectricalCurrent.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and ElectricalPotential, which results in a Power scalar.
         * @param v ElectricalCurrent scalar
         * @return Power scalar as a multiplication of ElectricalCurrent and ElectricalPotential
         */
        public final Power.Rel multiplyBy(final ElectricalPotential.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and Time, which results in a ElectricalCharge scalar.
         * @param v ElectricalCurrent scalar
         * @return ElectricalCharge scalar as a multiplication of ElectricalCurrent and Time
         */
        public final ElectricalCharge.Rel multiplyBy(final Time.Rel v)
        {
            return new ElectricalCharge.Rel(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and ElectricalResistance, which results in a ElectricalPotential
         * scalar.
         * @param v ElectricalCurrent scalar
         * @return ElectricalPotential scalar as a multiplication of ElectricalCurrent and ElectricalResistance
         */
        public final ElectricalPotential.Rel multiplyBy(final ElectricalResistance.Rel v)
        {
            return new ElectricalPotential.Rel(this.si * v.si, ElectricalPotentialUnit.SI);
        }

    }

    /**
     * Easy access methods for the ElectricalCurrent FloatScalar. Instead of <br>
     * <i>FloatScalar.Rel&lt;LengthUnit&gt; margin = new FloatScalar.Rel&lt;LengthUnit&gt;(0.2, LengthUnit.METER);</i><br>
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
    public static class Abs extends FloatScalar.Abs<ElectricalCurrentUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalCurrent.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final ElectricalCurrentUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalCurrent.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final ElectricalCurrentUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct ElectricalCurrent.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<ElectricalCurrentUnit> value)
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
        public static ElectricalCurrent.Abs interpolate(final ElectricalCurrent.Abs zero, final ElectricalCurrent.Abs one,
                final float ratio)
        {
            return new ElectricalCurrent.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio,
                    zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static ElectricalCurrent.Abs interpolate(final ElectricalCurrent.Abs zero, final ElectricalCurrent.Abs one,
                final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs abs()
        {
            return new ElectricalCurrent.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs acos()
        {
            return new ElectricalCurrent.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs asin()
        {
            return new ElectricalCurrent.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs atan()
        {
            return new ElectricalCurrent.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs cbrt()
        {
            return new ElectricalCurrent.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs ceil()
        {
            return new ElectricalCurrent.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs cos()
        {
            return new ElectricalCurrent.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs cosh()
        {
            return new ElectricalCurrent.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs exp()
        {
            return new ElectricalCurrent.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs expm1()
        {
            return new ElectricalCurrent.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs floor()
        {
            return new ElectricalCurrent.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs log()
        {
            return new ElectricalCurrent.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs log10()
        {
            return new ElectricalCurrent.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs log1p()
        {
            return new ElectricalCurrent.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs rint()
        {
            return new ElectricalCurrent.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs round()
        {
            return new ElectricalCurrent.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs signum()
        {
            return new ElectricalCurrent.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs sin()
        {
            return new ElectricalCurrent.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs sinh()
        {
            return new ElectricalCurrent.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs sqrt()
        {
            return new ElectricalCurrent.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs tan()
        {
            return new ElectricalCurrent.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs tanh()
        {
            return new ElectricalCurrent.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs inv()
        {
            return new ElectricalCurrent.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs toDegrees()
        {
            return new ElectricalCurrent.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs toRadians()
        {
            return new ElectricalCurrent.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs pow(final double x)
        {
            return new ElectricalCurrent.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs multiplyBy(final float factor)
        {
            return new ElectricalCurrent.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute electricalcurrent
         */
        public final ElectricalCurrent.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalCurrent.Abs divideBy(final float divisor)
        {
            return new ElectricalCurrent.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute electricalcurrent
         */
        public final ElectricalCurrent.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalCurrent.Abs plus(final ElectricalCurrent.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Abs(getInUnit() + v.getInUnit(), getUnit())
                    : new ElectricalCurrent.Abs(this.si + v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalCurrent.Rel minus(final ElectricalCurrent.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Rel(getInUnit() - v.getInUnit(), getUnit())
                    : new ElectricalCurrent.Rel(this.si - v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalCurrent.Abs minus(final ElectricalCurrent.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalCurrent.Abs(getInUnit() - v.getInUnit(), getUnit())
                    : new ElectricalCurrent.Abs(this.si - v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute electricalcurrent scalar.
         */
        public final ElectricalCurrent.Rel toRel()
        {
            return new ElectricalCurrent.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalCurrent and ElectricalCurrent, which results in a Dimensionless scalar.
         * @param v ElectricalCurrent scalar
         * @return Dimensionless scalar as a division of ElectricalCurrent and ElectricalCurrent
         */
        public final Dimensionless.Abs divideBy(final ElectricalCurrent.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and ElectricalPotential, which results in a Power scalar.
         * @param v ElectricalCurrent scalar
         * @return Power scalar as a multiplication of ElectricalCurrent and ElectricalPotential
         */
        public final Power.Abs multiplyBy(final ElectricalPotential.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and Time, which results in a ElectricalCharge scalar.
         * @param v ElectricalCurrent scalar
         * @return ElectricalCharge scalar as a multiplication of ElectricalCurrent and Time
         */
        public final ElectricalCharge.Abs multiplyBy(final Time.Abs v)
        {
            return new ElectricalCharge.Abs(this.si * v.si, ElectricalChargeUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalCurrent and ElectricalResistance, which results in a ElectricalPotential
         * scalar.
         * @param v ElectricalCurrent scalar
         * @return ElectricalPotential scalar as a multiplication of ElectricalCurrent and ElectricalResistance
         */
        public final ElectricalPotential.Abs multiplyBy(final ElectricalResistance.Abs v)
        {
            return new ElectricalPotential.Abs(this.si * v.si, ElectricalPotentialUnit.SI);
        }

    }
}
