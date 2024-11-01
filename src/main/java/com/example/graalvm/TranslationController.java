package com.example.graalvm;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {
    
    private final TranslationService service;
    
    public TranslationController(TranslationService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<Translation> getAllTranslations() {
        return service.getAllTranslations();
    }
    
    @GetMapping("/{id}")
    public Translation getTranslationById(@PathVariable Long id) {
        return service.getTranslationById(id)
            .orElseThrow(() -> new RuntimeException("Translation not found with id " + id));
    }
    
    @PostMapping
    public Translation createTranslation(@RequestBody Translation translation) {
        return service.saveTranslation(translation);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTranslation(@PathVariable Long id) {
        service.deleteTranslation(id);
    }
}