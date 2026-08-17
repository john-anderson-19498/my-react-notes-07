/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package bugs

import org.junit.jupiter.api.Test

final class Groovy11126 {

    private safeCall(String string) {
        string?.size()
    }

    private safeName(String string) {
        string?.chars
    }

    @Test
    void testSafeCall() {
        10000.times {
            safeCall('1')
            safeCall('')
        }
        safeCall(null)
        safeCall('22')
        safeCall(null)
    }

    @Test
    void testSafeName() {
        10000.times {
            safeName('1')
            safeName('')
        }
        safeName(null)
        safeName('22')
        safeName(null)
    }
}
