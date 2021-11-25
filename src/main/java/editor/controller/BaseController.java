package editor.controller;


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

import javax.inject.Inject;

import editor.data.*;

public class BaseController {

    @Inject
    protected UserDAO userDAO;

    @Inject
    protected CodeDAO codeDAO;

    @Inject
    protected GroupDAO groupDAO;

    @Inject
    protected StatusDAO statusDAO;

    @Inject
    protected ActivityDAO activityDAO;
}
