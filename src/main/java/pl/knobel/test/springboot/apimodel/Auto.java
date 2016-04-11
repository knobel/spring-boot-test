package pl.knobel.test.springboot.apimodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Auto extends ResourceSupport {
  private final long id;
  private String name;
  private String engine;

  @JsonCreator
  public Auto(
      @JsonProperty("name") String name,
      @JsonProperty("engine") String engine) {
    this.id = 1;
    this.name = name;
    this.engine = engine;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }
}