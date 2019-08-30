package org.djunits4.unit.si;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.djunits4.unit.util.UnitException;
import org.junit.Test;

/**
 * SIDimensionsTest tests the construction, addition, subtraction, and parsing of SI dimensions. <br>
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class SIDimensionsTest
{
    /**
     * Test the construction, addition, subtraction, and parsing of SI dimensions.
     * @throws UnitException on (unexpected) error
     */
    @Test
    public void testSIDimensions() throws UnitException
    {
        // all kgm/s2
        SIDimensions si1 = new SIDimensions(0, 0, 1, 1, -2, 0, 0, 0, 0);
        SIDimensions si2 = new SIDimensions(new byte[] {0, 0, 1, 1, -2, 0, 0, 0, 0});
        SIDimensions si3 = SIDimensions.of("kgm/s2");
        SIDimensions si4 = SIDimensions.of("kgms-2");
        assertEquals(si1, si2);
        assertEquals(si2, si3);
        assertEquals(si3, si4);
        assertEquals(si1.hashCode(), si2.hashCode());
        assertTrue(si1.equals(si2));
        assertTrue(si1.equals(si1));
        assertFalse(si1.equals(new Object()));
        assertFalse(si1.equals(SIDimensions.of("kgm2/s2")));
        assertFalse(si1.equals(null));
        assertEquals("[0, 0, 1, 1, -2, 0, 0, 0, 0]", si1.toString());

        // illegal "of" instances:
        illegal("kgm/s/s");
        illegal("kgkg/s");
        illegal("abcd");
        illegal("kgm-/s");
        illegal("kg-m/s");
        illegal("kgm/s-");
        illegal("kgm/");

        // legal "of" instances:
        SIDimensions.of("rad/s2");
        SIDimensions.of("rad1/s2");
        SIDimensions.of("1/s");
        SIDimensions.of("/s");
        SIDimensions.of("1/1");
        SIDimensions.of("1");
        SIDimensions.of("/1");

        SIDimensions si5 = SIDimensions.add(si1, si2);
        assertEquals("[0, 0, 2, 2, -4, 0, 0, 0, 0]", si5.toString());
        SIDimensions si6 = SIDimensions.subtract(si1, si2);
        assertEquals("[0, 0, 0, 0, 0, 0, 0, 0, 0]", si6.toString());
        SIDimensions si7 = si1.plus(si2);
        assertEquals("[0, 0, 2, 2, -4, 0, 0, 0, 0]", si7.toString());
        SIDimensions si8 = si1.minus(si2);
        assertEquals("[0, 0, 0, 0, 0, 0, 0, 0, 0]", si8.toString());

        SIDimensions si9 = SIDimensions.of("rad1sr2kg3m4s5A6K7mol8cd9");
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", si9.toString());

        SIDimensions siInv = si1.invert();
        assertEquals("[0, 0, -1, -1, 2, 0, 0, 0, 0]", siInv.toString());

        SIDimensions si10 = SIDimensions.of("kgm2s2/kgm2s");
        assertEquals("[0, 0, 0, 0, 1, 0, 0, 0, 0]", si10.toString());

        assertEquals("kgm/s2", si1.toString(true, false));
        assertEquals("kg.m/s2", si1.toString(true, true));
        assertEquals("kgms-2", si1.toString(false, false));
        assertEquals("kg.m.s-2", si1.toString(false, true));

        SIDimensions si11 = SIDimensions.of("s-3");
        assertEquals("1/s3", si11.toString(true, false));
        assertEquals("1/s3", si11.toString(true, true));
        assertEquals("s-3", si11.toString(false, false));
        assertEquals("s-3", si11.toString(false, true));

        SIDimensions si12 = SIDimensions.of("kgm2/s3A");
        assertEquals("kgm2/s3A", si12.toString(true, false));
        assertEquals("kg.m2/s3.A", si12.toString(true, true));
        assertEquals("kgm2s-3A-1", si12.toString(false, false));
        assertEquals("kg.m2.s-3.A-1", si12.toString(false, true));

        // fractional
        SIDimensions sif = new SIDimensions(new byte[] {0, 0, 1, 1, -2, 0, 0, 0, 0}, new byte[] {1, 1, 1, 1, 1, 1, 1, 1, 1});
        assertEquals(sif, si1);
        assertEquals(sif, si2);
        assertEquals(sif, si3);
        assertEquals(sif, si4);
        assertEquals(sif.hashCode(), si2.hashCode());
        assertTrue(sif.equals(si2));
        assertTrue(sif.equals(sif));
        assertFalse(sif.isFractional()); // unit denominator
        assertFalse(si2.isFractional());

        SIDimensions sif2 = new SIDimensions(new byte[] {0, 0, 1, 1, -2, -1, 0, 0, 0}, new byte[] {1, 1, 2, 2, 1, 3, 1, 1, 1});
        assertNotEquals(sif, sif2);
        assertNotEquals(sif.hashCode(), sif2.hashCode());
        assertEquals("[0, 0, 1/2, 1/2, -2, -1/3, 0, 0, 0]", sif2.toString());

        try
        {
            SIDimensions siw1 = new SIDimensions(new byte[] {0, 0, 1, 1, -2, 0, 0, 0}); // 8 long
            fail("SIDimensions.of(" + siw1 + ") should have triggered a UnitException");
        }
        catch (SIRuntimeException e)
        {
            // ignore
        }

        try
        {
            SIDimensions siw2 = new SIDimensions(new byte[] {0, 0, 1, 1, -2, 0, 0, 0, 0, 0}); // 6 long
            fail("SIDimensions.of(" + siw2 + ") should have triggered a UnitException");
        }
        catch (SIRuntimeException e)
        {
            // ignore
        }

        try
        {
            SIDimensions siw3 = new SIDimensions(new byte[] {0, 0, 1, 1, -2, 0, 0, 0}, new byte[] {1, 1, 2, 2, 1, 3, 1, 1, 1});
            fail("SIDimensions.of(" + siw3 + ") should have triggered a UnitException");
        }
        catch (SIRuntimeException e)
        {
            // ignore
        }

        try
        {
            SIDimensions siw4 =
                    new SIDimensions(new byte[] {0, 0, 1, 1, -2, 0, 0, 0, 0}, new byte[] {1, 1, 2, 2, 1, 3, 1, 1, 1, 1});
            fail("SIDimensions.of(" + siw4 + ") should have triggered a UnitException");
        }
        catch (SIRuntimeException e)
        {
            // ignore
        }
    }

    /**
     * @param si String; the (wrong) SI unit to parse
     */
    private void illegal(final String si)
    {
        try
        {
            SIDimensions.of(si);
            fail("SIDimensions.of(" + si + ") should have triggered a UnitException");
        }
        catch (UnitException e)
        {
            // ignore
        }
    }
}
