package com.example.digitalproject.services.servicesImpl;
import com.example.digitalproject.mappers.DocumentMapper;
import com.example.digitalproject.models.dto.documents.*;
import com.example.digitalproject.repositories.DocumentRepository;
import com.example.digitalproject.services.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private DocumentRepository documentRepository;
    private DocumentMapper documentMapper;

    @Override
    public DocumentGetDTO getDocument(Long id) {
        return documentMapper.entityToGet(documentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND)));
    }

    @Override
    public void postDocument(DocumentPostDTO documentPostDTO) {
        documentRepository.save(documentMapper.postToEntity(documentPostDTO));
    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public void putDocument(DocumentPutDTO documentPutDTO) {
        documentRepository.save(documentMapper.putToEntity(documentPutDTO));
    }

    @Override
    public List<DocumentGetDTO> getAllDocuments() {
        return documentMapper.getAllDocuments(documentRepository.findAll());
    }
}