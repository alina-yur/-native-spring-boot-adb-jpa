package com.example.graalvm;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TranslationService {
    
    private final TranslationRepository repository;
    
    public TranslationService(TranslationRepository repository) {
        this.repository = repository;
    }
    
    public List<Translation> getAllTranslations() {
        return repository.findAll();
    }
    
    public Optional<Translation> getTranslationById(Long id) {
        return repository.findById(id);
    }
    
    public Translation saveTranslation(Translation translation) {
        return repository.save(translation);
    }
    
    public void deleteTranslation(Long id) {
        repository.deleteById(id);
    }
}