package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerTimeUnit defines a unit for the cost or benefit per time, e.g. wage per hour.
 * <p>
 * Copyright (c) 2015-2016 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerTimeUnit extends LinearUnit<MoneyPerTimeUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per time unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of time for the money per time unit, e.g., hour. */
    private final TimeUnit timeUnit;

    /** Euro per hour. */
    public static final MoneyPerTimeUnit EUR_PER_HOUR;

    /** Euro per day. */
    public static final MoneyPerTimeUnit EUR_PER_DAY;

    /** US$ per hour. */
    public static final MoneyPerTimeUnit USD_PER_HOUR;

    /** US$ per day. */
    public static final MoneyPerTimeUnit USD_PER_DAY;

    /** The standard unit to use. */
    private static MoneyPerTimeUnit standardMoneyPerTimeUnit;

    static
    {
        EUR_PER_HOUR = new MoneyPerTimeUnit(MoneyUnit.EUR, TimeUnit.HOUR, "EUR per hour", "\u20AC/h", false);
        EUR_PER_DAY = new MoneyPerTimeUnit(MoneyUnit.EUR, TimeUnit.DAY, "EUR per day", "\u20AC/day", false);
        USD_PER_HOUR = new MoneyPerTimeUnit(MoneyUnit.USD, TimeUnit.HOUR, "USD per hour", "US$/h", false);
        USD_PER_DAY = new MoneyPerTimeUnit(MoneyUnit.USD, TimeUnit.DAY, "USD per day", "US$/day", false);
        standardMoneyPerTimeUnit = EUR_PER_HOUR;
    }

    /**
     * Build a money per time unit from a money unit and an time unit.
     * @param moneyUnit the unit of money for the money per time unit, e.g., EUR
     * @param timeUnit the unit of time for the money per time unit, e.g., hour
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerTimeUnit(final MoneyUnit moneyUnit, final TimeUnit timeUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, standardMoneyPerTimeUnit, moneyUnit
                .getConversionFactorToStandardUnit() / timeUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.moneyUnit = moneyUnit;
        this.timeUnit = timeUnit;
    }

    /**
     * Build a user-defined money per time unit from a money unit and an time unit.
     * @param moneyUnit the unit of money for the money per time unit, e.g., EUR
     * @param timeUnit the unit of time for the money per time unit, e.g., hour
     * @param name the key to the locale file for the long name of the unit
     * @param abbreviation the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerTimeUnit(final MoneyUnit moneyUnit, final TimeUnit timeUnit, final String name, final String abbreviation)
    {
        this(moneyUnit, timeUnit, name, abbreviation, false);
    }

    /**
     * Build a MoneyPerTimeUnit unit based on another MoneyPerTimeUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerTimeUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final MoneyPerTimeUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, referenceUnit, conversionFactorToReferenceUnit,
                standardUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.timeUnit = referenceUnit.getTimeUnit();
    }

    /**
     * Build a user-defined MoneyPerTimeUnit with a conversion factor to another MoneyPerTimeUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public MoneyPerTimeUnit(final String name, final String abbreviation, final MoneyPerTimeUnit referenceUnit,
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
     * @return timeUnit
     */
    public final TimeUnit getTimeUnit()
    {
        return this.timeUnit;
    }

    /**
     * Set the standard MoneyPerTimeUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerTimeUnit =
                    new MoneyPerTimeUnit(standardMoneyUnit, TimeUnit.HOUR, standardMoneyUnit.getName() + " per hour",
                            standardMoneyUnit.getAbbreviation() + "/h");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerTimeUnit getStandardUnit()
    {
        return standardMoneyPerTimeUnit;
    }

    /**
     * @return standard MoneyPerTimeUnit
     */
    public static MoneyPerTimeUnit getStandardMoneyPerTimeUnit()
    {
        return standardMoneyPerTimeUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "1/s";
    }

}
