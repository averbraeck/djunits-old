package org.djunits4.value.vdouble.scalar;

import org.djunits4.unit.SIUnit;

/**
 * Various physical constants.
 * <p>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class Constants
{
    /** Speed of light in vacuum. */
    public static final Speed LIGHTSPEED = new Speed.of(299792458, "m/s");

    /** Planck constant; ratio of a photon's energy and its frequency. */
    public static final DoubleScalar.Rel<SIUnit> PLANCK = new DoubleScalar.Rel<>(6.62607015e34, SIUnit.of("Js"));

    /** Number of constituent particles in a Mole. */
    public static final DoubleScalar.Rel<SIUnit> AVOGADROCONSTANT =
            new DoubleScalar.Rel<SIUnit>(6.02214076e23, SIUnit.of("1/mol"));

    /**
     * Gravitational constant, a.k.a. Newtonian constant of gravitation. This is the 2018 best known approximation, which has an
     * uncertainty 15e-16 m^3/kgs^2
     */
    public static final DoubleScalar.Rel<SIUnit> G = new DoubleScalar.Rel<>(6.67430e-11, SIUnit.of("m^3/kgs^2"));

}
