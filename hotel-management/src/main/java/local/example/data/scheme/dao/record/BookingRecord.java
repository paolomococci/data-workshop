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
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;

import local.example.data.scheme.dao.BookingDao;

public class BookingRecord 
		extends UpdatableRecordImpl<BookingRecord> 
		implements Record4<ULong, String, Date, Date> {

	private static final long serialVersionUID = -5016972913785784538L;
	
	/* constructors */
	
	public BookingRecord() {
		super(BookingDao.BOOKING_DAO);
	}
	
	public BookingRecord(ULong id, String vacancy, Date checkIn, Date checkOut) {
		super(BookingDao.BOOKING_DAO);
		super.set(1, vacancy);
		super.set(2, checkIn);
		super.set(3, checkOut);
	}
	
	/* getter */
	
	private ULong getId() {
		return (ULong) super.get(0);
	}
	
	private String getVacancy() {
		return (String) super.get(1);
	}
	
	private Date getCheckIn() {
		return (Date) super.get(2);
	}
	
	private Date getCheckOut() {
		return (Date) super.get(3);
	}
	
	/* setter */
	
	private void setVacancy(String vacancy) {
		super.set(1, vacancy);
	}
	
	private void setCheckIn(Date checkIn) {
		super.set(2, checkIn);
	}
	
	private void setCheckOut(Date checkOut) {
		super.set(3, checkOut);
	}
	
	/* update */

	public BookingRecord updateVacancy(String vacancy) {
		this.setVacancy(vacancy);
		return this;
	}

	public BookingRecord updateCheckIn(Date checkIn) {
		this.setCheckIn(checkIn);
		return this;
	}

	public BookingRecord updateCheckOut(Date checkOut) {
		this.setCheckOut(checkOut);
		return this;
	}

	public BookingRecord update(ULong id, String vacancy, Date checkIn, Date checkOut) {
		this.value1(id);
		this.value2(vacancy);
		this.value3(checkIn);
		this.value4(checkOut);
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
	public Row4<ULong, String, Date, Date> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Row4<ULong, String, Date, Date> valuesRow() {
		return (Row4) super.valuesRow();
	}
	
	/* override fields */

	@Override
	public Field<ULong> field1() {
		return BookingDao.BOOKING_DAO.ID;
	}

	@Override
	public Field<String> field2() {
		return BookingDao.BOOKING_DAO.VACANCY;
	}

	@Override
	public Field<Date> field3() {
		return BookingDao.BOOKING_DAO.CHECK_IN;
	}

	@Override
	public Field<Date> field4() {
		return BookingDao.BOOKING_DAO.CHECK_OUT;
	}
	
	/* override values */

	@Override
	public ULong value1() {
		return this.getId();
	}

	@Override
	public String value2() {
		return this.getVacancy();
	}

	@Override
	public Date value3() {
		return this.getCheckIn();
	}

	@Override
	public Date value4() {
		return this.getCheckOut();
	}
	
	/* override components */

	@Override
	public ULong component1() {
		return this.getId();
	}

	@Override
	public String component2() {
		return this.getVacancy();
	}

	@Override
	public Date component3() {
		return this.getCheckIn();
	}

	@Override
	public Date component4() {
		return this.getCheckOut();
	}
	
	/* other overrides */

	@Override
	public Record4<ULong, String, Date, Date> value1(ULong id) {
		return this;
	}

	@Override
	public Record4<ULong, String, Date, Date> value2(String vacancy) {
		this.setVacancy(vacancy);
		return this;
	}

	@Override
	public Record4<ULong, String, Date, Date> value3(Date checkIn) {
		this.setCheckIn(checkIn);
		return this;
	}

	@Override
	public Record4<ULong, String, Date, Date> value4(Date checkOut) {
		this.setCheckOut(checkOut);
		return this;
	}

	@Override
	public Record4<ULong, String, Date, Date> values(ULong id, String vacancy, Date checkIn, Date checkOut) {
		this.value1(id);
		this.value2(vacancy);
		this.value3(checkIn);
		this.value4(checkOut);
		return this;
	}
}
