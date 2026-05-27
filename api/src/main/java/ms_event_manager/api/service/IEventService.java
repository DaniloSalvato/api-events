package ms_event_manager.api.service;

import ms_event_manager.api.modals.Event;
import ms_event_manager.api.records.DataEvent;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEventService{
    Event CreateEvent(DataEvent data);
    Event getEvent(Long id);
    List<Event> getEvents();
    List<Event> getSortEvents();
    Event updateEvent(Long id, Event dataEventUpdate);
    String deleteEvent(Long id);
}
