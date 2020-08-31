package com.ericwchin.liferay.pwa.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"before-filter=Header Filter",
		"dispatcher=REQUEST",
		"servlet-context-name=",
		"servlet-filter-name=PWA Header Filter",
		"url-pattern=/*"
	},
	service = Filter.class
)
public class PWAServletFilter extends BaseFilter {

	@Override
	protected void processFilter(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FilterChain filterChain)
		throws Exception {

		httpServletResponse.addHeader("Service-Worker-Allowed", "/");

		processFilter(
			PWAServletFilter.class.getName(), httpServletRequest,
			httpServletResponse, filterChain);
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PWAServletFilter.class);

}
