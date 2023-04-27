package ru.yapridu.aptbooking.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Den
 */

@RestController
@RequestMapping("/api/v1/version")
@RequiredArgsConstructor
@Tag(name = "App version")
@PropertySource("classpath:application.yml")
public class AppVersionController {
    @Autowired
    private Environment env;

    @Operation(description = "Get application version.")
    @ApiResponse(responseCode = "200", description = "Version of application was found")
    @GetMapping()
    public ResponseEntity<String> getVersion() {
        return new ResponseEntity<>(env.getProperty("aptbooking.version"), HttpStatus.OK);
    }
}