package ms_event_manager.api.records;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DataEvent(
        @NotBlank(message = "Name cannot be blank")
        String eventName,
        @Future(message = "LocalDateTime must be future")
        LocalDateTime eventDate,
        @NotBlank(message = "PostalCode cannot be blank")
        String postalCode,
        @NotBlank(message = "PostalCode cannot be blank")
        String status){
}
