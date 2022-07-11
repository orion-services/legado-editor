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

import editor.model.Activity;
import editor.model.Code;
import editor.model.Group;
import editor.model.User;

import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static editor.service.BaseService.*;

/**
 * Service exception
 */
public class ServiceException extends WebApplicationException {

    public ServiceException(String message, Status status ) {
        super(init(message, status));
    }

    /**
     * A static method to init the message
     *
     * @param message : An error message
     * @param status : A HTTP error code
     *
     * @return A Response object
     */
    private static Response init(String message, Status status) {
        return Response
        .status(status)
        .entity(Map.of("message", message))
        .build();
    }

    public static void createUserException(String name, User hashCheck){

        if(name.isEmpty()) {
            throw new ServiceException(EMPTY_DATA, Response.Status.BAD_REQUEST);
        }
        if(hashCheck != null) {
            throw new ServiceException(USER_ALREADY, Response.Status.BAD_REQUEST);
        }
    }

    public static void createGroupException(Group groupCheck, User user) {
        if(groupCheck != null) {
            throw new ServiceException(GROUP_ALREADY, Response.Status.BAD_REQUEST);
        }
        if(user == null) {
            throw new ServiceException(USER_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
    }

    public static void joinGroupException(User user, Group group) {
        if(user==null) {
            throw new ServiceException(USER_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
        if(group==null) {
            throw new ServiceException(GROUP_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
    }

    public static void createActivityException(Group group) {
        if(group==null){
            throw new ServiceException(GROUP_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
    }

    public static void checkStatusException(Group group, editor.model.Status status) {
        if(group==null){
            throw new ServiceException(GROUP_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
        if(status==null){
            throw new ServiceException(EMPTY_DATA, Response.Status.BAD_REQUEST);
        }
    }
    public static void checkStatusException(Group group) {
        if(group==null){
            throw new ServiceException(GROUP_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
    }

    public static void participatesException(Group group, User user, Code checkUserCode, Activity activity, User userCheck) {
        if(group==null){
            throw new ServiceException(GROUP_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
        if(user==null){
            throw new ServiceException(USER_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
        if(checkUserCode!=null){
            throw new ServiceException(EMPTY_DATA, Response.Status.BAD_REQUEST);
        }
        if(activity==null){
            throw new ServiceException(ACTIVITY_NOT_EXIST, Response.Status.BAD_REQUEST);
        }
        if(userCheck==null){
            throw new ServiceException(EMPTY_DATA, Response.Status.BAD_REQUEST);
        }
    }

    public static void listActivitiesException(List<Activity> activity) {
        if(activity==null) {
            throw new ServiceException(EMPTY_DATA, Response.Status.BAD_REQUEST);
        }
    }
}

