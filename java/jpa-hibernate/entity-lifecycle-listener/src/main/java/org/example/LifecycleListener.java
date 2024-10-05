package org.example;

import jakarta.persistence.*;


public class LifecycleListener {
    @PrePersist
    public void prePersist(Object entity) {
        System.out.println(".LifecycleListener Entity prePersist(): " + entity);
    }
    @PostPersist
    public void postPersist(Object entity) {
        System.out.println(".LifecycleListener Entity postPersist(): " + entity);
    }
    @PreUpdate
    public void preUpdate(Object entity) {
        System.out.println(".LifecycleListener Entity preUpdate(): " + entity);
    }
    @PostUpdate
    public void postUpdate(Object entity) {
        System.out.println(".LifecycleListener Entity postUpdate(): " + entity);
    }
    @PreRemove
    public void preRemove(Object entity) {
        System.out.println(".LifecycleListener Entity preRemove(): " + entity);
    }
    @PostRemove
    public void postRemove(Object entity) {
        System.out.println(".LifecycleListener Entity postRemove(): " + entity);
    }
    @PostLoad
    public void postLoad(Object entity) {
        System.out.println(".LifecycleListener Entity postLoad(): " + entity);
    }
}
