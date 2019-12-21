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

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row13;
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
import local.example.data.scheme.dao.record.RoomRecord;

public class RoomDao 
	extends TableImpl<RoomRecord> {

	private static final long serialVersionUID = -10511442573941745L;
	public static final RoomDao ROOM_DAO = new RoomDao();

	@Override
	public Class<RoomRecord> getRecordType() {
		return RoomRecord.class;
	}

	public final TableField<RoomRecord, ULong> ID = createField(
			DSL.name("id"),
			SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), 
			this, 
			"");

	public final TableField<RoomRecord, Integer> BEDS = createField(
			DSL.name("beds"),
			SQLDataType.INTEGER.nullable(false), 
			this, 
			"");

	public final TableField<RoomRecord, Double> BASE_PRICE = createField(
			DSL.name("base_price"),
			SQLDataType.FLOAT.nullable(false), 
			this, 
			"");

	public final TableField<RoomRecord, Double> BATHROOM = createField(
			DSL.name("bathroom"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", 
					SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> FRIGOBAR = createField(
			DSL.name("frigobar"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> COOLING_FAN = createField(
			DSL.name("cooling_fan"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> AIR_CONDITIONING = createField(
			DSL.name("air_conditioning"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> LAUNDRY = createField(DSL.name("laundry"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> SHOEMAKER = createField(
			DSL.name("shoemaker"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> CATERING = createField(
			DSL.name("catering"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> WIFI = createField(
			DSL.name("wifi"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> GIGABIT_ETHERNET = createField(
			DSL.name("gigabit_ethernet"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	public final TableField<RoomRecord, Double> PRIVATE_BALCONY = createField(
			DSL.name("private_balcony"),
			SQLDataType.FLOAT.nullable(false).defaultValue(DSL.field("0.05", SQLDataType.FLOAT)), 
			this,
			"percentage that will contribute to the final price");

	/**
     * Create
     */
    public RoomDao() {
        this(DSL.name("room"), null);
    }

	/**
     * Create an aliased from String
     */
    public RoomDao(String alias) {
        this(DSL.name(alias), ROOM_DAO);
    }

	/**
     * Create an aliased from Name class
     */
    public RoomDao(Name alias) {
        this(alias, ROOM_DAO);
    }

	private RoomDao(Name alias, Table<RoomRecord> aliased) {
        this(alias, aliased, null);
    }

	private RoomDao(Name alias, Table<RoomRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("room data table"));
    }

	public <O extends Record> RoomDao(Table<O> child, ForeignKey<O, RoomRecord> key) {
        super(child, key, ROOM_DAO);
    }

	@Override
	public Schema getSchema() {
		return HotelScheme.HOTEL_SCHEME;
	}

	@Override
	public List<Index> getIndexes() {
		return Arrays.<Index>asList(IndexScheme.ROOM_PRIMARY);
	}

	@Override
	public Identity<RoomRecord, ULong> getIdentity() {
		return KeyScheme.IDENTITY_ROOM;
	}

	@Override
	public UniqueKey<RoomRecord> getPrimaryKey() {
		return KeyScheme.KEY_ROOM_PRIMARY;
	}

	@Override
	public List<UniqueKey<RoomRecord>> getKeys() {
		return Arrays.<UniqueKey<RoomRecord>>asList(KeyScheme.KEY_ROOM_PRIMARY);
	}

	@Override
	public RoomDao as(String alias) {
		return new RoomDao(DSL.name(alias), this);
	}

	@Override
	public RoomDao as(Name alias) {
		return new RoomDao(alias, this);
	}

	/**
	 * Rename from String
	 */
	@Override
	public RoomDao rename(String name) {
		return new RoomDao(DSL.name(name), null);
	}

	/**
	 * Rename from Name class
	 */
	@Override
	public RoomDao rename(Name name) {
		return new RoomDao(name, null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Row13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> fieldsRow() {
		return (Row13) super.fieldsRow();
	}
}
