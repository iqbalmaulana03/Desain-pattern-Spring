package com.repo.pattrenrepo.repository;

import com.repo.pattrenrepo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository <T>{

    public void user(T t);

    public T retrieve(int id);

    public T search(String name);

    public T delete(int id);

}
