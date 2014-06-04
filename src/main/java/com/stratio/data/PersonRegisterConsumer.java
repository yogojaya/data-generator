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

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonRegisterConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(PersonRegisterConsumer.class);
  private static final String CREATE_TABLE_IF_EXIST =
      "CREATE TABLE IF NOT EXISTS PersonRegister (MSDIN text, firstName text, "
          + "lastName text, birthDate timestamp, gender text, primary key (MSDIN));";
  private static final int NUM_BATCH_STATEMENT = 10;
  private Session session;

  private BatchStatement batchStatement = new BatchStatement();
  private int numStatement = 0;
  private int numIteration = 0;

  public PersonRegisterConsumer(String host, String keyspace) {
    Cluster cluster = Cluster.builder().addContactPoint(host).build();
    session = cluster.connect(keyspace);
    session.execute(CREATE_TABLE_IF_EXIST);
  }

  public void write(Object[] args) {
    PersonRegister person = PersonRegister.getInstance(args);
    Statement query =
        QueryBuilder.insertInto("PersonRegister").value("MSDIN", person.getMsdin())
            .value("firstName", person.getFirstName()).value("lastName", person.getLastName())
            .value("birthDate", person.getBirthDate()).value("gender", person.getGender());
    batchStatement.add(query);
    numStatement++;
    if (numStatement == NUM_BATCH_STATEMENT) {
      LOGGER.info("Execute batch query PersonRegister: "+ numIteration++);
      session.execute(batchStatement);
      batchStatement.clear();
      numStatement = 0;
    }
  }



}
