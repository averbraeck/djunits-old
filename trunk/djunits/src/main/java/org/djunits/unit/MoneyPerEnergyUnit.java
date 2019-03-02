package org.djunits.unit;

import org.djunits.unit.unitsystem.UnitSystem;

/**
 * MoneyPerEnergyUnit defines a unit for the cost or benefit per unit of energy, e.g. the cost of electricity per kWh.
 * <p>
 * Copyright (c) 2015-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
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
        EUR_PER_KILOWATTHOUR = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.KILOWATT_HOUR, "EUR/kWh", "\u20AC/kWh");
        EUR_PER_MEGAWATTHOUR = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.MEGAWATT_HOUR, "EUR/MWh", "\u20AC/MWh");
        EUR_PER_MEGAJOULE = new MoneyPerEnergyUnit(MoneyUnit.EUR, EnergyUnit.MEGAJOULE, "EUR/MJ", "\u20AC/MJ");
        USD_PER_KILOWATTHOUR = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.KILOWATT_HOUR, "US$/kWh", "US$/kWh");
        USD_PER_MEGAWATTHOUR = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.MEGAWATT_HOUR, "US$/MWh", "US$/MWh");
        USD_PER_MEGAJOULE = new MoneyPerEnergyUnit(MoneyUnit.USD, EnergyUnit.MEGAJOULE, "US$/MJ", "US$/MJ");
        standardMoneyPerEnergyUnit = EUR_PER_KILOWATTHOUR;
    }

    /**
     * Build a money per energy unit from a money unit and an energy unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per energy unit, e.g., EUR
     * @param energyUnit EnergyUnit; the unit of energy for the money per energy unit, e.g., kWh
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     */
    private MoneyPerEnergyUnit(final MoneyUnit moneyUnit, final EnergyUnit energyUnit, final String abbreviationKey)
    {
        super(abbreviationKey, UnitSystem.OTHER, standardMoneyPerEnergyUnit,
                moneyUnit.getScaleFactor() / energyUnit.getScaleFactor());
        this.moneyUnit = moneyUnit;
        this.energyUnit = energyUnit;
    }

    /**
     * Build a user-defined money per energy unit from a money unit and an energy unit.
     * @param moneyUnit MoneyUnit; the unit of money for the money per energy unit, e.g., EUR
     * @param energyUnit EnergyUnit; the unit of energy for the money per energy unit, e.g., kWh
     * @param name String; the key to the locale file for the long name of the unit
     * @param abbreviation String; the key to the locale file for the abbreviation of the unit
     */
    public MoneyPerEnergyUnit(final MoneyUnit moneyUnit, final EnergyUnit energyUnit, final String name,
            final String abbreviation)
    {
        super(name, abbreviation, UnitSystem.OTHER, standardMoneyPerEnergyUnit,
                moneyUnit.getScaleFactor() / energyUnit.getScaleFactor());
        this.moneyUnit = moneyUnit;
        this.energyUnit = energyUnit;
    }

    /**
     * Build a MoneyPerEnergyUnit with a conversion factor to another MoneyPerEnergyUnit.
     * @param abbreviationKey String; the key to the locale file for the abbreviation of the unit
     * @param referenceUnit MoneyPerEnergyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    private MoneyPerEnergyUnit(final String abbreviationKey, final MoneyPerEnergyUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(abbreviationKey, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.energyUnit = referenceUnit.getEnergyUnit();
    }

    /**
     * Build a user-defined MoneyPerEnergyUnitit with a conversion factor to another MoneyPerEnergyUnit.
     * @param name String; the long name of the unit
     * @param abbreviation String; the abbreviation of the unit
     * @param referenceUnit MoneyPerEnergyUnit; the unit to convert to
     * @param scaleFactorToReferenceUnit double; multiply a value in this unit by the factor to convert to the given reference
     *            unit
     */
    public MoneyPerEnergyUnit(final String name, final String abbreviation, final MoneyPerEnergyUnit referenceUnit,
            final double scaleFactorToReferenceUnit)
    {
        super(name, abbreviation, UnitSystem.OTHER, referenceUnit, scaleFactorToReferenceUnit);
        this.moneyUnit = referenceUnit.getMoneyUnit();
        this.energyUnit = referenceUnit.getEnergyUnit();
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
     * @param standardMoneyUnit MoneyUnit; the new standard money unit.
     */
    protected static void setStandardUnit(final MoneyUnit standardMoneyUnit)
    {
        try
        {
            standardMoneyPerEnergyUnit = new MoneyPerEnergyUnit(standardMoneyUnit, EnergyUnit.KILOWATT_HOUR,
                    standardMoneyUnit.getName() + " per kilowatthour", standardMoneyUnit.getAbbreviation() + "/kWh");
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

    /** {@inheritDoc} */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.energyUnit == null) ? 0 : this.energyUnit.hashCode());
        result = prime * result + ((this.moneyUnit == null) ? 0 : this.moneyUnit.hashCode());
        return result;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("checkstyle:needbraces")
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        MoneyPerEnergyUnit other = (MoneyPerEnergyUnit) obj;
        if (this.energyUnit == null)
        {
            if (other.energyUnit != null)
                return false;
        }
        else if (!this.energyUnit.equals(other.energyUnit))
            return false;
        if (this.moneyUnit == null)
        {
            if (other.moneyUnit != null)
                return false;
        }
        else if (!this.moneyUnit.equals(other.moneyUnit))
            return false;
        return true;
    }

}
