package ms_event_manager.api.controller;


import jakarta.validation.Valid;
import ms_event_manager.api.modals.Event;
import ms_event_manager.api.records.DataEvent;
import ms_event_manager.api.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private IEventService iEventService;

    @Transactional
    @PostMapping("/create-event")
    public ResponseEntity<Event> CreateEvent(@RequestBody @Valid DataEvent data){
        var result = iEventService.CreateEvent(data);
        return  result != null ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
    }

    @GetMapping("/get-event/{id}")
    public ResponseEntity<Event> GetEventById(@Valid @PathVariable Long id){
        var result = iEventService.getEvent(id);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
    }

    @GetMapping("/get-all-events")
    public ResponseEntity<List<Event>> GetAllEvents(){
        var result = iEventService.getEvents();
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
    }

    @GetMapping("/get-all-events/sorted")
    public ResponseEntity<List<Event>> GetAllSortEvents(){
        var result = iEventService.getSortEvents();
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/update-event/{id}")
    public ResponseEntity<Event> GetAllEventsSorted(@Valid @PathVariable Long id, @RequestBody Event dataEventUpdate){
        var result = iEventService.updateEvent(id, dataEventUpdate);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("/delete-event/{id}")
    public ResponseEntity<String> DeleteEvent(@Valid @PathVariable Long id){
        var result = iEventService.deleteEvent(id);
        return result.equals("Success") ? ResponseEntity.ok(result) : ResponseEntity.noContent().build();
    }
}
