package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.view.AddressView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final IAddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(AddressView.AddressDetail.class)
    public Address createAddress(@Valid @RequestBody AddressDTO dto){
        return addressService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(AddressView.AddressDetail.class)
    public Address updateAddress(@PathVariable String id,@Valid @RequestBody AddressDTO dto){
        return addressService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAddress(@PathVariable String id){
        return addressService.delete(id);
    }
}
