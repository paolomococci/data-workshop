/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.data.service;

import static local.example.data.scheme.dao.CustomerDao.CUSTOMER_DAO;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import local.example.data.domain.Customer;
import local.example.data.scheme.dao.record.CustomerRecord;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private DSLContext dslContext;

	public Customer createCustomer(Customer customer) {
		CustomerRecord customerRecord = (CustomerRecord) dslContext
				.insertInto(CUSTOMER_DAO)
				.set(CUSTOMER_DAO.FIRST_NAME, customer.getFirstName())
				.set(CUSTOMER_DAO.LAST_NAME, customer.getLastName())
				.set(CUSTOMER_DAO.BIRTHDAY, customer.getBirthday())
				.set(CUSTOMER_DAO.GENDER, customer.getGender())
				.set(CUSTOMER_DAO.EMAIL, customer.getEmail());
		customer.setId(customerRecord.getId());
		return customer;
	}
}
