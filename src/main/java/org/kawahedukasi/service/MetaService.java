package org.kawahedukasi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.vertx.core.eventbus.Message;
import org.kawahedukasi.constant.Gender;
import org.kawahedukasi.constant.ItemCategory;
import org.kawahedukasi.exception.ValidationException;
import org.kawahedukasi.model.JobPosition;
import org.kawahedukasi.model.LastEducation;
import org.kawahedukasi.model.PaymentType;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class MetaService {
    ObjectMapper om = new ObjectMapper();
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

    public Response itemCategory(){
        List<Map<String, Object>> result = new ArrayList<>();
        for (ItemCategory itemCategory:ItemCategory.values()){
            Map<String, Object> map = new HashMap<>();
            map.put("name", itemCategory.getName());
            result.add(map);
        }
        return Response.ok(result).build();
    }

    public Response bank() throws FileNotFoundException, JsonProcessingException {
        return Response.ok(getBankFromResources()).build();
    }

    public List<Map<String, Object>> getBankFromResources() throws FileNotFoundException, JsonProcessingException {
        File file = new File("./src/main/resources/bank.json");
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()){
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return om.readValue(sb.toString(), List.class);
    }

    public Response detailBank(String code) throws FileNotFoundException, JsonProcessingException {
        List<Map<String, Object>> bankList = getBankFromResources()
                .stream().filter(s -> s.get("bank_code").toString().equals(code))
                .collect(Collectors.toList());
        if (code.isEmpty()){
            throw new ValidationException("INVALID_CODE");
        }
        return Response.ok(bankList.get(0)).build();
    }

    public Response province() throws UnirestException, JsonProcessingException {
        HttpResponse<String> httpResponse = Unirest.get("https://emsifa.github.io/api-wilayah-indonesia/api/provinces.json").asString();
        return Response.ok(om.readValue(httpResponse.getBody(), List.class)).build();
    }

    public Response city(String provinceId) throws UnirestException, JsonProcessingException {
        HttpResponse<String> httpResponse = Unirest.get(
                MessageFormat.format("https://emsifa.github.io/api-wilayah-indonesia/api/regencies/{0}.json", provinceId)
        ).asString();
        if (httpResponse.getStatus() != 200){
            throw new ValidationException("INVALID_PROVINCE_ID");
        }
        return Response.ok(om.readValue(httpResponse.getBody(), List.class)).build();
    }

    public Response district(String cityId) throws UnirestException, JsonProcessingException {
        HttpResponse<String> httpResponse = Unirest.get(
                MessageFormat.format("https://emsifa.github.io/api-wilayah-indonesia/api/districts/{0}.json", cityId)
        ).asString();
        if (httpResponse.getStatus() != 200){
            throw new ValidationException("INVALID_CITY_ID");
        }
        return Response.ok(om.readValue(httpResponse.getBody(), List.class)).build();
    }

    public Response village(String districtId) throws UnirestException, JsonProcessingException {
        HttpResponse<String> httpResponse = Unirest.get(
                MessageFormat.format("https://emsifa.github.io/api-wilayah-indonesia/api/villages/{0}.json", districtId)
        ).asString();
        if (httpResponse.getStatus() != 200){
            throw new ValidationException("INVALID_DISTRICT_ID");
        }
        return Response.ok(om.readValue(httpResponse.getBody(), List.class)).build();
    }
}
