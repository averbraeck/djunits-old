package org.djunits.value.vfloat.scalar;

import org.djunits.unit.AreaUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowVolumeUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.LengthUnit;
import org.djunits.unit.UNITS;
import org.djunits.unit.VolumeUnit;

/**
 * Easy access methods for the Area FloatScalar. Instead of <br>
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
public interface Area extends UNITS
{
    /**
     * Easy access methods for the Area FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<AreaUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Area.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final AreaUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Area.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final AreaUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Area.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<AreaUnit> value)
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
        public static Area.Rel interpolate(final Area.Rel zero, final Area.Rel one, final float ratio)
        {
            return new Area.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Area.Rel interpolate(final Area.Rel zero, final Area.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel abs()
        {
            return new Area.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel acos()
        {
            return new Area.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel asin()
        {
            return new Area.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel atan()
        {
            return new Area.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel cbrt()
        {
            return new Area.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel ceil()
        {
            return new Area.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel cos()
        {
            return new Area.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel cosh()
        {
            return new Area.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel exp()
        {
            return new Area.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel expm1()
        {
            return new Area.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel floor()
        {
            return new Area.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel log()
        {
            return new Area.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel log10()
        {
            return new Area.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel log1p()
        {
            return new Area.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel rint()
        {
            return new Area.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel round()
        {
            return new Area.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel signum()
        {
            return new Area.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel sin()
        {
            return new Area.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel sinh()
        {
            return new Area.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel sqrt()
        {
            return new Area.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel tan()
        {
            return new Area.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel tanh()
        {
            return new Area.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel inv()
        {
            return new Area.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel toDegrees()
        {
            return new Area.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel toRadians()
        {
            return new Area.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel pow(final double x)
        {
            return new Area.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel multiplyBy(final float factor)
        {
            return new Area.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative area
         */
        public final Area.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Rel divideBy(final float divisor)
        {
            return new Area.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative area
         */
        public final Area.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Area.Rel plus(final Area.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Area.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Area.Rel(this.si
                    + v.si, AreaUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Area.Rel minus(final Area.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Area.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Area.Rel(this.si
                    - v.si, AreaUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Area.Abs plus(final Area.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Area.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Area.Abs(this.si
                    + v.si, AreaUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative area scalar.
         */
        public final Area.Abs toAbs()
        {
            return new Area.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Area and Area, which results in a Dimensionless scalar.
         * @param v Area scalar
         * @return Dimensionless scalar as a division of Area and Area
         */
        public final Dimensionless.Rel divideBy(final Area.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and Length, which results in a Volume scalar.
         * @param v Area scalar
         * @return Volume scalar as a multiplication of Area and Length
         */
        public final Volume.Rel multiplyBy(final Length.Rel v)
        {
            return new Volume.Rel(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Area and LinearDensity, which results in a Volume scalar.
         * @param v Area scalar
         * @return Volume scalar as a division of Area and LinearDensity
         */
        public final Volume.Rel divideBy(final LinearDensity.Rel v)
        {
            return new Volume.Rel(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Area and Length, which results in a Length scalar.
         * @param v Area scalar
         * @return Length scalar as a division of Area and Length
         */
        public final Length.Rel divideBy(final Length.Rel v)
        {
            return new Length.Rel(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and LinearDensity, which results in a Length scalar.
         * @param v Area scalar
         * @return Length scalar as a multiplication of Area and LinearDensity
         */
        public final Length.Rel multiplyBy(final LinearDensity.Rel v)
        {
            return new Length.Rel(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and Speed, which results in a FlowVolume scalar.
         * @param v Area scalar
         * @return FlowVolume scalar as a multiplication of Area and Speed
         */
        public final FlowVolume.Rel multiplyBy(final Speed.Rel v)
        {
            return new FlowVolume.Rel(this.si * v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and Pressure, which results in a Force scalar.
         * @param v Area scalar
         * @return Force scalar as a multiplication of Area and Pressure
         */
        public final Force.Rel multiplyBy(final Pressure.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

    }

    /**
     * Easy access methods for the Area FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<AreaUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Area.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final AreaUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Area.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final AreaUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Area.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<AreaUnit> value)
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
        public static Area.Abs interpolate(final Area.Abs zero, final Area.Abs one, final float ratio)
        {
            return new Area.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Area.Abs interpolate(final Area.Abs zero, final Area.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs abs()
        {
            return new Area.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs acos()
        {
            return new Area.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs asin()
        {
            return new Area.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs atan()
        {
            return new Area.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs cbrt()
        {
            return new Area.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs ceil()
        {
            return new Area.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs cos()
        {
            return new Area.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs cosh()
        {
            return new Area.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs exp()
        {
            return new Area.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs expm1()
        {
            return new Area.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs floor()
        {
            return new Area.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs log()
        {
            return new Area.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs log10()
        {
            return new Area.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs log1p()
        {
            return new Area.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs rint()
        {
            return new Area.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs round()
        {
            return new Area.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs signum()
        {
            return new Area.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs sin()
        {
            return new Area.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs sinh()
        {
            return new Area.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs sqrt()
        {
            return new Area.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs tan()
        {
            return new Area.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs tanh()
        {
            return new Area.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs inv()
        {
            return new Area.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs toDegrees()
        {
            return new Area.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs toRadians()
        {
            return new Area.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs pow(final double x)
        {
            return new Area.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs multiplyBy(final float factor)
        {
            return new Area.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute area
         */
        public final Area.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Area.Abs divideBy(final float divisor)
        {
            return new Area.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute area
         */
        public final Area.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Area.Abs plus(final Area.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Area.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Area.Abs(this.si
                    + v.si, AreaUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Area.Rel minus(final Area.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Area.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Area.Rel(this.si
                    - v.si, AreaUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Area.Abs minus(final Area.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Area.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Area.Abs(this.si
                    - v.si, AreaUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute area scalar.
         */
        public final Area.Rel toRel()
        {
            return new Area.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Area and Area, which results in a Dimensionless scalar.
         * @param v Area scalar
         * @return Dimensionless scalar as a division of Area and Area
         */
        public final Dimensionless.Abs divideBy(final Area.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and Length, which results in a Volume scalar.
         * @param v Area scalar
         * @return Volume scalar as a multiplication of Area and Length
         */
        public final Volume.Abs multiplyBy(final Length.Abs v)
        {
            return new Volume.Abs(this.si * v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Area and LinearDensity, which results in a Volume scalar.
         * @param v Area scalar
         * @return Volume scalar as a division of Area and LinearDensity
         */
        public final Volume.Abs divideBy(final LinearDensity.Abs v)
        {
            return new Volume.Abs(this.si / v.si, VolumeUnit.SI);
        }

        /**
         * Calculate the division of Area and Length, which results in a Length scalar.
         * @param v Area scalar
         * @return Length scalar as a division of Area and Length
         */
        public final Length.Abs divideBy(final Length.Abs v)
        {
            return new Length.Abs(this.si / v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and LinearDensity, which results in a Length scalar.
         * @param v Area scalar
         * @return Length scalar as a multiplication of Area and LinearDensity
         */
        public final Length.Abs multiplyBy(final LinearDensity.Abs v)
        {
            return new Length.Abs(this.si * v.si, LengthUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and Speed, which results in a FlowVolume scalar.
         * @param v Area scalar
         * @return FlowVolume scalar as a multiplication of Area and Speed
         */
        public final FlowVolume.Abs multiplyBy(final Speed.Abs v)
        {
            return new FlowVolume.Abs(this.si * v.si, FlowVolumeUnit.SI);
        }

        /**
         * Calculate the multiplication of Area and Pressure, which results in a Force scalar.
         * @param v Area scalar
         * @return Force scalar as a multiplication of Area and Pressure
         */
        public final Force.Abs multiplyBy(final Pressure.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

    }
}
