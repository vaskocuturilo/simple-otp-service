package site.testengineer.otp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.testengineer.otp.model.OneTimePassword;
import site.testengineer.otp.service.OneTimePasswordService;

@RestController
@RequestMapping(path = {"/api/v1/otp/"}, produces = {"application/json"})
public class OneTimePasswordController {

    private static final Logger logger = LoggerFactory.getLogger(OneTimePasswordController.class);

    private OneTimePasswordService oneTimePAsswordService;

    @Autowired
    public OneTimePasswordController(OneTimePasswordService oneTimePAsswordService) {
        this.oneTimePAsswordService = oneTimePAsswordService;
    }

    @Operation(summary = "Create a new one time password")
    @ApiResponse(responseCode = "200", description = "One time password is created",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = OneTimePassword.class))})
    @GetMapping("/create")
    private Object getOneTimePassword() {
        try {
            return ResponseEntity.ok(oneTimePAsswordService.returnOneTimePassword());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}
