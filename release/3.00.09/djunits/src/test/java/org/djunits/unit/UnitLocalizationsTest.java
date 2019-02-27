package org.djunits.unit;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.djunits.AvailableLocalizations;
import org.djunits.locale.DefaultLocale;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 10, 2014 <br>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class UnitLocalizationsTest
{
    /**
     * Check that all defined units have all localizations.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public final void checkDefinedUnits()
    {
        final String head = "localeunit";
        Set<String> usedKeys = new HashSet<String>();
        ArrayList<String> errors = new ArrayList<String>();
        URL url = getResource("/");
        String path = null;
        try
        {
            path = url.toURI().getPath();
        }
        catch (URISyntaxException exception1)
        {
            exception1.printStackTrace();
        }
        // System.err.println("path is \"" + path + "\"");

        List<String> localeNames = AvailableLocalizations.availableLocalizations(head, path);
        for (String localeName : localeNames)
        {
            // System.out.println("Checking internationalization to " + localeName);
            DefaultLocale.setLocale(new Locale(localeName));

            // Reflections reflections = new Reflections("org.djunits.core.unit");
            for (String className : Unit.STANDARD_UNITS)
            {
                Class c;
                try
                {
                    c = Class.forName("org.djunits.unit." + className);
                }
                catch (Exception exception)
                {
                    Assert.fail("Class org.djunits.unit." + className + " could not be loaded");
                    return;
                }

                // System.out.println(c.getSimpleName() + ": " + Unit.getUnits(c));
                for (Object o : Unit.getUnits(c))
                {
                    Unit<?> u = (Unit<?>) o;
                    if (u.isLocalizable())
                    {
                        String nameKey = u.getNameKey();
                        assertTrue("Name key must be non-null", null != nameKey);
                        assertTrue("Name key must be non-empty", nameKey.length() > 0);
                        String abbreviationKey = u.getAbbreviationKey();
                        assertTrue("Abbreviation key must be non-null", null != abbreviationKey);
                        assertTrue("Abbreviation key must be non-empty", abbreviationKey.length() > 0);
                        usedKeys.add(nameKey);
                        usedKeys.add(abbreviationKey);
                        String name = u.getName();
                        if (name.startsWith("!") && name.endsWith("!"))
                        {
                            errors.add(String.format("Missing translation for name %s to %s", nameKey, localeName));
                        }
                        String abbreviation = u.getAbbreviation();
                        if (abbreviation.startsWith("!") && abbreviation.endsWith("!"))
                        {
                            errors.add(String.format("Missing translation for abbreviation %s to %s", abbreviationKey,
                                    localeName));
                        }
                    }
                }
            }
        }
        for (String localeName : localeNames)
        {
            Properties properties = new Properties();
            String middlePart = "";
            if (!localeName.equals("en"))
            {
                middlePart = "_" + localeName;
            }
            try
            {
                URL url2 = getResource("/");
                String path2 = url2.toURI().getPath() + "/" + head + middlePart + ".properties";
                // System.err.println("path is \"" + path2 + "\"");
                FileInputStream fileInput = new FileInputStream(path2);
                properties.load(fileInput);
                fileInput.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            ResourceBundle.clearCache();
            Set<String> unusedKeys = new HashSet<String>();
            for (Object key : properties.keySet())
            {
                String keyString = (String) key;
                if (usedKeys.contains(keyString))
                {
                    continue;
                }
                unusedKeys.add(keyString);
            }
            for (String unusedKey : unusedKeys)
            {
                errors.add(String.format("Unused key %s for locale %s", unusedKey, localeName));
            }
        }
        for (String s : errors)
        {
            System.err.println("UnitLocalizations error: " + s);
        }
        assertTrue("There should be no errors in UnitLocalizations", errors.isEmpty());
    }

    /**
     * Figure out where the resources are.
     * @param name String; path
     * @return URL
     */
    public static URL getResource(final String name)
    {
        try
        {
            File file = new File(name);

            if (name.startsWith("/"))
            {
                URL url = UnitLocalizationsTest.class.getResource(name);
                if (url != null)
                {
                    return url;
                }
                url = Thread.currentThread().getContextClassLoader().getResource(name.substring(1));
                if (url != null)
                {
                    return url;
                }
                if (file.exists())
                {
                    return new URL("file:" + name);
                }
            }
            else if (name.startsWith("\\") || name.contains("\\")) // added the second part
            {
                if (file.exists())
                {
                    return new URL("file:" + name);
                }
            }
            else if (file.exists())
            {
                return new URL("file:" + name);
            }
        }
        catch (Exception exception)
        {
            exception = null;
            // We neglect exceptions since we return null
        }
        return null;
    }

}
