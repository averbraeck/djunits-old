package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.PressureUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Force FloatScalar. Instead of <br>
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
public interface Force extends UNITS
{
    /**
     * Easy access methods for the Force FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<ForceUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Force.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final ForceUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Force.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<ForceUnit> value)
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
        public static Force.Rel interpolate(final Force.Rel zero, final Force.Rel one, final float ratio)
        {
            return new Force.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel abs()
        {
            return new Force.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel acos()
        {
            return new Force.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel asin()
        {
            return new Force.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel atan()
        {
            return new Force.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel cbrt()
        {
            return new Force.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel ceil()
        {
            return new Force.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel cos()
        {
            return new Force.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel cosh()
        {
            return new Force.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel exp()
        {
            return new Force.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel expm1()
        {
            return new Force.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel floor()
        {
            return new Force.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel log()
        {
            return new Force.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel log10()
        {
            return new Force.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel log1p()
        {
            return new Force.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel rint()
        {
            return new Force.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel round()
        {
            return new Force.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel signum()
        {
            return new Force.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel sin()
        {
            return new Force.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel sinh()
        {
            return new Force.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel sqrt()
        {
            return new Force.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel tan()
        {
            return new Force.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel tanh()
        {
            return new Force.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel inv()
        {
            return new Force.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel toDegrees()
        {
            return new Force.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel toRadians()
        {
            return new Force.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel pow(final double x)
        {
            return new Force.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel multiplyBy(final float factor)
        {
            return new Force.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Rel divideBy(final float divisor)
        {
            return new Force.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Force.Rel plus(final Force.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Force.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Force.Rel(
                this.si + v.si, ForceUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Force.Rel minus(final Force.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Force.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Force.Rel(
                this.si - v.si, ForceUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Force.Abs plus(final Force.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Force.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Force.Abs(
                this.si + v.si, ForceUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Dimensionless scalar as a division of Force and Force
         */
        public final Dimensionless.Rel divideBy(final Force.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Energy scalar as a multiplication of Force and Length
         */
        public final Energy.Rel multiplyBy(final Length.Rel v)
        {
            return new Energy.Rel(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Energy scalar as a division of Force and LinearDensity
         */
        public final Energy.Rel divideBy(final LinearDensity.Rel v)
        {
            return new Energy.Rel(this.si / v.si, EnergyUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Power scalar as a multiplication of Force and Speed
         */
        public final Power.Rel multiplyBy(final Speed.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Acceleration scalar as a division of Force and Mass
         */
        public final Acceleration.Rel divideBy(final Mass.Rel v)
        {
            return new Acceleration.Rel(this.si / v.si, AccelerationUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Pressure scalar as a division of Force and Area
         */
        public final Pressure.Rel divideBy(final Area.Rel v)
        {
            return new Pressure.Rel(this.si / v.si, PressureUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Mass scalar as a division of Force and Acceleration
         */
        public final Mass.Rel divideBy(final Acceleration.Rel v)
        {
            return new Mass.Rel(this.si / v.si, MassUnit.SI);
        }

    }

    /**
     * Easy access methods for the Force FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<ForceUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Force.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final ForceUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Force.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<ForceUnit> value)
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
        public static Force.Abs interpolate(final Force.Abs zero, final Force.Abs one, final float ratio)
        {
            return new Force.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs abs()
        {
            return new Force.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs acos()
        {
            return new Force.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs asin()
        {
            return new Force.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs atan()
        {
            return new Force.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs cbrt()
        {
            return new Force.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs ceil()
        {
            return new Force.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs cos()
        {
            return new Force.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs cosh()
        {
            return new Force.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs exp()
        {
            return new Force.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs expm1()
        {
            return new Force.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs floor()
        {
            return new Force.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs log()
        {
            return new Force.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs log10()
        {
            return new Force.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs log1p()
        {
            return new Force.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs rint()
        {
            return new Force.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs round()
        {
            return new Force.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs signum()
        {
            return new Force.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs sin()
        {
            return new Force.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs sinh()
        {
            return new Force.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs sqrt()
        {
            return new Force.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs tan()
        {
            return new Force.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs tanh()
        {
            return new Force.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs inv()
        {
            return new Force.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs toDegrees()
        {
            return new Force.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs toRadians()
        {
            return new Force.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs pow(final double x)
        {
            return new Force.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs multiplyBy(final float factor)
        {
            return new Force.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Force.Abs divideBy(final float divisor)
        {
            return new Force.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Force.Abs plus(final Force.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Force.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Force.Abs(
                this.si + v.si, ForceUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Force.Rel minus(final Force.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Force.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Force.Rel(
                this.si - v.si, ForceUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Force.Abs minus(final Force.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Force.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Force.Abs(
                this.si - v.si, ForceUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Dimensionless scalar as a division of Force and Force
         */
        public final Dimensionless.Abs divideBy(final Force.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Energy scalar as a multiplication of Force and Length
         */
        public final Energy.Abs multiplyBy(final Length.Abs v)
        {
            return new Energy.Abs(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Energy scalar as a division of Force and LinearDensity
         */
        public final Energy.Abs divideBy(final LinearDensity.Abs v)
        {
            return new Energy.Abs(this.si / v.si, EnergyUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Power scalar as a multiplication of Force and Speed
         */
        public final Power.Abs multiplyBy(final Speed.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Acceleration scalar as a division of Force and Mass
         */
        public final Acceleration.Abs divideBy(final Mass.Abs v)
        {
            return new Acceleration.Abs(this.si / v.si, AccelerationUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Pressure scalar as a division of Force and Area
         */
        public final Pressure.Abs divideBy(final Area.Abs v)
        {
            return new Pressure.Abs(this.si / v.si, PressureUnit.SI);
        }

        /**
         * @param v Force scalar
         * @return Mass scalar as a division of Force and Acceleration
         */
        public final Mass.Abs divideBy(final Acceleration.Abs v)
        {
            return new Mass.Abs(this.si / v.si, MassUnit.SI);
        }

    }
}
