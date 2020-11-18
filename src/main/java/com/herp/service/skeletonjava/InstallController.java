package com.herp.service.skeletonjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
@RestController
public class InstallController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.application.title}")
    private String label;

    private static final Field[] inputs = ProvidedInput.nodeDefinition();
    private static final Field[] outputs = ProvidedOutput.nodeDefinition();
    
    @GetMapping("/install")
    public NodeDefinition commitNodeDefinition() {
	return new NodeDefinition(name, label, inputs, outputs);
    }
}
