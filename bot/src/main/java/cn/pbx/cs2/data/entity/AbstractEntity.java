package cn.pbx.cs2.data.entity;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

/**
 * @author BruceXu
 */
@MappedSuperclass
public abstract class AbstractEntity<Entity> implements Serializable {


}
