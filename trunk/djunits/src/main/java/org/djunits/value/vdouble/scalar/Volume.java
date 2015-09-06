package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.MoneyUnit;
import org.djunits.unit.TimeUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Volume DoubleScalar. Instead of <br>
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
public interface Volume extends UNITS
{
    /**
     * Easy access methods for the Volume DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<VolumeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Volume.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final VolumeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Volume.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<VolumeUnit> value)
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
        public static Volume.Rel interpolate(final Volume.Rel zero, final Volume.Rel one, final double ratio)
        {
            return new Volume.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel abs()
        {
            return new Volume.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel acos()
        {
            return new Volume.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel asin()
        {
            return new Volume.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel atan()
        {
            return new Volume.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel cbrt()
        {
            return new Volume.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel ceil()
        {
            return new Volume.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel cos()
        {
            return new Volume.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel cosh()
        {
            return new Volume.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel exp()
        {
            return new Volume.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel expm1()
        {
            return new Volume.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel floor()
        {
            return new Volume.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel log()
        {
            return new Volume.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel log10()
        {
            return new Volume.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel log1p()
        {
            return new Volume.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel rint()
        {
            return new Volume.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel round()
        {
            return new Volume.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel signum()
        {
            return new Volume.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel sin()
        {
            return new Volume.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel sinh()
        {
            return new Volume.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel sqrt()
        {
            return new Volume.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel tan()
        {
            return new Volume.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel tanh()
        {
            return new Volume.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel inv()
        {
            return new Volume.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel toDegrees()
        {
            return new Volume.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel toRadians()
        {
            return new Volume.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel pow(final double x)
        {
            return new Volume.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel multiplyBy(final double factor)
        {
            return new Volume.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Rel divideBy(final double divisor)
        {
            return new Volume.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Volume.Rel plus(final Volume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Volume.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Volume.Rel(
                this.si + v.si, VolumeUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Volume.Rel minus(final Volume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Volume.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Volume.Rel(
                this.si - v.si, VolumeUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Volume.Abs plus(final Volume.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Volume.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Volume.Abs(
                this.si + v.si, VolumeUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative volume scalar.
         */
        public final Volume.Abs toAbs()
        {
            return new Volume.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Volume and Volume, which results in a Dimensionless scalar.
         * @param v Volume scalar
         * @return Dimensionless scalar as a division of Volume and Volume
         */
        public final Dimensionless.Rel divideBy(final Volume.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and Density, which results in a Mass scalar.
         * @param v Volume scalar
         * @return Mass scalar as a multiplication of Volume and Density
         */
        public final Mass.Rel multiplyBy(final Density.Rel v)
        {
            return new Mass.Rel(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and Pressure, which results in a Energy scalar.
         * @param v Volume scalar
         * @return Energy scalar as a multiplication of Volume and Pressure
         */
        public final Energy.Rel multiplyBy(final Pressure.Rel v)
        {
            return new Energy.Rel(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of Volume and Length, which results in a Area scalar.
         * @param v Volume scalar
         * @return Area scalar as a division of Volume and Length
         */
        public final Area.Rel divideBy(final Length.Rel v)
        {
            return new Area.Rel(this.si / v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Volume and Area, which results in a Length scalar.
         * @param v Volume scalar
         * @return Length scalar as a division of Volume and Area
         */
        public final Length.Rel divideBy(final Area.Rel v)
        {
            return new Length.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and LinearDensity, which results in a Area scalar.
         * @param v Volume scalar
         * @return Area scalar as a multiplication of Volume and LinearDensity
         */
        public final Area.Rel multiplyBy(final LinearDensity.Rel v)
        {
            return new Area.Rel(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Volume and Time, which results in a FlowVolume scalar.
         * @param v Volume scalar
         * @return FlowVolume scalar as a division of Volume and Time
         */
        public final FlowVolume.Rel divideBy(final Time.Rel v)
        {
            return new FlowVolume.Rel(this.si / v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the division of Volume and FlowVolume, which results in a Time scalar.
         * @param v Volume scalar
         * @return Time scalar as a division of Volume and FlowVolume
         */
        public final Time.Rel divideBy(final FlowVolume.Rel v)
        {
            return new Time.Rel(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and MoneyPerVolume, which results in a Money scalar.
         * @param v Volume scalar
         * @return Money scalar as a multiplication of Volume and MoneyPerVolume
         */
        public final Money multiplyBy(final MoneyPerVolume v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }

    /**
     * Easy access methods for the Volume DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<VolumeUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Volume.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final VolumeUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Volume.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<VolumeUnit> value)
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
        public static Volume.Abs interpolate(final Volume.Abs zero, final Volume.Abs one, final double ratio)
        {
            return new Volume.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs abs()
        {
            return new Volume.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs acos()
        {
            return new Volume.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs asin()
        {
            return new Volume.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs atan()
        {
            return new Volume.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs cbrt()
        {
            return new Volume.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs ceil()
        {
            return new Volume.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs cos()
        {
            return new Volume.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs cosh()
        {
            return new Volume.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs exp()
        {
            return new Volume.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs expm1()
        {
            return new Volume.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs floor()
        {
            return new Volume.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs log()
        {
            return new Volume.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs log10()
        {
            return new Volume.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs log1p()
        {
            return new Volume.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs rint()
        {
            return new Volume.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs round()
        {
            return new Volume.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs signum()
        {
            return new Volume.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs sin()
        {
            return new Volume.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs sinh()
        {
            return new Volume.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs sqrt()
        {
            return new Volume.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs tan()
        {
            return new Volume.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs tanh()
        {
            return new Volume.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs inv()
        {
            return new Volume.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs toDegrees()
        {
            return new Volume.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs toRadians()
        {
            return new Volume.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs pow(final double x)
        {
            return new Volume.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs multiplyBy(final double factor)
        {
            return new Volume.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Volume.Abs divideBy(final double divisor)
        {
            return new Volume.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Volume.Abs plus(final Volume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Volume.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Volume.Abs(
                this.si + v.si, VolumeUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Volume.Rel minus(final Volume.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Volume.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Volume.Rel(
                this.si - v.si, VolumeUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Volume.Abs minus(final Volume.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Volume.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Volume.Abs(
                this.si - v.si, VolumeUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute volume scalar.
         */
        public final Volume.Rel toRel()
        {
            return new Volume.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Volume and Volume, which results in a Dimensionless scalar.
         * @param v Volume scalar
         * @return Dimensionless scalar as a division of Volume and Volume
         */
        public final Dimensionless.Abs divideBy(final Volume.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and Density, which results in a Mass scalar.
         * @param v Volume scalar
         * @return Mass scalar as a multiplication of Volume and Density
         */
        public final Mass.Abs multiplyBy(final Density.Abs v)
        {
            return new Mass.Abs(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and Pressure, which results in a Energy scalar.
         * @param v Volume scalar
         * @return Energy scalar as a multiplication of Volume and Pressure
         */
        public final Energy.Abs multiplyBy(final Pressure.Abs v)
        {
            return new Energy.Abs(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of Volume and Length, which results in a Area scalar.
         * @param v Volume scalar
         * @return Area scalar as a division of Volume and Length
         */
        public final Area.Abs divideBy(final Length.Abs v)
        {
            return new Area.Abs(this.si / v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Volume and Area, which results in a Length scalar.
         * @param v Volume scalar
         * @return Length scalar as a division of Volume and Area
         */
        public final Length.Abs divideBy(final Area.Abs v)
        {
            return new Length.Abs(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and LinearDensity, which results in a Area scalar.
         * @param v Volume scalar
         * @return Area scalar as a multiplication of Volume and LinearDensity
         */
        public final Area.Abs multiplyBy(final LinearDensity.Abs v)
        {
            return new Area.Abs(this.si * v.si, AreaUnit.SI);
        }

        /**
         * Calculate the division of Volume and Time, which results in a FlowVolume scalar.
         * @param v Volume scalar
         * @return FlowVolume scalar as a division of Volume and Time
         */
        public final FlowVolume.Abs divideBy(final Time.Abs v)
        {
            return new FlowVolume.Abs(this.si / v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the division of Volume and FlowVolume, which results in a Time scalar.
         * @param v Volume scalar
         * @return Time scalar as a division of Volume and FlowVolume
         */
        public final Time.Abs divideBy(final FlowVolume.Abs v)
        {
            return new Time.Abs(this.si / v.si, TimeUnit.SI);
        }

        /**
         * Calculate the multiplication of Volume and MoneyPerVolume, which results in a Money scalar.
         * @param v Volume scalar
         * @return Money scalar as a multiplication of Volume and MoneyPerVolume
         */
        public final Money multiplyBy(final MoneyPerVolume v)
        {
            return new Money(this.si * v.si, MoneyUnit.getStandardMoneyUnit());
        }

    }
}
