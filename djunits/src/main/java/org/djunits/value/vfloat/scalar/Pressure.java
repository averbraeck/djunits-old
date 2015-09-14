package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Pressure FloatScalar. Instead of <br>
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
public interface Pressure extends UNITS
{
    /**
     * Easy access methods for the Pressure FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<PressureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Pressure.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final PressureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Pressure.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final PressureUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Pressure.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<PressureUnit> value)
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
        public static Pressure.Rel interpolate(final Pressure.Rel zero, final Pressure.Rel one, final float ratio)
        {
            return new Pressure.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Pressure.Rel interpolate(final Pressure.Rel zero, final Pressure.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel abs()
        {
            return new Pressure.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel acos()
        {
            return new Pressure.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel asin()
        {
            return new Pressure.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel atan()
        {
            return new Pressure.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel cbrt()
        {
            return new Pressure.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel ceil()
        {
            return new Pressure.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel cos()
        {
            return new Pressure.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel cosh()
        {
            return new Pressure.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel exp()
        {
            return new Pressure.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel expm1()
        {
            return new Pressure.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel floor()
        {
            return new Pressure.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel log()
        {
            return new Pressure.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel log10()
        {
            return new Pressure.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel log1p()
        {
            return new Pressure.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel rint()
        {
            return new Pressure.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel round()
        {
            return new Pressure.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel signum()
        {
            return new Pressure.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel sin()
        {
            return new Pressure.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel sinh()
        {
            return new Pressure.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel sqrt()
        {
            return new Pressure.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel tan()
        {
            return new Pressure.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel tanh()
        {
            return new Pressure.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel inv()
        {
            return new Pressure.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel toDegrees()
        {
            return new Pressure.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel toRadians()
        {
            return new Pressure.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel pow(final double x)
        {
            return new Pressure.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel multiplyBy(final float factor)
        {
            return new Pressure.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative pressure
         */
        public final Pressure.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Rel divideBy(final float divisor)
        {
            return new Pressure.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative pressure
         */
        public final Pressure.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Pressure.Rel plus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Pressure.Rel(this.si + v.si, PressureUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Pressure.Rel minus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Pressure.Rel(this.si - v.si, PressureUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Pressure.Abs plus(final Pressure.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Pressure.Abs(this.si + v.si, PressureUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative pressure scalar.
         */
        public final Pressure.Abs toAbs()
        {
            return new Pressure.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Pressure and Pressure, which results in a Dimensionless scalar.
         * @param v Pressure scalar
         * @return Dimensionless scalar as a division of Pressure and Pressure
         */
        public final Dimensionless.Rel divideBy(final Pressure.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Pressure and Area, which results in a Force scalar.
         * @param v Pressure scalar
         * @return Force scalar as a multiplication of Pressure and Area
         */
        public final Force.Rel multiplyBy(final Area.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Pressure and Volume, which results in a Energy scalar.
         * @param v Pressure scalar
         * @return Energy scalar as a multiplication of Pressure and Volume
         */
        public final Energy.Rel multiplyBy(final Volume.Rel v)
        {
            return new Energy.Rel(this.si * v.si, EnergyUnit.SI);
        }

    }

    /**
     * Easy access methods for the Pressure FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<PressureUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Pressure.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final PressureUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Pressure.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final PressureUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Pressure.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<PressureUnit> value)
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
        public static Pressure.Abs interpolate(final Pressure.Abs zero, final Pressure.Abs one, final float ratio)
        {
            return new Pressure.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Pressure.Abs interpolate(final Pressure.Abs zero, final Pressure.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs abs()
        {
            return new Pressure.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs acos()
        {
            return new Pressure.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs asin()
        {
            return new Pressure.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs atan()
        {
            return new Pressure.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs cbrt()
        {
            return new Pressure.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs ceil()
        {
            return new Pressure.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs cos()
        {
            return new Pressure.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs cosh()
        {
            return new Pressure.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs exp()
        {
            return new Pressure.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs expm1()
        {
            return new Pressure.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs floor()
        {
            return new Pressure.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs log()
        {
            return new Pressure.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs log10()
        {
            return new Pressure.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs log1p()
        {
            return new Pressure.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs rint()
        {
            return new Pressure.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs round()
        {
            return new Pressure.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs signum()
        {
            return new Pressure.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs sin()
        {
            return new Pressure.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs sinh()
        {
            return new Pressure.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs sqrt()
        {
            return new Pressure.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs tan()
        {
            return new Pressure.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs tanh()
        {
            return new Pressure.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs inv()
        {
            return new Pressure.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs toDegrees()
        {
            return new Pressure.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs toRadians()
        {
            return new Pressure.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs pow(final double x)
        {
            return new Pressure.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs multiplyBy(final float factor)
        {
            return new Pressure.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute pressure
         */
        public final Pressure.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Pressure.Abs divideBy(final float divisor)
        {
            return new Pressure.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute pressure
         */
        public final Pressure.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Pressure.Abs plus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Pressure.Abs(this.si + v.si, PressureUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Pressure.Rel minus(final Pressure.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Pressure.Rel(this.si - v.si, PressureUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Pressure.Abs minus(final Pressure.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Pressure.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Pressure.Abs(this.si - v.si, PressureUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute pressure scalar.
         */
        public final Pressure.Rel toRel()
        {
            return new Pressure.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Pressure and Pressure, which results in a Dimensionless scalar.
         * @param v Pressure scalar
         * @return Dimensionless scalar as a division of Pressure and Pressure
         */
        public final Dimensionless.Abs divideBy(final Pressure.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Pressure and Area, which results in a Force scalar.
         * @param v Pressure scalar
         * @return Force scalar as a multiplication of Pressure and Area
         */
        public final Force.Abs multiplyBy(final Area.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of Pressure and Volume, which results in a Energy scalar.
         * @param v Pressure scalar
         * @return Energy scalar as a multiplication of Pressure and Volume
         */
        public final Energy.Abs multiplyBy(final Volume.Abs v)
        {
            return new Energy.Abs(this.si * v.si, EnergyUnit.SI);
        }

    }
}