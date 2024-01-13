package aj.micro.employeeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Message Controller",
        description = "Message Controller Exposes REST APIs for Department-Service"
)
@RestController
@RefreshScope //without restart the service change the configuration file from git
public class MessageController {

    @Value(value = "${spring.boot.message}")
    private String message;

    @Operation(
            summary = "Get the message from properties file",
            method = "message()",
            description = "to get message details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/message")
    public String message(){
        return this.message;
    }
}
