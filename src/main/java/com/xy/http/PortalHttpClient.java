package com.xy.http;

import com.xy.config.PortalHttpRequest;

public interface PortalHttpClient {

    <T> T execute(PortalHttpRequest portalHttpRequest, Class<T> cla);
}
