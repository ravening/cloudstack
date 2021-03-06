/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cloudstack.engine.subsystem.api.storage;

import java.util.List;

import com.cloud.storage.DataStoreRole;

public interface TemplateDataFactory {
    TemplateInfo getTemplate(long templateId);

    TemplateInfo getTemplate(long templateId, DataStore store);

    TemplateInfo getReadyTemplateOnImageStore(long templateId, Long zoneId);

    TemplateInfo getTemplate(DataObject obj, DataStore store, String configuration);

    TemplateInfo getTemplate(long templateId, DataStoreRole storeRole);

    TemplateInfo getTemplate(long templateId, DataStoreRole storeRole, Long zoneId);

    TemplateInfo getReadyTemplateOnCache(long templateId);

    List<TemplateInfo> listTemplateOnCache(long templateId);

    TemplateInfo getReadyBypassedTemplateOnPrimaryStore(long templateId, Long poolId, Long hostId);

    TemplateInfo getReadyBypassedTemplateOnManagedStorage(long templateId, TemplateInfo templateOnPrimary, Long poolId, Long hostId);

    boolean isTemplateMarkedForDirectDownload(long templateId);

    TemplateInfo getTemplateOnPrimaryStorage(long templateId, DataStore store, String configuration);
}
