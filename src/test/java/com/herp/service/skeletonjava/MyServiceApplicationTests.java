package com.herp.service.skeletonjava;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class MyServiceApplicationTests {

    // @Autowired causes the controller to be injected before the test method runs
    @Autowired
    private InstallController installController;

    @Autowired
	private DoController doController;
    
    @Test
	void contextLoads() throws Exception{
	    assertThat(installController).isNotNull();
	    assertThat(installController).isNotNull();

	}

}
