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

public class Register {
  /*
   * <attribute name="codPacote" pattern="6[0-9]{8}"/> <attribute name="dateTime" type="date"
   * generator="dateTimeGen"/> <attribute name="value" type="int" min="1" max="100"/> <attribute
   * name="type" pattern="[A-D]"/>
   */

  private final String id;
  private final String msdin;
  private final String firstName;
  private final String lastName;
  private final Date birthDate;
  private final String gender;
  private final String codPacote;
  private final Date dateTime;
  private final Integer value;
  private final String type;
  private final String country;

  private Register(String id, String msdin, String firstName, String lastName, Date birthDate,
      String gender, String codPacote, Date dateTime, Integer value, String type, String country) {
    this.id = id;
    this.msdin = msdin;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.gender = gender;
    this.codPacote = codPacote;
    this.dateTime = dateTime;
    this.value = value;
    this.type = type;
    this.country = country;
  }


  public static Register getInstance(Object[] args) {
    String id = args[0].toString();
    String msdin = args[1].toString();
    String firstName = args[2].toString();
    String lastName = args[3].toString();
    Date birthDate = (Date) args[4];
    String gender = args[5].toString();
    String codPacote = args[6].toString();
    Date dateTime = (Date) args[7];
    Integer value = (Integer) args[8];
    String type = args[9].toString();
    String country = args[10].toString();
    return new Register(id, msdin, firstName, lastName, birthDate, gender, codPacote, dateTime,
        value, type, country);
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

  public String getCodPacote() {
    return codPacote;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public Integer getValue() {
    return value;
  }

  public String getType() {
    return type;
  }

  public String getId() {
    return id;
  }

  public String getCountry() {
    return country;
  }
}
