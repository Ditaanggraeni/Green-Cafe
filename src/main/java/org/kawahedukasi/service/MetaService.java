package org.kawahedukasi.service;

import org.kawahedukasi.constant.Gender;
import org.kawahedukasi.model.JobPosition;
import org.kawahedukasi.model.LastEducation;
import org.kawahedukasi.model.PaymentType;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.*;

@ApplicationScoped
public class MetaService {
    public Response jobPosition(){
        return Response.ok(JobPosition.findAll().list()).build();
    }

    public Response lasEducation(){
        return Response.ok(LastEducation.findAll().list()).build();
    }

    public Response paymentType(){
        return Response.ok(PaymentType.findAll().list()).build();
    }

    public Response gender(){
        List<Map<String, Object>> result = new ArrayList<>();
        for (Gender gender:Gender.values()){
            Map<String, Object> map = new HashMap<>();
            map.put("name", gender.getName());
            map.put("code", gender.getCode());
            result.add(map);
        }
        return Response.ok(result).build();
    }
}
