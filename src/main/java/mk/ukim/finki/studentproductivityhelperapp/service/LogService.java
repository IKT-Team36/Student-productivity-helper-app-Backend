package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.Log;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.LogDto;

import java.util.List;
import java.util.Optional;

public interface LogService {

    List<Log> findAll();
    Optional<Log> findById(Long id);
    Optional<Log> save(LogDto logDto);
    Optional<Log> edit(Long id, LogDto logDto);
    void delete(Long id);
}
