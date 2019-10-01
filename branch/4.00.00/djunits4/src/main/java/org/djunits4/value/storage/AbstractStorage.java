package org.djunits4.value.storage;

import org.djunits4.Throw;

/**
 * StorageInterface.java.
 * <p>
 * Copyright (c) 2019-2019 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * <p>
 * @author <a href="https://www.tudelft.nl/averbraeck" target="_blank">Alexander Verbraeck</a>
 * @param <T> the vector or matrix data type
 */
public abstract class AbstractStorage<T extends AbstractStorage<T>> implements Cloneable
{
    /** the data type. */
    protected final StorageType storageType;

    /**
     * Construct a new Data store.
     * @param storageType StorageType; the data type
     */
    public AbstractStorage(final StorageType storageType)
    {
        super();
        Throw.whenNull(storageType, "storage type cannot be null");
        this.storageType = storageType;
    }

    /**
     * Return the StorageType (DENSE, SPARSE, etc.) for the stored indexed value.
     * @return the StorageType (DENSE, SPARSE, etc.) for the stored indexed value
     */
    public final StorageType getStorageType()
    {
        return this.storageType;
    }

    /**
     * Is this indexed value dense?
     * @return boolean; true if the data storage type is dense; false if the data storage type is not dense
     */
    public final boolean isDense()
    {
        return this.storageType.equals(StorageType.DENSE);
    }

    /**
     * Is this indexed value sparse?
     * @return boolean; true if the data storage type is sparse; false if the data storage type is not sparse
     */
    public final boolean isSparse()
    {
        return this.storageType.equals(StorageType.SPARSE);
    }

    /**
     * Compute and return the number of non-zero cells in this indexed value.
     * @return int; the number of non-zero cells
     */
    public abstract int cardinality();

    /**
     * Create and return a deep copy of the data.
     * @return T; a deep copy of the data
     */
    public abstract T copy();

}