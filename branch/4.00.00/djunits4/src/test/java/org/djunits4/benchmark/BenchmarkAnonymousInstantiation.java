package org.djunits4.benchmark;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.djunits4.unit.AbsoluteTemperatureUnit;
import org.djunits4.unit.AccelerationUnit;
import org.djunits4.unit.AngleSolidUnit;
import org.djunits4.unit.AngleUnit;
import org.djunits4.unit.AreaUnit;
import org.djunits4.unit.DensityUnit;
import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.DirectionUnit;
import org.djunits4.unit.DurationUnit;
import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.unit.ElectricalCurrentUnit;
import org.djunits4.unit.ElectricalPotentialUnit;
import org.djunits4.unit.ElectricalResistanceUnit;
import org.djunits4.unit.EnergyUnit;
import org.djunits4.unit.FlowMassUnit;
import org.djunits4.unit.FlowVolumeUnit;
import org.djunits4.unit.ForceUnit;
import org.djunits4.unit.FrequencyUnit;
import org.djunits4.unit.LengthUnit;
import org.djunits4.unit.LinearDensityUnit;
import org.djunits4.unit.MassUnit;
import org.djunits4.unit.PositionUnit;
import org.djunits4.unit.PowerUnit;
import org.djunits4.unit.PressureUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.SpeedUnit;
import org.djunits4.unit.TemperatureUnit;
import org.djunits4.unit.TimeUnit;
import org.djunits4.unit.TorqueUnit;
import org.djunits4.unit.Unit;
import org.djunits4.unit.VolumeUnit;
import org.djunits4.unit.util.UnitException;
import org.djunits4.unit.util.UnitRuntimeException;
import org.djunits4.value.vdouble.scalar.AbsoluteTemperature;
import org.djunits4.value.vdouble.scalar.Acceleration;
import org.djunits4.value.vdouble.scalar.Angle;
import org.djunits4.value.vdouble.scalar.AngleSolid;
import org.djunits4.value.vdouble.scalar.Area;
import org.djunits4.value.vdouble.scalar.Density;
import org.djunits4.value.vdouble.scalar.Dimensionless;
import org.djunits4.value.vdouble.scalar.Direction;
import org.djunits4.value.vdouble.scalar.Duration;
import org.djunits4.value.vdouble.scalar.ElectricalCharge;
import org.djunits4.value.vdouble.scalar.ElectricalCurrent;
import org.djunits4.value.vdouble.scalar.ElectricalPotential;
import org.djunits4.value.vdouble.scalar.ElectricalResistance;
import org.djunits4.value.vdouble.scalar.Energy;
import org.djunits4.value.vdouble.scalar.FlowMass;
import org.djunits4.value.vdouble.scalar.FlowVolume;
import org.djunits4.value.vdouble.scalar.Force;
import org.djunits4.value.vdouble.scalar.Frequency;
import org.djunits4.value.vdouble.scalar.Length;
import org.djunits4.value.vdouble.scalar.LinearDensity;
import org.djunits4.value.vdouble.scalar.Mass;
import org.djunits4.value.vdouble.scalar.Position;
import org.djunits4.value.vdouble.scalar.Power;
import org.djunits4.value.vdouble.scalar.Pressure;
import org.djunits4.value.vdouble.scalar.SIScalar;
import org.djunits4.value.vdouble.scalar.Speed;
import org.djunits4.value.vdouble.scalar.Temperature;
import org.djunits4.value.vdouble.scalar.Time;
import org.djunits4.value.vdouble.scalar.Torque;
import org.djunits4.value.vdouble.scalar.Volume;
import org.djunits4.value.vdouble.scalar.base.AbstractDoubleScalar;

