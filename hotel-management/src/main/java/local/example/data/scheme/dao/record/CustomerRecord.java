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

package local.example.data.scheme.dao.record;

import java.sql.Date;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;

import local.example.data.scheme.dao.CustomerDao;

public class CustomerRecord 
		extends UpdatableRecordImpl<CustomerRecord> 
		implements Record6<ULong, String, String, Date, String, String> {

	private static final long serialVersionUID = -1215824472402887483L;
	
	/* constructors */
	
	public CustomerRecord() {
		super(CustomerDao.CUSTOMER_DAO);
	}
	
	public CustomerRecord(String lastName, String email) {
		super(CustomerDao.CUSTOMER_DAO);
		super.set(2, lastName);
		super.set(6, email);
	}
	
	public CustomerRecord(String firstName, String lastName, String email) {
		super(CustomerDao.CUSTOMER_DAO);
		super.set(1, firstName);
		super.set(2, lastName);
		super.set(6, email);
	}
	
	public CustomerRecord(String firstName, String lastName, Date birthday, String email) {
		super(CustomerDao.CUSTOMER_DAO);
		super.set(1, firstName);
		super.set(2, lastName);
		super.set(3, birthday);
		super.set(6, email);
	}
	
	public CustomerRecord(String firstName, String lastName, Date birthday, String gender, String email) {
		super(CustomerDao.CUSTOMER_DAO);
		super.set(1, firstName);
		super.set(2, lastName);
		super.set(3, birthday);
		super.set(4, gender);
		super.set(6, email);
	}
	
	/* getter */
	
	private ULong getId() {
		return (ULong) get(0);
	}
	
	private String getFirstName() {
		return (String) get(1);
	}
	
	private String getLastName() {
		return (String) get(2);
	}
	
	private Date getBirthday() {
		return (Date) get(3);
	}
	
	private String getGender() {
		return (String) get(4);
	}
	
	private String getEmail() {
		return (String) get(5);
	}
	
	/* setter */
	
	private void setFirstName(String firstName) {
		set(1, firstName);
	}
	
	private void setLastName(String lastName) {
		set(2, lastName);
	}
	
	private void setBirthday(Date birthday) {
		set(3, birthday);
	}
	
	private void setGender(String gender) {
		set(4, gender);
	}
	
	private void setEmail(String email) {
		set(5, email);
	}
	
	/* update */
	
	public CustomerRecord updateFirstName(String firstName) {
		this.setFirstName(firstName);
		return this;
	}
	
	public CustomerRecord updateLastName(String lastName) {
		this.setLastName(lastName);
		return this;
	}
	
	public CustomerRecord updateBirthday(Date birthday) {
		this.setBirthday(birthday);
		return this;
	}
	
	public CustomerRecord updateGender(String gender) {
		this.setGender(gender);
		return this;
	}
	
	public CustomerRecord updateEmail(String email) {
		this.setEmail(email);
		return this;
	}
	
	public CustomerRecord update(
			String firstName,
			String lastName,
			Date birthday,
			String gender,
			String email) {
		this.updateFirstName(firstName);
		this.updateLastName(lastName);
		this.updateBirthday(birthday);
		this.updateGender(gender);
		this.updateEmail(email);
		return this;
	}
	
	/* overrides */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Record1<ULong> key() {
		return (Record1) super.key();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Row6<ULong, String, String, Date, String, String> fieldsRow() {
		return (Row6) super.fieldsRow();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Row6<ULong, String, String, Date, String, String> valuesRow() {
		return (Row6) super.valuesRow();
	}
	
	/* override fields */

	@Override
	public Field<ULong> field1() {
		return CustomerDao.CUSTOMER_DAO.ID;
	}

	@Override
	public Field<String> field2() {
		return CustomerDao.CUSTOMER_DAO.FIRST_NAME;
	}

	@Override
	public Field<String> field3() {
		return CustomerDao.CUSTOMER_DAO.LAST_NAME;
	}

	@Override
	public Field<Date> field4() {
		return CustomerDao.CUSTOMER_DAO.BIRTHDAY;
	}

	@Override
	public Field<String> field5() {
		return CustomerDao.CUSTOMER_DAO.GENDER;
	}

	@Override
	public Field<String> field6() {
		return CustomerDao.CUSTOMER_DAO.EMAIL;
	}
	
	/* override values */

	@Override
	public ULong value1() {
		return this.getId();
	}

	@Override
	public String value2() {
		return this.getFirstName();
	}

	@Override
	public String value3() {
		return this.getLastName();
	}

	@Override
	public Date value4() {
		return this.getBirthday();
	}

	@Override
	public String value5() {
		return this.getGender();
	}

	@Override
	public String value6() {
		return this.getEmail();
	}
	
	/* override components */

	@Override
	public ULong component1() {
		return this.getId();
	}

	@Override
	public String component2() {
		return this.getFirstName();
	}

	@Override
	public String component3() {
		return this.getLastName();
	}

	@Override
	public Date component4() {
		return this.getBirthday();
	}

	@Override
	public String component5() {
		return this.getGender();
	}

	@Override
	public String component6() {
		return this.getEmail();
	}
	
	/* other overrides */

	@Override
	public Record6<ULong, String, String, Date, String, String> value1(ULong id) {
		return this;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value2(String firstName) {
		this.setFirstName(firstName);
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value3(String lastName) {
		this.setLastName(lastName);
		return this;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value4(Date birthday) {
		this.setBirthday(birthday);
		return this;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value5(String gender) {
		this.setGender(gender);
		return this;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value6(String email) {
		this.setEmail(email);
		return this;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> values(
			ULong id, 
			String firstName, 
			String lastName, 
			Date birthday,
			String gender, 
			String email) {
		this.value1(id);
		this.value2(firstName);
		this.value3(lastName);
		this.value4(birthday);
		this.value5(gender);
		this.value6(email);
		return this;
	}
}
