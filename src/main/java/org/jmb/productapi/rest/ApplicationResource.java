package org.jmb.productapi.rest;

import javax.inject.Inject;

import org.jmb.productapi.api.ApplicationApi;
import org.jmb.productapi.core.ApplicationData;
import org.jmb.productapi.json.ApplicationDataDTO;

public class ApplicationResource implements ApplicationApi {

    private final ApplicationData applicationData;

    @Inject
    public ApplicationResource(final ApplicationData applicationData) {
        this.applicationData = applicationData;
    }

    @Override
    public ApplicationDataDTO getAppEnvData() {
        return new ApplicationDataDTO(applicationData.name(), applicationData.version());
    }
    
}
