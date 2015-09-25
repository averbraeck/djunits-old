package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerVolumeUnit defines a unit for the cost or benefit per volume, e.g. the cost of a gallon of fuel.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate: 2015-07-26 01:01:13 +0200 (Sun, 26 Jul 2015) $, @version $Revision: 1155 $, by $Author: averbraeck $,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerVolumeUnit extends Unit<MoneyPerVolumeUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per volume unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of volume for the money per volume unit, e.g., liter. */
    private final VolumeUnit volumeUnit;

    /** Euro per cubic meter. */
    public static final MoneyPerVolumeUnit EUR_PER_CUBIC_METER;

    /** Euro per liter. */
    public static final MoneyPerVolumeUnit EUR_PER_LITER;

    /** US$ per gallon (US). */
    public static final MoneyPerVolumeUnit USD_PER_GALLON_US_FLUID;

    /** US$ per ounce (US). */
    public static final MoneyPerVolumeUnit USD_PER_OUNCE_US_FLUID;

    /** The standard unit to use. */
    private static MoneyPerVolumeUnit standardMoneyPerVolumeUnit;

    static
    {
        EUR_PER_CUBIC_METER =
            new MoneyPerVolumeUnit(MoneyUnit.EUR, VolumeUnit.CUBIC_METER, "EUR per cubic meter", "\u20AC/m^3", false);
        EUR_PER_LITER = new MoneyPerVolumeUnit(MoneyUnit.EUR, VolumeUnit.LITER, "EUR per liter", "\u20AC/l", false);
        USD_PER_GALLON_US_FLUID =
            new MoneyPerVolumeUnit(MoneyUnit.USD, VolumeUnit.GALLON_US_FLUID, "USD per gallon (US)", "US$/gallon",
                false);
        USD_PER_OUNCE_US_FLUID =
            new MoneyPerVolumeUnit(MoneyUnit.USD, VolumeUnit.OUNCE_US_FLUID, "USD per ounce (US)", "US$/ounce", false);
        standardMoneyPerVolumeUnit = EUR_PER_CUBIC_METER;
    }

    /**
     * Build a money per volume unit from a money unit and an volume unit.
     * @param moneyUnit the unit of money for the money per volume unit, e.g., EUR
     * @param volumeUnit the unit of volume for the money per volume unit, e.g., m^3
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerVolumeUnit(final MoneyUnit moneyUnit, final VolumeUnit volumeUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, standardMoneyPerVolumeUnit, moneyUnit
            .getConversionFactorToStandardUnit()
            / volumeUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.moneyUnit = moneyUnit;
        this.volumeUnit = volumeUnit;
    }

    /**
     * Build a user-defined money per volume unit from a money unit and an volume unit.
     * @param moneyUnit the unit of money for the money per volume unit, e.g., EUR
     * @param volumeUnit the unit of volume for the money per volume unit, e.g., m^3
     * @param name the key to the locale file for the long name of the unit
     * @param abbreviation the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerVolumeUnit(final MoneyUnit moneyUnit, final VolumeUnit volumeUnit, final String name,
        final String abbreviation)
    {
        this(moneyUnit, volumeUnit, name, abbreviation, false);
    }

    /**
     * Build a MoneyPerVolumeUnit unit based on another MoneyPerVolumeUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerVolumeUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final MoneyPerVolumeUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, referenceUnit,
            conversionFactorToReferenceUnit, standardUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.volumeUnit = referenceUnit.getVolumeUnit();
    }

    /**
     * Build a user-defined MoneyPerVolumeUnit with a conversion factor to another MoneyPerVolumeUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public MoneyPerVolumeUnit(final String name, final String abbreviation, final MoneyPerVolumeUnit referenceUnit,
        final double conversionFactorToReferenceUnit)
    {
        this(name, abbreviation, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /**
     * @return moneyUnit
     */
    public final MoneyUnit getMoneyUnit()
    {
        return this.moneyUnit;
    }

    /**
     * @return volumeUnit
     */
    public final VolumeUnit getVolumeUnit()
    {
        return this.volumeUnit;
    }

    /**
     * Set the standard MoneyPerVolumeUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerVolumeUnit =
                new MoneyPerVolumeUnit(standardMoneyUnit, VolumeUnit.CUBIC_METER, standardMoneyUnit.getName()
                    + " per cubic meter", standardMoneyUnit.getAbbreviation() + "/m^3");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerVolumeUnit getStandardUnit()
    {
        return standardMoneyPerVolumeUnit;
    }

    /**
     * @return standard MoneyPerVolumeUnit
     */
    public static MoneyPerVolumeUnit getStandardMoneyPerVolumeUnit()
    {
        return standardMoneyPerVolumeUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/m3";
    }

}
