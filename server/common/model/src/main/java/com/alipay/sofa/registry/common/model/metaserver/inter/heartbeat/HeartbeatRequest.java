/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.registry.common.model.metaserver.inter.heartbeat;

import com.alipay.sofa.registry.common.model.Node;
import com.alipay.sofa.registry.common.model.slot.BaseSlotStatus;
import com.alipay.sofa.registry.common.model.slot.SlotConfig;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author shangyu.wh
 * @version $Id: RenewNodesRequest.java, v 0.1 2018-03-30 19:51 shangyu.wh Exp $
 */
public class HeartbeatRequest<T extends Node> implements Serializable {

    private int                            duration;

    private final T                        node;

    private final long                     slotTableEpoch;

    private final String                   dataCenter;

    private final long                     timestamp;

    private final SlotConfig.SlotBasicInfo slotBasicInfo;

    private final List<BaseSlotStatus>     slotStatuses;

    /**
     * constructor
     * @param node
     * @param slotTableEpoch
     */
    public HeartbeatRequest(T node, long slotTableEpoch, String dataCenter, long timestamp,
                            SlotConfig.SlotBasicInfo slotBasicInfo) {
        this.node = node;
        this.slotTableEpoch = slotTableEpoch;
        this.dataCenter = dataCenter;
        this.timestamp = timestamp;
        this.slotBasicInfo = slotBasicInfo;
        this.slotStatuses = Collections.EMPTY_LIST;
    }

    /**
     * constructor
     * @param node
     * @param slotTableEpoch
     */
    public HeartbeatRequest(T node, long slotTableEpoch, String dataCenter, long timestamp,
                            SlotConfig.SlotBasicInfo slotBasicInfo,
                            final List<BaseSlotStatus> slotStatuses) {
        this.node = node;
        this.slotTableEpoch = slotTableEpoch;
        this.dataCenter = dataCenter;
        this.timestamp = timestamp;
        this.slotBasicInfo = slotBasicInfo;
        this.slotStatuses = slotStatuses;
    }

    /**
     * Getter method for property <tt>duration</tt>.
     *
     * @return property value of duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Setter method for property <tt>duration</tt>.
     *
     * @param duration  value to be assigned to property duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Getter method for property <tt>node</tt>.
     *
     * @return property value of node
     */
    public T getNode() {
        return node;
    }

    /**
     * Gets get data center.
     *
     * @return the get data center
     */
    public String getDataCenter() {
        return dataCenter;
    }

    /**
     * Gets get timestamp.
     *
     * @return the get timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Gets get slot basic info.
     *
     * @return the get slot basic info
     */
    public SlotConfig.SlotBasicInfo getSlotBasicInfo() {
        return slotBasicInfo;
    }

    /**
     * Gets get slot table epoch.
     *
     * @return the get slot table epoch
     */
    public long getSlotTableEpoch() {
        return slotTableEpoch;
    }

    /**
     * Gets get slot status.
     *
     * @return the get slot status
     */
    public List<BaseSlotStatus> getSlotStatus() {
        return slotStatuses;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RenewNodesRequest{");
        sb.append("duration=").append(duration);
        sb.append(", node=").append(node);
        sb.append('}');
        return sb.toString();
    }
}