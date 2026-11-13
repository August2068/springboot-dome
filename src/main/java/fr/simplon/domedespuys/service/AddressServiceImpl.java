package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private AddressRepository addressRepository;
    private IUserService userService;

    @Override
    public Address create(AddressDTO dto) {
        Address address = new Address();
        address.setUser(userService.getById("1"));
        dtoToObject(dto, address);
        return address;
    }

    @Override
    public boolean delete(String id) {
        try{
            addressRepository.deleteById(Long.parseLong(id));
            return true;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        Address address = addressRepository.findById(Long.parseLong(id)).orElse(null);
        if(address != null){
            dtoToObject(dto, address);
        }
        return address;
    }

    private void dtoToObject(AddressDTO dto, Address address){
        address.setLine(dto.line);
        address.setExtraLine(dto.extraLine);
        address.setZipCode(dto.zipCode);
        address.setCity(dto.city);
        address.setCountry(dto.country);
        address.setPhone(dto.phone);
        address.setFirstname(dto.firstName);
        address.setLastname(dto.lastName);
        addressRepository.saveAndFlush(address);
    }

    @Override
    public Address getById(String id) {
        return addressRepository.findById(Long.parseLong(id)).orElse(null);
    }
}
