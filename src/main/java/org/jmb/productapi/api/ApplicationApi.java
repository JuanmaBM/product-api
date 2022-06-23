package org.jmb.productapi.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jmb.productapi.json.ApplicationDataDTO;

@Path("/app/env")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ApplicationApi {

    @GET
    ApplicationDataDTO getAppEnvData();
}
