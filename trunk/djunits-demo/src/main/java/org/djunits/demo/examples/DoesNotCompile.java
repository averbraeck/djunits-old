package org.djunits.demo.examples;

import org.djunits.unit.LengthUnit;
import org.djunits.unit.MassUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.value.vdouble.scalar.Acceleration;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.scalar.Energy;
import org.djunits.value.vdouble.scalar.Length;
import org.djunits.value.vdouble.scalar.Mass;
import org.djunits.value.vdouble.scalar.Speed;

/** ... */
public final class DoesNotCompile
{
    /** Do not instantiate... */
    private DoesNotCompile()
    {
        // Do not instantiate
    }

    /**
     * ...
     * @param args
     */
    public static void main(final String[] args)
    {
        Speed speed = new Speed(12, SpeedUnit.KM_PER_HOUR);
        Length length = new Length(4, LengthUnit.MILE);
        Duration howLongOK = length.divide(speed); // Good
        //Duration howLongWrong = speed.divide(length); // Does not compile; result would be a frequency
        //Speed other = speed.minus(length); // Does not compile; you cannot subtract a length from a speed
        //Acceleration acceleration = speed.times(speed).asAcceleration(); // Throws a UnitRuntime exception
        Energy kineticEnergy = speed.times(speed).times(new Mass(3, MassUnit.KILOGRAM).times(0.5)).asEnergy(); // OK
        System.out.println(kineticEnergy);
    }
    
}