/**
 * BenschmarkAnonymousInstantiation.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class BenchmarkAnonymousInstantiation
{
    /** the cache to make the lookup of the constructor for a Scalar belonging to a unit faster. */
    private static Map<Unit<?>, Constructor<? extends AbstractDoubleScalar<?, ?>>> CACHE = new HashMap<>();

    /** the cache to make the lookup of the method handle for a Scalar belonging to a unit faster. */
    private static Map<Unit<?>, MethodHandle> MH_CACHE = new HashMap<>();

    /** */
    private BenchmarkAnonymousInstantiation()
    {
        // Benchmarking class.
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Rigid check on types for the compiler.
     * @param value double; the value
     * @param unit U; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>> S instantiateCached(final double value,
            final U unit)
    {
        return instantiateAnonymousCached(value, unit);
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param value double; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces"})
    public static <S extends AbstractDoubleScalar<?, S>> S instantiateAnonymousCached(final double value, final Unit<?> unit)
    {
        try
        {
            Constructor<? extends AbstractDoubleScalar<?, ?>> scalarConstructor = CACHE.get(unit);
            if (scalarConstructor == null)
            {
                if (!unit.getClass().getSimpleName().endsWith("Unit"))
                {
                    throw new ClassNotFoundException(
                            "Unit " + unit + " name does noet end with 'Unit'. Cannot find corresponding scalar");
                }
                Class<? extends AbstractDoubleScalar<?, ?>> scalarClass;
                if (unit instanceof SIUnit)
                {
                    scalarClass = SIScalar.class;
                }
                else
                {
                    scalarClass = (Class<AbstractDoubleScalar<?, ?>>) Class.forName(
                            "org.djunits4.value.vdouble.scalar." + unit.getClass().getSimpleName().replace("Unit", ""));
                }
                scalarConstructor = scalarClass.getDeclaredConstructor(double.class, unit.getClass());
                CACHE.put(unit, scalarConstructor);
            }
            return (S) scalarConstructor.newInstance(value, unit);
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
        {
            throw new UnitRuntimeException(
                    "Cannot instantiate AbstractScalar of unit " + unit.toString() + ". Reason: " + exception.getMessage());
        }
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Rigid check on types for the compiler.
     * @param value double; the value
     * @param unit U; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>> S instantiateCascade(final double value,
            final U unit)
    {
        return instantiateAnonymousCascade(value, unit);
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param value double; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces"})
    public static <S extends AbstractDoubleScalar<?, S>> S instantiateAnonymousCascade(final double value, final Unit<?> unit)
    {
        if (unit instanceof DimensionlessUnit)
            return (S) new Dimensionless(value, (DimensionlessUnit) unit);
        else if (unit instanceof AccelerationUnit)
            return (S) new Acceleration(value, (AccelerationUnit) unit);
        else if (unit instanceof AngleSolidUnit)
            return (S) new AngleSolid(value, (AngleSolidUnit) unit);
        else if (unit instanceof AngleUnit)
            return (S) new Angle(value, (AngleUnit) unit);
        else if (unit instanceof DirectionUnit)
            return (S) new Direction(value, (DirectionUnit) unit);
        else if (unit instanceof DensityUnit)
            return (S) new Density(value, (DensityUnit) unit);
        else if (unit instanceof ElectricalChargeUnit)
            return (S) new ElectricalCharge(value, (ElectricalChargeUnit) unit);
        else if (unit instanceof ElectricalCurrentUnit)
            return (S) new ElectricalCurrent(value, (ElectricalCurrentUnit) unit);
        else if (unit instanceof ElectricalPotentialUnit)
            return (S) new ElectricalPotential(value, (ElectricalPotentialUnit) unit);
        else if (unit instanceof ElectricalResistanceUnit)
            return (S) new ElectricalResistance(value, (ElectricalResistanceUnit) unit);
        else if (unit instanceof EnergyUnit)
            return (S) new Energy(value, (EnergyUnit) unit);
        else if (unit instanceof FlowMassUnit)
            return (S) new FlowMass(value, (FlowMassUnit) unit);
        else if (unit instanceof AreaUnit)
            return (S) new Area(value, (AreaUnit) unit);
        else if (unit instanceof FlowVolumeUnit)
            return (S) new FlowVolume(value, (FlowVolumeUnit) unit);
        else if (unit instanceof ForceUnit)
            return (S) new Force(value, (ForceUnit) unit);
        else if (unit instanceof FrequencyUnit)
            return (S) new Frequency(value, (FrequencyUnit) unit);
        else if (unit instanceof LengthUnit)
            return (S) new Length(value, (LengthUnit) unit);
        else if (unit instanceof PositionUnit)
            return (S) new Position(value, (PositionUnit) unit);
        else if (unit instanceof LinearDensityUnit)
            return (S) new LinearDensity(value, (LinearDensityUnit) unit);
        else if (unit instanceof MassUnit)
            return (S) new Mass(value, (MassUnit) unit);
        else if (unit instanceof PowerUnit)
            return (S) new Power(value, (PowerUnit) unit);
        else if (unit instanceof PressureUnit)
            return (S) new Pressure(value, (PressureUnit) unit);
        else if (unit instanceof SpeedUnit)
            return (S) new Speed(value, (SpeedUnit) unit);
        else if (unit instanceof TemperatureUnit)
            return (S) new Temperature(value, (TemperatureUnit) unit);
        else if (unit instanceof AbsoluteTemperatureUnit)
            return (S) new AbsoluteTemperature(value, (AbsoluteTemperatureUnit) unit);
        else if (unit instanceof DurationUnit)
            return (S) new Duration(value, (DurationUnit) unit);
        else if (unit instanceof TimeUnit)
            return (S) new Time(value, (TimeUnit) unit);
        else if (unit instanceof TorqueUnit)
            return (S) new Torque(value, (TorqueUnit) unit);
        else if (unit instanceof VolumeUnit)
            return (S) new Volume(value, (VolumeUnit) unit);
        else
            throw new RuntimeException(new UnitException("Cannot instantiate AbstractScalar of unit " + unit.toString()));
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Rigid check on types for the compiler.
     * @param value double; the value
     * @param unit U; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>> S instantiateNonCached(final double value,
            final U unit)
    {
        return instantiateAnonymousNonCached(value, unit);
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param value double; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces"})
    public static <S extends AbstractDoubleScalar<?, S>> S instantiateAnonymousNonCached(final double value, final Unit<?> unit)
    {
        try
        {
            Class<AbstractDoubleScalar<?, ?>> scalarClass = (Class<AbstractDoubleScalar<?, ?>>) Class
                    .forName("org.djunits4.value.vdouble.scalar." + unit.getClass().getSimpleName().replace("Unit", ""));
            Constructor<AbstractDoubleScalar<?, ?>> scalarConstructor =
                    scalarClass.getDeclaredConstructor(double.class, unit.getClass());
            CACHE.put(unit, scalarConstructor);
            return (S) scalarConstructor.newInstance(value, unit);
        }
        catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException exception)
        {
            throw new UnitRuntimeException("Cannot instantiate AbstractScalar of unit " + unit.toString());
        }
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Rigid check on types for the compiler.
     * @param value double; the value
     * @param unit U; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <U> the unit
     * @param <S> the return type
     */
    public static <U extends Unit<U>, S extends AbstractDoubleScalar<U, S>> S instantiateMethodHandle(final double value,
            final U unit)
    {
        return instantiateAnonymousMethodHandle(value, unit);
    }

    /**
     * Instantiate the DoubleScalar based on its unit. Loose check for types on the compiler. This allows the unit to be
     * specified as a Unit&lt;?&gt; type.<br>
     * <b>Note</b> that it is possible to make mistakes with anonymous units.
     * @param value double; the value
     * @param unit Unit&lt;?&gt;; the unit in which the value is expressed
     * @return an instantiated DoubleScalar with the value expressed in the unit
     * @param <S> the return type
     */
    @SuppressWarnings({"unchecked", "checkstyle:needbraces"})
    public static <S extends AbstractDoubleScalar<?, S>> S instantiateAnonymousMethodHandle(final double value,
            final Unit<?> unit)
    {
        try
        {
            MethodHandle methodHandle = MH_CACHE.get(unit);
            if (methodHandle == null)
            {
                Class<AbstractDoubleScalar<?, S>> scalarClass = (Class<AbstractDoubleScalar<?, S>>) Class
                        .forName("org.djunits4.value.vdouble.scalar." + unit.getClass().getSimpleName().replace("Unit", ""));
                final MethodHandles.Lookup lookup = MethodHandles.lookup();
                methodHandle =
                        lookup.findConstructor(scalarClass, MethodType.methodType(void.class, double.class, unit.getClass()));
                MH_CACHE.put(unit, methodHandle);
            }
            S scalar = (S) methodHandle.invoke(value, unit);
            return scalar;
        }
        catch (Throwable exception)
        {
            exception.printStackTrace();
            throw new UnitRuntimeException(
                    "Cannot instantiate AbstractScalar of unit " + unit.toString() + ", reason: " + exception.getMessage());
        }
    }

    /**
     * Benchmark for anonymous scalar instantiation.
     * @param args empty
     * @throws Throwable on error
     */
    public static void main(final String[] args) throws Throwable
    {
        int MAX = 10_000_000;
        long t = System.nanoTime();
        long siSum = 0;
        for (int i = 0; i < MAX; i++)
        {
            Area a = new Area(1.0, AreaUnit.CENTIARE);
            siSum += a.si;
        }
        double t1 = (System.nanoTime() - t) * 1E-9;
        System.out.println(siSum + " instantiate at " + t1 + "s\n");

        t = System.nanoTime();
        siSum = 0;
        for (int i = 0; i < MAX; i++)
        {
            Area a = BenchmarkAnonymousInstantiation.instantiateCascade(1.0, AreaUnit.CENTIARE);
            siSum += a.si;
        }
        double t2 = (System.nanoTime() - t) * 1E-9;
        System.out.println(siSum + " cascade at " + t2 + "s");
        System.out.println("Cascade generation slower by a factor: " + t2 / t1 + "\n");

        t = System.nanoTime();
        siSum = 0;
        for (int i = 0; i < MAX; i++)
        {
            Area a = BenchmarkAnonymousInstantiation.instantiateNonCached(1.0, AreaUnit.CENTIARE);
            siSum += a.si;
        }
        double t3 = (System.nanoTime() - t) * 1E-9;
        System.out.println(siSum + " no-cache reflection at " + t3 + "s");
        System.out.println("Not cached generation slower by a factor: " + t3 / t1 + "\n");

        t = System.nanoTime();
        siSum = 0;
        for (int i = 0; i < MAX; i++)
        {
            Area a = BenchmarkAnonymousInstantiation.instantiateCached(1.0, AreaUnit.CENTIARE);
            siSum += a.si;
        }
        double t4 = (System.nanoTime() - t) * 1E-9;
        System.out.println(siSum + " cached reflection at " + t4 + "s");
        System.out.println("Cached generation slower by a factor: " + t4 / t1 + "\n");

        t = System.nanoTime();
        siSum = 0;
        for (int i = 0; i < MAX; i++)
        {
            Area a = BenchmarkAnonymousInstantiation.instantiateMethodHandle(1.0, AreaUnit.CENTIARE);
            siSum += a.si;
        }
        double t5 = (System.nanoTime() - t) * 1E-9;
        System.out.println(siSum + " MethodHandle at " + t5 + "s");
        System.out.println("MethodHandle generation slower by a factor: " + t5 / t1 + "\n");
    }
}
