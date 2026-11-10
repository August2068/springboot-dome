package fr.simplon.domedespuys.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICollectionPage <T>{
    Page<T> getCollectionPage(Pageable pageable);
}
