/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.warehouse.security.cache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import local.example.warehouse.security.util.SecurityUtil;

public class CustomizedRequestCache 
		extends HttpSessionRequestCache {

	@Override
	public void saveRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		if (!SecurityUtil.isFrameworkInternalRequest(httpServletRequest)) {
			super.saveRequest(httpServletRequest, httpServletResponse);
		}
	}
}
