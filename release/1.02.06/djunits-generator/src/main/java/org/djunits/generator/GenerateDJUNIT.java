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
 * $LastChangedDate$, @version $Revision$, by $Author$, initial
 * version Sep 1, 2015 <br>
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

    /** List of Money types. */
    private static List<String> typesMoney = new ArrayList<>();

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
     * Read the types from the file /TYPES_MONEY.txt.
     * @throws IOException
     */
    private static void readMoneyTypes() throws IOException
    {
        URL typesURL = URLResource.getResource("/TYPES_MONEY.txt");
        FileReader fileReader = new FileReader(new File(typesURL.getPath()));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null)
        {
            if (line.length() > 0)
            {
                typesMoney.add(line);
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

    /****************************************************************************************************************/
    /********************************************* SCALAR ***********************************************************/
    /****************************************************************************************************************/

    /**
     * Insert formulas based on FORMULAS.txt into the %FORMULAS% marker within the Java file.
     * @param java the java file
     * @param errorType the type for error messaging
     * @param prefix e.g., Float for Float types, or blank for Double types
     * @return the file with replacements
     */
    private static String formulas(String java, String errorType, String prefix)
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
            boolean isAbs = type.endsWith(".Abs");
            String absRel = isAbs ? "Abs" : "Rel";
            type = type.substring(0, type.length() - 4);
            String pType = prefix + type;
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
                if (!isAbs)
                {
                    String pParam = prefix + param;
                    String pResult = prefix + result;

                    fStr += "        /**\n";
                    fStr +=
                        "         * Calculate the " + dm + " of " + pType + " and " + pParam + ", which results in a ";
                    fStr += pResult + " scalar.\n";
                    fStr += "         * @param v " + pType + " scalar\n";
                    fStr +=
                        "         * @return " + pResult + " scalar as a " + dm + " of " + pType + " and " + pParam
                            + "\n";
                    fStr += "         */\n";
                    fStr += "        public final " + pResult + "." + absRel + " " + method;
                    fStr += "(final " + pParam + "." + absRel + " v)\n";
                    fStr += "        {\n";
                    fStr += "            return new " + pResult + "." + absRel + "(this.si " + mdsign + " v.si, ";
                    fStr += result + "Unit" + siOrMoney + ");\n";
                    fStr += "        }\n\n";
                }
            }
            ret = ret.substring(0, pos - 1) + fStr + ret.substring(pos + type.length() + 5, ret.length() - 1);
        }

        // remove the ".Abs" and ".Rel" for the purely relative units and money units.
        for (String relType : typesRel)
        {
            ret = ret.replaceAll(relType + "\\.Rel", relType);
            ret = ret.replaceAll(relType + "\\.Abs", relType);
        }
        for (String moneyType : typesMoney)
        {
            ret = ret.replaceAll(moneyType + "\\.Rel", moneyType);
            ret = ret.replaceAll(moneyType + "\\.Abs", moneyType);
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
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesAbsRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulas(java, "DoubleScalar => " + type, "");
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
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            if (java.contains("class Dimensionless"))
            {
                java = java.replaceAll("TypedDoubleScalarRel", "TypedDoubleScalarDimensionless");
            }
            java = formulas(java, "DoubleScalar => " + type, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + ".java");
        }
    }

    /**
     * Generate all Money classes in value.vdouble.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleScalarMoney() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_SCALAR_MONEY.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulas(java, "DoubleScalar => " + type, "");
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
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesAbsRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulas(java, "FloatScalar => " + type, "Float");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + ".java");
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
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            if (java.contains("class FloatDimensionless"))
            {
                java = java.replaceAll("TypedFloatScalarRel", "TypedFloatScalarDimensionless");
            }
            java = formulas(java, "FloatScalar => " + type, "Float");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + ".java");
        }
    }

    /**
     * Generate all Money classes in value.vfloat.scalar.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatScalarMoney() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/scalar/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_SCALAR_MONEY.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + ".java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulas(java, "FloatScalar => " + type, "Float");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + ".java");
        }
    }

    /****************************************************************************************************************/
    /************************************************ VECTOR ********************************************************/
    /****************************************************************************************************************/

    /**
     * Insert formulas based on FORMULAS.txt into the %FORMULAS% marker within the Java file.
     * @param java the java file
     * @param errorType the type for error messaging
     * @param prefix e.g., Float for Float types, or blank for Double types
     * @return the file with replacements
     */
    private static String formulasVector(String java, String errorType, String prefix)
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
            boolean isAbs = type.endsWith(".Abs");
            String absRel = isAbs ? "Abs" : "Rel";
            type = type.substring(0, type.length() - 4);
            String pType = prefix + type;
            if (!formulas.containsKey(type))
            {
                System.err.println("Formulas in FORMULAS.txt does not contain entry for type " + errorType);
                return ret.substring(0, pos - 1) + ret.substring(pos + type.length() + 2, ret.length() - 1);
            }
            String fStr = "";
            // for (String f : formulas.get(type))
            // {
            // String dm = f.startsWith("/") ? "division" : "multiplication";
            // String method = f.startsWith("/") ? "divideBy" : "multiplyBy";
            // String mdsign = f.startsWith("/") ? "/" : "*";
            // f = f.substring(1, f.length());
            // String param = f.split("=")[0].trim();
            // String result = f.split("=")[1].trim();
            // String siOrMoney = (result.startsWith("Money")) ? ".getStandard" + result + "Unit()" : ".SI";
            // if (!isAbs)
            // {
            // String pParam = prefix + param;
            // String pResult = prefix + result;
            //
            // fStr += "        /**\n";
            // fStr +=
            // "         * Calculate the " + dm + " of " + pType + " and " + pParam + ", which results in a ";
            // fStr += pResult + " scalar.\n";
            // fStr += "         * @param v " + pType + " scalar\n";
            // fStr +=
            // "         * @return " + pResult + " scalar as a " + dm + " of " + pType + " and " + pParam
            // + "\n";
            // fStr += "         */\n";
            // fStr += "        public final " + pResult + "." + absRel + " " + method;
            // fStr += "(final " + pParam + "." + absRel + " v)\n";
            // fStr += "        {\n";
            // fStr += "            return new " + pResult + "." + absRel + "(this.si " + mdsign + " v.si, ";
            // fStr += result + "Unit" + siOrMoney + ");\n";
            // fStr += "        }\n\n";
            // }
            // }
            ret = ret.substring(0, pos - 1) + fStr + ret.substring(pos + type.length() + 5, ret.length() - 1);
        }

        // remove the ".Abs" and ".Rel" for the purely relative units and money units.
        for (String relType : typesRel)
        {
            ret = ret.replaceAll(relType + "\\.Rel", relType);
            ret = ret.replaceAll(relType + "\\.Abs", relType);
        }
        for (String moneyType : typesMoney)
        {
            ret = ret.replaceAll(moneyType + "\\.Rel", moneyType);
            ret = ret.replaceAll(moneyType + "\\.Abs", moneyType);
        }
        return ret;
    }

    /****************************************************************************************************************/
    /********************************************* DOUBLEVECTOR *****************************************************/
    /****************************************************************************************************************/

    /**
     * Generate all Abs + Rel classes in value.vdouble.vector.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleVectorAbsRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/vector/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_VECTOR_ABS_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesAbsRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "DoubleVector => " + type, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + "Vector.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_DOUBLE_VECTOR_ABS_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesAbsRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + type + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "MutableDoubleVector => " + type, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + type + "Vector.java");
        }
    }

    /**
     * Generate all Rel classes in value.vdouble.vector.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleVectorRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/vector/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_VECTOR_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "DoubleVector => " + type, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + "Vector.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_DOUBLE_VECTOR_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + type + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            if (java.contains("class MutableDimensionless"))
            {
                java = java.replaceAll("TypedDoubleVectorRel", "TypedDoubleVectorDimensionless");
            }
            java = formulasVector(java, "MutableDoubleVector => " + type, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + type + "Vector.java");
        }
    }

    /**
     * Generate all Money classes in value.vdouble.vector.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleVectorMoney() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/vector/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_VECTOR_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "DoubleVector => " + type, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + "Vector.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_DOUBLE_VECTOR_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + type + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "MutableDoubleVector => " + type, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + type + "Vector.java");
        }

    }

    /****************************************************************************************************************/
    /********************************************** FLOATVECTOR *****************************************************/
    /****************************************************************************************************************/

    /**
     * Generate all Abs + Rel classes in value.vfloat.vector.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatVectorAbsRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/vector/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_VECTOR_ABS_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesAbsRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "FloatVector => " + fType, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + "Vector.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_FLOAT_VECTOR_ABS_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesAbsRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + fType + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "MutableFloatVector => " + fType, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + fType + "Vector.java");
        }
    }

    /**
     * Generate all Rel classes in value.vfloat.vector.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatVectorRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/vector/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_VECTOR_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "FloatVector => " + fType, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + "Vector.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_FLOAT_VECTOR_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + fType + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            if (java.contains("class MutableFloatDimensionless"))
            {
                java = java.replaceAll("TypedFloatVectorRel", "TypedFloatVectorDimensionless");
            }
            java = formulasVector(java, "MutableFloatVector => " + fType, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + fType + "Vector.java");
        }
    }

    /**
     * Generate all Money classes in value.vfloat.vector.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatVectorMoney() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/vector/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_VECTOR_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "FloatVector => " + fType, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + "Vector.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_FLOAT_VECTOR_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + fType + "Vector.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasVector(java, "MutableFloatVector => " + fType, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + fType + "Vector.java");
        }

    }

    /****************************************************************************************************************/
    /************************************************ MATRIX ********************************************************/
    /****************************************************************************************************************/

    /**
     * Insert formulas based on FORMULAS.txt into the %FORMULAS% marker within the Java file.
     * @param java the java file
     * @param errorType the type for error messaging
     * @param prefix e.g., Float for Float types, or blank for Double types
     * @return the file with replacements
     */
    private static String formulasMatrix(String java, String errorType, String prefix)
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
            boolean isAbs = type.endsWith(".Abs");
            String absRel = isAbs ? "Abs" : "Rel";
            type = type.substring(0, type.length() - 4);
            String pType = prefix + type;
            if (!formulas.containsKey(type))
            {
                System.err.println("Formulas in FORMULAS.txt does not contain entry for type " + errorType);
                return ret.substring(0, pos - 1) + ret.substring(pos + type.length() + 2, ret.length() - 1);
            }
            String fStr = "";
            // for (String f : formulas.get(type))
            // {
            // String dm = f.startsWith("/") ? "division" : "multiplication";
            // String method = f.startsWith("/") ? "divideBy" : "multiplyBy";
            // String mdsign = f.startsWith("/") ? "/" : "*";
            // f = f.substring(1, f.length());
            // String param = f.split("=")[0].trim();
            // String result = f.split("=")[1].trim();
            // String siOrMoney = (result.startsWith("Money")) ? ".getStandard" + result + "Unit()" : ".SI";
            // if (!isAbs)
            // {
            // String pParam = prefix + param;
            // String pResult = prefix + result;
            //
            // fStr += "        /**\n";
            // fStr +=
            // "         * Calculate the " + dm + " of " + pType + " and " + pParam + ", which results in a ";
            // fStr += pResult + " scalar.\n";
            // fStr += "         * @param v " + pType + " scalar\n";
            // fStr +=
            // "         * @return " + pResult + " scalar as a " + dm + " of " + pType + " and " + pParam
            // + "\n";
            // fStr += "         */\n";
            // fStr += "        public final " + pResult + "." + absRel + " " + method;
            // fStr += "(final " + pParam + "." + absRel + " v)\n";
            // fStr += "        {\n";
            // fStr += "            return new " + pResult + "." + absRel + "(this.si " + mdsign + " v.si, ";
            // fStr += result + "Unit" + siOrMoney + ");\n";
            // fStr += "        }\n\n";
            // }
            // }
            ret = ret.substring(0, pos - 1) + fStr + ret.substring(pos + type.length() + 5, ret.length() - 1);
        }

        // remove the ".Abs" and ".Rel" for the purely relative units and money units.
        for (String relType : typesRel)
        {
            ret = ret.replaceAll(relType + "\\.Rel", relType);
            ret = ret.replaceAll(relType + "\\.Abs", relType);
        }
        for (String moneyType : typesMoney)
        {
            ret = ret.replaceAll(moneyType + "\\.Rel", moneyType);
            ret = ret.replaceAll(moneyType + "\\.Abs", moneyType);
        }
        return ret;
    }

    /****************************************************************************************************************/
    /********************************************* DOUBLEMATRIX *****************************************************/
    /****************************************************************************************************************/

    /**
     * Generate all Abs + Rel classes in value.vdouble.matrix.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleMatrixAbsRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/matrix/";
        URL matrixURL = URLResource.getResource("/" + relativePath + "DOUBLE_MATRIX_ABS_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(matrixURL.toURI())));

        for (String type : typesAbsRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "DoubleMatrix => " + type, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + "Matrix.java");
        }

        matrixURL = URLResource.getResource("/" + relativePath + "MUTABLE_DOUBLE_MATRIX_ABS_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(matrixURL.toURI())));

        for (String type : typesAbsRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + type + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "MutableDoubleMatrix => " + type, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + type + "Matrix.java");
        }
    }

    /**
     * Generate all Rel classes in value.vdouble.matrix.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleMatrixRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/matrix/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_MATRIX_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "DoubleMatrix => " + type, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + "Matrix.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_DOUBLE_MATRIX_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + type + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            if (java.contains("class MutableDimensionless"))
            {
                java = java.replaceAll("TypedDoubleMatrixRel", "TypedDoubleMatrixDimensionless");
            }
            java = formulasMatrix(java, "MutableDoubleMatrix => " + type, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + type + "Matrix.java");
        }
    }

    /**
     * Generate all Money classes in value.vdouble.matrix.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateDoubleMatrixMoney() throws IOException, URISyntaxException
    {
        String relativePath = "value/vdouble/matrix/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "DOUBLE_MATRIX_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + type + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "DoubleMatrix => " + type, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + type + "Matrix.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_DOUBLE_MATRIX_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + type + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "MutableDoubleMatrix => " + type, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + type + "Matrix.java");
        }

    }

    /****************************************************************************************************************/
    /********************************************** FLOATMATRIX *****************************************************/
    /****************************************************************************************************************/

    /**
     * Generate all Abs + Rel classes in value.vfloat.matrix.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatMatrixAbsRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/matrix/";
        URL matrixURL = URLResource.getResource("/" + relativePath + "FLOAT_MATRIX_ABS_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(matrixURL.toURI())));

        for (String type : typesAbsRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "FloatMatrix => " + fType, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + "Matrix.java");
        }

        matrixURL = URLResource.getResource("/" + relativePath + "MUTABLE_FLOAT_MATRIX_ABS_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(matrixURL.toURI())));

        for (String type : typesAbsRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + fType + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "MutableFloatMatrix => " + fType, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + fType + "Matrix.java");
        }
    }

    /**
     * Generate all Rel classes in value.vfloat.matrix.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatMatrixRel() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/matrix/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_MATRIX_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "FloatMatrix => " + fType, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + "Matrix.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_FLOAT_MATRIX_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesRel)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + fType + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            if (java.contains("class MutableFloatDimensionless"))
            {
                java = java.replaceAll("TypedFloatMatrixRel", "TypedFloatMatrixDimensionless");
            }
            java = formulasMatrix(java, "MutableFloatMatrix => " + fType, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + fType + "Matrix.java");
        }
    }

    /**
     * Generate all Money classes in value.vfloat.matrix.
     * @throws IOException
     * @throws URISyntaxException
     */
    private static void generateFloatMatrixMoney() throws IOException, URISyntaxException
    {
        String relativePath = "value/vfloat/matrix/";
        URL scalarURL = URLResource.getResource("/" + relativePath + "FLOAT_MATRIX_REL.java");
        String scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + fType + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "FloatMatrix => " + fType, "");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + fType + "Matrix.java");
        }

        scalarURL = URLResource.getResource("/" + relativePath + "MUTABLE_FLOAT_MATRIX_REL.java");
        scalarJava = new String(Files.readAllBytes(Paths.get(scalarURL.toURI())));

        for (String type : typesMoney)
        {
            String fType = "Float" + type;
            File outPath = new File(absoluteRootPath + relativePath);
            outPath.mkdirs();
            PrintWriter out = new PrintWriter(absoluteRootPath + relativePath + "Mutable" + fType + "Matrix.java");
            String java = new String(scalarJava);
            java = java.replaceAll("%Type%", type);
            java = java.replaceAll("%type%", type.toLowerCase());
            java = java.replaceAll("%TYPE%", type.toUpperCase());
            java = formulasMatrix(java, "MutableFloatMatrix => " + fType, "Mutable");
            out.print(java);
            out.close();
            System.out.println("built: " + absoluteRootPath + relativePath + "Mutable" + fType + "Matrix.java");
        }

    }

    /****************************************************************************************************************/
    /********************************************* GENERIC **********************************************************/
    /****************************************************************************************************************/

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
        readMoneyTypes();
        readFormulas();
        generateDoubleScalarAbsRel();
        generateDoubleScalarRel();
        generateDoubleScalarMoney();
        generateFloatScalarAbsRel();
        generateFloatScalarRel();
        generateFloatScalarMoney();

        generateDoubleVectorAbsRel();
        generateDoubleVectorRel();
        generateDoubleVectorMoney();
        generateFloatVectorAbsRel();
        generateFloatVectorRel();
        generateFloatVectorMoney();
        
        generateDoubleMatrixAbsRel();
        generateDoubleMatrixRel();
        generateDoubleMatrixMoney();
        generateFloatMatrixAbsRel();
        generateFloatMatrixRel();
        generateFloatMatrixMoney();
    }

}