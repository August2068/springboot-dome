package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.service.interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {
    @Override
    public boolean delete(String id) {
        return false;
    }
}
