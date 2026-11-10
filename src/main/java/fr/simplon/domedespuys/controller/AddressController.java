package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.service.interfaces.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final IAddressService addressService;

}
