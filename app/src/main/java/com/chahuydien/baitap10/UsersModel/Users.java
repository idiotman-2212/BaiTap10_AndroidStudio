package com.chahuydien.baitap10.UsersModel;

import java.io.Serializable;

public class Users implements Serializable {
    public String login;
    public int id;
    public String node_id;
    public String avatar_url;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }
}


