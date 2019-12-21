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
import org.jooq.Row4;
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
import local.example.data.scheme.dao.record.BookingRecord;

public class BookingDao extends TableImpl<BookingRecord> {

	private static final long serialVersionUID = -3929196395630491855L;
	public static final BookingDao BOOKING_DAO = new BookingDao();

	@Override
	public Class<BookingRecord> getRecordType() {
		return BookingRecord.class;
	}

	public final TableField<BookingRecord, ULong> ID = createField(
			DSL.name("id"),
			SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), 
			this, 
			"");

	public final TableField<BookingRecord, String> VACANCY = createField(
			DSL.name("vacancy"),
			SQLDataType.VARCHAR(1).nullable(false), 
			this, 
			"N|Y|C, no|yes|cancel");

	public final TableField<BookingRecord, Date> CHECK_IN = createField(
			DSL.name("check_in"),
			SQLDataType.DATE.nullable(false), 
			this, 
			"");

	public final TableField<BookingRecord, Date> CHECK_OUT = createField(
			DSL.name("check_out"),
			SQLDataType.DATE.nullable(false), 
			this, 
			"");

	/**
	 * Create
	 */
	public BookingDao() {
		this(DSL.name("booking"), null);
	}

	/**
	 * Create an aliased from String
	 */
	public BookingDao(String alias) {
		this(DSL.name(alias), BOOKING_DAO);
	}

	/**
	 * Create an aliased from Name class
	 */
	public BookingDao(Name alias) {
		this(alias, BOOKING_DAO);
	}

	private BookingDao(Name alias, Table<BookingRecord> aliased) {
		this(alias, aliased, null);
	}

	private BookingDao(Name alias, Table<BookingRecord> aliased, Field<?>[] parameters) {
		super(alias, null, aliased, parameters, DSL.comment("booking data table"));
	}

	public <O extends Record> BookingDao(Table<O> child, ForeignKey<O, BookingRecord> key) {
		super(child, key, BOOKING_DAO);
	}

	@Override
	public Schema getSchema() {
		return HotelScheme.HOTEL_SCHEME;
	}

	@Override
	public List<Index> getIndexes() {
		return Arrays.<Index>asList(IndexScheme.BOOKING_PRIMARY);
	}

	@Override
	public Identity<BookingRecord, ULong> getIdentity() {
		return KeyScheme.IDENTITY_BOOKING;
	}

	@Override
	public UniqueKey<BookingRecord> getPrimaryKey() {
		return KeyScheme.KEY_BOOKING_PRIMARY;
	}

	@Override
	public List<UniqueKey<BookingRecord>> getKeys() {
		return Arrays.<UniqueKey<BookingRecord>>asList(KeyScheme.KEY_BOOKING_PRIMARY);
	}

	@Override
	public List<ForeignKey<BookingRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<BookingRecord, ?>>asList(
				KeyScheme.BOOKING_CUSTOMER_FK, 
				KeyScheme.BOOKING_ROOM_FK);
	}

	public CustomerDao customerDao() {
		return new CustomerDao(this, KeyScheme.BOOKING_CUSTOMER_FK);
	}

	public RoomDao roomDao() {
		return new RoomDao(this, KeyScheme.BOOKING_ROOM_FK);
	}

	@Override
	public BookingDao as(String alias) {
		return new BookingDao(DSL.name(alias), this);
	}

	@Override
	public BookingDao as(Name alias) {
		return new BookingDao(alias, this);
	}

	/**
	 * Rename
	 */
	@Override
	public BookingDao rename(String name) {
		return new BookingDao(DSL.name(name), null);
	}

	/**
	 * Rename
	 */
	@Override
	public BookingDao rename(Name name) {
		return new BookingDao(name, null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Row4<ULong, String, Date, Date> fieldsRow() {
		return (Row4) super.fieldsRow();
	}
}
