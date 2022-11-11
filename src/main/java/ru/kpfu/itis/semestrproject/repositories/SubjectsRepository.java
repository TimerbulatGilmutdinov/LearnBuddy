package ru.kpfu.itis.semestrproject.repositories;

import ru.kpfu.itis.semestrproject.models.Subject;

public interface SubjectsRepository {
    Subject findById(Long id);
    Subject findByName(String name);
    boolean addSubject(Subject subject);
}
