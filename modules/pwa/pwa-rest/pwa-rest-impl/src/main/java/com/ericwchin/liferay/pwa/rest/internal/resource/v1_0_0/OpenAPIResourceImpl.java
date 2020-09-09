package com.ericwchin.liferay.pwa.rest.internal.resource.v1_0_0;

import com.ericwchin.liferay.pwa.service.BrowserSubscriptionLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.vulcan.resource.OpenAPIResource;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/**
 * @author Eric Chin
 * @generated
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0_0/openapi.properties",
	service = OpenAPIResourceImpl.class
)
@Generated("")
@OpenAPIDefinition(
	info = @Info(description = "PWA REST API", license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html"), title = "PWA", version = "1.0.0")
)
@Path("/1.0.0")
public class OpenAPIResourceImpl {

	@GET
	@Path("/openapi.{type:json|yaml}")
	@Produces({MediaType.APPLICATION_JSON, "application/yaml"})
	public Response getOpenAPI(@PathParam("type") String type)
		throws Exception {

		try {
			Class<? extends OpenAPIResource> clazz =
				_openAPIResource.getClass();

			clazz.getMethod(
				"getOpenAPI", Set.class, String.class, UriInfo.class);
		}
		catch (NoSuchMethodException noSuchMethodException) {
			return _openAPIResource.getOpenAPI(_resourceClasses, type);
		}

		return _openAPIResource.getOpenAPI(_resourceClasses, type, _uriInfo);
	}

	@POST
	@Path("/subscribe")
	@Produces(MediaType.TEXT_PLAIN)
	public Response subscribe(
		@Context HttpServletRequest request, String data) {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				request);

			JSONObject dataObj = JSONFactoryUtil.createJSONObject(data);
			JSONObject subscriptionObj = dataObj.getJSONObject("data");

			_browserSubscriptionLocalService.addSubscription(
				subscriptionObj.getString("auth"),
				subscriptionObj.getString("key"),
				subscriptionObj.getString("endpoint"), serviceContext);
		}
		catch (PortalException pe) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		return Response.ok().build();
	}

	@Reference
	private BrowserSubscriptionLocalService _browserSubscriptionLocalService;

	@Reference
	private OpenAPIResource _openAPIResource;

	@Context
	private UriInfo _uriInfo;

	private final Set<Class<?>> _resourceClasses = new HashSet<Class<?>>() {
		{
			add(OpenAPIResourceImpl.class);
		}
	};

}