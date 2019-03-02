package org.djunits.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * ConvertLocale.java. <br>
 * <br>
 * Copyright (c) 2003-2018 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://www.simulation.tudelft.nl/" target="_blank">www.simulation.tudelft.nl</a>. The
 * source code and binary code of this software is proprietary information of Delft University of Technology.
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 */
public class GenerateXSD
{
    /*-
     * DurationUnit.ms = ms  | millisecond
       DurationUnit.s  = s   | second
       DurationUnit.m  = min | minute | min | m
     */
    public static void main(String[] args)
    {
        try
        {
            PrintWriter pw = new PrintWriter("E:/localeunit_nl.properties");
            String fn = GenerateXSD.class.getResource("/localeunit_nl.properties").getFile();
            BufferedReader br = new BufferedReader(new FileReader(fn));
            String line = br.readLine();
            while (line != null)
            {
                if (line.startsWith("#"))
                {
                    pw.println(line);
                }
                else if (line.startsWith("Dimensionless"))
                {
                    pw.println(line + " | 1");
                }
                else if (line.startsWith("Money"))
                {
                    pw.println(line);
                }
                else if (line.contains("="))
                {
                    String key1 = line.split("\\=")[0].trim();
                    String val1 = line.split("=")[1].trim();
                    line = br.readLine();
                    String key2 = line.split("\\=")[0].trim();
                    String val2 = line.split("\\=")[1].trim();
                    String key, v1, v2;
                    if (key1.length() < key2.length())
                    {
                        key = key1;
                        v1 = val1;
                        v2 = val2;
                    }
                    else
                    {
                        key = key2;
                        v1 = val2;
                        v2 = val1;
                    }
                    String s = key + " = " + v1 + " | " + v2;
                    if (v1.startsWith("\\u03BC"))
                    {
                        s += " | mu" + v1.substring(6);
                    }
                    pw.println(s);
                    System.out.println(s);
                }
                else
                {
                    pw.println(line);
                }
                line = br.readLine();
            }
            pw.close();
            br.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static String space(String s, int spaces)
    {
        return (s + "                                                          ").substring(0, Math.max(s.length(), spaces));
    }
}
