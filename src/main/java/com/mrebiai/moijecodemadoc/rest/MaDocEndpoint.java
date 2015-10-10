package com.mrebiai.moijecodemadoc.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * 
 */
@Path("/madocs")
public class MaDocEndpoint {

	@GET
	@Path("/test")
	@Produces("application/json")
	public String test() {
		return "Hello World!";
	}
	
//	@POST
//	@Consumes("application/json")
//	public Response create(MaDoc entity) {
//		em.persist(entity);
//		return Response.created(
//				UriBuilder.fromResource(MaDocEndpoint.class)
//						.path(String.valueOf(entity.getId())).build()).build();
//	}
//
//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") Long id) {
//		MaDoc entity = em.find(MaDoc.class, id);
//		if (entity == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		em.remove(entity);
//		return Response.noContent().build();
//	}
//
//	@GET
//	@Path("/{id:[0-9][0-9]*}")
//	@Produces("application/json")
//	public Response findById(@PathParam("id") Long id) {
//		TypedQuery<MaDoc> findByIdQuery = em
//				.createQuery(
//						"SELECT DISTINCT m FROM MaDoc m WHERE m.id = :entityId ORDER BY m.id",
//						MaDoc.class);
//		findByIdQuery.setParameter("entityId", id);
//		MaDoc entity;
//		try {
//			entity = findByIdQuery.getSingleResult();
//		} catch (NoResultException nre) {
//			entity = null;
//		}
//		if (entity == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.ok(entity).build();
//	}
//
//	@GET
//	@Produces("application/json")
//	public List<MaDoc> listAll(@QueryParam("start") Integer startPosition,
//			@QueryParam("max") Integer maxResult) {
//		TypedQuery<MaDoc> findAllQuery = em.createQuery(
//				"SELECT DISTINCT m FROM MaDoc m ORDER BY m.id", MaDoc.class);
//		if (startPosition != null) {
//			findAllQuery.setFirstResult(startPosition);
//		}
//		if (maxResult != null) {
//			findAllQuery.setMaxResults(maxResult);
//		}
//		final List<MaDoc> results = findAllQuery.getResultList();
//		return results;
//	}
//
//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	@Consumes("application/json")
//	public Response update(@PathParam("id") Long id, MaDoc entity) {
//		if (entity == null) {
//			return Response.status(Status.BAD_REQUEST).build();
//		}
//		if (id == null) {
//			return Response.status(Status.BAD_REQUEST).build();
//		}
//		if (!id.equals(entity.getId())) {
//			return Response.status(Status.CONFLICT).entity(entity).build();
//		}
//		if (em.find(MaDoc.class, id) == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		try {
//			entity = em.merge(entity);
//		} catch (OptimisticLockException e) {
//			return Response.status(Response.Status.CONFLICT)
//					.entity(e.getEntity()).build();
//		}
//
//		return Response.noContent().build();
//	}
}
