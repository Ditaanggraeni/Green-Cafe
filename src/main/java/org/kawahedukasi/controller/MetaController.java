package org.kawahedukasi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.kawahedukasi.constant.Gender;
import org.kawahedukasi.constant.ItemCategory;
import org.kawahedukasi.model.JobPosition;
import org.kawahedukasi.model.LastEducation;
import org.kawahedukasi.model.PaymentType;
import org.kawahedukasi.service.MetaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@Path("/api/meta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MetaController {
    @Inject
    MetaService metaService;

    @GET
    @Path("/jobPosition")
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = JobPosition.class)))
    })
    public Response jobPosition(){
        return metaService.jobPosition();
    }

    @GET
    @Path("/lastEducation")
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = LastEducation.class)))
    })
    public Response lastEducation(){
        return metaService.lasEducation();
    }

    @GET
    @Path("/paymentType")
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = PaymentType.class)))
    })
    public Response paymentType(){
        return metaService.paymentType();
    }

    @GET
    @Path("/gender")
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Gender.class)))
    })
    public Response gender(){
        return metaService.gender();
    }

    @GET
    @Path("/itemCategory")
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ItemCategory.class)))
    })
    public Response itemCategory(){
        return metaService.itemCategory();
    }

    @GET
    @Path("/bank")
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = List.class)))
    })
    public Response bank() throws FileNotFoundException, JsonProcessingException {
        return metaService.bank();
    }

    @GET
    @Path("/bank/{code}")
    @APIResponses({
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Map.class)))
    })
    public Response detailBank(@PathParam("code") String code) throws FileNotFoundException, JsonProcessingException {
        return metaService.detailBank(code);
    }
}
