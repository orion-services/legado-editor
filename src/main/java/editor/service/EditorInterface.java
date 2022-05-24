package editor.service;


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


import java.util.List;

import javax.ws.rs.FormParam;


import editor.model.Activity;
import editor.model.Group;
import editor.model.Status;
import editor.model.User;


public interface EditorInterface {

    /**
     * Creates a User in the blocks editor service.
     * 
     * @param discriminator : The Discord discriminator 
     * @return The blocks editor User object
     */

    public User createUser(@FormParam("alias") String alias, @FormParam("discriminator") String discriminator);

    /**
     * Creates a group in the blocks editor service.
     * 
     * @param alias : An unique name of the group
     * @return The blocks editor Group object 
     */

    public Group createGroup(@FormParam("alias") String alias, @FormParam("discriminator") String discriminator);

    /**
     * Allow one user join in a group
     * 
     * @param alias : An unique name of the group
     * @param discriminator : The Discord discriminator 
     * @return
     */

    public Group joinGroup(@FormParam("alias") String alias, @FormParam("discriminator") String discriminator);

    /**
     * Creates an activity to the group
     * 
     * @param alias : An unique name of the group
     * @return The blocks editor Activity object 
     */

    public Activity createActivity(@FormParam("alias") String alias);

    /**
     * Returns the current locks editor Activity object of a group
     * 
     * @param alias : An unique name of the group
     * @return The blocks editor Activity object 
     */

    public Status checkStatus(@FormParam("alias") String alias);

    /**
     * Asks to participates in a group activity
     * 
     * @param alias : An unique name of the group
     * @return Return a URL to participates of a activity 
     */

    public String participates(@FormParam("alias") String alias,@FormParam("discriminator") String discriminator);

    /**
     * Lists all current activities of an user
     * 
     * @param discriminator : The Discord discriminator 
     * @return Return a list of current activity of a user in all groups
     */

    public List<Activity> listActivities(@FormParam("discriminator") String discriminator);
    
}

