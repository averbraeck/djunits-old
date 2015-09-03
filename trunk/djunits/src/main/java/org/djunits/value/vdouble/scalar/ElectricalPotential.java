package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.ElectricalResistanceUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the ElectricalPotential DoubleScalar. Instead of <br>
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
public interface ElectricalPotential extends UNITS
{
    /**
     * Easy access methods for the ElectricalPotential DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<ElectricalPotentialUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalPotential.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final ElectricalPotentialUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalPotential.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<ElectricalPotentialUnit> value)
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
            final ElectricalPotential.Rel one, final double ratio)
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
            return new ElectricalPotential.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel asin()
        {
            return new ElectricalPotential.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel atan()
        {
            return new ElectricalPotential.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel cbrt()
        {
            return new ElectricalPotential.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel ceil()
        {
            return new ElectricalPotential.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel cos()
        {
            return new ElectricalPotential.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel cosh()
        {
            return new ElectricalPotential.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel exp()
        {
            return new ElectricalPotential.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel expm1()
        {
            return new ElectricalPotential.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel floor()
        {
            return new ElectricalPotential.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel log()
        {
            return new ElectricalPotential.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel log10()
        {
            return new ElectricalPotential.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel log1p()
        {
            return new ElectricalPotential.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel rint()
        {
            return new ElectricalPotential.Rel(Math.rint(getInUnit()), getUnit());
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
            return new ElectricalPotential.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel sinh()
        {
            return new ElectricalPotential.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel sqrt()
        {
            return new ElectricalPotential.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel tan()
        {
            return new ElectricalPotential.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel tanh()
        {
            return new ElectricalPotential.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel inv()
        {
            return new ElectricalPotential.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel toDegrees()
        {
            return new ElectricalPotential.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel toRadians()
        {
            return new ElectricalPotential.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel pow(final double x)
        {
            return new ElectricalPotential.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel multiplyBy(final double factor)
        {
            return new ElectricalPotential.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Rel divideBy(final double divisor)
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
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative electricalpotential scalar.
         */
        public final ElectricalPotential.Abs toAbs()
        {
            return new ElectricalPotential.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalPotential and ElectricalPotential, which results in a Dimensionless scalar.
         * @param v ElectricalPotential scalar
         * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
         */
        public final Dimensionless.Rel divideBy(final ElectricalPotential.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalPotential and ElectricalCurrent, which results in a Power scalar.
         * @param v ElectricalPotential scalar
         * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
         */
        public final Power.Rel multiplyBy(final ElectricalCurrent.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of ElectricalPotential and ElectricalCurrent, which results in a ElectricalResistance scalar.
         * @param v ElectricalPotential scalar
         * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
         */
        public final ElectricalResistance.Rel divideBy(final ElectricalCurrent.Rel v)
        {
            return new ElectricalResistance.Rel(this.si / v.si, ElectricalResistanceUnit.SI);
        }

    }

    /**
     * Easy access methods for the ElectricalPotential DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<ElectricalPotentialUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct ElectricalPotential.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final ElectricalPotentialUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct ElectricalPotential.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<ElectricalPotentialUnit> value)
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
            final ElectricalPotential.Abs one, final double ratio)
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
            return new ElectricalPotential.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs asin()
        {
            return new ElectricalPotential.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs atan()
        {
            return new ElectricalPotential.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs cbrt()
        {
            return new ElectricalPotential.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs ceil()
        {
            return new ElectricalPotential.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs cos()
        {
            return new ElectricalPotential.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs cosh()
        {
            return new ElectricalPotential.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs exp()
        {
            return new ElectricalPotential.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs expm1()
        {
            return new ElectricalPotential.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs floor()
        {
            return new ElectricalPotential.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs log()
        {
            return new ElectricalPotential.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs log10()
        {
            return new ElectricalPotential.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs log1p()
        {
            return new ElectricalPotential.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs rint()
        {
            return new ElectricalPotential.Abs(Math.rint(getInUnit()), getUnit());
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
            return new ElectricalPotential.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs sinh()
        {
            return new ElectricalPotential.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs sqrt()
        {
            return new ElectricalPotential.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs tan()
        {
            return new ElectricalPotential.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs tanh()
        {
            return new ElectricalPotential.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs inv()
        {
            return new ElectricalPotential.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs toDegrees()
        {
            return new ElectricalPotential.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs toRadians()
        {
            return new ElectricalPotential.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs pow(final double x)
        {
            return new ElectricalPotential.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs multiplyBy(final double factor)
        {
            return new ElectricalPotential.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final ElectricalPotential.Abs divideBy(final double divisor)
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
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute electricalpotential scalar.
         */
        public final ElectricalPotential.Rel toRel()
        {
            return new ElectricalPotential.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of ElectricalPotential and ElectricalPotential, which results in a Dimensionless scalar.
         * @param v ElectricalPotential scalar
         * @return Dimensionless scalar as a division of ElectricalPotential and ElectricalPotential
         */
        public final Dimensionless.Abs divideBy(final ElectricalPotential.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of ElectricalPotential and ElectricalCurrent, which results in a Power scalar.
         * @param v ElectricalPotential scalar
         * @return Power scalar as a multiplication of ElectricalPotential and ElectricalCurrent
         */
        public final Power.Abs multiplyBy(final ElectricalCurrent.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the division of ElectricalPotential and ElectricalCurrent, which results in a ElectricalResistance scalar.
         * @param v ElectricalPotential scalar
         * @return ElectricalResistance scalar as a division of ElectricalPotential and ElectricalCurrent
         */
        public final ElectricalResistance.Abs divideBy(final ElectricalCurrent.Abs v)
        {
            return new ElectricalResistance.Abs(this.si / v.si, ElectricalResistanceUnit.SI);
        }

    }
}
