package ms_event_manager.api.config;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class JWTUserData {

    private Long id;
    private String email;
}