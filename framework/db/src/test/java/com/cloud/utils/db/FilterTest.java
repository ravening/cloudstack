// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// the License.  You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.utils.db;

import org.junit.Assert;
import org.junit.Test;

public class FilterTest {

    @Test
    /*
    *  This test verifies that the Order By clause generated by the filter is correct and it separates each
    *  order by field with a comma. Using DbTestVO to assert it
    */
    public void testAddOrderBy() {
        Filter filter = new Filter(DbTestVO.class, "fieldString", true, 1L, 1L);

        Assert.assertTrue(filter.getOrderBy().trim().toLowerCase().equals("order by test.fld_string asc"));

        filter.addOrderBy(DbTestVO.class, "fieldLong", true);

        Assert.assertTrue(filter.getOrderBy().contains(","));
        Assert.assertTrue(filter.getOrderBy().split(",")[1].trim().toLowerCase().equals("test.fld_long asc"));

        filter.addOrderBy(DbTestVO.class, "fieldInt", true);

        Assert.assertTrue(filter.getOrderBy().split(",").length == 3);
        Assert.assertTrue(filter.getOrderBy().split(",")[2].trim().toLowerCase().equals("test.fld_int asc"));
    }
}
