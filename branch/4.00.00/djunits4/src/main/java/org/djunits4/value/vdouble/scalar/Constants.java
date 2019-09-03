package org.djunits4.value.vdouble.scalar;

import org.djunits4.unit.DimensionlessUnit;
import org.djunits4.unit.ElectricalChargeUnit;
import org.djunits4.unit.SIUnit;
import org.djunits4.unit.util.UnitException;

/**
 * Various physical constants.
 * <p>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers">Peter Knoppers</a>
 */
public class Constants
{
    /** Number of constituent particles in a Mole; a.k.a. Avogadro's number. */
    public static final DoubleScalar.Rel<SIUnit> AVOGADRO = make(6.02214076e23, "1/mol");

    /**
     * Boltzmann constant (according to the 2019 redefinition of SI base units) in Joule per Kelvin. See
     * <a href="https://en.wikipedia.org/wiki/Boltzmann_constant">Wikipedia: Boltzmann constant</a>
     */
    public static final DoubleScalar.Rel<SIUnit> BOLTZMANN = make(1.380649e-23, "kgm2/s2K");

    /** Electrical charge of one electron. */
    public static final ElectricalCharge ELECTRONCHARGE = new ElectricalCharge(-1, ElectricalChargeUnit.ATOMIC_UNIT);

    /**
     * Mass of an electron. See <a href="https://en.wikipedia.org/wiki/Physical_constant">Wikipedia Physical constant</a>. This
     * value of this physical constant has an uncertainty of 2.8e-40 kg.
     */
    public static final Mass ELECTRONMASS = Mass.of(9.1093837015e-31, "kg");

    /** ElectricalCharge of one proton. */
    public static final ElectricalCharge PROTONCHARGE = new ElectricalCharge(1, ElectricalChargeUnit.ATOMIC_UNIT);

    /**
     * Mass of a neutron. See <a href="https://en.wikipedia.org/wiki/List_of_physical_constants">Wikipedia List of physical
     * constants</a>. This value of this physical constant has an uncertainty of 9.5e-37 kg.
     */
    public static final Mass NEUTRONMASS = Mass.of(1.67492749804e-27, "kg");

    /**
     * Mass of a proton. See <a href="https://en.wikipedia.org/wiki/Physical_constant">Wikipedia Physical constant</a>. This
     * value of this physical constant has an uncertainty of 5.1e-37.
     */
    public static final Mass PROTONMASS = Mass.of(1.67272192369e-27, "kg");

    /**
     * Gravitational constant, a.k.a. Newtonian constant of gravitation. This is the 2018 best known approximation, which has an
     * uncertainty 1.5e-15 m^3/kgs^2
     */
    public static final DoubleScalar.Rel<SIUnit> G = make(6.67430e-11, "m3/kgs2");

    /** Speed of light in vacuum. This value is exact (the value of the meter is based on this and the value of the second). */
    public static final Speed LIGHTSPEED = Speed.of(299792458, "m/s");

    /**
     * Permeability of vacuum. See <a href="https://en.wikipedia.org/wiki/Vacuum_permeability">Wikipedia, Vacuum
     * permeability</a>. The uncertainty of this value is 1.9e-16N/A^2.
     */
    public static final DoubleScalar.Rel<SIUnit> VACUUMPERMEABILITY = make(1.25663706212e-6, "kgm/s2A2");

    /**
     * Permittivity of vacuum. See <a href="https://en.wikipedia.org/wiki/Vacuum_permittivity">Wikipedia Vacuum
     * permittivity</a>. The uncertainty of this value is 1.3e-21 F/m.
     */
    public static final DoubleScalar.Rel<SIUnit> VACUUMPERMITTIVITY = make(8.8541878128e-12, "s4A2/kgm3");

    /** Impedance of vacuum. */
    public static final SIScalar VACUUMIMPEDANCE = VACUUMPERMEABILITY.divideBy(VACUUMPERMITTIVITY);

    /** Planck constant; ratio of a photon's energy and its frequency. */
    public static final DoubleScalar.Rel<SIUnit> PLANCK = make(6.62607015e34, "kgm2/s");

    /** Ratio of circumference of circle and its radius. */
    public static final Dimensionless TAU = new Dimensionless(Math.PI * 2, DimensionlessUnit.SI);

    /** Reduced Planck constant, a.k.a. angular Planck constant; Planck constant divided by 2 pi. */
    public static final SIScalar PLANKREDUCED = PLANCK.divideBy(TAU);

    /**
     * Construct a new DoubleScalar.Rel&lt;SIUnit&gt; catching (and ignoring any UnitException.
     * <P>
     * TODO: this is ugly.
     * @param value double; the value of the result
     * @param siString String; the si coefficient string
     * @return DoubleScalar.Rel&lt;SIUnit&gt;; the new double scalar (or null when a UnitException occurred)
     */
    private static DoubleScalar.Rel<SIUnit> make(final double value, final String siString)
    {
        try
        {
            return new DoubleScalar.Rel<>(value, SIUnit.of(siString));
        }
        catch (UnitException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
