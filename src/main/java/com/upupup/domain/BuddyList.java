package com.upupup.domain;

public class BuddyList {
    private Integer id;
    private Integer buddyId;

    public BuddyList(Integer id, Integer buddyId) {
        this.id = id;
        this.buddyId = buddyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuddyId() {
        return buddyId;
    }

    public void setBuddyId(Integer buddyId) {
        this.buddyId = buddyId;
    }

    @Override
    public String toString() {
        return "BuddyList{" +
                "id=" + id +
                ", buddyId=" + buddyId +
                '}';
    }
}
