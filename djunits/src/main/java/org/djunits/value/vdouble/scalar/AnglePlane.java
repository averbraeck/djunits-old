package org.djunits.value.vdouble.scalar;

import org.djunits.unit.AnglePlaneUnit;
import org.djunits.unit.DimensionlessUnit;

/**
 * Easy access methods for the AnglePlane DoubleScalar. Instead of <br>
 * <i>DoubleScalar.Rel&lt;SomeUnit&gt; value = new DoubleScalar.Rel&lt;SomeUnit&gt;(0.2, SomeUnit.UNIT);</i><br>
 * we can now write <br>
 * <i>Some.Rel margin = new Some.Rel(0.2, UNIT);</i>, e.g., <i>Mass margin = new Mass(0.2, KILOGRAM);</i><br>
 * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the unit
 * used are compatible.
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Aug 28, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public interface AnglePlane
{
    /**
     * Easy access methods for the Relative AnglePlane DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;AnglePlaneUnit&gt; value = new DoubleScalar.Rel&lt;AnglePlaneUnit&gt;(100.0,
     * AnglePlaneUnit.SI);</i><br>
     * we can now write <br>
     * <i>AnglePlane.Rel value = new AnglePlane.Rel(100.0, AnglePlaneUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Rel extends TypedDoubleScalarRel<AnglePlaneUnit, AnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AnglePlane.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AnglePlane.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final AnglePlane.Rel value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlane.Rel instantiateTypeRel(final double value, final AnglePlaneUnit unit)
        {
            return new AnglePlane.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
         * @param value the double value
         * @param unit the unit
         * @return A a new absolute instance of the DoubleScalar of the right type
         */
        protected final AnglePlane.Abs instantiateTypeAbs(final double value, final AnglePlaneUnit unit)
        {
            return new AnglePlane.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AnglePlane.Rel
            interpolate(final AnglePlane.Rel zero, final AnglePlane.Rel one, final double ratio)
        {
            return new AnglePlane.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final AnglePlane.Abs plus(final AnglePlane.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative angleplane scalar.
         */
        public final AnglePlane.Abs toAbs()
        {
            return new AnglePlane.Abs(getInUnit(), getUnit());
        }

        /**
         * Calculate the division of AnglePlane and AnglePlane, which results in a Dimensionless scalar.
         * @param v AnglePlane scalar
         * @return Dimensionless scalar as a division of AnglePlane and AnglePlane
         */
        public final Dimensionless.Rel divideBy(final AnglePlane.Rel v)
        {
            return new Dimensionless.Rel(this.si / v.si, DimensionlessUnit.SI);
        }

    }

    /**
     * Easy access methods for the Absolute AnglePlane DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;AnglePlaneUnit&gt; value = new DoubleScalar.Abs&lt;AnglePlaneUnit&gt;(100.0,
     * AnglePlaneUnit.SI);</i><br>
     * we can now write <br>
     * <i>AnglePlane.Abs value = new AnglePlane.Abs(100.0, AnglePlaneUnit.SI);</i><br>
     * The compiler will automatically recognize which units belong to which quantity, and whether the quantity type and the
     * unit used are compatible.
     * <p>
     * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. <br>
     * All rights reserved. <br>
     * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
     * <p>
     * $LastChangedDate$, @version $Revision$, by $Author$,
     * initial version Sep 1, 2015 <br>
     * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
     * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
     */
    class Abs extends TypedDoubleScalarAbs<AnglePlaneUnit, AnglePlane.Abs, AnglePlane.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct AnglePlane.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final AnglePlaneUnit unit)
        {
            super(value, unit);
        }

        /**
         * Construct AnglePlane.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final AnglePlane.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlane.Abs instantiateTypeAbs(final double value, final AnglePlaneUnit unit)
        {
            return new AnglePlane.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final AnglePlane.Rel instantiateTypeRel(final double value, final AnglePlaneUnit unit)
        {
            return new AnglePlane.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static AnglePlane.Abs
            interpolate(final AnglePlane.Abs zero, final AnglePlane.Abs one, final double ratio)
        {
            return new AnglePlane.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

    }
}
