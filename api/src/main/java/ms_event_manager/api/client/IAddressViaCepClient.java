package ms_event_manager.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "ViaCep")
public interface IAddressViaCepClient {

    @GetMapping("{postalCode}/json/")
    AddressViaCepClient getAddressViaCepClient(@PathVariable String postalCode);
}
