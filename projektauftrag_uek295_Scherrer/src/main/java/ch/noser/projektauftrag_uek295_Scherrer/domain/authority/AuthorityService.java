package ch.noser.projektauftrag_uek295_Scherrer.domain.authority;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AuthorityService {
    private AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository){
        this.authorityRepository = authorityRepository;
    }
}