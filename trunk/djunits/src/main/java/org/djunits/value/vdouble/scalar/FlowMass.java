package org.djunits.value.vdouble.scalar;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FlowMassUnit;
import org.djunits.unit.ForceUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.UNITS;

/**
 * Easy access methods for the FlowMass DoubleScalar. Instead of <br>
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
public interface FlowMass extends UNITS
{
    /**
     * Easy access methods for the FlowMass DoubleScalar. Instead of <br>
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
    public static class Rel extends DoubleScalar.Rel<FlowMassUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FlowMass.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final FlowMassUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FlowMass.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final DoubleScalar.Rel<FlowMassUnit> value)
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
        public static FlowMass.Rel interpolate(final FlowMass.Rel zero, final FlowMass.Rel one, final double ratio)
        {
            return new FlowMass.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel abs()
        {
            return new FlowMass.Rel(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel acos()
        {
            return new FlowMass.Rel(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel asin()
        {
            return new FlowMass.Rel(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel atan()
        {
            return new FlowMass.Rel(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel cbrt()
        {
            return new FlowMass.Rel(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel ceil()
        {
            return new FlowMass.Rel(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel cos()
        {
            return new FlowMass.Rel(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel cosh()
        {
            return new FlowMass.Rel(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel exp()
        {
            return new FlowMass.Rel(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel expm1()
        {
            return new FlowMass.Rel(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel floor()
        {
            return new FlowMass.Rel(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel log()
        {
            return new FlowMass.Rel(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel log10()
        {
            return new FlowMass.Rel(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel log1p()
        {
            return new FlowMass.Rel(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel rint()
        {
            return new FlowMass.Rel(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel round()
        {
            return new FlowMass.Rel(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel signum()
        {
            return new FlowMass.Rel(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel sin()
        {
            return new FlowMass.Rel(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel sinh()
        {
            return new FlowMass.Rel(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel sqrt()
        {
            return new FlowMass.Rel(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel tan()
        {
            return new FlowMass.Rel(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel tanh()
        {
            return new FlowMass.Rel(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel inv()
        {
            return new FlowMass.Rel(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel toDegrees()
        {
            return new FlowMass.Rel(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel toRadians()
        {
            return new FlowMass.Rel(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel pow(final double x)
        {
            return new FlowMass.Rel(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel multiplyBy(final double factor)
        {
            return new FlowMass.Rel(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Rel divideBy(final double divisor)
        {
            return new FlowMass.Rel(getInUnit() / divisor, getUnit());
        }

        /**
         * Relative scalar plus Relative scalar = Relative scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FlowMass.Rel plus(final FlowMass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowMass.Rel(getInUnit() + v.getInUnit(), getUnit())
                : new FlowMass.Rel(this.si + v.si, FlowMassUnit.SI);
        }

        /**
         * Relative scalar minus Relative scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FlowMass.Rel minus(final FlowMass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowMass.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FlowMass.Rel(this.si - v.si, FlowMassUnit.SI);
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FlowMass.Abs plus(final FlowMass.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowMass.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FlowMass.Abs(this.si + v.si, FlowMassUnit.SI);
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative flowmass scalar.
         */
        public final FlowMass.Abs toAbs()
        {
            return new FlowMass.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
         * @param v FlowMass scalar
         * @return Dimensionless scalar as a division of FlowMass and FlowMass
         */
        public final Dimensionless.Rel divideBy(final FlowMass.Abs v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
         * @param v FlowMass scalar
         * @return Dimensionless scalar as a division of FlowMass and FlowMass
         */
        public final Dimensionless.Rel divideBy(final FlowMass.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Time, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a multiplication of FlowMass and Time
         */
        public final Mass.Rel multiplyBy(final Time.Abs v)
        {
            return new Mass.Rel(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Time, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a multiplication of FlowMass and Time
         */
        public final Mass.Rel multiplyBy(final Time.Rel v)
        {
            return new Mass.Rel(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a division of FlowMass and Frequency
         */
        public final Mass.Rel divideBy(final Frequency.Abs v)
        {
            return new Mass.Rel(this.si / v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a division of FlowMass and Frequency
         */
        public final Mass.Rel divideBy(final Frequency.Rel v)
        {
            return new Mass.Rel(this.si / v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
         * @param v FlowMass scalar
         * @return Frequency scalar as a division of FlowMass and Mass
         */
        public final Frequency.Rel divideBy(final Mass.Abs v)
        {
            return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
         * @param v FlowMass scalar
         * @return Frequency scalar as a division of FlowMass and Mass
         */
        public final Frequency.Rel divideBy(final Mass.Rel v)
        {
            return new Frequency.Rel(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
         * @param v FlowMass scalar
         * @return Force scalar as a multiplication of FlowMass and Speed
         */
        public final Force.Rel multiplyBy(final Speed.Abs v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
         * @param v FlowMass scalar
         * @return Force scalar as a multiplication of FlowMass and Speed
         */
        public final Force.Rel multiplyBy(final Speed.Rel v)
        {
            return new Force.Rel(this.si * v.si, ForceUnit.SI);
        }

    }

    /**
     * Easy access methods for the FlowMass DoubleScalar. Instead of <br>
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
    public static class Abs extends DoubleScalar.Abs<FlowMassUnit>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct FlowMass.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final FlowMassUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct FlowMass.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final DoubleScalar.Abs<FlowMassUnit> value)
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
        public static FlowMass.Abs interpolate(final FlowMass.Abs zero, final FlowMass.Abs one, final double ratio)
        {
            return new FlowMass.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero.getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs abs()
        {
            return new FlowMass.Abs(Math.abs(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs acos()
        {
            return new FlowMass.Abs(Math.acos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs asin()
        {
            return new FlowMass.Abs(Math.asin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs atan()
        {
            return new FlowMass.Abs(Math.atan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs cbrt()
        {
            return new FlowMass.Abs(Math.cbrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs ceil()
        {
            return new FlowMass.Abs(Math.ceil(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs cos()
        {
            return new FlowMass.Abs(Math.cos(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs cosh()
        {
            return new FlowMass.Abs(Math.cosh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs exp()
        {
            return new FlowMass.Abs(Math.exp(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs expm1()
        {
            return new FlowMass.Abs(Math.expm1(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs floor()
        {
            return new FlowMass.Abs(Math.floor(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs log()
        {
            return new FlowMass.Abs(Math.log(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs log10()
        {
            return new FlowMass.Abs(Math.log10(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs log1p()
        {
            return new FlowMass.Abs(Math.log1p(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs rint()
        {
            return new FlowMass.Abs(Math.rint(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs round()
        {
            return new FlowMass.Abs(Math.round(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs signum()
        {
            return new FlowMass.Abs(Math.signum(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs sin()
        {
            return new FlowMass.Abs(Math.sin(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs sinh()
        {
            return new FlowMass.Abs(Math.sinh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs sqrt()
        {
            return new FlowMass.Abs(Math.sqrt(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs tan()
        {
            return new FlowMass.Abs(Math.tan(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs tanh()
        {
            return new FlowMass.Abs(Math.tanh(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs inv()
        {
            return new FlowMass.Abs(1.0 / getInUnit(), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs toDegrees()
        {
            return new FlowMass.Abs(Math.toDegrees(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs toRadians()
        {
            return new FlowMass.Abs(Math.toRadians(getInUnit()), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs pow(final double x)
        {
            return new FlowMass.Abs(Math.pow(getInUnit(), x), getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs multiplyBy(final double factor)
        {
            return new FlowMass.Abs(getInUnit() * factor, getUnit());
        }

        /** {@inheritDoc} */
        @Override
        public final FlowMass.Abs divideBy(final double divisor)
        {
            return new FlowMass.Abs(getInUnit() / divisor, getUnit());
        }

        /**
         * Absolute scalar plus Relative scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final FlowMass.Abs plus(final FlowMass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowMass.Abs(getInUnit() + v.getInUnit(), getUnit())
                : new FlowMass.Abs(this.si + v.si, FlowMassUnit.SI);
        }

        /**
         * Absolute scalar minus Absolute scalar = Relative scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FlowMass.Rel minus(final FlowMass.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowMass.Rel(getInUnit() - v.getInUnit(), getUnit())
                : new FlowMass.Rel(this.si - v.si, FlowMassUnit.SI);
        }

        /**
         * Absolute scalar minus Relative scalar = Absolute scalar.
         * @param v the value to subtract
         * @return difference of this value and v as a new object
         */
        public final FlowMass.Abs minus(final FlowMass.Rel v)
        {
            return getUnit().equals(v.getUnit()) ? new FlowMass.Abs(getInUnit() - v.getInUnit(), getUnit())
                : new FlowMass.Abs(this.si - v.si, FlowMassUnit.SI);
        }

        /**
         * Translate the absolute scalar into a relative scalar (e.g., before or after a multiplication or division).
         * @return a relative version of this absolute flowmass scalar.
         */
        public final FlowMass.Rel toRel()
        {
            return new FlowMass.Rel(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
         * @param v FlowMass scalar
         * @return Dimensionless scalar as a division of FlowMass and FlowMass
         */
        public final Dimensionless.Abs divideBy(final FlowMass.Abs v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and FlowMass, which results in a Dimensionless scalar.
         * @param v FlowMass scalar
         * @return Dimensionless scalar as a division of FlowMass and FlowMass
         */
        public final Dimensionless.Abs divideBy(final FlowMass.Rel v)
        {
            return new Dimensionless.Abs(this.si / v.si, DimensionlessUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Time, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a multiplication of FlowMass and Time
         */
        public final Mass.Abs multiplyBy(final Time.Abs v)
        {
            return new Mass.Abs(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Time, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a multiplication of FlowMass and Time
         */
        public final Mass.Abs multiplyBy(final Time.Rel v)
        {
            return new Mass.Abs(this.si * v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a division of FlowMass and Frequency
         */
        public final Mass.Abs divideBy(final Frequency.Abs v)
        {
            return new Mass.Abs(this.si / v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Frequency, which results in a Mass scalar.
         * @param v FlowMass scalar
         * @return Mass scalar as a division of FlowMass and Frequency
         */
        public final Mass.Abs divideBy(final Frequency.Rel v)
        {
            return new Mass.Abs(this.si / v.si, MassUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
         * @param v FlowMass scalar
         * @return Frequency scalar as a division of FlowMass and Mass
         */
        public final Frequency.Abs divideBy(final Mass.Abs v)
        {
            return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the division of FlowMass and Mass, which results in a Frequency scalar.
         * @param v FlowMass scalar
         * @return Frequency scalar as a division of FlowMass and Mass
         */
        public final Frequency.Abs divideBy(final Mass.Rel v)
        {
            return new Frequency.Abs(this.si / v.si, FrequencyUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
         * @param v FlowMass scalar
         * @return Force scalar as a multiplication of FlowMass and Speed
         */
        public final Force.Abs multiplyBy(final Speed.Abs v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

        /**
         * Calculate the multiplication of FlowMass and Speed, which results in a Force scalar.
         * @param v FlowMass scalar
         * @return Force scalar as a multiplication of FlowMass and Speed
         */
        public final Force.Abs multiplyBy(final Speed.Rel v)
        {
            return new Force.Abs(this.si * v.si, ForceUnit.SI);
        }

    }
}
