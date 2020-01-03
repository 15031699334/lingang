package com.boot.gang.service;

public interface CommonService {

    Object findObjectById(String id, String entity);

    void save(Object object, String entity) throws Exception;

    void update(Object object, String entity) throws Exception;

}
