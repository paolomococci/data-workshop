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

import static local.example.data.scheme.dao.RoomDao.ROOM_DAO;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.exception.DataAccessException;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import local.example.data.domain.Room;
import local.example.data.scheme.dao.record.RoomRecord;

@Service
@Transactional
public class RoomService {

	@Autowired
	private DSLContext dslContext;
	
	public Room createRoom(Room room) 
			throws DataAccessException {
		RoomRecord roomRecord = (RoomRecord) dslContext
				.insertInto(ROOM_DAO)
				.set(ROOM_DAO.BEDS, room.getBeds())
				.set(ROOM_DAO.BASE_PRICE, room.getBasePrice())
				.set(ROOM_DAO.BATHROOM, room.getBathroom())
				.set(ROOM_DAO.FRIGOBAR, room.getFrigobar())
				.set(ROOM_DAO.COOLING_FAN, room.getCoolingFan())
				.set(ROOM_DAO.AIR_CONDITIONING, room.getAirConditioning())
				.set(ROOM_DAO.LAUNDRY, room.getLaundry())
				.set(ROOM_DAO.SHOEMAKER, room.getShoemaker())
				.set(ROOM_DAO.CATERING, room.getCatering())
				.set(ROOM_DAO.WIFI, room.getWifi())
				.set(ROOM_DAO.GIGABIT_ETHERNET, room.getGigabitEthernet())
				.set(ROOM_DAO.PRIVATE_BALCONY, room.getPrivateBalcony());
		room.setId(roomRecord.component1());
		return room;
	}
	
	public Room readRoom(ULong id) 
			throws DataAccessException {
		Record record = dslContext.select()
				.from(ROOM_DAO)
				.where(ROOM_DAO.ID.eq(id))
				.fetchOne();
		if (record != null) {
			return this.getEntity(record);
		}
		return null;
	}
	
	public List<Room> readAllRooms() 
			throws DataAccessException {
		List<Room> rooms = new ArrayList<Room>();
		Result<Record> records = dslContext
				.select()
				.from(ROOM_DAO)
				.fetch();
		for (Record record : records) {
			rooms.add(this.getEntity(record));
		}
		return rooms;
	}
	
	public void updateRoom(ULong id, Room room) 
			throws DataAccessException {
		dslContext.update(ROOM_DAO)
				.set(ROOM_DAO.BEDS, room.getBeds())
				.set(ROOM_DAO.BASE_PRICE, room.getBasePrice())
				.set(ROOM_DAO.BATHROOM, room.getBathroom())
				.set(ROOM_DAO.FRIGOBAR, room.getFrigobar())
				.set(ROOM_DAO.COOLING_FAN, room.getCoolingFan())
				.set(ROOM_DAO.AIR_CONDITIONING, room.getAirConditioning())
				.set(ROOM_DAO.LAUNDRY, room.getLaundry())
				.set(ROOM_DAO.SHOEMAKER, room.getShoemaker())
				.set(ROOM_DAO.CATERING, room.getCatering())
				.set(ROOM_DAO.WIFI, room.getWifi())
				.set(ROOM_DAO.GIGABIT_ETHERNET, room.getGigabitEthernet())
				.set(ROOM_DAO.PRIVATE_BALCONY, room.getPrivateBalcony())
				.where(ROOM_DAO.ID.equal(id))
				.execute();
	}
	
	public void deleteRoom(ULong id) 
			throws DataAccessException {
		dslContext.deleteFrom(ROOM_DAO)
				.where(ROOM_DAO.ID.equal(id))
				.execute();
	}
	
	private Room getEntity(Record record) 
			throws DataAccessException {
		ULong id = record.getValue(ROOM_DAO.ID, ULong.class);
		Integer beds = record.getValue(ROOM_DAO.BEDS, Integer.class);
		Double basePrice = record.getValue(ROOM_DAO.BASE_PRICE, Double.class);
		Double bathroom = record.getValue(ROOM_DAO.BATHROOM, Double.class);
		Double frigobar = record.getValue(ROOM_DAO.FRIGOBAR, Double.class);
		Double coolingFan = record.getValue(ROOM_DAO.COOLING_FAN, Double.class);
		Double airConditioning = record.getValue(ROOM_DAO.AIR_CONDITIONING, Double.class);
		Double laundry = record.getValue(ROOM_DAO.LAUNDRY, Double.class);
		Double shoemaker = record.getValue(ROOM_DAO.SHOEMAKER, Double.class);
		Double catering = record.getValue(ROOM_DAO.CATERING, Double.class);
		Double wifi = record.getValue(ROOM_DAO.WIFI, Double.class);
		Double gigabitEthernet = record.getValue(ROOM_DAO.GIGABIT_ETHERNET, Double.class);
		Double privateBalcony = record.getValue(ROOM_DAO.PRIVATE_BALCONY, Double.class);
		return new Room(
				id, 
				beds, 
				basePrice, 
				bathroom, 
				frigobar, 
				coolingFan, 
				airConditioning, 
				laundry, 
				shoemaker, 
				catering, 
				wifi, 
				gigabitEthernet, 
				privateBalcony);		
	}
}
