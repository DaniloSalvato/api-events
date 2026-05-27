package ms_event_manager.api.service;

import ms_event_manager.api.client.CheckTicket;
import ms_event_manager.api.client.IAddressViaCepClient;

import ms_event_manager.api.client.ITicketClient;
import ms_event_manager.api.modals.Event;
import ms_event_manager.api.records.DataEvent;
import ms_event_manager.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private IAddressViaCepClient iAddress;

    @Autowired
    private ITicketClient iTicketClient;

    public Event CreateEvent(DataEvent data){
        var newData = new Event(data, iAddress.getAddressViaCepClient(data.postalCode()));
        repository.save(newData);
        return newData;
    }

    public Event getEvent(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public List<Event> getEvents(){
        return repository.findAll();
    }

    public List<Event> getSortEvents(){
        return repository.findAll(Sort.by("id").ascending());
    }

    public Event updateEvent(Long id, Event dataEventUpdate){
        Event event = repository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));

        event.setEventName(dataEventUpdate.getEventName());
        event.setEventDate(dataEventUpdate.getEventDate());
        event.setPostalCode(dataEventUpdate.getPostalCode());
        event.setStreet(dataEventUpdate.getStreet());
        event.setDistrict(dataEventUpdate.getDistrict());
        event.setCity(dataEventUpdate.getCity());
        event.setState(dataEventUpdate.getState());

        return repository.save(event);
    }

    public String deleteEvent(Long id){
        Event event = repository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        CheckTicket ticket = iTicketClient.getTicketByEventId(id);

        if (ticket.hasTickets()) {
            return "Event cannot be delete, ticket have been created";
        }

        event.setStatus("Canceled");
        repository.save(event);

        return "Success";
    }
}