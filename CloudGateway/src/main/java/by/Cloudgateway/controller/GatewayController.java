package by.Cloudgateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

        @RequestMapping("/fallback")
        public ResponseEntity<String> greeting(String message) {
            return ResponseEntity.ok("Ups. Fallback " + message);
        }
        @GetMapping
        public String getMessage(){
            return "Hello";
        }
}