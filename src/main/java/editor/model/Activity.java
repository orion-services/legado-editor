package editor.model;


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


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@SequenceGenerator(name="activity_seq", sequenceName = "activity_seq",initialValue = 1, allocationSize = 1)
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ugroup_id",referencedColumnName = "id")
    @JsonIgnore
    public Group ugroup;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonIgnore
    public User user;

    public enum StatusType {
        WRITTERS_CIRCLE
    };

    public StatusType statusType = StatusType.WRITTERS_CIRCLE;


    public StatusType getStatusType() {
        return this.statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    @OneToMany(
        mappedBy = "activity", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER, 
        orphanRemoval = true)
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    public Set<Code> codes = new HashSet<>();


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate")
    private java.util.Calendar createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedDate")
    private java.util.Calendar modifiedDate;




    public Activity() {
    }


    public Set<Code> getCodes() {
        return this.codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getUgroup() {
        return this.ugroup;
    }

    public void setUgroup(Group ugroup) {
        this.ugroup = ugroup;
    }


    public Activity(Long id, Group ugroup) {
        this.id = id;
        this.ugroup = ugroup;
    }


    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addCode(Code code){
        codes.add(code);
    code.setActivity(this);
}


    public Set<Code> getCode() {
        return this.codes;
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


    public Activity(Long id, Group ugroup, User user, StatusType statusType, Set<Code> codes, java.util.Calendar createdDate, java.util.Calendar modifiedDate) {
        this.id = id;
        this.ugroup = ugroup;
        this.user = user;
        this.statusType = statusType;
        this.codes = codes;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }




}