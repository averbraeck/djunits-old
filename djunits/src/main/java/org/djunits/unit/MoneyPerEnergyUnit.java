package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerEnergyUnit defines a unit for the cost or benefit per unit of energy, e.g. the cost of electricity per kWh.
 * <p>
 * Copyright (c) 2015 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Sep 5, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class MoneyPerEnergyUnit extends LinearUnit<MoneyPerEnergyUnit>
{
    /** */
    private static final long serialVersionUID = 20150905L;

    /** The unit of money for the money per energy unit, e.g., EUR. */
    private final MoneyUnit moneyUnit;

    /** The unit of energy for the money per energy unit, e.g., kWh. */
    private final EnergyUnit energyUnit;

    /** Euro per kWh. */
    public static final MoneyPerEnergyUnit EUR_PER_KILOWATTHOUR;

    /** Euro per MWh. */
    public static final MoneyPerEnergyUnit EUR_PER_MEGAWATTHOUR;

    /** Euro per MJ. */
    public static final MoneyPerEnergyUnit EUR_PER_MEGAJOULE;

    /** US$ per kWh. */
    public static final MoneyPerEnergyUnit USD_PER_KILOWATTHOUR;

    /** US$ per MWh. */
    public static final MoneyPerEnergyUnit USD_PER_MEGAWATTHOUR;

    /** US$ per MJ. */
    public static final MoneyPerEnergyUnit USD_PER_MEGAJOULE;

    /** The standard unit to use. */
    private static MoneyPerEnergyUnit standardMoneyPerEnergyUnit;

    static
    {
        EUR_PER_KILOWATTHOUR =
                new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOWATT_HOUR, "EUR per kilowatthour", "\u20AC/kWh", false);
        EUR_PER_MEGAWATTHOUR =
                new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.MEGAWATT_HOUR, "EUR per megawatthour", "\u20AC/MWh", false);
        EUR_PER_MEGAJOULE =
                new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.MEGAJOULE, "EUR per megajoule", "\u20AC/MJ", false);
        USD_PER_KILOWATTHOUR =
                new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.KILOWATT_HOUR, "USD per kilowatthour", "US$/kWh", false);
        USD_PER_MEGAWATTHOUR =
                new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.MEGAWATT_HOUR, "USD per megawatthour", "US$/MWh", false);
        USD_PER_MEGAJOULE = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.MEGAJOULE, "USD per megajoule", "US$/MJ", false);
        standardMoneyPerEnergyUnit = EUR_PER_KILOWATTHOUR;
    }

    /**
     * Build a money per energy unit from a money unit and an energy unit.
     * @param moneyUnit the unit of money for the money per energy unit, e.g., EUR
     * @param energyUnit the unit of energy for the money per energy unit, e.g., kWh
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerEnergyUnit(final MoneyUnit moneyUnit, final EnergyUnit energyUnit, final String nameOrNameKey,
            final String abbreviationOrAbbreviationKey, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, standardMoneyPerEnergyUnit, moneyUnit
                .getConversionFactorToStandardUnit() / energyUnit.getConversionFactorToStandardUnit(), standardUnit);
        this.moneyUnit = moneyUnit;
        this.energyUnit = energyUnit;
    }

    /**
     * Build a user-defined money per energy unit from a money unit and an energy unit.
     * @param moneyUnit the unit of money for the money per energy unit, e.g., EUR
     * @param energyUnit the unit of energy for the money per energy unit, e.g., kWh
     * @param name the key to the locale file for the long name of the unit
     * @param abbreviation the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerEnergyUnit(final MoneyUnit moneyUnit, final EnergyUnit energyUnit, final String name,
            final String abbreviation)
    {
        this(moneyUnit, energyUnit, name, abbreviation, false);
    }

    /**
     * Build a MoneyPerEnergyUnit with a conversion factor to another MoneyPerEnergyUnit.
     * @param nameOrNameKey if standardUnit: the key to the locale file for the long name of the unit, otherwise the name itself
     * @param abbreviationOrAbbreviationKey if standardUnit: the key to the locale file for the abbreviation of the unit,
     *            otherwise the abbreviation itself
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     * @param standardUnit indicates whether it is a standard unit with a definition in the locale, or a user-defined unit
     */
    private MoneyPerEnergyUnit(final String nameOrNameKey, final String abbreviationOrAbbreviationKey,
            final MoneyPerEnergyUnit referenceUnit, final double conversionFactorToReferenceUnit, final boolean standardUnit)
    {
        super(nameOrNameKey, abbreviationOrAbbreviationKey, UnitSystem.OTHER, referenceUnit, conversionFactorToReferenceUnit,
                standardUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.energyUnit = referenceUnit.getEnergyUnit();
    }

    /**
     * Build a user-defined MoneyPerEnergyUnitit with a conversion factor to another MoneyPerEnergyUnit.
     * @param name the long name of the unit
     * @param abbreviation the abbreviation of the unit
     * @param referenceUnit the unit to convert to
     * @param conversionFactorToReferenceUnit multiply a value in this unit by the factor to convert to the given reference unit
     */
    public MoneyPerEnergyUnit(final String name, final String abbreviation, final MoneyPerEnergyUnit referenceUnit,
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
     * @return energyUnit
     */
    public final EnergyUnit getEnergyUnit()
    {
        return this.energyUnit;
    }

    /**
     * Set the standard MoneyPerEnergyUnit in case the standard MoneyUnit changes, as the standard money unit is flexible.
     * @param standardMoneyUnit the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerEnergyUnit =
                    new MoneyPerEnergyUnit(standardMoneyUnit, EnergyUnit.KILOWATT_HOUR, standardMoneyUnit.getName()
                            + " per kilowatthour", standardMoneyUnit.getAbbreviation() + "/kWh");
        }
        catch (Exception e)
        {
            // ignore a RunTimeException that indicates that the Unit might already exist
            e = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public final MoneyPerEnergyUnit getStandardUnit()
    {
        return standardMoneyPerEnergyUnit;
    }

    /**
     * @return standard MoneyPerEnergyUnit
     */
    public static MoneyPerEnergyUnit getStandardMoneyPerEnergyUnit()
    {
        return standardMoneyPerEnergyUnit;
    }

    /** {@inheritDoc} */
    @Override
    public final String getSICoefficientsString()
    {
        return "s2/kgm2";
    }

}
