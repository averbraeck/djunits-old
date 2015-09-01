package org.djunits.value.vfloat.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the ElectricalPotential FloatScalar. Instead of <br>
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
public interface ElectricalPotential extends UNITS
{
    /**
     * Easy access methods for the ElectricalPotential FloatScalar. Instead of <br>
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
    public static class Rel extends FloatScalar.Rel<ElectricalPotentialUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalPotential.Rel scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Rel(final float value, final ElectricalPotentialUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalPotential.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final FloatScalar.Rel<ElectricalPotentialUnit> value)
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
        public static ElectricalPotential.Rel interpolate(final ElectricalPotential.Rel zero,
            final ElectricalPotential.Rel one, final float ratio)
        {
            return new ElectricalPotential.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel abs()
        {
            return new ElectricalPotential.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel acos()
        {
            return new ElectricalPotential.Rel((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel asin()
        {
            return new ElectricalPotential.Rel((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel atan()
        {
            return new ElectricalPotential.Rel((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel cbrt()
        {
            return new ElectricalPotential.Rel((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel ceil()
        {
            return new ElectricalPotential.Rel((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel cos()
        {
            return new ElectricalPotential.Rel((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel cosh()
        {
            return new ElectricalPotential.Rel((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel exp()
        {
            return new ElectricalPotential.Rel((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel expm1()
        {
            return new ElectricalPotential.Rel((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel floor()
        {
            return new ElectricalPotential.Rel((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel log()
        {
            return new ElectricalPotential.Rel((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel log10()
        {
            return new ElectricalPotential.Rel((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel log1p()
        {
            return new ElectricalPotential.Rel((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel rint()
        {
            return new ElectricalPotential.Rel((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel round()
        {
            return new ElectricalPotential.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel signum()
        {
            return new ElectricalPotential.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel sin()
        {
            return new ElectricalPotential.Rel((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel sinh()
        {
            return new ElectricalPotential.Rel((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel sqrt()
        {
            return new ElectricalPotential.Rel((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel tan()
        {
            return new ElectricalPotential.Rel((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel tanh()
        {
            return new ElectricalPotential.Rel((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel inv()
        {
            return new ElectricalPotential.Rel(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel toDegrees()
        {
            return new ElectricalPotential.Rel((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel toRadians()
        {
            return new ElectricalPotential.Rel((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel pow(final double x)
        {
            return new ElectricalPotential.Rel((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel multiplyBy(final float factor)
        {
            return new ElectricalPotential.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel divideBy(final float divisor)
        {
            return new ElectricalPotential.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalPotential.Rel plus(final ElectricalPotential.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new ElectricalPotential.Rel(this.si + v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalPotential.Rel minus(final ElectricalPotential.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new ElectricalPotential.Rel(this.si - v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalPotential.Abs plus(final ElectricalPotential.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new ElectricalPotential.Abs(this.si + v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * @param v ElectricalPotential scalar
         * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
         */
        public final Dimensionless.Rel divideBy(final ElectricalPotential.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v ElectricalPotential scalar
         * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
         */
        public final Power.Rel multiplyBy(final ElectricalCurrent.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * @param v ElectricalPotential scalar
         * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
         */
        public final ElectricalResistance.Rel divideBy(final ElectricalCurrent.Rel v)
        {
            return new ElectricalResistance.Rel(this.si / v.si, ElectricalResistanceUnit.SI);
        }

    }

    /**
     * Easy access methods for the ElectricalPotential FloatScalar. Instead of <br>
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
    public static class Abs extends FloatScalar.Abs<ElectricalPotentialUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalPotential.Abs scalar.
         * @param value float value
         * @param unit unit for the float value
         */
        public Abs(final float value, final ElectricalPotentialUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalPotential.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final FloatScalar.Abs<ElectricalPotentialUnit> value)
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
        public static ElectricalPotential.Abs interpolate(final ElectricalPotential.Abs zero,
            final ElectricalPotential.Abs one, final float ratio)
        {
            return new ElectricalPotential.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs abs()
        {
            return new ElectricalPotential.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs acos()
        {
            return new ElectricalPotential.Abs((float) Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs asin()
        {
            return new ElectricalPotential.Abs((float) Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs atan()
        {
            return new ElectricalPotential.Abs((float) Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs cbrt()
        {
            return new ElectricalPotential.Abs((float) Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs ceil()
        {
            return new ElectricalPotential.Abs((float) Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs cos()
        {
            return new ElectricalPotential.Abs((float) Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs cosh()
        {
            return new ElectricalPotential.Abs((float) Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs exp()
        {
            return new ElectricalPotential.Abs((float) Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs expm1()
        {
            return new ElectricalPotential.Abs((float) Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs floor()
        {
            return new ElectricalPotential.Abs((float) Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs log()
        {
            return new ElectricalPotential.Abs((float) Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs log10()
        {
            return new ElectricalPotential.Abs((float) Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs log1p()
        {
            return new ElectricalPotential.Abs((float) Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs rint()
        {
            return new ElectricalPotential.Abs((float) Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs round()
        {
            return new ElectricalPotential.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs signum()
        {
            return new ElectricalPotential.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs sin()
        {
            return new ElectricalPotential.Abs((float) Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs sinh()
        {
            return new ElectricalPotential.Abs((float) Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs sqrt()
        {
            return new ElectricalPotential.Abs((float) Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs tan()
        {
            return new ElectricalPotential.Abs((float) Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs tanh()
        {
            return new ElectricalPotential.Abs((float) Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs inv()
        {
            return new ElectricalPotential.Abs(1.0f / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs toDegrees()
        {
            return new ElectricalPotential.Abs((float) Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs toRadians()
        {
            return new ElectricalPotential.Abs((float) Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs pow(final double x)
        {
            return new ElectricalPotential.Abs((float) Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs multiplyBy(final float factor)
        {
            return new ElectricalPotential.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs divideBy(final float divisor)
        {
            return new ElectricalPotential.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final ElectricalPotential.Abs plus(final ElectricalPotential.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new ElectricalPotential.Abs(this.si + v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalPotential.Rel minus(final ElectricalPotential.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new ElectricalPotential.Rel(this.si - v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final ElectricalPotential.Abs minus(final ElectricalPotential.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new ElectricalPotential.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new ElectricalPotential.Abs(this.si - v.si, ElectricalPotentialUnit.SI);
        }

        /**
         * @param v ElectricalPotential scalar
         * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
         */
        public final Dimensionless.Abs divideBy(final ElectricalPotential.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * @param v ElectricalPotential scalar
         * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
         */
        public final Power.Abs multiplyBy(final ElectricalCurrent.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * @param v ElectricalPotential scalar
         * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
         */
        public final ElectricalResistance.Abs divideBy(final ElectricalCurrent.Abs v)
        {
            return new ElectricalResistance.Abs(this.si / v.si, ElectricalResistanceUnit.SI);
        }

    }
}
