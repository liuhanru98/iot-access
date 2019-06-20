package com.shenzhen.teamway.iotaccessproxy;

import com.shenzhen.teamway.iotaccessproxy.controller.IotAccessController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotAccessProxyApplication.class)
public class IotAccessProxyApplicationTests {

  @Autowired
  private IotAccessController iotAccessController;

  @Test
  public void contextLoads() {
    iotAccessController.getCountPersonOfChannel();
  }

}
