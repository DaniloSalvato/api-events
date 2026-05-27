package ms_event_manager.api.modals;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ms_event_manager.api.client.AddressViaCepClient;
import ms_event_manager.api.records.DataEvent;

import java.time.LocalDateTime;


@Table(name="tb_events")
@Entity(name="Event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String eventName;

    @NotNull
    private LocalDateTime eventDate;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String street;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String status;

    public Event(DataEvent data, AddressViaCepClient address) {
        this.eventName = data.eventName();
        this.eventDate = data.eventDate();
        this.postalCode = address.cep();
        this.street = address.logradouro();
        this.district = address.bairro();
        this.city = address.localidade();
        this.state = address.uf();
        this.status = data.status();
    }

}
