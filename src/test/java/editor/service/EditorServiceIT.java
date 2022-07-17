/**
 * @License
 * Copyright 2022 Orion Services @ https://github.com/orion-services
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

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
class EditorServiceIT {

  @Test
  @Order(1)
  @DisplayName("Create a new user")
  void createUser1() {
    given()
        .when()
        .formParam("name", "Guilherme")
        .formParam("hashUser", "#1")
        .post("/editor/api/v1/createUser")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(2)
  @DisplayName("Create a new group")
  void createGroup() {
    given()
        .when()
        .formParam("namegroup", "g1")
        .formParam("hashUser", "#1")
        .post("/editor/api/v1/createGroup")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(3)
  @DisplayName("Create a new activity")
  void createActivity() {
    given()
        .when()
        .formParam("namegroup", "g1")
        .post("/editor/api/v1/createActivity")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(4)
  @DisplayName("Participate in an activity")
  void participates1() {
    given()
        .when()
        .formParam("hashUser", "#1")
        .formParam("namegroup", "g1")
        .put("/editor/api/v1/participates")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(5)
  @DisplayName("Create a new user")
  void createUser2() {
    given()
        .when()
        .formParam("name", "Moreira")
        .formParam("hashUser", "#2")
        .post("/editor/api/v1/createUser")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(6)
  @DisplayName("Join a group")
  void joinGroup() {
    given()
        .when()
        .formParam("hashUser", "#2")
        .formParam("namegroup", "g1")
        .put("/editor/api/v1/joingroup")
        .then()
        .statusCode(200);
  }

  @Test
  @Order(7)
  @DisplayName("Participate in an activity")
  void participates2() {
    given()
        .when()
        .formParam("hashUser", "#2")
        .formParam("namegroup", "g1")
        .put("/editor/api/v1/participates")
        .then()
        .statusCode(200);
  }

  //TODO refactor the test method
  @Test
  @Order(8)
  @DisplayName("Check a group status")
  void checkStatus() {
    given().formParam("namegroup", "g1")
            .when()
            .get("/editor/api/v1/checkStatus")
            .then()
            .statusCode(200);
  }

}
