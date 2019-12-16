package com.example.demo.entity;

import java.util.List;

/**
 * @Author DengMingZhu
 * @Date 2019/12/9 21:50
 * @Version 1.0
 */
public class Team {
    private Integer id;
    private String name;
    //小组名称
    private List<String> honors;
    //小组成员
    private List<User> teamnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHonors() {
        return honors;
    }

    public void setHonors(List<String> honors) {
        this.honors = honors;
    }

    public List<User> getTeamnumber() {
        return teamnumber;
    }

    public void setTeamnumber(List<User> teamnumber) {
        this.teamnumber = teamnumber;
    }

    @Override
    public String toString() {
        StringBuffer sbhonors = new StringBuffer();
        for (String honor : honors) {
            sbhonors.append(honor);
            sbhonors.append("/n");
        }
        sbhonors.append("小组荣耀");
        StringBuffer Team = new StringBuffer("team");
        for (User user : teamnumber) {
            Team.append(user.toString());
            Team.append("/n");
        }
        Team.append("小组成员");
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", honors=" + honors +
                ", teamnumber=" + teamnumber +
                '}';
    }
}
