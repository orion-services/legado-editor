package editor.repository;


/**
 * Copyright 2021 Blockly Service @ https://github.com/orion-services/blockly
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

import editor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface UserJPARepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN u.ugroups g WHERE u.id = :user_id AND g.id = :ugroup_id")
    User findByUserAndGroup(@Param("user_id") Long user_id, @Param("ugroup_id") Long ugroup_id);
}