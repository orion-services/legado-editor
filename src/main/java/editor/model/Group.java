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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.metamodel.StaticMetamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Group.class)
@SequenceGenerator(name="_group_seq", sequenceName = "_group_seq",initialValue = 1, allocationSize = 1)
@Table(name = "_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy="_groups", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnoreProperties("_groups")
    private List<User> users= new ArrayList<>();

    @OneToMany(
        mappedBy = "_group",
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER, 
        orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    public List<Status> statuses = new ArrayList<>();


    @OneToMany(
        mappedBy = "_group",
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER, 
        orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    public List<Activity> activities = new ArrayList<>();

    private String name;

    public Group() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public List<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }


    public void addUser(User user) {
            this.users.add(user);
        user.get_groups().add(this);
    }

    public void addActivity(Activity activity){
            activities.add(activity);
        activity.set_group(this);
    }
    
    public void addStatus(Status status){
            statuses.add(status);
        status.set_group(this);
    }

    public List<Status> getStatuses() {
        return this.statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "{" +
            ", users='" + getUsers() + "'" +
            ", statuses='" + getStatuses() + "'" +
            ", activities='" + getActivities() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }


    public Group(Long id, List<User> users, List<Status> statuses, List<Activity> activities, String name) {
        this.id = id;
        this.users = users;
        this.statuses = statuses;
        this.activities = activities;
        this.name = name;
    }

    public Group(List<User> users, String name) {
        this.users = users;
        this.name = name;
    }

    public Group(List<User> users, List<Status> statuses) {
        this.users = users;
        this.statuses = statuses;
    }

}