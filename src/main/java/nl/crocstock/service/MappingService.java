package nl.crocstock.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nl.crocstock.model.IncomingRequest;
import nl.crocstock.model.Mapping;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MappingService {
    @Getter
    final Set<Mapping> mappings;

    public boolean saveMapping(Mapping mapping) {
        this.mappings.add(mapping);
        return true;
    }

    public Mapping getMapping(IncomingRequest incomingRequest) {
        for (var mapping : this.mappings) {
            if (mapping.getRequest().equals(incomingRequest)) {
                return mapping;
            }
        }
        return null;
    }

    public boolean reset() {
        this.mappings.clear();
        return true;
    }

    public boolean remove(Mapping mapping) {
        this.mappings.remove(mapping);
        return true;
    }
}
