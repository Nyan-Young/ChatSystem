package com.upupup.domain;

public class BuddyApply {
    /**
     * 申请id
     **/
    private Integer id;
    /**
     * 被申请id
     **/
    private Integer applyId;
    public BuddyApply(Integer id, Integer applyId) {
        this.id = id;
        this.applyId = applyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    @Override
    public String toString() {
        return "BuddyApply{" +
                "id=" + id +
                ", applyId=" + applyId +
                '}';
    }
}
