package org.djunits.unit.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.djunits.unit.Unit;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.unit.scale.LinearScale;
import org.djunits.unit.si.SIDimensions;
import org.djunits.unit.si.SIPrefixes;
import org.djunits.unit.unitsystem.UnitSystem;
import org.djunits.unit.util.UnitException;
import org.djunits.unit.util.UnitRuntimeException;
import org.junit.Test;

/**
 * UnitBaseTest.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class UnitBaseTest
{
    /**
     * Test the UnitBase functions.
     * @throws UnitException on error
     */
    @SuppressWarnings("rawtypes")
    @Test
    public void testUnitBase() throws UnitException
    {

        assertEquals(QUnit.BASE, QUnit.BASE);
        assertNotEquals(QUnit.BASE, null);
        assertNotEquals(QUnit.BASE, new Object());
        UnitBase<QUnit> unitBase1 = new UnitBase<>(SIDimensions.of("kgm4/s5A3"));
        UnitBase<QUnit> unitBase2 = new UnitBase<>(new SIDimensions(0, 0, 1, 4, -5, -3, 0, 0, 0));
        UnitBase<QUnit> unitBase3 = new UnitBase<>(new byte[] {0, 0, 1, 4, -5, -3, 0, 0, 0});
        assertEquals(unitBase1, unitBase2);
        assertEquals(unitBase1, unitBase3);
        assertNotEquals(unitBase1, QUnit.BASE); // QUnit has a standard base; unitBase1 not (yet)
        assertNotEquals(unitBase1.hashCode(), QUnit.BASE.hashCode()); // QUnit has a standard base; unitBase1 not (yet)
        assertEquals(new SIDimensions(0, 0, 1, 4, -5, -3, 0, 0, 0), unitBase1.getSiDimensions());
        UnitBase<QUnit> unitBase4 = new UnitBase<>(SIDimensions.of("kg2m4/s5A3"));
        assertNotEquals(unitBase1, unitBase4);

        try
        {
            SIDimensions si = null;
            UnitBase<QUnit> unitBase5 = new UnitBase<>(si);
            fail("Should not have been able to create " + unitBase5 + " with argument null");
        }
        catch (NullPointerException | UnitRuntimeException e)
        {
            // ok
        }

        try
        {
            String si = null;
            UnitBase<QUnit> unitBase6 = new UnitBase<>(si);
            fail("Should not have been able to create " + unitBase6 + " with argument null");
        }
        catch (NullPointerException | UnitRuntimeException e)
        {
            // ok
        }

        assertEquals(QUnit.SI, QUnit.BASE.of("Q"));
        assertEquals(QUnit.SI, QUnit.BASE.getStandardUnit());
        assertEquals(QUnit.SI, QUnit.BASE.getUnitByAbbreviation("Q"));
        assertEquals(QUnit.SI, QUnit.BASE.getUnitById("Q"));

        assertEquals(QUnit.QQQ, QUnit.BASE.of("QQQ"));
        assertNotEquals(QUnit.QQQ, QUnit.BASE.getStandardUnit());
        assertEquals(QUnit.QQQ, QUnit.BASE.getUnitByAbbreviation("QQQ"));
        assertEquals(QUnit.QQQ, QUnit.BASE.getUnitById("QQQ"));

        assertEquals(QUnit.KILOQUEEZ, QUnit.BASE.of("kQ"));
        assertNotNull(QUnit.BASE.of("yQ"));
        assertNotNull(QUnit.BASE.of("YQ"));
        assertNotNull(QUnit.BASE.of("muQ"));
        assertNotNull(QUnit.BASE.of("MQ"));

        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("kgm4/s5A3"));
        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("kg.m4/s5.A3"));
        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("kg.m^4/s^5.A^3"));
        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("kgm4s-5A-3"));
        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("kg.m4.s-5.A-3"));
        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("kg.m^4.s^-5.A^-3"));
        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("m4kg/A3s5"));
        assertEquals(QUnit.QUEEZ, QUnit.BASE.of("s^-5.A^-3.kg.m^4"));
        assertNull(QUnit.BASE.of("kgm4/s5A4"));
        assertNull(QUnit.BASE.of("abcdef"));
        assertNull(QUnit.BASE.of("s^-5.A^-3.kg^-1.m^4"));

        assertEquals(QUnit.BASE.of("GQ"), QUnit.BASE.getUnitById("GQ"));
        assertEquals(QUnit.BASE.of("GQ"), QUnit.BASE.getUnitsById().get("GQ"));
        assertEquals(QUnit.BASE.of("GQ"), QUnit.BASE.getUnitByAbbreviation("GQ"));
        assertEquals(QUnit.BASE.of("GQ"), QUnit.BASE.getUnitsByAbbreviation().get("GQ"));

        try
        {
            SIDimensions.of("m/m/m/m");
            fail("UnitBase.of string with multiple slashes should have thrown a UnitRuntimeException");
        }
        catch (UnitException ut)
        {
            // Ignore expected exception
        }
        try
        {
            new UnitBase("m/m/m/m");
            fail("constructing UnitBase from string with multiple slashes should have thrown a UnitRuntimeException");
        }
        catch (UnitRuntimeException urt)
        {
            // Ignore expected exception
        }

        QUnit.BASE.unregister(QUnit.QQQ);
        assertNull(QUnit.BASE.of("QQQ"));
        UnitTypes.INSTANCE.unregister(unitBase1); // probably not registered
        UnitTypes.INSTANCE.unregister(unitBase2); // probably not registered
        UnitTypes.INSTANCE.unregister(unitBase3); // probably not registered
        UnitTypes.INSTANCE.unregister(unitBase4); // probably not registered
        UnitTypes.INSTANCE.unregister(QUnit.BASE); // should unregister
    }

    /** */
    protected static class QUnit extends Unit<QUnit>
    {
        /** */
        private static final long serialVersionUID = 1L;

        /** */
        public static final UnitBase<QUnit> BASE = new UnitBase<>("kgm4/s5A3");

        /** */
        public static final QUnit SI =
                new QUnit().build(new Unit.Builder<QUnit>().setId("Q").setName("queez").setScale(IdentityScale.SCALE)
                        .setSiPrefixes(SIPrefixes.UNIT).setUnitBase(BASE).setUnitSystem(UnitSystem.OTHER));

        /** */
        public static final QUnit QUEEZ = SI;

        /** */
        public static final QUnit KILOQUEEZ =
                new QUnit().build(new Unit.Builder<QUnit>().setId("kQ").setName("kiloqueez").setScale(new LinearScale(1000.0))
                        .setSiPrefixes(SIPrefixes.NONE).setUnitBase(BASE).setUnitSystem(UnitSystem.OTHER));

        /** */
        public static final QUnit MEGAQUEEZ = new QUnit()
                .build(new Unit.Builder<QUnit>().setId("MQ").setName("megaqueez").setScale(new LinearScale(1_000_000.0))
                        .setSiPrefixes(SIPrefixes.NONE).setUnitBase(BASE).setUnitSystem(UnitSystem.OTHER));

        /** */
        public static final QUnit QQQ =
                new QUnit().build(new Unit.Builder<QUnit>().setId("QQQ").setName("qqqeezz").setScale(new LinearScale(86400.0))
                        .setSiPrefixes(SIPrefixes.NONE).setUnitBase(BASE).setUnitSystem(UnitSystem.OTHER));
    }

}
