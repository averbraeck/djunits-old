package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerMassUnit defines a unit for the cost or benefit per mass, e.g. the cost of a kilogram of material.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerMassUnit extends LinearUnit<MoneyPerMassUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per mass unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of mass for the money per mass unit, e.g., kg. */
    private final MassUnit massUnit;

    /** Euro per kg. */
    public static final MoneyPerMassUnit EUR_PER_KILOGRAM;

    /** Euro per metric ton. */
    public static final MoneyPerMassUnit EUR_PER_METRIC_TON;

    /** US$ per pound. */
    public static final MoneyPerMassUnit USD_PER_POUND;

    /** US$ per long ton. */
    public static final MoneyPerMassUnit USD_PER_LONG_TON;

    /** US$ per short ton. */
    public static final MoneyPerMassUnit USD_PER_SHORT_TON;

    /** The standard unit to use. */
    private static MoneyPerMassUnit standardMoneyPerMassUnit;

    static
    {
        EUR_PER_KILOGRAM =
            new MoneyPerMassUnit(MoneyUnit.EUR, MassUnit.KILOGRAM, "EUR per kilogram", "\u20AC/kg", false);
        EUR_PER_METRIC_TON =
            new MoneyPerMassUnit(MoneyUnit.EUR, MassUnit.TON_METRIC, "EUR per metric ton", "\u20AC/ton(metric)", false);
        USD_PER_POUND = new MoneyPerMassUnit(MoneyUnit.USD, MassUnit.POUND, "USD per pound", "US$/lb", false);
        USD_PER_LONG_TON =
            new MoneyPerMassUnit(MoneyUnit.USD, MassUnit.TON_LONG, "USD per long ton", "US$/ton(long)", false);
        USD_PER_SHORT_TON =
            new MoneyPerMassUnit(MoneyUnit.USD, MassUnit.TON_SHORT, "USD per short ton", "US$/ton(short)", false);
        standardMoneyPerMassUnit = EUR_PER_KILOGRAM;
    }

    /**
     * Build a money per mass unit from a money unit and an mass unit.
     * @param moneyUnit the unit of money for the money per mass unit, e.g., EUR
     * @param massUnit the unit of mass for the money per mass unit, e.g., kg
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerMassUnit(final MoneyUnit moneyUnit, final MassUnit massUnit, final String nameOrNameKey,
        final String abbreviationOrAbbreviationKey, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, standardMoneyPerMassUnit, moneyUnit
            .getConversionFactorToStandardUnit() / massUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.moneyUnit = moneyUnit;
        this.massUnit = massUnit;
    }

    /**
     * Build a user-defined money per mass unit from a money unit and an mass unit.
     * @param moneyUnit the unit of money for the money per mass unit, e.g., EUR
     * @param massUnit the unit of mass for the money per mass unit, e.g., kg
     * @param name the key to the locale file for the long name of the unit
     * @param abbreviation the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerMassUnit(final MoneyUnit moneyUnit, final MassUnit massUnit, final String name,
        final String abbreviation)
    {
        this(moneyUnit, massUnit, name, abbreviation, false);
    }

    /**
     * Build a MoneyPerMassUnit unit based on another MoneyPerMassUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerMassUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
        final MoneyPerMassUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, referenceUnit,
            conversionFactorToReferenceUnit, standardUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.massUnit = referenceUnit.getMassUnit();
    }

    /**
     * Build a user-defined MoneyPerMassUnit with a conversion factor to another MoneyPerMassUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public MoneyPerMassUnit(final String name, final String abbreviation, final MoneyPerMassUnit referenceUnit,
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
     * @return massUnit
     */
    public final MassUnit getMassUnit()
    {
        return this.massUnit;
    }

    /**
     * Set the standard MoneyPerMassUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerMassUnit =
                new MoneyPerMassUnit(standardMoneyUnit, MassUnit.KILOGRAM, standardMoneyUnit.getName()
                    + " per kilogram", standardMoneyUnit.getAbbreviation() + "/kg");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerMassUnit getStandardUnit()
    {
        return standardMoneyPerMassUnit;
    }

    /**
     * @return standard MoneyPerMassUnit
     */
    public static MoneyPerMassUnit getStandardMoneyPerMassUnit()
    {
        return standardMoneyPerMassUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/kg";
    }

}
