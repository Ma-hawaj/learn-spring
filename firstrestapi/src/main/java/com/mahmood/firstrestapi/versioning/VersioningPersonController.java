package com.mahmood.firstrestapi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonv1(){
        return new PersonV1("Mahmood Alhawaj");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonv2(){
        return new PersonV2(new Name("Mahmood", "Alhawaj"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getPersonParamsv1(){
        return new PersonV1("Mahmood Alhawaj");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonParamsv2(){
        return new PersonV2(new Name("Mahmood", "Alhawaj"));
    }

    @GetMapping(value = "/personHdr", headers = "X-API-VERSION=1")
    public PersonV1 getPersonHeadersv1(){
        return new PersonV1("Mahmood Alhawaj");
    }

    @GetMapping(value = "/personHdr", headers = "X-API-VERSION=2")
    public PersonV2 getPersonHeadersv2(){
        return new PersonV2(new Name("Mahmood", "Alhawaj"));
    }

    // for this we will use Accept header
    @GetMapping(value = "/personMedia", produces = "application/vnd.app-v1+json")
    public PersonV1 getPersonMediav1(){
        return new PersonV1("Mahmood Alhawaj");
    }

    @GetMapping(value = "/personMedia", produces = "application/vnd.app-v2+json")
    public PersonV2 getPersonMediav2(){
        return new PersonV2(new Name("Mahmood", "Alhawaj"));
    }
}
