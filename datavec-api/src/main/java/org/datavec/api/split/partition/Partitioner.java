package org.datavec.api.split.partition;

import org.datavec.api.conf.Configuration;
import org.datavec.api.split.InputSplit;

import java.io.OutputStream;

public interface Partitioner {

    /**
     * Returns the number of partitions
     * @return
     */
    int numPartitions();

    /**
     * Initializes this partitioner with the given configuration
     * and input split
     * @param inputSplit the input split to use with this partitioner
     */
    void init(InputSplit inputSplit);

    /**
     * Initializes this partitioner with the given configuration
     * and input split
     * @param configuration the configuration to configure
     *                      this partitioner with
     * @param split the input split to use with this partitioner
     */
    void init(Configuration configuration,InputSplit split);

    /**
     * Updates the metadata for this partitioner
     * (to indicate whether the next partition is needed or not)
     * @param metadata
     */
    void updatePartitionInfo(Object...metadata);

    /**
     * Returns true if the partition needs to be moved to the next.
     * This is controlled with {@link #updatePartitionInfo(Object...)}
     * which handles incrementing counters and the like
     * to determine whether the current partition has been exhausted.
     * @return
     */
    boolean needsNewPartition();


    /**
     * "Increment" to the next stream
     * @return the new opened output stream
     */
    OutputStream openNewStream();

    /**
     * Get the current output stream
     * @return
     */
    OutputStream currentOutputStream();

}
