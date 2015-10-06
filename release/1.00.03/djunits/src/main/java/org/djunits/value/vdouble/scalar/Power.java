package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.ElectricalCurrentUnit;
import org.djunits.unit.ElectricalPotentialUnit;
import org.djunits.unit.EnergyUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.PowerUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the Power DoubleScalar. Instead of <br>
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
public interface Power extends UNITS
{
    /**
     * Easy access methods for the Power DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<PowerUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Power.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final PowerUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Power.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<PowerUnit> value)
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
        public static Power.Rel interpolate(final Power.Rel zero, final Power.Rel one, final double ratio)
        {
            return new Power.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel abs()
        {
            return new Power.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel acos()
        {
            return new Power.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel asin()
        {
            return new Power.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel atan()
        {
            return new Power.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel cbrt()
        {
            return new Power.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel ceil()
        {
            return new Power.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel cos()
        {
            return new Power.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel cosh()
        {
            return new Power.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel exp()
        {
            return new Power.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel expm1()
        {
            return new Power.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel floor()
        {
            return new Power.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel log()
        {
            return new Power.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel log10()
        {
            return new Power.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel log1p()
        {
            return new Power.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel rint()
        {
            return new Power.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel round()
        {
            return new Power.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel signum()
        {
            return new Power.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel sin()
        {
            return new Power.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel sinh()
        {
            return new Power.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel sqrt()
        {
            return new Power.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel tan()
        {
            return new Power.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel tanh()
        {
            return new Power.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel inv()
        {
            return new Power.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel toDegrees()
        {
            return new Power.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel toRadians()
        {
            return new Power.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel pow(final double x)
        {
            return new Power.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel multiplyBy(final double factor)
        {
            return new Power.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Rel divideBy(final double divisor)
        {
            return new Power.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Power.Rel plus(final Power.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Power.Rel(getInUnit() + v.getInUnit(), getUnit()) : new Power.Rel(
                    this.si + v.si, PowerUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Power.Rel minus(final Power.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Power.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Power.Rel(
                    this.si - v.si, PowerUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Power.Abs plus(final Power.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Power.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Power.Abs(
                    this.si + v.si, PowerUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative power scalar.
         */
        public final Power.Abs toAbs()
        {
            return new Power.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Power and Power, which results in a Dimensionless scalar.
         * @param v Power scalar
         * @return Dimensionless scalar as a division of Power and Power
         */
        public final Dimensionless.Rel divideBy(final Power.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Power and ElectricalCurrent, which results in a Power scalar.
         * @param v Power scalar
         * @return Power scalar as a multiplication of Power and ElectricalCurrent
         */
        public final Power.Rel multiplyBy(final ElectricalCurrent.Rel v)
        {
            return new Power.Rel(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Power and Time, which results in a Energy scalar.
         * @param v Power scalar
         * @return Energy scalar as a multiplication of Power and Time
         */
        public final Energy.Rel multiplyBy(final Time.Rel v)
        {
            return new Energy.Rel(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of Power and Frequency, which results in a Energy scalar.
         * @param v Power scalar
         * @return Energy scalar as a division of Power and Frequency
         */
        public final Energy.Rel divideBy(final Frequency.Rel v)
        {
            return new Energy.Rel(this.si / v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of Power and Speed, which results in a Force scalar.
         * @param v Power scalar
         * @return Force scalar as a division of Power and Speed
         */
        public final Force.Rel divideBy(final Speed.Rel v)
        {
            return new Force.Rel(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of Power and ElectricalPotential, which results in a ElectricalCurrent scalar.
         * @param v Power scalar
         * @return ElectricalCurrent scalar as a division of Power and ElectricalPotential
         */
        public final ElectricalCurrent.Rel divideBy(final ElectricalPotential.Rel v)
        {
            return new ElectricalCurrent.Rel(this.si / v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the division of Power and ElectricalCurrent, which results in a ElectricalPotential scalar.
         * @param v Power scalar
         * @return ElectricalPotential scalar as a division of Power and ElectricalCurrent
         */
        public final ElectricalPotential.Rel divideBy(final ElectricalCurrent.Rel v)
        {
            return new ElectricalPotential.Rel(this.si / v.si, ElectricalPotentialUnit.SI);
        }

    }

    /**
     * Easy access methods for the Power DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<PowerUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct Power.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final PowerUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct Power.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<PowerUnit> value)
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
        public static Power.Abs interpolate(final Power.Abs zero, final Power.Abs one, final double ratio)
        {
            return new Power.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs abs()
        {
            return new Power.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs acos()
        {
            return new Power.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs asin()
        {
            return new Power.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs atan()
        {
            return new Power.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs cbrt()
        {
            return new Power.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs ceil()
        {
            return new Power.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs cos()
        {
            return new Power.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs cosh()
        {
            return new Power.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs exp()
        {
            return new Power.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs expm1()
        {
            return new Power.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs floor()
        {
            return new Power.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs log()
        {
            return new Power.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs log10()
        {
            return new Power.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs log1p()
        {
            return new Power.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs rint()
        {
            return new Power.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs round()
        {
            return new Power.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs signum()
        {
            return new Power.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs sin()
        {
            return new Power.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs sinh()
        {
            return new Power.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs sqrt()
        {
            return new Power.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs tan()
        {
            return new Power.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs tanh()
        {
            return new Power.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs inv()
        {
            return new Power.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs toDegrees()
        {
            return new Power.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs toRadians()
        {
            return new Power.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs pow(final double x)
        {
            return new Power.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs multiplyBy(final double factor)
        {
            return new Power.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final Power.Abs divideBy(final double divisor)
        {
            return new Power.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final Power.Abs plus(final Power.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Power.Abs(getInUnit() + v.getInUnit(), getUnit()) : new Power.Abs(
                    this.si + v.si, PowerUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Power.Rel minus(final Power.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new Power.Rel(getInUnit() - v.getInUnit(), getUnit()) : new Power.Rel(
                    this.si - v.si, PowerUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final Power.Abs minus(final Power.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new Power.Abs(getInUnit() - v.getInUnit(), getUnit()) : new Power.Abs(
                    this.si - v.si, PowerUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute power scalar.
         */
        public final Power.Rel toRel()
        {
            return new Power.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of Power and Power, which results in a Dimensionless scalar.
         * @param v Power scalar
         * @return Dimensionless scalar as a division of Power and Power
         */
        public final Dimensionless.Abs divideBy(final Power.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of Power and ElectricalCurrent, which results in a Power scalar.
         * @param v Power scalar
         * @return Power scalar as a multiplication of Power and ElectricalCurrent
         */
        public final Power.Abs multiplyBy(final ElectricalCurrent.Abs v)
        {
            return new Power.Abs(this.si * v.si, PowerUnit.SI);
        }

        /**
         * Calculate the multiplication of Power and Time, which results in a Energy scalar.
         * @param v Power scalar
         * @return Energy scalar as a multiplication of Power and Time
         */
        public final Energy.Abs multiplyBy(final Time.Abs v)
        {
            return new Energy.Abs(this.si * v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of Power and Frequency, which results in a Energy scalar.
         * @param v Power scalar
         * @return Energy scalar as a division of Power and Frequency
         */
        public final Energy.Abs divideBy(final Frequency.Abs v)
        {
            return new Energy.Abs(this.si / v.si, EnergyUnit.SI);
        }

        /**
         * Calculate the division of Power and Speed, which results in a Force scalar.
         * @param v Power scalar
         * @return Force scalar as a division of Power and Speed
         */
        public final Force.Abs divideBy(final Speed.Abs v)
        {
            return new Force.Abs(this.si / v.si, ForceUnit.SI);
        }

        /**
         * Calculate the division of Power and ElectricalPotential, which results in a ElectricalCurrent scalar.
         * @param v Power scalar
         * @return ElectricalCurrent scalar as a division of Power and ElectricalPotential
         */
        public final ElectricalCurrent.Abs divideBy(final ElectricalPotential.Abs v)
        {
            return new ElectricalCurrent.Abs(this.si / v.si, ElectricalCurrentUnit.SI);
        }

        /**
         * Calculate the division of Power and ElectricalCurrent, which results in a ElectricalPotential scalar.
         * @param v Power scalar
         * @return ElectricalPotential scalar as a division of Power and ElectricalCurrent
         */
        public final ElectricalPotential.Abs divideBy(final ElectricalCurrent.Abs v)
        {
            return new ElectricalPotential.Abs(this.si / v.si, ElectricalPotentialUnit.SI);
        }

    }
}