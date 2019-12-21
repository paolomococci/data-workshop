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

package local.example.data.scheme.dao;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;

import local.example.data.scheme.HotelScheme;
import local.example.data.scheme.IndexScheme;
import local.example.data.scheme.KeyScheme;
import local.example.data.scheme.dao.record.CustomerRecord;

public class CustomerDao 
	extends TableImpl<CustomerRecord> {

	private static final long serialVersionUID = -7267665905185600063L;
	public static final CustomerDao CUSTOMER_DAO = new CustomerDao();

	@Override
	public Class<CustomerRecord> getRecordType() {
		return CustomerRecord.class;
	}

	public final TableField<CustomerRecord, ULong> ID = createField(
			DSL.name("id"),
			SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), 
			this, 
			"");

	public final TableField<CustomerRecord, String> FIRST_NAME = createField(
			DSL.name("first_name"),
			SQLDataType.VARCHAR(30).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), 
			this, 
			"");

	public final TableField<CustomerRecord, String> LAST_NAME = createField(DSL.name("last_name"),
			SQLDataType.VARCHAR(30).nullable(false), this, "");

	public final TableField<CustomerRecord, Date> BIRTHDAY = createField(
			DSL.name("birthday"),
			SQLDataType.DATE.defaultValue(DSL.field("NULL", SQLDataType.DATE)), 
			this, 
			"");

	public final TableField<CustomerRecord, String> GENDER = createField(
			DSL.name("gender"),
			SQLDataType.VARCHAR(1).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), 
			this, 
			"");

	public final TableField<CustomerRecord, String> EMAIL = createField(
			DSL.name("email"),
			SQLDataType.VARCHAR(100).nullable(false), 
			this, 
			"");

	/**
	 * Create
	 */
	public CustomerDao() {
		this(DSL.name("customer"), null);
	}

	/**
	 * Create an aliased from String
	 */
	public CustomerDao(String alias) {
		this(DSL.name(alias), CUSTOMER_DAO);
	}

	/**
	 * Create an aliased from Name class
	 */
	public CustomerDao(Name alias) {
		this(alias, CUSTOMER_DAO);
	}

	private CustomerDao(Name alias, Table<CustomerRecord> aliased) {
		this(alias, aliased, null);
	}

	private CustomerDao(Name alias, Table<CustomerRecord> aliased, Field<?>[] parameters) {
		super(alias, null, aliased, parameters, DSL.comment("customer data table"));
	}

	public <O extends Record> CustomerDao(Table<O> child, ForeignKey<O, CustomerRecord> key) {
		super(child, key, CUSTOMER_DAO);
	}

	@Override
	public Schema getSchema() {
		return HotelScheme.HOTEL_SCHEME;
	}

	@Override
	public List<Index> getIndexes() {
		return Arrays.<Index>asList(IndexScheme.CUSTOMER_PRIMARY);
	}

	@Override
	public Identity<CustomerRecord, ULong> getIdentity() {
		return KeyScheme.IDENTITY_CUSTOMER;
	}

	@Override
	public UniqueKey<CustomerRecord> getPrimaryKey() {
		return KeyScheme.KEY_CUSTOMER_PRIMARY;
	}

	@Override
	public List<UniqueKey<CustomerRecord>> getKeys() {
		return Arrays.<UniqueKey<CustomerRecord>>asList(KeyScheme.KEY_CUSTOMER_PRIMARY);
	}

	@Override
	public CustomerDao as(String alias) {
		return new CustomerDao(DSL.name(alias), this);
	}

	@Override
	public CustomerDao as(Name alias) {
		return new CustomerDao(alias, this);
	}

	/**
	 * Rename from String
	 */
	@Override
	public CustomerDao rename(String name) {
		return new CustomerDao(DSL.name(name), null);
	}

	/**
	 * Rename from Name class
	 */
	@Override
	public CustomerDao rename(Name name) {
		return new CustomerDao(name, null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Row6<ULong, String, String, Date, String, String> fieldsRow() {
		return (Row6) super.fieldsRow();
	}
}
