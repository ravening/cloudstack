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
package org.apache.cloudstack.engine.cloud.entity.api;

import org.apache.cloudstack.engine.entity.api.CloudStackEntity;

import com.cloud.storage.Snapshot;

public interface SnapshotEntity extends CloudStackEntity, Snapshot {
    /**
     * Make a reservation for backing up this snapshot
     * @param expiration time in seconds to expire the reservation
     * @return reservation token
     */
    String reserveForBackup(int expiration);

    /**
     * Perform the backup according to the reservation token
     * @param reservationToken token returned by reserveForBackup
     */
    void backup(String reservationToken);

    /**
     * restore this snapshot to this vm.
     * @param vm
     */
    void restore(String vm);

    /**
     * Destroy this snapshot.
     */
    void destroy();
}
