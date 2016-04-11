package pl.knobel.test.springboot.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.knobel.test.springboot.apimodel.Auto;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/autos")
public class AutoController {

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<Auto> getAuto(
      @RequestParam(value = "name", required = false, defaultValue = "Audi") String name) {

    Auto auto = new Auto(name, "TDI");
    auto.add(linkTo(methodOn(AutoController.class).getAuto(name)).withSelfRel());

    return new ResponseEntity<Auto>(auto, HttpStatus.OK);
  }

}