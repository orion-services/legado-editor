/**
 * Copyright 2021 Orion Bot @ https://github.com/orion-services/bot
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package editor.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import editor.model.User;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserControllerTest {


    @Test
    @DisplayName("Create User")
    void userCreateTrue() {
        User user = new User();
        user.setName("guilherme");
        user.setHashUser("Z3VpbGhlcm1l");
        assertEquals("guilherme", user.getName());
        assertEquals("Z3VpbGhlcm1l", user.getHashUser());

    }

    @Test
    @DisplayName("Create User Error")
    void userCreateError() {
        User user = new User();
        user.setName("guilherme");
        user.setHashUser("Z3VpbGhlcm1l");
        assertNotEquals("geralt", user.getName());
        assertNotEquals("o3xzghlcm1l", user.getHashUser());
        
    }

    @Test
    @DisplayName("Create User Empty")
    void userCreateEmpty() {
        User user = new User();
        user.setName("");
        user.setHashUser("");
        assertNotEquals("guilherme", user.getName());
        assertNotEquals("Z3VpbGhlcm1l", user.getHashUser());
    }

    @Test
    @DisplayName("Create User Null")
    void userCreateNull() {
        User user = new User();
        user.setName(null);
        user.setHashUser(null);
        assertNotEquals("guilherme", user.getName());
        assertNotEquals("Z3VpbGhlcm1l", user.getHashUser());
    }


}