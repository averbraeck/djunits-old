package org.djunits.value.vdouble.scalar;

import org.djunits.unit.*;

/**
 * Easy access methods for the %Type% DoubleScalar. Instead of <br>
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
public interface %Type%
{
    /**
     * Easy access methods for the Relative %Type% DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Rel&lt;%Type%Unit&gt; value = new DoubleScalar.Rel&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>%Type%.Rel value = new %Type%.Rel(100.0, %Type%Unit.SI);</i><br>
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
    class Rel extends TypedDoubleScalarRel<%Type%Unit, %Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %Type%.Rel scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Rel(final double value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %Type%.Rel scalar.
         * @param value Scalar from which to construct this instance
         */
        public Rel(final %Type%.Rel value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%.Rel instantiateTypeRel(final double value, final %Type%Unit unit)
        {
            return new %Type%.Rel(value, unit);
        }

        /**
         * Construct a new Absolute Immutable DoubleScalar of the right type. Each extending class must implement this method.
         * @param value the double value
         * @param unit the unit
         * @return A a new absolute instance of the DoubleScalar of the right type
         */
        protected final %Type%.Abs instantiateTypeAbs(final double value, final %Type%Unit unit)
        {
            return new %Type%.Abs(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static %Type%.Rel interpolate(final %Type%.Rel zero, final %Type%.Rel one, final double ratio)
        {
            return new %Type%.Rel(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }
        
        /**
         * Relative scalar plus Absolute scalar = Absolute scalar.
         * @param v the value to add
         * @return sum of this value and v as a new object
         */
        public final %Type%.Abs plus(final %Type%.Abs v)
        {
            return getUnit().equals(v.getUnit()) ? instantiateTypeAbs(getInUnit() + v.getInUnit(), getUnit())
                : instantiateTypeAbs(this.si + v.si, getUnit().getStandardUnit());
        }

        /**
         * Translate the relative scalar into an absolute scalar (e.g., before or after a multiplication or division).
         * @return an absolute version of this relative %type% scalar.
         */
        public final %Type%.Abs toAbs()
        {
            return new %Type%.Abs(getInUnit(), getUnit());
        }

%FORMULAS%%Type%.Rel%
    }

    /**
     * Easy access methods for the Absolute %Type% DoubleScalar. Instead of <br>
     * <i>DoubleScalar.Abs&lt;%Type%Unit&gt; value = new DoubleScalar.Abs&lt;%Type%Unit&gt;(100.0, %Type%Unit.SI);</i><br>
     * we can now write <br>
     * <i>%Type%.Abs value = new %Type%.Abs(100.0, %Type%Unit.SI);</i><br>
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
    class Abs extends TypedDoubleScalarAbs<%Type%Unit, %Type%.Abs, %Type%.Rel>
    {
        /** */
        private static final long serialVersionUID = 20150901L;

        /**
         * Construct %Type%.Abs scalar.
         * @param value double value
         * @param unit unit for the double value
         */
        public Abs(final double value, final %Type%Unit unit)
        {
            super(value, unit);
        }

        /**
         * Construct %Type%.Abs scalar.
         * @param value Scalar from which to construct this instance
         */
        public Abs(final %Type%.Abs value)
        {
            super(value);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%.Abs instantiateTypeAbs(final double value, final %Type%Unit unit)
        {
            return new %Type%.Abs(value, unit);
        }

        /** {@inheritDoc} */
        @Override
        protected final %Type%.Rel instantiateTypeRel(final double value, final %Type%Unit unit)
        {
            return new %Type%.Rel(value, unit);
        }

        /**
         * Interpolate between two values.
         * @param zero the low value
         * @param one the high value
         * @param ratio the ratio between 0 and 1, inclusive
         * @return a Scalar at the ratio between
         */
        public static %Type%.Abs interpolate(final %Type%.Abs zero, final %Type%.Abs one, final double ratio)
        {
            return new %Type%.Abs(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getUnit()) * ratio, zero
                .getUnit());
        }

%FORMULAS%%Type%.Abs%
    }
}

