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
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.Table;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;

public class BookingRecord 
	extends UpdatableRecordImpl<BookingRecord> 
	implements Record4<ULong, String, Date, Date> {

	private static final long serialVersionUID = -5016972913785784538L;

	public BookingRecord(Table<BookingRecord> table) {
		super(table);
		// TODO
	}

	@Override
	public Row4<ULong, String, Date, Date> fieldsRow() {
		// TODO
		return null;
	}

	@Override
	public Row4<ULong, String, Date, Date> valuesRow() {
		// TODO
		return null;
	}

	@Override
	public Field<ULong> field1() {
		// TODO
		return null;
	}

	@Override
	public Field<String> field2() {
		// TODO
		return null;
	}

	@Override
	public Field<Date> field3() {
		// TODO
		return null;
	}

	@Override
	public Field<Date> field4() {
		// TODO
		return null;
	}

	@Override
	public ULong value1() {
		// TODO
		return null;
	}

	@Override
	public String value2() {
		// TODO
		return null;
	}

	@Override
	public Date value3() {
		// TODO
		return null;
	}

	@Override
	public Date value4() {
		// TODO
		return null;
	}

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

	@Override
	public ULong component1() {
		// TODO
		return null;
	}

	@Override
	public String component2() {
		// TODO
		return null;
	}

	@Override
	public Date component3() {
		// TODO
		return null;
	}

	@Override
	public Date component4() {
		// TODO
		return null;
	}
}
