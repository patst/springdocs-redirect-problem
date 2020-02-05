package de.patst.swaggerlogin.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Tag(name = "Hello Service")
public class HelloController {

  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "Success",
              content = @Content(schema = @Schema(implementation = String.class))),
          @ApiResponse(responseCode = "400", description = "not found.")
      }
  )
  @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  @Operation(description = "Does something useful.",
          security = {@SecurityRequirement(name = "oauth2")})
  @Secured({})
  public String getSomeObject() {
    return "hello world";
  }



}
