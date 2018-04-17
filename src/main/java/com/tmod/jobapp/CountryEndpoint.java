package com.tmod.jobapp;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by gulteking on 17.04.2018 with love.
 */
@Endpoint
public class CountryEndpoint {

    @Autowired
    private CountryRepository countryRepository;
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse findCountry(@RequestPayload GetCountryRequest countryRequest) {
        Country c = countryRepository.findCountry(countryRequest.getName());
        GetCountryResponse countryResponse = new GetCountryResponse();
        countryResponse.setCountry(c);
        return countryResponse;
    }

}
