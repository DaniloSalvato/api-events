package ms_event_manager.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9090/ticket/check-tickets-by-event/", name = "Tickets")
public interface ITicketClient {
    @GetMapping("{eventId}")
    CheckTicket getTicketByEventId(@PathVariable Long eventId);
}
