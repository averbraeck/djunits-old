package org.djunits.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    /** The output folder of the writer -- will be written in Eclipse project-root/generated-code/org/djunits folder. */
    private static final String generatedCodeRelativePath = "/generated-code/org/djunits/";

    /**
     * The calculated absolute output path (root of the executable or Jar file). In case of an Eclipse run, ../../ is added to
     * the path to place the results in the root of the project, rather than in target/classes.
     */
    private static String absoluteRootPath;

    /** List of Abs + Rel types. */
    private static List<String> typesAbsRel = new ArrayList<>();

    /** List of Rel types. */
    private static List<String> typesRel = new ArrayList<>();

    /** Map of types to formulas. */
    private static Map<String, List<String>> formulas = new HashMap<>();

    /**
     * Read the types from the file /TYPES_ABS_REL.txt.
     * @throws IOException
     */
    private static void readAbsRelTypes() throws IOException
    {
        URL typesURL = URLResource.getResource("/TYPES_ABS_REL.txt");
        FileReader fileReader = new FileReader(new File(typesURL.getPath()));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null)
        {
            if (line.length() > 0)
            {
                typesAbsRel.add(line);
            }
        }
        bufferedReader.close();
    }

    /**
     * Read the types from the file /TYPES_REL.txt.
     * @throws IOException
     */
    private static void readRelTypes() throws IOException
    {
        URL typesURL = URLResource.getResource("/TYPES_REL.txt");
        FileReader fileReader = new FileReader(new File(typesURL.getPath()));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null)
        {
            if (line.length() > 0)
            {
                typesRel.add(line);
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
            String absRel = (type.endsWith(".Rel")) ? "Rel" : "Abs";
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
                String siOrMoney = (result.startsWith("Money")) ? ".getStandard" + result + "Unit()" : ".SI";
                fStr += "        /**\n";
                fStr += "         * Calculate the " + dm + " of " + type + " and " + param + ", which results in a ";
                fStr += result + " scalar.\n";
                fStr += "         * @param v " + type + " scalar\n";
                fStr += "         * @return " + result + " scalar as a " + dm + " of " + type + " and " + param + "\n";
                fStr += "         */\n";
                fStr += "        public final " + result + "." + absRel + " " + method;
                fStr += "(final " + param + "." + absRel + " v)\n";
                fStr += "        {\n";
                fStr += "            return new " + result + "." + absRel + "(this.si " + mdsign + " v.si, ";
                fStr += result + "Unit" + siOrMoney + ");\n";
                fStr += "        }\n\n";
            }
            ret = ret.substring(0, pos - 1) + fStr + ret.substring(pos + type.length() + 5, ret.length() - 1);
        }
        
        // remove the ".Rel" for the purely relative units.
        for (String relType : typesRel)
        {
            ret = ret.replaceAll(relType + "\\.Rel", relType);
            ret = ret.replaceAll(relType + "\\.Abs", relType);
        }
        return ret;
    }

    /**
     * Generate all Abs + Rel classes in value.vdouble.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleScalarAbsRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_SCALAR_ABS_REL.java");
        URL insertURL = URLResource.getResource("/" + relativePath + "INSERT.java");
        boolean isInsert = (insertURL != null) && new File(insertURL.toURI()).exists();
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));
        String insertJava = "";
        if (isInsert)
        {
            insertJava = new String(Files.readAllBytes(Paths.get(insertURL.toURI())));
        }

        for (String type : typesAbsRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + ".java");
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
            System.out.println("built: " + absoluteRootPath + relativePath + type + ".java");
        }
    }

    /**
     * Generate all Rel classes in value.vdouble.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleScalarRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_SCALAR_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%TYPE%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = formulas(java, "DoubleScalar => " + type);
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + ".java");
        }
    }

    /**
     * Generate all Abs + Rel classes in value.vfloat.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatScalarAbsRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_SCALAR_ABS_REL.java");
        URL insertURL = URLResource.getResource("/" + relativePath + "INSERT.java");
        boolean isInsert = (insertURL != null) && new File(insertURL.toURI()).exists();
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));
        String insertJava = "";
        if (isInsert)
        {
            insertJava = new String(Files.readAllBytes(Paths.get(insertURL.toURI())));
        }

        for (String type : typesAbsRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + ".java");
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
            System.out.println("built: " + absoluteRootPath + relativePath + type + ".java");
        }
    }

    /**
     * Generate all Rel classes in value.vfloat.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatScalarRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_SCALAR_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%TYPE%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = formulas(java, "FloatScalar => " + type);
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + ".java");
        }
    }

    /**
     * Determine calculated absolute output path (root of the executable or Jar file). In case of an Eclipse run, ../../ is
     * added to the path to place the results in the root of the project, rather than in target/classes.<br>
     * See https://weblogs.java.net/blog/kohsuke/archive/2007/04/how_to_convert.html and
     * http://stackoverflow.com/questions/320542/how-to-get-the-path-of-a-running-jar-file and
     * http://stackoverflow.com/questions/3153337/get-current-working-directory-in-java
     * @throws FileNotFoundException
     */
    private static void makeAndCleanAbsolutePath() throws FileNotFoundException
    {
        URL mainURL = URLResource.getResource("/");
        String path;
        try
        {
            path = mainURL.toURI().getPath();
        }
        catch (URISyntaxException exception)
        {
            path = mainURL.getPath();
        }
        if (path.endsWith("/target/classes/"))
        {
            path = path.substring(0, path.length() - "/target/classes/".length());
        }
        path += generatedCodeRelativePath;
        if (!new File(path).exists())
        {
            new File(path).mkdirs();
        }
        else
        {
            System.out.println("about to delete: " + path);
            // if (!deleteRecursive(new File(path)))
            // {
            // System.err.println("Could not empty directory " + path);
            // System.exit(-1);
            // }
        }
        absoluteRootPath = path;
        System.out.println("writing into: " + path);
    }

    /**
     * By default File#delete fails for non-empty directories, it works like "rm". We need something a little more brutual -
     * this does the equivalent of "rm -r". From: http://stackoverflow.com/questions/779519/delete-files-recursively-in-java.
     * Note: USE CAREFULLY.
     * @param path Root File Path
     * @return true iff the file and all sub files/directories have been removed
     * @throws FileNotFoundException on error (e.g., locked file)
     */
    public static boolean deleteRecursive(File path) throws FileNotFoundException
    {
        if (!path.exists())
        {
            throw new FileNotFoundException(path.getAbsolutePath());
        }
        boolean ret = true;
        if (path.isDirectory())
        {
            for (File f : path.listFiles())
            {
                ret = ret && deleteRecursive(f);
            }
        }
        return ret && path.delete();
    }

    /**
     * @param args
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        makeAndCleanAbsolutePath();
        readAbsRelTypes();
        readRelTypes();
        readFormulas();
        generateDoubleScalarAbsRel();
        generateDoubleScalarRel();
        generateFloatScalarAbsRel();
        generateFloatScalarRel();
    }

}
