package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the FlowVolume DoubleScalar. Instead of <br>
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
public interface FlowVolume extends UNITS
{
    /**
     * Easy access methods for the FlowVolume DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<FlowVolumeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FlowVolume.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final FlowVolumeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FlowVolume.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<FlowVolumeUnit> value)
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
        public static FlowVolume.Rel interpolate(final FlowVolume.Rel zero, final FlowVolume.Rel one, final double ratio)
        {
            return new FlowVolume.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel abs()
        {
            return new FlowVolume.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel acos()
        {
            return new FlowVolume.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel asin()
        {
            return new FlowVolume.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel atan()
        {
            return new FlowVolume.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel cbrt()
        {
            return new FlowVolume.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel ceil()
        {
            return new FlowVolume.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel cos()
        {
            return new FlowVolume.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel cosh()
        {
            return new FlowVolume.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel exp()
        {
            return new FlowVolume.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel expm1()
        {
            return new FlowVolume.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel floor()
        {
            return new FlowVolume.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel log()
        {
            return new FlowVolume.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel log10()
        {
            return new FlowVolume.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel log1p()
        {
            return new FlowVolume.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel rint()
        {
            return new FlowVolume.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel round()
        {
            return new FlowVolume.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel signum()
        {
            return new FlowVolume.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel sin()
        {
            return new FlowVolume.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel sinh()
        {
            return new FlowVolume.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel sqrt()
        {
            return new FlowVolume.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel tan()
        {
            return new FlowVolume.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel tanh()
        {
            return new FlowVolume.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel inv()
        {
            return new FlowVolume.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel toDegrees()
        {
            return new FlowVolume.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel toRadians()
        {
            return new FlowVolume.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel pow(final double x)
        {
            return new FlowVolume.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel multiplyBy(final double factor)
        {
            return new FlowVolume.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Rel divideBy(final double divisor)
        {
            return new FlowVolume.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FlowVolume.Rel plus(final FlowVolume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowVolume.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FlowVolume.Rel(this.si + v.si, FlowVolumeUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FlowVolume.Rel minus(final FlowVolume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowVolume.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FlowVolume.Rel(this.si - v.si, FlowVolumeUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FlowVolume.Abs plus(final FlowVolume.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowVolume.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FlowVolume.Abs(this.si + v.si, FlowVolumeUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative flowvolume scalar.
         */
        public final FlowVolume.Abs toAbs()
        {
            return new FlowVolume.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FlowVolume and FlowVolume, which results in a Dimensionless scalar.
         * @param v FlowVolume scalar
         * @return Dimensionless scalar as a division of FlowVolume and FlowVolume
         */
        public final Dimensionless.Rel divideBy(final FlowVolume.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowVolume and Time, which results in a Volume scalar.
         * @param v FlowVolume scalar
         * @return Volume scalar as a multiplication of FlowVolume and Time
         */
        public final Volume.Rel multiplyBy(final Time.Rel v)
        {
            return new Volume.Rel(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FlowVolume and Frequency, which results in a Volume scalar.
         * @param v FlowVolume scalar
         * @return Volume scalar as a division of FlowVolume and Frequency
         */
        public final Volume.Rel divideBy(final Frequency.Rel v)
        {
            return new Volume.Rel(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FlowVolume and Volume, which results in a Frequency scalar.
         * @param v FlowVolume scalar
         * @return Frequency scalar as a division of FlowVolume and Volume
         */
        public final Frequency.Rel divideBy(final Volume.Rel v)
        {
            return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of FlowVolume and Area, which results in a Speed scalar.
         * @param v FlowVolume scalar
         * @return Speed scalar as a division of FlowVolume and Area
         */
        public final Speed.Rel divideBy(final Area.Rel v)
        {
            return new Speed.Rel(this.si / v.si, SpeedUnit.SI);
        }

    }

    /**
     * Easy access methods for the FlowVolume DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<FlowVolumeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FlowVolume.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final FlowVolumeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FlowVolume.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<FlowVolumeUnit> value)
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
        public static FlowVolume.Abs interpolate(final FlowVolume.Abs zero, final FlowVolume.Abs one, final double ratio)
        {
            return new FlowVolume.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs abs()
        {
            return new FlowVolume.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs acos()
        {
            return new FlowVolume.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs asin()
        {
            return new FlowVolume.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs atan()
        {
            return new FlowVolume.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs cbrt()
        {
            return new FlowVolume.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs ceil()
        {
            return new FlowVolume.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs cos()
        {
            return new FlowVolume.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs cosh()
        {
            return new FlowVolume.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs exp()
        {
            return new FlowVolume.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs expm1()
        {
            return new FlowVolume.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs floor()
        {
            return new FlowVolume.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs log()
        {
            return new FlowVolume.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs log10()
        {
            return new FlowVolume.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs log1p()
        {
            return new FlowVolume.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs rint()
        {
            return new FlowVolume.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs round()
        {
            return new FlowVolume.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs signum()
        {
            return new FlowVolume.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs sin()
        {
            return new FlowVolume.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs sinh()
        {
            return new FlowVolume.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs sqrt()
        {
            return new FlowVolume.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs tan()
        {
            return new FlowVolume.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs tanh()
        {
            return new FlowVolume.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs inv()
        {
            return new FlowVolume.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs toDegrees()
        {
            return new FlowVolume.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs toRadians()
        {
            return new FlowVolume.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs pow(final double x)
        {
            return new FlowVolume.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs multiplyBy(final double factor)
        {
            return new FlowVolume.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowVolume.Abs divideBy(final double divisor)
        {
            return new FlowVolume.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FlowVolume.Abs plus(final FlowVolume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowVolume.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FlowVolume.Abs(this.si + v.si, FlowVolumeUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FlowVolume.Rel minus(final FlowVolume.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowVolume.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FlowVolume.Rel(this.si - v.si, FlowVolumeUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FlowVolume.Abs minus(final FlowVolume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowVolume.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FlowVolume.Abs(this.si - v.si, FlowVolumeUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute flowvolume scalar.
         */
        public final FlowVolume.Rel toRel()
        {
            return new FlowVolume.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FlowVolume and FlowVolume, which results in a Dimensionless scalar.
         * @param v FlowVolume scalar
         * @return Dimensionless scalar as a division of FlowVolume and FlowVolume
         */
        public final Dimensionless.Abs divideBy(final FlowVolume.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowVolume and Time, which results in a Volume scalar.
         * @param v FlowVolume scalar
         * @return Volume scalar as a multiplication of FlowVolume and Time
         */
        public final Volume.Abs multiplyBy(final Time.Abs v)
        {
            return new Volume.Abs(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FlowVolume and Frequency, which results in a Volume scalar.
         * @param v FlowVolume scalar
         * @return Volume scalar as a division of FlowVolume and Frequency
         */
        public final Volume.Abs divideBy(final Frequency.Abs v)
        {
            return new Volume.Abs(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of FlowVolume and Volume, which results in a Frequency scalar.
         * @param v FlowVolume scalar
         * @return Frequency scalar as a division of FlowVolume and Volume
         */
        public final Frequency.Abs divideBy(final Volume.Abs v)
        {
            return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of FlowVolume and Area, which results in a Speed scalar.
         * @param v FlowVolume scalar
         * @return Speed scalar as a division of FlowVolume and Area
         */
        public final Speed.Abs divideBy(final Area.Abs v)
        {
            return new Speed.Abs(this.si / v.si, SpeedUnit.SI);
        }

    }
}
