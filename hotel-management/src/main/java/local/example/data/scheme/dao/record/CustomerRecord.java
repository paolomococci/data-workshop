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
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.Table;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;

public class CustomerRecord 
	extends UpdatableRecordImpl<CustomerRecord> 
	implements Record6<ULong, String, String, Date, String, String> {

	private static final long serialVersionUID = -1215824472402887483L;

	public CustomerRecord(Table<CustomerRecord> table) {
		super(table);
		// TODO
	}

	@Override
	public Row6<ULong, String, String, Date, String, String> fieldsRow() {
		// TODO
		return null;
	}

	@Override
	public Row6<ULong, String, String, Date, String, String> valuesRow() {
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
	public Field<String> field3() {
		// TODO
		return null;
	}

	@Override
	public Field<Date> field4() {
		// TODO
		return null;
	}

	@Override
	public Field<String> field5() {
		// TODO
		return null;
	}

	@Override
	public Field<String> field6() {
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
	public String value3() {
		// TODO
		return null;
	}

	@Override
	public Date value4() {
		// TODO
		return null;
	}

	@Override
	public String value5() {
		// TODO
		return null;
	}

	@Override
	public String value6() {
		// TODO
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value1(ULong value) {
		// TODO
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value2(String value) {
		// TODO
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value3(String value) {
		// TODO
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value4(Date value) {
		// TODO
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value5(String value) {
		// TODO
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> value6(String value) {
		// TODO
		return null;
	}

	@Override
	public Record6<ULong, String, String, Date, String, String> values(ULong t1, String t2, String t3, Date t4,
			String t5, String t6) {
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
	public String component3() {
		// TODO
		return null;
	}

	@Override
	public Date component4() {
		// TODO
		return null;
	}

	@Override
	public String component5() {
		// TODO
		return null;
	}

	@Override
	public String component6() {
		// TODO
		return null;
	}
}
