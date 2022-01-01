package editor.entity;


/**
 * Copyright 2021 Blockly Service @ https://github.com/orion-services/blockly
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@SequenceGenerator(name="status_seq", sequenceName = "status_seq",initialValue = 1, allocationSize = 1)
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public StatusEnum statusEnum = StatusEnum.INACTIVE;

    public enum StatusEnum {
        ACTIVE,
        INACTIVE,
        BLOCKED
    };


    public StatusEnum getStatusEnum() {
        return this.statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ugroup_id",referencedColumnName = "id")
    @JsonBackReference
    public Group ugroup;

    @ManyToMany(mappedBy="statuses", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnoreProperties("statuses")
    private List<User> users= new ArrayList<>();


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate")
    private java.util.Calendar createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedDate")
    private java.util.Calendar modifiedDate;


    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Calendar getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public java.util.Calendar getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(java.util.Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    public Group getUgroup() {
        return this.ugroup;
    }

    public void setUgroup(Group ugroup) {
        this.ugroup = ugroup;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUsers(User user) {
        this.users.add(user);
        user.getStatuses().add(this);
    }



    public Status(Long id, StatusEnum statusEnum, Group ugroup, List<User> users, java.util.Calendar createdDate, java.util.Calendar modifiedDate) {
        this.id = id;
        this.statusEnum = statusEnum;
        this.ugroup = ugroup;
        this.users = users;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Status() {
    }


}