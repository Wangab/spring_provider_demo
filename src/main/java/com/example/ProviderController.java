package com.example;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by wanganbang on 6/28/16.
 */

@RestController
public class ProviderController {
    private final Logger logger = Logger.getLogger(ProviderController.class);

    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody Integer add(@RequestParam(value = "A") Integer a, @RequestParam(value = "B") Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info(instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getServiceId());
        return a + b;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody String info(){
        ServiceInstance instance = client.getLocalServiceInstance();
        return instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getServiceId();
    }
}
