package com.herp.service.skeletonjava;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DoController {
    
   
    @PostMapping("/do")
    public ProvidedOutput runService(@RequestBody ProvidedInput in) {
	return process(in);
	}
    // Alternative Implementation without special Input class, but HashMap
    //@PostMapping("/do")
    // public ProvidedOutput runService(@RequestBody HashMap<String, String> inputs) {
    //	String result = inputs.get("inputField1").concat(inputs.get("inputField2"));
    //	return new ProvidedOutput(result);
    //	}

    private ProvidedOutput process(ProvidedInput in){
	String result = in.getInputField1().concat(in.getInputField2());
	return new ProvidedOutput(result);
    }
}
