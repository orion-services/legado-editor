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

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;




@Entity
@SequenceGenerator(name="user_seq", sequenceName = "user_seq",initialValue = 1, allocationSize = 1)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String hashUser;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinTable(name="user_ugroup",
               joinColumns={@JoinColumn(name="user_id", referencedColumnName = "id")},
               inverseJoinColumns={@JoinColumn(name="ugroup_id", referencedColumnName = "id")})
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnoreProperties("users")
    private List<Group> ugroups = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
    @JoinTable(name="user_status",
               joinColumns={@JoinColumn(name="user_id", referencedColumnName = "id")},
               inverseJoinColumns={@JoinColumn(name="status_id", referencedColumnName = "id")})
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnoreProperties("users")
    private List<Status> statuses = new ArrayList<>();


    @OneToMany(
        mappedBy = "user", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER, 
        orphanRemoval = true)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    public Set<Activity> activities = new HashSet<>();



    @OneToMany(
        mappedBy = "user", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER, 
        orphanRemoval = true)    
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    public Set<Code> codes = new HashSet<>();





    public String generateHash() {
        SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[6];
            random.nextBytes(bytes);
            Encoder encoder = Base64.getUrlEncoder().withoutPadding();
            String hash = encoder.encodeToString(bytes);
        return hash;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Code> getCodes() {
        return this.codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }



    public String getHashUser() {
        return this.hashUser;
    }

    public String setHashUser(String hashUser) {
       return this.hashUser = hashUser;
    }

    public User(String name) {
        super();
        this.name = name;
    }

    public User() {
        super();
    }


    public Set<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    activity.setUser(this);
}

    public void addCode(Code code){
        codes.add(code);
    code.setUser(this);
    }


    public List<Group> getUgroups() {
        return this.ugroups;
    }

    public void setUgroups(List<Group> ugroups) {
        this.ugroups = ugroups;
    }


    public void addUgroup(Group ugroup) {
        this.ugroups.add(ugroup);
        ugroup.getUsers().add(this);
    }

    public void addStatuses(Status status) {
        this.statuses.add(status);
        status.getUsers().add(this);
    }



    public List<Status> getStatuses() {
        return this.statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }





   
}