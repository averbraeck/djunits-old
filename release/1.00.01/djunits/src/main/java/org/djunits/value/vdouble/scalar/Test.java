package org.djunits.value.vdouble.scalar;

/**
 * <p>
 * Copyright (c) 2013-2014 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">djunits License</a>.
 * <p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Aug 30, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Test implements DOUBLE_SCALAR
{
    /** length. */
    private final Length.Rel length;

    /** time. */
    private final Time.Abs time;

    /**
     * @param length length
     * @param time time
     */
    public Test(final Length.Rel length, final Time.Abs time)
    {
        super();
        this.length = length;
        this.time = time;
        test();
    }

    /** test method. */
    public void test()
    {
        Length.Rel l1 = new Length.Rel(10, METER);
        Length.Rel l2 = new Length.Rel(20, METER);
        Time.Abs t1 = new Time.Abs(1, MINUTE);
        Time.Abs t2 = new Time.Abs(4, MINUTE);
        Time.Rel t3 = new Time.Rel(10, SECOND);
        System.out.println(l1.gt(l2));
        System.out.println(t1.le(t2));
        Length.Rel labs = l1.abs();
        Length.Rel l3 = l1.plus(l2);
        Length.Rel l4 = l2.cbrt();
        l2 = l2.cbrt();
        System.out.println(l2.equals(l4));
        Area.Rel a1 = l1.multiplyBy(l2);
        Speed.Rel s1 = l1.divideBy(t3);
        System.out.println(getTime() + " =?" + t1 + " => " + getTime().eq(t1));
        System.out.println(getTime() + " =?" + t2 + " => " + getTime().eq(t2));
    }
    
    /**
     * @return length
     */
    public final Length.Rel getLength()
    {
        return this.length;
    }

    /**
     * @return time
     */
    public final Time.Abs getTime()
    {
        return this.time;
    }

    public static void main(String[] args)
    {
        new Test(new Length.Rel(100, CENTIMETER), new Time.Abs(60, SECOND));
    }
}
