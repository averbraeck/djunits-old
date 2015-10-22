package org.djunits.unit;

import org.djunits.unit.scale.LinearScale;
import org.djunits.unit.scale.Scale;
import org.djunits.unit.scale.StandardScale;
import org.djunits.unit.unitsystem.UnitSystem;

/**
 * A linear unit with easy-access constructor with a linear factor, and access to the linear factor. <br>
 * A linear unit is a unit that is linearly related to the SI standard unit. E.g. Mile is linearly related to meter (the SI unit
 * for length). Unlike temperature in degrees Celsius which is <strong>not</strong> linearly related to the Kelvin (the SI unit
 * for temperature).
 * <p>
 * Copyright (c) 2013-2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * </p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Oct 11, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @param <U> the linear Unit.
 */
public abstract class LinearUnit<U extends LinearUnit<U>> extends Unit<U>
{
    /** */
    private static final long serialVersionUID = 20151011L;

    /**
     * Build a standard linear unit and create the fields for a unit. If the parameter standardUnit is true, it is a standard
     * unit where name is the nameKey, and abbreviation is the abbreviationKey; if false, this unit is a user-defined unit where
     * the localization files do not have an entry. If standardUnit is true, a UnitException is silently ignored; if
     * standardUnit is false a UnitException is thrown as a RunTimeException.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    public LinearUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, standardUnit);
    }

    /**
     * Build a unit with a linear conversion factor to another unit. If the parameter standardUnit is true, it is a standard
     * unit where name is the nameKey, and abbreviation is the abbreviationKey; if false, this unit is a user-defined unit where
     * the localization files do not have an entry. If standardUnit is true, a UnitException is silently ignored; if
     * standardUnit is false a UnitException is thrown as a RunTimeException.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    protected LinearUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final U referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, standardUnit);

        // as it can happen that this method is called for the standard unit (when it is still null) we have to catch
        // the null pointer for the reference unit here.
        if (referenceUnit == null)
        {
            this.scale = new StandardScale();
        }
        else
        {
            this.scale =
                    new LinearScale(referenceUnit.getScale().getConversionFactorToStandardUnit()
                            * conversionFactorToReferenceUnit);
        }
    }

    /**
     * Build a unit with a specific conversion scale to/from the standard unit. If the parameter standardUnit is true, it is a
     * standard unit where name is the nameKey, and abbreviation is the abbreviationKey; if false, this unit is a user-defined
     * unit where the localization files do not have an entry. If standardUnit is true, a UnitException is silently ignored; if
     * standardUnit is false a UnitException is thrown as a RunTimeException.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param unitSystem the unit system, e.g. SI or Imperial
     * @param scale the conversion scale to use for this unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    protected LinearUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey, final UnitSystem unitSystem,
            final Scale scale, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, unitSystem, scale, standardUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final LinearScale getScale()
    {
        return (LinearScale) super.getScale();
    }

    /**
     * @return the conversion factor to the standard unit (e.g., the SI unit)
     */
    public final double getConversionFactorToStandardUnit()
    {
        return getScale().getConversionFactorToStandardUnit();
    }
}
