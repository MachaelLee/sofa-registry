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
package com.alipay.sofa.registry.common.model.dataserver;

import com.alipay.sofa.registry.common.model.PublisherVersion;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yuzhi.lyz
 * @version v 0.1 2020-11-05 14:27 yuzhi.lyz Exp $
 */
public class DatumSummary implements Serializable {
    private final String                                 dataInfoId;
    private Map<String/*registerId*/, PublisherVersion> publisherVersions = Maps.newHashMap();

    public DatumSummary(String dataInfoId) {
        this.dataInfoId = dataInfoId;
    }

    public DatumSummary(String dataInfoId,
                        Map<String/*registerId*/, PublisherVersion> publisherVersions) {
        this.dataInfoId = dataInfoId;
        this.publisherVersions = Collections.unmodifiableMap(Maps.newHashMap(publisherVersions));
    }

    /**
     * Getter method for property <tt>dataInfoId</tt>.
     * @return property value of dataInfoId
     */
    public String getDataInfoId() {
        return dataInfoId;
    }

    /**
     * Getter method for property <tt>publisherVersions</tt>.
     * @return property value of publisherVersions
     */
    public Map<String, PublisherVersion> getPublisherVersions() {
        return publisherVersions;
    }

    public void addPublisherVersion(String registerId, PublisherVersion version) {
        publisherVersions.put(registerId, version);
    }

    public Map<String, PublisherVersion> getPublisherVersions(Collection<String> registerIds) {
        Map<String, PublisherVersion> m = new HashMap<>(registerIds.size());
        registerIds.forEach(k -> {
                    PublisherVersion v = publisherVersions.get(k);
                    if (v == null) {
                        throw new IllegalArgumentException("not contains registerId:" + k);
                    }
                    m.put(k, v);
                }
        );
        return m;
    }

    public boolean isEmpty(){
        return publisherVersions.isEmpty();
    }

    public int size(){
        return publisherVersions.size();
    }

    @Override
    public String toString() {
        return String.format("Summary={%s=%d}", dataInfoId, size());
    }

}
