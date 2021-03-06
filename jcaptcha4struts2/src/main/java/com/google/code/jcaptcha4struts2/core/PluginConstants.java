/*
 * Copyright (C) 2008-2009 Yohan Liyanage. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.google.code.jcaptcha4struts2.core;


/**
 * JCaptcha4Struts2 Plugin Constants.
 * 
 * @author Yohan Liyanage
 * 
 * @since 2.0
 * @version 2.0
 */
public final class PluginConstants {

    /**
     * Disallow external instantiation.
     */
    private PluginConstants() {
        // No External Instantiation
    }
    
    /**
     * Default ImageCaptchaService implementation constant. Plugin will use an instance of this
     * class if a ImageCaptchaService implementation was not explicitly given.
     * <p>
     * It is possible to provide custom implementations using the {@code JC4S2Config} configuration
     * class. It exposes a property
     * <p>
     * Currently, the default implementation is {@code
     * com.octo.captcha.service.image.DefaultManageableImageCaptchaService}.
     * 
     */
    public static final String DEFAULT_IMG_CAPTCHA_IMPL =
            "com.octo.captcha.service.image.DefaultManageableImageCaptchaService";
    
    /**
     * HTTP Request Parameter Name for JCaptchaResponse message.
     * <p>
     * This is the request parameter name that should be used to send the jcaptcha response
     * for automatic validation process.
     */
    public static final String J_CAPTCHA_RESPONSE = "jCaptchaResponse";
}
