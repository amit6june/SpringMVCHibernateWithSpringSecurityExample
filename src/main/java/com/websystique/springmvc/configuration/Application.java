package com.websystique.springmvc.configuration;

import com.braintreegateway.BraintreeGateway;


import java.io.File;


public class Application {
    public static String DEFAULT_CONFIG_FILENAME = "config.properties";
    public static BraintreeGateway gateway;

    public static void main(String[] args) {
        File configFile = new File(DEFAULT_CONFIG_FILENAME);
        try {
            if(configFile.exists() && !configFile.isDirectory()) {
                gateway = BraintreeGatewayFactory.fromConfigFile(configFile);
            } else {
                gateway = BraintreeGatewayFactory.fromConfigMapping(System.getenv());
            }
        } catch (NullPointerException e) {
            System.err.println("Could not load Braintree configuration from config file or system environment.");
            System.exit(1);
        }


    }
}
