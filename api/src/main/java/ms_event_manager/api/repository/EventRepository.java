package ms_event_manager.api.repository;

import ms_event_manager.api.modals.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
