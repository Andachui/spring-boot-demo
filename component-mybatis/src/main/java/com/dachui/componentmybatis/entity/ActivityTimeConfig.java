package com.dachui.componentmybatis.entity;

import java.util.Date;

public class ActivityTimeConfig {
    private Integer id;

    private String activityId;

    private String preActivityId;

    private Integer isCurrentMgm;

    private String activityName;

    private Integer activityFlag;

    private Integer activityType;

    private String allowBusinessCategory;

    private String lockPeriod;

    private Date beginTime;

    private Date endTime;

    private String createUser;

    private Date createTime;

    private String lastUpdateUser;

    private Date lastUpdataTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getPreActivityId() {
        return preActivityId;
    }

    public void setPreActivityId(String preActivityId) {
        this.preActivityId = preActivityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public Integer getIsCurrentMgm() {
        return isCurrentMgm;
    }

    public void setIsCurrentMgm(Integer isCurrentMgm) {
        this.isCurrentMgm = isCurrentMgm;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Integer getActivityFlag() {
        return activityFlag;
    }

    public void setActivityFlag(Integer activityFlag) {
        this.activityFlag = activityFlag;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getAllowBusinessCategory() {
        return allowBusinessCategory;
    }

    public void setAllowBusinessCategory(String allowBusinessCategory) {
        this.allowBusinessCategory = allowBusinessCategory == null ? null : allowBusinessCategory.trim();
    }

    public String getLockPeriod() {
        return lockPeriod;
    }

    public void setLockPeriod(String lockPeriod) {
        this.lockPeriod = lockPeriod == null ? null : lockPeriod.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
    }

    public Date getLastUpdataTime() {
        return lastUpdataTime;
    }

    public void setLastUpdataTime(Date lastUpdataTime) {
        this.lastUpdataTime = lastUpdataTime;
    }
}