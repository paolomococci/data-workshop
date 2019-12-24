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

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.ULong;

import local.example.data.scheme.dao.RoomDao;

public class RoomRecord 
	extends UpdatableRecordImpl<RoomRecord> 
	implements Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> {

	private static final long serialVersionUID = -9142412866049967992L;
	
	/* constructors */
	
	public RoomRecord() {
		super(RoomDao.ROOM_DAO);
	}
	
	public RoomRecord(
			Integer beds, 
			Double basePrice, 
			Double bathroom, 
			Double frigobar, 
			Double coolingFan, 
			Double airConditioning, 
			Double laundry, 
			Double shoemaker, 
			Double catering, 
			Double wifi, 
			Double gigabitEthernet, 
			Double privateBalcony) {
		super(RoomDao.ROOM_DAO);
		super.set(1, beds);
		super.set(2, basePrice);
		super.set(3, bathroom);
		super.set(4, frigobar);
		super.set(5, coolingFan);
		super.set(6, airConditioning);
		super.set(7, laundry);
		super.set(8, shoemaker);
		super.set(9, catering);
		super.set(10, wifi);
		super.set(11, gigabitEthernet);
		super.set(12, privateBalcony);
	}
	
	/* getter */
	
	public ULong getId() {
		return (ULong) super.get(0);
	}
	
	public Integer getBeds() {
		return (Integer) super.get(1);
	}
	
	public Double getBasePrice() {
		return (Double) super.get(2);
	}
	
	public Double getBathroom() {
		return (Double) super.get(3);
	}
	
	public Double getFrigobar() {
		return (Double) super.get(4);
	}
	
	public Double getCoolingFan() {
		return (Double) super.get(5);
	}
	
	public Double getAirConditioning() {
		return (Double) super.get(6);
	}
	
	public Double getLaundry() {
		return (Double) super.get(7);
	}
	
	public Double getShoemaker() {
		return (Double) super.get(8);
	}
	
	public Double getCatering() {
		return (Double) super.get(9);
	}
	
	public Double getWifi() {
		return (Double) super.get(10);
	}
	
	public Double getGigabitEthernet() {
		return (Double) super.get(11);
	}
	
	public Double getPrivateBalcony() {
		return (Double) super.get(12);
	}
	
	/* setter */
	
	public void setBeds(Integer beds) {
		super.set(1, beds);
	}
	
	public void setBasePrice(Double basePrice) {
		super.set(2, basePrice);
	}
	
	public void setBathroom(Double bathroom) {
		super.set(3, bathroom);
	}
	
	public void setFrigobar(Double frigobar) {
		super.set(4, frigobar);
	}
	
	public void setCoolingFan(Double coolingFan) {
		super.set(5, coolingFan);
	}
	
	public void setAirConditioning(Double airConditioning) {
		super.set(6, airConditioning);
	}
	
	public void setLaundry(Double laundry) {
		super.set(7, laundry);
	}
	
	public void setShoemaker(Double shoemaker) {
		super.set(8, shoemaker);
	}
	
	public void setCatering(Double catering) {
		super.set(9, catering);
	}
	
	public void setWifi(Double wifi) {
		super.set(10, wifi);
	}
	
	public void setGigabitEthernet(Double gigabitEthernet) {
		super.set(11, gigabitEthernet);
	}
	
	public void setPrivateBalcony(Double privateBalcony) {
		super.set(12, privateBalcony);
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
	public Row13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> fieldsRow() {
		return (Row13) super.fieldsRow();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Row13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> valuesRow() {
		return (Row13) super.valuesRow();
	}
	
	/* override fields */

	@Override
	public Field<ULong> field1() {
		return RoomDao.ROOM_DAO.ID;
	}

	@Override
	public Field<Integer> field2() {
		return RoomDao.ROOM_DAO.BEDS;
	}

	@Override
	public Field<Double> field3() {
		return RoomDao.ROOM_DAO.BASE_PRICE;
	}

	@Override
	public Field<Double> field4() {
		return RoomDao.ROOM_DAO.BATHROOM;
	}

	@Override
	public Field<Double> field5() {
		return RoomDao.ROOM_DAO.FRIGOBAR;
	}

	@Override
	public Field<Double> field6() {
		return RoomDao.ROOM_DAO.COOLING_FAN;
	}

	@Override
	public Field<Double> field7() {
		return RoomDao.ROOM_DAO.AIR_CONDITIONING;
	}

	@Override
	public Field<Double> field8() {
		return RoomDao.ROOM_DAO.LAUNDRY;
	}

	@Override
	public Field<Double> field9() {
		return RoomDao.ROOM_DAO.SHOEMAKER;
	}

	@Override
	public Field<Double> field10() {
		return RoomDao.ROOM_DAO.CATERING;
	}

	@Override
	public Field<Double> field11() {
		return RoomDao.ROOM_DAO.WIFI;
	}

	@Override
	public Field<Double> field12() {
		return RoomDao.ROOM_DAO.GIGABIT_ETHERNET;
	}

	@Override
	public Field<Double> field13() {
		return RoomDao.ROOM_DAO.PRIVATE_BALCONY;
	}
	
	/* override values */

	@Override
	public ULong value1() {
		return this.getId();
	}

	@Override
	public Integer value2() {
		return this.getBeds();
	}

	@Override
	public Double value3() {
		return this.getBasePrice();
	}

	@Override
	public Double value4() {
		return this.getBathroom();
	}

	@Override
	public Double value5() {
		return this.getFrigobar();
	}

	@Override
	public Double value6() {
		return this.getCoolingFan();
	}

	@Override
	public Double value7() {
		return this.getAirConditioning();
	}

	@Override
	public Double value8() {
		return this.getLaundry();
	}

	@Override
	public Double value9() {
		return this.getShoemaker();
	}

	@Override
	public Double value10() {
		return this.getCatering();
	}

	@Override
	public Double value11() {
		return this.getWifi();
	}

	@Override
	public Double value12() {
		return this.getGigabitEthernet();
	}

	@Override
	public Double value13() {
		return this.getPrivateBalcony();
	}
	
	/* override components */

	@Override
	public ULong component1() {
		// TODO
		return null;
	}

	@Override
	public Integer component2() {
		// TODO
		return null;
	}

	@Override
	public Double component3() {
		// TODO
		return null;
	}

	@Override
	public Double component4() {
		// TODO
		return null;
	}

	@Override
	public Double component5() {
		// TODO
		return null;
	}

	@Override
	public Double component6() {
		// TODO
		return null;
	}

	@Override
	public Double component7() {
		// TODO
		return null;
	}

	@Override
	public Double component8() {
		// TODO
		return null;
	}

	@Override
	public Double component9() {
		// TODO
		return null;
	}

	@Override
	public Double component10() {
		// TODO
		return null;
	}

	@Override
	public Double component11() {
		// TODO
		return null;
	}

	@Override
	public Double component12() {
		// TODO
		return null;
	}

	@Override
	public Double component13() {
		// TODO
		return null;
	}
	
	/* other overrides */

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value1(
			ULong value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value2(
			Integer value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value3(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value4(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value5(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value6(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value7(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value8(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value9(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value10(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value11(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value12(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> value13(
			Double value) {
		// TODO
		return null;
	}

	@Override
	public Record13<ULong, Integer, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double, Double> values(
			ULong t1, Integer t2, Double t3, Double t4, Double t5, Double t6, Double t7, Double t8, Double t9,
			Double t10, Double t11, Double t12, Double t13) {
		// TODO
		return null;
	}
}
