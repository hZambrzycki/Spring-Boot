package com.zeta.cruddemo.dao;

import com.zeta.cruddemo.entity.Student;
import org.hibernate.type.internal.ImmutableNamedBasicTypeImpl;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
