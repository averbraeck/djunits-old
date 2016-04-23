package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;
import org.joda.money.CurrencyUnit;

/**
 * MoneyUnit defines a monetary unit, and wraps the joda money currency unit. At this time, conversion rates between monetary
 * units are not used. A standard monetary unit, defined as a static variable, can be set to be used in the code.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 03, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyUnit extends LinearUnit<MoneyUnit>
{
    // TODO allow for static conversion factors between MoneyUnits.
    // TODO allow for dynamic conversion factors between MoneyUnits.

    /** */
    private static final long serialVersionUID = 20150903L;

    /** The joda-money CurrencyUnit on which this djunits unit is based. */
    private final CurrencyUnit currencyUnit;

    /** The currency 'AUD' - Australian Dollar. */
    public static final MoneyUnit AUD;

    /** The currency 'CAD' - Canadian Dollar. */
    public static final MoneyUnit CAD;

    /** The currency 'CHF' - Swiss Franc. */
    public static final MoneyUnit CHF;

    /** The currency 'EUR' - Euro. */
    public static final MoneyUnit EUR;

    /** The currency 'GBP' - British pound. */
    public static final MoneyUnit GBP;

    /** The currency 'JPY' - Japanese Yen. */
    public static final MoneyUnit JPY;

    /** The currency 'USD' - United States Dollar. */
    public static final MoneyUnit USD;

    /** The standard unit to use. */
    private static MoneyUnit standardMoneyUnit;

    static
    {
        AUD = new MoneyUnit(CurrencyUnit.AUD, "MoneyUnit.AUD", "MoneyUnit.AUD", true);
        CAD = new MoneyUnit(CurrencyUnit.CAD, "MoneyUnit.CAD", "MoneyUnit.CAD", true);
        CHF = new MoneyUnit(CurrencyUnit.CHF, "MoneyUnit.CHF", "MoneyUnit.CHF", true);
        EUR = new MoneyUnit(CurrencyUnit.EUR, "MoneyUnit.EUR", "MoneyUnit.EUR", true);
        GBP = new MoneyUnit(CurrencyUnit.GBP, "MoneyUnit.GBP", "MoneyUnit.GBP", true);
        JPY = new MoneyUnit(CurrencyUnit.JPY, "MoneyUnit.JPY", "MoneyUnit.JPY", true);
        USD = new MoneyUnit(CurrencyUnit.USD, "MoneyUnit.USD", "MoneyUnit.USD", true);
        standardMoneyUnit = USD;
    }

    /**
     * Define money unit.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyUnit(final CurrencyUnit currencyUnit, final String nameOrNameKey, final String abbreviationKey,
            final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationKey, UnitSystem.OTHER, standardUnit);
        this.currencyUnit = currencyUnit;
    }

    /**
     * Build a user-defined money unit.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     */
    public MoneyUnit(final CurrencyUnit currencyUnit, final String name, final String abbreviation)
    {
        this(currencyUnit, name, abbreviation, false);
    }

    /**
     * Build a money unit based on another money unit with a conversion factor.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationKey the key to the locale file for the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyUnit(final CurrencyUnit currencyUnit, final String nameOrNameKey, final String abbreviationKey,
            final MoneyUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationKey, UnitSystem.OTHER, referenceUnit, conversionFactorToReferenceUnit, standardUnit);
        this.currencyUnit = currencyUnit;
    }

    /**
     * Build a user-defined money unit based on another money unit with a conversion factor.
     * @param currencyUnit the joda-money CurrencyUnit on which this djunits unit is based
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public MoneyUnit(final CurrencyUnit currencyUnit, final String name, final String abbreviation,
            final MoneyUnit referenceUnit, final double conversionFactorToReferenceUnit)
    {
        this(currencyUnit, name, abbreviation, referenceUnit, conversionFactorToReferenceUnit, false);
    }

    /**
     * @return the joda-money CurrencyUnit on which this djunits unit is based.
     */
    public final CurrencyUnit getCurrencyUnit()
    {
        return this.currencyUnit;
    }

    /**
     * Set the standard money unit to be used.
     * @param moneyUnit the new standard money unit.
     */
    public static final void setStandardUnit(final MoneyUnit moneyUnit)
    {
        standardMoneyUnit = moneyUnit;
        MoneyPerAreaUnit.setStandardUnit(moneyUnit);
        MoneyPerEnergyUnit.setStandardUnit(moneyUnit);
        MoneyPerLengthUnit.setStandardUnit(moneyUnit);
        MoneyPerMassUnit.setStandardUnit(moneyUnit);
        MoneyPerTimeUnit.setStandardUnit(moneyUnit);
        MoneyPerVolumeUnit.setStandardUnit(moneyUnit);
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyUnit getStandardUnit()
    {
        return standardMoneyUnit;
    }

    /**
     * @return the current standard money unit
     */
    public static final MoneyUnit getStandardMoneyUnit()
    {
        return standardMoneyUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1";
    }

}
