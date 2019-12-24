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
	
	public ULong getId() {
		return (ULong) super.get(0);
	}
	
	public String getVacancy() {
		return (String) super.get(1);
	}
	
	public Date getCheckIn() {
		return (Date) super.get(2);
	}
	
	public Date getCheckOut() {
		return (Date) super.get(3);
	}
	
	/* setter */
	
	public void setVacancy(String vacancy) {
		super.set(1, vacancy);
	}
	
	public void setCheckIn(Date checkIn) {
		super.set(2, checkIn);
	}
	
	public void setCheckOut(Date checkOut) {
		super.set(3, checkOut);
	}
	
	/* update */
	
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
	public Record4<ULong, String, Date, Date> value1(ULong value) {
		// TODO
		return null;
	}

	@Override
	public Record4<ULong, String, Date, Date> value2(String value) {
		// TODO
		return null;
	}

	@Override
	public Record4<ULong, String, Date, Date> value3(Date value) {
		// TODO
		return null;
	}

	@Override
	public Record4<ULong, String, Date, Date> value4(Date value) {
		// TODO
		return null;
	}

	@Override
	public Record4<ULong, String, Date, Date> values(ULong t1, String t2, Date t3, Date t4) {
		// TODO
		return null;
	}
}
