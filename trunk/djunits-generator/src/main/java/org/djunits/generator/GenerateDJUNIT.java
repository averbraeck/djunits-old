package org.djunits.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Copyright (c) 2013-2014 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://opentrafficsim.org/docs/license.html">OpenTrafficSim License</a>.
 * <p>
 * $LastChangedDate: 2015-07-24 02:58:59 +0200 (Fri, 24 Jul 2015) $, @version $Revision: 1147 $, by $Author: averbraeck $,
 * initial version Sep 1, 2015 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class GenerateDJUNIT
{
    /** The output folder of the writer -- this should correspond to the src/main/java/org/djunits folder. */
    private static final String rootPath = "D:/java/opentrafficsim/workspace/djunits/src/main/java/org/djunits/";

    /** List of types. */
    private static List<String> types = new ArrayList<>();

    /** Map of types to formulas. */
    private static Map<String, List<String>> formulas = new HashMap<>();

    /**
     * Read the types from the file /TYPES.txt.
     * @throws IOException
     */
    private static void readTypes() throws IOException
    {
        URL typesURL = URLResource.getResource("/TYPES.txt");
        FileReader fileReader = new FileReader(new File(typesURL.getPath()));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null)
        {
            if (line.length() > 0)
            {
                types.add(line);
            }
        }
        bufferedReader.close();
    }

    /**
     * Read the formulas from the file /FORMULAS.txt.
     * @throws IOException
     */
    private static void readFormulas() throws IOException
    {
        URL typesURL = URLResource.getResource("/FORMULAS.txt");
        FileReader fileReader = new FileReader(new File(typesURL.getPath()));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String type = null;
        String line = null;
        List<String> flist = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null)
        {
            if (line.startsWith("%"))
            {
                if (type != null)
                {
                    formulas.put(type, flist);
                }
                type = line.replaceAll("%", "").trim();
                flist = new ArrayList<>();
            }
            else
            {
                if (line.trim().length() > 0)
                {
                    flist.add(line.trim());
                }
            }
        }
        formulas.put(type, flist);
        bufferedReader.close();
    }

    /**
     * Insert text from the ins-file into the %INSERT% marker within the Java file.
     * @param java the java file
     * @param ins the file with all insert strings
     * @param type the type for error messaging
     * @return the file with replacements
     */
    private static String insert(String java, String ins, String type)
    {
        String ret = java;
        while (ret.contains("%INSERT%"))
        {
            int pos = ret.indexOf("%INSERT%");
            ret = ret.replaceFirst("%INSERT%", "");
            int end = ret.indexOf("%", pos);
            if (end == -1)
            {
                System.err.println("Closing % not found for %INSERT% in file for type " + type);
                return ret;
            }
            String insToken = ret.substring(pos, end);
            int i1 = ins.indexOf("%" + insToken + "%");
            String insString = "";
            if (i1 == -1)
            {
                System.out.println("Warning: %INSERT% token " + insToken + " not found in insert-file for type " + type);
            }
            else
            {
                int i2 = ins.indexOf("%", i1 + insToken.length() + 4);
                i2 = (i2 == -1) ? ins.length() - 1 : i2 - 1;
                insString = ins.substring(i1 + insToken.length() + 4, i2);
            }
            ret = ret.substring(0, pos - 1) + insString + ret.substring(pos + insToken.length() + 2, ret.length() - 1);
        }
        return ret;
    }

    /**
     * Insert formulas based on FORMULAS.txt into the %FORMULAS% marker within the Java file.
     * @param java the java file
     * @param errorType the type for error messaging
     * @return the file with replacements
     */
    private static String formulas(String java, String errorType)
    {
        String ret = java;
        while (ret.contains("%FORMULAS%"))
        {
            int pos = ret.indexOf("%FORMULAS%");
            ret = ret.replaceFirst("%FORMULAS%", "");
            int end = ret.indexOf("%", pos);
            if (end == -1)
            {
                System.err.println("Closing % not found for %FORMULAS% in file for type " + errorType);
                return ret;
            }
            String type = ret.substring(pos, end);
            String absrel = (type.endsWith(".Rel")) ? "Rel" : "Abs";
            type = type.substring(0, type.length() - 4);
            if (!formulas.containsKey(type))
            {
                System.err.println("Formulas in FORMULAS.txt does not contain entry for type " + errorType);
                return ret.substring(0, pos - 1) + ret.substring(pos + type.length() + 2, ret.length() - 1);
            }
            String fStr = "";
            for (String f : formulas.get(type))
            {
                String dm = f.startsWith("/") ? "division" : "multiplication";
                String method = f.startsWith("/") ? "divideBy" : "multiplyBy";
                String mdsign = f.startsWith("/") ? "/" : "*";
                f = f.substring(1, f.length());
                String param = f.split("=")[0].trim();
                String result = f.split("=")[1].trim();
                fStr += "        /**\n";
                fStr += "         * @param v " + type + " scalar\n";
                fStr += "         * @return " + result + " scalar as a " + dm + " of " + type + " and " + param + "\n";
                fStr += "         */\n";
                fStr += "        public final " + result + "." + absrel + " " + method;
                fStr += "(final " + param + "." + absrel + " v)\n";
                fStr += "        {\n";
                fStr += "            return new " + result + "." + absrel + "(this.si " + mdsign + " v.si, ";
                fStr += result + "Unit.SI);\n";
                fStr += "        }\n\n";
            }
            ret = ret.substring(0, pos - 1) + fStr + ret.substring(pos + type.length() + 5, ret.length() - 1);
        }
        return ret;
    }

    /**
     * Generate all classes in value.vdouble.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleScalar() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "SCALAR.java");
        URL insertURL = URLResource.getResource("/" + relativePath + "INSERT.java");
        boolean isInsert = (insertURL != null) && new File(insertURL.toURI()).exists();
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));
        String insertJava = "";
        if (isInsert)
        {
            insertJava = new String(Files.readAllBytes(Paths.get(insertURL.toURI())));
        }

        for (String type : types)
        {
            File outPath = new File(rootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(rootPath + relativePath + type + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%TYPE%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            if (isInsert)
            {
                java = insert(java, insertJava, "DoubleScalar => " + type);
            }
            java = formulas(java, "DoubleScalar => " + type);
            out.print(java);
            out.close();
        }
    }

    /**
     * Generate all classes in value.vfloat.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatScalar() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "SCALAR.java");
        URL insertURL = URLResource.getResource("/" + relativePath + "INSERT.java");
        boolean isInsert = (insertURL != null) && new File(insertURL.toURI()).exists();
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));
        String insertJava = "";
        if (isInsert)
        {
            insertJava = new String(Files.readAllBytes(Paths.get(insertURL.toURI())));
        }

        for (String type : types)
        {
            File outPath = new File(rootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(rootPath + relativePath + type + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%TYPE%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            if (isInsert)
            {
                java = insert(java, insertJava, "FloatScalar => " + type);
            }
            java = formulas(java, "FloatScalar => " + type);
            out.print(java);
            out.close();
        }
    }

    /**
     * @param args
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        readTypes();
        readFormulas();
        generateDoubleScalar();
        generateFloatScalar();
    }

}
