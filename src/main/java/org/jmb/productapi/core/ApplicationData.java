package org.jmb.productapi.core;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "application")
public interface ApplicationData {
    String name();
    String version();
}
