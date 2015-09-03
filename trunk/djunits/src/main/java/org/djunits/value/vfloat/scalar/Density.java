package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DensityUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Density FloatScalar. Instead of <br>
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
public interface Density extends UNITS
{
    /**
     * Easy access methods for the Density FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<DensityUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Density.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final DensityUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Density.Rel scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final double value, final DensityUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Density.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<DensityUnit> value)
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
        public static Density.Rel interpolate(final Density.Rel zero, final Density.Rel one, final float ratio)
        {
            return new Density.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Density.Rel interpolate(final Density.Rel zero, final Density.Rel one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel abs()
        {
            return new Density.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel acos()
        {
            return new Density.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel asin()
        {
            return new Density.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel atan()
        {
            return new Density.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel cbrt()
        {
            return new Density.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel ceil()
        {
            return new Density.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel cos()
        {
            return new Density.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel cosh()
        {
            return new Density.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel exp()
        {
            return new Density.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel expm1()
        {
            return new Density.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel floor()
        {
            return new Density.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel log()
        {
            return new Density.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel log10()
        {
            return new Density.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel log1p()
        {
            return new Density.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel rint()
        {
            return new Density.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel round()
        {
            return new Density.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel signum()
        {
            return new Density.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel sin()
        {
            return new Density.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel sinh()
        {
            return new Density.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel sqrt()
        {
            return new Density.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel tan()
        {
            return new Density.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel tanh()
        {
            return new Density.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel inv()
        {
            return new Density.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel toDegrees()
        {
            return new Density.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel toRadians()
        {
            return new Density.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel pow(final double x)
        {
            return new Density.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel multiplyBy(final float factor)
        {
            return new Density.Rel(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of a relative density
         */
        public final Density.Rel multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Rel divideBy(final float divisor)
        {
            return new Density.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of a relative density
         */
        public final Density.Rel divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Density.Rel plus(final Density.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Density.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new Density.Rel(this.si + v.si, DensityUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Density.Rel minus(final Density.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Density.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Density.Rel(this.si - v.si, DensityUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Density.Abs plus(final Density.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Density.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Density.Abs(this.si + v.si, DensityUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative density scalar.
         */
        public final Density.Abs toAbs()
        {
            return new Density.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Density and Density, which results in a Dimensionless scalar.
         * @param v Density scalar
         * @return Dimensionless scalar as a division of Density and Density
         */
        public final Dimensionless.Rel divideBy(final Density.Abs v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Density and Density, which results in a Dimensionless scalar.
         * @param v Density scalar
         * @return Dimensionless scalar as a division of Density and Density
         */
        public final Dimensionless.Rel divideBy(final Density.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Density and Volume, which results in a Mass scalar.
         * @param v Density scalar
         * @return Mass scalar as a multiplication of Density and Volume
         */
        public final Mass.Rel multiplyBy(final Volume.Abs v)
        {
            return new Mass.Rel(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Density and Volume, which results in a Mass scalar.
         * @param v Density scalar
         * @return Mass scalar as a multiplication of Density and Volume
         */
        public final Mass.Rel multiplyBy(final Volume.Rel v)
        {
            return new Mass.Rel(this.si * v.si, MassUnit.SI);
        }

    }

    /**
     * Easy access methods for the Density FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<DensityUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Density.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final DensityUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Density.Abs scalar using a double value.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final double value, final DensityUnit unit)
        {
            super((float) value, unit);
        }

        /**
         * Construct Density.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<DensityUnit> value)
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
        public static Density.Abs interpolate(final Density.Abs zero, final Density.Abs one, final float ratio)
        {
            return new Density.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static Density.Abs interpolate(final Density.Abs zero, final Density.Abs one, final double ratio)
        {
            return interpolate(zero, one, (float) ratio);
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs abs()
        {
            return new Density.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs acos()
        {
            return new Density.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs asin()
        {
            return new Density.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs atan()
        {
            return new Density.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs cbrt()
        {
            return new Density.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs ceil()
        {
            return new Density.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs cos()
        {
            return new Density.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs cosh()
        {
            return new Density.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs exp()
        {
            return new Density.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs expm1()
        {
            return new Density.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs floor()
        {
            return new Density.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs log()
        {
            return new Density.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs log10()
        {
            return new Density.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs log1p()
        {
            return new Density.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs rint()
        {
            return new Density.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs round()
        {
            return new Density.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs signum()
        {
            return new Density.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs sin()
        {
            return new Density.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs sinh()
        {
            return new Density.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs sqrt()
        {
            return new Density.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs tan()
        {
            return new Density.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs tanh()
        {
            return new Density.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs inv()
        {
            return new Density.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs toDegrees()
        {
            return new Density.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs toRadians()
        {
            return new Density.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs pow(final double x)
        {
            return new Density.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs multiplyBy(final float factor)
        {
            return new Density.Abs(getInUnit() * factor, getUnit());
        }

        /**
         * Multiply scalar with a double factor.
         * @param factor the factor to multiply with
         * @return new instance of an absolute density
         */
        public final Density.Abs multiplyBy(final double factor)
        {
            return multiplyBy((float) factor);
        }

        /** {@inheritDoc} */
        @Override
        public final Density.Abs divideBy(final float divisor)
        {
            return new Density.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Divide scalar by a double factor.
         * @param factor the factor to divide by
         * @return new instance of an absolute density
         */
        public final Density.Abs divideBy(final double factor)
        {
            return divideBy((float) factor);
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Density.Abs plus(final Density.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Density.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new Density.Abs(this.si + v.si, DensityUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Density.Rel minus(final Density.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Density.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new Density.Rel(this.si - v.si, DensityUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Density.Abs minus(final Density.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Density.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new Density.Abs(this.si - v.si, DensityUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute density scalar.
         */
        public final Density.Rel toRel()
        {
            return new Density.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Density and Density, which results in a Dimensionless scalar.
         * @param v Density scalar
         * @return Dimensionless scalar as a division of Density and Density
         */
        public final Dimensionless.Abs divideBy(final Density.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of Density and Density, which results in a Dimensionless scalar.
         * @param v Density scalar
         * @return Dimensionless scalar as a division of Density and Density
         */
        public final Dimensionless.Abs divideBy(final Density.Rel v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Density and Volume, which results in a Mass scalar.
         * @param v Density scalar
         * @return Mass scalar as a multiplication of Density and Volume
         */
        public final Mass.Abs multiplyBy(final Volume.Abs v)
        {
            return new Mass.Abs(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of Density and Volume, which results in a Mass scalar.
         * @param v Density scalar
         * @return Mass scalar as a multiplication of Density and Volume
         */
        public final Mass.Abs multiplyBy(final Volume.Rel v)
        {
            return new Mass.Abs(this.si * v.si, MassUnit.SI);
        }

    }
}
