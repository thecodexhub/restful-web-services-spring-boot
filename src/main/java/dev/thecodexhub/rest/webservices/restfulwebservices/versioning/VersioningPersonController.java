package dev.thecodexhub.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

  @GetMapping("/v1/person")
  public PersonV1 getPersonV1() {
    return new PersonV1("John Doe");
  }

  @GetMapping("/v2/person")
  public PersonV2 getPersonV2() {
    return new PersonV2(new Name("John", "Doe"));
  }

  @GetMapping(path = "/person", params = "version=1")
  public PersonV1 getPersonV1ViaRequestParam() {
    return new PersonV1("John Doe");
  }

  @GetMapping(path = "/person", params = "version=2")
  public PersonV2 getPersonV2ViaRequestParam() {
    return new PersonV2(new Name("John", "Doe"));
  }

  @GetMapping(path = "/person", headers = "X-API-VERSION=1")
  public PersonV1 getPersonV1ViaRequestHeader() {
    return new PersonV1("John Doe");
  }

  @GetMapping(path = "/person", headers = "X-API-VERSION=2")
  public PersonV2 getPersonV2ViaRequestHeader() {
    return new PersonV2(new Name("John", "Doe"));
  }

  @GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
  public PersonV1 getPersonV1ViaAcceptHeader() {
    return new PersonV1("John Doe");
  }

  @GetMapping(path = "/person", produces = "application/vnd.company.app-v2+json")
  public PersonV2 getPersonV2ViaAcceptHeader() {
    return new PersonV2(new Name("John", "Doe"));
  }
}
