package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.service.interfaces.IImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final IImageService imageService;

    @DeleteMapping("/{id}")
    public boolean deleteImage(@PathVariable String id){ return imageService.delete(id);}
}
