package com.benjamin.test.entity;

import com.benjamin.websocket.entity.Identity;

/**
 * Created by benjamin on 11/27/14.
 */
public class User implements Identity<String> {

  private String userId;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getIdentify() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public int hashCode() {
    return userId.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(!(obj instanceof User))
      return false;
    User user = (User) obj;
    if(user.getIdentify() == null)
      return false;
    return user.getIdentify().equals(this.getIdentify());
  }
}
