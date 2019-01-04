package com.adc.da.gateway.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 授权模块降级回调
 *

 */
@Component
public class ADCAuthFallbackProvider implements FallbackProvider {
    private static final String SERVICE_NAME = "soraka-auth";
    private static final String SERVICE_DISABLE = "服务不可用";

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new ADCFallbackResponse(cause, SERVICE_NAME, SERVICE_DISABLE);
    }

    @Override
    public String getRoute() {
        return SERVICE_NAME;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return fallbackResponse(null);
    }
}
