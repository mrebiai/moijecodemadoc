package com.mrebiai.moijecodemadoc.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mrebiai.moijecodemadoc.model.MaDoc;
import com.mrebiai.moijecodemadoc.service.AdocService;

/**
 * @author mrebiai
 */
@Path("/adoc")
public class AdocEndpoint {

	@Inject
	private AdocService adocService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(MaDoc entity) throws IOException {
		MaDoc result = adocService.process(entity);
		return Response.ok(result).build();
	}
}
