package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the ElectricalResistance FloatScalar. Instead of <br>
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
public interface ElectricalResistance extends UNITS
{
    /**
     * Easy access methods for the ElectricalResistance FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<ElectricalResistanceUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalResistance.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final ElectricalResistanceUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalResistance.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final ElectricalResistanceUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct ElectricalResistance.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<ElectricalResistanceUnit> value)
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
        public static ElectricalResistance.Rel interpolate(final ElectricalResistance.Rel zero,
            final ElectricalResistance.Rel one, final float ratio)
        {
            return new ElectricalResistance.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static ElectricalResistance.Rel interpolate(final ElectricalResistance.Rel zero,
            final ElectricalResistance.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel abs()
        {
            return new ElectricalResistance.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel acos()
        {
            return new ElectricalResistance.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel asin()
        {
            return new ElectricalResistance.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel atan()
        {
            return new ElectricalResistance.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel cbrt()
        {
            return new ElectricalResistance.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel ceil()
        {
            return new ElectricalResistance.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel cos()
        {
            return new ElectricalResistance.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel cosh()
        {
            return new ElectricalResistance.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel exp()
        {
            return new ElectricalResistance.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel expm1()
        {
            return new ElectricalResistance.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel floor()
        {
            return new ElectricalResistance.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel log()
        {
            return new ElectricalResistance.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel log10()
        {
            return new ElectricalResistance.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel log1p()
        {
            return new ElectricalResistance.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel rint()
        {
            return new ElectricalResistance.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel round()
        {
            return new ElectricalResistance.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel signum()
        {
            return new ElectricalResistance.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel sin()
        {
            return new ElectricalResistance.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel sinh()
        {
            return new ElectricalResistance.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel sqrt()
        {
            return new ElectricalResistance.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel tan()
        {
            return new ElectricalResistance.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel tanh()
        {
            return new ElectricalResistance.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel inv()
        {
            return new ElectricalResistance.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel toDegrees()
        {
            return new ElectricalResistance.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel toRadians()
        {
            return new ElectricalResistance.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel pow(final double x)
        {
            return new ElectricalResistance.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel multiplyBy(final float factor)
        {
            return new ElectricalResistance.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative electricalresistance
         */
        public final ElectricalResistance.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Rel divideBy(final float divisor)
        {
            return new ElectricalResistance.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative electricalresistance
         */
        public final ElectricalResistance.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalResistance.Rel plus(final ElectricalResistance.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new ElectricalResistance.Rel(this.si + v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalResistance.Rel minus(final ElectricalResistance.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new ElectricalResistance.Rel(this.si - v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalResistance.Abs plus(final ElectricalResistance.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new ElectricalResistance.Abs(this.si + v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative electricalresistance scalar.
         */
        public final ElectricalResistance.Abs toAbs()
        {
            return new ElectricalResistance.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalResistance and ElectricalResistance, which results in a Dimensionless scalar.
         * @param v ElectricalResistance scalar
         * @return Dimensionless scalar as a division of ElectricalResistance and ElectricalResistance
         */
        public final Dimensionless.Rel divideBy(final ElectricalResistance.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalResistance and ElectricalCurrent, which results in a ElectricalPotential
         * scalar.
         * @param v ElectricalResistance scalar
         * @return ElectricalPotential scalar as a multiplication of ElectricalResistance and ElectricalCurrent
         */
        public final ElectricalPotential.Rel multiplyBy(final ElectricalCurrent.Rel v)
        {
            return new ElectricalPotential.Rel(this.si * v.si, ElectricalPotentialUnit.SI);
        }

    }

    /**
     * Easy access methods for the ElectricalResistance FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<ElectricalResistanceUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalResistance.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final ElectricalResistanceUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalResistance.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final ElectricalResistanceUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct ElectricalResistance.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<ElectricalResistanceUnit> value)
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
        public static ElectricalResistance.Abs interpolate(final ElectricalResistance.Abs zero,
            final ElectricalResistance.Abs one, final float ratio)
        {
            return new ElectricalResistance.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static ElectricalResistance.Abs interpolate(final ElectricalResistance.Abs zero,
            final ElectricalResistance.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs abs()
        {
            return new ElectricalResistance.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs acos()
        {
            return new ElectricalResistance.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs asin()
        {
            return new ElectricalResistance.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs atan()
        {
            return new ElectricalResistance.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs cbrt()
        {
            return new ElectricalResistance.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs ceil()
        {
            return new ElectricalResistance.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs cos()
        {
            return new ElectricalResistance.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs cosh()
        {
            return new ElectricalResistance.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs exp()
        {
            return new ElectricalResistance.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs expm1()
        {
            return new ElectricalResistance.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs floor()
        {
            return new ElectricalResistance.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs log()
        {
            return new ElectricalResistance.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs log10()
        {
            return new ElectricalResistance.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs log1p()
        {
            return new ElectricalResistance.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs rint()
        {
            return new ElectricalResistance.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs round()
        {
            return new ElectricalResistance.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs signum()
        {
            return new ElectricalResistance.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs sin()
        {
            return new ElectricalResistance.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs sinh()
        {
            return new ElectricalResistance.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs sqrt()
        {
            return new ElectricalResistance.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs tan()
        {
            return new ElectricalResistance.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs tanh()
        {
            return new ElectricalResistance.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs inv()
        {
            return new ElectricalResistance.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs toDegrees()
        {
            return new ElectricalResistance.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs toRadians()
        {
            return new ElectricalResistance.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs pow(final double x)
        {
            return new ElectricalResistance.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs multiplyBy(final float factor)
        {
            return new ElectricalResistance.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute electricalresistance
         */
        public final ElectricalResistance.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalResistance.Abs divideBy(final float divisor)
        {
            return new ElectricalResistance.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute electricalresistance
         */
        public final ElectricalResistance.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalResistance.Abs plus(final ElectricalResistance.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new ElectricalResistance.Abs(this.si + v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalResistance.Rel minus(final ElectricalResistance.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new ElectricalResistance.Rel(this.si - v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalResistance.Abs minus(final ElectricalResistance.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalResistance.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new ElectricalResistance.Abs(this.si - v.si, ElectricalResistanceUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute electricalresistance scalar.
         */
        public final ElectricalResistance.Rel toRel()
        {
            return new ElectricalResistance.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalResistance and ElectricalResistance, which results in a Dimensionless scalar.
         * @param v ElectricalResistance scalar
         * @return Dimensionless scalar as a division of ElectricalResistance and ElectricalResistance
         */
        public final Dimensionless.Abs divideBy(final ElectricalResistance.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalResistance and ElectricalCurrent, which results in a ElectricalPotential
         * scalar.
         * @param v ElectricalResistance scalar
         * @return ElectricalPotential scalar as a multiplication of ElectricalResistance and ElectricalCurrent
         */
        public final ElectricalPotential.Abs multiplyBy(final ElectricalCurrent.Abs v)
        {
            return new ElectricalPotential.Abs(this.si * v.si, ElectricalPotentialUnit.SI);
        }

    }
}
