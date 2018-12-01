package com.springsecurity.sandbox.domain;

import com.springsecurity.sandbox.constants.ColumnConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_authority")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ColumnConstants.USER_AUTHORITY_ID)
    private Integer userAuthorityId;

    @ManyToOne
    @JoinColumn(name = ColumnConstants.USER_ID)
    private User user;

    @ManyToOne
    @JoinColumn(name = ColumnConstants.AUTHORITY_ID)
    private Authority authority;

    public Integer getUserAuthorityId() {
        return userAuthorityId;
    }

    public void setUserAuthorityId(Integer userAuthorityId) {
        this.userAuthorityId = userAuthorityId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
