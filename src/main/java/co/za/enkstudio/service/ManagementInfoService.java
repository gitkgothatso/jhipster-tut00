package co.za.enkstudio.service;

import co.za.enkstudio.config.JHipsterProperties;
import co.za.enkstudio.service.dto.ManagementInfoDTO;
import io.quarkus.runtime.configuration.ProfileManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * Provides information for management/info resource
 */
@ApplicationScoped
public class ManagementInfoService {

    private final JHipsterProperties jHipsterProperties;

    @Inject
    public ManagementInfoService(JHipsterProperties jHipsterProperties) {
        this.jHipsterProperties = jHipsterProperties;
    }

    public ManagementInfoDTO getManagementInfo() {
        var info = new ManagementInfoDTO();
        if (jHipsterProperties.info().swagger().enable()) {
            info.activeProfiles.add("swagger");
        }
        info.activeProfiles.add(ProfileManager.getActiveProfile());
        info.displayRibbonOnProfiles = ProfileManager.getActiveProfile();
        return info;
    }
}
