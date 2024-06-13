package hcmus.zingmp3.dataservice.config;

import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Value("${server.url}")
    private String gatewayUrl;

    @Bean
    public GroupedOpenApi streamingOpenApi(@Value("${springdoc.version}") String appVersion) {
        String[] paths = {
                "/api/sentiment-data/**",
                "/api/sentiment/**"
        };

        List<Server> servers = List.of(
                new Server().url("/").description("Playlist service server"),
                new Server().url(gatewayUrl).description("Production server")
        );
        return GroupedOpenApi.builder()
                .group("data-service")
                .addOpenApiCustomizer(openApi -> openApi
                        .servers(servers)
                        .info(new io.swagger.v3.oas.models.info.Info().title("Data service API").version(appVersion)))
                .pathsToMatch(paths)
                .build();
    }
}
