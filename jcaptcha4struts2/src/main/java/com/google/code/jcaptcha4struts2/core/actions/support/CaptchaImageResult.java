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
package com.google.code.jcaptcha4struts2.core.actions.support;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.google.code.jcaptcha4struts2.core.actions.JCaptchaImageAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

/**
 * Struts2 Result Type for JCaptcha Image.
 * 
 * @author Yohan Liyanage
 * @since 1.0
 * @version 2.0
 */
public class CaptchaImageResult implements Result {

    private static final Log LOG = LogFactory.getLog(CaptchaImageResult.class);
    private static final long serialVersionUID = -595342817673304030L;

    /**
     * Action Execution Result. This will write the image bytes to response stream.
     * 
     * @param invocation
     *            ActionInvocation
     * @throws IOException
     *             if an IOException occurs while writing the image to output stream.
     * @throws IllegalArgumentException
     *             if the action invocation was done by an action which is not the
     *             {@link JCaptchaImageAction}.
     */
    public void execute(ActionInvocation invocation) throws IOException, IllegalArgumentException {

        // Check if the invoked action was JCaptchaImageAction
        if (!(invocation.getAction() instanceof JCaptchaImageAction)) {
            throw new IllegalArgumentException(
                    "CaptchaImageResult expects JCaptchaImageAction as Action Invocation");
        }

        JCaptchaImageAction action = (JCaptchaImageAction) invocation.getAction();
        HttpServletResponse response = ServletActionContext.getResponse();

        // Read captcha image bytes
        byte[] image = action.getCaptchaImage();

        // Send response
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        response.setContentLength(image.length);
        try {
            response.getOutputStream().write(image);
            response.getOutputStream().flush();
        } catch (IOException e) {
            LOG.error("IOException while writing image response for action : " + e.getMessage(), e);
            throw e;
        }
    }

}
