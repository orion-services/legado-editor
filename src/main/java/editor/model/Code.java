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


import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;




@Entity
@SequenceGenerator(name="code_seq", sequenceName = "code_seq",initialValue = 1, allocationSize = 1)
@Table(name = "code")
public class Code{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_id",referencedColumnName = "id")
    @JsonBackReference
    public Activity activity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonBackReference
    public User user;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate")
    private java.util.Calendar createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedDate")
    private java.util.Calendar modifiedDate;
    
    @Column(length = 12000)
    private String textCode;

    private int limitBlock;

    @Column(unique = true)
    private String hashCode;

    public String generateHash() {
        SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[6];
            random.nextBytes(bytes);
            Encoder encoder = Base64.getUrlEncoder().withoutPadding();
            String hash = encoder.encodeToString(bytes);
        return hash;
    }

    public String getHashCode() {
        return this.hashCode;
    }

    public String setHashCode(String hashCode) {
        return this.hashCode = hashCode;
     }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getLimitBlock() {
        return this.limitBlock;
    }

    public void setLimitBlock(int limitBlock) {
        this.limitBlock = limitBlock;
    }


    public Long getId(Long idCode) {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextCode() {
        return this.textCode;
    }

    public void setTextCode(String textCode) {
        this.textCode = textCode;
    }

    public Code() {
    }

    public Code(Long id, Activity activity, User user, java.util.Calendar createdDate, java.util.Calendar modifiedDate, String textCode, int limitBlock, String hashCode) {
        this.id = id;
        this.activity = activity;
        this.user = user;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.textCode = textCode;
        this.limitBlock = limitBlock;
        this.hashCode = hashCode;
    }

    public Code(String textCode, String hashCode, int limitBlock) {
        this.textCode = textCode;
        this.hashCode = generateHash();
        this.limitBlock = limitBlock;
    }
    
   
}