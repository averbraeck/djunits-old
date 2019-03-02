package org.djunits.locale;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Localization object for language sprecific reporting of units.
 * <p>
 * Copyright (c) 2013-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="http://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * $LastChangedDate$, @version $Revision$, by $Author$,
 * initial version Jun 12, 2014 <br>
 * @author <a href="http://www.tbm.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="http://tudelft.nl/pknoppers">Peter Knoppers</a>
 */
public class Localization
{
    /** filename without .properties, to be found in src/main/resources folder. */
    private final String bundleNamePrefix;

    /** the resource bundle. */
    private ResourceBundle resourceBundle;

    /** current locale. */
    private Locale currentLocale = null;

    /** the default resource bundle. */
    private ResourceBundle defaultResourceBundle;

    /** default locale. */
    private Locale defaultLocale = null;

    /**
     * Create a Localization object.
     * @param prefix String; the prefix of the properties files to use.
     */
    public Localization(final String prefix)
    {
        this.bundleNamePrefix = prefix;
        getString("xyz"); // initialize the default locale
    }

    /**
     * Retrieve a string from a locale bundle. If retrieval fails the value of key string, surrounded by exclamation marks is
     * returned.
     * @param key String; the key for the locale in the properties file
     * @return localized string, or, if a translation could not be found return the key surrounded by exclamation marks
     */
    public final String getString(final String key)
    {
        if (this.currentLocale == null || !this.currentLocale.equals(DefaultLocale.getLocale()))
        {
            if (DefaultLocale.getLocale() == null)
            {
                DefaultLocale.setLocale(new Locale("en"));
            }
            this.currentLocale = DefaultLocale.getLocale();
            Locale.setDefault(this.currentLocale);
            try
            {
                this.resourceBundle = ResourceBundle.getBundle(this.bundleNamePrefix, this.currentLocale);
            }
            catch (MissingResourceException e)
            {
                try
                {
                    this.resourceBundle = ResourceBundle.getBundle("resources/" + this.bundleNamePrefix, this.currentLocale);
                }
                catch (MissingResourceException e2)
                {
                    return '!' + key.substring(key.indexOf('.') + 1) + '!';
                }
            }
        }
        if (null == this.resourceBundle)
        {
            // Failed to find the resourceBundle (on a previous call to getString)
            return '!' + key.substring(key.indexOf('.') + 1) + '!';
        }
        try
        {
            return this.resourceBundle.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key.substring(key.indexOf('.') + 1) + '!';
        }
    }

    /**
     * Retrieve a string from the default locale bundle. If retrieval fails the value of key string, surrounded by exclamation
     * marks is returned.
     * @param key String; the key for the locale in the properties file
     * @return localized string, or, if a translation could not be found return the key surrounded by exclamation marks
     */
    public final String getDefaultString(final String key)
    {
        if (this.defaultLocale == null)
        {
            this.defaultLocale = new Locale("en");
            try
            {
                this.defaultResourceBundle = ResourceBundle.getBundle(this.bundleNamePrefix, this.defaultLocale);
            }
            catch (MissingResourceException e)
            {
                try
                {
                    this.defaultResourceBundle =
                            ResourceBundle.getBundle("resources/" + this.bundleNamePrefix, this.defaultLocale);
                }
                catch (MissingResourceException e2)
                {
                    return '!' + key.substring(key.indexOf('.') + 1) + '!';
                }
            }
        }
        if (null == this.defaultResourceBundle)
        {
            // Failed to find the resourceBundle (on a previous call to getString)
            return '!' + key.substring(key.indexOf('.') + 1) + '!';
        }
        try
        {
            return this.defaultResourceBundle.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key.substring(key.indexOf('.') + 1) + '!';
        }
    }

    /**
     * @return whether the current locale is the default (English) locale
     */
    public boolean isDefault()
    {
        if (this.currentLocale == null || this.defaultLocale == null | !this.currentLocale.equals(this.defaultLocale)
                || !this.currentLocale.equals(DefaultLocale.getLocale()))
        {
            return false;
        }
        return true;
    }
}
