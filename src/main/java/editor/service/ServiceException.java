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

import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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

}

