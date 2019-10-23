package org.djunits.locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * Verify that all localizations contain all keys.
 * <p>
 * @author <a href="https://www.tudelft.nl/p.knoppers">Peter Knoppers</a>
 */
public class VerifyLocalizations
{

    /**
     * Verify that all localizations have the same set of keys as the localeunit.properties file.
     * @throws IOException when a file could not be read
     */
    @Test
    public void verifyLocalizations() throws IOException
    {
        // TODO The way that this code finds the files may need fixing to work in the deploy environment.
        String pathToResources = "src/main/resources";
        String referenceFileName = "localeunit.properties";
        // Parse the localeunit.properties file and store all the keys
        List<String> reference =
                Files.readAllLines(Paths.get(pathToResources + "/" + referenceFileName), StandardCharsets.ISO_8859_1);
        Map<String, Integer> keys = new HashMap<>();
        for (int lineNo = 0; lineNo < reference.size(); lineNo++)
        {
            String line = reference.get(lineNo);
            if (line.startsWith("#"))
            {
                continue;
            }
            String[] parts = line.split("\\=");
            assertTrue(referenceFileName + "(" + (lineNo + 1) + ") should contain a equals sign", parts.length > 1);
            keys.put(parts[0].trim(), (lineNo + 1));
        }
        System.out.println("Collected " + keys.size() + " keys from reference file " + referenceFileName);
        List<Path> paths = new ArrayList<>();
        Files.list(new File(pathToResources).toPath()).forEach(path -> paths.add(path));
        for (Path path : paths)
        {
            System.out.println(path);
            if (path.getFileName().toString().startsWith("localeunit_")
                    && path.getFileName().toString().endsWith(".properties"))
            {
                Set<String> missingKeys = new TreeSet<>(keys.keySet()); 
                Set<String> foundKeys = new HashSet<>();
                int lineNo = 0;
                int errors = 0;
                for (String line : Files.readAllLines(path, StandardCharsets.ISO_8859_1))
                {
                    lineNo++;
                    if (line.startsWith("#"))
                    {
                        continue;
                    }
                    String[] parts = line.split("\\=");
                    if (parts.length < 2)
                    {
                        System.err.println(path.getFileName() + "(" + (lineNo) + ") does not contain an equals sign");
                        errors++;
                        continue;
                    }
                    String key = parts[0].trim();
                    if (!keys.containsKey(key))
                    {
                        System.err.println(path.getFileName() + "(" + lineNo + "): key " + key + " is not a valid key");
                        errors++;
                    }
                    if (foundKeys.contains(key))
                    {
                        System.err.println(path.getFileName() + "(" + lineNo + "): duplicate key " + key);
                        errors++;
                    }
                    missingKeys.remove(key);
                    foundKeys.add(key);
                }
                for (String key : missingKeys)
                {
                    System.err.println("file " + path.getFileName() + " misses key " + key);
                    errors++;
                }
                assertEquals("No errors in file " + path.getFileName(), 0, errors);
            }
        }

    }

}
