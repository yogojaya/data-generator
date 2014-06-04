/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.stratio.data;

import java.util.Date;

public class PersonRegister {
  private final String msdin;
  private final String firstName;
  private final String lastName;
  private final Date birthDate;
  private final String gender;

  private PersonRegister(String msdin, String firstName, String lastName, Date birthDate,
      String gender) {
    this.msdin = msdin;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.gender = gender;
  }


  public static PersonRegister getInstance(Object[] args) {
    String msdin = args[0].toString();
    String firstName = args[1].toString();
    String lastName = args[2].toString();
    Date birthDate = (Date) args[3];
    String gender = args[4].toString();
    return new PersonRegister(msdin, firstName, lastName, birthDate, gender);
  }



  public String getMsdin() {
    return msdin;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public String getGender() {
    return gender;
  }
}
