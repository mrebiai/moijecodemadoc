package com.mrebiai.moijecodemadoc.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mrebiai.moijecodemadoc.model.MyDoc;
import com.mrebiai.moijecodemadoc.service.AdocService;
import com.mrebiai.moijecodemadoc.service.PumlService;

/**
 * @author mrebiai
 */
@Path("/puml")
public class PumlEndpoint {

	@Inject
	private PumlService pumlService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(MyDoc entity) throws IOException {
		MyDoc result = pumlService.process(entity);
		return Response.ok(result).build();
	}
}
