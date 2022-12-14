package org.djunits.cleanup;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Utility to clean the .classfile files for all projects; the excludes=** will be removed. Run this class only from
 * Eclipse!<br>
 * <p>
 * Copyright (c) 2003-2022 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved.<br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public final class CleanClassfileFiles
{
    /** */
    private CleanClassfileFiles()
    {
        // utility class
    }

    /**
     * @param args String[]; none
     * @throws IOException on I/O error
     * @throws URISyntaxException on I/O error
     */
    public static void main(final String[] args) throws IOException, URISyntaxException
    {
        File classFolder = new File(CleanClassfileFiles.class.getResource("/").toURI());
        File workspaceFolder = classFolder.getParentFile().getParentFile().getParentFile();
        for (File projectFolder : workspaceFolder.listFiles())
        {
            if (projectFolder.isDirectory() && projectFolder.getName().startsWith("dju")
                    && new File(projectFolder, ".classpath").exists())
            {
                boolean changed = false;
                File classPathFile = new File(projectFolder, ".classpath");
                List<String> lines = Files.readAllLines(Paths.get(classPathFile.toURI()), StandardCharsets.UTF_8);
                for (int index = 0; index < lines.size(); index++)
                {
                    String line = lines.get(index);
                    if (line.contains("src/main/resources") && line.contains("excluding=\"**\""))
                    {
                        line = line.replace("excluding=\"**\" ", "");
                        lines.set(index, line);
                        changed = true;
                    }
                }
                if (changed)
                {
                    Files.write(Paths.get(classPathFile.toURI()), lines);
                    System.out.println("Changed: " + projectFolder.toString());
                }
            }
        }
    }

}
