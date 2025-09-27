package model.repository;

import model.entity.Employee;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    boolean add(T t);
    boolean deleteById(String id);
    boolean isEditById(String id,T t);
}
